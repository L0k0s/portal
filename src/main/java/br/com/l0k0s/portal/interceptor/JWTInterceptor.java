package br.com.l0k0s.portal.interceptor;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWTVerifyException;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.controller.CORSController;
import br.com.l0k0s.portal.controller.IndexController;
import br.com.l0k0s.portal.controller.LoginController;
import br.com.l0k0s.portal.dto.UsuarioDTO;
import br.com.l0k0s.portal.interfaces.annotation.Adm;
import br.com.l0k0s.portal.model.UsuarioLogado;
import br.com.l0k0s.portal.ultils.JWTToken;

@Intercepts
@RequestScoped
public class JWTInterceptor {

	private HttpServletRequest request;
	private Result result;	

	public JWTInterceptor() {
		this(null, null);
	}

	@Inject
	public JWTInterceptor(HttpServletRequest request, Result result) {
		this.request = request;
		this.result = result;
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack, ControllerMethod method) {

		String token = request.getHeader("authorization");

		Map<String, Object> claims;

		try {

			claims = JWTToken.decode(token);
			int userId = 0;
			String setorNome = null;
			String userNome = null;
			
			for (Map.Entry<String, Object> entry : claims.entrySet()) {			
				if (entry.getKey().equals("user")) {
					Object map = entry.getValue();
					@SuppressWarnings("unchecked")
					Map<String, Object> claims2 = (Map<String, Object>) map;
					for (Map.Entry<String, Object> entry2 : claims2.entrySet()) {
						if (entry2.getKey().equals("usuarioId")) {
							userId = (int) entry2.getValue();
						} else if (entry2.getKey().equals("usuarioNome")){
							userNome = entry2.getValue().toString();							
						}else{
							setorNome = entry2.getValue().toString();
						}
					}
				}
			}
			
			UsuarioDTO usuarioDTO = new UsuarioDTO(userId, userNome ,setorNome);			
			UsuarioLogado.usuarioDTO = usuarioDTO;
			if (ehAutorizado(method)) {
				result.use(Results.http()).addHeader("Authorization", token);
				stack.next();
			} else {
				result.use(Results.http()).setStatusCode(401);
				result.use(Results.json()).from("This user does not exist", "msg").serialize();							}
		} catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException
				| IOException | JWTVerifyException e) {
			result.use(Results.http()).setStatusCode(401);
			result.use(Results.json()).from(e.getMessage(), "msg").serialize();
		}
	}

	@Accepts
	public boolean ehRestrito(ControllerMethod method) {
		boolean verifica = true;
		if (method.getController().getType().equals(IndexController.class)
				|| method.getController().getType().equals(LoginController.class)
				|| method.getController().getType().equals(CORSController.class)) {
			verifica = false;
		}
		return verifica;
	}
	
	
	public boolean ehAutorizado(ControllerMethod method){
		boolean verifica = false;
		if(!method.getController().getType().isAnnotationPresent(Adm.class) || method.containsAnnotation(Get.class)){
			verifica = true;
		}else if (UsuarioLogado.usuarioDTO.getSetorId().equals("Engenharia")) {
			verifica = true;		
		}		
		return verifica;
	}
}

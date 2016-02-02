package br.com.l0k0s.portal.controller;
import java.util.Set;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Options;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.HttpMethod;
import br.com.caelum.vraptor.events.VRaptorRequestStarted;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.view.Results;
 
@Controller
public class CORSController {
 
	@Inject private Result result;
	@Inject private Router router;
 
	@Options("/*")
	public void options(@Observes VRaptorRequestStarted requestInfo) {
		Set<HttpMethod> allowed = router.allowedMethodsFor(requestInfo.getRequest().getRequestedUri());
		String allowMethods = allowed.toString().replaceAll("\\[|\\]", "");

		result.use(Results.status()).header("Allow", allowMethods);		
		result.use(Results.status()).header("Access-Control-Allow-Methods", allowMethods);
		result.use(Results.status()).header("Access-Control-Allow-Headers", "Content-Type, accept, Authorization, origin");
		result.use(Results.status()).noContent();
	}
}
package by.com.lifetecj.chain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ukr.astelit.idr.rtn.ws.api.chain.ChainRequest;
import ukr.astelit.idr.rtn.ws.api.chain.ChainResult;
import ukr.astelit.idr.rtn.ws.api.chain.InputParameter;

@RestController
public class ChainController {
	
	public ChainController(ChainService chainService) {
		super();
		this.chainService = chainService;
	}


	Logger logger = LoggerFactory.getLogger(ChainController.class);
	private final ChainService chainService;
			
	@GetMapping("/test")
	String getTest() {
		
		return testChain();
	}
	
	@GetMapping("/hello")
	String getTest2() {
		
		return "Hello!";
	}
	
	
	public String testChain() {
		
		/*
		ChainAPI_Service service = new ukr.astelit.idr.rtn.ws.api.chain.ChainAPI_Service();
		
		ChainAPI port = service.getChainAPIPort();
		BindingProvider binding = (BindingProvider) port;
		
        // Add HTTP Basic Authentification credentials to this request      
        binding.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "IDR");   
        binding.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "P@ssw0rd");
		*/
		InputParameter inputParameter1 = new InputParameter();
		inputParameter1.setName("account_id");
		inputParameter1.setValue("20699");
		
		List<InputParameter> inputParameters = new ArrayList<InputParameter>();
		inputParameters.add(inputParameter1);
		
		ChainRequest chainRequest = new ChainRequest();
		chainRequest.setChainName("migration_unlims_2022");
		chainRequest.getInputParameters().addAll(inputParameters);		
		
		ChainResult chainResult = chainService.callChain(chainRequest);
		
        String resultCode = chainResult.getResultCode().value();
        String transactionId = chainResult.getTransactionId().toString();
		
		return resultCode;
	}

}

package by.com.lifetecj.chain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ukr.astelit.idr.rtn.ws.api.chain.ChainAPI;
import ukr.astelit.idr.rtn.ws.api.chain.ChainAPI_Service;
import ukr.astelit.idr.rtn.ws.api.chain.ChainRequest;
import ukr.astelit.idr.rtn.ws.api.chain.ChainResult;
import ukr.astelit.idr.rtn.ws.api.chain.ExecuteChain;
import ukr.astelit.idr.rtn.ws.api.chain.ExecuteChainResponse;
import ukr.astelit.idr.rtn.ws.api.chain.InputParameter;
import ukr.astelit.idr.rtn.ws.api.chain.ObjectFactory;
import ukr.astelit.idr.rtn.ws.api.chain.ResultCodeType;

@RestController
//@RequestMapping(value = "/")
public class ChainController {
	
	Logger logger = LoggerFactory.getLogger(ChainController.class);
	
			
	@GetMapping("/test")
	String getTest() {
		
		return testChain();
	}
	
	@GetMapping("/hello")
	String getTest2() {
		
		return "Hello!";
	}
	
	
	public String testChain() {
		
		ChainAPI_Service service = new ukr.astelit.idr.rtn.ws.api.chain.ChainAPI_Service();
		
		ChainAPI port = service.getChainAPIPort();
		BindingProvider binding = (BindingProvider) port;
		
        // Add HTTP Basic Authentification credentials to this request      
        binding.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "IDR");   
        binding.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "P@ssw0rd");
		
		InputParameter inputParameter1 = new InputParameter();
		inputParameter1.setName("account_id");
		inputParameter1.setValue("20699");
		
		List<InputParameter> inputParameters = new ArrayList<InputParameter>();
		inputParameters.add(inputParameter1);
		
		ChainRequest chainRequest = new ChainRequest();
		chainRequest.setChainName("migration_unlims_2022");
		chainRequest.getInputParameters().addAll(inputParameters);		
		
		ChainResult chainResult = port.executeChain(chainRequest);
        String resultCode = chainResult.getResultCode().value();
        String transactionId = chainResult.getTransactionId().toString();
		
		return resultCode;
	}

}

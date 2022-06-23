package by.com.lifetecj.chain;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ukr.astelit.idr.rtn.ws.api.chain.ChainAPI;
import ukr.astelit.idr.rtn.ws.api.chain.ChainAPI_Service;
import ukr.astelit.idr.rtn.ws.api.chain.ChainRequest;
import ukr.astelit.idr.rtn.ws.api.chain.ChainResult;

@Service
public class ChainService {
	
	ChainAPI_Service service = new ukr.astelit.idr.rtn.ws.api.chain.ChainAPI_Service();
	Logger logger = LoggerFactory.getLogger(ChainService.class);
	
	@Value("${chain.username}")
	private String chUsername;
	
	@Value("${chain.password}")
	private String chPassword;
	
	public ChainResult callChain(ChainRequest chainRequest) {
		
		ChainAPI port = service.getChainAPIPort();
		BindingProvider binding = (BindingProvider) port;
		
        // Add HTTP Basic Authentification credentials to this request      
        binding.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, chUsername);   
        binding.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, chPassword);
        
        logger.info("Call chain: " + chainRequest.getChainName() + " with: " + chainRequest.getInputParameters());
        
        ChainResult chainResult = port.executeChain(chainRequest);
        
        logger.info("Chain resultCode: " + chainResult.getResultCode().value() + ". TransactionId = " + chainResult.getTransactionId().toString());
        
        return chainResult;
		
	}

}

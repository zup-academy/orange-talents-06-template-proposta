package com.zup.proposta.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zup.proposta.request.PropostaRequest;

@Component
public class ValidacaoCadastroValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
	    return PropostaRequest.class.equals(aClass);
	}

    @Override
    public void validate(Object object, Errors errors) {
    	final PropostaRequest request = (PropostaRequest) object;
    		errors.rejectValue("documento", "Documento inválido");
    }

	
	

}

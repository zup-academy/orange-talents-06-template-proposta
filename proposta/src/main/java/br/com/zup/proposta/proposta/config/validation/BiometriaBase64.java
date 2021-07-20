package br.com.zup.proposta.proposta.config.validation;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.proposta.proposta.dto.BiometriaDTO;

public class BiometriaBase64 implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BiometriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			
		}
		
		BiometriaDTO biometriaDto = (BiometriaDTO) target;
		if(!Base64.isBase64(biometriaDto.getBiometria())) {
			throw new IllegalArgumentException("Formato inválido de biometria");
		}
	}

}

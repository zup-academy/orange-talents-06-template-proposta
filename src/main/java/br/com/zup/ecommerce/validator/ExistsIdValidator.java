package br.com.zup.ecommerce.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<?> classe;
	private String dominio;

	@Override
	public void initialize(ExistsId constraintAnnotation) {
		dominio = constraintAnnotation.fieldName();
		classe = constraintAnnotation.domainClass();
	}

	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where " + dominio + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		return !list.isEmpty();
	}

}

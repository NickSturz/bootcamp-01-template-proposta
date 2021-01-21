package br.com.zup.nicolle.cartaoproposta.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CPFCNPJValidator implements ConstraintValidator<CPFCNPJ, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        if(cpfValidator.isValid(value, context)) {
            return true;
        }

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        if(cnpjValidator.isValid(value, context)) {
            return true;
        }


        return false;
    }


}
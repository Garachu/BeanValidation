package com.meg.customer;

import com.meg.customer.Customer;

import javax.validation.*;
import java.util.Set;

/**
 * Created by meg on 1/22/18.
 */
public class PurchaseOrderService {

    private ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
    private Validator validator = validationFactory.getValidator();
    private Set<ConstraintViolation<Customer>> violations;

    public void createCustomer(Customer customer){
        violations = validator.validate(customer);
        if(violations.size() > 0) throw  new ConstraintViolationException(violations);
    }
}

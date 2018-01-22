package com.meg.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by meg on 1/22/18.
 */
public class Customer {

    @NotNull
    @Size(min = 4, max = 40)
    private String firstName;

    @NotNull
    @Size(min = 4, max = 40)
    private String lastName;

    private String primaryEmail;

    private String recoverlyEmail;

    private String phoneNumber;

    @Past
    private Date dateOfBirth;
}

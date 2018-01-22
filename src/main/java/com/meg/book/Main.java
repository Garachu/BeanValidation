package com.meg.book;

import com.meg.book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Main {

    public static void main(String[] arg) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Book book = new Book("8987666", null, 1.5f, "Best IT scifi book", 247, date("01 / 01 / 2010"));

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        if (violations.size() > 0) {
            for (ConstraintViolation violation : violations) {
                System.out.println(
                        violation.getRootBeanClass().getSimpleName() + "\t"+
                                violation.getPropertyPath() + "\t"+
                                violation.getInvalidValue() + "\t"+
                                violation.getMessage());
            }
        }

    }

    public static Date date(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(strDate);
            return date;
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

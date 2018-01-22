package book;

import com.meg.book.Book;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by meg on 1/22/18.
 */
public class BookTest {
    private static ValidatorFactory vf;
    private static Validator validator;
    private Set<ConstraintViolation<Book>> violations;

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        //vf.close();
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

    @Test
    public void shouldRaiseNoConstraintViolation() {
        Book book = new Book("9781234567890", "H2G2", 12.5f, "Best IT SCIFI book", 247, date("01/01/2010"));
        violations = validator.validate(book);
        assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseViolationCausePriceLow() {
        Book book = new Book("9781234567890", "H2G2", 0.5f, "Best IT SCIFI book", 247, date("01/01/2010"));
        violations = validator.validate(book);
        assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseViolationCauseDateInFuture() {
        Book book = new Book("9781234567890", "H2G2", 0.5f, "Best IT SCIFI book", 247, date("01/01/2025"));
        violations = validator.validate(book);
        assertEquals(0, violations.size());
    }
}

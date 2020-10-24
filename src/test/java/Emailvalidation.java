import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class Emailvalidation {
    private String email;
    private boolean expectedResult;

    public Emailvalidation(String Email, boolean expectedResult) {
        this.email = Email;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc@gmail.com.com", true},
                {"abc+100@gmail.com", true},
                {"abc()*@gmail.com", false},
                {"abc@%*.com", false},
                {"abc@abc@gmail.com", false}
        });
    }

    @Test
    public void givenEmail_whenValidShouldReturn_asPerResult() {
        User userValidation = new User();
        boolean result = userValidation.validEmail(this.email," Enter valid email id");
        Assert.assertEquals(this.expectedResult, result);

    }
}

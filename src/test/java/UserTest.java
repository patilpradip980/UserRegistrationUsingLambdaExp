import org.junit.*;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class UserTest {
    Scanner scanner = new Scanner(System.in);
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void givenFirstName_whenInProperFormat_shouldReturnTrue() throws Exception {
        boolean result = user.FirstNameValidation("Pradip", " ");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenFirstName_whenLengthLessThan3_shouldReturnFalse() throws Exception {
        boolean result = user.FirstNameValidation("Pr", "Name length is less than minimum character");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenNumberCome_shouldReturnFalse() throws Exception {
        boolean result = user.FirstNameValidation("Pr12dp", "Numeric not required in name");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenSpecialSymbolCome_shouldReturnFalse() throws Exception {
        boolean result = user.FirstNameValidation("Pr@dp", "Special character not required in name");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenFirstName_whenNotStartWithUpperCase_shouldReturnFalse() throws Exception {
        boolean result = user.FirstNameValidation("pradip", "Name first letter need uppercase");
        Assert.assertEquals(false, result);
    }
    @Test
    public void givenLastName_whenInProperFormat_shouldReturnTrue() throws Exception {
        boolean result = user.LastNameValidation("Patil", " ");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenLastName_whenLengthLessThan3_shouldReturnFalse() throws Exception {
        boolean result = user.LastNameValidation("Pa", "Name length is less than minimum character");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenNumberCome_shouldReturnFalse() throws Exception {
        boolean result = user.LastNameValidation("Pa123", "Numeric not required in name");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenSpecialSymbolCome_shouldReturnFalse() throws Exception {
        boolean result = user.LastNameValidation("Pa@dip", "Special character not required in name");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_whenNotStartWithUpperCase_shouldReturnFalse() throws Exception {
        boolean result = user.LastNameValidation("patil", "Name first letter need uppercase");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenMobile_whenNotCompleteDigit_shouldReturnFalse() throws Exception {
        boolean result = user.validMobileNumber("966535328","Country code not present");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenMobile_whenAlphabetCome_returnFalse() throws Exception {
        boolean result = user.validMobileNumber("ASD1234592","Alphabet not required in mobile number");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenEmail_whenInGeneralFormatWithCountryCode_shouldReturnTrue() throws Exception  {
        boolean result = user.validMobileNumber("91-9665353284"," ");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenEmail_whenNotCompleteDigit_shouldReturnFalse() throws Exception  {
        boolean result = user.validMobileNumber("91-96653532","Incomplete Digit");
        Assert.assertEquals(false, result);
    }
    @Test
    public void givenPassword_whenMeetAllRules_returnTrue() throws Exception{
        boolean result = user.validPassword("Avika@1994"," ");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_whenMissingMinimumCharacter_returnFalse() throws Exception {
        boolean result = user.validPassword("Avika@1","Minimum 8 character required");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_whenMissingOneUpperLetterAtLeast_returnFalse() throws Exception {
        boolean result = user.validPassword("avika@1994","at least one uppercase required");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_whenMissingOneLowerLetterAtLeast_returnFalse() throws Exception{
        boolean result = user.validPassword("AVIKA@1994","at least one lower case required");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_whenMissingOneSpecialSymbolAtLeast_returnFalse() throws Exception {
        boolean result = user.validPassword("Avika1994","at least one special symbol required");
        Assert.assertEquals(false, result);
    }
}


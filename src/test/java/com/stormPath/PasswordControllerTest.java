package com.stormPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

/**
 * Author sumitk
 * Date   10/6/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PasswordApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class PasswordControllerTest {

    @Value("${local.server.port}")
    private int port;

    Password validPassword;
    Password passwordWithCaps;
    Password shortPassword;
    Password passwordWithNumOnly;

    //@Autowired
    //private PasswordValidatorInterface passwordValidatorInterface;

    @Autowired
    public PasswordValidator passwordValidator;

    RestTemplate template = new TestRestTemplate();

    @Before
    public void setUp() throws Exception {
        validPassword = new Password("1validpas");
        passwordWithCaps = new Password("1inValidPass");
        shortPassword = new Password("shrt");
        passwordWithNumOnly = new Password("12345");
    }


    private String getBaseUrl(){
        return "http://localhost:" + this.port;
    }

    @Test
    public void testValidPassword() throws Exception {
        Response response = passwordValidator.validatePassword(validPassword);
        assertEquals(response.getResponseCode(), passwordValidator.RESPONSE_CODE_SUCCESSFUL);
    }

    @Test
    public void testInvalidPasswordWithCaps() throws Exception {
        Response response = passwordValidator.validatePassword(passwordWithCaps);
        assertEquals(response.getResponseCode(), passwordValidator.RESPONSE_CODE_ERROR_INVALID_CHAR);
    }

    @Test
    public void testInvalidPasswordWithNumbersOnly() throws Exception {
        Response response = passwordValidator.validatePassword(passwordWithNumOnly);
        assertEquals(response.getResponseCode(), passwordValidator.RESPONSE_CODE_ERROR_INVALID_CHAR);
    }

    @Test
    public void testInvalidPasswordLength() throws Exception {
        Response response = passwordValidator.validatePassword(shortPassword);
        assertEquals(response.getResponseCode(), passwordValidator.RESPONSE_CODE_ERROR_INVALID_LENGTH);
    }

    @Test
    public void testIntegrationTest(){
        HttpHeaders headers = template.getForEntity("http://localhost:" + port, String.class).getHeaders();
        assertThat(headers.toString(), containsString("application/json"));
    }
}

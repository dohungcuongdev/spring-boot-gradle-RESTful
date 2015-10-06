package com.stormPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Author sumitk
 * Date   10/5/15
 *
 * http://www.jayway.com/2014/07/04/integration-testing-a-spring-boot-application/
 * https://github.com/mwarman/skeleton-ws-spring-boot/blob/master/src/test/java/com/leanstacks/ws/web/api/GreetingControllerMocksTest.java
 *
 * http://www.javacodegeeks.com/2015/03/integration-testing-on-rest-urls-with-spring-boot.html
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = PasswordApplication.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")   // 4
public class PasswordControllerTest {

    @Value("${local.server.port}")   // 6
    int port;

    Password one;
    Password two;
    Password three;

    @Autowired
    private PasswordValidatorInterface passwordValidatorInterface;

    @Before
    public void setUp() throws Exception {
        one = new Password("1validpass");
        two = new Password("1inValidPass");
        three = new Password("shrt");
    }

    @Test
    public void validatePassword() throws Exception {

        String uri = "/validate";


    }

}

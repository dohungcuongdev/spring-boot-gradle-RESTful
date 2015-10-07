#Password-Validation-Service

This is a Spring-Boot Gradle project for validating a password. 
It is a micro service which provides password validation as a service. 
This project runs on embedded Tomcat and can be easily started up and plugged into any application. 

This application can be run as follows:

```
    # To see the tasks available with this project
    $ gradle tasks 
    
    # To build the project and run the tests
    $ gradle build 
    
    # To run all the tests 
    $ gradle test
    # Test results -  build/reports/tests/index.html
    
    # To run the project
    $ gradle run   
    # This will start the password validation service as http://localhost:9000
    # The port is defined in src/main/resources/application.properties as server.port
    
    # Alternately this project can be run as an executable jar
    $ gradle build
    $ java -jar build/libs/password-validation-0.1.0-SNAPSHOT.jar
    
    # To test the service after starting it
    $ curl -H "Content-Type: application/json" -d '{"password" : "1validpaswd"}' http://localhost:9000/validate
    
    # The service has lots of Production ready endpoints built-in through spring-boot-starter-actuator.
    # These run on port 9001 as configured in src/main/resources/application.properties as management.port
    $ curl http://localhost:9001/health
    $ curl http://localhost:9001/beans
    
    # For more details  - http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready
     
```

I choose Gradle and SpringBoot because its build process is pretty simple and its very easy to build a production quality microservice.

Design decisions:
    - Any single character being repeated also makes the password invalid [Ex. password1 is invalid]
    - Only numbers in the password is invalid [Ex. 12345 is invalid]
    - Any capital chars are invalid [Ex. 1inValid is invalid]

  
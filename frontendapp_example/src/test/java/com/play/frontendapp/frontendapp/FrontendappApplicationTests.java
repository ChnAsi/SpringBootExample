package com.play.frontendapp.frontendapp;

import com.dataservice.usersdb.contractors.ExampleUserContractor;
import com.dataservice.usersdb.contractors.UserContractor;
import com.dataservice.usersdb.model.User;
import com.play.frontendapp.frontendapp.services.FrontendUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FrontendappApplicationTests {

    @Autowired
    FrontendUserService userService;

    // For mocking the API contractor's methods.
    @MockBean
    ExampleUserContractor contractor;

    @Test
    public void contextLoads() {
    }

    @Test
    public void FrontendUserService_ReturnUserOnSuccess() {

        User user = new User();
        user.setName("Dani");
        user.setLastName("Din");
        user.setBirthYear(1523);
        user.setId("1");

        Mockito.when(contractor.addUser(user)).thenReturn(user);

        User resultUser = userService.addUser("Dani", "Din", 1523);
        assertThat(resultUser).isEqualTo(user);

    }

    @Test
    public void FrontendUserService_ReturnNullOnFailure() {

        User user = new User();
        user.setName("Dani");
        user.setLastName("Din");
        user.setBirthYear(1523);
        user.setId("1");

        Mockito.when(contractor.addUser(user)).thenReturn(null);

        User resultUser = userService.addUser("Dani", "Din", 1523);
        assertThat(resultUser).isNull();

    }

}

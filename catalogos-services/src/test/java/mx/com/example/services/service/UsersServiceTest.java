package mx.com.example.services.service;

import mx.com.example.model.UserDO;
import mx.com.example.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UsersServiceTest extends BaseTest {

    @Test
    public void shouldGetOneUser() {

        int age = 4;
        String name = "Javier";
        String lastName = "Rodriguez";

        UserDO testUserDO = new UserDO(name, lastName, age);
        entityManager.persist(testUserDO);

        List<UserDO> result = usersService.getUsers(0, 20, "name", "desc");

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(age, result.get(0).getAge());
        Assert.assertEquals(name, result.get(0).getName());
        Assert.assertEquals(lastName, result.get(0).getLastName());

    }

    @Test
    public void shouldUpdateName() {

        int age = 4;
        String name = "Javier";
        String lastName = "Rodriguez";

        UserDO testUserDO = new UserDO(name, lastName, age);
        UserDO resultTestUserDo = entityManager.persist(testUserDO);

        int age2 = 4;
        String name2 = "Xavier";
        String lastName2 = "Rodriguez";

        UserDO testUserDO2 = new UserDO(name2, lastName2, age2);
        testUserDO2.setId(resultTestUserDo.getId());
        usersService.saveUser(testUserDO2);

        UserDO result = entityManager.find(UserDO.class, resultTestUserDo.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(age2, result.getAge());
        Assert.assertEquals(name2, result.getName());
        Assert.assertEquals(lastName2, result.getLastName());
    }
}

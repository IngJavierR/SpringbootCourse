package mx.com.example.services.service;

import mx.com.example.model.UserDO;
import mx.com.example.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CatalogosServiceTest extends BaseTest {

    @Test
    public void shouldReturnAllUsers() {

        List<UserDO> users = catalogosService.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void shouldReturnEmptyUsers() {

        List<UserDO> usersIni = catalogosService.getAllUsers();
        entityManager.remove(usersIni.stream().findFirst().get());

        List<UserDO> users = catalogosService.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(0, users.size());
    }
}

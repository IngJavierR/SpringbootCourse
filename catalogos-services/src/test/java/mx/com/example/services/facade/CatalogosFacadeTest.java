package mx.com.example.services.facade;

import mx.com.example.commons.to.UserTO;
import mx.com.example.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class CatalogosFacadeTest extends BaseTest {

    @Test
    public void shouldReturnAllUsers() {

        List<UserTO> users = catalogosFacade.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }
}

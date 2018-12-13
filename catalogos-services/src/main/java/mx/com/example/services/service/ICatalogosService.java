package mx.com.example.services.service;

import mx.com.example.commons.to.UserTO;
import mx.com.example.model.UserDO;

import java.util.List;

public interface ICatalogosService {


    List<UserDO> getAllUsers();

    List<UserDO> getPageableUsers(int page, int size, String property, String direction);

    void saveUser(UserDO user);
}

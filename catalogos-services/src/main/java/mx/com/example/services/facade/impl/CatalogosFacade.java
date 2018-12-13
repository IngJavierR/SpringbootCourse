package mx.com.example.services.facade.impl;

import mx.com.example.commons.to.UserTO;
import mx.com.example.model.UserDO;
import mx.com.example.services.facade.ICatalogosFacade;
import mx.com.example.services.service.ICatalogosService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogosFacade implements ICatalogosFacade {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public ICatalogosService catalogosService;

    @Override
    public List<UserTO> getAllUsers() {

        List<UserDO> userList = catalogosService.getAllUsers();
        Type userDOType = new TypeToken<List<UserDO>>() {}.getType();
        return  modelMapper.map(userList, userDOType);
    }

    @Override
    public List<UserTO> getAllPageableUsers(int page, int size, String property, String direction) {
        List<UserDO> usersDO = catalogosService.getPageableUsers(page, size, property, direction);

        return usersDO.stream().map(x -> {
           UserTO userTO = new UserTO();
           userTO.setAge(x.getAge());
           userTO.setLastName(x.getLastName());
           userTO.setName(x.getName());
           userTO.setId(x.getId());
           return userTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserTO user) {
        UserDO userDO = modelMapper.map(user, UserDO.class);
        catalogosService.saveUser(userDO);
    }
}

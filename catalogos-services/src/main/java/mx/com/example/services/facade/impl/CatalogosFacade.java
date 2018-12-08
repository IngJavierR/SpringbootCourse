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
}

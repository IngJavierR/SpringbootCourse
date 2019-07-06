package mx.com.example.services.facade.impl;

import mx.com.example.commons.to.UserTO;
import mx.com.example.model.UserDO;
import mx.com.example.services.facade.IUserFacade;
import mx.com.example.services.service.IUsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class UserFacadeImpl implements IUserFacade {

    @Autowired
    IUsersService usersService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveUser(UserTO userTO) {
        save(userTO);
    }

    @Override
    public List<UserTO> getUsers(int page, int size, String property, String direction) {

        List<UserDO> userDOList = usersService.getUsers(page, size, property, direction);

        Type userDOType = new TypeToken<List<UserDO>>(){}.getType();
        return modelMapper.map(userDOList, userDOType);
    }

    @Override
    public void deleteUser(Long id) {
        usersService.deleteUser(id);
    }

    @Override
    public void updateUser(UserTO userTO) {

        if(!usersService.validateIfExist(userTO.getId())){
            throw new IllegalArgumentException("Id no existe");
        }
        save(userTO);
    }

    private void save(UserTO userTO) {
        UserDO userDO = modelMapper.map(userTO, UserDO.class);
        usersService.saveUser(userDO);
    }


}

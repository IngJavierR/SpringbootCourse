package mx.com.example.services.service.impl;

import mx.com.example.model.UserDO;
import mx.com.example.persistence.UserDAO;
import mx.com.example.services.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUsersService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void saveUser(UserDO user) {
        userDAO.save(user);
    }

    @Override
    public List<UserDO> getUsers(int page, int size, String property, String direction) {

        Sort sort =
        new Sort(direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, property);
        return userDAO.findAll(PageRequest.of(page, size, sort)).getContent();
    }

    @Override
    public boolean validateIfExist(Long id) {
        return userDAO.existsById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}

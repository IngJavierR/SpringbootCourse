package mx.com.example.services.service.impl;

import mx.com.example.model.UserDO;
import mx.com.example.persistence.UserDAO;
import mx.com.example.services.service.ICatalogosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogosServiceImpl implements ICatalogosService {

    static final Logger LOG = LogManager.getLogger(CatalogosServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDO> getAllUsers() {
        return (List<UserDO>) userDAO.findAll();
    }

    @Override
    public List<UserDO> getPageableUsers(int page, int size, String property, String direction) {
        Sort sort = new Sort(direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, property);
        return userDAO.findAll(PageRequest.of(page, size, sort)).getContent();
    }

    @Override
    public void saveUser(UserDO user) {
        userDAO.save(user);
    }
}

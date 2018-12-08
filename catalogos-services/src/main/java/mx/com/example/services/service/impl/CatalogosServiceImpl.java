package mx.com.example.services.service.impl;

import mx.com.example.model.UserDO;
import mx.com.example.persistence.UserDAO;
import mx.com.example.services.service.ICatalogosService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}

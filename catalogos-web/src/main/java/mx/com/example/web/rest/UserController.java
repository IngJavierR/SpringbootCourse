package mx.com.example.web.rest;

import io.swagger.annotations.Api;
import mx.com.example.commons.to.UserTO;
import mx.com.example.services.facade.IUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("admin")
@Api(value = "admin", description = "Administracion de usuarios")
public class UserController {

    @Autowired
    IUserFacade userFacade;

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody UserTO userTO){
        userFacade.saveUser(userTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUser(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                  @RequestParam(value = "size", defaultValue = "10", required = false) int size,
                                  @RequestParam(value = "property", defaultValue = "name", required = false) String property,
                                  @RequestParam(value = "direcction", defaultValue = "asc", required = false) String direcction) {

        List<UserTO> userTOList = userFacade.getUsers(page, size, property, direcction);
        return new ResponseEntity(userTOList ,HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable("id") long id) {
        userFacade.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO userTO){
        userFacade.updateUser(userTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}

package mx.com.example.web.rest;

import io.swagger.annotations.Api;
import mx.com.example.commons.to.DogTO;
import mx.com.example.commons.to.UserTO;
import mx.com.example.services.facade.ICatalogosFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("catalogos")
@Api(value="catalogos", description="Operaciones con catalogos")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    public ICatalogosFacade catalogosFacade;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsers(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                   @RequestParam(value = "size", defaultValue = "10", required = false) int size,
                                   @RequestParam(value = "property", required = false) String property,
                                   @RequestParam(value = "direction", required = false) String direction) {

        property = Optional.ofNullable(property).orElse("id");
        direction = Optional.ofNullable(direction).orElse("asc");

        List<UserTO> users = catalogosFacade.getAllPageableUsers(page, size, property, direction);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/dog/{raza}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getDogs(@PathVariable("raza") String raza) {
        LOG.info(raza);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/dog", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getDog(@RequestParam("id") long id) {
        LOG.info("Llego un {}", id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/dog", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveDog(@RequestBody DogTO dog) {
        LOG.info("Llego un {} - {} - {}", dog.getId(), dog.getName(), dog.getRaza());
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody UserTO user)
    {
        catalogosFacade.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }
}

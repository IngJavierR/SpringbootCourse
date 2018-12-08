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
    public ResponseEntity getUsers(@RequestParam("page") int page,
                                   @RequestParam("size") int size) {
        List<UserTO> users = catalogosFacade.getAllPageableUsers(page, size);
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


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }
}

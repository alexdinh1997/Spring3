package fi.vamk.e1800935.spring3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/* Controller creates the Restful API. The class must have @RestController 
   annotation to be automatically found. Also each method should have 
    @RequextMapping annotation. Not that same path (like /test) can be used
    only once in one project (with the same method).*/
@RestController
public class PartnerController {
    @Autowired
    private PartnerRepository repository;

    @RequestMapping(value = "/partner", method = RequestMethod.POST)
    public @ResponseBody Partner create(@RequestBody Partner item) {
        return repository.save(item);
    }

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "{\"id\":\"hello\"}";
    }
    //import org.springframework.http.MediaTyppe
    //produces = {MediaTyppe.APPLICATION_JSON_VALUE,MediaTyppe.APPLICATION_XML_VALUE},
    @RequestMapping(value="/partners",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                    method= RequestMethod.GET)
    public Iterable<Partner> partners(@RequestParam(value = "name", defaultValue = "World") String name) {
        return repository.findAll();
    }

    @RequestMapping(value = "/partner/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                    method= RequestMethod.GET)
    public Optional<Partner> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }  



}
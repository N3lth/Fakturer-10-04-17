package eu.programisci.Test.animal.api;

import eu.programisci.Test.animal.dto.AnimalDTO;
import eu.programisci.Test.animal.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/animals")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
// origins ???
public class AnimalRestController {

    @Autowired
    private IAnimalService animalService; // zaznaczasz jedno, shift f6 i zamieniasz wszystkie, ktora nazywaja sie tak samo

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AnimalDTO findOne(@RequestParam("id") Long aId) {
        return animalService.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AnimalDTO> findAll() {
        return animalService.findAllForTable();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        animalService.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AnimalDTO save(@RequestBody AnimalDTO animalDTO) {
        return animalService.save(animalDTO);
    }
}

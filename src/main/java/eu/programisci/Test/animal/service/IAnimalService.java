package eu.programisci.Test.animal.service;

import eu.programisci.Test.animal.dto.AnimalDTO;

import java.util.List;

public interface IAnimalService {

    AnimalDTO findOne(Long id);

    List<AnimalDTO> findAllForTable();

    void deleteOne(Long id);

    AnimalDTO save(AnimalDTO animalDTO);
}

package eu.programisci.Test.animal.service;

import eu.programisci.Test.animal.converters.AnimalConverter;
import eu.programisci.Test.animal.dto.AnimalDTO;
import eu.programisci.Test.animal.ob.AnimalOB;
import eu.programisci.Test.animal.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnimalServiceImpl implements IAnimalService{

    // ALT INSERT - Implement Methods
    @Autowired
    private IAnimalRepository animalRepository;

    @Autowired
    private AnimalConverter animalConverter;

    @Override
    public AnimalDTO findOne(Long id) {
        AnimalOB ob = animalRepository.findOne(id);
        AnimalDTO dto = animalConverter.obToDTO(ob);
        return dto;
    }

    @Override
    public void deleteOne(Long id) {
        animalRepository.delete(id);
    }

    @Override
    public AnimalDTO save(AnimalDTO animalDTO){
        if (animalDTO.getId() == null ){
            return animalConverter.obToDTO(create(animalDTO));
        }else{
            return animalConverter.obToDTO(update(animalDTO));
        }
    }

    @Override
    public List<AnimalDTO> findAllForTable() {
        List<AnimalOB> obList = animalRepository.findAll();
        List<AnimalDTO> dtoList = animalConverter.animalObToAnimalForTable(obList);
        return dtoList;
    }

    private AnimalOB create(AnimalDTO dto) {
        AnimalOB ob = animalConverter.DTOToOb(dto);
//        ob.setCreationDate(new Date());
        ob = animalRepository.save(ob);
        return ob;
    }

    private AnimalOB update(AnimalDTO dto) {
        AnimalOB ob = animalRepository.findOne(dto.getId());
        ob.setGatunek(dto.getGatunek());
        ob.setRasa(dto.getRasa());
        ob.setImie(dto.getImie());
        ob.setWiek(dto.getWiek());
        ob.setKolor(dto.getKolor());
        ob.setUwagi(dto.getUwagi());
        ob = animalRepository.save(ob);
        return ob;
    }
}

package eu.programisci.Test.animal.converters;

import eu.programisci.Test.animal.dto.AnimalDTO;
import eu.programisci.Test.animal.ob.AnimalOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalConverter {

    public AnimalDTO obToDTO(AnimalOB in){
        AnimalDTO out = new AnimalDTO();
        out.setId(in.getId());
        out.setGatunek(in.getGatunek());
        out.setRasa(in.getRasa());
        out.setImie(in.getImie());
        out.setKolor(in.getKolor());
        out.setUwagi(in.getUwagi());
        out.setWiek(in.getWiek());
        return out;
    }

    public AnimalOB DTOToOb(AnimalDTO in){
        AnimalOB out = new AnimalOB();
        out.setId(in.getId());
        out.setGatunek(in.getGatunek());
        out.setRasa(in.getRasa());
        out.setImie(in.getImie());
        out.setKolor(in.getKolor());
        out.setUwagi(in.getUwagi());
        out.setWiek(in.getWiek());
        return out;
    }

    public List<AnimalDTO> animalObToAnimalForTable(List<AnimalOB> inList) {
        if (inList == null) {
            return null;
        }
        List<AnimalDTO> outList = new ArrayList<>();
        for (AnimalOB in : inList) {
            outList.add(obToDTO(in));
        }
        return outList;
    }
}

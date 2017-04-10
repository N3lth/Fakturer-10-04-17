package eu.programisci.Test.animal.repository;

import eu.programisci.Test.animal.ob.AnimalOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mateu on 2017-04-04.
 */
@Repository
public interface IAnimalRepository extends JpaRepository<AnimalOB, Long>{
}

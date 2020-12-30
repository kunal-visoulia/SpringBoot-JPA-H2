package in.kvisoulia.bootJpa.dao;

import in.kvisoulia.bootJpa.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// <className, data type of primaryKey>
public interface AlienRepo extends CrudRepository<Alien, Integer> {
//no need to define simple crud method as crudrepo interface have them all

    List<Alien> findByTech(String tech);
    //findBy/getBy + propertyName; definition will be handled by springboot

    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String tech);

}

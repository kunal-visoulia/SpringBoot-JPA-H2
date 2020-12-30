package in.kvisoulia.bootJpa.dao;

import in.kvisoulia.bootJpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}

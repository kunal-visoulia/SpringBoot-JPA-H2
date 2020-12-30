package in.kvisoulia.bootJpa.controller;

import in.kvisoulia.bootJpa.dao.AlienRepo;
import in.kvisoulia.bootJpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable("aid") int aid){
        Alien a = repo.getOne(aid);//make sure data is present
        repo.delete(a);
        return "deleted";

    }

    @PostMapping("/alien")//same url as third func but using PostMapping
    public Alien addAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;//add alien and return the same data
    }
    @PutMapping("/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;//add alien and return the same data
    }
    @GetMapping("/aliens")
    public List<Alien> getAliens(){
    return repo.findAll();

    }
    @GetMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){

        return repo.findById(aid);
    }

}

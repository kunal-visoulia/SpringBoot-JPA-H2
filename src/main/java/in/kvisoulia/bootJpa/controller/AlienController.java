package in.kvisoulia.bootJpa.controller;

import in.kvisoulia.bootJpa.dao.AlienRepo;
import in.kvisoulia.bootJpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        //or make it optional with java 8
        mv.addObject(alien);
      System.out.println(repo.findByTech("JAVA"));
        System.out.println(repo.findByAidGreaterThan(3));
        System.out.println(repo.findByTechSorted("JAVA"));
        return mv;

    }

}

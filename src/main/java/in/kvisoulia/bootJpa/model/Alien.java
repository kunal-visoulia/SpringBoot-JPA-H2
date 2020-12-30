package in.kvisoulia.bootJpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;

    @Override
    public String toString() {
        return "Alien with aid= "+this.aid+"name= "+this.aname+"tech= "+this.tech;
    }
}

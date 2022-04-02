package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "Masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private LocalDate birthday;
    @Column(name = "cats")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="MasterId")
    private ArrayList<Kotik> mastersCats;

    public Master(){}

    public Master(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
        mastersCats = new ArrayList<>();
    }

    public void addCat(Kotik cat){
        mastersCats.add(cat);
        cat.addMaster(this);
    }

    public void removeCat(Kotik cat){
        mastersCats.remove(cat);
        cat.removeMaster(this);
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public ArrayList getMastersCats(){
        return mastersCats;
    }
}

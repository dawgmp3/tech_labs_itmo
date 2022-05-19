import com.example.lab3.entity.Kotik;
import com.example.lab3.entity.Master;
import com.example.lab3.enumClasses.Breed;
import com.example.lab3.enumClasses.Color;
import com.example.lab3.repos.MasterRepos;
import com.example.lab3.services.MasterService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lab3Tests {
    @Mock
    public MasterRepos masterDao;
    public MasterService masterService;


    public void init(){
        MockitoAnnotations.initMocks(this);
        this.masterService = new MasterService(masterDao);
    }

    @Test
    public void master_Has_Cat(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Master master = new Master("Marina", LocalDate.parse("10.08.2002", formatter));
        Kotik cat = new Kotik("Manunya", LocalDate.parse("10.08.2015", formatter),
                Breed.Abyssinian, Color.Black, master);
        master.addCat(cat);
        Assert.isTrue(master.getMastersCats().contains(cat), "ok");
    }
}

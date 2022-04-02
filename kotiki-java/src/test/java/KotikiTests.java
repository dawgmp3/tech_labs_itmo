import dao.DaoMaster;
import entity.Kotik;
import entity.Master;
import enumClasses.Breed;
import enumClasses.Color;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.MasterService;
import java.time.LocalDate;

public class KotikiTests {
    @Mock
    public DaoMaster masterDao;
    public MasterService masterService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.masterService = new MasterService(masterDao);
    }

    @Test
    public void master_Has_Cat(){
        Master master = new Master("Marina", LocalDate.of(2002, 8, 10));
        Kotik cat = new Kotik("Manunya", LocalDate.of(2008, 9, 21),
                Breed.Abyssinian, Color.Black, master);
        master.addCat(cat);
        Boolean catt = master.getMastersCats().contains(cat);
        Assert.assertEquals(true, catt);
    }
}



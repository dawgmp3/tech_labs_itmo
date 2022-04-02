package service;

import dao.DaoKotik;
import dao.DaoMaster;
import entity.Kotik;
import entity.Master;
import java.util.List;
import java.util.UUID;

public class MasterService {
    private DaoMaster masterDao = new DaoMaster();

    public MasterService(DaoMaster daoMaster) {
        this.masterDao = daoMaster;
    }

    public Master findMaster(int id) {
        return masterDao.findById(id);
    }

    public void saveMaster(Master master) {
        masterDao.save(master);
    }

    public void deleteMaster(Master master) {
        masterDao.delete(master);
    }

    public void updateMaster(Master master) {
        masterDao.update(master);
    }

    public List<Master> findAllMasters() {
        return masterDao.findAll();
    }

    public Kotik findKotikById(UUID id) {
        return masterDao.findKotikById(id);
    }

}

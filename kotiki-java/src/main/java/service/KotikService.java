package service;

import dao.DaoKotik;
import entity.Kotik;
import entity.Master;

import java.util.UUID;

public class KotikService {
    private DaoKotik kotikDao;

    public KotikService(DaoKotik kotikDao) {
        this.kotikDao = kotikDao;
    }

    public Kotik findKotik(UUID id) {
        return kotikDao.findById(id);
    }

    public void saveKotik(Kotik kotik) {
        kotikDao.save(kotik);
    }

    public void deleteKotik(Kotik kotik) {
        kotikDao.delete(kotik);
    }

    public void updateKotik(Kotik kotik) {
        kotikDao.update(kotik);
    }
    public void findMasterById(UUID id) { kotikDao.findMasterById(id); }
}

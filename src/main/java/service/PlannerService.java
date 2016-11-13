package service;

import dao.PlannerDao;
import entity.Planner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Marisha on 05/11/16.
 */


@Service
public class PlannerService {

    @Autowired private PlannerDao dao;

    @Transactional
    public void createOrUpdate(Planner planner){
        dao.merge(planner);
    }

    @Transactional
    public void delete(Long id){
        dao.delete(id);
    }

    @Transactional
    public void updateStatus(Long id) {
        dao.updateStatus(id);
    }


    public List<Planner> find(Boolean bool){
        return dao.find(bool);
    }
}

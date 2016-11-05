import config.RootConfig;
import dao.PlannerDao;
import entity.Planner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Marisha on 30/10/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TestRepository {

    @Autowired
    private PlannerDao dao;

    @Test
    public void testFindAll() {
        List<Planner> list = dao.find(null);
        list.forEach(e ->
                System.out.println(e.getId() + ";" + e.getItem() + ";" + e.isStatus())
        );
        assert (list.size() != 0);
    }

    @Test
    public void testUnDone() {
        List<Planner> l = dao.find(false);
        l.forEach(e ->
                System.out.println(e.getId() + ";" + e.getItem() + ";" + e.isStatus())
        );
        assert (l.size() != 0);
    }

    @Test
    public void testDone() {
        List<Planner> l = dao.find(true);
        l.forEach(e ->
                System.out.println(e.getId() + ";" + e.getItem() + ";" + e.isStatus())
        );
        assert (l.size() != 0);
    }

    @Test
    public void testSave(){
        Planner planner = new Planner();
        planner.setItem("test action");
        planner.setStatus(false);
        dao.save(planner);

    }

    @Test
    public void testUpdate() {
        Planner planner = new Planner();
        planner.setId(7L);
        planner.setItem("test action2");
        planner.setStatus(false);
        dao.update(planner);
    }
}

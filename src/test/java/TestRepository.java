import config.RootConfig;
import entity.Planner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.PlannerService;

import java.util.List;

/**
 * Created by Marisha on 30/10/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TestRepository {

    @Autowired
    private PlannerService service;

    @Test
    public void testFindAll() {
        List<Planner> list = service.find(null);
        list.forEach(e ->
                System.out.println(e.getId() + ";" + e.getItem() + ";" + e.isStatus())
        );
        assert (list.size() != 0);
    }

    @Test
    public void testUnDone() {
        List<Planner> l = service.find(false);
        l.forEach(e ->
                System.out.println(e.getId() + ";" + e.getItem() + ";" + e.isStatus())
        );
        assert (l.size() != 0);
    }

    @Test
    public void testDone() {
        List<Planner> l = service.find(true);
        l.forEach(e ->
                System.out.println(e.getId() + ";" + e.getItem() + ";" + e.isStatus())
        );
        assert (l.size() != 0);
    }

    @Test
    public void testMerge() {
        Planner planner = new Planner();
        //planner.setId(10L);\
        planner.setItem("new");
        planner.setStatus(true);
        service.createOrUpdate(planner);
    }

    @Test
    public void testDelete(){
        service.delete(8L);
    }
}

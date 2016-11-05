import config.RootConfig;
import dao.TodolistDAO;
import entity.Todolist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
    private TodolistDAO dao;

    @Test
    public void testFindAll() {
        List<Todolist> list = dao.find(null);
        for (Todolist e : list) {
            System.out.println(e.getId() + ";" + e.getTodo() + ";" + e.isDone());
        }
        assert (list.size() != 0);
    }

    @Test
    public void testUnDone() {
        List<Todolist> list = dao.find(false);
        for (Todolist e : list) {
            System.out.println(e.getId() + ";" + e.getTodo() + ";" + e.isDone());
        }
        assert (list.size() != 0);
    }

    @Test
    public void testDone() {
        List<Todolist> list = dao.find(true);
        for (Todolist e : list) {
            System.out.println(e.getId() + ";" + e.getTodo() + ";" + e.isDone());
        }
        assert (list.size() != 0);
    }

    @Test
    public void testSave(){
        Todolist todolist = new Todolist();
        todolist.setTodo("test action");
        todolist.setDone(true);
        dao.save(todolist);

    }
}

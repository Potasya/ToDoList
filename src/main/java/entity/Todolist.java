package entity;

import entity.converters.BooleanToIntegerConverter;

import javax.persistence.*;

/**
 * Created by Marisha on 30/10/16.
 */

@Entity
public class Todolist {

    public Todolist(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "todo")
    private String todo;

    @Column(name = "done")
    @Convert(converter=BooleanToIntegerConverter.class)
    private boolean done;

    public Todolist(Long id, String todo, boolean done){
        this.id = id;
        this.todo = todo;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}

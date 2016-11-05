package entity;

import entity.converters.BooleanToIntegerConverter;

import javax.persistence.*;

/**
 * Created by Marisha on 30/10/16.
 */

@Entity(name = "TODOLIST")
public class Planner {

    public Planner(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TODO")
    private String item;

    @Column(name = "DONE")
    @Convert(converter=BooleanToIntegerConverter.class)
    private boolean status;

    public Planner(Long id, String todo, boolean done){
        this.id = id;
        this.item = todo;
        this.status = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

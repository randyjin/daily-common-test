package org.trlove.collection;

/**
 * Created by aguda on 16/6/8.
 */
public class Location {
    private Long id;
    private String name;

    public Location(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

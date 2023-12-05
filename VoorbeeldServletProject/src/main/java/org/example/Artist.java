package org.example;

public class Artist {
    private String name;
    private int id;

    public Artist(String name, int id) {
        this.name = name;
        if (id >= 0) {
            this.id = id;
        } else {
            int maxId = Database.getMaxIdFromDatabase();
            if(maxId < 0) {
                return;
            } else {
                this.id = maxId + 1;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}

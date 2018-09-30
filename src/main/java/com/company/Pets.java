package com.company;

public class Pets {
    private int id;
    private String birth;
    private String name;
    private String ownwer;

    public Pets() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnwer() {
        return ownwer;
    }

    public void setOwnwer(String ownwer) {
        this.ownwer = ownwer;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", birth='" + birth + '\'' +
                ", name='" + name + '\'' +
                ", ownwer='" + ownwer + '\'' +
                '}';
    }
}

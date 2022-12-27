package com.example.lab_1_zaimov_andreev.classes;

public class Pair {
    private Long Id;
    private String Info;

    public Pair (long Id, String Info)
    {
        this.Id = Id;
        this.Info = Info;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }
}

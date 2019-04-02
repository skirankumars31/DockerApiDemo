package no.nav.DockerApiDemo.model;

import java.io.Serializable;

public class Person implements Serializable{

    String name;
    String FNR;

    public Person(String name, String FNR) {
        this.name = name;
        this.FNR = FNR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFNR() {
        return FNR;
    }

    public void setFNR(String FNR) {
        this.FNR = FNR;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", FNR='" + this.FNR + '\'' +
                '}';
    }


}

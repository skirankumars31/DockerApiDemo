package no.nav.DockerApiDemo.model;

public class Person {

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
}

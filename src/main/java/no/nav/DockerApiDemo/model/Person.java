package no.nav.DockerApiDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Person implements Serializable{

    String name;
    String FNR;

    /**
     * The json property is specified so that jackson can convert json into a java object
     * @param name
     * @param FNR
     */
    public Person(@JsonProperty("name") String name,@JsonProperty("fnr") String FNR) {
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

package no.nav.DockerApiDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Soknad implements Serializable {

    String name;
    String FNR;

    public Soknad(@JsonProperty("name") String name,@JsonProperty("fnr") String FNR) {
        this.name = name;
        this.FNR = FNR;
    }

    public String getName() {
        return name;
    }

    public String getFNR() {
        return FNR;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFNR(String FNR) {
        this.FNR = FNR;
    }
}

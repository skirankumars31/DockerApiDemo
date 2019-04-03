package no.nav.DockerApiDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Inntekt implements Serializable {

    String FNR;
    Double Lønn;

    public Inntekt(@JsonProperty("fnr") String FNR,@JsonProperty("lønn") Double lønn) {
        this.FNR = FNR;
        Lønn = lønn;
    }

    public String getFNR() {
        return FNR;
    }

    public void setFNR(String FNR) {
        this.FNR = FNR;
    }

    public Double getLønn() {
        return Lønn;
    }

    public void setLønn(Double lønn) {
        Lønn = lønn;
    }
}

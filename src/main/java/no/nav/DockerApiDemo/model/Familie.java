package no.nav.DockerApiDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Familie implements Serializable {

    String FNR;
    int ChildrenCount;

    public Familie(@JsonProperty("fnr") String FNR, @JsonProperty("childrenCount") int childrenCount) {
        this.FNR = FNR;
        ChildrenCount = childrenCount;
    }

    public String getFNR() {
        return FNR;
    }

    public void setFNR(String FNR) {
        this.FNR = FNR;
    }

    public int getChildrenCount() {
        return ChildrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        ChildrenCount = childrenCount;
    }
}

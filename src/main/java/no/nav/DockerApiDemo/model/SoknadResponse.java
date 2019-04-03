package no.nav.DockerApiDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class SoknadResponse implements Serializable {

    String FNR;
    Boolean CaseApproval;
    UUID SoknadID;


    public SoknadResponse(@JsonProperty("fnr") String FNR,@JsonProperty("caseapproval") Boolean caseApproval) {
        this.FNR = FNR;
        CaseApproval = caseApproval;
        SoknadID = new UUID(12,2);
    }

    public String getFNR() {
        return FNR;
    }

    public void setFNR(String FNR) {
        this.FNR = FNR;
    }

    public Boolean getCaseApproval() {
        return CaseApproval;
    }

    public void setCaseApproval(Boolean caseApproval) {
        CaseApproval = caseApproval;
    }

    @Override
    public String toString() {
        return "SoknadResponse{" +
                "FNR='" + FNR + '\'' +
                ", CaseApproval=" + CaseApproval +
                ", SoknadID=" + SoknadID +
                '}';
    }
}

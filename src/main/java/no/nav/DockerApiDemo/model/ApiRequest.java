package no.nav.DockerApiDemo.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ApiRequest implements Serializable {

    @ApiModelProperty( notes = "Person's FNR Address", required = true )
    String FNR;

    public String getFNR() {
        return FNR;
    }

    public void setFNR(String FNR) {
        this.FNR = FNR;
    }
}

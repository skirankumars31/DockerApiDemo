package no.nav.DockerApiDemo.services;

import no.nav.DockerApiDemo.model.Familie;
import no.nav.DockerApiDemo.model.Inntekt;
import org.springframework.stereotype.Service;

@Service
public class FamilieService {


    public Familie getFamilieForhold(String FNR) {
        if (FNR.contains("253"))
        return new Familie(FNR,3);
        else
            return new Familie(FNR,2);
    }

}

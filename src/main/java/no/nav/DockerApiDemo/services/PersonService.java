package no.nav.DockerApiDemo.services;

import no.nav.DockerApiDemo.model.Inntekt;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    RestTemplate restTemplate = new RestTemplate();

    public String sayHello() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8082/rest/docker/api/hello", HttpMethod.GET, entity, String.class).getBody();
    }


    public Inntekt getInntekt(String FNR) {
        if (FNR.contains("253"))
        return new Inntekt(FNR,20000D);
        else
            return new Inntekt(FNR,35000D);

    }

}

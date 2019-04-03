package no.nav.DockerApiDemo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    RestTemplate restTemplate = new RestTemplate();

    public String sayHello(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8082/rest/docker/api/hello", HttpMethod.GET,entity,String.class).getBody();
    }
}

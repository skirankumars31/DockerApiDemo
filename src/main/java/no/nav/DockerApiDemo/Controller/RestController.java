package no.nav.DockerApiDemo.Controller;

import no.nav.DockerApiDemo.model.Inntekt;
import no.nav.DockerApiDemo.services.EmployeeService;
import no.nav.DockerApiDemo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Deprecated
@org.springframework.web.bind.annotation.RestController
public class RestController {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/postTemplate")
    public String sayHello(){
        return employeeService.sayHello();
    }

}

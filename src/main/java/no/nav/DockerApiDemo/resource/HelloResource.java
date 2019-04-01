package no.nav.DockerApiDemo.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.ContentType;
import no.nav.DockerApiDemo.model.Person;
import org.junit.ClassRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/docker/api")
@Api(value="Hello Resource",description="Operations related to Hello World")
public class HelloResource {

    @Value("${spring.message}")
    String message;

    @ApiOperation(value="Says Hello World")
    @GetMapping(value= "/hello", produces = "application/text")
    public String hello(){
        return message;
    }


    /**
     * This api returns a Person Json
     * @return Person
     */
    @ApiOperation(value="Gets a Person")
    @GetMapping(value = "/fetchPerson", produces = "application/json")
    public Person fetchPerson(){
        return new Person("Kiran","12345678910");
    }


    @ApiOperation(value="Says Hello to the Person")
    @PostMapping("/post")
    public String sayHello(@RequestBody String name){
        return "Hello"+name;
    }
}

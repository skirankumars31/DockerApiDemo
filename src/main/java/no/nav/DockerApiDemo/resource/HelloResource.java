package no.nav.DockerApiDemo.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/docker/hello")
@Api(value="Hello Resource",description="Operations related to Hello World")
public class HelloResource {

    @ApiOperation(value="Says Hello World")
    @GetMapping
    public String hello(){
        return "Hello World";
    }


    @ApiOperation(value="Says Hello to the Person")
    @PostMapping("/post")
    public String sayHello(@RequestBody String name){
        return "Hello"+name;
    }
}

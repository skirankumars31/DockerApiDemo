package no.nav.DockerApiDemo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import no.nav.DockerApiDemo.model.Inntekt;
import no.nav.DockerApiDemo.model.ApiRequest;
import no.nav.DockerApiDemo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inntekt")
@Api(value="Inntekt Services",description="Operations pertaining to Inntekt")
public class InntektController {

    @Autowired
    PersonService personService;

    /**
     * Rest API exposed by Inntekt to fetch inntekt of a Person
     * @param InntektRequest
     * @return
     */
    @ApiOperation(value="Gets the inntekt of a Person")
    @PostMapping(value = "/getInntekt",consumes = "application/json")
    public Inntekt getInntekt(@RequestBody ApiRequest apiRequest){
        return personService.getInntekt(apiRequest.getFNR());
    }

}

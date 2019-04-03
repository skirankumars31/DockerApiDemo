package no.nav.DockerApiDemo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import no.nav.DockerApiDemo.model.Familie;
import no.nav.DockerApiDemo.model.Inntekt;
import no.nav.DockerApiDemo.model.ApiRequest;
import no.nav.DockerApiDemo.services.FamilieService;
import no.nav.DockerApiDemo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familie")
@Api(value="Familie API Services", description="Operations pertaining to Familie")
public class FamilieController {

    @Autowired
    FamilieService familieService;

    /**
     * Rest API exposed by Inntekt to fetch inntekt of a Person
     * @param ApiRequest
     * @return
     */
    @ApiOperation(value="Gets the FamilieForhold of a Person")
    @PostMapping(value = "/getFamilieForhold",consumes = "application/json")
    public Familie getFamilieForhold(@RequestBody ApiRequest apiRequest){
        return familieService.getFamilieForhold(apiRequest.getFNR());
    }
}

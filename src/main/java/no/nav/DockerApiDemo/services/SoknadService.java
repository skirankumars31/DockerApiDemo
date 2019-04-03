package no.nav.DockerApiDemo.services;

import no.nav.DockerApiDemo.model.ApiRequest;
import no.nav.DockerApiDemo.model.Familie;
import no.nav.DockerApiDemo.model.Inntekt;
import no.nav.DockerApiDemo.model.SoknadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SoknadService {

    @Value("${inntekt.service.url}")
    String InntektURL;

    @Value("${familieforhold.service.url}")
    String FamilieURL;

    @Autowired
    ReportingService reportingService;

    RestTemplate restTemplate = new RestTemplate();

    public SoknadResponse processSoknad(String FNR){

        SoknadResponse soknadResponse;
        Double Lønn;
        int KidsCount;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ApiRequest inntektRequest = new ApiRequest();
        inntektRequest.setFNR(FNR);
        HttpEntity<ApiRequest> entity = new HttpEntity<>(inntektRequest,headers);
        Lønn = restTemplate.exchange(InntektURL+"/getInntekt", HttpMethod.POST,entity, Inntekt.class).getBody().getLønn();
        KidsCount = restTemplate.exchange(FamilieURL+"/getFamilieForhold", HttpMethod.POST,entity, Familie.class).getBody().getChildrenCount();

        if(Lønn <= 20000 && KidsCount >= 3){
            soknadResponse = new SoknadResponse(FNR,true);
            reportingService.reportSoknad(soknadResponse);
            return soknadResponse;
        }
        else{
            soknadResponse = new SoknadResponse(FNR,false);
            reportingService.reportSoknad(soknadResponse);
            return soknadResponse;
        }
    }
}

package no.nav.DockerApiDemo.services;

import no.nav.DockerApiDemo.model.Familie;
import no.nav.DockerApiDemo.model.Person;
import no.nav.DockerApiDemo.model.SoknadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReportingService {

    @Autowired
    private KafkaTemplate<String,SoknadResponse> kafkareportTemplate;

    @Value("${kafka.topic}")
    String TOPIC;

    public void reportSoknad(SoknadResponse response) {
        kafkareportTemplate.send(TOPIC,response);
    }
}

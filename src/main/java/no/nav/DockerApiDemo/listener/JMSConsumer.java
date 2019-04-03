package no.nav.DockerApiDemo.listener;

import no.nav.DockerApiDemo.model.Person;
import no.nav.DockerApiDemo.model.Soknad;
import no.nav.DockerApiDemo.model.SoknadResponse;
import no.nav.DockerApiDemo.services.SoknadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSConsumer {

    @Autowired
    SoknadService soknadService;

    @JmsListener(destination="${soknad.queue.name}")
    public void sendJMSSoknad(final Soknad message){
        //System.out.println("Received JMS message with name:" + message.getName()+" and fnr:"+message.getFNR());
        SoknadResponse response = soknadService.processSoknad(message.getFNR());
        //System.out.println(response.toString());
    }
}

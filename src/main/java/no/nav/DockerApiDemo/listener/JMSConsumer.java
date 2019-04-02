package no.nav.DockerApiDemo.listener;

import no.nav.DockerApiDemo.model.Person;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSConsumer {

    @JmsListener(destination = "example.queue")
    public void consume(final Person message){
        System.out.println("Received message with name:" + message.getName()+" and fnr:"+message.getFNR());
    }
}

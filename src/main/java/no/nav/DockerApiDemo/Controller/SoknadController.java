package no.nav.DockerApiDemo.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import no.nav.DockerApiDemo.model.Person;
import no.nav.DockerApiDemo.model.Soknad;
import no.nav.DockerApiDemo.model.SoknadResponse;
import no.nav.DockerApiDemo.services.PersonService;
import no.nav.DockerApiDemo.services.SoknadService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soknad")
@Api(value="Soknad",description="Operations pertaining to Ytelser Soknad")
public class SoknadController {

    @Value("${spring.message}")
    String message;

    @Autowired
    private KafkaTemplate<String,Person> kafkaTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    ActiveMQQueue queue;

    @Autowired
    SoknadService soknadService;

    /*@Autowired
    MessageConverter messageConverter;*/

    @Value("${kafka.topic}")
    String TOPIC;

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


    @ApiOperation(value="Send Soknad via Rest API")
    @PostMapping("/sendApiSoknad")
    public SoknadResponse sendApiSoknad(@RequestBody Soknad soknad){
        return soknadService.processSoknad(soknad.getFNR());
    }


    /**
     * Api to publish message to Kafka
     */
    @ApiOperation(value="Publishes message to Kafka Topic")
    @PostMapping("/publish/message")
    public String PublishMessage(@RequestBody String message){
        kafkaTemplate.send(TOPIC,new Person("Kiran","19048618465"));
        return "Published to Kafka Successfully";
    }

    /**
     * Api to publish json message to JMS
     */
    @ApiOperation(value="Publishes message to JMS ActiveMQ")
    @PostMapping("/publish/jms")
    public String PublishJMS(@RequestBody String message){
        //jmsTemplate.setMessageConverter(messageConverter);
        jmsTemplate.convertAndSend(queue,new Soknad("Kiran","19048618465"));
        return "Published to JMS Successfully";
    }

}

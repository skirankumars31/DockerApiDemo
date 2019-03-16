package no.nav.DockerApiDemo;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class DockerApiDemoApplicationTests {

	/*@ClassRule
	public static EmbeddedKafkaRule embeddedKafka =
			new EmbeddedKafkaRule(1, true, "ExampleTopic");*/


	@Test
	public void contextLoads() {
	}

}

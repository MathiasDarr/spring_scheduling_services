package org.mddarr.patientservice;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.mddarr.patientservice.models.Patient;
import org.mddarr.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.time.Duration;
import java.util.List;

@SpringBootTest
class PatientServiceApplicationTests {

	@ClassRule
	public static DockerComposeContainer environment =
			new DockerComposeContainer<>(new File("src/test/resources/cassandra-compose.yml"))
					.withExposedService("cassandra", 9042,
							Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(30)));

	@Test
	void contextLoads() {

	}

}

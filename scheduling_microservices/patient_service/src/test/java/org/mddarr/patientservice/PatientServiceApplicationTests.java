package org.mddarr.patientservice;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.mddarr.patientservice.models.Patient;
import org.mddarr.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;

import java.util.List;

@SpringBootTest
class PatientServiceApplicationTests {

	@ClassRule
	public static GenericContainer cassandra =
			new GenericContainer("cassandra:3")
					.withExposedPorts(9042);

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void contextLoads() {
		List<Patient> patients = patientRepository.findAllPatients();
	}

}

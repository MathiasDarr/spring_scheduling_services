package org.mddarr.inventoryservice;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ProductsServiceApplicationTests extends AbstractIntegrationTest {


	@BeforeEach
	public void setup() throws IOException {

	}


	@Test
	void contextLoads() {
	}

}

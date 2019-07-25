package com.ideagen.pojo.exp.webservice.springweb;

import com.ideagen.pojo.exp.webservice.springweb.configuration.H2TestDatasourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {PojoExpWebserviceSpringwebApplication.class, H2TestDatasourceConfig.class})
class PojoExpWebserviceSpringwebApplicationTests {

	@Test
	void contextLoads() {
	}
}

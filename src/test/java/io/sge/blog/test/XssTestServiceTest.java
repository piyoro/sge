package io.sge.blog.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.sge.blog.test.entity.XssTest;
import io.sge.blog.test.service.XssTestService;

@SpringBootTest
public class XssTestServiceTest {

	@Autowired
	XssTestService xssTestService;

	@Test
	public void testXssTestByQuery() {
		List<XssTest> list = xssTestService.xssTestByQuery();
		assertEquals(18, list.size());
	}
}

package io.sge.blog.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.sge.blog.test.vo.User;

@Controller
public class TestController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/test")
	@ResponseBody
	public String sampleHome() {
		if (logger.isDebugEnabled()) {
			logger.debug("sampleHome() - start"); //$NON-NLS-1$
		}

		String strLogMsg = "test message";

		if (logger.isInfoEnabled()) {
			logger.info("sampleHome() - strLogMsg - strLogMsg={}", strLogMsg); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("sampleHome() - log this position"); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("sampleHome() - end"); //$NON-NLS-1$
		}
		return "Hello Gradle! Hello Spring Boot!";

	}

	@GetMapping("/thymeleaf")
	public String getUser(Model model) {
		User user = new User("dorune", "한글", "piyoro");
		model.addAttribute("user", user);
		return "test/thymeleaf";
	}
}
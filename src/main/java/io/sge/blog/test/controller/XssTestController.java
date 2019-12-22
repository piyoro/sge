package io.sge.blog.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.sge.blog.test.entity.XssTest;
import io.sge.blog.test.service.XssTestService;
import io.sge.blog.test.vo.User;

@Controller
public class XssTestController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(XssTestController.class);

	@Autowired
	XssTestService xssTestService;

	@RequestMapping(value = "/testSelect")
	public String testSelect(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("testSelect() - start"); //$NON-NLS-1$
		}
		User user = new User("dorune", "한글", "piyoro");
		model.addAttribute("user", user);

		List<XssTest> testList = xssTestService.xssTestByQuery();
		model.addAttribute("testList", testList);

		if (logger.isDebugEnabled()) {
			logger.debug("testSelect() - end"); //$NON-NLS-1$
		}
		// return "th_thymeleaf";
		return "test/th_testSelect";
		// return "test2/test";
	}

	@RequestMapping(value = "/testSelectJstl")
	public String testSelectJstl(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("testSelect() - start"); //$NON-NLS-1$
		}

		User user = new User("dorune", "한글", "piyoro");
		model.addAttribute("user", user);

		List<XssTest> testList = xssTestService.xssTestByQuery();
		model.addAttribute("testList", testList);

		if (logger.isDebugEnabled()) {
			logger.debug("testSelect() - end"); //$NON-NLS-1$
		}
		return "test2/test";
	}

	@RequestMapping(value = "/xssTestInsert")
	public String xssTestInsert(Model model, HttpServletRequest req, HttpServletResponse res) {
		if (logger.isDebugEnabled()) {
			logger.debug("testSelect() - start"); //$NON-NLS-1$
		}

		User user = new User("dorune", "한글", "piyoro");
		model.addAttribute("user", user);

		Integer id = Integer.valueOf(req.getParameter("id"));
		String text = req.getParameter("text");
		XssTest test = new XssTest(id, text);
		logger.debug("kjw xss {}", new Object[] { test });
		logger.debug("kjw3 xss {}", new Object[] { test });
		xssTestService.xssInsertTest(test);
		logger.debug("kjw2 xss {}", new Object[] { test });
		// List<XssTest> testList = xssTestService.xssTestByQuery();
		// model.addAttribute("testList", testList);

		if (logger.isDebugEnabled()) {
			logger.debug("testSelect() - end"); //$NON-NLS-1$
		}
		return "test/th_testSelect";

	}
}
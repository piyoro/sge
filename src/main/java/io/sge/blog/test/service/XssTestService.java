package io.sge.blog.test.service;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sge.blog.test.dao.XssTestRepository;
import io.sge.blog.test.entity.XssTest;

@Service
public class XssTestService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(XssTestService.class);

	@Autowired
	XssTestRepository xssTestRepository;

	public List<XssTest> xssTestByQuery() {
		if (logger.isDebugEnabled()) {
			logger.debug("xssTestByQuery() - start"); //$NON-NLS-1$
		}

		List<XssTest> returnList = xssTestRepository.getXssTestQuery();
		if (logger.isInfoEnabled()) {
			logger.info("xssTestByQuery() - List returnList={}", returnList); //$NON-NLS-1$
			if (returnList != null) {
				for (XssTest item : returnList) {
					// 18. 아이디 에서 만 html unescape 처리 테스트
					if (item.getId() == 18) {
						item.setXssText(StringEscapeUtils.unescapeHtml4(item.getXssText()));
					}
				}
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("xssTestByQuery() - end"); //$NON-NLS-1$
		}
		return returnList;
	}

	public void xssInsertTest(XssTest xssTest) {
		xssTestRepository.save(xssTest);
	}
}

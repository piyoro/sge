package io.sge.blog.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import io.sge.blog.common.util.DateUtil;
import io.sge.blog.common.util.StringUtil;

public class TrxBaseFilter implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(TrxBaseFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - start"); //$NON-NLS-1$
		}

		HttpServletRequest req = (HttpServletRequest) request;

		String reqTrcId = req.getHeader("reqTrcId");
		if (StringUtils.isEmpty(reqTrcId)) {
			reqTrcId = DateUtil.getCurrentDate("yyyyMMddHHmmssSSS") + StringUtil.getFixedRandomStringId(3, '0')
					+ StringUtil.getFixedRandomStringId(3, '0') + StringUtil.getFixedRandomStringId(3, '0');
		}
		MDC.put("reqTrcId", reqTrcId);

		chain.doFilter(req, response);

		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
		}
	}

}

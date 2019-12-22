package io.sge.blog.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.sge.blog.common.util.DateUtil;
import io.sge.blog.common.util.StringUtil;

/**
 * traceId 로깅 관련 기능을 TrxBaseFilter로 기능을 이관했다.
 */
public class TrxBaseInterceptor extends HandlerInterceptorAdapter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(TrxBaseInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object object) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("preHandle(HttpServletRequest, HttpServletResponse, Object) - start"); //$NON-NLS-1$
		}

		String reqTrcId = req.getHeader("reqTrcId");
		if (StringUtils.isEmpty(reqTrcId)) {
			reqTrcId = DateUtil.getCurrentDate("yyyyMMddHHmmssSSS") + StringUtil.getFixedRandomStringId(3, '0')
					+ StringUtil.getFixedRandomStringId(3, '0') + StringUtil.getFixedRandomStringId(3, '0');
		}
		MDC.put("reqTrcId", reqTrcId);

		if (logger.isDebugEnabled()) {
			logger.debug("preHandle(HttpServletRequest, HttpServletResponse, Object) - end"); //$NON-NLS-1$
		}
		return true;
	}
}

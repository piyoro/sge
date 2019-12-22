package io.sge.blog.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sge.blog.test.dao.CouponReqTestRepository;
import io.sge.blog.test.entity.CouponReqTest;

@Service
public class CouponReqTestService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(CouponReqTestService.class);

	@Autowired
	CouponReqTestRepository couponReqTestRepository;

	public void insertCouponReq(CouponReqTest couponReqTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponReq(CouponReqTest) - start"); //$NON-NLS-1$
		}

		couponReqTestRepository.save(couponReqTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponReq(CouponReqTest) - end"); //$NON-NLS-1$
		}
	}
}

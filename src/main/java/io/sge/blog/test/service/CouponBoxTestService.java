package io.sge.blog.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.sge.blog.common.exception.SgeException;
import io.sge.blog.test.dao.CouponBoxTestRepository;
import io.sge.blog.test.dao.CouponReqTestRepository;
import io.sge.blog.test.entity.CouponBoxTest;
import io.sge.blog.test.entity.CouponReqTest;

@Service
public class CouponBoxTestService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(CouponBoxTestService.class);

	@Autowired
	CouponReqTestRepository couponReqTestRepository;

	@Autowired
	CouponBoxTestRepository couponBoxTestRepository;

	public void insertCouponBox(CouponBoxTest couponBoxTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 디폴트 속성, 부모 트랜잭션 내에서 실행하며 부모 트랜잭션이 없을 경우 새로운 트랜잭션을 생성한다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertCouponBox_REQUIRED(CouponBoxTest couponBoxTest, boolean throwException) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_REQUIRED(CouponBoxTest, boolean) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (throwException) {
			throw new SgeException("expected transaction");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_REQUIRED(CouponBoxTest, boolean) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 디폴트 속성, 부모 트랜잭션 내에서 실행하며 부모 트랜잭션이 없을 경우 새로운 트랜잭션을 생성한다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void prcCouponBox_REQUIRED(CouponBoxTest couponBoxTest, boolean throwException) {
		if (logger.isDebugEnabled()) {
			logger.debug("prcCouponBox_REQUIRED(CouponBoxTest, boolean) - start"); //$NON-NLS-1$
		}
		CouponReqTest couponReqTest = new CouponReqTest();
		couponReqTest.setCouponReqTestId(couponBoxTest.getCouponReqTestId());
		couponReqTest.setRegDt(couponBoxTest.getRegDt());

		couponReqTestRepository.save(couponReqTest);
		couponBoxTestRepository.save(couponBoxTest);

		if (throwException) {
			throw new SgeException("expected transaction");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("prcCouponBox_REQUIRED(CouponBoxTest, boolean) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 이미 시작된 트랜잭션이 있으면 참여하고 그렇지 않으면 트랜잭션 없이 진행하게 만든다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public void insertCouponBox_SUPPORTS(CouponBoxTest couponBoxTest, boolean throwException) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_SUPPORTS(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (throwException) {
			throw new SgeException("unexpected transaction");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_SUPPORTS(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 항상 새로운 트랜잭션을 시작한다. - 이미 진행 중인 트랜잭션이 있으면 트랜잭션을 잠시 보류시킨다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertCouponBox_REQUIRES_NEW(CouponBoxTest couponBoxTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_REQUIRES_NEW(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_REQUIRES_NEW(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * REQUIRED와 비슷하게 이미 시작된 트랜잭션이 있으면 참여한다. - 반면에 트랜잭션이 시작된 것이 없으면 새로 시작하는 대신 예외를 발생시킨다. - 혼자서는 독립적으로 트랜잭션을 진행하면 안 되는 경우에 사용한다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertCouponBox_MANDATORY(CouponBoxTest couponBoxTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_MANDATORY(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_MANDATORY(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 트랜잭션을 사용하지 않게 한다. - 이미 진행 중인 트랜잭션이 있으면 보류시킨다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void insertCouponBox_NOT_SUPPORTED(CouponBoxTest couponBoxTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_NOT_SUPPORTED(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_NOT_SUPPORTED(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 트랜잭션을 사용하지 않도록 강제한다. - 이미 진행 중인 트랜잭션도 존재하면 안된다 있다면 예외를 발생시킨다.
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.NEVER)
	public void insertCouponBox_NEVER(CouponBoxTest couponBoxTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_NEVER(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_NEVER(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * <pre>
	- 이미 진행중인 트랜잭션이 있으면 중첩 트랜잭션을 시작한다.
	- 중첩 트랜잭션은 트랜잭션 안에 다시 트랜잭션을 만드는 것이다.
	
	- 하지만 독립적인 트랜잭션을 만드는 REQUIRES_NEW와는 다르다.
	
	중첩된 트랜잭션은 먼저 시작된 부모 트랜잭션의 커밋과 롤백에는 영향을 받지만 자신의 커밋과 롤백은 부모 트랝개션에게 영향을 주지 않는다.
	
	1. 어떤 작업을 진행하는 중 로그는 꼭 DB에 저장해야 할 때
	이 로그를 저장하는 작업이 실패한다고 메인 작업의 트랜잭션까지는 롤백되버린다면 특히 쇼핑몰에서 고객 주문작업 등의 경우 매출 하락까지도 발생할 수 있는 중요한 문제이다.
	
	반대로 로그를 남긴 후 메인 작업에서 예외가 발생한다면 이때는 저장한 로그도 롤백 되어야 하는게 맞다. (내 생각과는 조금 다르다)
	 * </pre>
	 * 
	 * @param couponBoxTest
	 */
	@Transactional(propagation = Propagation.NESTED)
	public void insertCouponBox_NESTED(CouponBoxTest couponBoxTest) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_NESTED(CouponBoxTest) - start"); //$NON-NLS-1$
		}

		couponBoxTestRepository.save(couponBoxTest);

		if (logger.isDebugEnabled()) {
			logger.debug("insertCouponBox_NESTED(CouponBoxTest) - end"); //$NON-NLS-1$
		}
	}

	/*
		public void insertCouponBox_SUPPORTS(CouponBoxTest couponBoxTest) {
			
			CouponReqTest couponReqTest = new CouponReqTest();
			couponReqTest.setCouponReqTestId(couponBoxTest.getCouponReqTestId());
			couponReqTest.setRegDt(couponBoxTest.getRegDt());
			
			couponReqTestRepository.save(couponReqTest);
			
			couponBoxTestRepository.save(couponBoxTest);
		}
	*/
}

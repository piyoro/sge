package io.sge.blog.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.sge.blog.common.exception.SgeException;
import io.sge.blog.test.entity.CouponBoxTest;
import io.sge.blog.test.entity.CouponReqTest;
import io.sge.blog.test.entity.CouponReqTestId;
import io.sge.blog.test.service.CouponBoxTestService;
import io.sge.blog.test.service.CouponReqTestService;

@DataJpaTest
public class CouponTransactionServiceTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(CouponTransactionServiceTest.class);

	@Autowired
	CouponReqTestService couponReqTestService;

	@Autowired
	CouponBoxTestService couponBoxTestService;

	/**
	 * 디폴트 속성, 부모 트랜잭션 내에서 실행하며 부모 트랜잭션이 없을 경우 새로운 트랜잭션을 생성한다.
	 * 
	 * @param couponBoxTest
	 */
	@Test
	public void insertCouponBox_REQUIRED() {
		int testNumber = 9;
		String testRegDt = "20191223";

		CouponReqTestId couponReqTestId = new CouponReqTestId();
		couponReqTestId.setUserId("test");
		couponReqTestId.setCouponId(testNumber);

		CouponReqTest couponReqTest = new CouponReqTest();
		couponReqTest.setCouponReqTestId(couponReqTestId);
		couponReqTest.setRegDt(testRegDt);

		CouponBoxTest couponBoxTest = new CouponBoxTest();
		couponBoxTest.setCouponNum(String.valueOf(testNumber));
		couponBoxTest.setCouponReqTestId(couponReqTestId);
		couponBoxTest.setRegDt(testRegDt);

		// couponReqTestService.insertCouponReq(couponReqTest);
		/*
				boolean throwException = false;
				// unexpected exception && transaction rollbak
				couponBoxTestService.insertCouponBox_REQUIRED(couponBoxTest, throwException);
				assertTrue(true);
		*/

		/*
		 * REQUIRED insertCouponReq
		 * REQUIRED insertCouponBox_REQUIRED
		 * 결과
		 * coupon_req_test => commit
		 * coupon_box_test => rollback
		 * 기대했던 내용이 아니다.
		 */
		/*		
				boolean throwException = true;
				// ! expected exception && transaction rollbak
				assertThrows(SgeException.class, () -> {
					couponBoxTestService.insertCouponBox_REQUIRED(couponBoxTest, throwException);
				});
		*/

		boolean throwException = false;
		// unexpected exception && transaction rollbak
		couponBoxTestService.prcCouponBox_REQUIRED(couponBoxTest, throwException);
		assertTrue(true);

		/*
		 * coupon_req / coupon_box 서비스 2개의 역할을 하나의 서비스로 묶어본다.
		 * 기대했던대로 Exception 발생 시,
		 * coupon_req_test => rollback
		 * coupon_box_test => rollback
		 * 으로 동작한다.
		 * 트랜잭션의 부모라는 용어가 서비스 레벨임을 확인한다.
		 */
		/*
		boolean throwException = true;
		// !! expected exception && transaction rollbak
		assertThrows(SgeException.class, () -> {
			couponBoxTestService.prcCouponBox_REQUIRED(couponBoxTest, throwException);
		});
		*/
	}

	/**
	 * 이미 시작된 트랜잭션이 있으면 참여하고 그렇지 않으면 트랜잭션 없이 진행하게 만든다.
	 * 
	 * @param couponBoxTest
	 */
	// @Test
	public void insertCouponBox_SUPPORTS() {
		int testNumber = 3;
		String testRegDt = "20191223";

		CouponReqTestId couponReqTestId = new CouponReqTestId();
		couponReqTestId.setUserId("test");
		couponReqTestId.setCouponId(testNumber);

		CouponReqTest couponReqTest = new CouponReqTest();
		couponReqTest.setCouponReqTestId(couponReqTestId);
		couponReqTest.setRegDt(testRegDt);

		CouponBoxTest couponBoxTest = new CouponBoxTest();
		couponBoxTest.setCouponNum(String.valueOf(testNumber));
		couponBoxTest.setCouponReqTestId(couponReqTestId);
		couponBoxTest.setRegDt(testRegDt);

		couponReqTestService.insertCouponReq(couponReqTest);
		/*
		boolean throwException = false;
		// unexpected transaction rollbak
		couponBoxTestService.insertCouponBox_SUPPORTS(couponBoxTest, throwException);
		assertTrue(true);
		*/
		boolean throwException = true;
		// unexpected transaction rollbak
		assertThrows(SgeException.class, () -> {
			couponBoxTestService.insertCouponBox_SUPPORTS(couponBoxTest, throwException);
		});
	}
}

package io.sge.blog.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.sge.blog.test.entity.CouponReqTest;
import io.sge.blog.test.entity.CouponReqTestId;
import io.sge.blog.test.service.CouponReqTestService;

@SpringBootTest
public class CouponReqTestServiceTest {

	@Autowired
	CouponReqTestService CouponReqTestService;

	@Test
	public void insertCouponReq() {
		CouponReqTestId couponReqTestId = new CouponReqTestId();

		couponReqTestId.setUserId("test");
		couponReqTestId.setCouponId(1);
		CouponReqTest couponReqTest = new CouponReqTest();
		couponReqTest.setCouponReqTestId(couponReqTestId);
		couponReqTest.setRegDt("20191223");
		CouponReqTestService.insertCouponReq(couponReqTest);
		assertTrue(true);
	}
}

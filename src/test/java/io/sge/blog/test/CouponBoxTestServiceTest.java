package io.sge.blog.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.sge.blog.test.entity.CouponBoxTest;
import io.sge.blog.test.entity.CouponReqTestId;
import io.sge.blog.test.service.CouponBoxTestService;

@SpringBootTest
public class CouponBoxTestServiceTest {

	@Autowired
	CouponBoxTestService CouponBoxTestService;

	@Test
	public void insertCouponBox() {
		CouponReqTestId couponReqTestId = new CouponReqTestId();

		couponReqTestId.setUserId("test");
		couponReqTestId.setCouponId(1);
		CouponBoxTest CouponBoxTest = new CouponBoxTest();
		CouponBoxTest.setCouponNum("1");
		CouponBoxTest.setCouponReqTestId(couponReqTestId);
		CouponBoxTest.setRegDt("20191223");
		CouponBoxTestService.insertCouponBox(CouponBoxTest);
		assertTrue(true);
	}
}

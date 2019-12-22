package io.sge.blog.test.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CouponBoxTest {

	@Id
	@Column(name = "COUPON_NUM", columnDefinition = "VARCHAR2(100)")
	private String couponNum;

	@Embedded
	private CouponReqTestId CouponReqTestId;

	@Column(name = "REG_DT", columnDefinition = "CHAR(8)")
	private String regDt;

	public String getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(String couponNum) {
		this.couponNum = couponNum;
	}

	public CouponReqTestId getCouponReqTestId() {
		return CouponReqTestId;
	}

	public void setCouponReqTestId(CouponReqTestId couponReqTestId) {
		CouponReqTestId = couponReqTestId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

}

package io.sge.blog.test.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CouponReqTest {

	@EmbeddedId
	private CouponReqTestId CouponReqTestId;

	@Column(name = "REG_DT", columnDefinition = "CHAR(8)")
	private String regDt;

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

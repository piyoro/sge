package io.sge.blog.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CouponReqTestId implements Serializable {

	/**
	 * generated serial version ID
	 */
	private static final long serialVersionUID = 7531130253943085191L;

	@Column(name = "USER_ID", columnDefinition = "VARCHAR2(50)")
	private String userId;

	@Column(name = "COUPON_ID", columnDefinition = "INT")
	private int couponId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

}

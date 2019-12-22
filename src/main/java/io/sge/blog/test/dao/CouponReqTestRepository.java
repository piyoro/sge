package io.sge.blog.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.sge.blog.test.entity.CouponReqTestId;
import io.sge.blog.test.entity.CouponReqTest;

@Repository
public interface CouponReqTestRepository extends CrudRepository<CouponReqTest, CouponReqTestId> {

}

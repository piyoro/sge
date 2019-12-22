package io.sge.blog.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.sge.blog.test.entity.CouponBoxTest;

@Repository
public interface CouponBoxTestRepository extends CrudRepository<CouponBoxTest, String> {

}

package io.sge.blog.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.sge.blog.test.entity.XssTest;

@Repository
public interface XssTestRepository extends CrudRepository<XssTest, Integer> {
	// @Query("select new XssTest(id, xssText) from XssTest")
	@Query("select new XssTest(a.id, a.xssText) from XssTest a")
	List<XssTest> getXssTestQuery();
}

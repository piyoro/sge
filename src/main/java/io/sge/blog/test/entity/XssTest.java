package io.sge.blog.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

//import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "XssTest")
public class XssTest {

	@Id
	@Column(name = "ID", columnDefinition = "INT")
	private Integer id;

	@Column(name = "XSS_TEXT", columnDefinition = "VARCHAR(100)")
	private String xssText;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXssText() {
		return xssText;
	}

	public void setXssText(String xssText) {
		this.xssText = xssText;
	}

	public XssTest() {
		super();
	}

	public XssTest(Integer id, String xssText) {
		this.id = id;
		this.xssText = xssText;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

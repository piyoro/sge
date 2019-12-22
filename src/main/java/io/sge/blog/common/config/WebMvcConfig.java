package io.sge.blog.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

@Configuration
/*
 * @EnableWebMvc 작성하지 않으면 spring-boot에서 자동으로 설정한다. 작성한다면 WebMvcAutoConfiguration 클래스가 동작하지 않게되고, Spring-boot가 설정해 놓은 기본설정은 동작하지 않게 된다.
 */
@EnableWebMvc
/*
 * 특별히 건드리지 않았는데, @ComponentScan 가 없으니 requestMapping 을 찾지 못한다.
 */
@ComponentScan(value = { "io.sge.blog" })
public class WebMvcConfig implements WebMvcConfigurer {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

	/*
	 * lucy-xss-filter
	 */
	@Bean
	public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistrationBean() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFilterRegistrationBean() - start"); //$NON-NLS-1$
		}

		FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<XssEscapeServletFilter>();
		registrationBean.setFilter(new XssEscapeServletFilter());
		registrationBean.setOrder(1);
		registrationBean.addUrlPatterns("*"); // filter를 거칠 url patterns

		if (logger.isDebugEnabled()) {
			logger.debug("getFilterRegistrationBean() - end"); //$NON-NLS-1$
		}
		return registrationBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터는 추후 추가
		// registry.addInterceptor(new TrxBaseInterceptor()).addPathPatterns("/*");
	}
}

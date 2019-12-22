/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sge.blog.common.xss;

import org.apache.commons.lang3.StringUtils;

import com.navercorp.lucy.security.xss.servletfilter.defender.Defender;
import com.navercorp.lucy.security.xss.servletfilter.defender.XssSaxFilterDefender;
import com.nhncorp.lucy.security.xss.XssPreventer;

/**
 * @author todtod80
 */
public class XssDreDefender implements Defender {

	/**
	 * @param values
	 *        String[]
	 * @return void
	 */
	@Override
	public void init(String[] values) {
	}

	/**
	 * @param value
	 *        String
	 * @return String
	 */
	@Override
	public String doFilter(String value) {
		// escape 처리 전에 XssSaxFilter 에서 처리하는
		// 위험요소를 제거하고 escape 하기를 희망한다.
		if (StringUtils.isEmpty(value))
			return value;

		XssSaxFilterDefender saxDefender = new XssSaxFilterDefender();

		// lucy 라이브러리에서 잘 처리해줬을거라 판단
		saxDefender.init(null);
		value = saxDefender.doFilter(value);
		return XssPreventer.escape(value);
	}
}

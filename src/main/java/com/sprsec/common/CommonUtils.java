package com.sprsec.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

	public static void headerInfo(HttpServletRequest request, Map<String, Object> model) {
		model.put("_contextPath", request.getContextPath());
	}
}

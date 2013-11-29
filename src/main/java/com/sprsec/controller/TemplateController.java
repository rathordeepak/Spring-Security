package com.sprsec.controller;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("templateController")
public class TemplateController {

	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/templates/{pageName}", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	String getTemplate(@PathVariable("pageName") String pageName,
			HttpServletRequest request, HttpServletResponse response) {
		String content = "";
		try {
			File file = new File(
					servletContext.getRealPath("WEB-INF/pages/templates/"
							+ pageName + ".html"));
			if (file == null || !file.exists()) {
				throw new FileNotFoundException();
			}
			response.setContentType("text/html");
			content = FileUtils.readFileToString(file);
		} catch (FileNotFoundException e) {
		} catch (Exception ignored) {
		}
		return content;

	}

	@RequestMapping(value = "/templates/{subfolder}/{page}", method = RequestMethod.GET)
	@Secured("ROLE_PG_HOME")
	public @ResponseBody
	String getTemplate(@PathVariable("subfolder") String subfolder,
			@PathVariable("page") String page, HttpServletRequest request,
			HttpServletResponse response) {
		String content = "";
		try {
			File file = new File(
					servletContext.getRealPath("WEB-INF/pages/templates/"
							+ subfolder + "/" + page + ".html"));
			if (file == null || !file.exists()) {
				throw new FileNotFoundException();
			}
			response.setContentType("text/html");
			content = FileUtils.readFileToString(file);
		} catch (FileNotFoundException e) {
		} catch (Exception ignored) {
		}
		return content;

	}

}

package com.sprsec.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import com.sprsec.navigation.Menu;

@Repository
public class Navigation implements BeanPostProcessor,
		ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {
	private ApplicationContext applicationContext;

	private Map<String, NavEntry> navigations = new HashMap<String, NavEntry>();

	private boolean initialized = false;

	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			if (event.getApplicationContext().equals(applicationContext)) {
				Menu nav1 = applicationContext.getBean(Menu.class);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		Class<? extends Object> clazz = bean.getClass();
		if (org.springframework.aop.SpringProxy.class.isAssignableFrom(clazz)) {
			clazz = clazz.getSuperclass();
		}
		if (clazz.isAnnotationPresent(Controller.class)) {
			Method[] declaredMethods = ReflectionUtils
					.getAllDeclaredMethods(clazz);
			for (Method method : declaredMethods) {

				if (method.isAnnotationPresent(Menu.class)) {
					Menu menu = method.getAnnotation(Menu.class);
					NavEntry navEntry = new NavEntry();
					navEntry.setAccessCode(menu.accessCode());
					navEntry.setTitle(menu.title());
					navEntry.setOrder(menu.order());
					navEntry.setUrl(menu.url());
					navigations.put(menu.accessCode(), navEntry);
				}
			}
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	public Map<String, NavEntry> getMenuList() {
		return navigations;
	}

	public List<NavEntry> displayMenuList() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails
				.getAuthorities();
		Map<String, NavEntry> allowAccessList = getMenuList();
		List<NavEntry> navigationEntries = new ArrayList<NavEntry>();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (allowAccessList.get(grantedAuthority.getAuthority()) != null) {
				navigationEntries.add(allowAccessList.get(grantedAuthority
						.getAuthority()));
			}
		}
		return navigationEntries;
	}

	public class NavEntry {
		private String title;
		private String accessCode;
		private int order;
		private String url;

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAccessCode() {
			return accessCode;
		}

		public void setAccessCode(String accessCode) {
			this.accessCode = accessCode;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}
}

package com.sprsec.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.PublicDao;
import com.sprsec.service.PublicManager;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublicManagerImpl implements PublicManager {

	@Autowired
	private PublicDao publicDao;

	@Override
	public <T> List<T> getObjects(Class<T> clazz) {
		return publicDao.getObjects(clazz);
	}

	@Override
	public <T> T getObject(Class<T> clazz, Serializable id) {
		return publicDao.getObject(clazz, id);
	}

	@Transactional(readOnly = false)
	public void saveObject(Object o) {
		publicDao.saveObject(o);

	}

	@Override
	public void removeObject(Class clazz, Serializable id) {
		publicDao.removeObject(clazz, id);
	}

	@Override
	public <T> List<T> getObjects(Class<T> clazz, String orderByField) {
		return publicDao.getObjects(clazz);
	}

	@Override
	public <T> T getObjectOrNull(Class<T> clazz, Serializable id) {
		return publicDao.getObjectOrNull(clazz, id);
	}
	
}

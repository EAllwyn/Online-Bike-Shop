package com.mit.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.SupplierDAO;
import com.mit.model.Supplier;


@EnableTransactionManagement
@Repository("supplierDAO")
public class SupplierDAOImple implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImple(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public List<Supplier> getAllSupplier() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	@Transactional
	public boolean saveSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}

	@Transactional
	public boolean deleteSupplier(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierById(id));
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Supplier getSupplierById(String id) {
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id ="+ id +"" ).uniqueResult();// uniqueresult() or list().get(0);

	}

	@Transactional
	public Supplier getSupplierByName(String name) {
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id ="+ name +"" ).list().get(0);

	}

}

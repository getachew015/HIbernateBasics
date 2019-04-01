package com.hibernate.loanapp.compositekey;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.crud.HibernateUtil;

public class CustomerDAO implements CPKCustomerDAO{

	@Override
	public int addCustomerLoanDetails(CustomerLoan customerLoan) {
		try {
			Session session = HibernateUtil.getSession().openSession();
			Transaction trans = session.beginTransaction();
			session.save(customerLoan);
			trans.commit();
			session.close();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public CustomerLoan getCustomerLoanDetails(Integer customerId, String loanId) {
		CustomerLoan custLoan = null;
		
		try {
			Session session = HibernateUtil.getSession().openSession();
			CustomerLoanPK custLoanPK = new CustomerLoanPK();
			custLoanPK.setCustomerId(customerId);
			custLoanPK.setLoanId(loanId);
			custLoan = session.load(CustomerLoan.class, custLoanPK);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return custLoan;
	}

	@Override
	public int addCustomerLoanEmbedded(CustomerLoanCompoPK custLoanCompoPK) {
		try {
			Session session = HibernateUtil.getSession().openSession();
			Transaction trans = session.beginTransaction();
			session.save(custLoanCompoPK);
			trans.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public CustomerLoanCompoPK getCustomerLoanCompoPK(CustomerLoanPK pk) {		
		Session session = HibernateUtil.getSession().openSession();
		CustomerLoanCompoPK custLoanCompoPK = session.load(CustomerLoanCompoPK.class, pk);
		session.close();
		return custLoanCompoPK;
	}

}

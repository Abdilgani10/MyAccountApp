package com.qa.domain;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


public class RepoLayer {

	@Transactional
	public class RepoLayer {
		
		@PersistenceContext(unitName = "primary")
		private EntityManager em; 
		
			
		public List <Account> getAllAccount() {
			TypedQuery<Account> query = em.createQuery("Select * FROM ACCOUNT;", Account.class);
			return query.getResultList();
		}
		
		public List <Account> findAccount() {
			TypedQuery<Account> query = em.createQuery("Select * FROM ACCOUNT WHERE FIRSTNAME = 'John';", Account.class);
			query.executeUpdate();
			return query.getResultList();
		}
		
		@Transactional
		public void createAccount() {
			TypedQuery<Account> query = em.createQuery("INSERT INTO ACCOUNT VALUES ('1','333','Gani','Abdilgani');", Account.class);
			query.executeUpdate();
			
		}
		public void updateAccount() {
			TypedQuery<Account> query = em.createQuery("update ACCOUNT SET FIRSTNAME = 'JANE'  WHERE ID = 2;", Account.class);
			query.executeUpdate();
			
		}
		
		public void deleteAccount() {
			TypedQuery<Account> query = em.createQuery("DELETE FROM ACCOUNT WHERE ID = 1;", Account.class);
			query.executeUpdate();
			
		}
	}
}

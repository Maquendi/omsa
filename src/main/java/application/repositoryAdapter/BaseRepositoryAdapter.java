package application.repositoryAdapter;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import application.exceptions.InvalidModelException;
import application.exceptions.ResourceNotFoundException;
import application.repository.BaseRepository;

public abstract class BaseRepositoryAdapter<T> implements BaseRepository<T> {
	
	
	@Autowired
	@Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
	
	private Class<T> type;
	
	
	public BaseRepositoryAdapter(Class<T> clazz) {
		this.type = clazz;
	}
	
	

	@Override
	public Long save(T entity) throws InvalidModelException {
		try {
    	      
			      Session session = sessionFactory.openSession();
    	    	  session.beginTransaction();
    	    	  Long id  = (Long)session.save(entity);
    	    	 
    	    	  session.getTransaction().commit();
    	          
    	      return id;
       }catch(Exception ex) {
    	   throw new InvalidModelException("This model is invalid || " + ex.getMessage() );
       }
	}
	
	
	@Override
	public T findById(final long id) throws ResourceNotFoundException {
		
		System.out.println(id);
		
		T result = null;
		
		try {
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			AbstractQuery<T> q = cb.createQuery(type);
			
			Root<T> root = q.from(type); 
			
			q.where(cb.equal(root.get("id"), id));
			
			CriteriaQuery<T> select1 = ((CriteriaQuery<T>) q).select(root);  
			
			TypedQuery<T> tQuery = session.createQuery(select1);
			  
			result = tQuery.getSingleResult();
			
			session.getTransaction().commit();
			
			return result;
			
		}catch(NoResultException ex) {
			throw new ResourceNotFoundException("entity with id: " + id + " not found" );
		}
		
	}
	
	

	@Override
	public List<T> findAll() {


        Session session = sessionFactory.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		AbstractQuery<T> q = cb.createQuery(type);
		
		Root<T> root = q.from(type); 
		
		CriteriaQuery<T> select = ((CriteriaQuery<T>) q).select(root);  
		
		TypedQuery<T> tQuery = session.createQuery(select);
		  
		List<T> result = tQuery.getResultList();
		
		return result;
	}

	
	@Override
	public void delete(T entity) throws InvalidModelException {
       try {
    	   
    	      Session session = sessionFactory.openSession();
	    	  session.beginTransaction();
	    	  session.delete(entity);
	    	  session.getTransaction().commit();

       }catch(Exception ex) {
    	   throw new InvalidModelException("This model is invalid || " + ex.getMessage() );
       }
	}

	@Override
	@Transactional
	public T modify(T entity) throws InvalidModelException {
	  Session session = sessionFactory.openSession();
   	  session.beginTransaction();
   	  session.saveOrUpdate(entity);
   	  session.getTransaction().commit();
		
	  return entity;
	}

}

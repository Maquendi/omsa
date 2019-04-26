package repositoryAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import exceptions.InvalidModelException;
import repository.BaseRepository;

public abstract class BaseRepositoryAdapter<T> implements BaseRepository<T> {
	
	public abstract EntityManager entityManager();

	@Override
	@Transactional
	public T save(T entity) throws InvalidModelException {
		try {
    	      System.out.println(entity);
    	      entityManager().persist(entity);
    	      return entity;
       }catch(Exception ex) {
    	   throw new InvalidModelException("This model is invalid || " + ex.getMessage() );
       }
	}

	@Override
	public List<T> findAll() {
		
		return new ArrayList<>();
	}

	@Override
    @Transactional
	public void delete(T entity) throws InvalidModelException {
       try {


    	   System.out.println(entity);
    	   
       }catch(Exception ex) {
    	   throw new InvalidModelException("This model is invalid || " + ex.getMessage() );
       }
	}

	@Override
	@Transactional
	public T modify(T entity) throws InvalidModelException {
		return null;
	}

}

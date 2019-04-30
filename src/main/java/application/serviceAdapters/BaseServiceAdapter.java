package application.serviceAdapters;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import application.exceptions.InvalidModelException;
import application.repository.BaseRepository;
import application.service.IService;



public abstract class BaseServiceAdapter<T> implements IService<T>{
	
	@Autowired
	private BaseRepository<T> repository;
	
	
	@Override
	public Long save(T entity) throws InvalidModelException {
		try { 
    	      return repository.save(entity);
           }catch(Exception ex) {
    	     throw new InvalidModelException("This model is invalid || " + ex.getMessage() );
       }
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}
	
	
	@Override
	public Optional<T> findById(final long id) {
		
		
		
		return Optional.of(repository.findById(id));
	}
	
	

	@Override
	public void delete(T entity) throws InvalidModelException {
       try {
    	     repository.delete(entity);
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

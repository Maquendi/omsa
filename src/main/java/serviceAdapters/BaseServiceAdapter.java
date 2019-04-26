package serviceAdapters;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import exceptions.InvalidModelException;
import repository.BaseRepository;
import service.IService;



public abstract class BaseServiceAdapter<T> implements IService<T>{
	
	@Autowired
	private BaseRepository<T> repository;
	
	@Override
	public T save(T entity) throws InvalidModelException {
		try { 
    	      return repository.save(entity);
           }catch(Exception ex) {
    	     throw new InvalidModelException("This model is invalid || " + ex.getMessage() );
       }
	}

	@Override
	public List<T> findAll() {
		
		return new ArrayList<>();
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

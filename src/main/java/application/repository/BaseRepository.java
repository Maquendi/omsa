package application.repository;

import java.util.List;

import application.exceptions.InvalidModelException;
import application.exceptions.ResourceNotFoundException;

public interface BaseRepository<T> {

	public Long save(T entity) throws InvalidModelException;
	
	public List<T> findAll();
	
	public T findById(final long id) throws ResourceNotFoundException;
	
	public void delete(T entity) throws InvalidModelException;
	
	public T modify(T entity) throws InvalidModelException;
}

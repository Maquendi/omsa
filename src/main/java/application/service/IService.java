package application.service;

import java.util.List;
import java.util.Optional;

import application.exceptions.InvalidModelException;

    public interface IService<T> {
    	
    public Long save(T entity) throws InvalidModelException;
	
	public List<T> findAll();
	
	public Optional<T> findById(final long id);
	
	public void delete(T entity) throws InvalidModelException;
	
	public T modify(T entity) throws InvalidModelException;
}

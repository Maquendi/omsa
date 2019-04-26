package service;

import java.util.List;

import exceptions.InvalidModelException;

    public interface IService<T> {
    	
    public T save(T entity) throws InvalidModelException;
	
	public List<T> findAll();
	
	public void delete(T entity) throws InvalidModelException;
	
	public T modify(T entity) throws InvalidModelException;
}

package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import exceptions.InvalidModelException;

@Repository
public interface BaseRepository<T> {

	public T save(T entity) throws InvalidModelException;
	
	public List<T> findAll();
	
	public void delete(T entity) throws InvalidModelException;
	
	public T modify(T entity) throws InvalidModelException;
}

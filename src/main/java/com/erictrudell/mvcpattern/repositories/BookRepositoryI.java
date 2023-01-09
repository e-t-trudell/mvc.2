package com.erictrudell.mvcpattern.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erictrudell.mvcpattern.models.Book;
@Repository
public interface BookRepositoryI extends CrudRepository<Book, Long>{
	
	
	
	List<Book> findByDescriptionContaining(String search);
	List<Book> countByTitleContaining(String search);
//	create / update
	List<Book> save(String b);
//	read one or all
	List<Book> getOne(Long id);
	List<Book> findAll();
//	delete
	List<Book> deleteByTitleStartingWith(String search);
//	List<Book> deleteById(Long id);
}

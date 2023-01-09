package com.erictrudell.mvcpattern.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erictrudell.mvcpattern.models.Book;
import com.erictrudell.mvcpattern.repositories.BookRepositoryI;

@Service
public class BookService {
	@Autowired
    // adding the book repository as a dependency
    private BookRepositoryI bookRepository;
    
//    public BookService(BookRepositoryI bookRepository) {
//        this.bookRepository = bookRepository;
//    }
	public Optional<Book> getOneById(Long id) {
        return bookRepository.findById(id);
    }
    // returns all the books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }
//    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
//    	bookRepository.save(String.format(id, title, desc, lang, numOfPages));
////    	bookRepository.save(title);
////    	bookRepository.save(desc);
////    	bookRepository.save(lang);
////    	bookRepository.save(numOfPages);
//    	
//		return bookRepository.save(b);
//	}
    public void deleteById(Long id) {
    	bookRepository.deleteById(id); 
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
}


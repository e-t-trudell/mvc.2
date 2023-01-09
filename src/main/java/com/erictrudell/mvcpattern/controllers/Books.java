package com.erictrudell.mvcpattern.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erictrudell.mvcpattern.models.Book;
import com.erictrudell.mvcpattern.services.BookService;
@Controller
public class Books{
    private final BookService bookService;
    
    public Books(BookService bookService){
        this.bookService = bookService;
    }
    @Autowired
    private BookService bookServ;
    
//    HAVE ONE CONTROLLER FOR HOME AND A SECOND FOR EACH OTHER CLASS DEPENDING ON APP SIZE
    
    @GetMapping("/")
    public String index(Model model) {
//    	get all books from database
    	List<Book> allBooks = bookServ.getAllBooks();
//    	store all books to list
//    	pass list to model
    	model.addAttribute("allBooks", allBooks);
    	return "index.jsp";
    }
    @GetMapping("/api/books")
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }
    
    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @GetMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
//    
    
}
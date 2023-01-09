package com.erictrudell.mvcpattern.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erictrudell.mvcpattern.models.Book;
import com.erictrudell.mvcpattern.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	@PostMapping("/create")
//	bind results catches all results of using the validators here against the binded model attribute
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return"newBook.jsp";
		}else {
			bookServ.createBook(book);
			return "redirect:/";
		}
	}
//	changing method of form to delete request from post request
	@DeleteMapping("/{id}/delete")
    public String deleted(@PathVariable("id") Long id) {
    	bookServ.deleteById(id);
    	return"redirect:/";
    }
//	for a-tag with href link
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteById(id);
		return "redirect:/";
	}

//	@PutMapping("/{id}/delete")
//	public String putRemove(@PathVariable("id") Long id) {
//		bookServ.deleteById(id);
//		return "redirect:/";
//	}
//	get request to render the page
	@GetMapping("/{id}/update")
	public String editForm(@PathVariable("id") Long id, Model model) {
//		most elegant approach
		model.addAttribute("book", bookServ.findBook(id));
		return "editBook.jsp";
	}
//	put request to actually edit
	@PutMapping("/{id}/update")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result,
			@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
//			
			book.setId(id);
			bookServ.updateBook(book);
			return"redirect:/";
		}
	}

}

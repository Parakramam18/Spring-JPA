package com.pruthvi.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    BookRepo bookRepo;

   // @GetMapping("/")
    @GetMapping("/Books")
    public String getBooks()
    {
        return "Hello Books";
    }

    @PutMapping("/addBooks")
    public Book addBooks(@RequestBody Book book)
    {
        return bookRepo.save(book);
    }

    @GetMapping("/Sorted")
    Page<Book> getAllBooks(@RequestParam Optional<Integer> page,
                           @RequestParam Optional<String> sortBy)
    {
        return bookRepo.findAll(PageRequest.of(page.orElse(0),5,
                Sort.Direction.ASC,sortBy.orElse("id")));
    }
}

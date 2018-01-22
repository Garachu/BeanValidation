package com.meg.book;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by meg on 1/22/18.
 */
public class Book {
    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$")
    private String isbn;

    @NotNull
    private String title;

    @NotNull
    @Min(2)
    private Float price;

    @Size(min = 10, max = 2000)
    private String description;

    private Integer nbOfPages;

    @Past
    private Date dateOfPublication;

    public Book(@Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$") String isbn, @NotNull String title, @NotNull @Min(2) Float price, @Size(min = 10, max = 2000) String description, Integer nbOfPages, @Past Date dateOfPublication) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.description = description;
        this.nbOfPages = nbOfPages;
        this.dateOfPublication = dateOfPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
}

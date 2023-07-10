/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clams_combined_library_and_management_systems;

/**
 *
 * @author mdsab
 */
public class BookSearchModel {
    Integer bookID, qty;
    String title, category, author, publisher, status;
    
    
    
    public BookSearchModel(Integer bookID, Integer qty, String title, String category, String author, String publisher, String status) {
        this.bookID = bookID;
        this.qty = qty;
        this.title = title;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }

    public Integer getBookID() {
        return bookID;
    }

    public Integer getQty() {
        return qty;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

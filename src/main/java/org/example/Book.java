package org.example;

public class Book {
    private final Library library;
    public String book_id;
    private final String book_name;
    private final String author;
    protected long issueDate;
    protected long returnDate;
    public int copies;
    public Book(String id,String name,String author,int copies,Library lib){
        this.book_id=id;
        this.book_name=name;
        this.author=author;
        this.library=lib;
        this.copies=copies;
    }
    public void listBook(){
        System.out.println("Book ID: "+this.book_id+"\nName: "+this.book_name+"\nAuthor: "+this.author);
    }
}

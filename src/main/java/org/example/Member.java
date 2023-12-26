package org.example;
import java.util.*;
public class Member {
    private int fine=0;
    private final List<Book> myBooks=new ArrayList<Book>();
    private int no_ofBooks=0;
    private final Library library;
    private final int mem_age;
    protected String mem_id;
    protected String mem_name;
    protected long mem_ph_no;
    public Member(String name, long ph_no, String id,Library lib, int age){
        this.mem_id=id;
        this.mem_name=name;
        this.mem_ph_no=ph_no;
        this.library=lib;
        this.mem_age=age;
    }
    public void list_available_books(){
        for(int i=0;i<library.bookList.size();i++){
            if(library.bookList.get(i).copies>0)
                library.bookList.get(i).listBook();
        }
    }
    public void listMyBooks(){
        for(int i=0;i<no_ofBooks;i++){
            this.myBooks.get(i).listBook();
        }
    }
    public void issueBook(String id){
        if(this.no_ofBooks>1){
            System.out.println("You cannot hold more than two books at a time.");
        }
        else if(this.fine>0){
            System.out.println("Pay the dues first.");
        }
        else {
            for (int i = 0; i < library.bookList.size(); i++) {
                if (Objects.equals(library.bookList.get(i).book_id, id)) {
                    this.myBooks.add(this.no_ofBooks, library.bookList.get(i));
                    this.no_ofBooks++;
                    library.bookList.get(i).copies--;
                    library.bookList.get(i).issueDate=new Date().getTime()/1000;
                    library.bookList.get(i).returnDate=library.bookList.get(i).issueDate+10;
                    library.bookList.remove(library.bookList.get(i));
                    library.no_of_books--;
                    System.out.println("--------------------------");
                    System.out.println("Book issued successfully!");
                }
            }
        }
    }

    public int calculateFine(long daysLate) {
        int amt;
        if(daysLate>0){
            amt=(int)(daysLate*3);
        }
        else{
            amt=0;
        }
        return amt;
    }


    public void returnBook(String id){
        for (int i = 0; i < this.myBooks.size(); i++) {
            if (Objects.equals(this.myBooks.get(i).book_id, id)) {
                this.library.bookList.add(this.myBooks.get(i));
                library.no_of_books++;
                long currentDate=new Date().getTime()/1000;
                long daysLate=(currentDate-this.myBooks.get(i).returnDate);
                this.myBooks.remove(this.myBooks.get(i));
                if(daysLate>0){
                    this.setFine(daysLate);
                    System.out.println("--------------------------");
                    System.out.println("Book id: "+id+" returned successfully! Rs."+this.calculateFine(daysLate)+" has been charged for a delay of "+daysLate+" days.");
                }
                else{
                    System.out.println("--------------------------");
                    System.out.println("Book id: "+id+" returned successfully! No fine due.");
                }
                this.no_ofBooks--;
            }
        }
    }
    public void setFine(long daysLate){
        if(this.calculateFine(daysLate)>0)
            this.fine=this.fine+this.calculateFine(daysLate);
    }
    public void payFine() {
        if(this.fine==0){
            System.out.println("No fine to be paid.");
        }
        else {
            System.out.println("You had a total fine of Rs."+this.fine+". It has been paid successfully.");
            this.fine=0;
        }
    }
    public void listMember(){
        System.out.println("Member ID: "+this.mem_id+"\nName: "+this.mem_name+"\nAge: "+this.mem_age+"\nPh.No.: "+this.mem_ph_no);
        this.listMyBooks();
        System.out.println("Fine due: "+this.fine+"\n");
    }

    public void returnAllBooks(){
        this.library.bookList.addAll(this.myBooks);
    }
}

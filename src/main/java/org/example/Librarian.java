package org.example;

import java.util.Objects;

public class Librarian {
    private final Library library;
    public Librarian(Library lib){
        this.library=lib;
    }
    public void register_Member(String name, long ph_no,int age){
        //long no=9999999999;
        if(ph_no<1000000000){
            System.out.println("Invalid Phone Number!");
            return;
        }
        for(int i=0; i<library.memberList.size();i++){
            if(Objects.equals(library.memberList.get(i).mem_ph_no, ph_no)){
                System.out.println("--------------------------");
                System.out.println("Member with this phone number is already registered.\nCan't register two members with same phone number.");
                return;
            }
        }
        String id=Integer.toString(++this.library.no_of_members);
        library.memberList.add(new Member(name,ph_no,id,this.library,age));
        System.out.println("--------------------------");
        System.out.println("Member successfully registered with member id: "+this.library.no_of_members);
    }
    public void removeMember(String id){
        for(int i=0; i<library.memberList.size();i++){
            if(Objects.equals(library.memberList.get(i).mem_id, id)){
                library.memberList.get(i).returnAllBooks();
                library.memberList.remove(library.memberList.get(i));
                //library.no_of_members--;
                System.out.println("--------------------------");
                System.out.println("Member with id: "+id+" removed successfully!");
                return;
            }
        }
    }
    public void viewMembers(){
        for(int i=0;i<library.memberList.size();i++){
            library.memberList.get(i).listMember();
        }
    }
    public void viewBooks(){
        for(int i=0;i<library.bookList.size();i++){
            library.bookList.get(i).listBook();
        }
        for(int i=0;i<library.memberList.size();i++){
            library.memberList.get(i).listMyBooks();
        }
    }
    public void addBook(String title,String author,int copies) {
        for (int i = 0; i < copies; i++) {
            library.bookList.add(new Book(Integer.toString(++library.no_of_books), title, author, copies, library));
        }
        System.out.println("--------------------------");
        System.out.println("Book added successfully!");
        //System.out.println("--------------------------");
    }
    public void removeBook(String id){
        for(int i=0;i<library.bookList.size();i++){
            if(Objects.equals(library.bookList.get(i).book_id, id)){
                library.bookList.remove(library.bookList.get(i));
                System.out.println("--------------------------");
                System.out.println("Book id: "+id+" removed successfully.");
                //library.no_of_books;
            }
        }
    }
}

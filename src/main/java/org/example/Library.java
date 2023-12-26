package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    private final String libraryName;
    private final Librarian librarian=new Librarian(this);
    public List<Member> memberList = new ArrayList<Member>();
    public int no_of_members=0;
    public List<Book> bookList= new ArrayList<Book>();
    public int no_of_books;
    public Library(String name){
        this.libraryName=name;
        this.no_of_members=0;
        this.no_of_books=0;
    }

    public void enterAsLibrarian(){

        this.display_menu1();
    }
    public void enterAsMember(){
        Scanner sc1=new Scanner(System.in);
        System.out.print("Name: ");
        String name=sc1.nextLine();
        Scanner sc2=new Scanner(System.in);
        System.out.print("Phone No.: ");
        long ph_no=sc2.nextLong();
        if(ph_no<1000000000){
            System.out.println("Invalid Phone Number!");
            return;
        }
        int i;
        for(i=0;i<this.memberList.size();i++){
            if(this.memberList.get(i).mem_ph_no==ph_no&&Objects.equals(this.memberList.get(i).mem_name, name)){
                    System.out.println("Welcome "+name+". Member ID: "+this.memberList.get(i).mem_id);
                    this.display_menu2(this.memberList.get(i));
                    return;
            }
        }
        System.out.println("Member with name: "+name+" and Phone no.: "+ph_no+" does not exist.");
    }
    private String choice1;
    public void display_menu1(){
        while(true) {
            System.out.println("--------------------------");
            System.out.println("1. Register a member");
            System.out.println("2. Remove a member");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View all members");
            System.out.println("6. View all books");
            System.out.println("7. Back");
            System.out.println("--------------------------");
            Scanner scan1 = new Scanner(System.in);
            choice1 = scan1.nextLine();
            if (Objects.equals(choice1, "1")) {
                System.out.println("--------------------------");
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Name: ");
                String name = sc1.nextLine();
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Phone No.: ");
                long ph_no;
                try{
                    ph_no=sc2.nextLong();
                }
                catch(Exception e){
                    System.out.println("Invalid phone no.");
                    continue;
                }
                Scanner sc3=new Scanner(System.in);
                System.out.print("Age: ");
                int age;
                try{
                    age=sc3.nextInt();
                }
                catch(Exception e){
                    System.out.println("Invalid input");
                    continue;
                }
                this.librarian.register_Member(name,ph_no,age);
            } else if (Objects.equals(choice1, "2")) {
                String id;
                System.out.println("--------------------------");
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Enter id of member to be removed: ");
                id = Integer.toString(sc1.nextInt());
                librarian.removeMember(id);
            } else if (Objects.equals(choice1, "3")) {
                String name;
                String author;
                int copies;
                System.out.println("--------------------------");
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Title of book: ");
                name = sc1.nextLine();
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Author's Name: ");
                author = sc2.nextLine();
                Scanner sc3 = new Scanner(System.in);
                System.out.print("Enter no. of copies you want to add: ");
                copies = sc3.nextInt();
                librarian.addBook(name, author, copies);
            } else if (Objects.equals(choice1, "4")) {
                String id;
                System.out.println("--------------------------");
                Scanner sc1 = new Scanner(System.in);
                System.out.print("Enter id of book to be removed: ");
                id = Integer.toString(sc1.nextInt());
                librarian.removeBook(id);
            } else if (Objects.equals(choice1, "5")) {
                System.out.println("--------------------------");
                librarian.viewMembers();
            } else if (Objects.equals(choice1, "6")) {
                System.out.println("--------------------------");
                librarian.viewBooks();
            } else if (Objects.equals(choice1, "7")) {
                this.menu();
            } else {
                System.out.println("--------------------------");
                System.out.println("Enter a valid choice!");
            }
        }
    }
    private String choice2;
    public void display_menu2(Member mem){
        while(true){
            System.out.println("--------------------------");
            System.out.println("1. List Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Pay Fine");
            System.out.println("6. Back");
            System.out.println("--------------------------");
            Scanner scan2=new Scanner(System.in);
            choice2=scan2.nextLine();
            if(Objects.equals(choice2, "1")){
                System.out.println("--------------------------");
                mem.list_available_books();
            }
            else if(Objects.equals(choice2, "2")){
                System.out.println("--------------------------");
                mem.listMyBooks();
            }
            else if(Objects.equals(choice2, "3")){
                System.out.println("--------------------------");
                mem.list_available_books();
                String id;
                Scanner sc1=new Scanner(System.in);
                System.out.print("Enter Book id: ");
                id=Integer.toString(sc1.nextInt());
                mem.issueBook(id);
            }
            else if(Objects.equals(choice2, "4")){
                System.out.println("--------------------------");
                mem.listMyBooks();
                String id;
                Scanner sc1=new Scanner(System.in);
                System.out.print("Enter Book id: ");
                id=Integer.toString(sc1.nextInt());
                mem.returnBook(id);
            }
            else if(Objects.equals(choice2, "5")){
                System.out.println("--------------------------");
                mem.payFine();
            }
            else if(Objects.equals(choice2, "6")){
                this.menu();
            }
            else{
                System.out.println("--------------------------");
                System.out.println("Enter a valid choice!");
            }
        }
    }
    private String choice;
    public void menu(){
        while(true){
            System.out.println("--------------------------");
            System.out.println("1. Enter as librarian");
            System.out.println("2. Enter as member");
            System.out.println("3. Exit");
            System.out.println("--------------------------");
            Scanner scan=new Scanner(System.in);
            choice=scan.nextLine();
            if(Objects.equals(choice, "1")){
                this.enterAsLibrarian();
            }
            else if(Objects.equals(choice, "2")){
                this.enterAsMember();
            }
            else if(Objects.equals(choice, "3")){
                System.out.println("--------------------------");
                System.out.println("Thanks for visiting!");
                System.out.println("--------------------------");
                System.exit(0);
            }
            else{
                System.out.println("--------------------------");
                System.out.println("Enter a valid choice!");
            }
        }
    }
}

BRIEF DESCRIPTION OF HOW THE PROGRAM WORKS.

> main creates a new library object and calls menu() method on it.
    # menu() has 3 choices:
        * on selecting the first choice enterAsLibrarian() method is called. It does not ask for any kind of input.
        * on selecting the second choice enterAsMember() method is called. It asks for Member name and phone number as input to log in into that member's account.
        * on selecting the third choice, the program aborts.
    # enterAsLibrarian() further calls menu1() method.
    # enterAsMember() asks for name and phone no. in input as login credentials and further calls menu2() method.

> there are seven choices in menu1() which calls methods implemented by the Librarian() class on the private Librarian object in the class Library() .
    # first choice is to register a member, asks for member name, phone no. and age as input and then calls the register_Member() method which adds a new member in the arrayList memberList of the class Library().
    # second choice is to remove member, asks for the member id as input of the member which is to be removed and then calls the removeMember() method which removes the member along with it's data from the library's database.
    # third choice is to add a book, asks for book title, author and no. of copies to be added as input and then calls the addBook() method which adds books in the arrayList bookList of the class Library().
    # fourth choice is to remove book, asks for the book id as input of the book which is to be removed and then calls the removeBook() method which removes that particular book from the Library() class' bookList.
    # fifth choice is to view all members, doesn't ask for any input and calls the method viewMembers() which simply lists down all the member associated with library along with their books and fine due. viewMembers() uses Member() class' public method listMember(), to list down the members, on the Member objects in the memberList of Library.
    # sixth choice is to view all books, doesn't ask for any input and calls the method viewBooks() which simply lists down all the books associated with the library whether or not issued by some member. viewBooks() uses Book() class' public method listBook(), to list down the books, on the Book objects in the bookList of Library.
    # seventh choice takes the user back to the previous stage of menu() and again asks for the input from among the three listed choices as described earlier.

> there are six choices in menu2() which calls methods implemented by the Member() class on the Member objects in the memberList of the class Library().
    # first choice is to list available books, doesn't ask for any input and calls the method list_available_books() which simply list down all the books which the user can get issued i.e. all books except those which are currently been issued to some other members. list_available_books() uses Book() class' public method listBook(), to list down the books, on the Book objects in the bookList of Library.
    # second choice is to list my books, doesn't ask for any input and calls the listMyBooks() method which simply lists down all the books that have been issued to this member. listMyBooks() uses Book() class' public method listBook(), to list down the books, on the Book objects in the myBooks of the Member.
    # third choice is to issue a book, first displays the available books and then asks for the book id as input of the book which the member wants to get issued. It then calls the issueBook() method which throws an exception, "you can't hold more than 2 books at a time" if the member has already got issued two books and "pay the dues first" if the member has some fine due. Otherwise it issues the book to tha member and adds it in the member's myBooks if the book is available.
    # fourth choice is to return a book, first displays the books in the member's myBooks arrayList and then asks for the book id as input of the book which the member wants to return. It then calls returnBook() method which removes the book from member's myBooks and adds it back to Library's bookList and calculates the fine if the book is returned after the due date of ten days with rate of Rs.3 per day of delay.
    # fifth choice is to pay the fine, doesn't ask for any input and calls the method payFine() which just displays the member's total fine amount and that it has been paid and sets the member's fine field equal to zero.
    # sixth choice takes the user back to the previous stage of menu() and again asks for the input from among the three listed choice as described earlier.


SOME IMPORTANT POINTS.

> If a member is removed it's id is not reused.
> If a book is removed it's id is not reused.
> Librarian() class' viewBooks() method need not list the books in sequential order with respect to book id.
> Member() class' list_available_book() and listMyBooks() methods need not list the books in sequential order with respect to book id.
> There is no age limit for the members.
> Program only checks if the phone no. is not less than 10 digits.
> Two members cannot be registered with the same phone number however, they can have names in common.
> Fine for a member is calculated only when it returns a book and it is then added to its fine field.
> While taking input for no. of copies if the user enters anything apart from an integer value, the program will abort.


COMMANDS TO COMPILE AND RUN.
On the terminal go the directory where this folder(A1_2022068) is saved.
Then run the following three commands one by one in the given sequence:
    mvn clean install
    mvn package
    mvn exec:java

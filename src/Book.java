import java.util.Objects;

public class Book {
    private final String name;
    private Author author;
    private int publicationYear;


    public Book(String name, Author author, int publicationYear) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;

    }


    public String getName() {

        return this.name;
    }

    public Author getAuthor() {
        return this.author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public  void getBook(String name) throws BookNotFoundException {
        if (name == null) {

            throw new BookNotFoundException("Данной книги нет.");
        }
    }









    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear && name.equals(book.name) && author.equals(book.author);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, author, publicationYear);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author.toString() +
                ", publicationYear=" + publicationYear +
                '}';
    }

}






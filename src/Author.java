import java.util.Objects;

public class Author {
    private String surname ;
    private String  name;
    private String patronymic;
    public Author (String surname ,String name,String patronymic){
        this.name=name;
        this.surname =surname;
        this.patronymic=patronymic;
}public String getName(){return this.name;}
    public String getSurname(){return this.surname;}
    public String getPatronymic(){return this.patronymic;}

    @Override
    public String toString() {
        return "Author{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return surname.equals(author.surname) && name.equals(author.name) && patronymic.equals(author.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic);
    }
}

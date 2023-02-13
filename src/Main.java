import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws BookNotFoundException {

        Author levTolstoy = new Author("Толстой", "Лев", "Николаевич");
        Author maryaRemark = new Author("Ремарк", "Мария", "Эрих");
        Author mikhailBulgakov = new Author("Булгаков", "Михаил", "Афанасьевич");
        Author alexanderPushkin = new Author("Пушкин", "Александр", "Сергеевич");
        Author ivanTurgenev = new Author("Тургенев", "Иван", "Сергеевич");

        Book voynaUMir = new Book("Война и мир", levTolstoy, 1869);
        Book tryTovarihsay = new Book("Три товарища", maryaRemark, 2011);
        Book dogsHeart = new Book("Собачье сердце", mikhailBulgakov, 2001);
        Book еugeneOnegin = new Book("Евгений Онегин", alexanderPushkin, 2003);
        Book fathersAndSons = new Book("Отцы и дети", ivanTurgenev, 2005);
        List<String> bookList = new ArrayList<>();
        bookList.add("Отцы и дети");
        bookList.add("Война и мир");
        bookList.add("Три товарища");
        bookList.add("Собачье сердце");
        bookList.add("Евгений Онегин");
        List<ArrayList<String>> ret = getShelvesOfBooks(bookList);

        ret.stream().forEach(System.out::println);
        Book tryTovarihsnj = null;
        getBook(voynaUMir,еugeneOnegin,tryTovarihsnj);

    }


    private static List<ArrayList<String>> getShelvesOfBooks(List<String> bookList) {

        bookList = bookList.stream()
                .sorted()
                .collect(Collectors.toList());


        List<ArrayList<String>> shelves = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }


        int ind = 0;
        int shelfInd = 0;

        while (ind < bookList.size()) {
            int perShelf = getBooksPerShelf(bookList.size() - ind, shelves.size() - shelfInd);
            for (int i = 0; i < perShelf; i++) {
                shelves.get(shelfInd).add(bookList.get(ind));
                ind++;
            }
            shelfInd++;
        }

        return shelves;
    }


    static int getBooksPerShelf(int books, int shelves) {
        int perShelf = books / shelves;
        if (perShelf * shelves < books)
            perShelf++;
        return perShelf;

    }


    //Задание 2.
    private static void getBook(Book... books) throws BookNotFoundException{
        for (Book book: books)
        try {
            getBook();

        } catch (BookNotFoundException e) {
            System.out.println("Введен неверное название книги");
            System.out.println(e.getMessage());

        }
    }
}





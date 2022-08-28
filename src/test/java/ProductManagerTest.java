import domain.ProductManager;
import domain.Book;
import domain.Product;
import domain.Smartphone;
import domain.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    private final Book firstBook = new Book(1, "Wood", 450, "Sting");
    private final Book secondBook = new Book(2, "Folder", 857, "Sten");
    private final Smartphone firstSmartphone = new Smartphone(3, "F52", 43_520, "Son");
    private final Smartphone secondSmartphone = new Smartphone(4, "F53", 9_999, "Set");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSeveralAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sten");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Folder");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneConstructor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Son");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("F53");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("F52");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBook() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Wood");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneConstructor2() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Set");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Sting");
        Assertions.assertArrayEquals(expected, actual);
    }

}

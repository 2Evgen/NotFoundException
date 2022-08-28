import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

        ProductRepository repository = new ProductRepository();
        Product book = new Book(1, "Жизнь на островах", 1_150, "Эрнест Хемингуэй");
        Product smartphone = new Smartphone(2, "Smart", 125_000, "America");
        Product product = new Product(3, "Sega", 4_850);



    @Test
    void shouldSave() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAll() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(2);
        Product[] expected = {book, product};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.findById(2);
        Product[] expected = {smartphone};
        Product[] actual = repository.findById(2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdOutOfBounds() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }

    @Test
    void shouldRemoveByIdWithExceptions() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(2);
        Product[] expected = {book, product};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
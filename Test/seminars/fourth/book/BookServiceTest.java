package seminars.fourth.book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookRepository bookRepositoryMock;
    private BookService bookService;
    private Book book;

/*Создаем мок обьект */
    public void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    public void findBookByIdTest() {
       /* Создаем ожидаемый id и получаем id книги при вызове метода findBookById() класса BookService.
 */
        when(bookService.findBookById("1")).thenReturn(new Book("1", "Title", "Author"));

        /* Создаем ожидаемый id и получаем id книги при вызове метода findBookById() класса BookService.
         */
        String expectIdBook = "1";
        String actualIdBook = bookService.findBookById("1").getId();

        // Проверяем что у заглушки один раз был вызван метод findById() с аргументом 1
        verify(bookService).findBookById("1");
        // Проверяем что ожидаемый id равен id полученного объекта
        assertEquals(expectIdBook, actualIdBook, "Метод findBookById возвращает другой объект");
    }

    @Test
    void findAllBooksTest() {
        when(bookService.findAllBooks())
                .thenReturn(new ArrayList<>(Arrays.asList(
                        new Book("1"),
                        new Book("2"),
                        new Book("3"),
                        new Book("4")
                )));
        // Задаем ожидаемый размер листа книг и получаем размер листа при вызове метода findAllBooks класса BookService
        int expectedSizeListBooks = 4;
        int actualSizeListBooks = bookService.findAllBooks().size();

        // Проверяем что у заглушки один раз был вызван метод findAll()
        verify(bookService).findAllBooks();
        // Проверяем что размер листа равен полученному
        assertEquals(expectedSizeListBooks,
                actualSizeListBooks,
                "Метод findAllBooks возвращает некорректный список с книгами");
    }

}
package test.butramyou.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.butramyou.library.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}

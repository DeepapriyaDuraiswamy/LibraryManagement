package com.deepa.book.library.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepa.book.library.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}

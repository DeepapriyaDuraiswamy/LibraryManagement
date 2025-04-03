package com.deepa.book.library.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deepa.book.library.entities.HelloEntity;

@Repository
public interface HelloRepository extends JpaRepository<HelloEntity, Long> {

	List<HelloEntity> findAll();

	Optional<HelloEntity> findById(Long id);

	@Query("SELECT t.testColumn1 FROM HelloEntity t")
	List<String> getTableDataWithQuery();
}

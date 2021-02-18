package com.example.sd2020.demo.repository;

import com.example.sd2020.demo.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * Repository-ul folosit de clasa LibraryController pentru implementarea metodelor sale.
 */

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {


}

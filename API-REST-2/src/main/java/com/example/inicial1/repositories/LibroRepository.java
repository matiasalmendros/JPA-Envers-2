package com.example.inicial1.repositories;

import com.example.inicial1.entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository  extends BaseRepository<Libro, Long> {

    List<Libro> findByTituloContainingOrGeneroContaining(String titulo, String genero);

    //Con Pageable
    Page<Libro> findByTituloContainingOrGeneroContaining(String titulo, String genero, Pageable pageable);

    //boolean existsByGenero(String genero);

    //-------------------------------
    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro% OR l.genero LIKE %:filtro%")
    List<Libro> search(@Param("filtro") String filtro);

    //-------------------------------
    @Query(
            value = "SELECT * FROM Libro WHERE Libro.titulo LIKE %:filtro% OR Libro.genero LIKE %:filtro%",
            nativeQuery = true
    )
    List<Libro> searchNative(@Param("filtro") String filtro);

    //Con Pageable
    @Query(
            value = "SELECT * FROM Libro WHERE Libro.titulo LIKE %:filtro% OR Libro.genero LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Libro",
            nativeQuery = true
    )
    Page<Libro> searchNative(@Param("filtro") String filtro, Pageable pageable);

    //-------------------------------
}

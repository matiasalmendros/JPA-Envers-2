package com.example.inicial1.repositories;

import com.example.inicial1.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocalidadRepository  extends BaseRepository<Localidad, Long> {

    List<Localidad> findByDenominacionContaining(String denominacion);

    //Con Pageable
    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    //boolean existsByDenominacion(String denominacion);

    //-------------------------------
    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    List<Localidad> search(@Param("filtro") String filtro);

    //-------------------------------
    @Query(
            value = "SELECT * FROM Localidad l WHERE l.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Localidad> searchNative(@Param("filtro") String filtro);

    //Con Pageable
    @Query(
            value = "SELECT * FROM Localidad l WHERE l.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNative(@Param("filtro") String filtro, Pageable pageable);

    //-------------------------------
}

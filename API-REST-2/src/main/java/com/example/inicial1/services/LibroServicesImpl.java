package com.example.inicial1.services;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LibroServicesImpl extends BaseServiceImpl<Libro,Long> implements LibroService{

    @Autowired
    private LibroRepository libroRepository;


    public LibroServicesImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Libro> search(String filtro) throws Exception {
        try {
            //List<Libro> libros = libroRepository.findByTituloContainingOrGeneroContaining(filtro,filtro);

            //List<Libro> libros = libroRepository.search(filtro);

            List<Libro> libros = libroRepository.searchNative(filtro);

            return libros;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Libro> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Libro> libros = libroRepository.findByNombreContainingOrApellidoContaining(filtro,filtro,pageable));

            //Page<Libro> libros = libroRepository.search(filtro, pageable));

            Page<Libro> libros = libroRepository.searchNative(filtro, pageable);

            return libros;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

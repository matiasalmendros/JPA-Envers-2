package com.example.inicial1.services;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorServicesImpl extends BaseServiceImpl<Autor,Long> implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    public AutorServicesImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {
        try {
            //List<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);

            //List<Autor> autores = autorRepository.search(filtro);

            List<Autor> autores = autorRepository.searchNative(filtro);

            return autores;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro,filtro,pageable));

            //Page<Autor> autores = autorRepository.search(filtro, pageable));

            Page<Autor> autores = autorRepository.searchNative(filtro, pageable);

            return autores;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

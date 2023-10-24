package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService  {

    @Autowired
    private DomicilioRepository domicilioRepository;


    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Domicilio> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<Domicilio> domicilios = domicilioRepository.search(filtro);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Domicilio> domicilios = domicilioRepository.search(filtro, pageable);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

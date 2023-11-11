package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService  {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Empleado> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<Empleado> empleados = empleadoRepository.search(filtro);
            return empleados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Empleado> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Empleado> empleados = empleadoRepository.search(filtro, pageable);
            return empleados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

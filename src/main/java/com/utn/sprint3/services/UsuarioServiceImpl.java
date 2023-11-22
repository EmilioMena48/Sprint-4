package com.utn.sprint3.services;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.*;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Usuario> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<Usuario> clientes = usuarioRepository.search(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Usuario> clientes = usuarioRepository.search(filtro, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<EmpleadoDTO> findByRoles(List<Rol> roles) throws Exception {
        try {
            List<Usuario> empleados = usuarioRepository.findByRoles(roles);
            List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();



            for (Usuario empleadoDB : empleados) {

                Domicilio domicilio = empleadoDB.getDomicilio();
                DomicilioDTO domicilioDTO = new DomicilioDTO(
                        domicilio.getId(),
                        domicilio.getCalle(),
                        domicilio.getNumero(),
                        domicilio.getCodigoPostal(),
                        domicilio.getLocalidad(),
                        domicilio.getDepartamento(),
                        domicilio.getNumeroVivienda(),
                        domicilio.getPisoDto()
                );

                EmpleadoDTO empleadoDTO = new EmpleadoDTO(
                        empleadoDB.getFechaAlta(),
                        empleadoDB.getId(),
                        empleadoDB.getUsername(),
                        empleadoDB.getNombre(),
                        empleadoDB.getApellido(),
                        empleadoDB.getTelefono(),
                        empleadoDB.getEmail(),
                        empleadoDB.getRol(),
                        domicilioDTO
                );
                empleadoDTOS.add(empleadoDTO);
            }

            return empleadoDTOS;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }





        public List<RankingDTO> searchClientePedido() throws Exception {
            try {
                List<Usuario> entities = usuarioRepository.findAll();
                List<RankingDTO> dtos = new ArrayList<>();

                RankingDTO auxdto = new RankingDTO();
                for (Usuario usuario : entities) {
                    auxdto.setId(usuario.getId());
                    auxdto.setUsername(usuario.getUsername());
                    auxdto.setPedido(usuario.getPedidos().size());
                    dtos.add(auxdto);

                }
                return dtos;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }

        }
}

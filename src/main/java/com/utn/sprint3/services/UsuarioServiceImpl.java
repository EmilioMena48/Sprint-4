package com.utn.sprint3.services;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.entidades.UsuarioDTO;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public List<UsuarioDTO> findByRoles(List<Rol> roles) throws Exception {
        try {
            List<Usuario> empleados = usuarioRepository.findByRoles(roles);
            List<UsuarioDTO> usuariosDTO = new ArrayList<>();


            for (Usuario usuarioDB : empleados) {

              /* SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaNacimiento = dateFormat.parse(usuarioDB.getFechaNacimiento());*/

                UsuarioDTO usuarioDTO = new UsuarioDTO(
                        usuarioDB.getId(),
                        usuarioDB.getUsername(),
                        usuarioDB.getPassword(),
                        usuarioDB.getNombre(),
                        usuarioDB.getApellido(),
                        usuarioDB.getTelefono(),
                        usuarioDB.getEmail(),
                        //usuarioDB.getFechaNacimiento(),
                        usuarioDB.getRol()
                );
                usuariosDTO.add(usuarioDTO);
            }

            return usuariosDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



}

package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Roman on 16/10/18.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario save(Usuario usuario);

    Usuario findByUsername(String username);

    Usuario findById(Long id);

    Page<Usuario> findAll(Pageable pageable);

    List<Usuario> findAllByUsername(String username);

    List<Usuario>findAll();

    Optional<Usuario> findByResetToken(String resetToken);

    Optional<Usuario> findByEmail(String email);

    void deleteById(Long id);
}

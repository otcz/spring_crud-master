package Taos.dao;

import TaosBackend.Taos.Modelo.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioDaoImplement implements  UsuarioDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
}

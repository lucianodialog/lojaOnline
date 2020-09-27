package br.com.helpetecnologia.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.helpetecnologia.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepositoryImplementation<Pedido, Integer>{

}

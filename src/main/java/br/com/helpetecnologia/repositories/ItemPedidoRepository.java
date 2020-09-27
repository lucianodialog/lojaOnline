package br.com.helpetecnologia.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.helpetecnologia.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepositoryImplementation<ItemPedido, Integer>{

}

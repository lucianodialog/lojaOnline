package br.com.helpetecnologia.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.domain.Cliente;
import br.com.helpetecnologia.domain.Produto;

public interface ProdutoRepository extends JpaRepositoryImplementation<Produto, Integer>{

}

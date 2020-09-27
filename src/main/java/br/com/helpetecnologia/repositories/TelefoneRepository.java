package br.com.helpetecnologia.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepositoryImplementation<Telefone, Integer>{

}

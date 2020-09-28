package br.com.helpetecnologia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.helpetecnologia.domain.Categoria;
import br.com.helpetecnologia.repositories.CategoriaRepository;
import br.com.helpetecnologia.services.exception.DataIntegrityException;
import br.com.helpetecnologia.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	/*
	public Categoria buscarCategoriaId(int id) {		
		Optional<Categoria> categoria = repo.findById(id);
		return categoria.orElse(null);		
	}
	*/
	
	public List<Categoria> listarTodasCategorias() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Categoria buscarCategoriaId(int id) {		
		Optional<Categoria> categoria = repo.findById(id);	
			return categoria.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));	
	
	}
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return repo.save(categoria);
	}
	
	public Categoria atualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		buscarCategoriaId(categoria.getId());//Chamado para fazer uma verificação se minha categoria existe
		return repo.save(categoria);
	}
	

	public void deleteById(Integer id) {
		buscarCategoriaId(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que tem produtos");//Trata quando tenta excluir uma categoria que tem produtos associados
		}
		
	}
}

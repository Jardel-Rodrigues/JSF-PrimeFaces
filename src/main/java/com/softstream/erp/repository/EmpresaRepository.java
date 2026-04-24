package com.softstream.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.softstream.erp.model.Empresa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	public Empresa findById(Long id) {
		return entityManager.find(Empresa.class, id);
	}
	
	public List<Empresa> pesquisar(String nome) {
		
		String jpql = "from Empresa e where e.nomeFantasia like :nome";
		
		TypedQuery<Empresa> query = entityManager.createQuery(jpql, Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
	}
	
	public Empresa salvar(Empresa empresa) {
		return entityManager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = findById(empresa.getId());
		entityManager.remove(empresa);
	}

}

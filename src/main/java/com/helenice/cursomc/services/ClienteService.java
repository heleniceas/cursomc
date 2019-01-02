package com.helenice.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.helenice.cursomc.domain.Cidade;
import com.helenice.cursomc.domain.Cliente;
import com.helenice.cursomc.domain.Endereco;
import com.helenice.cursomc.domain.enums.TipoCliente;
import com.helenice.cursomc.dto.ClienteDTO;
import com.helenice.cursomc.dto.ClienteNewDTO;
import com.helenice.cursomc.repositories.ClienteRepository;
import com.helenice.cursomc.services.exceptions.DataIntegrityException;
import com.helenice.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + " ,Tipo: " + Cliente.class.getName()));
	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			 throw new DataIntegrityException("Não é possivel excluir, cliente contém referências!");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	
	public Cliente fromDTO( ClienteDTO objDto) {
		return  new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	public Cliente fromDTO( ClienteNewDTO objDto) {
		Cliente cli=  new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
	//Integer id, String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente,  Cidade cidade
		Endereco end = new Endereco(null, objDto.getLogradouro(),objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, null);
		cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3()!=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		
		return cli;
	}

}

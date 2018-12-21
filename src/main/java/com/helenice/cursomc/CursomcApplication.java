package com.helenice.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.helenice.cursomc.domain.Categoria;
import com.helenice.cursomc.domain.Cidade;
import com.helenice.cursomc.domain.Cliente;
import com.helenice.cursomc.domain.Endereco;
import com.helenice.cursomc.domain.Estado;
import com.helenice.cursomc.domain.Produto;
import com.helenice.cursomc.domain.TipoCliente;
import com.helenice.cursomc.repositories.CategoriaRepository;
import com.helenice.cursomc.repositories.CidadeRepository;
import com.helenice.cursomc.repositories.ClienteRepository;
import com.helenice.cursomc.repositories.EnderecoRepository;
import com.helenice.cursomc.repositories.EstadoRepository;
import com.helenice.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//	List<Categoria>	 lista = new ArrayList<Categoria>();
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");

//	lista.add(cat2)
//	lista.add(cat1)

		
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		///////////////////////////////////////////////////////////////////
		
		Estado est1 = new Estado(null, "Minas");
		Estado est2 = new Estado(null, "Sao Paulo");
		Estado est3 = new Estado(null, "Rio");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Rio de Janeiro", est3);
//		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3, c4));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "37294137838", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("55135684","953570422"));
	
		Endereco end1 = new Endereco(null, "Rua das Flores", "300", "Apartamento 303", "Jardim", "05854180", cli1, c2);
		Endereco end2 = new Endereco(null, "Avenida Matos", "100", "casa", "centro", "05854180", cli1, c1);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		

	}
}

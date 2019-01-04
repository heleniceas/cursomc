package com.helenice.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.helenice.cursomc.domain.Categoria;
import com.helenice.cursomc.domain.Cidade;
import com.helenice.cursomc.domain.Cliente;
import com.helenice.cursomc.domain.Endereco;
import com.helenice.cursomc.domain.Estado;
import com.helenice.cursomc.domain.ItemPedido;
import com.helenice.cursomc.domain.Pagamento;
import com.helenice.cursomc.domain.PagamentoComBoleto;
import com.helenice.cursomc.domain.PagamentoComCartao;
import com.helenice.cursomc.domain.Pedido;
import com.helenice.cursomc.domain.Produto;
import com.helenice.cursomc.domain.enums.EstadoPagamento;
import com.helenice.cursomc.domain.enums.Perfil;
import com.helenice.cursomc.domain.enums.TipoCliente;
import com.helenice.cursomc.repositories.CategoriaRepository;
import com.helenice.cursomc.repositories.CidadeRepository;
import com.helenice.cursomc.repositories.ClienteRepository;
import com.helenice.cursomc.repositories.EnderecoRepository;
import com.helenice.cursomc.repositories.EstadoRepository;
import com.helenice.cursomc.repositories.ItemPedidoRepository;
import com.helenice.cursomc.repositories.PagamentoRepository;
import com.helenice.cursomc.repositories.PedidoRepository;
import com.helenice.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	
	@Autowired
	private PedidoRepository pedidosRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//	List<Categoria>	 lista = new ArrayList<Categoria>();
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		Categoria cat3= new Categoria(null, "aaaaa");
		Categoria cat4= new Categoria(null, "jeferson");
		Categoria cat5= new Categoria(null, "helenice");
		Categoria cat6= new Categoria(null, "bababba");
		Categoria cat7= new Categoria(null, "basddsbabba");

//	lista.add(cat2)
//	lista.add(cat1)

		
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 90.00);
		Produto p4 = new Produto(null, "Mesa de Escritorio",300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "Tv true color", 1900.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
	
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3, p4,p5,p6, p7,p8,p9, p10, p11));
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
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "37294137838", TipoCliente.PESSOA_FISICA, bCryptPasswordEncoder.encode("senha"));
		
		cli1.getTelefones().addAll(Arrays.asList("55135684","953570422"));
		
		Cliente cli2 = new Cliente(null, "Ana Silva", "ana_gama@gmail.com", "85809296017", TipoCliente.PESSOA_FISICA, bCryptPasswordEncoder.encode("senha"));
		cli2.getTelefones().addAll(Arrays.asList("36554552","953689548"));
		cli2.addPerfil(Perfil.ADMIN);
		
	
		Endereco end1 = new Endereco(null, "Rua das Flores", "300", "Apartamento 303", "Jardim", "05854180", cli1, c2);
		Endereco end2 = new Endereco(null, "Avenida Matos", "100", "casa", "centro", "05854180", cli1, c1);
		Endereco end3 = new Endereco(null, "Avenida Jaguare", "2106", "casa", "lapa", "05832189", cli2, c1);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		cli2.getEnderecos().addAll(Arrays.asList(end3));
		clienteRepository.save(cli1);
		clienteRepository.save(cli2);
		enderecoRepository.saveAll(Arrays.asList(end1,end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1  = new Pedido(null, sdf.parse("30/09/2017 10:32"),  cli1, end1);
		Pedido ped2  = new Pedido(null, sdf.parse("10/10/2018 19:35"),  cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6); 
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		
		pedidosRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.0, 1, 800.00);
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}

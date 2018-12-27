package com.helenice.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helenice.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}

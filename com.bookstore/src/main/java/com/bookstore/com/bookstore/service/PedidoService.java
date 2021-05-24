package com.bookstore.com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.com.bookstore.model.Pedido;
import com.bookstore.com.bookstore.repository.PedidoRepository;

/**
 * 
 * @author NPG (nome dado a equipe que esta desenvolvendo esse sistema)
 * Essa classe é reposnsável por métodos de CRUD sobre o Pedido
 *
 *
 */
@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void salvarPedido(Pedido pedido) {
		
		pedidoRepository.save(pedido);
	}
	
	public Pedido recuperarPeloCodigo(Long id) {
		
		return pedidoRepository.findById(id).get();
	}

}

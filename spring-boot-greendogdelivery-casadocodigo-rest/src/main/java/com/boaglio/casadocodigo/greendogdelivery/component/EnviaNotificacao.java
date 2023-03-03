package com.boaglio.casadocodigo.greendogdelivery.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boaglio.casadocodigo.greendogdelivery.domain.Cliente;
import com.boaglio.casadocodigo.greendogdelivery.domain.Pedido;
import com.boaglio.casadocodigo.greendogdelivery.dto.Notificacao;

@Component
public class EnviaNotificacao {

	@Autowired
	Notificacao notificacao;
	
	public void enviaEmail(Cliente cliente, Pedido pedido) {
		if (notificacao.envioAtivo()) {
			/* código de envio */
			System.out.println("Notificação enviada");
		} else {
			System.out.println("Notificação desligada");
		}
	}
}

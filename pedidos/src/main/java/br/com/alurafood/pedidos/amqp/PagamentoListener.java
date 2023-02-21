package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentoDto;

@Component
public class PagamentoListener {

	@RabbitListener(queues = "pagamentos.detalhes-pedidos")
	public void recebeMensagem(PagamentoDto pagamento) {
		String mensagem = """
				Cliente: %s
				Dados do pagamento: %s
				Número do pedido: %s
				Valor R$: %s
				Status: %S
				""".formatted(
						pagamento.getNome(),
						pagamento.getId(), 
						pagamento.getPedidoId(), 
						pagamento.getValor(),
						pagamento.getStatus());
		System.out.println("Recebi a mensagem " + mensagem);
	}
}

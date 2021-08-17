package modelVO;
import java.util.*;

public class PedidoVO {
  private Date dataPedido;
  
  //Data do Pedido
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		dataPedido = new Date();
		this.dataPedido = dataPedido;
	}

}

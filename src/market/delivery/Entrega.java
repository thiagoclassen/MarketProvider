package market.delivery;

import java.util.ArrayList;
import java.util.Date;

import market.order.Order;

public class Entrega {
	
	private ArrayList<Veiculo> veiculos;
	
	public Entrega(){
		veiculos = VeiculoDaoImp.getInstance().getAllVeiculos();
		verificaVeiculos();
	}
	
	private void verificaVeiculos(){
		for(Veiculo veiculo:veiculos){
			if(veiculo.getEntrega()!=null && veiculo.getEntrega().compareTo(new Date())<0){
				veiculo.setEntrega(null);
				VeiculoDaoImp.getInstance().updateVeiculo(veiculo);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public Veiculo alocarEntrega(Order order){
		for(Veiculo veiculo:veiculos){
			if(veiculo.getEntrega()==null){
				Date data = new Date();
				data.setHours(23);
				data.setMinutes(59);
				data.setSeconds(59);
				veiculo.setEntrega(data);
				VeiculoDaoImp.getInstance().updateVeiculo(veiculo);
				return veiculo;
			}
		}
		return null;
	}

}

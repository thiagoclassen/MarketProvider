package market.delivery;

import java.util.ArrayList;


public interface VeiculoDao {
	
	public ArrayList<Veiculo> getAllVeiculos();
	public void addVeiculo(Veiculo veiculo);
	public void updateVeiculo(Veiculo veiculo);
	public void deleteVeiculo(Veiculo veiculo);

}

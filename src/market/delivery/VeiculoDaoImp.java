package market.delivery;

import java.util.ArrayList;

import market.data.FileManager;

public class VeiculoDaoImp implements VeiculoDao {

	private static ArrayList<Veiculo> veiculos;

	private static VeiculoDaoImp instance = null;

	public static VeiculoDaoImp getInstance() {

		if (instance == null) {
			instance = new VeiculoDaoImp();
			veiculos = FileManager.loadVeiculos();
		}
		return instance;
	}

	@Override
	public ArrayList<Veiculo> getAllVeiculos() {
		return veiculos;
	}

	@Override
	public void addVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
		writeVeiculos();
	}

	@Override
	public void updateVeiculo(Veiculo veiculo) {
		// TODO - throw error if the client doesn't exists
		int pos = veiculos.indexOf(veiculo);
		if (pos != -1) {
			veiculos.set(pos, veiculo);
			writeVeiculos();
		}
	}

	@Override
	public void deleteVeiculo(Veiculo veiculo) {
		// TODO - throw error if the client doesn't exists
		int pos = veiculos.indexOf(veiculo);
		if (pos != -1) {
			veiculos.remove(pos);
			writeVeiculos();
		}
	}

	private void writeVeiculos() {
		FileManager.writeVeiculos(veiculos);
	}

}

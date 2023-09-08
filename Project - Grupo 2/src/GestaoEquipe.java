import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestaoEquipe {
	public String[] leValores(String[] dadosIn) {
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}
	
	public Perifericos lePerifericos() {
		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Codigo", "Marca", "Tipo Periferico" };
		valores = leValores (nomeVal);

		Perifericos peri = new Perifericos (valores[0],valores[1],valores[2], valores[3]);
		return peri;
	}
	
	public Hardware leHardware() {
		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Codigo", "Marca", "Tipo Hardware" };
		valores = leValores (nomeVal);

		Hardware hard = new Hardware (valores[0],valores[1],valores[2], valores[3]);
		return hard;
		
	}
	
	public Vestuario leVestuario() {
		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Codigo", "Marca", "Tipo Vestuario" };
		valores = leValores (nomeVal);

		Vestuario vest = new Vestuario (valores[0],valores[1],valores[2], valores[3]);
		return vest;
		
	}
	
	public void mostraEquipamento(String dados) {
		JOptionPane.showMessageDialog(null,"PRODUTO\n-------\n +" +dados);
	}
	
	public void salvaEquipamentos(ArrayList<Equipamento>equipamentos) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream
					(new FileOutputStream("gestao.dat"));
			for (int i=0; i < equipamentos.size(); i++)
				outputStream.writeObject(equipamentos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Equipamento>recuperaEquipamentos(){
		ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream
					(new FileInputStream("gestao.dat"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Equipamento) {
					equipamentos.add((Equipamento) obj);
				}
			}
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("End of file reached.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com equipamentos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return equipamentos;
		}
	}
	
	public void menuEquipamentos() {

		ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();


		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Gestao da equipe\n" +
					"Opções:\n" +
					"1. Entrada de dados\n" +
					"2. Exibir dados\n" +
					"3. Limpar dados\n" +
					"4. Gravar dados\n" +
					"5. Recuperar dados\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");

			while (!numeroInteiroValido(entrada)) {
				entrada = JOptionPane.showInputDialog(null, menu +
						"\n\nEntrada inválida! Digite um número inteiro.");
			}
			opc1 = Integer.valueOf ( entrada );

			switch (opc1) {
				case 1:// Entrar Equipamentos
					menu = "Registrar Equipamentos\n" +
							"Opções:\n" +
							"1. Hardware\n" +
							"2. Vestuario\n" +
							"3. Perifericos\n";

					entrada = JOptionPane.showInputDialog (menu + "\n\n");
					while (!numeroInteiroValido(entrada)) {
						entrada = JOptionPane.showInputDialog(null, menu +
								"\n\nEntrada inválida! Digite um número inteiro.");
					}
					opc2 = Integer.valueOf ( entrada );

					switch (opc2){
							case 1: equipamentos.add((Equipamento) leHardware ());
								break;
							case 2: equipamentos.add((Equipamento) leVestuario ());
								break;
							case 3: equipamentos.add((Equipamento) lePerifericos ());
								break;
							default:
							JOptionPane.showMessageDialog(null,"Produto para entrada NÃO escolhido!");
					}
					break;
				case 2: // Exibir Equipamentos
					if (equipamentos.size() == 0) {
						JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
						break;
					}
					String dados = "";
					for (int i=0; i < equipamentos.size(); i++)	{
						dados += equipamentos.get(i).toString() + "\n";
					}
					JOptionPane.showMessageDialog(null,dados);
					break;
				case 3: // Limpar Equipamentos
					if (equipamentos.size() == 0) {
						JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
						break;
					}
					equipamentos.clear();
					JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
					break;
				case 4: // Grava Equipamentos
					if (equipamentos.size() == 0) {
						JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
						break;
					}
					salvaEquipamentos (equipamentos);
					JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
					break;
				case 5: // Recupera Equipamentos
					equipamentos = recuperaEquipamentos ();
					if (equipamentos	.size() == 0) {
						JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
						break;
					}
					JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
					break;
				case 9:
					JOptionPane.showMessageDialog(null,"Fim do aplicativo de gestao para equipes de e-sport");
					break;
			}
		} while (opc1 != 9);
	}

	private boolean numeroInteiroValido(String s) {
		boolean resultado;
		try {
			Integer.parseInt(s);
			resultado = true;
		} catch (NumberFormatException e) {
			resultado = false;
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		GestaoEquipe gest = new GestaoEquipe ();
		gest.menuEquipamentos ();
	}

}

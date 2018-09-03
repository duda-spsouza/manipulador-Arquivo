package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	private static List<String> arcformated = new ArrayList<String>();

	public static void CarregaDados(String file) {
		BufferedReader br;
		//"%HOMEPATH%\\data\\in"
		//C:\Users\Duda\data\in
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Duda\\data\\in\\" + file));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				if (linha.contains("001�")) {
					String[] aux = linha.split("001�");
					for (int i = 1; i < aux.length; i++) {
						arcformated.add("001�" + aux[i]);
					}
				} else if (linha.contains("002�")) {
					String[] aux = linha.split("002�");
					for (int i = 1; i < aux.length; i++) {
						arcformated.add("002�" + aux[i]);
					}
				} else if (linha.contains("003�")) {
					String[] aux = linha.split("003�");
					for (int i = 1; i < aux.length; i++) {
						arcformated.add("003�" + aux[i]);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Arquivo de Input nao encontrado.");
		}
	}

	public static List<String> getArcFormated() {
		return arcformated;
	}
}

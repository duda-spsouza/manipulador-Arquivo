package com.manipulador.arq.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.manipulador.arq.util.Config;

public class Reader {
	private static List<String> arcformated = new ArrayList<String>();

	public static void CarregaDados(String file) {
		BufferedReader br;
		Config  config = new Config();
		try {
			br = new BufferedReader(new FileReader(config.PATH_ENTRADA+"\\" + file));
			String linha = "";
			while ((linha = br.readLine()) != null) {
				if (linha.contains("001ç")) {
					String[] aux = linha.split("001ç");
					for (int i = 1; i < aux.length; i++) {
						arcformated.add("001ç" + aux[i]);
					}
				} else if (linha.contains("002ç")) {
					String[] aux = linha.split("002ç");
					for (int i = 1; i < aux.length; i++) {
						arcformated.add("002ç" + aux[i]);
					}
				} else if (linha.contains("003ç")) {
					String[] aux = linha.split("003ç");
					for (int i = 1; i < aux.length; i++) {
						arcformated.add("003ç" + aux[i]);
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

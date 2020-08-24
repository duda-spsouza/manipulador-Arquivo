package com.manipulador.arq.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
	
	public static final Path PATH_ENTRADA = Paths.get(System.getProperty("user.home") + "\\data\\in\\");
	public static final Path PATH_SAIDA = Paths.get(System.getProperty("user.home") + "\\data\\out\\");

}

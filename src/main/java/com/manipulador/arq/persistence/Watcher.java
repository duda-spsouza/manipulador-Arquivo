package com.manipulador.arq.persistence;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;

import com.manipulador.arq.util.Config;

public class Watcher {
	public void watchDirectory() {
		Config  config = new Config();
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path diretorio = config.PATH_ENTRADA;
			diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			System.out.println("Aguardando Arquivo .dat no diretório:"+diretorio);
			while (true) {
				WatchKey key = watcher.take();
				Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
				Path path = (Path) watchEvent.get().context();
				if (path.toString().endsWith(".dat")) {
					System.out.println("Carregando/Lendo Arquivo...");
					Reader.CarregaDados(path.toString());
					Writer writer = new Writer();
					System.out.println("Escreve Arquivo...");
					writer.createFileWithResult();
				}
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
			watcher.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}

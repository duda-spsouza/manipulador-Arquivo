package persistence;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;

public class Watcher {
	public void watchDirectory() {
				//"%HOMEPATH%\\data\\in"
				//C:\\Users\\Duda\\data\\in
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path diretorio = Paths.get("C:\\Users\\Duda\\data\\in\\");
			diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			while (true) {
				WatchKey key = watcher.take();
				Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
				Path path = (Path) watchEvent.get().context();
				if (path.toString().endsWith(".dat")) {
					Reader.CarregaDados(path.toString());
					Writer writer = new Writer();
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

package main;
import persistence.*;

public class Main {
	public static void main(String[] args) {
		Watcher watcher = new Watcher();
		watcher.watchDirectory();
	}
}

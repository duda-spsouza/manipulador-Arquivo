package com.manipulador.arq.principal;

import com.manipulador.arq.persistence.Watcher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Watcher watcher = new Watcher();
		watcher.watchDirectory();
    }
}

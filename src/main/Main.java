package main;

import java.util.List;

import utils.AccessFile;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccessFile access = new AccessFile();
		
		List<String> list = access.reader("data/graph_demo.txt");
		System.out.println("Lecture finie, résultat :");
		System.out.println(list);

	}

}

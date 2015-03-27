package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AccessFile {
	public List<Integer> listVertex = new ArrayList<Integer>();
	public List<int[]> listEdges = new ArrayList<int[]>();
	
	public void reader (String path) {
		try{
			InputStream ips=new FileInputStream(path); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			String[] tab = null;
			while ((line=br.readLine())!=null) {
				System.out.println(line);
				tab = line.split(" ");
				if (tab.length%2 == 0) 
					throw new Exception("incomplet file"); // Create the exception
				listVertex.add(Integer.parseInt(tab[0]));
				for (int i = 1; i < tab.length-2; i++) {
					int[] t = new int[2];
					t[0] = Integer.parseInt(tab[i++]); 
					t[1] = Integer.parseInt(tab[i]);
					listEdges.add(t);
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return ;
	}

	public void writer (String file) {
		try {
			FileWriter fw = new FileWriter(file) ;
			BufferedWriter bw = new BufferedWriter(fw) ;
			PrintWriter outputFile = new PrintWriter(bw) ; 
			for (Integer vertex : listVertex) {
				List<int[]> listEdges = Parser.getEdges(vertex);
				String s = vertex + "" ;
				for (int[] t : listEdges)
					s += " " + t[0] + " " + t[1];
				outputFile.println(s) ;
			}
			outputFile.close() ;
			System.out.println(file + " a été créé") ; 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
}

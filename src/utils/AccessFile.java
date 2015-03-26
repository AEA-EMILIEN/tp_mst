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
	
	public List<String> reader (String path) {
		List<String> list = new ArrayList<String>();
		try{
			InputStream ips=new FileInputStream(path); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			while ((line=br.readLine())!=null) {
				System.out.println(line);
				list.add(line);
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return list;
	}

	public void writer (List<String> list, String file) {
		try {
			FileWriter fw = new FileWriter(file) ;
			BufferedWriter bw = new BufferedWriter(fw) ;
			PrintWriter fichierSortie = new PrintWriter(bw) ; 
			for (String s : list)
				fichierSortie.println(s) ;
			fichierSortie.close() ;
			System.out.println(file + " a été créé") ; 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
}

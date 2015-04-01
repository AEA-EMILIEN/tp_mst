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
			BufferedReader br=new BufferedReader(ipsr,100000);
			String line;
			String[] tab = null;
			while ((line=br.readLine())!=null) {
				tab = line.split(" ");
				if (tab.length%2 == 0) 
					throw new Exception("incomplet file"); // Create the exception
				if (! listVertex.contains(Integer.parseInt(tab[0])))
					listVertex.add(Integer.parseInt(tab[0]));
				for (int i = 1; i < tab.length; i+=2) {
					if (! listVertex.contains(Integer.parseInt(tab[i])))
						listVertex.add(Integer.parseInt(tab[i]));
					int[] t = new int[3];
					t[0] = Integer.parseInt(tab[0]);
					t[1] = Integer.parseInt(tab[i]);
					t[2] = Integer.parseInt(tab[i+1]);
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

	public void writer (String sg,String file) {
		try {
			FileWriter fw = new FileWriter(file,false) ;
			BufferedWriter bw = new BufferedWriter(fw,100000) ;
			PrintWriter outputFile = new PrintWriter(bw) ; 
			
			String[] sa = sg.split("\n");
			StringBuilder sb = new StringBuilder(sa.length*5);
			for(String s : sa)
			{
				if(s.length()>=5)
				{	
					sb.append(s);
					sb.append("\n");
				}
			}
			
			sb.deleteCharAt(sb.length()-1);
			
			outputFile.print(sb.toString()) ;
			
			outputFile.close() ;
			System.out.println(file + " a été créé") ; 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
}

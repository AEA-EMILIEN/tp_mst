package structure;

import java.util.ArrayList;

public class Graphe {
	
	
	public ArrayList<Noeud> sommets;
	public int nbSommets;
	
	
	/**
	 * Classe interne noeud
	 * 
	 *
	 */
	protected class Noeud {
		
		public int value;
		public ArrayList<Noeud> succ;
		public int nbSucc;
		
		protected Noeud()
		{
			this.value = -1;
			this.succ = null;
			this.nbSucc = 0;
		}
		
		protected Noeud(int val,ArrayList<Noeud> succ)
		{
			this.value = val;
			this.succ = succ;
			if (this.succ!=null)
				this.nbSucc = succ.size();
			else 
				this.nbSucc = 0;
		}
		
		protected String toString(int n)
		{
			String s = "";
			StringBuffer sb = new StringBuffer(100);
			 
			for(int i=0;i<this.nbSucc;i++)
			{
				int succ = this.succ.get(i).value; //HMMMMMMMMM je renvoi un noeud alors que probablement je veux le numero du noeud
				if(n>succ)
					sb.append(succ);
			}
			
			return s;
		}
		
	}
	
	public Graphe()
	{
		this.sommets = new ArrayList<Noeud>(20);
		this.nbSommets = 0;
	}
	
	public Graphe(ArrayList<Noeud> sommets)
	{
		this.sommets = sommets;
		this.nbSommets = this.sommets.size();
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer(1000);
		String s = "";
		
		
		for(int i=0;i<this.nbSommets;i++)
		{
			sb.append(i);
			sb.append(this.sommets.get(i).toString());
		}
		
		s = sb.toString();
		
		return s;
	}
	
}

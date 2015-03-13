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
	}
	
	public Graphe()
	{
		this.sommets = new ArrayList<>(20);
		this.nbSommets = 0;
	}
	
	public Graphe(ArrayList<Noeud> sommets)
	{
		this.sommets = sommets;
		this.nbSommets = this.sommets.size();
	}
	
	
	
}

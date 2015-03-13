package structure;

import java.util.ArrayList;
import java.util.Random;

public class Erdos extends Graphe {

	//0<=p<=1, par defaut vaudra 1
	public double p;
	
	
	public Erdos()
	{
		super();
		this.p=1;
	}
	
	
	public Erdos(int nbSommets, double p)
	{
		this.sommets = new ArrayList<Noeud>(nbSommets);
		this.nbSommets = nbSommets;
		
		if (p<0 || p>1)
			throw new Error("valeur de p érroné, p doit etre compris entre 0 et 1 ");
		else
			this.p = p;
		
		initErdos();
		
	}
	
	public void initErdos()
	{
		//on crée tous les sommets vides
		for(int i=0;i<this.nbSommets;i++)
		{
			this.sommets.add(i,new Noeud(i,new ArrayList<Noeud>(this.nbSommets)));
		}
		
		//et on crée les aretes
		for (int i=0;i<this.nbSommets;i++)
		{
			Noeud n = this.sommets.get(i);
		//	n.succ.add()
		}
		
		Random r = new Random();
		double num = r.nextDouble();
	}
}


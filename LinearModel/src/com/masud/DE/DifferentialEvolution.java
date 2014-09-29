package com.masud.DE;

import java.util.Random;

import com.masud.Control.WorkThrough;
import com.masud.Model.Model;

public abstract class DifferentialEvolution {

	public static int [] pickAgents(int j)
	{
		Random r = new Random();
		int [] it = new int[4];
		int i,cur;
		
		boolean b=true;
        i=0;
        it[i++] = j;
        while(i<4)
        {                
            cur = r.nextInt(79-0);
            for(int k=0;k<i;k++)
            {
                if(cur == it[k]) {b=false;}
            }
            if(b == true) { it[i++] = cur;}
        }
        
        for(int z=0;z<it.length;z++)
        {
            System.out.print(it[z]+"  ");
        }
        System.out.println();
    
		
		
		return it;
	}
	
	public static double fitnessFunction(double[][] geneNet)
	{
		double MSE=0;
		for(int row=0;row<5;row++)
		{
			for(int t=0;t<5;t++)
			{
				MSE+=Math.pow(((geneNet[row][t]-WorkThrough.xj[row][t])/WorkThrough.xj[row][t]),2);
			}
		}
		return MSE;
	}
	public static void DiffEv()
	{
		Random r = new Random();
		int i,j,k,R;
		double ri,CR=0.8,U,F;
		int [] agents = new int[4];
		double [][] newWeight = new double[5][5];
		double [][] newGeneNetwork = new double[5][5];
		double [][] oldGeneNetwork = new double[5][5];
		
		for(i=0;i<80;i++)
		{
			agents = pickAgents(i);
			R = r.nextInt(80-0);
			int a = agents[1];
			int b = agents[2];
			int c = agents[3];
			F = r.nextDouble();
			for(j=0;j<5;j++)
			{
				for(k=0;k<5;k++)
				{
					ri = r.nextDouble();
					if(ri<CR)
					{
						newWeight[j][k] = WorkThrough.weightMatrix1[a] [j] [k]+ F *(WorkThrough.weightMatrix1[b] [j] [k]-WorkThrough.weightMatrix1[c] [j] [k]);
					}
					else
					{
						newWeight[j][k] = WorkThrough.weightMatrix1[i] [j] [k];
					}
				}
				
				//Generate new Network for new weight
				Model.getWeight(newWeight,0); // Set the weight to calculate new gene network using model
				newGeneNetwork=Model.implementModel(i);  // Generate new network for the new weight
				
				for(int l=0;l<5;l++)
				{
					System.arraycopy(WorkThrough.netMatrixs[i][0], 0, oldGeneNetwork[l], 0, 5);	
				}
				
				// Comparing Through MSE
				if(fitnessFunction(newGeneNetwork)<fitnessFunction(oldGeneNetwork))//Place old network value in 5.5
				{
					//Replace Weighted Matrix
					for(int l=0;l<5;l++)
					{
						System.arraycopy(newWeight[l], 0, WorkThrough.weightMatrix1[i][l], 0, 5);	
					}
				}
			}
		}
	}
}

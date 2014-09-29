package com.masud.Model;

import com.masud.Control.WorkThrough;

public abstract class Model {
	
	public static double[][] weight = new double[5][5];
	public static void getWeight(double[][] w,int thWeifht)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				weight[i][j] = w[i][j];
			}
		}
	}
	
    public static double[][] implementModel(int thWeifht)
    {
    	double[][] xi = new double[5][5];
        for(int i=1;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
            	xi[i][j] = WorkThrough.xj[i-1][j]*weight[i-1][j]; 
            }
        }
        return xi;
    }
}

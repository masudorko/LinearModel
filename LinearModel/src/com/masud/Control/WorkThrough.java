package com.masud.Control;

public class WorkThrough {
	
	 public static double[][][] weightMatrix1 = new double[80][5][5];
	 public static double[][][] netMatrixs = new double[80][5][5];
	 public double [][] xi = new double[5][5];
	 public static double [][] xj = new double[5][5];
	   
	   void initializeXj(double [][] y,int r, int c)
	   {
	       for(int i=0;i<1;i++)
	       {
	           System.arraycopy(y[i], 0, xj[i], 0, c);
	       }
	   }
	   /* Generating Weight matrix*/
	   public void generateMatrix()
	   {
	       //Random r = new Random();
	       for(int i=0;1<80;i++) //80 matrix
	       {
	           for(int j=0;j<5;j++) // Each 4 rows in a matrix
	           {
	               for(int k=0;k<5;k++)
	               {
	                   try{
	                       weightMatrix1[i][j][k]= (-5 + (Math.random() * ((10 - (-5)) + 1)));
	                   System.out.println("i : "+i+" j : "+j+" k : "+k+"  "+weightMatrix1[i][j][k]);
	                   }
	                   catch(ArrayIndexOutOfBoundsException ex)
	                   {
	                       break;
	                   }
	               }
	               
	           }
	           
	       }
	   }
	   
	   public static void main(String args[])
	   {
	       WorkThrough wrk = new WorkThrough();
	       wrk.generateMatrix();
	       
	       
	   }

}

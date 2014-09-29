package com.masud.Test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][][] x = new int[5][5][5];
		int [][] y = new int[5][5];		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<5;k++)
				{
					x[i][j][k] = i+1;
				}
			}
		}
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<5;k++)
				{
					System.out.print(x[i][j][k]);;
				}
				System.out.println();
			}
		}
		
		
		for(int l=0;l<5;l++)
		{
			for(int m=0;m<5;m++)
			{
				y[l][m] = 99;
			}	
		}
		
		for(int l=0;l<5;l++)
		{
		//	for(int m=0;m<5;m++)
			{
				System.arraycopy(x[0][l], 0, y[l], 0, 5);
			}	
		}
		
		System.out.println("=============Printin y==============");
		
		for(int l=0;l<5;l++)
		{
			for(int m=0;m<5;m++)
			{
				System.out.print(y[l][m]+"  ");
			}	
			System.out.println();
		}
	}

}

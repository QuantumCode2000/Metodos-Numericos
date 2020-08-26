package Interpolacion;

import java.util.Scanner;

public class DifDiv 
{
	int n,n1;
	Double[] x;
	Double[][] Fx;
	Scanner leer=new Scanner(System.in);
	
	public DifDiv(){}
	
	
	
	public void llenar()
	{	System.out.println("numero de datos:");
		n1=n=Leer.datoInt();
		Fx=new Double[n][n];
		x=new Double[n];
		System.out.println("ingrese los datos");
		System.out.println("  X |  F(x)");
		for(int i=0;i<n;i++)
		{
			x[i]=leer.nextDouble();
			Fx[i][0]=leer.nextDouble();
		}
	}
	
	public void grado(int g)
	{
		n--;
		for(int i=0;i<n;i++)
		{
			Fx[i][g]=(Fx[i+1][g-1]-Fx[i][g-1])/(x[i+g]-x[i]);
		}
	}
	
	public void Difv()
	{
		for(int i=0;i<n1;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(Fx[j][i]+"|");
			}
			System.out.println("grado:"+i);
			grado(i+1);
		}
	}
	
	public void Newton()
	{
		System.out.print("P"+n1+"(x)= ");
		for(int i=0;i<n1;i++)
		{
			System.out.print(Fx[0][i]);
			for(int j=0;j<i;j++)
			{
				System.out.print("(x-"+x[j]+")");
			}
			System.out.println(" + ");
		}
		System.out.println();
	}
	
	public void eval()
	{
		System.out.println("ingrese valor a evaluar:");
		Double y=Leer.datoDouble();
		Double aux,re=0.0;
		System.out.print("P"+n1+"(x)= ");
		for(int i=0;i<n1;i++)
		{
			aux=Fx[0][i];
			for(int j=0;j<i;j++)
			{
				aux=aux*(y-x[j]);
			}
			re=re+aux;
		}
		System.out.println(re);
	}
	
	
	public void operar()
	{
				 llenar();
				 System.out.println("Diferencias Divididas");
				 Difv();n=n1; 
				 System.out.println();
				 System.out.println("Neton por diferencias finitas");
				 Newton();
				 
				 System.out.println("�valuar? [SI(si)/NO(cualquier tecla)]");
					String s=leer.next();
					boolean o;
					if(s.compareTo("si")==0)
					{
						o=true;
					}
					else
					{
						o=false;
					}
				while(o)
				{
				 eval(); 			
				 System.out.println("continuar? [SI(si)/NO(cualquier tecla)]");
					s=leer.next();
					
					if(s.compareTo("si")==0)
					{
						o=true;
					}
					else
					{
						o=false;
					}
				}
		
	}
	
	

}

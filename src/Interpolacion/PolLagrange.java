package Interpolacion;

import java.util.Scanner;

public class PolLagrange 
{
	Double[] A,x,Fx;
	int grado,n;
	Scanner leer=new Scanner(System.in);
	
	public PolLagrange(){}
	
	public Double f(Double a)
	{
		Double f=0.0;
		for(int i=0;i<n;i++)
		{
			
		}
		return f=0.0;
	}

	public void llenar()
	{	System.out.println("numero de datos:");
		n=Leer.datoInt();
		x=new Double[n];
		Fx=new Double[n];
		System.out.println("ingrese los datos");
		System.out.println("  F(x) |    x");
		for(int i=0;i<n;i++)
		{
			Fx[i]=leer.nextDouble();
			x[i]=leer.nextDouble();
		}
	}
	
	public void grado()
	{
		System.out.println("Ingrese el grado del polinomio");
		grado=Leer.datoInt();
		A=new Double[grado];		
	}
	
	public void coef()
	{
		for(int i=0;i<grado;i++)
		{
			A[i]=Fx[i];
			for(int j=0;j<grado;j++)
			{	
				if(i!=j)
				{
				A[i]=A[i]/(x[i]-x[j]);
				}
			}
		}
	}
	
	public void lagrange()
	{
		coef();
		System.out.print("P"+grado+"(X)=");
		for(int i=0;i<grado;i++)
		{
			System.out.print(A[i]);
			for(int j=0;j<grado;j++)
			{
				if(i!=j)
				{
					System.out.print("*(x-"+x[j]+")");
				}
			}
			System.out.println(" + ");
		}
		System.out.println();
	}
	
	public void eval()
	{
		System.out.print("x=");
		Double y=Leer.datoDouble();
		Double ev=0.0;
		Double re=0.0;
		for(int i=0;i<grado;i++)
		{
			ev=A[i];
			for(int j=0;j<grado;j++)
			{
				if(i!=j)
				{
					ev=ev*(y-x[j]);
				}
			}
			re=re+ev;
		}
		System.out.println(re);
	}
	
	
	public void Operacion()
	{
				llenar(); 
				grado();  
				lagrange();
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

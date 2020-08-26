package Interpolacion;

import java.util.Scanner;

public class Simple 
{
	Double[][] A;
	Double[] B,X;
	int n;
	Scanner leer=new Scanner(System.in);
	public Simple()
	{
		System.out.println("ingrese el numero de constantes a encontrar");
		n=Leer.datoInt();
		
		A=new Double[n][n];
		B=new Double[n];
		X=new Double[n];
	}
	
	public void llenar()
	{
		Double Ax;
		Double Bx;
		System.out.println("Px[] |  X");
		for(int i=0;i<n;i++)
		{
		Bx=leer.nextDouble();
		B[i]=Bx;
		Ax=leer.nextDouble();
		for(int j=0;j<n;j++)
		{
			A[i][j]=Math.pow(Ax,j);
		}
		
		}
	}
	
	public void operaciones() 
	{
		boolean o=true;
		Double q,r;
		llenar();
		X=OpMat.encX(A, B);
		System.out.println();
		System.out.println("forma: A * X = B");
		System.out.println();
		System.out.println("Matriz A(variables)");
		OpMat.mostrar(A);
		System.out.println("Vector B(resultados)");
		OpMat.mostrar(B);
		System.out.println("vector X(constantes)");
		OpMat.mostrar(X);
		
		System.out.print("Y = ");
		for(int i=0;i<n;i++)
		{ 
			System.out.println(X[i]+"(x^"+(i+1)+") +");
		}
		
		System.out.println();
		System.out.println("�valuar? [SI(si)/NO(cualquier tecla)]");
		String s=leer.next();
		
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
			System.out.println("ingrese x");
			q=Leer.datoDouble();
			r=0.0;
		for(int i=0;i<n;i++)
			{
			r=r+Math.pow(q,i)*X[i];
			}
		System.out.println("Px: "+r);
		
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

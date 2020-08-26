package Multivariante;

import Funcion.*;

public class NewtonRapsonM
{
	Double[][] mt;
	Double[] vc;
	Funcion f1,f2,f1dx,f1dy,f2dx,f2dy;
	
	public NewtonRapsonM()
	{
		mt=new Double[2][2];
		vc=new Double[2];
		String s;
		System.out.println("funcion 1");
		s=Leer.dato();
		f1=new Funcion(s);
		System.out.println("funcion 1 derivado en x");
		s=Leer.dato();
		f1dx=new Funcion(s);
		System.out.println("funcion 1 derivado en y");
		s=Leer.dato();
		f1dy=new Funcion(s);
		System.out.println("funcion 2");
		s=Leer.dato();
		f2=new Funcion(s);
		System.out.println("funcion 2 derivado en x");
		s=Leer.dato();
		f2dx=new Funcion(s);
		System.out.println("funcion 2 derivado en y");
		s=Leer.dato();
		f2dy=new Funcion(s);
		
	}
	
	public void llenarMV(Double x,Double y)
	{
		mt[0][0]=f1dx.evaluar(x,y);
		mt[0][1]=f1dy.evaluar(x,y);
		mt[1][0]=f2dx.evaluar(x,y);
		mt[1][1]=f2dy.evaluar(x,y);
		
		vc[0]=-f1.evaluar(x,y);
		vc[1]=-f2.evaluar(x,y);	
		
	}
	
	public Double mod(Double a,Double b)
	{
		Double re;
		return re=Math.sqrt(a*a+b*b);
	}
	
	public void operar()
	{
		Double md =0.0;
		Double[] jk=new Double[2];
		Double[] re=new Double[2];
		int i=0;
		jk[0]=0.0;jk[1]=0.0;
		//Puntos iniciales
		System.out.print("x0:");
		double x0=Leer.datoDouble();
		System.out.print("y0:");
		double y0=Leer.datoDouble();
		re[0]=x0;re[1]=y0;
		do
		{
			i++;
			System.out.print(i+" ");
			llenarMV(re[0],re[1]);
			jk=OpMat.encX(mt,vc);		
			re=OpMat.sumVec(jk,re);
			md=mod(jk[0],jk[1]);
			System.out.println("mod "+md);
			System.out.print("re: ");
			OpMat.mostrar(re);
			System.out.println();
		}while(md!=0.0);
		
	}	
}

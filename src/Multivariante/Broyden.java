package Multivariante;
import Funcion.*;

public class Broyden 
{
	Double[][] mt1,mt2;
	Double[] vc1,vc2,x0,x1;
	int n=2;
	Funcion f1,f2,f1dx,f1dy,f2dx,f2dy;
	
	public Broyden()
	{
		
		mt1=new Double[n][n];
		mt2=new Double[n][n];
		vc1=new Double[n];
		vc2=new Double[n];
		x1=new Double[n];
		x0=new Double[n];
		
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
	
	public void llenarMV1(Double x,Double y)
	{
		mt1[0][0]=f1dx.evaluar(x,y);
		mt1[0][1]=f1dy.evaluar(x,y);
		mt1[1][0]=f2dx.evaluar(x,y);
		mt1[1][1]=f2dy.evaluar(x,y);
		x0[0]=x;
		x0[1]=y;
		vc1[0]=-f1.evaluar(x,y);
		vc1[1]=-f2.evaluar(x,y);		
	}
	
	public void llenarMV2(Double x,Double y)
	{
		mt2[0][0]=f1dx.evaluar(x,y);
		mt2[0][1]=f1dy.evaluar(x,y);
		mt2[1][0]=f2dx.evaluar(x,y);
		mt2[1][1]=f2dy.evaluar(x,y);
		x1[0]=x;
		x1[1]=y;
		vc2[0]=-f1.evaluar(x,y);
		vc2[1]=-f2.evaluar(x,y);	
		
	}
	
	
	public Double mod(Double a,Double b)
	{
		Double re;
		return re=Math.sqrt(a*a+b*b);
	}
	
	public void Operacion()
	{
		Double[][] Ainv=new Double[n][n];
		Double[][] jk=new Double[n][n];
		Double[] Ax=new Double[n];
		Double[] Afx=new Double[n];
		Double[] x2=new Double[n];
		Double[][] num=new Double[n][n];
		Double[] aux1=new Double[n];
		Double[] jkxFx=new Double[n];
		Double[] Axjk=new Double[n];

		
		
		Double den;

		
		System.out.print("x0:");
		double X0=Leer.datoDouble();
		System.out.print("y0:");
		double Y0=Leer.datoDouble();
		System.out.print("x1:");
		double X1=Leer.datoDouble();
		System.out.print("y1:");
		double Y1=Leer.datoDouble();
		
		System.out.println("ingrese maximo de iteraciones");
		int n21=Leer.datoInt();
		
		llenarMV1(X0,Y0);
		llenarMV2(X1,Y1);		
		
		
		
		for(int i=0;i<n21;i++)
		{
			
		jk = OpMat.fadeba(mt1);
		Ax = OpMat.resVec(x1,x0);
		Afx= OpMat.resVec(vc1,vc2);
		
		
		
		//System.out.println("Afx:");
		//OpMat.mostrar(Afx);
		
		//System.out.println("Ax");
		//OpMat.mostrar(Ax);
		
		//System.out.println("JACOVIANO INVERSO:");
		//OpMat.mostrar(jk);
		
		Axjk=OpMat.multVecxMat(jk,Ax);
		//System.out.println("Ax* jacobiano inverso:");
		//OpMat.mostrar(Axjk);
		
		
		jkxFx=OpMat.multMatxVec(jk,Afx);
		//System.out.println("jacobiano inverso * fx:");
		//OpMat.mostrar(jkxFx);
		
		aux1=OpMat.resVec(Ax,jkxFx);
		//System.out.println("Ax- jacobiano inverso *fx:");
		//OpMat.mostrar(jkxFx);
		
		
		num=OpMat.mulVectEsp(aux1,Axjk);
		
		//System.out.println("NUMERADOR:");
		//OpMat.mostrar(num);
		
		den=OpMat.mulEsc(jkxFx,Ax);
		//System.out.println("denominador: "+den);
		
		
		num=OpMat.MatXconst(num,1/den); 
		//System.out.println("numerador/denominador:");
		//OpMat.mostrar(num);
		
		Ainv=OpMat.sumMat(jk,num);
		//System.out.println("Ainv:");
		//OpMat.mostrar(Ainv);
		
		
		vc2=OpMat.VecXconst(vc2, -1.0);
	
		x2=OpMat.resVec(x1,OpMat.multMatxVec(Ainv,vc2));
		System.out.print("x2:");
		OpMat.mostrar(x2);
		if(x2[0].isNaN())
		{
			i=n21;
		}
		//System.out.println();
		//System.out.println();
		//System.out.println();

		x0=x1;
		x1=x2;
		llenarMV1(x0[0],x0[1]);
		llenarMV2(x1[0],x1[1]);		
		
	}
	}	
}

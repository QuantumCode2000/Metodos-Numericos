package edos;

import java.text.DecimalFormat;
import java.util.Scanner;
import Funcion.*;

public class RKuta 
{
	Double A,B,X,Y,Z,h;
	Double k1,k2,k3,k4,c1,c2,c3,c4;	
	int n;
	Scanner leer=new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#.0000");
	Funcion f1,f2;
	
	
	public RKuta()
	{
		
		String s;
		System.out.println("ingrese la funcion y' (cambio de variable)");
		s=Leer.dato();
		f1=new Funcion(s);
		System.out.println("ingrese la funcion y''");
		s=Leer.dato();
		f2=new Funcion(s);
		System.out.print("n: ");
		n= leer.nextInt();
		System.out.println("x0____x1");
		A=leer.nextDouble();
		B=leer.nextDouble();
		System.out.print("y(x0) :");Y=leer.nextDouble();
		System.out.print("z(x0) :");Z=leer.nextDouble();
		X=A;
	}
	
	
	public Double f1(Double x,Double y,Double z)
	{
		Double F;	
		return F= z;
	}
	
	public Double f2(Double x,Double y,Double z)
	{
		Double F;
		return F= - (5*z + 20*y) /20 ;	
	}
	
	
	public void Operacion()
	{
		h=(B-A)/n;
		System.out.println("X: "+df.format(X)+" Y: "+df.format(Y)+" Z: "+df.format(Z));
		for(int i=1;i<=n;i++)
		{
			k1=f1.evaluar(X,Y,Z);
			//System.out.println("k1:"+k1);
			c1=f2.evaluar(X,Y,Z);
			//System.out.println("c1:"+c1);
			k2=f1.evaluar(X+h/2,Y+h*k1/2,Z+h*c1/2);
			//System.out.println("k2:"+k2);
			c2=f2.evaluar(X+h/2,Y+h*k1/2,Z+h*c1/2);
			//System.out.println("c2:"+c2);
			k3=f1.evaluar(X+h/2,Y+h*k2/2,Z+h*c2/2);
			//System.out.println("k3:"+k3);
			c3=f2.evaluar(X+h/2,Y+h*k2/2,Z+h*c2/2);
			//System.out.println("c3:"+c3);
			k4=f1.evaluar(X+h,Y+h*k3,Z+h*c3);
			///System.out.println("k4:"+k4);
		    c4=f2.evaluar(X+h,Y+h*k3,Z+h*c3);
			//System.out.println("c4:"+c4);
			Y=Y+(h/6)*(k1+2*k2+2*k3+k4);
			Z=Z+(h/6)*(c1+2*c2+2*c3+c4);
			X=X+h;
			System.out.println("X: "+df.format(X)+" Y: "+df.format(Y)+ " Z: "+df.format(Z));
		}
		
	}
	
	
	
}

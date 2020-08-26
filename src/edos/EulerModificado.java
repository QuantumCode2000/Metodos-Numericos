package edos;

import java.text.DecimalFormat;
import java.util.Scanner;
import Funcion.*;

public class EulerModificado 
{
	Double h,x0,x1,X,X1,Yp1,Yp2,Y;                        
	DecimalFormat df = new DecimalFormat("#.0000");
	Funcion y;
	 /* Salida : 1.42*/
	int n;
	Scanner leer=new Scanner(System.in);
	public EulerModificado()
	{
		System.out.println("ingrese la funcion y'");
		String s=Leer.dato();
		y=new Funcion(s);
		System.out.println("ingresa n");
		n=leer.nextInt();
		System.out.println("x0__x1");
		x0=leer.nextDouble();
		x1=leer.nextDouble();
		System.out.print("Y(x0):");
		Y=leer.nextDouble();
	}
	//cambiar 
	public void operacion()
	{
		h=(x1-x0)/n;
		X=x0;
		System.out.println("X: "+df.format(X)+" Y: "+df.format(Y));		
		for(int i=0;i<n;i++)
		{
			Yp1=Y+h*y.evaluar(X,Y);
			X1=X+h;
			Yp2=(y.evaluar(X,Y)+y.evaluar(X1,Yp1))/2;
			//System.out.println("Yp1:"+Yp1+" X1:"+X1+" Yp2:"+Yp2);
			Y=Y+h*Yp2;
			X=X+h;
			System.out.println("X: "+df.format(X)+" Y: "+df.format(Y));		
			//System.out.println("-----------");
		}
	}
	
}

package edos;

import java.text.DecimalFormat;
import java.util.Scanner;
import Funcion.*;

public class Taylor 
{
	Double h,x0,x1,X,Y;
	int n;
	Scanner leer=new Scanner(System.in);
	Funcion fxy,dfxy;
	DecimalFormat df = new DecimalFormat("#.0000");
	public Taylor()
	{
		String s;
		System.out.println("ingrese la funcion y'");
		s=Leer.dato();
		fxy=new Funcion(s);
		//deribada parcial en x = fxy/dx + (fxy/dy)*fxy
		System.out.println("ingrese la funcion y''");
		s=Leer.dato();
		dfxy=new Funcion(s);
		System.out.print("n: ");
		n=leer.nextInt();
		System.out.println("X0____X1");
		x0=leer.nextDouble();
		x1=leer.nextDouble();
		h=(x1-x0)/n;
	}
	
	
	public void operacion()
	{
		System.out.print("Y(X0)=");
		Y=leer.nextDouble();
		X=x0;
		System.out.println("X= "+X+" Y= "+Y);
		for(int i=0;i<n;i++)
		{
			Y=Y+h*fxy.evaluar(X,Y)+(h*h/2)*dfxy.evaluar(X,Y);
			X=X+h;
			System.out.println("X= "+df.format(X)+" Y= "+df.format(Y));
		}
	}

}

package Interpolacion;

import java.util.Scanner;

public class regMult
{
	Double[][] alphas;
	Double[][] X,Y,B;
	int n,m,num;
	Double Ymed=0.0,Yesmed=0.0,R2=0.0;
	Double[][] Yes;
	Scanner leer=new Scanner(System.in);
	
	public regMult()
	{
		System.out.print("cuatas variables son: ");
		m=Leer.datoInt();
		System.out.println("cuantas repeticiones");
		num=Leer.datoInt();
		alphas=new Double[m+1][1];
		for(int i=0;i<m+1;i++)
		{
			alphas[i][0]=0.0;
		}
		
	}
	public void llenar()
	{
		System.out.print("cuatas datos son: ");
		n=Leer.datoInt();
		Yes=new Double[n][1];
		X=new Double[n][m+1];
		Y=new Double[n][1];
		B=new Double[m+1][1];
		System.out.println(" Y | X1 | X2 | X3...");
		for(int i=0;i<n;i++)
		{	
			//System.out.print("Y["+i+"]");
			Y[i][0]=leer.nextDouble();
			Ymed=Ymed+Y[i][0];
			X[i][0]=1.0;
			for(int j=1;j<m+1;j++)
			{
				X[i][j]=leer.nextDouble();
			}
		}
		Ymed=Ymed/n;
		OpMat.mostrar(Y);
		OpMat.mostrar(X);	
	}
	
	public void Operacion()
	{  
			Double Rnum=0.0;
			Double Rden=0.0;
			Double[][] p1=new Double[m+1][m+1];
			Double[][] p2=new Double[m+1][m+1];
			Double[][] p3=new Double[m+1][1];
			
			llenar();
			
			/*p1=OpMat.multMat(OpMat.transp(X), X);
			System.out.println("p1:");
			OpMat.mostrar(p1);
			p2=OpMat.InversaMatriz(p1);
			System.out.println("p2:");
			OpMat.mostrar(p2);
			
			p3=OpMat.multMat(OpMat.transp(X),Y);
			System.out.println("p3:");
			OpMat.mostrar(p3);
			B=OpMat.multMat(p2,p3);*/
			
			
			
			B=OpMat.multMat(OpMat.fadeba(OpMat.multMat(OpMat.transp(X), X)), OpMat.multMat(OpMat.transp(X),Y));
			Yes=OpMat.multMat(X,B);
			System.out.println("Alphas");OpMat.mostrar(B);
			for(int i=0;i<n;i++)
			{
				Yesmed=Yesmed+Yes[i][0];
			}
			Yesmed=Yesmed/n;
			for(int i=0;i<n;i++)
			{
				Rnum=Rnum+(Yes[i][0]-Yesmed)*(Yes[i][0]-Yesmed);
				Rden=Rden+(Y[i][0]-Ymed)*(Y[i][0]-Ymed);
			}
			R2=Rnum/Rden;
			System.out.println("R2: "+R2);
		
	}

}

/*Temperatura	15	16	24	13	21	16	22	18	20	19	28	27	13	22	23
Humedad	      70	65	71	64	84	86	72	84	71	75	84	79	80	76	88
Recuento	156 	157	177	145	197	184	172	187	157	169	200	193	167	170	192
*/












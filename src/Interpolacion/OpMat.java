package Interpolacion;

public class OpMat 
{
	Double[][] mt1;
	Double[][] mt2;
	Double[][] mt3;
	Double[] vc;
	static int q=0;
	
	OpMat()
	{
		mt1=new Double[6][6];
		mt1[0][0]= 0.17;
		mt1[0][1]=4.32;
		mt1[0][2]=-4.32;
		mt1[0][3]=6.75;
		mt1[0][4]=-4.36;
		mt1[0][5]=3.61;

		mt1[1][0]=-0.51;
		mt1[1][1]=-9.21;
		mt1[1][2]=-5.21;
		mt1[1][3]=-4.81;
		mt1[1][4]=2.37;
		mt1[1][5]=-2.61;
		
		mt1[2][0]=0.89;
		mt1[2][1]=0.32;
		mt1[2][2]=-10.51;
		mt1[2][3]=-0.05;
		mt1[2][4]=-4.38;
		mt1[2][5]=4.62;

		mt1[3][0]=7.35;
		mt1[3][1]=-0.01;
		mt1[3][2]=-40.60;
		mt1[3][3]=-0.07;
		mt1[3][4]=9.36;
		mt1[3][5]=-9.35;

		mt1[4][0]=4.86;
		mt1[4][1]=3.51;
		mt1[4][2]=21.10;
		mt1[4][3]=4.36;
		mt1[4][4]=-4.37;
		mt1[4][5]=4.99;

		
		mt1[5][0]=2.15;
		mt1[5][1]=4.62;
		mt1[5][2]=4.67;
		mt1[5][3]=9.54;
		mt1[5][4]=2.39;
		mt1[5][5]=5.35;


		vc=new Double[6];
		vc[0]=21.56;
		vc[1]=-6.37;
		vc[2]=4.52;
		vc[3]=6.33;
		vc[4]=9.81;
		vc[5]=-20.35;
		
	}
	
	
	
	public static	 void leer(Double[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
		 for(int j=0;j<a[0].length;j++)
		 	{
			 System.out.print("a["+(i+1)+"]["+(j+1)+"]= ");
			a[i][j]= Leer.datoDouble();
		 	}
		}
	}
	
	public static void mostrar(Double[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
		 for(int j=0;j<a[0].length;j++)
		 	{
			 System.out.print("  a["+(i+1)+"]["+(j+1)+"]= "+a[i][j]);
		 	}
		 System.out.println();
		}
		System.out.println();
	}
	
	public static void mostrar(Double[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			 System.out.print("  a["+(i+1)+"]"+a[i]);
		}
		System.out.println();
	}
	
	public static Double[][] multMat(Double[][] a,Double[][] b)
	{
		Double[][] re=new Double[a.length][b[0].length];
		if(a[0].length==b.length)
		{
			for(int f=0;f<a.length;f++)
			{
				for (int c=0;c<b[0].length;c++)
				{
					re[f][c]=0.0;
					for(int k=0;k<a[0].length;k++)
					{
						re[f][c]=re[f][c]+a[f][k]*b[k][c];
					}
				}
			}
			return re;	
		}
		else
		{
			System.out.println("las matrices no se puden multiplcar en ese orden");
		}
		return re;
	}
	
	public static Double mulEsc(Double[] a,Double[] b)
	{
		Double re=0.0;
		if(a.length==b.length)
		{
			for(int f=0;f<a.length;f++)
			{
				re=re+a[f]*b[f];
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden multiplcar en ese orden");
		}
		return re;
	}
	
	public static Double[][] mulVectEsp(Double[] a,Double[] b)
	{
		Double[][] re=new Double[a.length][b.length];
			for(int f=0;f<a.length;f++)
			{
				for(int c=0;c<b.length;c++)
				{
					re[f][c]=0.0;
						re[f][c]=re[f][c]+a[f]*b[c];
				}
			}
		return re;
	}
	
	public static Double[] mulVect(Double[] a,Double[] b)
	{
		Double[] re=new Double[b.length];
		if(a.length==b.length)
		{
			for(int f=0;f<a.length;f++)
			{
					re[f]=0.0;
						re[f]=re[f]+a[f]*b[f];
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden multiplcar en ese orden");
		}
		return re;
	}
	
	public static Double[] multVecxMat(Double[][] a,Double[] b)
	{
		Double[] re=new Double[b.length];
		if(a.length==b.length)
		{
			for(int f=0;f<a.length;f++)
			{
					re[f]=0.0;
					for(int k=0;k<a[0].length;k++)
					{
						re[f]=re[f]+a[k][f]*b[k];
					}
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden multiplcar en ese orden");
		}
		return re;
	}
	public static Double[] multMatxVec(Double[][] a,Double[] b)
	{
		
		Double[] re=new Double[a.length];
		if(a[0].length==b.length)
		{
			for(int f=0;f<a.length;f++)
			{
					re[f]=0.0;
					for(int k=0;k<a[0].length;k++)
					{
						re[f]=re[f]+a[f][k]*b[k];
					}
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden multiplcar en ese orden");
		}
		return re;
	}
	
	public static Double[][] sumMat(Double[][] a,Double[][] b)
	{
		Double[][] re=new Double[a.length][b[0].length];
		if(a.length==b.length && a[0].length==b[0].length)
		{
			for(int i=0;i<a.length;i++)
			{
				for (int j=0;j<b[0].length;j++)
				{
					re[i][j]=0.0;
					re[i][j]= a[i][j]+b[i][j];
				}
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden sumar en ese orden");
		}
		return re;
	}
	
	public static Double[][] resMat(Double[][] a,Double[][] b)
	{
		Double[][] re=new Double[a.length][b[0].length];
		if(a.length==b.length && a[0].length==b[0].length)
		{
			for(int i=0;i<a.length;i++)
			{
				for (int j=0;j<b[0].length;j++)
				{
					re[i][j]=0.0;
					re[i][j]= a[i][j]-b[i][j];
				}
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden restar en ese orden");
		}
		return re;
	}
	
	public static Double[] resVec(Double[] a,Double[] b)
	{
		Double[] re=new Double[a.length];
		if(a.length==b.length)
		{
			for(int i=0;i<a.length;i++)
			{
				re[i]=0.0;
				re[i]= a[i]-b[i];
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden restar en ese orden");
		}
		return re;
	}
	
	public static Double[] sumVec(Double[] a,Double[] b)
	{
		Double[] re=new Double[a.length];
		if(a.length==b.length)
		{
			for(int i=0;i<a.length;i++)
			{
				re[i]=0.0;
				re[i]= a[i]+b[i];
			}
			return re;
		}
		else
		{
			System.out.println("las matrices no se puden restar en ese orden");
		}
		return re;
	}
	
    public static Double[][] transp(Double[][] a)
    {
    	Double[][] re=new Double[a[0].length][a.length];
    		
    			for(int i=0;i<a.length;i++)
    			{
    				for (int j=0;j<a[0].length;j++)
    				{
    					re[j][i]= a[i][j];
    				}
    			}
    	return re;		
    }
    
    public static Double trazaMat(Double[][] a)
	{
    	Double re=0.0;
    	
    	if(a.length==a[0].length)
    	{
    		
    		for(int i=0;i<a.length;i++)
    		{
    			for(int j=0;j<a[0].length;j++)
    			{
    				if(i==j)
    				{
    					re=re+a[i][j];
    				}
    			}
    		}		
		return re;
    	}
    	else
    	{
    		System.out.println("no se puede sacar la traza de una matriz rectangular");
    	}
    	return re;
	}
    
    public void sumTrgSup(Double[][] a)
    {
    	Double re=0.0;
		if(a.length==a[0].length)
		{
			for(int i=0;i<a.length;i++)
			{
				for (int j=0;j<a[0].length;j++)
				{
					if(i<=j)
					{
					re=re+a[i][j];
					}
				}
			}
			System.out.println("suama de la triangular sup M1:"+re);
		}
		else
		{
			System.out.println("no se puede sumar la triangular superior devido a no ser una matriz cuadrada");
		}
    }
    
    public static void asigMtExt(Double[][] a,Double[][] re)
    {
    	for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				re[i][j]=a[i][j];
			}
		}
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=a.length;j<re[0].length;j++)
			{
				if(i==j-a.length)
				{
					re[i][j]=1.0;
				}
				else
				{
					re[i][j]=0.0;
				}
			}	
		}
		mostrar(re);
		System.out.println();
    }
    
    public static Double[][] InversaMatriz(Double[][] a)
    {
    	int q=0;
    	if(a.length==a[0].length)
    	{
    		Double[][] re=new Double[a.length][2*a[0].length];
    		asigMtExt(a,re);
    		for(int i=0;i<a.length;i++)
    		{
    			q=i+1;
        		divPorPivot(re,i);		
    			for(int j=0;j<a.length;j++)
    			{
    				if(i!=j)
    				{
    					volverCero(re,j,i);
    				}
    			}	
    		} 
    		
    		for(int i=0;i<a.length;i++)
    		{
    			for(int j=a.length;j<re[0].length;j++)
    			{
    				a[i][j-a.length]=re[i][j];
    			}	
    		}
    		mostrar(a);
    		return a;
    	}
    	else
    	{
    		System.out.println("la matriz no es cuadrada");
    	}
    	return a;
    }
    
    
    public static void divPorPivot(Double[][] d,int f)
    {	
    	Double div=d[f][f];
    	if (div!=0)
    	{
    		for(int i=0;i<d[0].length;i++)
   			{
   				d[f][i]=d[f][i]/div;
   			}
   			mostrar(d);
   			System.out.println();
    	}
    	else
    	{
    		if(q==d.length)
    		{
    			System.out.println("la matriz no tiene inversa!!");
    			System.out.println("la matriz no tiene inversa!!");
    			System.out.println("la matriz no tiene inversa!!");


    		}
    		else
    		{
    			cambioDeFila(d,f);
    			q++;
    			divPorPivot(d,f);
    		}
    	}
    }
    
    public static void cambioDeFila(Double[][] d, int f)
    {		
    	Double aux=0.0;
    	for(int i=0;i<d[0].length;i++)
    	{
    		aux=d[f][i];
    		d[f][i]=d[q][i];
    		d[q][i]=aux;
    	}
    }
    
    public static void volverCero(Double[][] d,int f,int p)
    {
    	Double mul=d[f][p];
    	for(int i=0;i<d[0].length;i++)
    	{
    		d[f][i]=d[f][i]-d[p][i]*mul;
    	}
    	mostrar(d);
    }
    
    public static Double pI(Double[][] a,int i)
    {
    	Double pi=0.0;
    		pi=trazaMat(a)/i;
    	return pi;
    }
    
    public static Double[][] MatXconst(Double[][] a,Double c)
    {
    	for(int i=0;i<a.length;i++)
    	{
    		for(int j=0;j<a[0].length;j++)
    		{
    			a[i][j]=a[i][j]*c;
    		}
    	}	
    	return a;
    }
    
    public static Double[] VecXconst(Double[] a,Double c)
    {
    	for(int i=0;i<a.length;i++)
    	{
    		 a[i]=a[i]*c;	
    	}	
    	return a;
    }
    
    public static Double[][] Ide(int x)
    {
    	Double[][] ide=new Double[x][x];
    	for(int i=0;i<x;i++)
		{
			for(int j=0;j<x;j++)
			{
				if(i==j)
				{
					ide[i][j]=1.0;
				}
				else
				{
					ide[i][j]=0.0;
				}
			}	
		}
    	
    	return ide;
    	
    	
    }
    
    public static Double[][] fadeba(Double[][] m)
    {
    	int i=0;
    	Double pi0=0.0;
    	Double[][] B=new Double[m.length][m[0].length];
    	Double[][] B0=new Double[m.length][m[0].length];
    	Double[][] Ainv=new Double[m.length][m[0].length];
		Ainv=m;
		do
		{
			i++;
			Double pi=pI(Ainv,i);
			B= resMat(Ainv,MatXconst(Ide(Ainv.length),pi));
			Ainv=multMat(m,B);
		
			if(Math.abs(B[0][0])>0.0001 && Math.abs(B[1][1])>0.0001)
			{
				B0= B;
				
			}
			else
			{
				pi0=pi;
				i=0;
			}
		
		}while(i>0);
		
		Ainv=MatXconst(B0,1/pi0);
		return Ainv;
    }
    
    public static Double[][] generarMat0(int n,int m)
    {
    	Double[][] mat0=new Double[n][m];
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<m;j++)
    		{
    			mat0[i][j]=0.0;
    		}
    	}
    	
    	
    	return mat0;
    }
    
	
	public void Operar()
	{
		System.out.print("Nro de filas de M1: ");
		int nFa = Leer.datoInt();
		System.out.print("Nro de columnas de M1: ");
		int nCa= Leer.datoInt();
		mt1=new Double[nFa][nCa];
		leer(mt1);
		mostrar(mt1);
		System.out.print("Nro de filas de M2: ");
		nFa = Leer.datoInt();
		System.out.print("Nro de columnas de M2: ");
		nCa= Leer.datoInt();
		mt2=new Double[nFa][nCa];
		leer(mt2);
		mostrar(mt2);
		mostrar(multMat(mt1,mt2));
		
		
		
		
		
	}

	public static Double[] encX(Double[][] mt	,Double[] vc2)
	{
		Double[] re=new Double[vc2.length];
		Double[][] ainv=new Double[mt.length][mt[0].length];

		ainv=fadeba(mt);
		re= multMatxVec(ainv,vc2);
		return re;
	}
}

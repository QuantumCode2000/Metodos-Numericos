package Multivariante;

public class Newton 
{
	
	Double[] x1,x0,fx0;
	Double[][] J;
	
	Newton()
	{
		int n=2;
		x0=new Double[n];
		x1=new Double[n];
		fx0=new Double[n];
		J=new Double[n][n];
	}
	
	public Double[][] Jc(Double x,Double y)
	{
		Double[][] re=new Double[2][2]; 
		re[0][0]=-x*y+5;
		re[0][1]=y;
		re[1][0]=y*y;
		re[1][1]=-x+5;
		
		return re;
	}
	
	public Double[][] Jcinv(Double[][] Jc,Double x, Double y)
	{
		Double[][] re=new Double[2][2];
		
		Double det= 20*x+2*y*y*y-4*x*x*y+20*x*y-100;
		//System.out.println("det= "+det);

		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				re[i][j]=Jc[i][j]/det;
			}
		}
		
		return re;
		
	}
	
	public Double[] Fx(Double x,Double y)
	{
		Double[] re=new Double[2];
		re[0]=2*x*x-20*x+2*y*y+16;
		re[1]=2*x*y*y+2*x-20*y+16;
		return re;
	}
	
	public void Operar()
	{
		x1[0]=1.0;
		x1[1]=-3.0;	
		OpMat.mostrar(x1);
		do {
			x0=x1;
			J=Jc(x0[0],x0[1]);
			//System.out.println("jacoviano");
			//OpMat.mostrar(J);
			J=Jcinv(J,x0[0],x0[1]);
			//System.out.println("jacoviano inversa");
			//OpMat.mostrar(J);
			fx0=Fx(x0[0],x0[1]);
			//System.out.println("f(xn)");
			//OpMat.mostrar(fx0);
			x1=OpMat.resVec(x0,OpMat.multMatxVec(J, fx0));
			System.out.println("X(n+1)");
			OpMat.mostrar(x1);
		}while(x1[0]-x0[0]!=0 && x1[1]-x0[1]!=0);	
	}
	
	
	
}

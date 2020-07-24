package com.wipro.eb.entity;

public class Domestic extends Connection{

	public Domestic(int currentReading, int	previousReading, float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		int k=currentReading-previousReading;
		float bill=0;
		if(k>100)
			bill=(float) (2.3*(50)+4.2*(50)+5.5*(k-100));
		else if(k>50)
			bill=(float) (2.3*(50)+4.2*(k-50));
		else
			bill=(float) (2.3*(50));
		if(bill>=10000)
			return (float) (bill+bill*0.09);
		else if(bill>=5000)
			return (float) (bill+bill*0.06);
		else
			return (float) (bill+bill*0.02);
		
	}
}

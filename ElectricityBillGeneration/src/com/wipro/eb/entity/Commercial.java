package com.wipro.eb.entity;

public class Commercial extends Connection{
	public Commercial(int currentReading, int	previousReading, float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		int k=currentReading-previousReading;
		float bill=0;
		if(k>100)
			bill=(float) (5.2*(50)+6.8*(50)+8.3*(k-100));
		else if(k>50)
			bill=(float) (5.2*(50)+6.8*(k-50));
		else
			bill=(float) (5.2*(50));
		if(bill>=10000)
			return (float) (bill+bill*0.09);
		else if(bill>=5000)
			return (float) (bill+bill*0.06);
		else
			return (float) (bill+bill*0.02);
		
	}
}

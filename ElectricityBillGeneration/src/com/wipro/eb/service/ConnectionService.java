package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	int f=0;
	public boolean validate(int currentReading, int previousReading, String type)throws InvalidReadingException, InvalidConnectionException
	{
		if(currentReading < previousReading) 
			throw new InvalidReadingException();
		if(currentReading<0)
			throw new InvalidReadingException();
		if(previousReading<0)
			throw new InvalidReadingException();
		if(!(type.contentEquals("Domestic") || type.contentEquals("Commercial")))
			throw new InvalidConnectionException();
		else			
			return true;
	}
	 public float calculateBillAmt(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException 
	{
		 float bill=0;
		 try
		 {
			 boolean flag=validate(currentReading,previousReading,type);
			 if(flag)
			 {
				if(type.equals("Domestic"))
				{
					float slabs[]= {2.3f,4.2f,5.5f};
					Domestic domestic=new Domestic(previousReading, currentReading, slabs);
					bill= domestic.computeBill();
				}
				else if(type.equals("Commercial"))
				{
					float slabs[]= {5.2f,6.8f,8.3f};
					Commercial commercial=new Commercial(previousReading, currentReading, slabs);
					bill= commercial.computeBill();
				}
			}
		 }
		 catch(InvalidReadingException e)
		 {
			bill=-1;
		 }
		 catch(InvalidConnectionException e)
		 {
			bill=-2;
		 }
		return bill;
	}
	public String generateBill(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		float i=calculateBillAmt(currentReading,previousReading,type);
		if((int)i==-1)
			throw new InvalidReadingException();
		else if((int)i==-2)
			throw new InvalidConnectionException();
		else
			return "Amount to be paid: "+ i;
	}
	 
}

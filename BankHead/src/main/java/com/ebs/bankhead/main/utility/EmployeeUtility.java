package com.ebs.bankhead.main.utility;

import java.util.Random;

public class EmployeeUtility 
{
	
	public static final Random USERNAME_RANDOM=new Random(1000);
	
	public static final Random PASSWORD_RANDOM =new Random(1000);
	
	public static String getUsername(String FirstName)
	{
		return FirstName+USERNAME_RANDOM.nextInt(9999);
		
	}
	
	public static String getPassword(String FirstName)
	{
		return FirstName +'@'+PASSWORD_RANDOM.nextInt(9999);
	}

}

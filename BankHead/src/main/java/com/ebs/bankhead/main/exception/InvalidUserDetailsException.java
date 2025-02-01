package com.ebs.bankhead.main.exception;

public class InvalidUserDetailsException extends RuntimeException
{
  public InvalidUserDetailsException(String msg)
  {
	  super(msg);
  }
}

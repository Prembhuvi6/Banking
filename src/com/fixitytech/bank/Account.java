package com.fixitytech.bank;


public class Account {
	
	
	int id;
	String name;
	double balance;
	
	
	static int generateID=1000;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Account(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public static int getGenerateID() {
		return ++generateID;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	private void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public Transaction deposit(double amt)
	{
		
		balance=balance+amt;
		
	Transaction transaction=new Transaction();
	transaction.setTransactionId(Transaction.generatorId());
	transaction.setAccountId(id);
	transaction.setAmount(amt);
	transaction.setType(1);
	transaction.setStatus(0);
	
	return transaction;
		
	}
	
	
	public Transaction withdrawl(double amt)
	{
	
		Transaction transaction=new Transaction();
		transaction.setAccountId(Transaction.generatorId());
		transaction.setAccountId(id);
		transaction.setAmount(amt);
		transaction.setType(2);
		
		
		if(balance-amt>=0)
		
		{
		balance=balance-amt;
		transaction.setStatus(0);
			
		}
		else
			transaction.setStatus(1);
	
	return transaction;
		
	}

}

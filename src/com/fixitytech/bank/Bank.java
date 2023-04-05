package com.fixitytech.bank;

public class Bank {
	
	
	Account accounts[]=new Account[1000];
	int noOfAccounts;
	
	Transaction transactions[]=new Transaction[1000];
	int noOfTransactions;
	
	
	public Account openAccount(String name,double amt)
	{		
		if(noOfAccounts<1000)
		{
		//Account account =new Account();	
		//account.setId(Account.getGenerateID());
		//account.setName(name);
		Account account=new Account(Account.getGenerateID(), name, amt);
		
//		account.deposit(amt);
		
		accounts[noOfAccounts++]=account;
	
		return account;
		}
		
		return null;
	}
	
	Account getAccount(int id)
	{
		
		for(int i=0;i<noOfAccounts;i++)
			if(accounts[i].getId()==id)
				return accounts[i];
		
		return null;
		
	}
	Account[] getAccounts()
	{
		
		Account accounts[]=new Account[noOfAccounts];
		
		for(int i=0;i<noOfAccounts;i++)
			accounts[i]=this.accounts[i];
		
		return accounts;
		
	}
	
	public Transaction deposit(int acid,double amt)
	{
		
		Account account=getAccount(acid);
		
		if(account!=null)
		{
			Transaction transaction=account.deposit(amt);
			
			if(noOfTransactions< 1000)
				transactions[noOfTransactions++]=transaction;
			return transaction;	
			
		}
		else
			return null;
		
	}

	
	public Transaction Withdrawl(int acid,double amt)
	{
		
		Account account=getAccount(acid);
		
		if(account!=null)
		{
			Transaction transaction=account.withdrawl(amt);
			
			if(noOfTransactions< 1000)
				transactions[noOfTransactions++]=transaction;
			return transaction;	
			
		}
		else
			return null;
		
	}

	public Statement getMiniStatement(int id) {
		// TODO Auto-generated method stub
		
		Account ac=getAccount(id);
		if(ac!=null)
		{
			Statement st=new Statement();
			
			st.setAccountbalance(ac.getBalance());
			st.setAccountHolderName(ac.getName());
			st.setAccountbalance(ac.getBalance());
			
			int nt=getTransactionsCount(id);
			
			if(nt>10)
				nt=10;
			Transaction ts[]=new Transaction[nt];

			for(int i=0,j=0;j<nt && i<noOfTransactions;i++)
				 if(transactions[i].getAcId()==id)
					 ts[j++]=transactions[i];
			
			
			st.setTransactions(ts);
			
			return st;
			
		}
		else
		return null;
	}

	
	

	
	int getTransactionsCount(int acid)
	{
		int cn=0;
		
		for(int i=0;i<noOfTransactions;i++)
			 if(transactions[i].getAcId()==acid)
				 cn++;
		return cn;
	}
	
	public Statement getStatement(int id) {
		// TODO Auto-generated method stub
		
		Account ac=getAccount(id);
		if(ac!=null)
		{
			Statement st=new Statement();
			
			st.setAccountbalance(ac.getBalance());
			st.setAccountHolderName(ac.getName());
			st.setAccountbalance(ac.getBalance());
			
			int nt=getTransactionsCount(id);
			Transaction ts[]=new Transaction[nt];

			for(int i=0,j=0;i<noOfTransactions;i++)
				 if(transactions[i].getAcId()==id)
					 ts[j++]=transactions[i];
			
			
			st.setTransactions(ts);
			
			return st;
			
		}
		else
		return null;
	}

}
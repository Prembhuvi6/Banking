package com.fixitytech.bank;

import java.util.Scanner;
public class Main {
public static void main(String[] args) {
Bank bank=new Bank();




Scanner s = new Scanner(System.in);
	 int id;
	 double amount;
	while(true){
	System.out.println("display menu!!!");
	System.out.println("1.open/new account");
	System.out.println("2.Balance Enquiry");
	System.out.println("3.Deposit");
	System.out.println("4.Withdraw");
	System.out.println("5.Mini Statement");
	System.out.println("6.Detailed Statement ");
	System.out.println("7.Exit. ");
	System.out.println("enter your choice: ");
	int ch=s.nextInt();
	switch(ch){
	   case 1:
			 System.out.println("enter a customer name and ammount");
			 String name=s.next();
			 amount=s.nextDouble();
			 Account account=bank.openAccount(name,amount);
			 if(account!=null)
			  System.out.println(" Account is successfully created"+" "+account.getId());
			else
			 System.out.println("Account not created");
			
			 break;
	    case 2:
	    
			 System.out.println("enter id");
			 id=s.nextInt();
			 Account accounts=bank.getAccount(id);
			 if(accounts!=null)
			  System.out.println(accounts.getName()+" "+accounts.getBalance());
			 else
			  System.out.println("no account found of this id");
			break;
	     case 3:
			 System.out.println("enter account id and amount");
			 id=s.nextInt();
			 amount=s.nextDouble();
			 Transaction transaction=bank.deposit(id,amount);
			 if( transaction!=null)
			 {
			  System.out.println("your transaction reference no "+transaction.generatorId()+" "+transaction.getAmount());
			  if(transaction.getStatus()==0)
			   System.out.println("Transaction Sucess");
			  else 
				System.out.println("unable to Deposit");
				  
			 }
			break; 
			
	      case 4:
	    	 
	 		 System.out.println("enter account id and amount");
	 		 id=s.nextInt();
	 		 amount=s.nextDouble();
	 		 Transaction transactions=bank.Withdrawl(id,amount);
	 		 if( transactions!=null)
	 		 {
	 		  System.out.println("your transaction reference no "+transactions.getTransactionId()+" "+transactions.getAmount());
	 		  if(transactions.getStatus()==0)
	 		   System.out.println("Transaction Sucess");
	 		  else 
	 			  if(transactions.getStatus()==1)
	 			System.out.println("unable to Deposit");
	 		 }
	 		else
	 		 System.out.println("Try again");
	 		  break;
	 		 
	       
	      case 5:
	    	  
	    	    System.out.println("Enter Account Id: ");
	    	    id=s.nextInt();
	    	    Statement statement=bank.getMiniStatement(id);
	    	    if(statement==null )
	    	    	System.out.println("INVALID ACCOUNT ID ");
	    	    else
	    	    {
	    	          System.out.println(statement.getAccountId()+"  "+statement.getAccountBalance());
	    	          System.out.println(statement.getName());
	    	          Transaction trs[]=statement.getTransactions();
	    	          for(Transaction ts:trs)
	    	          {
	    	            System.out.println(ts.getAccountId()+"  "+ts.getAmount()+"    "+ts.getStatus());
	    	          }
	
	
	
	    	      }
	    	    
	    	 break;
	      
	
	      case 6:
	    	  
			  System.out.println("Enter Id");
			  mid=44;
			   statement=bank.getStatement(mid);
			  if(statement==null)
				  System.out.println("Invalid Account Id");
			  else
			  {
				  System.out.println(statement.getAccountId()+"   "+statement.getAccountBalance());
				  System.out.println(statement.getAccountHolderName());
				  
				  Transaction trs[]=statement.getTransactions();
				  
				  for(Transaction tr:trs)
				  {
					  System.out.println(tr.getId()+"  "+tr.getAmount()+"  "+tr.getType()+"  "+tr.getStatus());
				  }
				  
				  
			  }
	
	
	
		break;
		
		case 7:
			
			System.out.println("thank you have a nice day ...visit again");
			System.exit(0);
		 
		 s.close();
		   
		}//Switch
		}//while
}//main
}//class
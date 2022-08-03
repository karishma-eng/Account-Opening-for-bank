/*Assignment Question  6:Design a class for a bank database the database should support 
the following operations.
1. Deposit a certain amount into an account,
2. Withdrawing a certain amount from an account,
3. Return a value specifying the amount (i.e. balance) in an amount.
Hint::  take data members and create methods as according to your needs into the class.*/

import java.sql.*;
import java.util.Scanner;
public class Bank
 {
public void openAccount()
   {
    String name;
   int accountno,balance;
   Scanner in=new Scanner(System.in);
  System.out.println("Enter the details for opening account ");
            System.out.println("Enter the name := ");
	        name=in.next();
	    System.out.println("Enter the Accountno := ");
	        accountno=in.nextInt();
	    System.out.println("Enter the Amount for opening := ");
	        balance=in.nextInt();
  try
{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
                                             "manager");
  Statement state=con.createStatement();
  state.executeUpdate("insert into Bank values('"+name+"',"+accountno+","+balance+")");
  System.out.println("New Account is opened successfully");
     con.close(); 
    }
 catch(Exception e)
  {   
   System.out.println(e);
 } 
}        
public void Addamount()
{ 
  int balance=0;
  Scanner s=new Scanner(System.in);
  System.out.println("Enter the account no.to deposit account");
   int accountno=s.nextInt();
  System.out.println("Enter the amount to deposit");
    int Amount=s.nextInt();
 try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
 Statement state=con.createStatement();
 ResultSet rs=state.executeQuery("select balance from Bank where accountno="+accountno+" ");
  if(rs.next( ))
  {
   balance=rs.getInt("balance");
  }
    balance=balance+Amount;
  //state.executeUpdate("insert into Bank(balance) values(balance)");
   state.executeUpdate("Update Bank set balance="+balance+" where accountno="+accountno+" ");
     System.out.println("Amount is deposited successfully");
  con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
}

public void Withdraw()
{ 
  int balance=0;
  Scanner sp=new Scanner(System.in);
 System.out.println("Enter the account no to withdraw amount");
   int accountno=sp.nextInt();
  System.out.println("Enter the amount to withdraw");
    int Amount=sp.nextInt();
 try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
 Statement s=con.createStatement();
 ResultSet rs=s.executeQuery("select balance from Bank where accountno="+accountno+" ");
   if (rs.next()) 
   {
    balance=rs.getInt("balance");
   }  
      balance=balance-Amount;
   s.executeUpdate("Update Bank set balance="+balance+" where accountno="+accountno+" ");
     System.out.println("Amount is withdrawn successfully");
  con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
}
public void balance()
{
 Scanner b=new Scanner(System.in);
 System.out.println("Enter the account no to check balance");
  int accountno=b.nextInt();
try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
 Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select balance from Bank where accountno="+accountno+" ");
   while(rs.next())
{
   System.out.print(rs.getInt(1));
}
  System.out.println(" total balance in account ");
   con.close();
}
catch(Exception ee)
{
 System.out.println(ee);
}
}
public static void main(String str[])
{
  Bank bnk=new Bank();
  Scanner st=new Scanner(System.in);
   System.out.println("ENTER THE OPTION TO CHOOSE BANK SERVICE");
   System.out.println("1.TO OPEN ACCOUNT ");
   System.out.println("2.TO DEPOSIT AMOUNT ");
   System.out.println("3.TO WITHDRAW AMOUNT ");
   System.out.println("4.TO RETRIEVE BALANCE IN ACCOUNT ");
     int option=st.nextInt();
  switch(option)
{
 case 1: bnk.openAccount();
          break;

 case 2: bnk.Addamount();
          break;

case 3 : bnk.Withdraw();
         break;

case 4:  bnk.balance();
         break;
default:
System.out.println("Invalid selection");
}
}
}

 
 
    
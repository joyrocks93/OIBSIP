import java.util.Scanner;
public class ATM_interface {
    String name;
    String userName;
    String password;
    String accountNo;
    int prevTransac;
    int balance = 1000000;
    int transactions = 0;
    //int flag = 0;
    String transactionHistory = "";
    Scanner input = new Scanner(System.in);

    public void register() {
        System.out.print("Enter Your Name: ");
        this.name = input.nextLine();
        System.out.print("Enter Username: "); 
        this.userName = input.nextLine();
        System.out.print("Enter Password: ");
        this.password = input.nextLine();
        System.out.print("Enter Bank Account Number: ");
        this.accountNo = input.nextLine();
        System.out.println("Registration Completed!! Please Login To Proceed!!");
    }

    public void deposit() {
        boolean flag = false;
        while (!flag) {
            System.out.print("Enter amount to deposit: ");
            int amount = input.nextInt();
            if (amount > 0) {
                try {
                    if (amount <= 500000) {
                        transactions++;
                        balance += amount;
                        prevTransac = amount;
                        System.out.println("Rs. " + amount + " Successfully Deposited!!");
                        String str = "Rs." + amount + " deposited\n";
                        transactionHistory = transactionHistory.concat(str);
                    } 
                    else {
                        System.out.println("Sorry...Limit is Rs.500000.");
                    }
                } 
                catch (Exception e) {
                    System.out.println("Some error occurred...error msg :- " + e);
                }
                flag = true;
            } 
            else {
                System.out.println("Deposit must be more than zero");
            }
        }

    }

    public void checkBalance() {
        System.out.println("Rs. " + balance);
    }

    public void withdraw() {
        boolean flag = false;
        while (!flag) {
            System.out.print("Enter amount to withdraw: ");
            int amount = input.nextInt();
            if (amount > 0) {
                try {
                    if (balance >= amount) {
                        transactions++;
                        balance -= amount;
                        prevTransac = -amount;
                        System.out.println("Rs. " + amount + " Withdrawal Successful!!");
                        String str = "Rs." + amount + " withdrew\n";
                        transactionHistory = transactionHistory.concat(str);
                        flag = true;
                    } else {
                        System.out.println("Insufficient Balance. Not possible for the withdrawal!");
                    }
                } 
                catch (Exception e) {
                    System.out.println("Some error occurred...error msg :- " + e);
                }

            } 
            else {
                System.out.println("The amount must be greater than zero");
            }
        }

    }

    public void transfer()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Receiver's Name: ");
        String receiver = input.nextLine();
        System.out.print("Enter amount to transfer: ");
        int amount = input.nextInt();
        try
        {
            if (balance >= amount)
            {
                if (amount <= 500000)
                {
                    transactions++;
                    balance -= amount;
                    prevTransac = -amount;
                    System.out.println("Rs. "+amount + " Successfully Transferred to " + receiver);
                    String str = amount + " Rs. transferred to " + receiver + "\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else
                {
                    System.out.println("Sorry!! Limit is Rs.500000.");
                }
            }
            else
            {
                System.out.println("Transfer failed due to insufficient balance!");
            }
        }
        catch (Exception e)
        {
            System.out.println("Some error occurred...error msg :- "+e);
        }
    }
    public void getprevTransac()
    {
        if (prevTransac > 0)
        {
            System.out.println("Deposited: " + prevTransac);
        }
        else if (prevTransac < 0)
        {
            System.out.println("Withdraw: " + Math.abs(prevTransac));
        }
        else
        {
            System.out.println("No Transaction Occurred!");
        }
    }

    public boolean login()
    {
        boolean isLogin = false;
        Scanner input = new Scanner(System.in);
        while (!isLogin)
        {
            System.out.print("Enter Username: ");
            String Username = input.nextLine();
            if ( Username.equals(userName) )
            {
                while (!isLogin)
                {
                    System.out.print("Enter Password: ");
                    String Password = input.nextLine();
                    if ( Password.equals(password) )
                    {
                        System.out.print("Login Success!!");
                        isLogin = true;
                    }
                    else
                    {
                        System.out.println("Incorrect Password...");
                    }
                }
            }
            else
            {
                System.out.println("Username not found.");
            }
        }
        return isLogin;
    }
    public void transacHistory()
    {
        if (transactions == 0)
        {
            System.out.println("Empty!!");
        }
        else
        {
            System.out.println("\n" + transactionHistory);
        }
    }

    public static void main(String args[])
    {
        ATM_interface a = new ATM_interface();
        Scanner sc = new Scanner(System.in);
        System.out.println("----------- WELCOME TO ABC BANK ATM -----------\n");
        System.out.println("1.Register account(press 1)\n2.Exit(press any other key besides 1)");
        System.out.print("Enter your Choice: ");
        int option = sc.nextInt();
        if(option>0)
        {
            if(option == 1)
            {
                a.register();
                while (true)
                {
                    System.out.println("\nPress 1.Log-In\n Press 2.Exit");
                    System.out.print("Enter Your Choice: ");
                    int ch =sc.nextInt();
                    if (ch == 1)
                    {
                        if (a.login())
                        {
                            System.out.println("\n\n---------- WELCOME " + a.name + " ----------\n");
                            boolean isFinished = false;
                            while (!isFinished)
                            {
                                System.out.println("Press the keys mentioned for each option :-\n1.Check the Balance\n2.Deposit\n3.Withdraw\n4.Transfer\n5.Get the Last Transaction\n6.Get Full Transaction History\n7.Exit");
                                System.out.print("\nEnter Your Choice: ");
                                int c = sc.nextInt();
                                switch (c)
                                {
                                    case 1:
                                        a.checkBalance();
                                        break;
                                    case 2:
                                        a.deposit();
                                        break;
                                    case 3:
                                        a.withdraw();
                                        break;
                                    case 4:
                                        a.transfer();
                                        break;
                                    case 5:
                                        a.getprevTransac();
                                        break;
                                    case 6:
                                        a.transacHistory();
                                        break;
                                    case 7:
                                        isFinished = true;
                                        break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Log-In Failed...");
                        }

                    }
                    else
                    {
                        System.exit(0);
                    }
                }
            }
            else
            {
                System.exit(0);
            }
        }
        else
        {
            System.out.println("Invalid key");
        }
    }
}
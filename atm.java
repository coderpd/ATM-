public class BankAPP {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/bank";
		String r ="root";
		String p ="root";
		connection con=null;
		try {
			class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManger.getConnection(url,u,p);
			Scanner scan =new Scanner(system.in);
			//login module
			System.out.println("<---Welcome to Tap Bank--->");
            System.out.println("Enter Account Number:"); 
            int acc_num = scan.nextInt();
            System.out.println("Enter Pin: ");
            int pin = scan.nextInt();
            String query ="select from account where+ acc_num" + "= ? and pin = ?";
            preparedStatement psmt1=con.preparedStatement(query);
            psmt1.setInt(1,acc_num);
            psmt1.setInt(2,pin);
            ResultSet res1=psmt1.executeQuery();
            res1.next();
            String name=res1.getString(2);
            int bal=res1.getInt(4);
            System.out.println("welcome"+nmae+"!your available balance"+ bal);
            //transfer Module
           System.out.println("------Transfer Details------");
           System.out.println("Enter the Beneficiary Account Number");
           int b_acc = scan.nextInt();
           System.out.println("Enter the tranfer amount");
           int t_amt = scan.nextInt();
           preparedStatement psmt2=con.prepareStatement ("update account set balance = balance-? where acc_num?");
           psmt2.setInt(1, t_amt); 
           psmt2.setInt(2, ac_no);
           psmt2.executeUpdate();
           //Incoming credit request
            System.out.println("_____ Incoming credit request from____" + name +"account_num"+acc-Num+"wants to transfer"+t_amt);
            System.out.println("press y to receive!");
            System.out.println("press n to reject!");
            String choice = sc.next();
            if (choice.equals("y")) {
            PreparedStatement psmt3=con.prepareStatement ("update account set balance=balance+? where acc_num=?");
            psmt3.setInt(1, t_amt); 
            psmt3.setInt(2, b_ac);
            psmt3.executeUpdate(); 
            PreparedStatement psmt4=con.prepareStatement ("Select from account where acc_num=?");
            psmt4.setInt(1,b_ac);
            ResultSet res2=psmt4.executeQuery();
            res2.next();
            int b=res2.getInt(4);
            String b_n=res2.getString (2); 
            System.out.println("hello" + b_n + "your balance is" + b);

         } 
            else 
             PreparedStatement psmt4=con.preparestatement ("Select * from account where acc-num=?");
             ResultSet res2=psmt4.executeQuery();
             res2.next();
             int b=res2.getInt(4); String b_n=res2.getString (2);
             System.out.println("hello" + b_n + "your balance is" + b);
           
		}
		catch(exception e) {
			System.out.println("incorrect pin");
			}
		}
	}
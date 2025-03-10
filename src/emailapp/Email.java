package emailapp;
import java.util.Scanner;
public class Email {
    //making all the fields as private to stop unauthorized access
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultLength=7;
    private String department;
    private String institute="google";
    private int mailBoxCapacity=1024;
    private String alternateEmail;

    //constructor to set firstname and last name
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        greet();
        //setting department setdepartment method which takes input from the user and then return the department
        this.department=setDepartment();
        this.password=randomPassword(defaultLength);
        System.out.println("The default password is: "+this.password);
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+institute+".com";
        System.out.println("Your email is: "+email);
    }
    public void greet(){
        System.out.println("Welcome "+this.firstName+".Glad having you here!");
    }
   public String setDepartment(){
        int depCode;
        Scanner sc=new Scanner(System.in);
        System.out.println("Department codes:\n1 CSE\n2 IT\n3 ECE\nEnter your dept code:");
        depCode=sc.nextInt();
        switch (depCode){
            case 1 -> {
                return "CSE";
            }
            case 2 -> {
                return "IT";
            }
            case 3 -> {
                return "ECE";
            }
        }
        return "";
   }

    //then generate a random password
    public String randomPassword(int length){
        String passwordSet="0123456789@&%$#";
        char[] passw=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int)(Math.random()*passwordSet.length());
            passw[i]=passwordSet.charAt(rand);
        }
        return new String(passw);
    }


    //setting mailbox capacity
    public void setMailBoxCapacity(int capacity){
        mailBoxCapacity=capacity;
    }
    //setting an alternate email
    public void setAlternateEmail(String altEmail){
        alternateEmail=altEmail;
    }
    //function to that is used to change password
    public void changePassword(String password){
        this.password=password;
    }
    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String displayInfo(){
        return "Display Name: "+this.firstName+" "+this.lastName+
                "\nDepartment: "+this.department+
                "\nEmail ID: "+this.email+
                "\nPassword: "+getPassword()+
                "\nAlternate Email: "+getAlternateEmail()+
                "\nMail box capacity: "+getMailBoxCapacity()+" mb";
    }
}

package contactlist.operational;
import contactlist.adt.People;
import contactlist.storage.LinkedList;
import contactlist.storage.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Operational {
    public int run(){
        System.out.println("Welcome Your Contact List App\n" +
                "1.add a new contact\n" +
                "2.view all contacts\n" +
                "3.search for a contact\n" +
                "4.delete a contact\n" +
                "5.exit\n");
        System.out.print("INPUT : ");
        Scanner scan =new Scanner(System.in);
        int input;
        try{
            input=scan.nextInt();
            return input;
        }
        catch (InputMismatchException e){
            return -1;
        }
    }


    public People addNew(){
        People response=input();
        return response;
    }


    public void view(LinkedList linkedList){
        linkedList.show();
    }

    public void delete(LinkedList storage,String name){
        storage.delete(name);
    }

    public void search(LinkedList storage){
        System.out.println("Enter FirstName To Search");
        Scanner scanner=new Scanner(System.in);
        storage.search(scanner.next());

    }

    private People input(){
        People people=new People();
        System.out.println("You have chosen to add a new contact.\n" +
                "Please enter the following : ");
        Scanner scan=new Scanner(System.in);
        System.out.print("First Name : ");
        String fName=scan.next();
        people.setFirstName(fName);
        System.out.print("Last Name : ");
        String lName=scan.next();
        people.setLastName(lName);
        System.out.print("Contact Number : ");
        String number=scan.next();
        people.setNumber(number);
        System.out.print("Would you like to add another contact number? (y/n) : ");
        String optionNumber =scan.next().trim();
        while(optionNumber.charAt(0)=='y'){
            System.out.print("Contact Number : ");
            String newContact=scan.next();
            people.setMultiNumber(newContact);
            System.out.print("Would you like to add another contact number? (y/n) : ");
            optionNumber =scan.next();
        }
        System.out.print("Would you like to add email address? (y/n): ");
        String optionEmail =scan.next().trim();
        while(optionEmail.charAt(0)=='y') {
            System.out.print("Email Address : ");
            String newEmail = scan.next();
            people.setMultiEmail(newEmail);
            System.out.print("Would you like to add another email? (y/n) : ");
            optionEmail = scan.next();
        }
        return people;
    }
    public static void formattedEmailContact(String data){
        String [] emailNumber=data.split("!");
        ArrayList<String> arrayListN=new ArrayList<>();
        arrayListN.addAll(Arrays.asList(emailNumber[0].split(",")));
        if(arrayListN.size()==1){
            System.out.println("Number : "+arrayListN.get(0));
        }
        else{
            System.out.print("Number(s) : ");
            for (String out:
                    arrayListN) {
                System.out.print(out+", ");
            }
            System.out.print("\b\b\n");
        }
        try{
            ArrayList<String> arrayListE=new ArrayList<>();
            arrayListE.addAll(Arrays.asList(emailNumber[1].split(",")));
            arrayListE.remove(0);
            if(arrayListE.size()==1){
                System.out.println("Email : "+arrayListE.get(0));
            }
            else if (arrayListE.size()==0){
                System.out.println("No Emails Saved!");
            }
            else{
                System.out.print("Email(s) : ");
                for (String out:
                        arrayListE) {
                    System.out.print(out+", ");
                }
                System.out.print("\b\b\n");

            }
        }
        catch(NullPointerException e){
            System.out.println("Null Pointer Exception : debug the source code!");

        }
    }
}

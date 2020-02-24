package contactlist.main;
import contactlist.operational.Operational;
import contactlist.storage.LinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operational operational=new Operational();
        LinkedList storage=new LinkedList();
        int input=operational.run();
        while(input!=5){
            switch (input){
                case 1:
                    storage.insert(operational.addNew());
                    input=operational.run();
                    break;
                case 2:
                    operational.view(storage);
                    input=operational.run();
                    break;
                case 3:
                    operational.search(storage);
                    input=operational.run();
                    break;
                case 4:
                    String[] x =storage.contactList();
                    if(x==null){
                        input=operational.run();
                        break;}
                    System.out.println("Here are all your contacts");
                    System.out.println("-------- * -------- * -------- * --------");
                    for (int i = 0; i < x.length; i++) {
                        System.out.println((i+1)+". "+x[i]);
                    }
                    System.out.println("-------- * -------- * -------- * --------");
                    Scanner scan= new Scanner(System.in);
                    System.out.print("Enter the number against name to delete : ");
                    try{
                    int index=scan.nextInt();
                    operational.delete(storage,x[index-1]);}
                    catch (InputMismatchException | ArrayIndexOutOfBoundsException e){
                        System.out.println("Invalid Input!");
                    }

                    input=operational.run();
                    break;
                default:
                    System.out.println("INVALID INPUT!\n"+"Try Again...\n\n");
                    input=operational.run();
            }
        }
    }
}

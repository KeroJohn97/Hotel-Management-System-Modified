import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Food implements Serializable
{
    private int itemno;
    private int quantity;
    private float price;

    public void setItemno(int itemno){ this.itemno = itemno; }
    public int getItemno() { return this.itemno; }
    public void setQuantity(int quantity){ this.quantity = quantity; }
    public int getQuantity() { return this.quantity; }
    public void setPrice(float price){ this.price = price; }
    public float getPrice() { return this.price; }

    Food(int itemno, int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }
}
class Singleroom implements Serializable
{
    String name;
    String contact;
    String gender;
    ArrayList<Food> food =new ArrayList<>();


    Singleroom()
    {
        this.name="";
    }

    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}

class Doubleroom extends Singleroom implements Serializable
{
    String name2;
    String contact2;
    String gender2;

    Doubleroom()
    {
        this.name="";
        this.name2="";
    }

    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}

class Tripleroom extends Doubleroom implements Serializable
{
    String name3;
    String contact3;
    String gender3;

    Tripleroom()
    {
        this.name="";
        this.name2="";
        this.name3="";
    }

    Tripleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
        this.name3=name3;
        this.contact3=contact3;
        this.gender3=gender3;
    }
}

class holder implements Serializable
{
    Doubleroom luxury_doublerrom[]=new Doubleroom[10]; //Luxury
    Doubleroom deluxe_doublerrom[]=new Doubleroom[20]; //Deluxe
    Singleroom luxury_singleerrom[]=new Singleroom[10]; //Luxury
    Singleroom deluxe_singleerrom[]=new Singleroom[20]; //Deluxe
}

class Hotel
{
    static holder hotel_ob=new holder();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2=sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
        }

        switch (i) {
            case 1:hotel_ob.luxury_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:hotel_ob.deluxe_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:hotel_ob.luxury_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:hotel_ob.deluxe_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }

    static void bookLuxuryDoubleRoom(int j, int rn){
        int i = 1;
        for(j=0;j<hotel_ob.luxury_doublerrom.length;j++)
        {
            if(hotel_ob.luxury_doublerrom[j]==null)
            {
                System.out.print(j+1+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try{
            rn=sc.nextInt();
            rn--;
            if(hotel_ob.luxury_doublerrom[rn]!=null)
                throw new Exception("Not Available !");
            CustDetails(i,rn);
        }
        catch(Exception e)
        {
            System.out.println("Invalid Option");
            return;
        }
    }

    static void bookDeluxeDoubleRoom(int j, int rn){
        int i = 2;
        for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
        {
            if(hotel_ob.deluxe_doublerrom[j]==null)
            {
                System.out.print(j+11+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try{
            rn=sc.nextInt();
            rn=rn-11;
            if(hotel_ob.deluxe_doublerrom[rn]!=null)
                throw new Exception("Not Available !");
            CustDetails(i,rn);
        }
        catch(Exception e)
        {
            System.out.println("Invalid Option");
            return;
        }
    }

    static void bookLuxurySingleRoom(int j, int rn){
        int i = 3;
        for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
        {
            if(hotel_ob.luxury_singleerrom[j]==null)
            {
                System.out.print(j+31+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try{
            rn=sc.nextInt();
            rn=rn-31;
            if(hotel_ob.luxury_singleerrom[rn]!=null)
                throw new Exception("Not Available !");
            CustDetails(i,rn);
        }
        catch(Exception e)
        {
            System.out.println("Invalid Option");
            return;
        }
    }

    static void bookDeluxeSingleRoom(int j, int rn){
        int i = 4;
        for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
        {
            if(hotel_ob.deluxe_singleerrom[j]==null)
            {
                System.out.print(j+41+",");
            }
        }
        System.out.print("\nEnter room number: ");
        try{
            rn=sc.nextInt();
            rn=rn-41;
            if(hotel_ob.deluxe_singleerrom[rn]!=null)
                throw new Exception("Not Available !");
            CustDetails(i,rn);
        }
        catch(Exception e)
        {
            System.out.println("Invalid Option");
            return;
        }
    }

    static void bookroom(int i)
    {
        // Start execution
        long begin = System.nanoTime();

        int j = 0;
        int rn = 0;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                bookLuxuryDoubleRoom(j, rn);
                break;
            case 2:
                bookDeluxeDoubleRoom(j, rn);
                break;
            case 3:
                bookLuxurySingleRoom(j, rn);
                break;
            case 4:
                bookDeluxeSingleRoom(j, rn);
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");

        // End of execution
        long end = System.nanoTime();
        System.out.println("\nBookroom() Elapsed Time: " + (end - begin) + " ns\n");
    }

    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }

    static int checkRoomSize(int i){
        if(i == 1)
            return 10;
        if(i == 2)
            return hotel_ob.deluxe_doublerrom.length;
        if(i == 3)
            return hotel_ob.luxury_singleerrom.length;
        if(i == 4)
            return hotel_ob.deluxe_singleerrom.length;
        return 0;
    }

    static void availability(int i)
    {
        // Start execution
        long begin = System.nanoTime();

        if (i != 1 && i != 2 && i != 3 && i != 4){
            System.out.println("Enter valid option");
            return;
        }
        int j, count = 0;
        int roomSize = checkRoomSize(i);
        for(j=0; j < roomSize; j++)
        {
            if(i == 1) {
                if(hotel_ob.luxury_doublerrom[j]==null)
                    count++;
            }
            if(i == 2) {
                if(hotel_ob.deluxe_doublerrom[j]==null)
                    count++;
            }
            if(i == 3) {
                if(hotel_ob.luxury_singleerrom[j]==null)
                    count++;
            }
            if(i == 4) {
                if(hotel_ob.deluxe_singleerrom[j]==null)
                    count++;
            }
        }
        System.out.println("Number of rooms available : "+count);

        // End of execution
        long end = System.nanoTime();
        System.out.println("\nAvailability() Elapsed Time: " + (end - begin) + " ns\n");
    }

    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");

        switch(rtype)
        {
            case 1:
                amount+=4000;
                System.out.println("\nRoom Charge - "+4000);
                System.out.println("\n===============");
                System.out.println("Food Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:hotel_ob.luxury_doublerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                }

                break;
            case 2:amount+=3000;
                System.out.println("Room Charge - "+3000);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:hotel_ob.deluxe_doublerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                }
                break;
            case 3:amount+=2200;
                System.out.println("Room Charge - "+2200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb:hotel_ob.luxury_singleerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                }
                break;
            case 4:amount+=1200;
                System.out.println("Room Charge - "+1200);
                System.out.println("\nFood Charges:- ");
                System.out.println("===============");
                System.out.println("Item   Quantity    Price");
                System.out.println("-------------------------");
                for(Food obb: hotel_ob.deluxe_singleerrom[rn].food)
                {
                    amount+=obb.getPrice();
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }

    static void checkoutConfirmation(int w, int rn, int rtype){
        System.out.println("Do you want to checkout ?(y/n)");
        w=sc.next().charAt(0);
        if(w=='y'||w=='Y')
        {
            bill(rn,rtype);
            hotel_ob.luxury_doublerrom[rn]=null;
            System.out.println("Deallocated successfully");
        }
    }

    static void deallocate(int rn,int rtype)
    {
        // Start execution
        long begin = System.nanoTime();

        int j;
        char w = 'y';
        switch (rtype) {
            case 1:
                if(hotel_ob.luxury_doublerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_doublerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                checkoutConfirmation(w, rn, rtype);
                break;
            case 2:
                if(hotel_ob.deluxe_doublerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_doublerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                checkoutConfirmation(w, rn, rtype);
                break;
            case 3:
                if(hotel_ob.luxury_singleerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_singleerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                checkoutConfirmation(w, rn, rtype);
                break;
            case 4:
                if(hotel_ob.deluxe_singleerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_singleerrom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                checkoutConfirmation(w, rn, rtype);
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }

        // End of execution
        long end = System.nanoTime();
        System.out.println("\nDeallocate() Elapsed Time: " + (end - begin) + " ns\n");
    }

    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
        try{
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q=sc.nextInt();

                switch(rtype){
                    case 1: hotel_ob.luxury_doublerrom[rn].food.add(new Food(i,q));
                        break;
                    case 2: hotel_ob.deluxe_doublerrom[rn].food.add(new Food(i,q));
                        break;
                    case 3: hotel_ob.luxury_singleerrom[rn].food.add(new Food(i,q));
                        break;
                    case 4: hotel_ob.deluxe_singleerrom[rn].food.add(new Food(i,q));
                        break;
                }
                System.out.println("Do you want to order anything else ? (y/n)");
                wish=sc.next().charAt(0);
            }while(wish=='y'||wish=='Y');
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Cannot be done");
        }
    }
}


class write implements Runnable
{
    holder hotel_ob;
    write(holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
        try{
            FileOutputStream fout=new FileOutputStream("backup");
            ObjectOutputStream oos=new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }

    }

}

public class Main {
    public static void main(String[] args){

        // Start execution
        long begin = System.nanoTime();

        try
        {
            File f = new File("backup");
            if(f.exists())
            {
                FileInputStream fin=new FileInputStream(f);
                ObjectInputStream ois=new ObjectInputStream(fin);
                Hotel.hotel_ob=(holder)ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch,ch2;
            char wish;
            x:
            do{

                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.order(ch2-41,4);
                        else if(ch2>30)
                            Hotel.order(ch2-31,3);
                        else if(ch2>10)
                            Hotel.order(ch2-11,2);
                        else if(ch2>0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                            System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.deallocate(ch2-41,4);
                        else if(ch2>30)
                            Hotel.deallocate(ch2-31,3);
                        else if(ch2>10)
                            Hotel.deallocate(ch2-11,2);
                        else if(ch2>0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0);
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }

            }while(wish=='y'||wish=='Y');

            Thread t=new Thread(new write(Hotel.hotel_ob));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }

        // End of execution
        long end = System.nanoTime();
        System.out.println("\nTotal Elapsed Time: " + (end - begin) + " ns\n");
    }
}
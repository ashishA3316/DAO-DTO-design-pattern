package demo;

import dao.MobileDAO;
import dto.MobileDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class MobileMainApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-------Enter Your Choice-------");
        System.out.println("1. Add New Mobile");
        System.out.println("2. Search Mobile");
        System.out.println("3. Delete Mobile");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1 :
                addMobile();
                break;

            case 2 :
                searchMobile();
                break;

            case 3 :
                deleteMobile();

            default:
                System.out.println("Invalid Choice !!");
        }

    }
//add Mobile details--------------------------------------------------------
    private static void addMobile() {
        System.out.println("Enter Model NO");
        int no = sc.nextInt();
        System.out.println("Enter Model Name");
        String name = sc.next();
        System.out.println("Enter Mobile Company");
        String comp = sc.next();
        System.out.println("Enter Mobile RAM");
        int ram = sc.nextInt();
        System.out.println("Enter Mobile Camera");
        int cam = sc.nextInt();
        System.out.println("Enter Mobile Price");
        double price = sc.nextDouble();
        //add data into DTO Object
        MobileDTO dt = new MobileDTO();
        dt.setModelNo(no);
        dt.setModelName(name);
        dt.setCompany(comp);
        dt.setRam(ram);
        dt.setCamera(cam);
        dt.setPrice(price);
        //call method from DAO class
        MobileDAO da = new MobileDAO();
        int count = da.insertMobileDetails(dt);
        System.out.println(count+" Mobile Details Inserted Successfully");
    }
//search Mobile-----------------------------------------------------------------------------
    private static void searchMobile() {
        boolean status = true;

        System.out.println("Select Your Choice");
        System.out.println("1. Search By Company");
        System.out.println("2. Search By Price");
        System.out.println("3. Search By RAM");
        System.out.println("4. Search By Camera");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1 :
                Company();
                break;

            case 2 :
                Price();
                break;

            case 3 :
                RAM();
                break;

            case 4 :
                Camera();
                break;

            default:
                System.out.println("Invalid Choice !!");
                break;
        }

    }

    private static void Company() {
        System.out.println("Enter the Name of Company");
        String name = sc.next();
        MobileDTO dt = new MobileDTO();
        dt.setCompany(name);
        MobileDAO da = new MobileDAO();
        ArrayList<MobileDTO> data = da.DisplayMobileByCompany(dt);
//        System.out.println("Model Name");
        for (MobileDTO data1 : data)
        {
            System.out.println(data1.getModelName());
        }
    }

    private static void Price() {
        System.out.println("Enter the Starting Price");
        double Sprice = sc.nextDouble();
        System.out.println("Enter the Ending Price");
        double Eprice = sc.nextDouble();
        MobileDAO da = new MobileDAO();
        ArrayList<MobileDTO> data1 = da.DisplayMobileByPrice(Sprice, Eprice);
        for (MobileDTO data : data1)
        {
            System.out.println(data);
        }
    }

    private static void RAM() {
        System.out.println("Enter the RAM of Mobile");
        int ram = sc.nextInt();
        MobileDAO da = new MobileDAO();
        ArrayList<MobileDTO> data1 = da.DisplayMobileByRam(ram);
        for (MobileDTO data : data1)
        {
            System.out.println(data);
        }
    }

    private static void Camera() {
        System.out.println("Enter the Start_MP of Camera");
        int st = sc.nextInt();
        System.out.println("Enter the End_MP of Camera");
        int ed = sc.nextInt();
        MobileDAO da = new MobileDAO();
        ArrayList<MobileDTO> data1 = da.DisplayMobileByCamera(st, ed);
        for(MobileDTO data : data1)
        {
            System.out.println(data);
        }
    }
    //delete Mobile-----------------------------------------------------------------------------
    private static void deleteMobile() {
        System.out.println("Enter Model No");
        int no = sc.nextInt();

        MobileDTO dt = new MobileDTO();
        dt.setModelNo(no);

        MobileDAO da = new MobileDAO();
        int count = da.deleteMobile(dt);

        System.out.println(count+ " Mobile Deleted Successfully");

    }

}

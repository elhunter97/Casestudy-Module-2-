package view;

import models.Bill;
import models.Medicine;

import java.util.List;
import java.util.Scanner;

public class View {

    public int viewMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add new medicine");
        System.out.println("2. Delete medicine by name");
        System.out.println("3. Create new bill");
        System.out.println("4. Edit medicine information");
        System.out.println("5. Sort medicine by price");
        System.out.println("6. Sort medicine by name");
        System.out.println("7. Display medicine sold");
        System.out.println("8. Display medicine exist");
        System.out.println("9. Display list medicine expiry date");
        System.out.println("10.Display list medicine nearly expiry date");
        System.out.println("0. End Program");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public Medicine viewAddMedicine(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter medicine name: ");
        String name = sc.nextLine();
        System.out.print("Enter medicine type: ");
        String type = sc.nextLine();
        System.out.print("Enter input date(dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        System.out.print("Enter expiry date(dd/MM/yyyy): ");
        String expiryDate = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        Medicine medicine = new Medicine(name,type,inputDate,expiryDate,price,quantity);
        return medicine;
    }
    public void displayMedicines(List<Medicine> medicines) {
        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }

    public void displayBills(List<Bill> bills) {
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

package controllers;
import models.Bill;
import models.Medicine;
import view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        Medicine medicine;
        boolean res = false;
        Scanner scanner = new Scanner(System.in);

        int choice;
        while (true) {
            choice = view.viewMenu();
            switch (choice) {
                case 1:
                        medicine = view.viewAddMedicine();
                        res = controller.addMedicine(medicine);
                    break;
                case 2:
                    System.out.println("Nhập tên thuốc cần xóa:");
                    String delName = scanner.nextLine();
                    controller.deleteMedicine(delName);
                    break;
                case 3:
                    System.out.println("Nhập thông tin hóa đơn (id khách hàng, tên khách hàng, tên thuốc, số lượng, tổng giá):");
                    String customerId = scanner.nextLine();
                    String customerName = scanner.nextLine();
                    String medicineName = scanner.nextLine();
                    int billQuantity = scanner.nextInt();
                    int totalPrice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Bill bill = new Bill(customerId, customerName, medicineName, billQuantity, totalPrice);
                    controller.createBill(bill);
                    break;
                case 4:
//                    System.out.println("Nhập tên thuốc cần cập nhật và thông tin mới (id, tên, loại, ngày nhập, ngày hết hạn, giá, số lượng):");
//                    String updateName = scanner.nextLine();
//                    id = scanner.nextLine();
//                    name = scanner.nextLine();
//                    medType = scanner.nextLine();
//                    inputDate = scanner.nextLine();
//                    expDate = scanner.nextLine();
//                    price = scanner.nextInt();
//                    quantity = scanner.nextInt();
//                    scanner.nextLine(); // Consume newline
//                    Medicine updatedMedicine = new Medicine(id, name, medType, inputDate, expDate, price, quantity);
//                    controller.updateMedicine(updateName, updatedMedicine);
                    break;
                case 5:
                    controller.sortMedicinesByPrice();
                    break;
                case 6:
                    controller.sortMedicinesByName();
                    break;
                case 7:
                    controller.displaySoldProducts();
                    break;
                case 8:
                    controller.displayStock();
                    break;
                case 9:
                    controller.displayExpiredMedicines();
                    break;
                case 10:
                    controller.displayNearExpiryMedicines();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}

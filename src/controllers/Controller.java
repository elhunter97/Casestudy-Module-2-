package controllers;
import models.Bill;
import models.Medicine;
import view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    public static final String SRC_MEDICINE = "src/data/medicines.csv";
    public static final String SRC_BILL = "ssrc/data/sell.csv";
    private List<Medicine> medicines = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    private View view;

    public Controller(View view) {
        this.view = view;
        loadMedicines();
        loadBills();
    }

    private void loadMedicines() {
        try (BufferedReader br = new BufferedReader(new FileReader(SRC_MEDICINE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Medicine medicine = new Medicine(data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]));
                medicines.add(medicine);
            }
        } catch (IOException e) {
            view.displayMessage("Error loading medicines: " + e.getMessage());
        }
    }

    private void loadBills() {
        try (BufferedReader br = new BufferedReader(new FileReader(SRC_BILL))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Bill bill = new Bill(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                bills.add(bill);
            }
        } catch (IOException e) {
            view.displayMessage("Error loading bills: " + e.getMessage());
        }
    }

    private void saveMedicines() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SRC_MEDICINE))) {
            for (Medicine medicine : medicines) {
                bw.write(medicine.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            view.displayMessage("Error saving medicines: " + e.getMessage());
        }
    }

    private void saveBills() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SRC_BILL))) {
            for (Bill bill : bills) {
                bw.write(bill.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            view.displayMessage("Error saving bills: " + e.getMessage());
        }
    }

    public boolean addMedicine(Medicine medicine) {
        if(medicine.getName().isEmpty() || medicine.getMedType().isEmpty()){
            return false;
        }
        if(medicine.getPrice()<=0 || medicine.getQuantity()<=0){
            return false;
        }
        medicines.add(medicine);
        saveMedicines();
        view.displayMessage("Medicine added successfully!");
        return true;
    }

    public void deleteMedicine(String name) {
        medicines.removeIf(m -> m.getName().equalsIgnoreCase(name));
        saveMedicines();
        view.displayMessage("Medicine deleted successfully!");
    }

    public void createBill(Bill bill) {
        bills.add(bill);
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(bill.getMedicineName())) {
                medicine.setQuantity(medicine.getQuantity() - bill.getQuantity());
                break;
            }
        }
        saveBills();
        saveMedicines();
        view.displayMessage("Bill created successfully!");
    }

    public void updateMedicine(String name, Medicine updatedMedicine) {
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                medicine.setId(updatedMedicine.getId());
                medicine.setName(updatedMedicine.getName());
                medicine.setMedType(updatedMedicine.getMedType());
                medicine.setInputDate(updatedMedicine.getInputDate());
                medicine.setExpDate(updatedMedicine.getExpDate());
                medicine.setPrice(updatedMedicine.getPrice());
                medicine.setQuantity(updatedMedicine.getQuantity());
                break;
            }
        }
        saveMedicines();
        view.displayMessage("Medicine updated successfully!");
    }

    public void sortMedicinesByName() {
        medicines.sort(Comparator.comparing(Medicine::getName));
        view.displayMedicines(medicines);
    }

    public void sortMedicinesByPrice() {
        medicines.sort(Comparator.comparingInt(Medicine::getPrice));
        view.displayMedicines(medicines);
    }

    public void displaySoldProducts() {
        view.displayBills(bills);
    }

    public void displayStock() {
        view.displayMedicines(medicines);
    }

    public void displayExpiredMedicines() {
        List<Medicine> expiredMedicines = new ArrayList<>();
        String currentDate = java.time.LocalDate.now().toString();
        for (Medicine medicine : medicines) {
            if (medicine.getExpDate().compareTo(currentDate) < 0) {
                expiredMedicines.add(medicine);
            }
        }
        view.displayMedicines(expiredMedicines);
    }

    public void displayNearExpiryMedicines() {
        List<Medicine> nearExpiryMedicines = new ArrayList<>();
        String currentDate = java.time.LocalDate.now().toString();
        java.time.LocalDate currentDateObj = java.time.LocalDate.parse(currentDate);
        for (Medicine medicine : medicines) {
            java.time.LocalDate expDateObj = java.time.LocalDate.parse(medicine.getExpDate());
            if (!expDateObj.isBefore(currentDateObj) && expDateObj.minusDays(30).isBefore(currentDateObj)) {
                nearExpiryMedicines.add(medicine);
            }
        }
        view.displayMedicines(nearExpiryMedicines);
    }
}


package models;

public class Bill {
    private String customerId;
    private String customerName;
    private String medicineName;
    private int quantity;
    private int totalPrice;

    // Constructor
    public Bill(String customerId, String customerName, String medicineName, int quantity, int totalPrice) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return customerId + "," + customerName + "," + medicineName + "," + quantity + "," + totalPrice;
    }
}

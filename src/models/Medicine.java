package models;

public class Medicine {
    private String id;
    private String name;
    private String medType;
    private String inputDate;
    private String expDate;
    private int price;
    private int quantity;
    private static int cnt = 0;

    public Medicine(String name, String medType, String inputDate, String expDate, int price, int quantity) {
        this.id = String.format("MED%04d",++cnt);
        this.name = name;
        this.medType = medType;
        this.inputDate = inputDate;
        this.expDate = expDate;
        this.price = price;
        this.quantity = quantity;
    }

    public Medicine(String id, String name, String medType, String inputDate, String expDate, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.medType = medType;
        this.inputDate = inputDate;
        this.expDate = expDate;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedType() {
        return medType;
    }

    public void setMedType(String medType) {
        this.medType = medType;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void formatInputDate(){
        StringBuilder sb = new StringBuilder(inputDate);
        if(sb.charAt(1)=='/') sb.insert(0,'0');
        if(sb.charAt(4)=='/') sb.insert(3,'0');
        inputDate = sb.toString();
    }
    public void formatExpDate(){StringBuilder sb = new StringBuilder(expDate);
        if(sb.charAt(1)=='/') sb.insert(0,'0');
        if(sb.charAt(4)=='/') sb.insert(3,'0');
        expDate = sb.toString();
    }
    @Override
    public String toString() {
        formatInputDate();
        formatExpDate();
        return id + "," + name + "," + medType + "," + inputDate + "," + expDate + "," + price + "," + quantity;
    }
}

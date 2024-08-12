class MobilePhone {
    private String brand;
    private String model;
    private double price;
    private int storageCapacity;

    public MobilePhone(String brand, String model, double price, int storageCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
    }

    public void displayPhoneDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }

    public static void comparePrices(MobilePhone phone1, MobilePhone phone2) {
        if (phone1.price < phone2.price) {
            System.out.println(phone1.brand + " " + phone1.model + " is cheaper than " + phone2.brand + " " + phone2.model);
        } else if (phone1.price > phone2.price) {
            System.out.println(phone2.brand + " " + phone2.model + " is cheaper than " + phone1.brand + " " + phone1.model);
        } else {
            System.out.println("Both phones have the same price.");
        }
    }
    public void checkRequirements(int minStorage) {
        if (storageCapacity >= minStorage) {
            System.out.println(brand + " " + model + " meets the minimum storage requirement of " + minStorage + "GB.");
        } else {
            System.out.println(brand + " " + model + " does not meet the minimum storage requirement of " + minStorage + "GB.");
        }
    }
    public int getStorageCapacity() {
        return storageCapacity;
    }
}


public class Main {
    public static void main(String[] args) {
        MobilePhone[] phones = new MobilePhone[3];
        phones[0] = new MobilePhone("Apple", "iPhone 12", 999.99, 256);
        phones[1] = new MobilePhone("Samsung", "Galaxy S21", 899.99, 128);
        phones[2] = new MobilePhone("Google", "Pixel 5", 699.99, 128);

        MobilePhone maxStoragePhone = phones[0];
        for (int i = 1; i < phones.length; i++) {
            if (phones[i].getStorageCapacity() > maxStoragePhone.getStorageCapacity()) {
                maxStoragePhone = phones[i];
            }
        }
        System.out.println("Phone with the highest storage capacity:");
        maxStoragePhone.displayPhoneDetails();
    }
}
package TES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Qurbanku {
    private List<Customer> customers;
    private String filename;

    public Qurbanku(String filename) {
        this.filename = filename;
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomerByphoneNumber(String phonenumber) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getPhoneNumber().equals(phonenumber)) {
                iterator.remove();
                System.out.println("Pembeli berhasil dihapus.");
                return;
            }
        }
        System.out.println("Pembeli tidak ditemukan.");
    }

    public void resetData() {
        customers.clear();
        System.out.println("Semua data pembeli berhasil di reset.");
    }

    public void saveData() {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Customer customer : customers) {
                StringBuilder sb = new StringBuilder();
                sb.append(customer.getName()).append(",");
                sb.append(customer.getAdress()).append(",");
                sb.append(customer.getPhoneNumber());
                for (String order : customer.getOrders()) {
                    sb.append(",").append(order);
                }
                writer.println(sb.toString());
            }
            System.out.println("Data sukses tersimpan.");
        } catch (FileNotFoundException e) {
            System.out.println("Error terjadi saat menyimpan data.");
        }
    }

    public void loadData() {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String adress = data[1];
                    String phoneNumber = data[2];
                    List<String> orders = new ArrayList<>();
                    if (data.length > 3) {
                        for (int i = 3; i < data.length; i++) {
                            orders.add(data[i]);
                        }
                    }
                    if (!phoneNumber.startsWith("+62")) {
                        phoneNumber = "+62" + phoneNumber;
                    }
                    Customer customer = new Customer(name, adress, phoneNumber, orders);
                    customers.add(customer);
                }
            }
            System.out.println("Data berhasil dimuat.");
        } catch (FileNotFoundException e) {
            System.out.println("Error terjadi saat memuat data.");
        }
    }

    public void displayData() {
        int index = 1;
        for (Customer customer : customers) {
            System.out.println("Data " + index + ":");
            System.out.println("Nama    : " + customer.getName());
            System.out.println("Alamat  : " + customer.getAdress());
            System.out.println("No. Hp  : " + customer.getPhoneNumber());
            List<String> orders = customer.getOrders();
            if (!orders.isEmpty()) {
                System.out.println("Pilihan : ");
                for (String order : orders) {
                    System.out.println("- " + order);
                }
            }
            System.out.println("----------------------");
            index++;
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

package TES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Qurbanku qurbanku = new Qurbanku("customer_data.txt");
        qurbanku.loadData();

        Pilihan pilihan = new Pilihan(qurbanku);
        Scanner scanner = new Scanner(System.in);

        int choice;
        boolean hasData = !qurbanku.getCustomers().isEmpty();
        List<String> orders = new ArrayList<>();

        do {
            System.out.println("1. Masukkan Data");
            System.out.println("2. Hapus Data Pembeli");
            System.out.println("3. Hapus Semua Data");
            if (hasData) {
                System.out.println("4. Tampilkan data");
            }
            System.out.println("5. Keluar");
            System.out.println("6. Pilihan Qurban");
            System.out.print("Masukkan Pilihan (1, 2, 3, 4, 5, atau 6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Masukkan Data Pembeli:");
                    System.out.print("Nama : ");
                    String name = scanner.nextLine();
                    System.out.print("Alamat : ");
                    String adress = scanner.nextLine();
                    System.out.print("No. Hp : ");
                    String phoneNumber = scanner.nextLine();

                    qurbanku.addCustomer(new Customer(name, adress, phoneNumber, orders));
                    hasData = true;
                    break;
                case 2:
                    System.out.print("Masukkan No. Hp pembeli : ");
                    String nameToRemove = scanner.nextLine();
                    qurbanku.removeCustomerByphoneNumber(nameToRemove);
                    break;
                case 3:
                    qurbanku.resetData();
                    hasData = false;
                    break;
                case 4:
                    qurbanku.displayData();
                    break;
                case 5:
                    System.out.println("Keluar Program");
                    break;
                case 6:
                    pilihan.PilihanQurban();
                    break;
                default:
                    System.out.println("Pilihan salah. Mohon ulangi lagi.");
                    break;
            }
            qurbanku.saveData();
        } while (choice != 5);
    }
}

package TES;

import java.util.Scanner;
public class Pilihan {
    private Qurbanku qurbanku;
    private Scanner scanner;

    public Pilihan( Qurbanku qurbanku){
        this.qurbanku = qurbanku;
        scanner = new Scanner(System.in);
    }

    public void PilihanQurban(){
        int choice;
        do {
            System.out.println("Pilihan:");
            System.out.println("1. Sapi");
            System.out.println("2. Kambing");
            System.out.println("3. Pilihan");
            System.out.println("Pilih 1, 2, atau 3: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleMenuSelection("Sapi", 6000000);
                    break;
                case 2:
                    handleMenuSelection("Kambing", 3000000);
                    break;
                case 3:
                    System.out.println("Kembali ke Pilihan");
                    break;
                default:
                    System.out.println("Pilihan salah, mohon ulangi lagi. ");
                    break;
            }
        } while (choice != 3);
    }

    private void handleMenuSelection(String menuName, int price) {
        System.out.println("Nama Pembeli : ");
        String customerName = scanner.nextLine();
        Customer customer = findcustomerByName(customerName);

        if (customer != null) {
            System.out.println("Pesanan Diterima!");
            System.out.println("Pilihan : " + menuName);
            System.out.println("Harga : Rp." + price);

                    System.out.println("Masukkan Jumlah Pembayaran : ");
                    int payment = scanner.nextInt();
                    scanner.nextLine();

                    int change = payment - price;
                    if (change < 0){
                        System.out.println("Maaf, uang anda kurang.");
                    } else {
                        System.out.println("Terima Kasih Banyak!");
                        System.out.println("Kembalian : Rp." + change);

                        customer.addOrder(menuName, price);
                        qurbanku.saveData();
                    }
        } else {
            System.out.println("Pembeli Tidak Ditemukan.");
        }
    }

    private Customer findcustomerByName(String name){
        for (Customer pembeli : qurbanku.getCustomers()){
            if (pembeli.getName().equals(name)) {
                return pembeli;
            }
        }
        return null;
    }
}

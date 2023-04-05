public class chickens01 {
    public static void main(String[] args) {

        // scenario 1
        // telur per ayam = 5, jumlah ayam = 3;
        int chiken1, egg1, simpan1;
        int scen1;
        int beruang1;
        simpan1 = 0;
        chiken1 = 3;
        egg1 = 5;
        scen1 = chiken1 * egg1;
        simpan1 = simpan1 + scen1;
        System.out.println("scan 1");
        System.out.println("pada hari senin : "+simpan1);
        chiken1++;
        scen1 = chiken1 * egg1;
        simpan1 = simpan1 + scen1;
        System.out.println("\n"+"pada hari selasa : "+simpan1);
        beruang1 = 2;
        chiken1 =  chiken1 / beruang1;
        scen1 = chiken1 * egg1;
        simpan1 = simpan1 + scen1;
        System.out.println("\n"+"pada hari rabu : "+simpan1);

        System.out.println("=================================================================");
        //scenario 2
        //telur per ayam = 4, jumlah ayam = 8
        int chiken2, egg2, simpan2;
        int scen2;
        int beruang2;
        simpan2 = 0;
        chiken2 = 8;
        egg2 = 4;
        scen2 = chiken2 * egg2;
        simpan2 = simpan2 + scen2;
        System.out.println("scan 2");
        System.out.println("pada hari senin : "+simpan2);
        chiken2++;
        scen2 = chiken2 * egg2;
        simpan2 = simpan2 + scen2;
        System.out.println("\n"+"pada hari selasa : "+simpan2);
        beruang2 = 2;
        chiken2 =  chiken2 / beruang2;
        scen2 = chiken2 * egg2;
        simpan2 = simpan2 + scen2;
        System.out.println("\n"+"pada hari rabu : "+simpan2);

    }
}

// tugas 1
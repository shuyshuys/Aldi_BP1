
import java.util.Scanner;

public class AppFinalProject {
    // variabel global
    static Scanner sc = new Scanner(System.in);
    static String dataBarang[][] = new String[10][2];
    static String transaksi[][] = new String[10][4];
    static int jumBarang = 0;

    // method2
    static int hitungtotal(int jumlah, int harga) {
        return jumlah * harga;
    }

    static void tambahBarang(String nmBarang, String hrgBarang) {
        if (jumBarang >= 7) {
            System.out.println("Kapasitas penuh...");
        } else {
            dataBarang[jumBarang][0] = nmBarang;
            dataBarang[jumBarang][1] = hrgBarang;
            System.out.println("Penambahan berhasil...");
            jumBarang++;
        }
    }

    static void hasilPenambahan() {
        for (int i = 0; i < jumBarang; i++) {
            System.out.print((i + 4) + ".\t");
            System.out.println(dataBarang[i][0] + "\t| " + "Rp. " + dataBarang[i][1]);
        }
        System.out.println("");
    }

    public static String[] cariBarang(String kodeBarang) {
        // Cari data barang berdasarkan kode barang
        for (int i = 0; i < dataBarang.length; i++) {
            if (dataBarang[i][0].equals(kodeBarang)) {
                return dataBarang[i];
            }
        }
        // Kembalikan null jika tidak ditemukan
        return null;
    }

    public static void ubahDataBarang(String kodeBarang) {
        Scanner input = new Scanner(System.in);
        // Cari data barang yang akan diubah
        String[] data = cariBarang(kodeBarang);
        if (data != null) {
            // Ubah data barang
            System.out.print("Masukkan nama barang baru: ");
            String namaBarang = input.next();
            System.out.print("Masukkan harga barang baru: ");
            int hargaBarang = input.nextInt();

            data[1] = namaBarang;
            data[2] = String.valueOf(hargaBarang);
        } else {
            System.out.println("Kode barang tidak ditemukan");
        }
        input.close();
    }

    public static void main(String[] args) {
        // Variabel Lokal(hanya bisa diakses di dalam kurung kurawa)
        // Array (transaksi, master barang)
        // contoh pengisisan
        dataBarang[0][0] = "sandal";
        dataBarang[0][1] = "50000";
        dataBarang[1][0] = "sepatu";
        dataBarang[1][1] = "150000";
        dataBarang[2][0] = "Tas";
        dataBarang[2][1] = "100000";

        transaksi[0][0] = "101";
        transaksi[0][1] = "Sepatu";
        transaksi[0][2] = "5";
        System.out.println(transaksi[0][0]);
        int jumlah = Integer.valueOf(transaksi[0][2]);
        int harga = Integer.valueOf(dataBarang[1][1]);
        int total = hitungtotal(jumlah, harga);
        transaksi[0][3] = String.valueOf(total); // harga total
        // System.out.println(transaksi[0][3]);
        Scanner sc = new Scanner(System.in);
        int pilihMode = 0;
        do {
            System.out.println("================================");
            System.out.println("\tTOKO BARANG MURAH");
            System.out.println("================================");
            System.out.println("1. Admin");
            System.out.println("2. Kasir");
            System.out.println("3. Pemilik");
            System.out.println("4. Selesai");
            System.out.print("Pilih: ");
            pilihMode = sc.nextInt();
            switch (pilihMode) {
                case 1:
                    int pilihAdmin = 0;
                    System.out.println("-----------------------------");
                    System.out.println("\tMode Admin");
                    System.out.println("-----------------------------");
                    do {
                        System.out.println("1. Lihat Barang");
                        System.out.println("2. Tambah Barang");
                        System.out.println("3. Ubah Barang");
                        System.out.println("4. Hapus Barang");
                        System.out.println("5. Exit");
                        System.out.print("Pilih: ");
                        pilihAdmin = sc.nextInt();
                        switch (pilihAdmin) {
                            case 1:
                                System.out.println("-----------------------------");
                                System.out.println("\tDaftar Barang");
                                System.out.println("-----------------------------");
                                System.out.println("BARANG\t| HARGA");
                                for (int i = 0; i < 5; i++) {
                                    if (dataBarang[i][0] != null) {
                                        System.out.print((i + 1) + ".\t");
                                        System.out.println(dataBarang[i][0] + "\t| " + "Rp. " + dataBarang[i][1]);
                                    }
                                }
                                hasilPenambahan();
                                break;
                            case 2:
                                System.out.println("-----------------------------");
                                System.out.println("\tTambah Barang");
                                System.out.println("-----------------------------");
                                System.out.print("Nama Barang = ");
                                String nama = sc.next();
                                System.out.print("Harga barang = ");
                                String HrgBarang = sc.next();
                                tambahBarang(nama, HrgBarang);
                                System.out.println("");
                                break;
                            case 3:

                                break;
                            case 4:
                                break;
                            case 5:
                                break;

                        }
                    } while (pilihAdmin != 5);
                    break;
                case 2:
                    int pilihKasir = 0;
                    System.out.println("Mode Kasir");
                    do {
                        System.out.println("1. Daftar Barang");
                        System.out.println("2. Cari Barang");
                        System.out.println("3. Exit");
                        System.out.print("Pilih = ");
                        pilihKasir = sc.nextInt();
                        switch (pilihKasir) {
                            case 1:
                                System.out.println("-----------------------------");
                                System.out.println("\tDaftar Barang");
                                System.out.println("-----------------------------");
                                System.out.println("BARANG\t| HARGA");
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("");
                                break;
                            case 3:
                                break;
                        }
                    } while (pilihKasir != 3);
                    break;
                case 3:
                    int pilihPemilik = 0;
                    System.out.println("Mode Pemilik");
                    System.out.println("1. Rekap Data Penjualan");
                    System.out.println("2. Laporan pemesanan Barang");
                    System.out.println("3. Daftar Barang Terlaris");
                    System.out.println("4. Exit");
                    System.out.print("Pilih = ");
                    pilihPemilik = sc.nextInt();
                    switch (pilihPemilik) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Terima Kasih....");
                    break;
            }
        } while (pilihMode != 4);
        sc.close();
    }

}

import java.util.Scanner;

public class appBarang {
    // searching
    static int mCari(String[] data, int[] dataHarga, String cari) {
        int indexKetemu = data.length;
        boolean ketemu = false;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(cari)) {
                ketemu = true;
                System.out.println("Data Ditemukan");
                System.out.println(data[i] + " Rp " + dataHarga[i]);
                indexKetemu = i;
            }
        }

        if (ketemu == false) {
            System.out.println("Data Tidak Ditemukan");
        }

        return indexKetemu;
    }

    static String[] tambahData(String[] data, String dataBaru) {
        String hasil[] = new String[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            hasil[i] = data[i];
        }

        hasil[data.length] = dataBaru;

        return hasil;

    }

    static int[] tambahHarga(int[] harga, int hargaBaru) {
        int hasil[] = new int[harga.length + 1];

        for (int i = 0; i < harga.length; i++) {
            hasil[i] = harga[i];
        }

        hasil[harga.length] = hargaBaru;

        return hasil;
    }

    static String[] hapusData(String[] data, int indexHapus) {
        String hasil[] = new String[data.length - 1];

        for (int i = 0, indexBaru = 0; i < data.length; i++) {
            if (indexHapus != i) {
                hasil[indexBaru++] = data[i];
            }
        }

        return hasil;
    }

    static int[] hapusHarga(int[] harga, int indexHapus) {
        int hasil[] = new int[harga.length - 1];

        for (int i = 0, indexBaru = 0; i < harga.length; i++) {
            if (indexHapus != i) {
                hasil[indexBaru++] = harga[i];
            }
        }

        return hasil;
    }

    // sorting
    static void sortingTerlaris(String[] data, int[] dataHarga, int[] terlaris) {
        int tempInt;
        String tempString;
        for (int i = 0; i < data.length - 1; i++) {
            if (terlaris[i] < terlaris[i + 1]) {
                tempInt = terlaris[i];
                terlaris[i] = terlaris[i + 1];
                terlaris[i + 1] = tempInt;
                tempInt = dataHarga[i];
                dataHarga[i] = dataHarga[i + 1];
                dataHarga[i + 1] = tempInt;
                tempString = data[i];
                data[i] = data[i + 1];
                data[i + 1] = tempString;
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + ". " + data[i] + " Rp " + dataHarga[i] + " terjual " + terlaris[i] + "x");
        }
    }

    // PROGRAM AWAL
    public static void main(String[] args) {

        Scanner insert = new Scanner(System.in);
        String data[] = { "Marlboro", "Djarum", "Camel", "Surya", "Istana" };
        int dataHarga[] = { 20600, 12000, 20000, 29000, 15000 };
        int terlaris[] = { 0, 0, 0, 0, 0 };
        String laporan[] = {};
        String cari = "",
                dataBaru;
        int pilihMode = 1,
                pilihMenu = 1,
                indexKetemu = data.length,
                jumlahBeli = 0,
                totalBayar = 0,
                uangPembeli = 0,
                kembalianPembeli = 0,
                hargaBaru = 0;

        System.out.println("Program Toko Sederhana");

        while (pilihMode != 4) {
            System.out.println("");
            System.out.println("Pilih Hak Akses");
            System.out.println("1. Kasir");
            System.out.println("2. Admin");
            System.out.println("3. Owner");
            System.out.println("4. Keluar");
            System.out.print("Tentukan pilihan : ");
            pilihMode = insert.nextInt();
            pilihMenu = 1;

            if (pilihMode != 4) {
                switch (pilihMode) {
                    case 1: // pilihMode 1 = Mode kasir
                        while (pilihMenu != 3) {
                            System.out.println("");
                            System.out.println("Menu");
                            System.out.println("1. Cari Barang");
                            System.out.println("2. Checkout");
                            System.out.println("3. Keluar");
                            System.out.print("Tentukan pilihan : ");
                            pilihMenu = insert.nextInt();

                            if (pilihMenu == 1) { // pilihMenu 1 = Cari/pilih barang
                                cari = "";
                                while (!"q".equals(cari)) {
                                    System.out.println("");
                                    System.out.println("Ketik 'q' untuk keluar");
                                    System.out.print("Cari barang : ");
                                    cari = insert.next();
                                    if (!"q".equals(cari)) {
                                        System.out.println("");
                                        indexKetemu = mCari(data, dataHarga, cari);
                                        if (indexKetemu < data.length) {
                                            System.out.print("Masukkan jumlah beli : ");
                                            jumlahBeli = insert.nextInt();
                                            totalBayar = dataHarga[indexKetemu] * jumlahBeli;
                                            int lengthTerlaris = terlaris.length;
                                            terlaris[lengthTerlaris - 1] = jumlahBeli;
                                            System.out.println("Data berhasil ditambahkan");
                                            System.out.println("");
                                        }
                                    }
                                }
                            } else if (pilihMenu == 2) { // pilihMenu 2 = Checkout barang
                                System.out.println("");
                                System.out.println("Total Bayar : " + totalBayar);
                                while (uangPembeli < totalBayar) {
                                    System.out.print("Masukkan uang pembeli : ");
                                    uangPembeli = insert.nextInt();
                                    if (uangPembeli < totalBayar) {
                                        System.out.println("Uang Pembeli Kurang");
                                    } else {
                                        kembalianPembeli = uangPembeli - totalBayar;

                                        if (kembalianPembeli > 0) {
                                            System.out.println("Kembalian anda Rp " + kembalianPembeli);
                                        }
                                        laporan = tambahData(laporan,
                                                "Total Bayar Rp " + totalBayar + " Uang Pembeli Rp " + uangPembeli);
                                        System.out.println("Terimakasih");
                                        totalBayar = 0;

                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        while (pilihMenu != 5) { // pilohMenu 2 = Mode admin
                            System.out.println("");
                            System.out.println("Menu");
                            System.out.println("1. Tampilkan Barang");
                            System.out.println("2. Tambah Barang");
                            System.out.println("3. Ubah Barang");
                            System.out.println("4. Hapus Barang");
                            System.out.println("5. Keluar ");
                            System.out.print("Tentukan pilihan : ");
                            pilihMenu = insert.nextInt();
                            System.out.println("");

                            switch (pilihMenu) {
                                case 1:
                                    // pilihMenu 1 = Tampilkan barang
                                    for (int i = 0; i < data.length; i++) {
                                        System.out.println((i + 1) + ". " + data[i] + " Rp " + dataHarga[i]);
                                    }
                                    break;
                                case 2:
                                    // pilihMenu 2 = Tambah barang
                                    System.out.print("Masukkan nama produk : ");
                                    dataBaru = insert.next();
                                    System.out.print("Masukkan harga produk : ");
                                    hargaBaru = insert.nextInt();
                                    data = tambahData(data, dataBaru);
                                    dataHarga = tambahHarga(dataHarga, hargaBaru);
                                    System.out.println("");
                                    System.out.println("Data berhasil ditambahkan");
                                    break;
                                case 3:
                                    // pilihMenu 3 = Ubah barang
                                    System.out.print("Cari barang : ");
                                    cari = insert.next();
                                    System.out.println("");
                                    indexKetemu = mCari(data, dataHarga, cari);
                                    if (indexKetemu < data.length) {
                                        System.out.print("Masukkan nama produk : ");
                                        data[indexKetemu] = insert.next();
                                        System.out.print("Masukkan harga produk : ");
                                        dataHarga[indexKetemu] = insert.nextInt();
                                        System.out.println("");
                                        System.out.println("Data berhasil diubah");
                                    }
                                    break;
                                case 4:
                                    // pilihMenu 4 = Hapus barang
                                    System.out.print("Cari barang : ");
                                    cari = insert.next();
                                    System.out.println("");
                                    indexKetemu = mCari(data, dataHarga, cari);
                                    if (indexKetemu < data.length) {
                                        data = hapusData(data, indexKetemu);
                                        dataHarga = hapusHarga(dataHarga, indexKetemu);
                                        System.out.println("");
                                        System.out.println("Data berhasil dihapus");
                                    }
                                    break;
                            }
                        }
                        break;
                    case 3: // pilihMode 3 = Mode owner
                        while (pilihMenu != 3) {
                            System.out.println("");
                            System.out.println("Menu");
                            System.out.println("1. Laporan");
                            System.out.println("2. Barang Terlaris");
                            System.out.println("3. Keluar ");
                            System.out.print("Tentukan pilihan : ");
                            pilihMenu = insert.nextInt();
                            System.out.println("");

                            if (pilihMenu == 1) { // pilihMenu 1 = Laporan
                                if (laporan.length > 0) {
                                    for (int i = 0; i < laporan.length; i++) {
                                        System.out.println((i + 1) + ". " + laporan[i]);
                                    }
                                } else {
                                    System.out.println("Laporan masih kosong");
                                }
                            } else if (pilihMenu == 2) { // pilihMenu 2 = Barang terlaris
                                sortingTerlaris(data, dataHarga, terlaris);
                            }
                        }
                        break;
                }

            }
        }
        insert.close();

    }
}
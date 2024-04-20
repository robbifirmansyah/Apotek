import java.util.Scanner;

public class Apotek {

    private static Obat[] rakObat;
    private int obatDibeli = 0;
    private int totalPenjualan = 0;
    Apotek(int kapasitasRak) {
        rakObat = new Obat[kapasitasRak];
    }
    static Scanner scanner = new Scanner(System.in);



    void utama(){
        while(true){
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            switch(pilihan){
                case 1:
                    lihatObat();
                    break;
                case 2:
                    System.out.print("Nama obat: ");
                    String nama = scanner.next();
                    System.out.print("Stok obat: ");
                    int stok = scanner.nextInt();
                    System.out.print("Harga obat: ");
                    int harga = scanner.nextInt();
                    System.out.print("Index tambah: ");
                    int indexTambah = scanner.nextInt();
                    tambahObat(indexTambah, nama, stok, harga);
                    break;
                case 3:
                    System.out.print("Index 1: ");
                    int index1 = scanner.nextInt();
                    System.out.print("Index 2: ");
                    int index2 = scanner.nextInt();
                    pindahObat(index1, index2);
                    break;
                case 4:
                    System.out.print("Index beli: ");
                    int indexBeli = scanner.nextInt();
                    System.out.print("Jumlah beli: ");
                    int jumlah = scanner.nextInt();
                    beliObat(indexBeli, jumlah);
                    break;
                case 5:
                    rekap();
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    static void tampilkanMenu(){
        System.out.println("Selamat datang di Apotek");
        System.out.println("1. Lihat obat");
        System.out.println("2. Tambah obat");
        System.out.println("3. Pindah obat");
        System.out.println("4. Beli obat");
        System.out.println("5. Keluar");
        System.out.print("Pilihan: ");
    }

    void lihatObat() {
        System.out.println("Daftar obat: ");
        System.out.println("-".repeat(40));
        for (int i = 0; i < rakObat.length; i++) {
            if (rakObat[i] != null) {
                System.out.printf("Nama: %s | Harga: %d | Stok: %d\n", i, rakObat[i].getNama(), rakObat[i].getHarga(), rakObat[i].getStok());
            } else {
                System.out.printf("(kosong)\n", i);
            }
            System.out.println("-".repeat(40));
        }
    }



    static void tambahObat(int i, String nama, int stok, int harga){
        if (rakObat[i] != null) {
            System.out.println("Rak sudah terisi");
        } else if (i > 0 && rakObat[i - 1] != null && rakObat[i - 1].getHarga() > harga) {
            System.out.println("Obat lebih murah dari index sebelumnya");
        } else if (i < rakObat.length - 1 && rakObat[i + 1] != null && rakObat[i + 1].getHarga() < harga) {
            System.out.println("Obat lebih mahal dari index selanjutnya");
        } else {
            rakObat[i] = new Obat(nama, harga, stok);
            System.out.println("Obat berhasil ditambahkan");
        }
    }

    void pindahObat(int index1, int index2) {
        if (rakObat[index1] == null || rakObat[index2] == null) {
            if (rakObat[index1] != null) {
                Boolean isIndex1Lower = index2 > 0 && rakObat[index2 - 1] != null
                        && rakObat[index2 - 1].getHarga() > rakObat[index1].getHarga();
                Boolean isIndex1Higher = index2 < rakObat.length - 1 && rakObat[index2 + 1] != null
                        && rakObat[index2 + 1].getHarga() < rakObat[index1].getHarga();
                if (isIndex1Lower || isIndex1Higher) {
                    System.out.println("Obat tidak dapat dipindah");
                    return;
                }
            } else if (rakObat[index2] != null) {
                Boolean isIndex2Lower = index1 > 0 && rakObat[index1 - 1] != null
                        && rakObat[index1 - 1].getHarga() > rakObat[index2].getHarga();
                Boolean isIndex2Higher = index1 < rakObat.length - 1 && rakObat[index1 + 1] != null
                        && rakObat[index1 + 1].getHarga() < rakObat[index2].getHarga();
                if (isIndex2Lower || isIndex2Higher) {
                    System.out.println("Obat tidak dapat dipindah");
                    return;
                }
            }
            Obat temp = rakObat[index1];
            rakObat[index1] = rakObat[index2];
            rakObat[index2] = temp;
            System.out.println("Obat berhasil dipindah");
        } else {
            System.out.println("Obat tidak dapat dipindah");
        }
    }

    void beliObat(int index, int jumlah) {
        if (index < 0 || index >= rakObat.length) {
            System.out.println("Indeks tidak valid");
            return;
        }
        if (rakObat[index] == null) {
            System.out.println("Obat tidak ditemukan");
        } else {
            if (rakObat[index].getStok() < jumlah) {
                System.out.println("Stok obat tidak cukup");
            } else {
                rakObat[index].setStok(rakObat[index].getStok() - jumlah);
                totalPenjualan += rakObat[index].getHarga() * jumlah;
                obatDibeli += jumlah;
                System.out.println("Obat berhasil dibeli");
            }
        }
    }


    void rekap(){
        if (this.obatDibeli == 0) {
            System.out.println("Tetap semangat, mungkin esok akan lebih baik");
        } else {
            System.out.printf("Jumlah Obat Dibeli: %d - Harga Total: %d\n", this.obatDibeli, this.totalPenjualan);
        }
    }

}





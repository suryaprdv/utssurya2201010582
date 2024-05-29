
import java.util.Scanner;


/**
 *
 * @author Asus SURYAPRADIVA2201010582
 */
public class aplikasipencatatan {
    private static final int MAX_CATATAN = 100; // Jumlah maksimum catatan
    private static catatan[] catatan = new catatan[MAX_CATATAN]; // Array untuk menyimpan catatan
    private static int jumlahCatatan = 0; // Penghitung jumlah catatan
    private static Scanner scanner = new Scanner(System.in); // Scanner untuk input pengguna

    public static void main(String[] args) {
        int pilihan;
        do {
            // Menampilkan menu
            System.out.println("=====================================");
            System.out.println("       Aplikasi Pencatatan");
            System.out.println("=====================================");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Tampilkan Catatan");
            System.out.println("3. Ubah Catatan");
            System.out.println("4. Hapus Catatan");
            System.out.println("5. Keluar");
            System.out.println("=====================================");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            
            switch (pilihan) {
                case 1:
                    tambahCatatan();
                    break;
                case 2:
                    tampilkanCatatan();
                    break;
                case 3:
                    ubahCatatan();
                    break;
                case 4:
                    hapusCatatan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang tersedia.");
                    break;
            }
        } while (pilihan != 0);
    }

    private static void tambahCatatan() {
        if (jumlahCatatan >= MAX_CATATAN) {
            System.out.println("Kapasitas catatan penuh. Tidak bisa menambah catatan baru.");
            return;
        }

        System.out.print("Masukkan isi catatan: ");
        String isi = scanner.nextLine();
        catatan[jumlahCatatan++] = new catatan(isi);
        System.out.println("Catatan berhasil ditambahkan.");
    }

    private static void tampilkanCatatan() {
        if (jumlahCatatan == 0) {
            System.out.println("Belum ada catatan.");
            return;
        }

        System.out.println("=====================================");
        System.out.println("         Daftar Catatan:");
        System.out.println("=====================================");
        for (int i = 0; i < jumlahCatatan; i++) {
            System.out.println((i + 1) + ". " + catatan[i].getIsi());
        }
        System.out.println("=====================================");
    }

    private static void ubahCatatan() {
        if (jumlahCatatan == 0) {
            System.out.println("Belum ada catatan.");
            return;
        }

        tampilkanCatatan();
        System.out.print("Pilih nomor catatan yang akan diubah: ");
        int nomor = scanner.nextInt();
        scanner.nextLine(); 
        if (nomor >= 1 && nomor <= jumlahCatatan) {
            System.out.print("Masukkan isi catatan baru: ");
            String isiBaru = scanner.nextLine();
            catatan[nomor - 1].setIsi(isiBaru);
            System.out.println("Catatan berhasil diubah.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }

    private static void hapusCatatan() {
        if (jumlahCatatan == 0) {
            System.out.println("Belum ada catatan.");
            return;
        }

        tampilkanCatatan();
        System.out.print("Pilih nomor catatan yang akan dihapus: ");
        int nomor = scanner.nextInt();
        scanner.nextLine(); 
        if (nomor >= 1 && nomor <= jumlahCatatan) {
            for (int i = nomor - 1; i < jumlahCatatan - 1; i++) {
                catatan[i] = catatan[i + 1];
            }
            jumlahCatatan--;
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }
}

    
package pkg2309106080_tiarakasmawatiputri;

import java.util.ArrayList;
import java.util.Scanner;

class AlatBerat {
    private int id;
    private String nama;
    private int hargaSewa;
    
    public AlatBerat(int id, String nama, int hargaSewa) {
        this.id = id;
        this.nama = nama;
        this.hargaSewa = hargaSewa;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getHargaSewa() {
        return hargaSewa;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }
    
    public void display() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", Harga Sewa: Rp" + hargaSewa);
    }
}

class Penyewaan {
    private String idSewa;
    private String namaPenyewa;
    protected int idAlat;
    int lamaSewa;
    
    public Penyewaan(String idSewa, String namaPenyewa, int idAlat, int lamaSewa) {
        this.idSewa = idSewa;
        this.namaPenyewa = namaPenyewa;
        this.idAlat = idAlat;
        this.lamaSewa = lamaSewa;
    }
    
    public String getIdSewa() {
        return idSewa;
    }
    
    public String getNamaPenyewa() {
        return namaPenyewa;
    }
    
    public int getIdAlat() {
        return idAlat;
    }
    
    public int getLamaSewa() {
        return lamaSewa;
    }
    
    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }
    
    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }
    
    public void display() {
        System.out.println("ID Sewa: " + idSewa + ", Nama Penyewa: " + namaPenyewa + ", ID Alat: " + idAlat + ", Lama Sewa: " + lamaSewa + " hari");
    }
}

public class Main {
    static ArrayList<AlatBerat> daftarAlat = new ArrayList<>();
    static ArrayList<Penyewaan> daftarSewa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Menambahkan 3 alat berat yang tersedia
        daftarAlat.add(new AlatBerat(1, "Excavator", 500000));
        daftarAlat.add(new AlatBerat(2, "Bulldozer", 700000));
        daftarAlat.add(new AlatBerat(3, "Crane", 900000));
        
        int pilihan;
        do {
            System.out.println("\nSISTEM PENYEWAAN ALAT BERAT DI PT NEO");
            System.out.println("1. Tambah Alat Berat");
            System.out.println("2. Lihat Alat Berat");
            System.out.println("3. Edit Alat Berat");
            System.out.println("4. Hapus Alat Berat");
            System.out.println("5. Tambah Penyewaan");
            System.out.println("6. Lihat Penyewaan");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1 -> tambahAlatBerat();
                case 2 -> lihatAlatBerat();
                case 3 -> editAlatBerat();
                case 4 -> hapusAlatBerat();
                case 5 -> tambahPenyewaan();
                case 6 -> lihatPenyewaan();
                case 7 -> System.out.println("Terima kasih telah menggunakan sistem!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);
    }
    
    static void tambahAlatBerat() {
        System.out.print("Masukkan ID Alat: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Alat: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga Sewa: ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        
        daftarAlat.add(new AlatBerat(id, nama, harga));
        System.out.println("Alat berat berhasil ditambahkan!");
    }
    
    static void lihatAlatBerat() {
        if (daftarAlat.isEmpty()) {
            System.out.println("Tidak ada data alat berat.");
            return;
        }
        for (AlatBerat alat : daftarAlat) {
            alat.display();
        }
    }
    
    static void editAlatBerat() {
        System.out.print("Masukkan ID alat yang ingin diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (AlatBerat alat : daftarAlat) {
            if (alat.getId() == id) {
                System.out.print("Masukkan Nama Baru: ");
                alat.setNama(scanner.nextLine());
                System.out.print("Masukkan Harga Sewa Baru: ");
                alat.setHargaSewa(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Data alat berat berhasil diperbarui!");
                return;
            }
        }
        System.out.println("ID alat tidak ditemukan.");
    }
    
    static void hapusAlatBerat() {
        System.out.print("Masukkan ID alat yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        daftarAlat.removeIf(alat -> alat.getId() == id);
        System.out.println("Data alat berat berhasil dihapus!");
    }
    
    static void tambahPenyewaan() {
        System.out.print("Masukkan ID Sewa: ");
        String idSewa = scanner.nextLine();
        System.out.print("Masukkan Nama Penyewa: ");
        String namaPenyewa = scanner.nextLine();
        System.out.print("Masukkan ID Alat: ");
        int idAlat = scanner.nextInt();
        System.out.print("Masukkan Lama Sewa (hari): ");
        int lamaSewa = scanner.nextInt();
        scanner.nextLine();
        
        daftarSewa.add(new Penyewaan(idSewa, namaPenyewa, idAlat, lamaSewa));
        System.out.println("Data penyewaan berhasil ditambahkan!");
    }
    
    static void lihatPenyewaan() {
        if (daftarSewa.isEmpty()) {
            System.out.println("Tidak ada data penyewaan.");
            return;
        }
        for (Penyewaan sewa : daftarSewa) {
            sewa.display();
        }
    }
}

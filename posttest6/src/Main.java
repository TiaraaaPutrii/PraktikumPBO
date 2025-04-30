import java.util.ArrayList;
import java.util.Scanner;

// Interface Perawatan
interface Perawatan {
    void jadwalServis();
    void cekKondisi();
}

// Abstract class
abstract class AlatBerat implements Perawatan {
    private int id;
    private String nama;
    private int hargaSewa;
    private static int jumlahAlat = 0; // static variable

    // Constructor
    public AlatBerat(int id, String nama, int hargaSewa) {
        this.id = id;
        this.nama = nama;
        this.hargaSewa = hargaSewa;
        jumlahAlat++; // setiap kali objek dibuat, jumlah bertambah
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    // Static method
    public static int getJumlahAlat() {
        return jumlahAlat;
    }

    // Method dari interface Perawatan
    public void jadwalServis() {
        System.out.println("Jadwal servis setiap 30 hari.");
    }

    public void cekKondisi() {
        System.out.println("Kondisi dicek sebelum dan sesudah penyewaan.");
    }

    // Method abstrak
    public abstract void tampilkanInfo();
}

// Kelas turunan Excavator
class Excavator extends AlatBerat {
    private int kapasitasBucket;

    public Excavator(int id, String nama, int hargaSewa, int kapasitasBucket) {
        super(id, nama, hargaSewa);
        this.kapasitasBucket = kapasitasBucket;
    }

    public int getKapasitasBucket() {
        return kapasitasBucket;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Harga Sewa: Rp " + getHargaSewa());
        System.out.println("Kapasitas Bucket: " + kapasitasBucket + " liter");
        jadwalServis();
        cekKondisi();
        System.out.println();
    }
}

// Kelas turunan Bulldozer
class Bulldozer extends AlatBerat {
    private int kekuatanDorong;

    public Bulldozer(int id, String nama, int hargaSewa, int kekuatanDorong) {
        super(id, nama, hargaSewa);
        this.kekuatanDorong = kekuatanDorong;
    }

    public int getKekuatanDorong() {
        return kekuatanDorong;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Harga Sewa: Rp " + getHargaSewa());
        System.out.println("Kekuatan Dorong: " + kekuatanDorong + " ton");
        jadwalServis();
        cekKondisi();
        System.out.println();
    }
}

// Kelas final
final class ValidasiInput {
    public static boolean validasiAngka(String input) {
        return input.matches("\\d+");
    }
}

// Main class
public class Main {
    private static ArrayList<AlatBerat> daftarAlat = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idTerakhir = 0;

    public static void main(String[] args) {
        int pilihan = 0;

        while (pilihan != 4) {
            System.out.println("===== Sistem Manajemen Alat Berat =====");
            System.out.println("1. Tambah Alat Berat");
            System.out.println("2. Lihat Daftar Alat Berat");
            System.out.println("3. Lihat Total Alat Berat");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine();

            // Validasi input harus angka
            if (!ValidasiInput.validasiAngka(input)) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            try {
                pilihan = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Terjadi kesalahan input! " + e.getMessage());
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahAlatBerat();
                    break;
                case 2:
                    lihatAlatBerat();
                    break;
                case 3:
                    System.out.println("Total Alat Berat: " + AlatBerat.getJumlahAlat());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }

    private static void tambahAlatBerat() {
        System.out.println("\nPilih Jenis Alat Berat:");
        System.out.println("1. Excavator");
        System.out.println("2. Bulldozer");
        System.out.print("Pilihan: ");
        String input = scanner.nextLine();

        if (!ValidasiInput.validasiAngka(input)) {
            System.out.println("Input harus berupa angka!");
            return;
        }

        int jenis;
        try {
            jenis = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Terjadi kesalahan input! " + e.getMessage());
            return;
        }

        System.out.print("Nama Alat: ");
        String nama = scanner.nextLine();

        System.out.print("Harga Sewa per hari: ");
        int hargaSewa;
        try {
            hargaSewa = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harga harus berupa angka!");
            return;
        }

        idTerakhir++;

        if (jenis == 1) {
            System.out.print("Kapasitas Bucket (liter): ");
            int kapasitas;
            try {
                kapasitas = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input kapasitas harus berupa angka!");
                return;
            }
            daftarAlat.add(new Excavator(idTerakhir, nama, hargaSewa, kapasitas));
        } else if (jenis == 2) {
            System.out.print("Kekuatan Dorong (ton): ");
            int kekuatan;
            try {
                kekuatan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input kekuatan harus berupa angka!");
                return;
            }
            daftarAlat.add(new Bulldozer(idTerakhir, nama, hargaSewa, kekuatan));
        } else {
            System.out.println("Jenis alat berat tidak valid!");
        }

        System.out.println("Alat berat berhasil ditambahkan!\n");
    }

    private static void lihatAlatBerat() {
        if (daftarAlat.isEmpty()) {
            System.out.println("\nBelum ada data alat berat.\n");
            return;
        }

        System.out.println("\n===== Daftar Alat Berat =====");
        for (AlatBerat alat : daftarAlat) {
            alat.tampilkanInfo();
        }
        System.out.println("Total Alat Berat: " + AlatBerat.getJumlahAlat());
        System.out.println();
    }
}

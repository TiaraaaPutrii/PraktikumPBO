package posttest5;

import java.util.ArrayList;
import java.util.Scanner;

// Abstract Parent Class
abstract class AlatBerat {
    private final int id; // final variable
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

    public final void display() { // final method
        System.out.println("ID: " + id + ", Nama: " + nama + ", Harga Sewa: Rp" + hargaSewa);
    }

    // Abstract method
    public abstract void jenisDetail();
}

// Subclass 1
class AlatBeratKecil extends AlatBerat {
    private int jumlahRoda;

    public AlatBeratKecil(int id, String nama, int hargaSewa, int jumlahRoda) {
        super(id, nama, hargaSewa);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public void jenisDetail() {
        System.out.println("Jenis: Kecil, Jumlah Roda: " + jumlahRoda);
    }
}

// Subclass 2
class AlatBeratBesar extends AlatBerat {
    private boolean memilikiLenganEkstra;

    public AlatBeratBesar(int id, String nama, int hargaSewa, boolean memilikiLenganEkstra) {
        super(id, nama, hargaSewa);
        this.memilikiLenganEkstra = memilikiLenganEkstra;
    }

    @Override
    public void jenisDetail() {
        System.out.println("Jenis: Besar, Memiliki Lengan Ekstra: " + (memilikiLenganEkstra ? "Ya" : "Tidak"));
    }
}

// Umum
class AlatBeratUmum extends AlatBerat {
    public AlatBeratUmum(int id, String nama, int hargaSewa) {
        super(id, nama, hargaSewa);
    }

    @Override
    public void jenisDetail() {
        System.out.println("Jenis: Umum");
    }
}

// Parent Class Penyewaan
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

    public void display() {
        System.out.println("ID Sewa: " + idSewa + ", Nama Penyewa: " + namaPenyewa + ", Lama Sewa: " + lamaSewa + " hari");
    }

    // Method overloading (Polymorphism)
    public void display(boolean tampilTotal, ArrayList<AlatBerat> daftarAlat) {
        display();
        if (tampilTotal) {
            for (AlatBerat alat : daftarAlat) {
                if (alat.getId() == this.idAlat) {
                    int total = alat.getHargaSewa() * lamaSewa;
                    System.out.println("Total Biaya: Rp" + total);
                    alat.display();
                    alat.jenisDetail();
                    break;
                }
            }
        }
    }
}

// Subclass 3
class PenyewaanPromo extends Penyewaan {
    private double diskon;

    public PenyewaanPromo(String idSewa, String namaPenyewa, int idAlat, int lamaSewa, double diskon) {
        super(idSewa, namaPenyewa, idAlat, lamaSewa);
        this.diskon = diskon;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Diskon Penyewaan: " + diskon + "%");
    }
}

public final class Main { // final class
    static ArrayList<AlatBerat> daftarAlat = new ArrayList<>();
    static ArrayList<Penyewaan> daftarSewa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarAlat.add(new AlatBeratKecil(1, "Excavator Mini", 1500000, 4));
        daftarAlat.add(new AlatBeratBesar(2, "Crane Besar", 3500000, true));
        daftarAlat.add(new AlatBeratBesar(3, "Bulldozer", 2500000, false));

        int pilihan = -1;
        do {
            System.out.println("\nSISTEM PENYEWAAN ALAT BERAT DI PT NEO");
            System.out.println("1. Tambah Alat Berat");
            System.out.println("2. Lihat Alat Berat");
            System.out.println("3. Edit Alat Berat");
            System.out.println("4. Hapus Alat Berat");
            System.out.println("5. Tambah Penyewaan");
            System.out.println("6. Lihat Penyewaan");
            System.out.println("7. Tambah Penyewaan dengan Diskon");
            System.out.println("8. Keluar");

            System.out.print("Pilih menu: ");
            String input = scanner.nextLine();

            if (!input.matches("\\d+")) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            pilihan = Integer.parseInt(input);

            switch (pilihan) {
                case 1 -> tambahAlatBerat();
                case 2 -> lihatAlatBerat();
                case 3 -> editAlatBerat();
                case 4 -> hapusAlatBerat();
                case 5 -> tambahPenyewaan();
                case 6 -> lihatPenyewaan();
                case 7 -> tambahPenyewaanDiskon();
                case 8 -> System.out.println("Terima kasih telah menggunakan sistem!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 8);
    }

    static void tambahAlatBerat() {
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (AlatBerat alat : daftarAlat) {
            if (alat.getId() == id) {
                System.out.println("Error: ID sudah digunakan!");
                return;
            }
        }

        System.out.print("Masukkan Nama Alat: ");
        String nama = scanner.nextLine();

        for (AlatBerat alat : daftarAlat) {
            if (alat.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Error: Nama alat sudah digunakan!");
                return;
            }
        }

        System.out.print("Masukkan Harga Sewa: ");
        int harga = scanner.nextInt();
        scanner.nextLine();

        int jenis;
        while (true) {
            System.out.print("Jenis (1. Kecil, 2. Besar, 3. Umum): ");
            if (scanner.hasNextInt()) {
                jenis = scanner.nextInt();
                scanner.nextLine();
                if (jenis >= 1 && jenis <= 3) {
                    break;
                } else {
                    System.out.println("Pilihan jenis tidak valid. Masukkan 1, 2, atau 3.");
                }
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        switch (jenis) {
            case 1 -> {
                System.out.print("Masukkan Jumlah Roda: ");
                int roda = scanner.nextInt();
                scanner.nextLine();
                daftarAlat.add(new AlatBeratKecil(id, nama, harga, roda));
            }
            case 2 -> {
                System.out.print("Memiliki Lengan Ekstra? (true/false): ");
                boolean lengan = scanner.nextBoolean();
                scanner.nextLine();
                daftarAlat.add(new AlatBeratBesar(id, nama, harga, lengan));
            }
            case 3 -> daftarAlat.add(new AlatBeratUmum(id, nama, harga));
        }

        System.out.println("Data alat berat berhasil ditambahkan!");
    }

    static void lihatAlatBerat() {
        System.out.println("\nDAFTAR ALAT BERAT:");
        for (AlatBerat alat : daftarAlat) {
            alat.display();
            alat.jenisDetail();
        }
    }

    static void editAlatBerat() {
        System.out.print("Masukkan ID alat yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (AlatBerat alat : daftarAlat) {
            if (alat.getId() == id) {
                System.out.print("Masukkan Nama Baru: ");
                String namaBaru = scanner.nextLine();
                for (AlatBerat other : daftarAlat) {
                    if (!other.equals(alat) && other.getNama().equalsIgnoreCase(namaBaru)) {
                        System.out.println("Error: Nama alat sudah digunakan!");
                        return;
                    }
                }
                System.out.print("Masukkan Harga Sewa Baru: ");
                int harga = scanner.nextInt();
                scanner.nextLine();
                alat.setNama(namaBaru);
                alat.setHargaSewa(harga);
                System.out.println("Data berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }

    static void hapusAlatBerat() {
        System.out.print("Masukkan ID alat yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < daftarAlat.size(); i++) {
            if (daftarAlat.get(i).getId() == id) {
                daftarAlat.remove(i);
                System.out.println("Data berhasil dihapus!");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }

    static void tambahPenyewaan() {
        System.out.print("Masukkan ID Sewa: ");
        String idSewa = scanner.nextLine();

        for (Penyewaan sewa : daftarSewa) {
            if (sewa.getIdSewa().equalsIgnoreCase(idSewa)) {
                System.out.println("ID Sewa sudah digunakan! Gagal menambahkan.");
                return;
            }
        }

        System.out.print("Masukkan Nama Penyewa: ");
        String namaPenyewa = scanner.nextLine();
        System.out.print("Masukkan ID Alat: ");
        int idAlat = scanner.nextInt();

        boolean alatAda = false;
        for (AlatBerat alat : daftarAlat) {
            if (alat.getId() == idAlat) {
                alatAda = true;
                break;
            }
        }
        if (!alatAda) {
            System.out.println("ID Alat tidak ditemukan! Gagal menambahkan penyewaan.");
            scanner.nextLine();
            return;
        }

        System.out.print("Masukkan Lama Sewa (hari): ");
        int lamaSewa = scanner.nextInt();
        scanner.nextLine();

        daftarSewa.add(new Penyewaan(idSewa, namaPenyewa, idAlat, lamaSewa));
        System.out.println("Data penyewaan berhasil ditambahkan!");
    }

    static void lihatPenyewaan() {
        System.out.println("\nDAFTAR PENYEWAAN:");
        for (Penyewaan sewa : daftarSewa) {
            sewa.display(true, daftarAlat);
        }
    }

    static void tambahPenyewaanDiskon() {
        System.out.print("Masukkan ID Sewa: ");
        String idSewa = scanner.nextLine();

        for (Penyewaan sewa : daftarSewa) {
            if (sewa.getIdSewa().equalsIgnoreCase(idSewa)) {
                System.out.println("ID Sewa sudah digunakan! Gagal menambahkan.");
                return;
            }
        }

        System.out.print("Masukkan Nama Penyewa: ");
        String namaPenyewa = scanner.nextLine();
        System.out.print("Masukkan ID Alat: ");
        int idAlat = scanner.nextInt();

        boolean alatAda = false;
        for (AlatBerat alat : daftarAlat) {
            if (alat.getId() == idAlat) {
                alatAda = true;
                break;
            }
        }
        if (!alatAda) {
            System.out.println("ID Alat tidak ditemukan! Gagal menambahkan penyewaan.");
            scanner.nextLine();
            return;
        }

        System.out.print("Masukkan Lama Sewa (hari): ");
        int lamaSewa = scanner.nextInt();
        System.out.print("Masukkan Diskon (%): ");
        double diskon = scanner.nextDouble();
        scanner.nextLine();

        daftarSewa.add(new PenyewaanPromo(idSewa, namaPenyewa, idAlat, lamaSewa, diskon));
        System.out.println("Data penyewaan dengan diskon berhasil ditambahkan!");
    }
}

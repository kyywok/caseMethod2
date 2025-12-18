import java.util.Scanner;

public class CM2Magang04 {
    // inisialisasi variabel global
    static Scanner sc = new Scanner(System.in);
    static String[][] data = new String[100][6];
    static int pendaftar = 0;

    public static void main(String[] args) {
        // perulangan untuk memilih menu
        while (true) {
            System.out.println("\n--- SISTEM PENDAFTARAN MAGANG MAHASISWA ");
            System.out.println(
                    "1. tambah data magang\n2. tampilkan semua pendaftar magang\n3. cari pendaftar berdasarkan program studi\n4. hitung julah pendaftar untuk semua status\n5. keluar");
            System.out.print("pilih menu 1-5: ");
            int menu = sc.nextInt();

            // pemilihan fungsi berdasar dari menu
            switch (menu) {
                case 1:
                    tambahdata();
                    break;
                case 2:
                    tampilSemua();
                    break;
                case 3:
                    System.out.print("masukkan program studi atau nama perusahaan: ");
                    String prodi = sc.next();
                    caripendaftar(prodi);
                    break;
                case 4:
                    hitungpendaftar();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("menu tidak tersedia");
            }
        }
    }

    // function tambah data
    public static void tambahdata() {
        // input data pendaftar
        System.out.println("\n--- MASUKAN DATA ");
        System.out.print("nama: ");
        data[pendaftar][0] = sc.next();
        System.out.print("nim: ");
        data[pendaftar][1] = sc.next();
        System.out.print("program studi: ");
        data[pendaftar][2] = sc.next();
        System.out.print("perusahaan tujuan magang: ");
        data[pendaftar][3] = sc.next();
        System.out.print("semester pengambilan magang (6/7): ");
        data[pendaftar][4] = sc.next();
        System.out.print("status magang (diterima/menunggu/ditolak): ");
        data[pendaftar][5] = sc.next();
        pendaftar++;

        System.out.println("data berhasil ditambahkan. Total pendaftar saat ini: " + pendaftar);
    }

    public static void tampilSemua() {
        System.out.println("\n--- SEMUA PENDAFTAR ");

        // jika tidak ada pendaftar maka menjalankan kode berikut
        if (pendaftar == 0) {
            System.out.println("belum ada pendaftar!");
            return;
        }

        // menampilkan semua pendaftar yang dipanggil dari array
        for (int i = 0; i < pendaftar; i++) {
            System.out.println("\npendaftar ke-" + (i + 1));
            System.out.println("nama: " + data[i][0]);
            System.out.println("nim: " + data[i][1]);
            System.out.println("program Studi: " + data[i][2]);
            System.out.println("perusahaan Magang: " + data[i][3]);
            System.out.println("semester: " + data[i][4]);
            System.out.println("status: " + data[i][5]);
            System.out.println("data pendaftaran magang berhasil ditambahkan. total pendaftar: " + pendaftar);
        }
    }

    // fungsi cari pendaftar
    public static void caripendaftar(String prodi) {
        String namaPerusahaan = prodi;
        System.out.println("\n--- HASIL PENCARIAN PRODI / NAMA PERUSAHAAN: " + prodi);

        // inisialisasi variabel
        boolean ditemukan = false;

        // perulangan untuk mencari pendaftar yang dicari berdasarkan prodi
        for (int i = 0; i < pendaftar; i++) {
            if (data[i][2].equalsIgnoreCase(prodi)) {
                System.out.println("nama: " + data[i][0]);
                System.out.println("nim: " + data[i][1]);
                System.out.println("status: " + data[i][5]);
                ditemukan = true;
            } else if (data[i][3].equalsIgnoreCase(namaPerusahaan)) {
                System.out.println("nama: " + data[i][0]);
                System.out.println("nim: " + data[i][1]);
                System.out.println("status: " + data[i][5]);
                ditemukan = true;
            }
        }

        // pemilihan ketika belum ada pendaftar
        if (!ditemukan) {
            System.out.println("belum ada pendaftar.");
        }
    }

    // fungsi untuk menentukan berapa orang yang diterima, menunggu, dan ditolak
    public static void hitungpendaftar() {
        // inisialisasi variabel
        int diterima = 0, menunggu = 0, ditolak = 0, total = 0;
        double presentase = 0;

        // perulangan untuk menjulah berapa yang diterima,menunggu, dan ditolak
        for (int i = 0; i < pendaftar; i++) {
            String status = data[i][5];
            if (status.equalsIgnoreCase("diterima")) {
                diterima += 1;
            } else if (status.equalsIgnoreCase("menunggu")) {
                menunggu += 1;
            } else if (status.equalsIgnoreCase("ditolak")) {
                ditolak += 1;
            }
        }

        total = diterima + menunggu + ditolak;
        if (total > 0) {
            presentase = (double) diterima / total * 100;
        } else {
            presentase = 0;
        }

        // tampilkan hasil pendaftar
        System.out.println("\n--- DATA PENDAFTAR YANG DITERIMA/NENUNGGU/DITOLAK");
        System.out.println("diterima: " + diterima);
        System.out.println("menunggu: " + menunggu);
        System.out.println("ditolak: " + ditolak);
        System.out.println("presentase kelulusan (diterima) dari semua pendaftar: " + presentase);
    }
}

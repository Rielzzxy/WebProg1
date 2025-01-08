import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Ngasir {

    public static void main(String[] args) {
        // Locale Indonesia untuk format mata uang
        Locale localeID = new Locale("in", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);

        // Menu makanan dan harga
        String[] menu = { "Nasi Goreng", "Mie Ayam", "Sate Ayam", "Bakso", "Ayam Bakar", "Cappuccino", "Es Teh Manis",
                "Air Minum" };
        int[] harga = { 15000, 12000, 20000, 10000, 18000, 20000, 5000, 3000 };

        // Paket dan harga
        String[] paket = { "Paket 1 (Ayam Bakar + Es Teh Manis)", "Paket 2 (Sate Ayam + Air Minum)",
                "Paket 3 (Nasi Goreng + Es Teh Manis)" };
        int[] hargaPaket = { 25000, 23000, 18000 };

        // Scanner untuk input pengguna
        Scanner input = new Scanner(System.in);

        // Variabel untuk menghitung total harga dan jumlah pesanan
        int totalHarga = 0;
        int totalPesanan = 0;

        // List untuk menyimpan pesanan dan jumlahnya
        ArrayList<String> pesananList = new ArrayList<>();
        ArrayList<Integer> jumlahList = new ArrayList<>();

        boolean inginPesanLagi = true;
        while (inginPesanLagi) {
            // Tampilkan menu
            System.out.println("\n===== Menu Makanan =====");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i] + " - " + currencyFormatter.format(harga[i]));
            }

            // Tampilkan paket
            System.out.println("\n===== Paket Makanan =====");
            for (int i = 0; i < paket.length; i++) {
                System.out.println("P" + (i + 1) + ". " + paket[i] + " - " + currencyFormatter.format(hargaPaket[i]));
            }

            // Proses pemesanan
            boolean adaPesanan = false;
            while (true) {
                if (!adaPesanan) {
                    System.out.println("\nBelum ada pesanan. Kami menyarankan Paket 1: Ayam Bakar + Es Teh Manis.");
                }

                System.out.print("\nPilih nomor makanan (1-8) atau paket (P1-P3), atau 0 untuk selesai: ");
                String pilihan = input.next();

                if (pilihan.equals("0")) {
                    break; // Keluar dari loop jika user memilih 0
                } else if (pilihan.startsWith("P")) {
                    // Pesan paket
                    int indexPaket = Integer.parseInt(pilihan.substring(1)) - 1;
                    if (indexPaket >= 0 && indexPaket < paket.length) {
                        System.out.print("Masukkan jumlah pesanan untuk " + paket[indexPaket] + ": ");
                        int jumlah = input.nextInt();

                        // Tambahkan ke list pesanan
                        pesananList.add(paket[indexPaket]);
                        jumlahList.add(jumlah);

                        // Hitung total harga dan jumlah pesanan
                        totalHarga += hargaPaket[indexPaket] * jumlah;
                        totalPesanan += jumlah;

                        System.out.println(jumlah + " paket " + paket[indexPaket] + " ditambahkan ke pesanan.");
                        adaPesanan = true;
                    } else {
                        System.out.println("Pilihan paket tidak valid, coba lagi.");
                    }
                } else {
                    // Pesan menu biasa
                    int pilihanMenu = Integer.parseInt(pilihan) - 1;
                    if (pilihanMenu >= 0 && pilihanMenu < menu.length) {
                        System.out.print("Masukkan jumlah pesanan untuk " + menu[pilihanMenu] + ": ");
                        int jumlah = input.nextInt();

                        // Tambahkan ke list pesanan
                        pesananList.add(menu[pilihanMenu]);
                        jumlahList.add(jumlah);

                        // Hitung total harga dan jumlah pesanan
                        totalHarga += harga[pilihanMenu] * jumlah;
                        totalPesanan += jumlah;

                        System.out.println(jumlah + " porsi " + menu[pilihanMenu] + " ditambahkan ke pesanan.");
                        adaPesanan = true;
                    } else {
                        System.out.println("Pilihan tidak valid, coba lagi.");
                    }
                }
            }

            // Tampilkan pesanan untuk ditinjau
            while (true) {
                System.out.println("\n===== Struk Pesanan Sementara =====");
                for (int i = 0; i < pesananList.size(); i++) {
                    System.out.println(jumlahList.get(i) + " x " + pesananList.get(i) + " - "
                            + currencyFormatter.format(hargaPesanan(pesananList.get(i), menu, harga, paket, hargaPaket)
                                    * jumlahList.get(i)));
                }
                System.out.println("Total item dipesan: " + totalPesanan);
                System.out.println("Total harga: " + currencyFormatter.format(totalHarga));

                // Tanyakan apakah pesanan sudah final atau ingin mengganti pesanan
                System.out.print("\nApakah pesanan Anda sudah benar? (ya/tidak): ");
                String konfirmasi = input.next();
                if (konfirmasi.equalsIgnoreCase("ya")) {
                    break; // Keluar dari loop dan lanjutkan ke pembayaran jika pesanan sudah fix
                } else if (konfirmasi.equalsIgnoreCase("tidak")) {
                    System.out.println("Anda akan mengubah pesanan.");
                    System.out.print("Masukkan nomor pesanan yang ingin diubah (1 - " + pesananList.size() + "): ");
                    int indexPesanan = input.nextInt() - 1; // Ubah indeks sesuai input pengguna
                    if (indexPesanan >= 0 && indexPesanan < pesananList.size()) {
                        System.out.print("Masukkan jumlah baru untuk " + pesananList.get(indexPesanan) + ": ");
                        int jumlahBaru = input.nextInt();

                        // Hitung ulang total harga dan pesanan
                        totalHarga -= jumlahList.get(indexPesanan)
                                * hargaPesanan(pesananList.get(indexPesanan), menu, harga, paket, hargaPaket);
                        totalPesanan -= jumlahList.get(indexPesanan);

                        jumlahList.set(indexPesanan, jumlahBaru); // Update jumlah
                        totalHarga += jumlahBaru
                                * hargaPesanan(pesananList.get(indexPesanan), menu, harga, paket, hargaPaket); // Update
                                                                                                               // total
                                                                                                               // harga
                        totalPesanan += jumlahBaru;

                        System.out.println(
                                "Pesanan diubah menjadi " + jumlahBaru + " x " + pesananList.get(indexPesanan) + ".");
                    } else {
                        System.out.println("Nomor pesanan tidak valid.");
                    }
                } else {
                    System.out.println("Input tidak valid. Silakan masukkan 'ya' atau 'tidak'.");
                }
            }

            // Tampilkan total pesanan dan harga (seperti struk final)
            System.out.println("\n===== Struk Pembelian =====");
            for (int i = 0; i < pesananList.size(); i++) {
                System.out.println(jumlahList.get(i) + " x " + pesananList.get(i) + " - " + currencyFormatter
                        .format(hargaPesanan(pesananList.get(i), menu, harga, paket, hargaPaket) * jumlahList.get(i)));
            }
            System.out.println("\nTotal item dipesan: " + totalPesanan);
            System.out.println("Total harga: " + currencyFormatter.format(totalHarga));

            // Tanyakan apakah pengguna ingin memesan lagi
            System.out.print("\nApakah Anda ingin memesan lagi? (ya/tidak): ");
            String pesananLagi = input.next();
            if (!pesananLagi.equalsIgnoreCase("ya")) {
                inginPesanLagi = false;
            }
        }

        // Menanyakan metode pembayaran
        System.out.println("\nPilih metode pembayaran:");
        System.out.println("1. Tunai");
        System.out.println("2. E-Wallet:");
        System.out.println("    2.1 OVO");
        System.out.println("    2.2 GoPay");
        System.out.println("    2.3 Dana");

        System.out.print("Masukkan pilihan (1-2 untuk metode, atau 2.1/2.2 untuk E-Wallet): ");
        String metodePembayaran = input.next();

        // Proses metode pembayaran
        switch (metodePembayaran) {
            case "1":
                System.out.print("Masukkan jumlah uang yang dibayarkan: ");
                int uangDibayar = input.nextInt();
                if (uangDibayar >= totalHarga) {
                    int kembalian = uangDibayar - totalHarga;
                    System.out.println("Anda memilih pembayaran tunai.");
                    System.out.println("Uang yang dibayarkan: " + currencyFormatter.format(uangDibayar));
                    System.out.println("Kembalian: " + currencyFormatter.format(kembalian));
                } else {
                    System.out.println("Uang yang dibayarkan kurang.");
                }
                break;
            case "2.1":
                System.out.println("Anda memilih pembayaran melalui OVO.");
                break;
            case "2.2":
                System.out.println("Anda memilih pembayaran melalui GoPay.");
                break;
            case "2.3":
                System.out.println("Anda memilih pembayaran melalui Dana.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        System.out.println("Terima kasih telah berbelanja!");
        input.close();
    }

    // Fungsi untuk mendapatkan harga pesanan baik dari menu maupun paket
    public static int hargaPesanan(String pesanan, String[] menu, int[] hargaMenu, String[] paket, int[] hargaPaket) {
        // Cek apakah pesanan ada di paket
        for (int i = 0; i < paket.length; i++) {
            if (pesanan.equals(paket[i])) {
                return hargaPaket[i];
            }
        }

        // Jika bukan paket, cek di menu biasa
        for (int i = 0; i < menu.length; i++) {
            if (pesanan.equals(menu[i])) {
                return hargaMenu[i];
            }
        }

        return 0; // Default return jika tidak ditemukan
    }
}

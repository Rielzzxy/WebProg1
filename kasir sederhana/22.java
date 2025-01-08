import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Kelas Produk untuk menyimpan informasi nama dan harga produk
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - Rp" + price;
    }
}

// Kelas Kasir untuk menangani keranjang belanja dan perhitungan total
public class Cashier {
    private List<Product> cart;

    public Cashier() {
        cart = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    public void clearCart() {
        cart.clear();
    }

    public List<Product> getCart() {
        return cart;
    }
}

// Kelas Transaksi untuk mencatat informasi pembayaran dan menghitung kembalian
class Transaction {
    private double totalAmount;
    private double paidAmount;
    private double change;

    public Transaction(double totalAmount, double paidAmount) {
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.change = paidAmount - totalAmount;
    }

    public double getChange() {
        return change;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }
}

// Kelas utama untuk GUI aplikasi kasir sederhana
public class CashierApp {

    // Objek kasir untuk menangani transaksi
    private static Cashier cashier = new Cashier();

    // Model untuk menampilkan produk dalam keranjang belanja
    private static DefaultListModel<String> cartListModel = new DefaultListModel<>();

    // Label untuk menampilkan total harga
    private static JLabel totalLabel = new JLabel("Total: Rp 0");

    public static void main(String[] args) {

        // Membuat frame utama aplikasi
        JFrame frame = new JFrame("Aplikasi Kasir Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        // Membuat panel untuk daftar produk
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(3, 1));

        // Definisi produk yang dijual
        Product product1 = new Product("Kopi", 15000);
        Product product2 = new Product("Teh", 10000);
        Product product3 = new Product("Roti", 12000);

        // Tombol untuk menambahkan produk ke keranjang
        JButton productButton1 = new JButton(product1.toString());
        JButton productButton2 = new JButton(product2.toString());
        JButton productButton3 = new JButton(product3.toString());

        // Aksi ketika tombol produk diklik
        productButton1.addActionListener(e -> addToCart(product1));
        productButton2.addActionListener(e -> addToCart(product2));
        productButton3.addActionListener(e -> addToCart(product3));

        // Menambahkan tombol ke panel produk
        productPanel.add(productButton1);
        productPanel.add(productButton2);
        productPanel.add(productButton3);

        // Membuat panel untuk keranjang belanja
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());

        // List untuk menampilkan produk di keranjang
        JList<String> cartList = new JList<>(cartListModel);
        JScrollPane cartScrollPane = new JScrollPane(cartList);

        // Menambahkan elemen ke panel keranjang
        cartPanel.add(new JLabel("Keranjang Belanja:"), BorderLayout.NORTH);
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        cartPanel.add(totalLabel, BorderLayout.SOUTH);

        // Membuat panel untuk pembayaran
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(3, 2));

        // Label dan field untuk memasukkan jumlah pembayaran
        JLabel paymentLabel = new JLabel("Bayar: ");
        JTextField paymentField = new JTextField();

        // Tombol bayar
        JButton payButton = new JButton("Bayar");
        payButton.addActionListener(e -> processPayment(paymentField.getText()));

        // Menambahkan elemen ke panel pembayaran
        paymentPanel.add(paymentLabel);
        paymentPanel.add(paymentField);
        paymentPanel.add(new JLabel()); // Placeholder untuk tata letak
        paymentPanel.add(payButton);

        // Menambahkan panel produk, keranjang, dan pembayaran ke frame utama
        frame.setLayout(new BorderLayout());
        frame.add(productPanel, BorderLayout.NORTH);
        frame.add(cartPanel, BorderLayout.CENTER);
        frame.add(paymentPanel, BorderLayout.SOUTH);

        // Menampilkan frame
        frame.setVisible(true);
    }

    // Method untuk menambahkan produk ke keranjang belanja
    private static void addToCart(Product product) {
        cashier.addProductToCart(product);
        cartListModel.addElement(product.toString());
        updateTotal();
    }

    // Method untuk memperbarui total harga
    private static void updateTotal() {
        double total = cashier.calculateTotal();
        totalLabel.setText("Total: Rp " + total);
    }

    // Method untuk memproses pembayaran
    private static void processPayment(String paymentText) {
        try {
            double paidAmount = Double.parseDouble(paymentText);
            double totalAmount = cashier.calculateTotal();
            Transaction transaction = new Transaction(totalAmount, paidAmount);

            if (transaction.getChange() < 0) {
                JOptionPane.showMessageDialog(null, "Uang tidak cukup!");
            } else {
                JOptionPane.showMessageDialog(null, "Pembayaran sukses! Kembalian: Rp " + transaction.getChange());
                cashier.clearCart();
                cartListModel.clear();
                updateTotal();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Masukkan jumlah uang yang valid!");
        }
    }
}

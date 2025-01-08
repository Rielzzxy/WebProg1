import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Kelas Produk harus didefinisikan di bagian atas file
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

// Kelas Kasir untuk menangani logika kasir
class Cashier {
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

// Kelas Transaksi untuk memproses transaksi
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

// Kelas utama yang berisi GUI aplikasi kasir
public class CashierApp {
    private static Cashier cashier = new Cashier();
    private static DefaultListModel<String> cartListModel = new DefaultListModel<>();
    private static JLabel totalLabel = new JLabel("Total: Rp 0");

    public static void main(String[] args) {
        // Frame utama aplikasi
        JFrame frame = new JFrame("Aplikasi Kasir Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        // Panel untuk daftar produk
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(3, 1));

        // Definisi produk yang dijual
        Product product1 = new Product("Kopi", 15000);
        Product product2 = new Product("Teh", 10000);
        Product product3 = new Product("Roti", 12000);

        // Tombol produk
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

        // Panel untuk keranjang belanja
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());
        JList<String> cartList = new JList<>(cartListModel);
        JScrollPane cartScrollPane = new JScrollPane(cartList);

        cartPanel.add(new JLabel("Keranjang Belanja:"), BorderLayout.NORTH);
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        cartPanel.add(totalLabel, BorderLayout.SOUTH);

        // Panel untuk pembayaran
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(3, 2));

        JLabel paymentLabel = new JLabel("Bayar: ");
        JTextField paymentField = new JTextField();

        JButton payButton = new JButton("Bayar");
        payButton.addActionListener(e -> processPayment(paymentField.getText()));

        paymentPanel.add(paymentLabel);
        paymentPanel.add(paymentField);
        paymentPanel.add(new JLabel()); // Placeholder untuk tata letak
        paymentPanel.add(payButton);

        // Menambahkan panel ke frame
        frame.setLayout(new BorderLayout());
        frame.add(productPanel, BorderLayout.NORTH);
        frame.add(cartPanel, BorderLayout.CENTER);
        frame.add(paymentPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Menambahkan produk ke keranjang belanja
    private static void addToCart(Product product) {
        cashier.addProductToCart(product);
        cartListModel.addElement(product.toString());
        updateTotal();
    }

    // Mengupdate total harga
    private static void updateTotal() {
        double total = cashier.calculateTotal();
        totalLabel.setText("Total: Rp " + total);
    }

    // Memproses pembayaran
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

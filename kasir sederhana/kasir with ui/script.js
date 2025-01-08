// List Menu and Prices
const menu = [
    { name: "Nasi Goreng", price: 15000 },
    { name: "Mie Ayam", price: 12000 },
    { name: "Sate Ayam", price: 20000 },
    { name: "Bakso", price: 10000 },
    { name: "Ayam Bakar", price: 18000 },
    { name: "Cappuccino", price: 20000 },
    { name: "Es Teh Manis", price: 5000 },
    { name: "Air Minum", price: 3000 },
    { name: "Americano", price: 5000 },
    { name: "Roti Bakar ", price: 14000 }
];

const bundlingPromo = [
    { name: "Paket Nasi Goreng + Es Teh Manis", items: ["Nasi Goreng", "Es Teh Manis"], price: 18000 },
    { name: "Paket Sate Ayam + Air Minum", items: ["Sate Ayam", "Air Minum"], price: 22000 },
    { name: "Paket Mie Ayam + Cappuccino", items: ["Mie Ayam", "Cappuccino"], price: 30000 }
];

const pesanan = [];
let totalHarga = 0;

const menuList = document.getElementById('menu-list');
const promoList = document.getElementById('promo-list');
const pesananList = document.getElementById('pesanan-list');
const totalHargaElem = document.getElementById('total-harga');

// Populate Menu List
menu.forEach((item, index) => {
    const li = document.createElement('li');
    li.innerHTML = `
        <span>${item.name}</span>
        <button onclick="tambahPesanan(${index})">Tambah (${formatRupiah(item.price)})</button>
    `;
    menuList.appendChild(li);
});

// Populate Bundling Promo List
bundlingPromo.forEach((promo, index) => {
    const li = document.createElement('li');
    li.innerHTML = `
        <span>${promo.name}</span>
        <button onclick="tambahPromo(${index})">Tambah Promo (${formatRupiah(promo.price)})</button>
    `;
    promoList.appendChild(li);
});

// Add to Pesanan
function tambahPesanan(index) {
    const menuItem = menu[index];
    let existingItem = pesanan.find(item => item.name === menuItem.name);

    if (existingItem) {
        existingItem.quantity += 1;
        existingItem.totalPrice += menuItem.price;
    } else {
        pesanan.push({ ...menuItem, quantity: 1, totalPrice: menuItem.price });
    }

    totalHarga += menuItem.price;
    renderPesananList();
}

// Add Bundling Promo to Pesanan
function tambahPromo(index) {
    const promoItem = bundlingPromo[index];
    let existingPromo = pesanan.find(item => item.name === promoItem.name);

    if (existingPromo) {
        existingPromo.quantity += 1;
        existingPromo.totalPrice += promoItem.price;
    } else {
        pesanan.push({ ...promoItem, quantity: 1, totalPrice: promoItem.price });
    }

    totalHarga += promoItem.price;
    renderPesananList();
}

function renderPesananList() {
    pesananList.innerHTML = '';
    pesanan.forEach(item => {
        const li = document.createElement('li');
        li.innerHTML = `${item.name} x${item.quantity} - ${formatRupiah(item.totalPrice)}`;
        pesananList.appendChild(li);
    });
    totalHargaElem.innerText = formatRupiah(totalHarga);
}

// Format Rupiah
function formatRupiah(angka) {
    return new Intl.NumberFormat('id-ID', {
        style: 'currency',
        currency: 'IDR'
    }).format(angka);
}

// Handle Payment
function bayar() {
    const metodePembayaran = document.getElementById('metode-pembayaran').value;
    const uangDibayar = parseInt(document.getElementById('uang-dibayar').value) || 0;
    const kembalianOutput = document.getElementById('kembalian-output');

    if (metodePembayaran === 'tunai') {
        if (uangDibayar >= totalHarga) {
            const kembalian = uangDibayar - totalHarga;
            kembalianOutput.innerText = `Kembalian: ${formatRupiah(kembalian)}\nTerimakasih, selamat menikmati makanan!`;
        } else {
            kembalianOutput.innerText = `Uang yang dibayarkan kurang!`;
        }
    } else {
        kembalianOutput.innerText = `Pembayaran melalui ${metodePembayaran.toUpperCase()} berhasil!\nTerimakasih, selamat menikmati makanan!`;
    }
}


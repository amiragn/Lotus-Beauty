CREATE DATABASE LotusBeauty
GO
USE LotusBeauty
GO

CREATE TABLE Karyawan( -- yang bisa liat karyawan aja
    ID_Karyawan			INTEGER PRIMARY KEY,  
    Nomor_KTP			VARCHAR(255) UNIQUE,
    Nama_Lengkap		VARCHAR(255),
    TTL					VARCHAR(255),
	Username_Karyawan	VARCHAR(255) UNIQUE,
	Password_Karyawan	VARCHAR(255),
	Jalan               VARCHAR(255),
    Kelurahan           VARCHAR(255),
    Kecamatan           VARCHAR(255),
    Kota                VARCHAR(255),
    Provinsi            VARCHAR(255),
    Kode_Pos            VARCHAR(5)
)

CREATE TABLE Karyawan_Nomor_Telepon( -- yang bisa liat karyawan aja
    Karyawan_ID_Karyawan    INTEGER NOT NULL,
    Nomor_Telepon			VARCHAR(255),
    CONSTRAINT Karyawan_Nomor_Telepon_FKIndex1
        FOREIGN KEY (Karyawan_ID_Karyawan) REFERENCES Karyawan
)
CREATE TABLE Karyawan_Admin( -- yang bisa lihat karyawan aja
	ID_Admin				INTEGER NOT NULL PRIMARY KEY,
    Karyawan_ID_Karyawan    INTEGER NOT NULL ,
--	Pesanan_ID_Pesanan      INTEGER NOT NULL,
    CONSTRAINT Karyawan_Admin_FKIndex1
        FOREIGN KEY (Karyawan_ID_Karyawan) REFERENCES Karyawan,
   -- CONSTRAINT Karyawan_Admin_FKIndex2
     --   FOREIGN KEY (Pesanan_ID_Pesanan) REFERENCES Pesanan
)

CREATE TABLE Karyawan_Logistik( -- yang bisa lihat karyawan aja
	ID_Logistik					INTEGER NOT NULL PRIMARY KEY,
    Karyawan_ID_Karyawan        INTEGER NOT NULL,
--	Pengiriman_ID_Pengiriman    INTEGER NOT NULL
--  CONSTRAINT Karyawan_Logistik_FKIndex1
--        FOREIGN KEY (Pengiriman_ID_Pengiriman) REFERENCES Pengiriman,
    CONSTRAINT Karyawan_Logistik_FKIndex2
        FOREIGN KEY (Karyawan_ID_Karyawan) REFERENCES Karyawan
)

CREATE TABLE Produk( -- yang bisa liat pelanggan dan karyawan (tapi karyawan bisa edit)
    ID_Produk           INTEGER PRIMARY KEY, --auto-increment
    Nama_Produk         VARCHAR(255),
    Harga               INTEGER, 
    Tanggal_Kadaluwarsa DATE,
    Berat               INTEGER
)

CREATE TABLE Pembeli( -- yang bisa liat pelanggan sama karyawan (cuma bisa liat id, nama, nomor telp sama alamat)
    ID_Toko					INTEGER PRIMARY KEY,
    Nama_Toko				VARCHAR(255),
    Nomor_Telepon			VARCHAR(255) UNIQUE,
	Username_Pembeli		VARCHAR(255) UNIQUE,
	Password_Pembeli		VARCHAR(255),
	Jalan					VARCHAR(255),
    Kelurahan				VARCHAR(255),
    Kecamatan				VARCHAR(255),
    Kota					VARCHAR(255),
    Provinsi				VARCHAR(255),
    Kode_Pos				VARCHAR(5)
)

CREATE TABLE Keranjang( -- yang bisa liat pelanggan aja
    ID_Keranjang		INTEGER PRIMARY KEY,
	Pembeli_ID_Toko		INTEGER NOT NULL
    CONSTRAINT Keranjang_FKIndex1
        FOREIGN KEY (Pembeli_ID_Toko) REFERENCES Pembeli,
--	CONSTRAINT Keranjang_FKIndex2
--		FOREIGN KEY (Produk_ID_Produk) REFERENCES Produk,
)

 CREATE TABLE Keranjang_Detail_Produk( -- yang bisa liat pelanggan aja
    Keranjang_ID_Keranjang  INTEGER NOT NULL,
    Produk_ID_Produk        INTEGER NOT NULL,
	Kuantitas			INTEGER
    PRIMARY KEY (Keranjang_ID_Keranjang, Produk_ID_Produk),
    CONSTRAINT Keranjang_Detail_Produk_FKIndex1
        FOREIGN KEY (Keranjang_ID_Keranjang) REFERENCES Keranjang,
    CONSTRAINT Keranjang_Detail_Produk_FKIndex2    
        FOREIGN KEY (Produk_ID_Produk) REFERENCES Produk
)

CREATE TABLE Keranjang_has_Produk( -- yang bisa liat pelanggan aja
    Keranjang_ID_Keranjang  INTEGER NOT NULL,
    Produk_ID_Produk        INTEGER NOT NULL,
	Sub_Total				INTEGER --harga x kuantitas
    PRIMARY KEY (Keranjang_ID_Keranjang, Produk_ID_Produk),
    CONSTRAINT Keranjang_has_Produk_FKIndex1
        FOREIGN KEY (Keranjang_ID_Keranjang) REFERENCES Keranjang,
    CONSTRAINT Keranjang_has_Produk_FKIndex2    
        FOREIGN KEY (Produk_ID_Produk) REFERENCES Produk
)

CREATE TABLE Pesanan( -- yang bisa lihat karyawan aja
    ID_Pesanan					INTEGER PRIMARY KEY,
    Keranjang_ID_Keranjang		INTEGER NOT NULL,
	Karyawan_Admin_ID_Admin     INTEGER NOT NULL,
    Waktu_Pemesanan				DATE,
	Total_Harga					INTEGER,
	Ongkos_Kirim				INTEGER,
	Status_Pemesanan			VARCHAR(255) --sudah lunas atau belum lunas
   CONSTRAINT Pesanan_FKIndex1
       FOREIGN KEY (Keranjang_ID_Keranjang) REFERENCES Keranjang,
--	   CONSTRAINT Pesanan_FKIndex2
--		FOREIGN KEY (Pengiriman_ID_Pengiriman) REFERENCES Pengiriman,
	CONSTRAINT Pesanan_FKIndex2
		FOREIGN KEY (Karyawan_Admin_ID_Admin) REFERENCES Karyawan_Admin
)

CREATE TABLE Pengiriman( -- yang bisa lihat karyawan aja
    ID_Pengiriman       INTEGER PRIMARY KEY,
	Karyawan_Logistik_ID_Logistik INTEGER NOT NULL,
	Pesanan_ID_Pesanan	INTEGER NOT NULL, 
    Status_Pengiriman   VARCHAR(255)
    CONSTRAINT Pengiriman_FKIndex1
        FOREIGN KEY (Pesanan_ID_Pesanan) REFERENCES Pesanan,
	CONSTRAINT Pengiriman_FKIndex2
		FOREIGN KEY (Karyawan_Logistik_ID_Logistik) REFERENCES Karyawan_Logistik

)

CREATE TABLE Pembayaran( -- yang bisa lihat pelanggan dan karyawan
    ID_Pembayaran       INTEGER PRIMARY KEY,
    Pesanan_ID_Pesanan  INTEGER NOT NULL,
	Waktu_Pembayaran    DATE,
	Jenis_Pembayaran    VARCHAR(255),
--  Status_Pembayaran   VARCHAR(255),
    Total_Pembayaran    INTEGER --SUM dari pesanan
    CONSTRAINT Pembayaran_FKIndex1
        FOREIGN KEY (Pesanan_ID_Pesanan) REFERENCES Pesanan
)
USE LotusBeauty

DELETE FROM Pengiriman
DELETE FROM Pembayaran
DELETE FROM Pesanan
DELETE FROM Keranjang_has_Produk
DELETE FROM Keranjang_Detail_Produk
DELETE FROM Keranjang
DELETE FROM Pembeli
DELETE FROM Produk
DELETE FROM Karyawan_Admin
DELETE FROM Karyawan_Logistik
DELETE FROM Karyawan_Nomor_Telepon
DELETE FROM Karyawan

INSERT INTO Karyawan (ID_Karyawan, Nomor_KTP, Nama_Lengkap, TTL, Username_Karyawan, Password_Karyawan, Jalan, Kelurahan, Kecamatan, Kota, Provinsi, Kode_Pos)
VALUES 
(70001, 1256373821, 'Budi Anugrah', 'Jakarta, 13 November 1983', 'budiianugrah', '2138', 'Jalan Soekarno', 'Klojen', 'Belimbing', 'Jakarta', 'DKI Jakarta', '10120'),
(70002, 1256373822, 'Andi Sutomo', 'Madiun, 9 April 1980', 'sutomoo', '3822', 'Jalan Soekharto', 'Lowokwaru', 'Semangka', 'Jakarta', 'DKI Jakarta', '10130'),
(70003, 1256373823, 'Tono', 'Bandung, 13 April 1983', 'tono12', '5637', 'Jalan Habibie', 'Malang', 'Apel', 'Madiun', 'Jawa Timur', '63114'),
(70004, 1256373824, 'Subekti', 'Jakarta, 25 November 1983', 'bekti5', '3248', 'Jalan Hatta', 'Dendeng', 'Klojen', 'Bandung', 'Jawa Barat', '40112'),
(70005, 1256373825, 'Andre', 'Madiun, 15 Desember 1980', 'andr3ee', '8532', 'Jalan Kartini', 'Geger', 'Stroberi', 'Surabaya', 'Jawa Timur', '36743'),
(70006, 1256373826, 'Edi Sutomo', 'Surabaya, 20 Agustus 1981', 'ediii', '6832', 'Jalan Subang', 'Milir', 'Apel', 'Blitar', 'Jawa Timur', '66116'),
(70007, 1256373827, 'Ahmad Rizky', 'Sumedang, 13 April 1988', 'ahrizky','7238', 'Jalan KH Dewantara','Belimbing', 'Melon', 'Bandung', 'Jawa Barat', '40112'),
(70008, 1256373828, 'Rizky Adi', 'Subang, 20 November 1983', 'rizkydi', '8283', 'Jalan Suharto', 'Batu', 'Semangka', 'Batu', 'Jawa Timur', '65312'),
(70009,1256373829, 'Purnawan', 'Jakarta, 15 November 1986','purnawaann','9828', 'Jalan Kartini', 'Oro Oro Dowo', 'Jeruk', 'Kediri', 'Jawa Timur', '64111'),
(70010, 1256373820, 'Budi', 'Yogyakarta, 20 November 1987', 'budiisaja', '3280', 'Jalan Cut Nyak Dien', 'Lowokwaru', 'Anggur', 'Banjarmasin', 'Jawa Timur', '70115')


INSERT INTO Karyawan_Nomor_Telepon
VALUES	(70001, '081234273554'),
		(70002, '081234273553'),
		(70003, '081234273557'),
		(70004, '081234273558'),
		(70005, '081234273552'),
		(70006, '081234273551'),
		(70007, '081234273555'),
		(70008, '081234273556'),
		(70009, '081234273559'),
		(70010, '081234273550'),
		(70010, '081234427355')

INSERT INTO Karyawan_Logistik(ID_Logistik, Karyawan_ID_Karyawan)
VALUES (71001, 70001),
	   (71002, 70002),
	   (71003, 70003),
	   (71004, 70004),
	   (71005, 70005)

INSERT INTO Karyawan_Admin(ID_Admin, Karyawan_ID_Karyawan)
VALUES (72006, 70006),
	   (72007, 70007),
	   (72008, 70008),
	   (72009, 70009),
	   (72010, 70010)

INSERT INTO Produk (ID_Produk,Nama_Produk, Harga, Tanggal_Kadaluwarsa, Berat) --ID_Produk gausah ditulis soalnya otomatis increment
VALUES (10001, 'Masker Wajah', 60000, '2029-09-10', 27.9),
	   (10002, 'Cream Wajah', 100000, '2029-12-06', 15),
	   (10003, 'Toner Wajah', 70000, '2030-06-11', 20),
	   (10004, 'Pelembab Wajah',50000, '2029-09-28',25.8),
	   (10005, 'Serum Wajah', 60000, '2029-10-25', 15),
	   (10006, 'Sunscreen', 64000, '2030-03-20', 20),
	   (10007, 'Pembersih Wajah', 40000, '2029-09-13', 30),
	   (10008, 'Serum Pelembab', 150000, '2029-09-11', 20),
	   (10009, 'Serum Exfoliasi', 155000, '2029-12-12', 20),
	   (10010, 'Serum Pencerah', 160000, '2030-06-07', 20),
	   (10011, 'Sabun Muka', 70000, '2029-09-06', 30),
	   (10012, 'Essence', 64000, '2029-10-08', 20),
	   (10013, 'Pelembab Bibir', 20000, '2030-03-02', 12)

INSERT INTO Pembeli 
VALUES (30001, 'Alula beauty', '081234273111','alulabeautyshop.id','alula01', 'Jalan Mawar', 'Belimbing' , 'Klojen', 'Jakarta', 'DKI Jakarta', '12345'),
	   (30002, 'Ghealsy.id', '081234273112', 'ghealsy.id.id','ghealsy02', 'Jalan Melati' , 'Stroberi', 'Lowokwaru', 'Jakarta', 'DKI Jakarta', '12345'),
	   (30003, 'beautee',  '081234273113','beauteeindo.id','beauteeindo', 'Jalan Kamboja', 'Apel', 'Malang', 'Madiun', 'Jawa Timur', '12345'),
	   (30004, 'fathia shop', '081234273114', 'fathia_shop.id','fathia04', 'Jalan Sepatu', 'Melon', 'Belimbing', 'Bandung',	'Jawa Barat', '12345'),
	   (30005, 'Keisya shop', '081234273115', 'keisya_shop.id','keisya05', 'Jalan Anyelir', 'Mangga', 'Junrejo', 'Madiun', 'Jawa Timur', '12345'),
	   (30006, 'Mira skincare', '081234273116', 'miraskin_care.id','mira06', 'Jalan Daisy', 'Semangka', 'Batu',	'Batu', 'Jawa Timur', '12345'),
	   (30007, 'Ruri Skincare', '081234273117', 'ruri.skincare.id','ruri07', 'Jalan Sekar', 'Apel',	'Malang', 'Madiun',	'Jawa Timur', '12345'),
	   (30008, 'Magenta Shop', '081234273118','gentashop.id','genta08', 'Jalan Tulip',	'Melon', 'Belimbing', 'Bandung', 'Jawa Barat', '12345'),
	   (30009, 'Roiyan Shop', '081234273119', 'roiyancare.id','roiyan09', 'Jalan Alamanda', 'Mangga',	'Junrejo',	'Madiun',	'Jawa Timur', '12345'),
	   (30010, 'Arya Skincare', '081234273110', 'aryaskincare.id','arya10', 'Jalan Akasia',	'Semangka', 'Batu',	'Batu',	'Jawa Timur', '12345')

--INSERT Keranjang
INSERT INTO Keranjang 
VALUES (40001, 30001),
	   (40002, 30002),
	   (40003, 30003),
	   (40004, 30004),
	   (40005, 30005),
	   (40006, 30006),
	   (40007, 30007),
	   (40008, 30008),
	   (40009, 30009),
	   (40010, 30010),
	   (40011, 30001),
	   (40012, 30002),
	   (40013, 30003),
	   (40014, 30004),
	   (40015, 30005),
	   (40016, 30006),
	   (40017, 30007),
	   (40018, 30008),
	   (40019, 30009),
	   (40020, 30010)

-- INSERT DETAIL PRODUK
INSERT INTO Keranjang_Detail_Produk 
VALUES	(40001, 10001,	150),
		(40001, 10007,	100),
		(40001, 10002,	230),
		(40002, 10004,	238),
		(40003, 10006,	128),
		(40004, 10005,	209),		
		(40005, 10004,	238),
		(40006, 10006,	128),
		(40007, 10008,	128),
		(40008, 10009,	209),
		(40009, 10010,	238),	
		(40010, 10011,	128),
		(40011,	10001,	50),
		(40011,	10002,	10),
		(40011,	10003,	5),
		(40011,	10004,	7),
		(40011,	10005,	4),
		(40012,	10002,	3),
		(40012,	10003,	4),
		(40012,	10004,	2),
		(40012,	10005,	4),
		(40012,	10006,	5),
		(40013,	10003,	3),
		(40013,	10004,	3),
		(40013,	10005,	4),
		(40013,	10006,	7),
		(40013,	10007,	1),
		(40014,	10004,	6),
		(40014,	10005,	8),
		(40014,	10006,	2),
		(40014,	10007,	3),
		(40014,	10008,	5),
		(40015,	10005,	7),
		(40015,	10006,	9),
		(40015,	10007,	1),
		(40015,	10008,	4),
		(40015,	10009,	6),
		(40016,	10010,	24),
		(40016,	10006,	5),
		(40016,	10007,	32),
		(40016,	10008,	5),
		(40016,	10009,	6),
		(40017,	10010,	7),
		(40017,	10007,	8),
		(40017,	10008,	4),
		(40017,	10009,	2),
		(40017,	10001,	4),
		(40018,	10011,	9),
		(40018,	10008,	8),
		(40018,	10009,	6),
		(40018,	10010,	7),
		(40018,	10001,	6),
		(40019,	10012,	4),
		(40019,	10013,	3),
		(40019,	10001,	4),
		(40019,	10002,	5),
		(40019,	10003,	7),
		(40020,	10004,	8),
		(40020,	10005,	9),
		(40020,	10006,	8),
		(40020,	10007,	4),
		(40020,	10008,	4)
		



--INSERT Keranjang_has_Produk
INSERT INTO Keranjang_has_Produk
VALUES	(40001, 10001,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10001 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40001)),
		(40001, 10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40001)),
		(40001, 10002,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10002 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40001)),
		(40002, 10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40002)),
		(40003, 10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40003 )),
		(40004, 10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40004 )),
		(40005, 10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40005)),
		(40006, 10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40006 )),
		(40007, 10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40007 )),
		(40008, 10009,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10009 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40008 )),
		(40009, 10010,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10010 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40009 )),
		(40010, 10011,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10011 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40010 )),
		(40011,	10001,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10001 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40011)),
		(40011,	10002,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10002 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40011)),
		(40011,	10003,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10003 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40011)),
		(40011,	10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40011)),
		(40011,	10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40011)),
		(40012,	10002,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10002 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40012)),
		(40012,	10003,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10003 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40012)),
		(40012,	10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40012)),
		(40012,	10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40012)),
		(40012,	10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40012)),
		(40013,	10003,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10003 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40013)),
		(40013,	10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40013)),
		(40013,	10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40013)),
		(40013,	10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40013)),
		(40013,	10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40013)),
		(40014,	10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40014)),
		(40014,	10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40014)),
		(40014,	10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40014)),
		(40014,	10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40014)),
		(40014,	10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40014)),
		(40015,	10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40015)),
		(40015,	10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40015)),
		(40015,	10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40015)),
		(40015,	10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40015)),
		(40015,	10009,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10009 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40015)),
		(40016,	10010,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10010 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40016)),
		(40016,	10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40016)),
		(40016,	10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40016)),
		(40016,	10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40016)),
		(40016,	10009,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10009 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40016)),
		(40017,	10010,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10010 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40017)),
		(40017,	10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40017)),
		(40017,	10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40017)),
		(40017,	10009,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10009 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40017)),
		(40017,	10001,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10001 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40017)),
		(40018,	10011,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10011 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40018)),
		(40018,	10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40018)),
		(40018,	10009,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10009 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40018)),
		(40018,	10010,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10010 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40018)),
		(40018,	10001,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10001 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40018)),
		(40019,	10012,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10012 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40019)),
		(40019,	10013,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10013 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40019)),
		(40019,	10001,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10001 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40019)),
		(40019,	10002,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10002 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40019)),
		(40019,	10003,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10003 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40019)),
		(40020,	10004,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10004 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40020)),
		(40020,	10005,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10005 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40020)),
		(40020,	10006,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10006 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40020)),
		(40020,	10007,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10007 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40020)),
		(40020,	10008,(SELECT Produk.Harga*Keranjang_Detail_Produk.Kuantitas From Keranjang_Detail_Produk JOIN Produk ON Produk.ID_Produk=Keranjang_Detail_Produk.Produk_ID_Produk WHERE Produk.ID_Produk = 10008 AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = 40020))
		
-- INSERT Pesanan
INSERT INTO Pesanan (ID_Pesanan,Keranjang_ID_Keranjang, Karyawan_Admin_ID_Admin, Waktu_Pemesanan, Total_Harga, Ongkos_Kirim, Status_Pemesanan)
VALUES (50001, 40001, 72006, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40001), 20000, 'SUDAH LUNAS'),
	   (50002, 40002, 72007, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40002), 20000, 'SUDAH LUNAS'),
	   (50003, 40003, 72008, '2022-09-12', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40003), 20000, 'SUDAH LUNAS'),
	   (50004, 40004, 72009, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40004), 20000, 'SUDAH LUNAS'),
	   (50005, 40005, 72010, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40005), 20000, 'SUDAH LUNAS'),
	   (50006, 40006, 72006, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40006), 20000, 'SUDAH LUNAS'),
	   (50007, 40007, 72007, '2022-09-12', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40007), 20000, 'SUDAH LUNAS'),
	   (50008, 40008, 72008, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40008), 20000, 'SUDAH LUNAS'),
	   (50009, 40009, 72009, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40009), 20000, 'SUDAH LUNAS'),
	   (50010, 40010, 72010, '2022-09-15', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40010), 20000, 'SUDAH LUNAS'),
	   (50011, 40011, 72006, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40011), 20000, 'SUDAH LUNAS'),
	   (50012, 40012, 72007, '2022-09-17', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40012), 20000, 'SUDAH LUNAS'),
	   (50013, 40013, 72008, '2022-09-13', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40013),	20000, 'SUDAH LUNAS'),
	   (50014, 40014, 72009, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40014),	20000, 'SUDAH LUNAS'),
	   (50015, 40015, 72010, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40015),	20000, 'SUDAH LUNAS'),
	   (50016, 40016, 72006, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40016),	20000, 'SUDAH LUNAS'),
	   (50017, 40017, 72007, '2022-09-13', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40017),	20000, 'SUDAH LUNAS'),
	   (50018, 40018, 72008, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40018),	20000, 'SUDAH LUNAS'),
	   (50019, 40019, 72009, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40019),	20000, 'SUDAH LUNAS'),
	   (50020, 40020, 72010, '2022-09-16', (SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = 40020),	20000, 'SUDAH LUNAS')

--INSERT Pembayaran
INSERT INTO Pembayaran (ID_Pembayaran, Pesanan_ID_Pesanan, Waktu_Pembayaran, Jenis_Pembayaran, Total_Pembayaran)
VALUES (80001, 50001, '2022-09-15', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50001)),
	   (80002, 50002, '2022-09-18', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50002)),
	   (80003, 50003, '2022-09-15', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50003)),
	   (80004, 50004, '2022-09-15', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50004)),
	   (80005, 50005, '2022-09-15', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50005)),
	   (80006, 50006, '2022-09-15', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50006)),
	   (80007, 50007, '2022-09-15', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50007)),
	   (80008, 50008, '2022-09-15', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50008)),
	   (80009, 50009, '2022-09-15', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50009)),
	   (80010, 50010, '2022-09-15', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50010)),
	   (80011, 50011, '2022-09-17', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50011)),
	   (80012, 50012, '2022-09-18', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50012)),
	   (80013, 50013, '2022-09-14', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50013)),
	   (80014, 50014, '2022-09-17', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50014)),
	   (80015, 50015, '2022-09-17', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50015)),
	   (80016, 50016, '2022-09-17', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50016)),
	   (80017, 50017, '2022-09-14', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50017)),
	   (80018, 50018, '2022-09-17', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50018)),
	   (80019, 50019, '2022-09-17', 'Transfer',	(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50019)),
	   (80020, 50020, '2022-09-17', 'COD',		(SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = 50020))

INSERT INTO Pengiriman (ID_Pengiriman, Pesanan_ID_Pesanan, Karyawan_Logistik_ID_Logistik, Status_Pengiriman)
VALUES (60001, 50001, 71001, 'DALAM PERJALANAN'),
	   (60002, 50002, 71002, 'SAMPAI TUJUAN'),
	   (60003, 50003, 71003, 'SAMPAI TUJUAN'),
	   (60004, 50004, 71004, 'DALAM PERJALANAN'),
	   (60005, 50005, 71005, 'SAMPAI TUJUAN'),
	   (60006, 50006, 71001, 'DALAM PERJALANAN'),
	   (60007, 50007, 71002, 'SAMPAI TUJUAN'),
	   (60008, 50008, 71003, 'DALAM PERJALANAN'),
	   (60009, 50009, 71004, 'DALAM PERJALANAN'),
	   (60010, 50010, 71005, 'DALAM PERJALANAN'),
	   (60011, 50011, 71001, 'DALAM PERJALANAN'),
	   (60012, 50012, 71002, 'SAMPAI TUJUAN'),
	   (60013, 50013, 71003, 'SAMPAI TUJUAN'),
	   (60014, 50014, 71004, 'DALAM PERJALANAN'),
	   (60015, 50015, 71005, 'SAMPAI TUJUAN'),
	   (60016, 50016, 71001, 'DALAM PERJALANAN'),
	   (60017, 50017, 71002, 'SAMPAI TUJUAN'),
	   (60018, 50018, 71003, 'DALAM PERJALANAN'),
	   (60019, 50019, 71004, 'DALAM PERJALANAN'),
	   (60020, 50020, 71005, 'DALAM PERJALANAN')



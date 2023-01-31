/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lotusbeautygui;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Pinto
 */
public class Pesanan extends javax.swing.JFrame {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstate = null;
    Statement state;
    Boolean bool = false;
    
    public boolean newData;
    public boolean editData;
   
    private void Connection() {
	try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433; integratedSecurity=false; encrypt=false; trustServerCertificate=true;"
                +"DatabaseName=LotusBeauty; user=kelompok3; password=1234;" +
                "loginTimeout=30;";

            con = DriverManager.getConnection(connectionUrl);
            state = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
            
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                System.exit(0);
        }
    }
    
    private void Display(){
        try {
            String sql = "SELECT Produk.Nama_Produk, Produk.Harga, Keranjang_Detail_Produk.Kuantitas, Keranjang_has_Produk.Sub_Total FROM Pesanan, Keranjang, Keranjang_Detail_Produk, Keranjang_has_Produk, Pembeli, Produk WHERE Pesanan.Keranjang_ID_Keranjang = Keranjang.ID_Keranjang AND	  Keranjang.ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND   Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND   Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko AND   Keranjang_Detail_Produk.Produk_ID_Produk = Produk.ID_Produk AND   Keranjang_has_Produk.Produk_ID_Produk = Produk.ID_Produk AND Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            tabelData.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form Karyawan
     */
    public Pesanan() {
        initComponents();
        Connection();
        Display();
        this.setTitle("Pesanan");
        
        ResultSet resultSet = null;
        try {
            Connection();
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT TOP 1 Pesanan.ID_Pesanan, Pembeli.ID_Toko, Pembeli.Nama_Toko, Pesanan.Ongkos_Kirim, Pesanan.Total_Harga FROM Pesanan, Keranjang, Keranjang_Detail_Produk, Keranjang_has_Produk, Pembeli, Produk WHERE Pesanan.Keranjang_ID_Keranjang = Keranjang.ID_Keranjang AND	  Keranjang.ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND   Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND   Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko AND   Keranjang_Detail_Produk.Produk_ID_Produk = Produk.ID_Produk AND   Keranjang_has_Produk.Produk_ID_Produk = Produk.ID_Produk AND   Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'");
            String idPesanan = null;
            String idToko = null;
            String namaToko = null;
            String ongkosKirim = null;
            String totalHarga = null;
            while(resultSet.next()){
                idPesanan = resultSet.getString(1);
                idToko = resultSet.getString(2);
                namaToko = resultSet.getString(3);
                ongkosKirim = resultSet.getString(4);
                totalHarga = resultSet.getString(5);
            }
            txtFieldidPesanan.setText(idPesanan);
            txtFieldidToko.setText(idToko);
            txtFieldnamaToko.setText(namaToko);
            txtFieldOngkir.setText(ongkosKirim);
            txtFieldTotal.setText(totalHarga);
            }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
            }
    }
    
    private void clearFields(){
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFieldidPembayaran = new javax.swing.JTextField();
        txtFieldidPengiriman = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnTxtBack = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        btnBayar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFieldOngkir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFieldidPesanan = new javax.swing.JTextField();
        txtFieldidToko = new javax.swing.JTextField();
        jLabel_InfoEditKeranjang = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFieldnamaToko = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFieldTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboJenisPembayaran = new javax.swing.JComboBox<>();

        txtFieldidPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldidPembayaranActionPerformed(evt);
            }
        });

        txtFieldidPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldidPengirimanActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 142, 202));

        btnTxtBack.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtBack.setText("<< Back");
        btnTxtBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtBackMouseClicked(evt);
            }
        });

        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        btnSearch.setText("Search");

        tabelData.setBackground(new java.awt.Color(255, 231, 255));
        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Produk", "Harga", "Kuantitas", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelData);

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Pesanan");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ongkos Kirim");

        txtFieldOngkir.setText("20000");
        txtFieldOngkir.setToolTipText("");
        txtFieldOngkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldOngkirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Toko Pembeli");

        txtFieldidPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldidPesananActionPerformed(evt);
            }
        });

        txtFieldidToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldidTokoActionPerformed(evt);
            }
        });

        jLabel_InfoEditKeranjang.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_InfoEditKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_InfoEditKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_InfoEditKeranjang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Toko Pembeli");

        txtFieldnamaToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldnamaTokoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total");

        txtFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldTotalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pilih Jenis Pembayaran");

        comboJenisPembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transfer", "COD" }));
        comboJenisPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJenisPembayaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTxtBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66)
                                .addComponent(txtFieldidPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFieldidToko, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtFieldnamaToko, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(comboJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(20, 20, 20)
                                        .addComponent(txtFieldOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel_InfoEditKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnBayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFieldTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))))
                        .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTxtBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldidPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(comboJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFieldOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFieldidToko, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFieldnamaToko, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel_InfoEditKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTxtBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtBackMouseClicked
        // TODO add your handling code here:
        MenuPelanggan mn = new MenuPelanggan();
        mn.setVisible(true);
        mn.pack();
        mn.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnTxtBackMouseClicked

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
//        LocalDateTime localDate = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        ResultSet resultSet = null;
        try {
            Connection();
            
            System.out.println(date);
            
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT Total_Harga + Ongkos_Kirim FROM Pesanan WHERE Pesanan.ID_Pesanan = '"+txtFieldidPesanan.getText()+"'");
            String totalPembayaran = null;
            while(resultSet.next()){
                totalPembayaran = resultSet.getString(1);
            }
            
            String query4 = "select top 1 ID_Pembayaran from Pembayaran order by ID_Pembayaran desc";
            rs = state.executeQuery(query4);
            if (rs.next()) {
                String ID_Pembayaran = rs.getString("ID_Pembayaran");
                txtFieldidPembayaran.setText(ID_Pembayaran);
            }
            String a = txtFieldidPembayaran.getText();
            int b =  Integer.parseInt(a) + 1;
            
            
            String query5 = "select top 1 ID_Pengiriman from Pengiriman order by ID_Pengiriman desc";
            rs = state.executeQuery(query5);
            if (rs.next()) {
                String ID_Pengiriman = rs.getString("ID_Pengiriman");
                txtFieldidPengiriman.setText(ID_Pengiriman);
            }
            String c = txtFieldidPengiriman.getText();
            int d =  Integer.parseInt(c) + 1;
            
            String query = "INSERT INTO Pembayaran VALUES('"+b+"','"+txtFieldidPesanan.getText()+"','"+date+"','"+comboJenisPembayaran.getSelectedItem().toString()+"','"+totalPembayaran+"')";
            state.executeUpdate(query);
            
            String query2 = "UPDATE Pesanan SET Status_Pemesanan = 'SUDAH LUNAS' WHERE ID_Pesanan = '"+txtFieldidPesanan.getText()+"'";
            state.executeUpdate(query2);
            
            String query3 = "INSERT INTO Pengiriman (ID_Pengiriman, Pesanan_ID_Pesanan, Karyawan_Logistik_ID_Logistik, Status_Pengiriman) VALUES('"+d+"','"+txtFieldidPesanan.getText()+"', 72004, 'DALAM PERJALANAN')";
            System.out.println(d);
            System.out.println("mulai query 3");
            state.executeUpdate(query3);
            
            Display();
            state.close();
            con.close();
            clearFields();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
            }
        
        KonfirmasiPembayaran p = new KonfirmasiPembayaran();
        p.setVisible(true);
        p.pack();
        p.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnBayarActionPerformed

    private void txtFieldOngkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldOngkirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldOngkirActionPerformed

    private void txtFieldidPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidPesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidPesananActionPerformed

    private void txtFieldidTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidTokoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidTokoActionPerformed

    private void txtFieldnamaTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldnamaTokoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldnamaTokoActionPerformed

    private void txtFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldTotalActionPerformed

    private void comboJenisPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJenisPembayaranActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboJenisPembayaranActionPerformed

    private void txtFieldidPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidPembayaranActionPerformed

    private void txtFieldidPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidPengirimanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidPengirimanActionPerformed

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
//            String query = "select * from produk left outer join Keranjang_Detail_Produk on Produk.ID_Produk = Keranjang_Detail_Produk.Produk_ID_Produk left outer join Keranjang_has_Produk on Produk.ID_Produk = Keranjang_has_Produk.Produk_ID_Produk where Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang and Keranjang_Detail_Produk.Produk_ID_Produk = Keranjang_has_Produk.Produk_ID_Produk and Keranjang_Detail_Produk.Keranjang_ID_Keranjang = '"+z+"' and Nama_Produk like '%"+searchText.getText()+"%' or Harga like '%"+searchText.getText()+"%' or Kuantitas like '%"+searchText.getText()+"%' or Sub_Total like '%"+searchText.getText()+"%'";            
//            rs = state.executeQuery(query);
            tabelData.setModel(DbUtils.resultSetToTableModel(rs));  
        }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_searchTextKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel btnTxtBack;
    private javax.swing.JComboBox<String> comboJenisPembayaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_InfoEditKeranjang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchText;
    private javax.swing.JTable tabelData;
    private javax.swing.JTextField txtFieldOngkir;
    private javax.swing.JTextField txtFieldTotal;
    private javax.swing.JTextField txtFieldidPembayaran;
    private javax.swing.JTextField txtFieldidPengiriman;
    private javax.swing.JTextField txtFieldidPesanan;
    private javax.swing.JTextField txtFieldidToko;
    private javax.swing.JTextField txtFieldnamaToko;
    // End of variables declaration//GEN-END:variables
}

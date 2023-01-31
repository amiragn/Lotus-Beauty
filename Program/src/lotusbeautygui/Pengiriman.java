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
import java.util.HashMap;
import java.util.Map;
import net.proteanit.sql.DbUtils;
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
public class Pengiriman extends javax.swing.JFrame {
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
            String sql = "SELECT Pesanan.ID_Pesanan, Pengiriman.ID_Pengiriman, Produk.Nama_Produk, Pembayaran.Total_Pembayaran, Pengiriman.Status_Pengiriman FROM Keranjang, Keranjang_Detail_Produk, Keranjang_has_Produk, Pembeli, Produk, Pesanan, Pengiriman, Pembayaran WHERE Keranjang.ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND   Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND   Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko AND   Keranjang_Detail_Produk.Produk_ID_Produk = Produk.ID_Produk AND   Keranjang_has_Produk.Produk_ID_Produk = Produk.ID_Produk AND	  Pesanan.Keranjang_ID_Keranjang = Keranjang.ID_Keranjang AND   Pesanan.Keranjang_ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND	  Pesanan.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND   Pengiriman.Pesanan_ID_Pesanan = Pesanan.ID_Pesanan AND   Pembayaran.Pesanan_ID_Pesanan = Pesanan.ID_Pesanan AND   Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'";
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
    public Pengiriman() {
        initComponents();
        Connection();
        Display();
        this.setTitle("Pengiriman");
        
        ResultSet resultSet = null;
        try {
            Connection();
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT TOP 1 Pembeli.ID_Toko, Pembeli.Nama_Toko, CONCAT(Pembeli.Jalan, ', ', Pembeli.Kelurahan, ', ', Pembeli.Kecamatan, ', ', Pembeli.Kota, ', ', Pembeli.Provinsi, ', ', Pembeli.Kode_Pos) AS 'Alamat' FROM Keranjang, Keranjang_Detail_Produk, Keranjang_has_Produk, Pembeli, Produk, Pesanan, Pengiriman, Pembayaran WHERE Keranjang.ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND   Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND   Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko AND   Keranjang_Detail_Produk.Produk_ID_Produk = Produk.ID_Produk AND   Keranjang_has_Produk.Produk_ID_Produk = Produk.ID_Produk AND	  Pesanan.Keranjang_ID_Keranjang = Keranjang.ID_Keranjang AND   Pesanan.Keranjang_ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND	  Pesanan.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND   Pengiriman.Pesanan_ID_Pesanan = Pesanan.ID_Pesanan AND   Pembayaran.Pesanan_ID_Pesanan = Pesanan.ID_Pesanan AND   Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'");
            String idToko = null;
            String namaToko = null;
            String alamat = null;
            while(resultSet.next()){
                idToko = resultSet.getString(1);
                namaToko = resultSet.getString(2);
                alamat = resultSet.getString(3);
            }
            txtFieldidToko.setText(idToko);
            txtFieldnamaToko.setText(namaToko);
            txtFieldAlamat.setText(alamat);
            }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
            }
    }
    
    private static String destFileName = "NotaPembelian.pdf";
    
    private static JasperReport getJasperReport() throws FileNotFoundException, JRException{
        File template = Paths.get("NOTAPEMBELIANFIX.jrxml").toFile();
        return JasperCompileManager.compileReport(template.getAbsolutePath());
    }

    private static Map<String, Object> getParameters() {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("dibuatOleh", "Fathia");
        return parameters;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idPesanan = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnTxtBack = new javax.swing.JLabel();
        jTextField_search = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFieldidToko = new javax.swing.JTextField();
        txtFieldnamaToko = new javax.swing.JTextField();
        jLabel_InfoEditKeranjang = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFieldAlamat = new javax.swing.JTextField();
        jasperButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 142, 202));

        btnTxtBack.setForeground(new java.awt.Color(255, 255, 255));
        btnTxtBack.setText("<< Back");
        btnTxtBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtBackMouseClicked(evt);
            }
        });

        btnSearch.setText("Search");

        tabelData.setBackground(new java.awt.Color(255, 231, 255));
        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "ID Pengiriman", "Nama Produk", "Total", "Status Pengiriman"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelData);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Toko Pembeli");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Toko");

        txtFieldidToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldidTokoActionPerformed(evt);
            }
        });

        txtFieldnamaToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldnamaTokoActionPerformed(evt);
            }
        });

        jLabel_InfoEditKeranjang.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_InfoEditKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_InfoEditKeranjang.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_InfoEditKeranjang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alamat");

        txtFieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldAlamatActionPerformed(evt);
            }
        });

        jasperButton.setText("Print Nota");
        jasperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jasperButtonActionPerformed(evt);
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
                                .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(txtFieldidToko, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_InfoEditKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtFieldnamaToko, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jasperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114))))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTxtBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldidToko, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFieldnamaToko, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jasperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_InfoEditKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void txtFieldnamaTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldnamaTokoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldnamaTokoActionPerformed

    private void txtFieldidTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidTokoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidTokoActionPerformed

    private void btnTxtBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtBackMouseClicked
        // TODO add your handling code here:
        MenuPelanggan mn = new MenuPelanggan();
        mn.setVisible(true);
        mn.pack();
        mn.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnTxtBackMouseClicked

    private void txtFieldAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldAlamatActionPerformed

    private void jasperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jasperButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
            String query = "select top 1 ID_Pesanan from Pesanan order by ID_Pesanan desc";
            rs = state.executeQuery(query);
            if (rs.next()) {
                String ID_Pesanan = rs.getString("ID_Pesanan");
                idPesanan.setText(ID_Pesanan);
            }
            
            System.out.println("Membuat Jasper Report... ");
            JasperReport jasperReport = getJasperReport();
            Map<String,Object> parameters = getParameters();
            parameters.put("param", txtFieldidToko.getText());
            parameters.put("param2", idPesanan.getText());
            
            System.out.println("Report Selesai");

            String connectionUrl = "jdbc:sqlserver://localhost:1433; integratedSecurity=false; encrypt=false; trustServerCertificate=true;"
            +"DatabaseName=LotusBeauty; user=kelompok3; password=1234;" +
            "loginTimeout=30;";
            try {
                java.sql.Connection connection = DriverManager.getConnection(connectionUrl);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
                JasperViewer.viewReport(jasperPrint, false);
                JasperExportManager.exportReportToPdfFile(jasperPrint,  destFileName);
            } catch (java.sql.SQLException ex) {
                ex.printStackTrace();
            }
        } catch(Exception  e) {
            //            Logger.getLogger(KonfirmasiPembayaran.class.getName()).log(Level.SEVERE, null, e);
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jasperButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengiriman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel btnTxtBack;
    private javax.swing.JTextField idPesanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_InfoEditKeranjang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JButton jasperButton;
    private javax.swing.JTable tabelData;
    private javax.swing.JTextField txtFieldAlamat;
    private javax.swing.JTextField txtFieldidToko;
    private javax.swing.JTextField txtFieldnamaToko;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lotusbeautygui;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.proteanit.sql.DbUtils;
import java.util.Date;


/**
 *
 * @author Pinto
 */
public class Keranjang extends javax.swing.JFrame {
    /**
     * Creates new form Karyawan
     */
    
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
            String sql = "SELECT Keranjang.ID_Keranjang, Pembeli.ID_Toko, Produk.ID_Produk, Produk.Nama_Produk, Produk.Berat, Produk.Tanggal_Kadaluwarsa, Produk.Harga, Keranjang_Detail_Produk.Kuantitas, Keranjang_has_Produk.Sub_Total FROM Keranjang, Keranjang_Detail_Produk, Keranjang_has_Produk, Pembeli, Produk WHERE Keranjang.ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko AND  Keranjang_Detail_Produk.Produk_ID_Produk = Produk.ID_Produk AND Keranjang_has_Produk.Produk_ID_Produk = Produk.ID_Produk AND Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"' AND Keranjang.ID_Keranjang = (select top 1 ID_Keranjang from Keranjang order by ID_Keranjang desc)";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            tabelData.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Keranjang() {
        initComponents();
        Connection();
        Display();
        this.setTitle("Keranjang");
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        
        ResultSet resultSet = null;
        try {
            Connection();
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT Keranjang.ID_Keranjang, Pembeli.ID_Toko FROM Keranjang JOIN Pembeli ON Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko WHERE Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'");
            String idKeranjang = null;
            String idToko = null;
            while(resultSet.next()){
                idKeranjang = resultSet.getString(1);
                idToko = resultSet.getString(2);
            }
            txtFieldidKeranjang.setText(idKeranjang);
            txtFieldidToko.setText(idToko);
            }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
            }
    }
    
    private void clearFields(){
        idText.setText(null);
        jSpinner_kuantitas.setValue(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tesText = new javax.swing.JTextField();
        idPesanan = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnTxtBack = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnPesanSekarang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEditKeranjang = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFieldidKeranjang = new javax.swing.JTextField();
        txtFieldidToko = new javax.swing.JTextField();
        jLabel_InfoEditKeranjang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_kuantitas = new javax.swing.JSpinner();

        idPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPesananActionPerformed(evt);
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Produk", "Berat (kg)", "Tanggal Kadaluwarsa", "Harga", "Kuantitas", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelData);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnPesanSekarang.setText("Pesan Sekarang");
        btnPesanSekarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanSekarangActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Keranjang");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEditKeranjang.setText("Edit Keranjang");
        btnEditKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditKeranjangActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Produk");

        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Toko Pembeli");

        txtFieldidKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldidKeranjangActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kuantitas");

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
                                .addComponent(btnSearch))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner_kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtFieldidToko, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(txtFieldidKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_InfoEditKeranjang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEditKeranjang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSave)
                                .addGap(12, 12, 12)
                                .addComponent(btnPesanSekarang)))
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
                    .addComponent(jLabel4)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldidKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtFieldidToko, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jSpinner_kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel_InfoEditKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesanSekarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        btnPesanSekarang.setEnabled(true);
        btnEditKeranjang.setEnabled(true);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        //kesave dulu
        clearFields();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPesanSekarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanSekarangActionPerformed
        // TODO add your handling code here:
//        LocalDateTime localDate = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");
        
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        try {
            Connection();
            state = con.createStatement();
//            PreparedStatement st = con.prepareStatement("INSERT INTO Pesanan VALUES(?,?,?,?,?,?,?)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("mulai");
            
            resultSet = state.executeQuery("SELECT Keranjang.ID_Keranjang, Pembeli.ID_Toko FROM Keranjang JOIN Pembeli ON Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko WHERE Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'");
            String idKeranjang = null;
            String idToko = null;
            while(resultSet.next()){
                idKeranjang = resultSet.getString(1);
                idToko = resultSet.getString(2);
            }
            System.out.println(idKeranjang);
            System.out.println(idToko);
            
            String Sub_Total = null;
            resultSet2 = state.executeQuery("SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = '"+idKeranjang+"'");
            while(resultSet2.next()){
                Sub_Total = resultSet2.getString(1);
            }
            System.out.println(Sub_Total);
            
            String date = sdf.format(new Date());
            System.out.println(date);
            
            String query3 = "select top 1 ID_Pesanan from Pesanan order by ID_Pesanan desc";
            rs = state.executeQuery(query3);
            if (rs.next()) {
                String ID_Pesanan = rs.getString("ID_Pesanan");
                tesText.setText(ID_Pesanan);
            }
            String a = tesText.getText();
            int b =  Integer.parseInt(a) + 1;
            
            String query = "INSERT INTO Pesanan VALUES('"+b+"','"+idKeranjang+"', 71010, '"+date+"','"+Sub_Total+"', 20000, 'BELUM LUNAS')";
            state.executeUpdate(query);
            
            String query4 = "select top 1 ID_Keranjang from Keranjang order by ID_Keranjang desc";
            rs = state.executeQuery(query4);
            if (rs.next()) {
                String ID_Keranjang = rs.getString("ID_Keranjang");
                txtFieldidKeranjang.setText(ID_Keranjang);
            }
            String g = txtFieldidKeranjang.getText();
            int h =  Integer.parseInt(g) + 1;
            System.out.println(h);
                    
            String query5 = "insert into Keranjang values('"+h+"','"+txtFieldidToko.getText()+"')";
            state.executeUpdate(query5);

            
//            String query = "INSERT INTO Pesanan VALUES('"+idPesanan.getText()+"','"+idKeranjang+"', 71010, '"+date+"','"+Sub_Total+"', 20000, 'BELUM LUNAS')";
//            state.setString(1, idPesanan.getText());
//            state.setString(2, idKeranjang);
//            state.setString(3, null);
//            state.setString(4, date);
//            state.setString(5, Sub_Total);
//            state.setString(6, "20000");
//            state.setString(7, "BELUM LUNAS");
//            String query = "insert into Pesanan values('"+idPesanan.getText()+"','"+idKeranjang+"',"+dtf.format(localDate)+",'(SELECT SUM(Sub_Total) FROM Keranjang_has_Produk WHERE Keranjang_has_Produk.Keranjang_ID_Keranjang = '"+idKeranjang+"'), 20000, 'BELUM LUNAS')'";
            
            Display();
            state.close();
            con.close();
            clearFields();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
            }
        
        Pesanan p = new Pesanan();
        p.setVisible(true);
        p.pack();
        p.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnPesanSekarangActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
            String query2 = "delete from Keranjang_Detail_Produk where Produk_ID_Produk= '"+idText.getText()+"'";
            state.executeUpdate(query2);
            String query3 = "delete from Keranjang_has_Produk where Produk_ID_Produk = '"+idText.getText()+"'";
            state.executeUpdate(query3);
            Display();
            state.close();
            con.close();
            clearFields();
            btnPesanSekarang.setEnabled(true);
            btnEditKeranjang.setEnabled(true);
            btnDelete.setEnabled(false);
            btnSave.setEnabled(false);
            //kedelete dulu
            clearFields();
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");
        }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditKeranjangActionPerformed
        // TODO add your handling code here:
        
        jLabel_InfoEditKeranjang.setText("!!! Ketik Nama Produk yang ingin diedit/dihapus !!!");
        clearFields();
        btnPesanSekarang.setEnabled(false);
        btnEditKeranjang.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEditKeranjangActionPerformed

    private void idTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextActionPerformed

    private void txtFieldidKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidKeranjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidKeranjangActionPerformed

    private void txtFieldidTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldidTokoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldidTokoActionPerformed

    private void tabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataMouseClicked
        // TODO add your handling code here:
        try {
            Connection();
            int row = tabelData.getSelectedRow();
            String klik = (tabelData.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from Keranjang where ID_Produk='"+klik+"'");
            if(sql.next()){
                String ID_Produk = sql.getString("ID_Produk");
                idText.setText(ID_Produk);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_tabelDataMouseClicked

    private void idPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPesananActionPerformed

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
            String query = "SELECT Keranjang.ID_Keranjang, Pembeli.ID_Toko, Produk.ID_Produk, Produk.Nama_Produk, Produk.Berat, Produk.Tanggal_Kadaluwarsa, Produk.Harga, Keranjang_Detail_Produk.Kuantitas, Keranjang_has_Produk.Sub_Total "
                    + "FROM Keranjang, Keranjang_Detail_Produk, Keranjang_has_Produk, Pembeli, Produk "
                    + "WHERE Keranjang.ID_Keranjang = Keranjang_Detail_Produk.Keranjang_ID_Keranjang AND Keranjang_Detail_Produk.Keranjang_ID_Keranjang = Keranjang_has_Produk.Keranjang_ID_Keranjang AND Keranjang.Pembeli_ID_Toko = Pembeli.ID_Toko AND  Keranjang_Detail_Produk.Produk_ID_Produk = Produk.ID_Produk AND Keranjang_has_Produk.Produk_ID_Produk = Produk.ID_Produk "
                    + "AND Pembeli.Username_Pembeli = '"+LoginForm.usernameText.getText()+"'"
                    + " or Keranjang.ID_Keranjang like '%"+searchText.getText()+"%' "
                    + "or Pembeli.ID_Toko like '%"+searchText.getText()+"%' "
                    + "or Produk.ID_Produk like '%"+searchText.getText()+"%' "
                    + "or Produk.Nama_Produk like '%"+searchText.getText()+"%' "
                    + "or Produk.Berat like '%"+searchText.getText()+"%'"
                    + "or Produk.Tanggal_Kadaluwarsa like '%"+searchText.getText()+"%'"
                    + "or Produk.Harga like '%"+searchText.getText()+"%'"
                    + "or Keranjang_Detail_Produk.Kuantitas like '%"+searchText.getText()+"%'"
                    + "or Keranjang_has_Produk.Sub_Total like '%"+searchText.getText()+"%'";
            rs = state.executeQuery(query);
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
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keranjang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditKeranjang;
    private javax.swing.JButton btnPesanSekarang;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel btnTxtBack;
    private javax.swing.JTextField idPesanan;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_InfoEditKeranjang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_kuantitas;
    private javax.swing.JTextField searchText;
    private javax.swing.JTable tabelData;
    private javax.swing.JTextField tesText;
    private javax.swing.JTextField txtFieldidKeranjang;
    private javax.swing.JTextField txtFieldidToko;
    // End of variables declaration//GEN-END:variables
}
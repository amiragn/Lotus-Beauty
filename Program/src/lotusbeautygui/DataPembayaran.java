/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lotusbeautygui;

import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;

/**
 *
 * @author Pinto
 */
public class DataPembayaran extends javax.swing.JFrame {

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
            String sql = "select * from Pembayaran";
            pstate = con.prepareStatement(sql);
            rs = pstate.executeQuery();
            tabelData.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public DataPembayaran() {
        initComponents();
        Connection();
        Display();
        this.setTitle("Data Pembayaran");
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    
    private void clearFields(){
        pembayaranText.setText(null);
        pesananText.setText(null);
        waktuText.setText(null);
        totalText.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        firstButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pembayaranText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pesananText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        waktuText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        jenisCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 142, 202));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<< Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        tabelData.setBackground(new java.awt.Color(255, 231, 255));
        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pembayaran", "ID Pesanan", "Waktu Pembayaran", "Jenis Pembayaran", "Total Pembayaran", "Status Pemesanan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
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

        firstButton.setText("<<");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        prevButton.setText("<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        lastButton.setText(">>");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Pembayaran");

        pembayaranText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembayaranTextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Pesanan");

        pesananText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesananTextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Waktu Pemesanan");

        waktuText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waktuTextActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jenis Pembayaran");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Pembayaran");

        totalText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTextActionPerformed(evt);
            }
        });

        jenisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transfer", "COD" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pembayaranText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pesananText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(waktuText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jenisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(firstButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(161, 161, 161))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pembayaranText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pesananText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(waktuText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jenisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        MenuKaryawan mn = new MenuKaryawan();
        mn.setVisible(true);
        mn.pack();
        mn.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            tabelData.changeSelection(0,0,false,false);
            int row = tabelData.getSelectedRow();
            String klik = (tabelData.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from Pembayaran where ID_Pembayaran='"+klik+"'");
            if(sql.next()){
                String ID_Pembayaran = sql.getString("ID_Pembayaran");
                pembayaranText.setText(ID_Pembayaran);
                String Pesanan_ID_Pesanan = sql.getString("Pesanan_ID_Pesanan");
                pesananText.setText(Pesanan_ID_Pesanan);
                String Waktu_Pembayaran = sql.getString("Waktu_Pembayaran");
                waktuText.setText(Waktu_Pembayaran);
                String Jenis_Pembayaran = sql.getString("Jenis_Pembayaran");
                jenisCombo.setSelectedItem(Jenis_Pembayaran);
                String Total_Pembayaran = sql.getString("Total_Pembayaran");
                totalText.setText(Total_Pembayaran);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_firstButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            int row = tabelData.getSelectedRow();
            tabelData.changeSelection(row-1,0,false,false);
            row = tabelData.getSelectedRow();
            String klik = (tabelData.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from Pembayaran where ID_Pembayaran='"+klik+"'");
            if(sql.next()){
                String ID_Pembayaran = sql.getString("ID_Pembayaran");
                pembayaranText.setText(ID_Pembayaran);
                String Pesanan_ID_Pesanan = sql.getString("Pesanan_ID_Pesanan");
                pesananText.setText(Pesanan_ID_Pesanan);
                String Waktu_Pembayaran = sql.getString("Waktu_Pembayaran");
                waktuText.setText(Waktu_Pembayaran);
                String Jenis_Pembayaran = sql.getString("Jenis_Pembayaran");
                jenisCombo.setSelectedItem(Jenis_Pembayaran);
                String Total_Pembayaran = sql.getString("Total_Pembayaran");
                totalText.setText(Total_Pembayaran);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            int row = tabelData.getSelectedRow();
            int count = tabelData.getRowCount();
            if (row == (count-1)) {
                tabelData.changeSelection(count-1,0,false,false);
            }
            else {
                tabelData.changeSelection(row+1,0,false,false);
            }
            row = tabelData.getSelectedRow();
            String klik = (tabelData.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from Pembayaran where ID_Pembayaran='"+klik+"'");
            if(sql.next()){
                String ID_Pembayaran = sql.getString("ID_Pembayaran");
                pembayaranText.setText(ID_Pembayaran);
                String Pesanan_ID_Pesanan = sql.getString("Pesanan_ID_Pesanan");
                pesananText.setText(Pesanan_ID_Pesanan);
                String Waktu_Pembayaran = sql.getString("Waktu_Pembayaran");
                waktuText.setText(Waktu_Pembayaran);
                String Jenis_Pembayaran = sql.getString("Jenis_Pembayaran");
                jenisCombo.setSelectedItem(Jenis_Pembayaran);
                String Total_Pembayaran = sql.getString("Total_Pembayaran");
                totalText.setText(Total_Pembayaran);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_nextButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            int count = tabelData.getRowCount(); 
            tabelData.changeSelection(count-1,0,false,false);
            int row = tabelData.getSelectedRow();
            String klik = (tabelData.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from Pembayaran where ID_Pembayaran='"+klik+"'");
            if(sql.next()){
                String ID_Pembayaran = sql.getString("ID_Pembayaran");
                pembayaranText.setText(ID_Pembayaran);
                String Pesanan_ID_Pesanan = sql.getString("Pesanan_ID_Pesanan");
                pesananText.setText(Pesanan_ID_Pesanan);
                String Waktu_Pembayaran = sql.getString("Waktu_Pembayaran");
                waktuText.setText(Waktu_Pembayaran);
                String Jenis_Pembayaran = sql.getString("Jenis_Pembayaran");
                jenisCombo.setSelectedItem(Jenis_Pembayaran);
                String Total_Pembayaran = sql.getString("Total_Pembayaran");
                totalText.setText(Total_Pembayaran);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_lastButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
        clearFields();
        newData = true;
        editData =  false;
        newButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
    }//GEN-LAST:event_newButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        editData = true;
        newData = false;
        newButton.setEnabled(false);
        editButton.setEnabled(false);
        deleteButton.setEnabled(true);
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
            String query = "delete from Pembayaran where ID_Pembayaran = '"+pembayaranText.getText()+"'";
            state.executeUpdate(query);
            Display();
            state.close();
            con.close();
            clearFields();
            newButton.setEnabled(true);
            editButton.setEnabled(true);
            deleteButton.setEnabled(false);
            saveButton.setEnabled(false);
            cancelButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");
        }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if (newData == true && editData == false) {
            try {
            Connection();
            state = con.createStatement();
            String query = "insert into Pembayaran values('"+pembayaranText.getText()+"', '"+pesananText.getText()+"','"+waktuText.getText()+"','"+jenisCombo.getSelectedItem()+"','"+totalText.getText()+"')";
            state.executeUpdate(query);
            Display();
            state.close();
            con.close();
            clearFields();
            newButton.setEnabled(true);
            editButton.setEnabled(true);
            deleteButton.setEnabled(false);
            saveButton.setEnabled(false);
            cancelButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            }
            catch(Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        else if (editData == true && newData == false) {
            try {
            Connection();
            state = con.createStatement();
            String query = "update Pembayaran set ID_Pembayaran = '"+pembayaranText.getText()+"', Pesanan_ID_Pesanan = '"+pesananText.getText()+"', Waktu_Pembayaran = '"+waktuText.getText()+"', Jenis_Pembayaran = '"+jenisCombo.getSelectedItem()+"', Total_Pembayaran = '"+totalText.getText()+"' where ID_Pembayaran = '"+pembayaranText.getText()+"'";
            state.executeUpdate(query);
            Display();
            state.close();
            con.close();
            clearFields();
            newButton.setEnabled(true);
            editButton.setEnabled(true);
            deleteButton.setEnabled(false);
            saveButton.setEnabled(false);
            cancelButton.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Berhasil diedit");
            }
            catch(Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        newButton.setEnabled(true);
        editButton.setEnabled(true);
        deleteButton.setEnabled(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        clearFields();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void pembayaranTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembayaranTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pembayaranTextActionPerformed

    private void pesananTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesananTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesananTextActionPerformed

    private void waktuTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waktuTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waktuTextActionPerformed

    private void totalTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTextActionPerformed

    private void tabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataMouseClicked
        // TODO add your handling code here:
        try {
            Connection();
            int row = tabelData.getSelectedRow();
            String klik = (tabelData.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from Pembayaran where ID_Pembayaran='"+klik+"'");
            if(sql.next()){
                String ID_Pembayaran = sql.getString("ID_Pembayaran");
                pembayaranText.setText(ID_Pembayaran);
                String Pesanan_ID_Pesanan = sql.getString("Pesanan_ID_Pesanan");
                pesananText.setText(Pesanan_ID_Pesanan);
                String Waktu_Pembayaran = sql.getString("Waktu_Pembayaran");
                waktuText.setText(Waktu_Pembayaran);
                String Jenis_Pembayaran = sql.getString("Jenis_Pembayaran");
                jenisCombo.setSelectedItem(Jenis_Pembayaran);
                String Total_Pembayaran = sql.getString("Total_Pembayaran");
                totalText.setText(Total_Pembayaran);
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_tabelDataMouseClicked

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
            String query = "select * from Pembayaran where ID_Pembayaran like '%"+searchText.getText()+"%' or Pesanan_ID_Pesanan like '%"+searchText.getText()+"%' or Waktu_Pembayaran like '%"+searchText.getText()+"%' or Jenis_Pembayaran like '%"+searchText.getText()+"%' or Total_Pembayaran like '%"+searchText.getText()+"%'";
            rs = state.executeQuery(query);
            tabelData.setModel(DbUtils.resultSetToTableModel(rs));  
        }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_searchTextKeyReleased

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection();
            state = con.createStatement();
            String query = "select * from Pembayaran where ID_Pembayaran like '%"+searchText.getText()+"%' or Pesanan_ID_Pesanan like '%"+searchText.getText()+"%' or Waktu_Pembayaran like '%"+searchText.getText()+"%' or Jenis_Pembayaran like '%"+searchText.getText()+"%' or Total_Pembayaran like '%"+searchText.getText()+"%'";
            rs = state.executeQuery(query);
            tabelData.setModel(DbUtils.resultSetToTableModel(rs));  
        }
        catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DataPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisCombo;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField pembayaranText;
    private javax.swing.JTextField pesananText;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JTable tabelData;
    private javax.swing.JTextField totalText;
    private javax.swing.JTextField waktuText;
    // End of variables declaration//GEN-END:variables
}

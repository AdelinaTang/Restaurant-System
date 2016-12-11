//Author : Chow Hui Pin

package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import control.*;
import domain.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RenewCustomerFrame extends javax.swing.JFrame {

    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private ArrayList<String> customer = null;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = new Date();
    String customerID = "";
    
    public RenewCustomerFrame() {
        initComponents();
        setTitle("Renew Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        customerID = generateCustomerID();

        String dateJoined = dateFormat.format(dateObj);
        String firstFourDigit = dateJoined.substring(0, 4);
        int year = Integer.parseInt(firstFourDigit) + 2;
        String yearString = String.valueOf(year);
        String monthString = dateJoined.substring(5, 7);
        String dayString = dateJoined.substring(8);
        String expiryDate = yearString + "-" + monthString + "-" + dayString;
        jtfDateJoined.setEditable(false);
        jtfDateJoined.setText(dateJoined);
        jtfExpiryDate.setEditable(false);
        jtfExpiryDate.setText(expiryDate);

        customer = maintainCustomerControl.retrieveCustomerRecordICControl();
        for (int i = 0; i < customer.size(); i++) {
            model.addElement(customer.get(i));

        }

        jcbICNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String icNo = (String) jcbICNo.getSelectedItem();
                Customer customer = maintainCustomerControl.retrieveCustomerRecordICControl(icNo);
                jtfFirstName.setText(customer.getFirstName());
                jtfLastName.setText(customer.getLastName());
                jtfContactNo.setText(customer.getContactNo());
                jtfEmail.setText(customer.getEmail());
                jtaAddress.setText(customer.getAddress());
                jtfLoyaltyPointBalance.setText(String.valueOf(customer.getLoyaltyPointBalance()));
                jtfFirstName.setEditable(false);
                jtfLastName.setEditable(false);
                jtfContactNo.setEditable(false);
                jtfEmail.setEditable(false);
                jtaAddress.setEditable(false);
                jtfLoyaltyPointBalance.setEditable(false);
                jtfStatus.setEditable(false);
                jtfOldID.setEditable(false);
                jtfStatus.setText(customer.getStatus());
                jtfOldID.setText(customer.getOldID());

            }
        });

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int option = JOptionPane.showConfirmDialog(null, "Confirm to renew?", "Renew Membership", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    String icNo = (String) jcbICNo.getSelectedItem();
                    Customer customer = maintainCustomerControl.retrieveCustomerRecordICControl(icNo);
                    Customer renewCustomer = new Customer(customerID, icNo, customer.getFirstName(), customer.getLastName(),
                            customer.getContactNo(), customer.getEmail(), customer.getAddress(), dateJoined, expiryDate,
                            customer.getLoyaltyPointBalance(), "Active", customer.getCustomerID());

                    maintainCustomerControl.updateRenewCustomerRecordControl(icNo);
                    maintainCustomerControl.createCustomerRecordControl(renewCustomer);

                    JOptionPane.showMessageDialog(null, "Membership is successfully renewed");
                    Reset();
                    customerID = generateCustomerID();
                }

            }
        });

        jbtCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

    }

    public void Reset() {
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jtfContactNo.setText("");
        jtfEmail.setText("");
        jtaAddress.setText("");
        jtfLoyaltyPointBalance.setText("");
        jtfStatus.setText("");
        jtfOldID.setText("");

    }

    public String generateCustomerID() {

        String customerID = maintainCustomerControl.getLatestIDControl();
        int lastThreeDigit = Integer.parseInt(customerID.substring(1, 4));
        String incrementedCustomerID = String.format("C%03d", (lastThreeDigit + 1));
        jtfCustomerID.setEditable(false);
        jtfCustomerID.setText(incrementedCustomerID);
        return incrementedCustomerID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbStaffID = new javax.swing.JLabel();
        jlbFirstName = new javax.swing.JLabel();
        jlbLastName = new javax.swing.JLabel();
        jlbContactNo = new javax.swing.JLabel();
        jlbEmail = new javax.swing.JLabel();
        jlbAddress = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfContactNo = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jbtOk = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jlbDateJoined = new javax.swing.JLabel();
        jtfDateJoined = new javax.swing.JTextField();
        jlbExpiryDate = new javax.swing.JLabel();
        jtfExpiryDate = new javax.swing.JTextField();
        jlbLoyaltyPointBalance = new javax.swing.JLabel();
        jtfLoyaltyPointBalance = new javax.swing.JTextField();
        jlbICNo = new javax.swing.JLabel();
        jtfCustomerID = new javax.swing.JTextField();
        jcbICNo = new javax.swing.JComboBox(model);
        jtfStatus = new javax.swing.JTextField();
        jlbStatus = new javax.swing.JLabel();
        jtfOldID = new javax.swing.JTextField();
        jlbOldID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Renew Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbStaffID.setText("Customer ID");

        jlbFirstName.setText("First Name");

        jlbLastName.setText("Last Name");

        jlbContactNo.setText("Contact No");

        jlbEmail.setText("Email");

        jlbAddress.setText("Address");

        jtaAddress.setColumns(20);
        jtaAddress.setLineWrap(true);
        jtaAddress.setRows(5);
        jtaAddress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaAddress);

        jbtOk.setText("Ok");

        jbtCancel.setText("Cancel");

        jlbDateJoined.setText("Date Joined");

        jlbExpiryDate.setText("Expiry Date");

        jlbLoyaltyPointBalance.setText("Loyalty Point Balance");

        jlbICNo.setText("IC No");

        jtfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCustomerIDActionPerformed(evt);
            }
        });

        jlbStatus.setText("Status");

        jlbOldID.setText("Old ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbICNo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfExpiryDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfDateJoined, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(jtfContactNo)
                                    .addComponent(jtfLastName)
                                    .addComponent(jtfFirstName)
                                    .addComponent(jcbICNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(jlbStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbOldID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfOldID, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtOk)
                                        .addGap(38, 38, 38)
                                        .addComponent(jbtCancel))
                                    .addComponent(jtfLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45))
                                    .addComponent(jlbAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addComponent(jlbExpiryDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addComponent(jtfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbICNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbICNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfOldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbOldID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk)
                    .addComponent(jbtCancel))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCustomerIDActionPerformed

    }//GEN-LAST:event_jtfCustomerIDActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(RenewCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RenewCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RenewCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RenewCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RenewCustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtOk;
    private javax.swing.JComboBox jcbICNo;
    private javax.swing.JLabel jlbAddress;
    private javax.swing.JLabel jlbContactNo;
    private javax.swing.JLabel jlbDateJoined;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbExpiryDate;
    private javax.swing.JLabel jlbFirstName;
    private javax.swing.JLabel jlbICNo;
    private javax.swing.JLabel jlbLastName;
    private javax.swing.JLabel jlbLoyaltyPointBalance;
    private javax.swing.JLabel jlbOldID;
    private javax.swing.JLabel jlbStaffID;
    private javax.swing.JLabel jlbStatus;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfCustomerID;
    private javax.swing.JTextField jtfDateJoined;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfExpiryDate;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfLoyaltyPointBalance;
    private javax.swing.JTextField jtfOldID;
    private javax.swing.JTextField jtfStatus;
    // End of variables declaration//GEN-END:variables
}

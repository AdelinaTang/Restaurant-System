package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class PaymentClick extends javax.swing.JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private ArrayList<Payment> readPayment = maintainTransactionControl.retrieveTransactionRecordControl();

    public PaymentClick() {
    }

    public PaymentClick(Payment payment) {

        initComponents();
        setTitle("Payment");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        String customerID;
        jtfTransactionID.setText(payment.getTransactionID());
        try {
            customerID = payment.getCustomer().getCustomerID();
        } catch (NullPointerException ex) {
            customerID = "Not Member";
        }
        jtfCustomerID.setText(customerID);
        jtfStaffID.setText(payment.getStaff().getStaffID());
        jtfOrderID.setText(payment.getOrders().getOrderID());
        jtfPaymentMethod.setText(payment.getPaymentMethod());
        jtfDiscount.setText(String.valueOf(payment.getDiscount()));
        jtfTotalPriceBD.setText(String.format("RM %.2f", payment.getTotalPriceBD()));
        jtfTax.setText(String.valueOf(payment.getTax()));
        jtfTotalPriceAD.setText(String.format("RM %.2f", payment.getTotalPriceAD()));
        jtfGrandTotal.setText(String.format("RM %.2f", payment.getGrandTotal()));
        jtfLoyaltyPointUsed.setText(String.valueOf(payment.getLoyaltyPointUsed()));
        jtfLoyaltyPointAmount.setText(String.format("RM %.2f", payment.getLoyaltyPointAmount()));
        jtfLoyaltyPointEarned.setText(String.valueOf(payment.getLoyaltyPointEarned()));

        jtfTransactionID.setEditable(false);
        jtfCustomerID.setEditable(false);
        jtfStaffID.setEditable(false);
        jtfOrderID.setEditable(false);
        jtfPaymentMethod.setEditable(false);
        jtfDiscount.setEditable(false);
        jtfTotalPriceBD.setEditable(false);
        jtfTax.setEditable(false);
        jtfTotalPriceAD.setEditable(false);
        jtfGrandTotal.setEditable(false);
        jtfLoyaltyPointUsed.setEditable(false);
        jtfLoyaltyPointAmount.setEditable(false);
        jtfLoyaltyPointEarned.setEditable(false);

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public PaymentClick(int i) {
        initComponents();

        setTitle("Payment");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        String customerID;
        jtfTransactionID.setText(readPayment.get(i).getTransactionID());
        try {
            customerID = readPayment.get(i).getCustomer().getCustomerID();
        } catch (NullPointerException ex) {
            customerID = "Not Member";
        }
        jtfCustomerID.setText(customerID);
        jtfStaffID.setText(readPayment.get(i).getStaff().getStaffID());
        jtfOrderID.setText(readPayment.get(i).getOrders().getOrderID());
        jtfPaymentMethod.setText(readPayment.get(i).getPaymentMethod());
        jtfDiscount.setText(String.valueOf(readPayment.get(i).getDiscount()));
        jtfTotalPriceBD.setText(String.format("RM %.2f", readPayment.get(i).getTotalPriceBD()));
        jtfTax.setText(String.valueOf(readPayment.get(i).getTax()));
        jtfTotalPriceAD.setText(String.format("RM %.2f", readPayment.get(i).getTotalPriceAD()));
        jtfGrandTotal.setText(String.format("RM %.2f", readPayment.get(i).getGrandTotal()));
        jtfLoyaltyPointUsed.setText(String.valueOf(readPayment.get(i).getLoyaltyPointUsed()));
        jtfLoyaltyPointAmount.setText(String.format("RM %.2f", readPayment.get(i).getLoyaltyPointAmount()));
        jtfLoyaltyPointEarned.setText(String.valueOf(readPayment.get(i).getLoyaltyPointEarned()));

        jtfTransactionID.setEditable(false);
        jtfCustomerID.setEditable(false);
        jtfStaffID.setEditable(false);
        jtfOrderID.setEditable(false);
        jtfPaymentMethod.setEditable(false);
        jtfDiscount.setEditable(false);
        jtfTotalPriceBD.setEditable(false);
        jtfTax.setEditable(false);
        jtfTotalPriceAD.setEditable(false);
        jtfGrandTotal.setEditable(false);
        jtfLoyaltyPointUsed.setEditable(false);
        jtfLoyaltyPointAmount.setEditable(false);
        jtfLoyaltyPointEarned.setEditable(false);

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
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
        jtfTransactionID = new javax.swing.JTextField();
        jtfStaffID = new javax.swing.JTextField();
        jtfOrderID = new javax.swing.JTextField();
        jtfPaymentMethod = new javax.swing.JTextField();
        jtfDiscount = new javax.swing.JTextField();
        jbtOk = new javax.swing.JButton();
        jlbDateJoined = new javax.swing.JLabel();
        jtfTax = new javax.swing.JTextField();
        jlbLoyaltyPointUsed = new javax.swing.JLabel();
        jtfLoyaltyPointUsed = new javax.swing.JTextField();
        jtfCustomerID = new javax.swing.JTextField();
        jlbStaffID1 = new javax.swing.JLabel();
        jtfGrandTotal = new javax.swing.JTextField();
        jtfLoyaltyPointAmount = new javax.swing.JTextField();
        jlbExpiryDate1 = new javax.swing.JLabel();
        jlbOldID = new javax.swing.JLabel();
        jtfTotalPriceBD = new javax.swing.JTextField();
        jtfTotalPriceAD = new javax.swing.JTextField();
        jlbAddress1 = new javax.swing.JLabel();
        jlbOldID1 = new javax.swing.JLabel();
        jtfLoyaltyPointEarned = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbStaffID.setText("Transaction ID");

        jlbFirstName.setText("Staff ID");

        jlbLastName.setText("Order ID");

        jlbContactNo.setText("Payment Method");

        jlbEmail.setText("Discount");

        jlbAddress.setText("Total Price Before Deduction");

        jbtOk.setText("Ok");

        jlbDateJoined.setText("Tax");

        jlbLoyaltyPointUsed.setText("Loyalty Point Used");

        jlbStaffID1.setText("Customer ID");

        jlbExpiryDate1.setText("Grand Total");

        jlbOldID.setText("Loyalty Point Amount");

        jlbAddress1.setText("Total Price After Deduction");

        jlbOldID1.setText("Loyalty Point Earned");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jlbStaffID1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbOldID, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbExpiryDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbOldID1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfGrandTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(jtfTax, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTransactionID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfStaffID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfOrderID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPaymentMethod, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDiscount, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCustomerID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLoyaltyPointUsed)
                            .addComponent(jtfLoyaltyPointAmount, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTotalPriceBD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTotalPriceAD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLoyaltyPointEarned, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jlbLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtOk)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbStaffID1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTotalPriceBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTotalPriceAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbExpiryDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbOldID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLoyaltyPointAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfLoyaltyPointEarned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlbOldID1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jbtOk)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PaymentClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentClick().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlbAddress;
    private javax.swing.JLabel jlbAddress1;
    private javax.swing.JLabel jlbContactNo;
    private javax.swing.JLabel jlbDateJoined;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbExpiryDate1;
    private javax.swing.JLabel jlbFirstName;
    private javax.swing.JLabel jlbLastName;
    private javax.swing.JLabel jlbLoyaltyPointUsed;
    private javax.swing.JLabel jlbOldID;
    private javax.swing.JLabel jlbOldID1;
    private javax.swing.JLabel jlbStaffID;
    private javax.swing.JLabel jlbStaffID1;
    private javax.swing.JTextField jtfCustomerID;
    private javax.swing.JTextField jtfDiscount;
    private javax.swing.JTextField jtfGrandTotal;
    private javax.swing.JTextField jtfLoyaltyPointAmount;
    private javax.swing.JTextField jtfLoyaltyPointEarned;
    private javax.swing.JTextField jtfLoyaltyPointUsed;
    private javax.swing.JTextField jtfOrderID;
    private javax.swing.JTextField jtfPaymentMethod;
    private javax.swing.JTextField jtfStaffID;
    private javax.swing.JTextField jtfTax;
    private javax.swing.JTextField jtfTotalPriceAD;
    private javax.swing.JTextField jtfTotalPriceBD;
    private javax.swing.JTextField jtfTransactionID;
    // End of variables declaration//GEN-END:variables
}

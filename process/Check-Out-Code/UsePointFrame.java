package ui;

import control.*;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class UsePointFrame extends javax.swing.JFrame {

    private Customer cust;
    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private Payment payment = null;
    private final double POINT = 0.1;
    private final double DISCOUNT = 0.1;
    private final double GST = 0.06;
    String paymentMethod = "";
    double totalAmountTemp = 0;

    public UsePointFrame(String transactionID, Customer customer, Staff staff, double totalAmount, double temp, String orderID,
            int seatNumber, ArrayList<Food> foodRecord) {
        initComponents();

        totalAmountTemp = temp;
        cust = customer;
        jtfLoyaltyPointAmount.setEditable(false);
        jtfGrandTotal.setEditable(false);
        jtfLoyaltyPointEarned.setEditable(false);
        jtfNewLoyaltyPointBalance.setEditable(false);
        jtfInitialPointBalance.setText(String.valueOf(cust.getLoyaltyPointBalance()));
        jtfInitialPointBalance.setEditable(false);
        jbtGenerateReceipt.setEnabled(false);

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pointUsed = jtfLoyaltyPointUsed.getText();
                display(pointUsed, cust.getLoyaltyPointBalance());

            }
        });

        jtfLoyaltyPointUsed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pointUsed = jtfLoyaltyPointUsed.getText();
                display(pointUsed, cust.getLoyaltyPointBalance());

            }
        });

        ButtonGroup bgPaymentMethod = new ButtonGroup();
        bgPaymentMethod.add(jrbCash);
        bgPaymentMethod.add(jrbCreditCard);

        jrbCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "Cash";
                jbtGenerateReceipt.setEnabled(true);
            }
        });

        jrbCreditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "CreditCard";
                jbtGenerateReceipt.setEnabled(true);
            }
        });

        jbtGenerateReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String pointUsed2 = jtfLoyaltyPointUsed.getText();
                int initialLoyaltyPointBalance2 = cust.getLoyaltyPointBalance();
                int loyaltyPointUsed2 = Integer.parseInt(pointUsed2);
                double loyaltyPointAmount2 = loyaltyPointUsed2 * POINT;
                double grandTotal2 = totalAmountTemp - loyaltyPointAmount2;
                int loyaltyPointBalance2 = initialLoyaltyPointBalance2 - loyaltyPointUsed2;
                double loyaltyPointEarned2 = grandTotal2 / 0.1;
                int newLoyaltyPointBalance2 = loyaltyPointBalance2 + (int) loyaltyPointEarned2;

                int option = JOptionPane.showConfirmDialog(null, "Confirm to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Orders orders = maintainOrdersControl.retrieveOrdersRecordControl(orderID);
                    payment = new Payment(transactionID, customer, staff, orders, paymentMethod, DISCOUNT, totalAmount, GST, temp,
                            grandTotal2, loyaltyPointUsed2, loyaltyPointAmount2, (int) loyaltyPointEarned2);
                    maintainTransactionControl.createTransactionRecordControl(payment);
                    maintainCustomerControl.updateCustomerRecordControl(customer.getCustomerID(), newLoyaltyPointBalance2);
                    maintainSeatControl.updateSeatAvailabilityControl(seatNumber);
                    dispose();
                    if (paymentMethod.equals("Cash")) {
                        new CashFrame(grandTotal2, foodRecord, transactionID);
                    } else {
                        new CreditCardFrame(grandTotal2, foodRecord, transactionID);
                    }
                }

            }
        });

        setTitle("Use Point");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    public void display(String pointUsed, int pointBalance) {
        boolean valid = validateInput(pointUsed, pointBalance);

        if (valid) {

            int initialLoyaltyPointBalance = cust.getLoyaltyPointBalance();
            int loyaltyPointUsed = Integer.parseInt(pointUsed);
            double loyaltyPointAmount = loyaltyPointUsed * POINT;
            double grandTotal = totalAmountTemp - loyaltyPointAmount;
            int loyaltyPointBalance = initialLoyaltyPointBalance - loyaltyPointUsed;
            double loyaltyPointEarned = grandTotal / 0.1;
            int newLoyaltyPointBalance = loyaltyPointBalance + (int) loyaltyPointEarned;

            jtfLoyaltyPointAmount.setText(String.format("RM %.2f", loyaltyPointAmount));
            jtfGrandTotal.setText(String.format("RM %.2f", grandTotal));
            jtfLoyaltyPointEarned.setText(String.valueOf((int) loyaltyPointEarned));
            jtfNewLoyaltyPointBalance.setText(String.valueOf(newLoyaltyPointBalance));

        }
    }

    public boolean validateInput(String pointUsed, int pointBalance) {
        if (pointUsed.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfLoyaltyPointUsed.requestFocusInWindow();
            return false;
        }
        for (int i = 0; i < pointUsed.length(); i++) {
            if (!Character.isDigit(pointUsed.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfLoyaltyPointUsed.setText("");
                jtfLoyaltyPointUsed.requestFocusInWindow();
                return false;
            }
        }
        if (Integer.parseInt(pointUsed) > pointBalance) {
            JOptionPane.showMessageDialog(null, "Invalid.Not enough points!");
            jtfLoyaltyPointUsed.setText("");
            jtfLoyaltyPointUsed.requestFocusInWindow();
            return false;

        }
        return true;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbLoyaltyPointUsed = new javax.swing.JLabel();
        jlbGrandTotal = new javax.swing.JLabel();
        jtfLoyaltyPointUsed = new javax.swing.JTextField();
        jbtGenerateReceipt = new javax.swing.JButton();
        jlbLoyaltyPointEarned = new javax.swing.JLabel();
        jtfGrandTotal = new javax.swing.JTextField();
        jlbSeatAvailability = new javax.swing.JLabel();
        jtfLoyaltyPointEarned = new javax.swing.JTextField();
        jtfLoyaltyPointAmount = new javax.swing.JTextField();
        jlbLoyaltyPointEarned1 = new javax.swing.JLabel();
        jrbCash = new javax.swing.JRadioButton();
        jrbCreditCard = new javax.swing.JRadioButton();
        jbtOk = new javax.swing.JButton();
        jlbInitialPointBalance = new javax.swing.JLabel();
        jtfInitialPointBalance = new javax.swing.JTextField();
        jlbInitialPointBalance1 = new javax.swing.JLabel();
        jtfNewLoyaltyPointBalance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Use Point", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbLoyaltyPointUsed.setText("Loyalty Point To Be Used");

        jlbGrandTotal.setText("Grand Total To Be Paid");

        jbtGenerateReceipt.setText("Generate Receipt");

        jlbLoyaltyPointEarned.setText("Loyalty Point Earned");

        jlbSeatAvailability.setText("Loyalty Point Amount");

        jlbLoyaltyPointEarned1.setText("Payment Method");

        jrbCash.setText("Cash");

        jrbCreditCard.setText("Credit Card");

        jbtOk.setText("Ok");

        jlbInitialPointBalance.setText("Current Loyalty Point Balance");

        jlbInitialPointBalance1.setText("New Loyalty Point Balance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlbLoyaltyPointEarned1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbSeatAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbLoyaltyPointUsed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbGrandTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbLoyaltyPointEarned, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbInitialPointBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jlbInitialPointBalance1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfLoyaltyPointEarned, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jtfLoyaltyPointAmount, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLoyaltyPointUsed, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfGrandTotal)
                            .addComponent(jtfInitialPointBalance, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNewLoyaltyPointBalance))
                        .addGap(18, 18, 18)
                        .addComponent(jbtOk)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtGenerateReceipt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbCash)
                                .addGap(26, 26, 26)
                                .addComponent(jrbCreditCard)))
                        .addGap(110, 110, 110))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInitialPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfInitialPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSeatAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLoyaltyPointAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoyaltyPointEarned, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLoyaltyPointEarned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInitialPointBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNewLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoyaltyPointEarned1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbCash)
                    .addComponent(jrbCreditCard))
                .addGap(18, 18, 18)
                .addComponent(jbtGenerateReceipt)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(UsePointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsePointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsePointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsePointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtGenerateReceipt;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlbGrandTotal;
    private javax.swing.JLabel jlbInitialPointBalance;
    private javax.swing.JLabel jlbInitialPointBalance1;
    private javax.swing.JLabel jlbLoyaltyPointEarned;
    private javax.swing.JLabel jlbLoyaltyPointEarned1;
    private javax.swing.JLabel jlbLoyaltyPointUsed;
    private javax.swing.JLabel jlbSeatAvailability;
    private javax.swing.JRadioButton jrbCash;
    private javax.swing.JRadioButton jrbCreditCard;
    private javax.swing.JTextField jtfGrandTotal;
    private javax.swing.JTextField jtfInitialPointBalance;
    private javax.swing.JTextField jtfLoyaltyPointAmount;
    private javax.swing.JTextField jtfLoyaltyPointEarned;
    private javax.swing.JTextField jtfLoyaltyPointUsed;
    private javax.swing.JTextField jtfNewLoyaltyPointBalance;
    // End of variables declaration//GEN-END:variables
}

//Author : Choo Yee Ling

package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import control.*;
import domain.*;
import java.util.ArrayList;

public class UpdateSeatFrame extends javax.swing.JFrame {

    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private ArrayList<Seat> seat = null;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();

    public UpdateSeatFrame() {
        initComponents();
        setTitle("Update Seat");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        seat = maintainSeatControl.retrieveSeatRecordControl();
        for (int i = 0; i < seat.size(); i++) {
            model.addElement(seat.get(i).getSeatNo());
        }

        jcbSeatNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seatNo = (int) jcbSeatNo.getSelectedItem();
                Seat seat = maintainSeatControl.retrieveSeatRecordControl(seatNo);
                jcbSeatSize.setSelectedItem(seat.getSeatSize());
                jtfNumberOfChairs.setText(String.valueOf(seat.getNumberOfChairs()));

            }
        });

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seatNo = (int) jcbSeatNo.getSelectedItem();
                String seatSize = (String) jcbSeatSize.getSelectedItem();
                String noOfChairs = jtfNumberOfChairs.getText();
                boolean valid = validateInput(noOfChairs);
                //when customer make order, the status of the seat should be "Not available" at the moment
                //link to payment(after customer check out, the status of the seat should be changed back to "Available" in the database

                if (valid) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to update?", "Update Seat", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        Seat seat = new Seat(seatNo, "Available", seatSize, Integer.parseInt(noOfChairs));
                        maintainSeatControl.updateSeatRecordControl(seat);
                        JOptionPane.showMessageDialog(null, "Record successfully updated");
                        jtfNumberOfChairs.setText("");
                    }
                }

            }
        });

        jbtCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public boolean validateInput(String noOfChairs) {
        if (noOfChairs.equals("")) {
            JOptionPane.showMessageDialog(null, "Field cannot be left empty");
            jtfNumberOfChairs.requestFocusInWindow();
            return false;
        }
        for (int i = 0; i < noOfChairs.length(); i++) {
            if (!Character.isDigit(noOfChairs.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Number of chairs must consist of digits only");
                jtfNumberOfChairs.setText("");
                jtfNumberOfChairs.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbSeatNo = new javax.swing.JLabel();
        jlbSeatSize = new javax.swing.JLabel();
        jbtOk = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jcbSeatSize = new javax.swing.JComboBox();
        jlbNumberOfSeats = new javax.swing.JLabel();
        jtfNumberOfChairs = new javax.swing.JTextField();
        jcbSeatNo = new javax.swing.JComboBox(model);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Seat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbSeatNo.setText("Seat No");

        jlbSeatSize.setText("Seat Size");

        jbtOk.setText("Ok");

        jbtCancel.setText("Cancel");
        jbtCancel.setActionCommand("");

        jcbSeatSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Small", "Medium", "Large", " " }));

        jlbNumberOfSeats.setText("Number of Chairs");

        jtfNumberOfChairs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumberOfChairsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSeatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbSeatSize, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbSeatSize, 0, 266, Short.MAX_VALUE)
                            .addComponent(jcbSeatNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbNumberOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtOk)
                                .addGap(18, 18, 18)
                                .addComponent(jbtCancel))
                            .addComponent(jtfNumberOfChairs, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSeatNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeatNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSeatSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSeatSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNumberOfChairs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNumberOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk)
                    .addComponent(jbtCancel))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNumberOfChairsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumberOfChairsActionPerformed

    }//GEN-LAST:event_jtfNumberOfChairsActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateSeatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSeatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSeatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSeatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSeatFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtOk;
    private javax.swing.JComboBox jcbSeatNo;
    private javax.swing.JComboBox jcbSeatSize;
    private javax.swing.JLabel jlbNumberOfSeats;
    private javax.swing.JLabel jlbSeatNo;
    private javax.swing.JLabel jlbSeatSize;
    private javax.swing.JTextField jtfNumberOfChairs;
    // End of variables declaration//GEN-END:variables
}

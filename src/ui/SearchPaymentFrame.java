//Author : Adelina Tang Chooi Li
package ui;

import java.awt.event.MouseAdapter;
import control.MaintainCustomerControl;
import control.MaintainMenusControl;
import control.MaintainTransactionControl;
import domain.Customer;
import domain.Menus;
import domain.Orders;
import domain.Payment;
import domain.Seat;
import domain.Staff;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchPaymentFrame extends javax.swing.JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    ArrayList<Payment> payment = null;
    private ArrayList<Payment> payment2 = null;
    private String[] columnNames = {"TransactionID", "CustomerID", "StaffID", "OrderID", "PaymentMethod", "Discount",
        "TotalPriceBeforeDeduction", "Tax", "TotalPriceAfterDeduction", "GrandTotal", "LoyaltyPointUsed", "LoyaltyPointAmount",
        "LoyaltyPointEarned"};
    private Object[][] data = {};
    DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public SearchPaymentFrame() {
        initComponents();

        jTextField1.addActionListener((ActionEvent e) -> {
            action();
        });

        jButton1.addActionListener((ActionEvent e) -> {
            action();
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void action() {
        detailsTableModel.setRowCount(0);

        payment = maintainTransactionControl.retrieveTransactionRecordControl();
        if (!jTextField1.getText().equals("")) {
            for (int i = 0; i < payment.size(); i++) {
                System.out.println(payment.size());
                if (payment.get(i).toString().toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                    System.out.println(payment.get(i));

                    String memberStatus = "";
                    try {
                        memberStatus = payment.get(i).getCustomer().getCustomerID();
                    } catch (NullPointerException ex) {
                        memberStatus = "Not Member";
                    } finally {

                        detailsTableModel.addRow(new Object[]{payment.get(i).getTransactionID(), memberStatus,
                            payment.get(i).getStaff().getStaffID(), payment.get(i).getOrders().getOrderID(), payment.get(i).getPaymentMethod(),
                            payment.get(i).getDiscount(), payment.get(i).getTotalPriceBD(), payment.get(i).getTax(),
                            payment.get(i).getTotalPriceAD(), payment.get(i).getGrandTotal(), payment.get(i).getLoyaltyPointUsed(),
                            payment.get(i).getLoyaltyPointAmount(), payment.get(i).getLoyaltyPointEarned()}
                        );
                    }
                }
            }

        } else;
        new DisplaySearch();
        payment.clear();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search");

        jLabel1.setText("Search");

        jButton1.setText("Find");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jButton1))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(jLabel1)))
                        .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(43, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchPaymentFrame().setVisible(true);
            }
        });
    }

    class DisplaySearch extends JFrame {

        public DisplaySearch() {
            JTable jtbMenu = new JTable();

            jtbMenu.setModel(detailsTableModel);
            jtbMenu.setPreferredScrollableViewportSize(new Dimension(450, 63));
            jtbMenu.setFillsViewportHeight(true);
            JScrollPane jsp = new JScrollPane(jtbMenu);
            add(jsp);

            TableRowSorter<TableModel> sorter
                    = new TableRowSorter<TableModel>(detailsTableModel);

            jtbMenu.setRowSorter(sorter);

            jtbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Payment payment = null;

                    int row = jtbMenu.rowAtPoint(evt.getPoint());

                    int rowCount = detailsTableModel.getRowCount();
                    for (int i = 0; i < rowCount; i++) {

                        if (row == i) {
                            payment2 = maintainTransactionControl.retrieveTransactionRecordControl();
                            Customer cust;
                            try {
                                cust = new Customer(detailsTableModel.getValueAt(i, 1).toString(),
                                        payment2.get(i).getCustomer().getICNo(), payment2.get(i).getCustomer().getFirstName(),
                                        payment2.get(i).getCustomer().getLastName(), payment2.get(i).getCustomer().getContactNo(),
                                        payment2.get(i).getCustomer().getEmail(), payment2.get(i).getCustomer().getAddress(),
                                        payment2.get(i).getCustomer().getDateJoined(), payment2.get(i).getCustomer().getExpiryDate(),
                                        payment2.get(i).getCustomer().getLoyaltyPointBalance(), payment2.get(i).getCustomer().getStatus(),
                                        payment2.get(i).getCustomer().getOldID());
                            } catch (NullPointerException ex) {
                                cust = null;
                            }

                            Staff stf = new Staff(detailsTableModel.getValueAt(i, 2).toString(), payment2.get(i).getStaff().getFirstName(),
                                    payment2.get(i).getStaff().getLastName(), payment2.get(i).getStaff().getContactNo(), payment2.get(i).getStaff().getEmail(),
                                    payment2.get(i).getStaff().getAddress(), payment2.get(i).getStaff().getStatus(), payment2.get(i).getStaff().getPassword());

                            Seat seat = new Seat(payment2.get(i).getOrders().getSeat().getSeatNo(),
                                    payment2.get(i).getOrders().getSeat().getSeatAvailability(), payment2.get(i).getOrders().getSeat().getSeatSize(),
                                    payment2.get(i).getOrders().getSeat().getNumberOfChairs());

                            Orders ord = new Orders(detailsTableModel.getValueAt(i, 3).toString(), seat, payment2.get(i).getOrders().getDateOrder());

                            payment = new Payment(detailsTableModel.getValueAt(i, 0).toString(),
                                    cust, stf, ord,
                                    detailsTableModel.getValueAt(i, 4).toString(),
                                    Double.parseDouble(detailsTableModel.getValueAt(i, 5).toString()),
                                    Double.parseDouble(detailsTableModel.getValueAt(i, 6).toString()),
                                    Double.parseDouble(detailsTableModel.getValueAt(i, 7).toString()),
                                    Double.parseDouble(detailsTableModel.getValueAt(i, 8).toString()),
                                    Double.parseDouble(detailsTableModel.getValueAt(i, 9).toString()),
                                    Integer.parseInt(detailsTableModel.getValueAt(i, 10).toString()),
                                    Double.parseDouble(detailsTableModel.getValueAt(i, 11).toString()),
                                    Integer.parseInt(detailsTableModel.getValueAt(i, 12).toString()));
                            new PaymentClick(payment);
                        }

                    }

                }
            });

            setTitle("Search Payment");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            setSize(600, 300);

        }

    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;

}

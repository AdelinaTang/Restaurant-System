//Author : Adelina Tang Chooi Li

package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class ReadPaymentFrame extends JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private ArrayList<Payment> readPayment = maintainTransactionControl.retrieveTransactionRecordControl();

    public ReadPaymentFrame() {

        JTable jtbPayment = new JTable();
        String[] columnNames = {"TransactionID", "CustomerID", "StaffID", "OrderID", "PaymentMethod", "Discount",
            "TotalPriceBeforeDeduction", "Tax", "TotalPriceAfterDeduction", "GrandTotal", "LoyaltyPointUsed", "LoyaltyPointAmount",
            "LoyaltyPointEarned"};

        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);

        jtbPayment.setRowSorter(sorter);

        for (int i = 0; i < readPayment.size(); i++) {
            String memberStatus = "";
            try {
                memberStatus = readPayment.get(i).getCustomer().getCustomerID();
            } catch (NullPointerException ex) {
                memberStatus = "Not Member";
            } finally {
                detailsTableModel.addRow(new Object[]{readPayment.get(i).getTransactionID(), memberStatus,
                    readPayment.get(i).getStaff().getStaffID(), readPayment.get(i).getOrders().getOrderID(), readPayment.get(i).getPaymentMethod(),
                    readPayment.get(i).getDiscount(), readPayment.get(i).getTotalPriceBD(), readPayment.get(i).getTax(),
                    readPayment.get(i).getTotalPriceAD(), readPayment.get(i).getGrandTotal(), readPayment.get(i).getLoyaltyPointUsed(),
                    readPayment.get(i).getLoyaltyPointAmount(), readPayment.get(i).getLoyaltyPointEarned()});
            }
        }
//iw ant to die now.. ? why
        jtbPayment.setModel(detailsTableModel);
        jtbPayment.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbPayment.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbPayment);
        add(jsp);

        jtbPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int row = jtbPayment.rowAtPoint(evt.getPoint());
                for (int i = 0; i < readPayment.size(); i++) {
                    if (row == i) {
                        new PaymentClick(i);
                    }
                }
            }
        });

        setTitle("Read Payment");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 300);
    }

    public static void main(String[] args) {
        new ReadPaymentFrame();
    }

}

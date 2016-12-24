//Author : Chow Hui Pin
package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class ReadStaffFrame extends JFrame {

    private MaintainStaffControl maintainStaffControl = new MaintainStaffControl();
    private ArrayList<Staff> readStaff = maintainStaffControl.retrieveStaffRecordControl();

    public ReadStaffFrame() {
        JTable jtbStaff = new JTable();
        String[] columnNames = {"StaffID", "FirstName", "LastName", "ContactNo", "Email", "Address", "Status", "Password"};
        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);

        jtbStaff.setRowSorter(sorter);

        for (int i = 0; i < readStaff.size(); i++) {
            if (!readStaff.get(i).getStaffID().equals("S000")) {
                detailsTableModel.addRow(new Object[]{readStaff.get(i).getStaffID(), readStaff.get(i).getFirstName(),
                    readStaff.get(i).getLastName(), readStaff.get(i).getContactNo(), readStaff.get(i).getEmail(),
                    readStaff.get(i).getAddress(), readStaff.get(i).getStatus(), readStaff.get(i).getPassword()});
            }

        }

        jtbStaff.setModel(detailsTableModel);
        jtbStaff.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbStaff.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbStaff);
        add(jsp);

        jtbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jtbStaff.rowAtPoint(evt.getPoint());
                for (int i = 0; i < readStaff.size(); i++) {
                    if (row == i) {
                        new StaffClick(i);
                    }
                }
            }
        });

        setTitle("Read Staff");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 300);
    }

    public static void main(String[] args) {
        new ReadStaffFrame();
    }

}

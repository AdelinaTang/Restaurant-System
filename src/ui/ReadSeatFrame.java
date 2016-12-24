//Author : Choo Yee Ling

package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class ReadSeatFrame extends JFrame {

    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private ArrayList<Seat> readSeat = maintainSeatControl.retrieveSeatRecordControl();

    public ReadSeatFrame() {
        JTable jtbSeat = new JTable();
        String[] columnNames = {"SeatNo", "SeatAvailability", "SeatSize", "NumberOfChairs"};
        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);

        jtbSeat.setRowSorter(sorter);

        for (int i = 0; i < readSeat.size(); i++) {
            detailsTableModel.addRow(new Object[]{readSeat.get(i).getSeatNo(), readSeat.get(i).getSeatAvailability(),
                readSeat.get(i).getSeatSize(), readSeat.get(i).getNumberOfChairs()}
            );
        }

        jtbSeat.setModel(detailsTableModel);
        jtbSeat.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbSeat.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbSeat);
        add(jsp);

        jtbSeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jtbSeat.rowAtPoint(evt.getPoint());
                for (int i = 0; i < readSeat.size(); i++) {
                    if (row == i) {
                        new SeatClick(i);
                    }
                }
            }
        });

        setTitle("Read Seat");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 300);
    }

    public static void main(String[] args) {
        new ReadSeatFrame();
    }

}

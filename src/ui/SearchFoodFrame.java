//Author : Choo Yee Ling
package ui;

import control.MaintainMenusControl;
import domain.Food;
import domain.Menus;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchFoodFrame extends javax.swing.JFrame {

    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private String[] columnNames = {"FoodID", "FoodName", "Category", "Description", "PricePerUnit", "Status"};
    private Object[][] data = {};
    DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public SearchFoodFrame() {
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

        ArrayList<Menus> menus = maintainMenusControl.retrieveMenusRecordControl();
        if (!jTextField1.getText().equals("")) {
            for (int i = 0; i < menus.size(); i++) {
                if (menus.get(i).toString().toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                    System.out.println(menus.get(i));
                    detailsTableModel.addRow(new Object[]{menus.get(i).getFoodID(), menus.get(i).getFoodName(),
                        menus.get(i).getCategory(), menus.get(i).getDescription(), menus.get(i).getPricePerUnit(),
                        menus.get(i).getStatus()}
                    );
                }
            }
        } else;
        new DisplaySearch();
        menus.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFoodFrame().setVisible(true);
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
                    Menus menu = null;
                    int row = jtbMenu.rowAtPoint(evt.getPoint());

                    int rowCount = detailsTableModel.getRowCount();
                    for (int i = 0; i < rowCount; i++) {

                        if (row == i) {
                            menu = new Menus(detailsTableModel.getValueAt(i, 0).toString(), detailsTableModel.getValueAt(i, 1).toString(),
                                    detailsTableModel.getValueAt(i, 2).toString(), detailsTableModel.getValueAt(i, 3).toString(), Double.parseDouble(detailsTableModel.getValueAt(i, 4).toString()), detailsTableModel.getValueAt(i, 5).toString());
                            new FoodClick(menu);
                        }

                    }

                }
            });

            setTitle("Search Menu");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            setSize(600, 300);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

package com.viruswar.client;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;
import com.viruswar.logging.LoggingService;
import com.viruswar.server.util.GameFieldService;
import com.viruswar.server.util.MovePermitChecker;
import com.viruswar.webservice.ServerService;
import com.viruswar.webservice.ServerServiceService;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.viruswar.server.Server.CROSS_VIRUS;

public class ClientForm extends javax.swing.JFrame {

    final String MY_NAME = "";

    public static CommandsHandler commandsHandler = null;

    public static String clientGroup = "";

    public static final String url = "http://localhost:8081/viruswar";

    public static ServerService serverService;

    static {
        try {
            serverService = new ServerServiceService(new URL(url)).getServerServicePort();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void formWindowClosing(WindowEvent e) {
        // TODO add your code here
    }

    public ClientForm() throws MalformedURLException {
        MovePermitChecker.isMovePermitForCross = true;
        MovePermitChecker.isMovePermitForRounds = true;
        initComponents();
        jTable1.setShowGrid(true);
        jTable1.setBackground(Color.WHITE);
        jTable1.getGraphics().setColor(Color.red);
        jTable1.getGraphics().fillRect(jTable1.getCellRect(5, 5, true).x,
                                       jTable1.getCellRect(5, 5, true).y,
                                       jTable1.getCellRect(5, 5, true).width,
                                       jTable1.getCellRect(5, 5, true).height);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - unknown
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                formWindowClosing(e);
            }
        });
        var contentPane = getContentPane();

        //======== jScrollPane1 ========
        {

            //---- jTable1 ----
            jTable1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"1", "X", null, null, null, null, null, null, null, null, null},
                    {"2", null, null, null, null, null, null, null, null, null, null},
                    {"3", null, null, null, null, null, null, null, null, null, null},
                    {"4", null, null, null, null, null, null, null, null, null, null},
                    {"5", null, null, null, "", null, null, null, null, null, null},
                    {"6", null, null, null, null, null, null, null, null, null, null},
                    {"7", null, null, null, null, null, null, null, null, null, null},
                    {"8", null, null, null, null, null, null, null, null, null, null},
                    {"9", null, null, null, null, null, null, null, null, null, null},
                    {"10", null, null, null, null, null, null, null, null, null, "O"},
                },
                new String[] {
                    "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "k"
                }
            ));
            jTable1.setColumnSelectionAllowed(true);
            jTable1.setEnabled(false);
            jTable1.setRowHeight(34);
            jTable1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        ClickOnCellMouseClicked(e);
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            jScrollPane1.setViewportView(jTable1);
        }

        //======== jScrollPane2 ========
        {

            //---- jTextArea1 ----
            jTextArea1.setEditable(false);
            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane2.setViewportView(jTextArea1);
        }

        //---- jLabel1 ----
        jLabel1.setText("\u041f\u043e\u0434\u0441\u043a\u0430\u0437\u043a\u0438");

        //---- jLabel2 ----
        jLabel2.setFont(new Font("Terminator Two", Font.PLAIN, 13));
        jLabel2.setText("\u0412\u043e\u0439\u043d\u0430 \u0432\u0438\u0440\u0443\u0441\u043e\u0432");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(362, 362, 362))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(182, 182, 182)
                    .addComponent(jLabel2)
                    .addContainerGap(795, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(19, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents
    
    private void ClickOnCellMouseClicked(java.awt.event.MouseEvent evt) throws MalformedURLException {//GEN-FIRST:event_ClickOnCellMouseClicked
        if (serverService.isMovePermit(clientGroup)) {
                int row, col;
                row = jTable1.rowAtPoint(evt.getPoint()) + 1;
                col = jTable1.columnAtPoint(evt.getPoint());

                String col_string = GameFieldService.colums[col - 1];
                String command = row + ":" + col_string;
                CommandsSender SR = new CommandsSender(jTextArea1);
                commandsHandler.group_name = serverService.findWhoseTurn();
                commandsHandler.handleCommandServer(SR.SendCommand(command));
                System.out.println("Why??? " + serverService.isMovePermit(clientGroup));
            } else {
                LoggingService.logging("Сейчас ход вашего противника!", jTextArea1, MY_NAME);
            }
    }//GEN-LAST:event_ClickOnCellMouseClicked
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
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClientForm().setVisible(true);
                    commandsHandler = new CommandsHandler(jTextArea1, jTable1, CROSS_VIRUS);
                    HandleEnemyMovesThread handleEnemyMovesThread = new HandleEnemyMovesThread();
                    handleEnemyMovesThread.start();
                    clientGroup = serverService.getClientGroup();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane jScrollPane1;
    public static JTable jTable1;
    private JScrollPane jScrollPane2;
    public static JTextArea jTextArea1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
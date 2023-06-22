package com.mycompany.network_hw2;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
Bosses:_Omar (Salous) and (Shkokani)
*/


public class GUI extends javax.swing.JFrame {
private static int pooort,poS2;
static DefaultListModel listModel;
static boolean flagLog=false;
static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        int i=0;
        InetAddress req=null;
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {       
            if (i == 0)
                 req = inetAddress;  
            i++;
        }
       if ( i == 2){
            if(!netint.getName().equals("lo"))
             jComboBox_Avaliable_Interfaces.addItem(netint.getName()+":"+req.toString().substring(1, req.toString().length()));
        }
     }

    public GUI() throws SocketException {
        listModel = new DefaultListModel();
        initComponents();
       addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if(flagLog)
       logout();
       System.exit(0);
    }
});

        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
        jTextField_Remote_IP.setEditable(false);
        jTextField_Remote_Port.setEditable(false);
        jTextPane1.setEditable(false);

        jTextField_Local_IP.setText(jComboBox_Avaliable_Interfaces.getSelectedItem().toString().split(":")[1]);
        jTextField_Local_IP.setEditable(false);
        
        jTextField_Local_Port.setText(Integer.toString(pooort));
        jTextField_Local_Port.setEditable(false);
        System.out.println(jTextField_Local_Port.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Status = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_TCP_IP = new javax.swing.JTextField();
        jTextField_TCP_Port = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Avaliable_Interfaces = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Local_IP = new javax.swing.JTextField();
        jTextField_Local_Port = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Remote_IP = new javax.swing.JTextField();
        jTextField_UserName = new javax.swing.JTextField();
        jTextField_Remote_Port = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_enterText = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>(listModel);
        canvas1 = new java.awt.Canvas();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ClientChat");
        setResizable(false);

        jLabel2.setText("Status:");

        jTextField_Status.setEnabled(false);

        jLabel3.setText("TCP Server IP:");

        jLabel4.setText("TCP Server Port:");

        jLabel5.setText("Avaliable Intefaces");

        jComboBox_Avaliable_Interfaces.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_Avaliable_InterfacesItemStateChanged(evt);
            }
        });

        jLabel6.setText("Local IP:");

        jLabel7.setText("Local Port:");

        jLabel8.setText("Remote IP:");

        jLabel9.setText("Remote Port:");

        jLabel1.setText("User Name:");

        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 0));
        jLabel10.setText("Online Users");

        jTextArea_enterText.setColumns(20);
        jTextArea_enterText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextArea_enterText.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea_enterText.setRows(5);
        jTextArea_enterText.setText("Write Message");
        jTextArea_enterText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea_enterTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea_enterTextFocusLost(evt);
            }
        });
        jTextArea_enterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea_enterTextKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea_enterText);

        jScrollPane4.setViewportView(jTextPane1);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton4.setText("Online");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_Status))
                            .addComponent(jScrollPane4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField_Local_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_Remote_IP)
                                            .addComponent(jTextField_Remote_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_Local_Port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_TCP_IP)
                                    .addComponent(jTextField_TCP_Port, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                            .addComponent(jLabel5)
                            .addComponent(jComboBox_Avaliable_Interfaces, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_TCP_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_TCP_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_Avaliable_Interfaces, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField_Local_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField_Local_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField_Remote_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField_Remote_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263)))
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int []indices=jList1.getSelectedIndices();
        String sentence=jTextArea_enterText.getText();
        
        if(indices.length>1){
            
        for(int i=0;i<indices.length;i++){
            String st=(String)listModel.getElementAt(indices[i]);
            st=st.replaceAll(" ","");
            String []data=st.split("-");
            
            if ( jTextField_Local_Port.getText().trim().equals(data[2])
                && (jTextField_Local_IP.getText().trim().equals(data[1]))){
                 continue;         
            }

          
            
            byte[] sendData = new byte[1024];
            sendData=sentence.getBytes();
            InetAddress address;
            try {
                address = InetAddress.getByName(data[1]);
                 DatagramSocket clientSocket = new DatagramSocket(pooort -1); 
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, Integer.parseInt(data[2])); 
                clientSocket.send(sendPacket); 
                clientSocket.close(); 
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           

          
    }
            
            StyledDocument docPriv = jTextPane1.getStyledDocument();
          Style style1Priv = jTextPane1.addStyle("", null);
          StyleConstants.setForeground(style1Priv, Color.GREEN);
        try {
            docPriv.insertString(docPriv.getLength(), "Me to group: "+sentence+"\n", style1Priv);
        } catch (BadLocationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        else{
              
           poort = Integer.parseInt(jTextField_Remote_Port.getText().trim());
         try {
            byte[] sendData = new byte[1024];
            StyledDocument doc = jTextPane1.getStyledDocument();
                  Style style1 = jTextPane1.addStyle("", null);
                  StyleConstants.setForeground(style1, Color.red);
               try {
                   if ( poort == Integer.parseInt(jTextField_Local_Port.getText().trim()) 
                         && (jTextField_Local_IP.getText().trim().equals( jTextField_Remote_IP.getText().trim() )  )){
                  StyledDocument docPriv = jTextPane1.getStyledDocument();
                  Style style1Priv = jTextPane1.addStyle("", null);
                  StyleConstants.setForeground(style1Priv, Color.GREEN);
                  docPriv.insertString(docPriv.getLength(), "Private: "+sentence+"\n", style1Priv);
              }
                   else
                       doc.insertString(doc.getLength(), "Me: "+sentence+"\n", style1);
               } catch (BadLocationException ex) {
                   Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
               }

            sendData=sentence.getBytes();
            InetAddress address = InetAddress.getByName(jTextField_Remote_IP.getText());
            DatagramSocket clientSocket = new DatagramSocket(pooort -1); 
            
           
             System.out.println("port:" + Integer.parseInt(jTextField_Remote_Port.getText().trim()));
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, Integer.parseInt(jTextField_Remote_Port.getText().trim())); 
            clientSocket.send(sendPacket); 
            clientSocket.close();         
        }
         catch (IOException ex) {
        
        }
         
        }
        
                jTextArea_enterText.setText("Write Message");
                jTextArea_enterText.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox_Avaliable_InterfacesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_Avaliable_InterfacesItemStateChanged
            jTextField_Local_IP.setText(jComboBox_Avaliable_Interfaces.getSelectedItem().toString().split(":")[1]);
            
    }//GEN-LAST:event_jComboBox_Avaliable_InterfacesItemStateChanged

    private void jTextArea_enterTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea_enterTextFocusGained
        // TODO add your handling code here:
        if ( jTextArea_enterText.getText().trim().equals("Write Message") )
        {
            jTextArea_enterText.setText("");
            jTextArea_enterText.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextArea_enterTextFocusGained

    private void jTextArea_enterTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea_enterTextFocusLost
        // TODO add your handling code here:
        if ( jTextArea_enterText.getText().trim().equals("") ||
                jTextArea_enterText.getText().trim().equals("Write Message"))
        {
            jTextArea_enterText.setText("Write Message");
            jTextArea_enterText.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_jTextArea_enterTextFocusLost

    private void jTextArea_enterTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_enterTextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea_enterTextKeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

        if (evt.getClickCount() == 2) {
          String s=jList1.getSelectedValue();
          //name,ip,port
          s=s.replaceAll(" ", "");
          String[] data=s.split("-");
         jTextField_Remote_IP.setText(data[1]);
         jTextField_Remote_Port.setText(data[2]);
         
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(jTextField_UserName.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please enter name first");
        else{
            flagLog=true;
            
            // flag - name - ip - port_udp - port_tcp
            String sentence="1 - "+jTextField_UserName.getText().trim()+" - "+jTextField_Local_IP.getText().trim()+" - "+
                    jTextField_Local_Port.getText().trim()+" - " + Integer.toString(poS2);
        try {
            Socket clientSocket = new Socket(jTextField_TCP_IP.getText().trim(), Integer.parseInt(jTextField_TCP_Port.getText().trim())); 
            DataOutputStream outToServer =new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(sentence); 
            clientSocket.close(); 
        }
         catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Server it is not connected","Problem in connection",JOptionPane.ERROR_MESSAGE);
        }         
     }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        if(flagLog==true)
            logout();
        
        else{
            JOptionPane.showMessageDialog(null,"You not login");
        }
        flagLog=false;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        if(!flagLog){
            JOptionPane.showMessageDialog(null,"You not login");
            return;
        }

        
        String sentence="3 - "+jTextField_UserName.getText().trim()+" - "+jTextField_Local_IP.getText().trim()+" - "+
                    jTextField_Local_Port.getText().trim()+" - " + Integer.toString(poS2);
        try {
            Socket clientSocket = new Socket(jTextField_TCP_IP.getText().trim(), Integer.parseInt(jTextField_TCP_Port.getText().trim())); 
            DataOutputStream outToServer =new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(sentence); 
            clientSocket.close(); 
        }
         catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Server it is not connected","Problem in connection",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Random random = new Random();
        pooort = random.nextInt(65535 - 1025) + 1025;

        while(true){
        poS2 = random.nextInt(65535 - 1025) + 1025;
        if(poS2!=pooort)
            break;
        }
 
        Server server = new Server();
        ServerTCP server2=new ServerTCP();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (SocketException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });            
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private static javax.swing.JComboBox<String> jComboBox_Avaliable_Interfaces;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private static javax.swing.JTextArea jTextArea_enterText;
    private static javax.swing.JTextField jTextField_Local_IP;
    private static javax.swing.JTextField jTextField_Local_Port;
    private static javax.swing.JTextField jTextField_Remote_IP;
    private static javax.swing.JTextField jTextField_Remote_Port;
    private static javax.swing.JTextField jTextField_Status;
    private javax.swing.JTextField jTextField_TCP_IP;
    private javax.swing.JTextField jTextField_TCP_Port;
    private javax.swing.JTextField jTextField_UserName;
    private static javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
    static int poort = 0;

    private void logout() {
   jTextPane1.setText("");
        String sentence="2 - "+jTextField_UserName.getText().trim()+" - "+jTextField_Local_IP.getText().trim()+" - "+
                    jTextField_Local_Port.getText().trim()+" - " + Integer.toString(poS2);
         try {
           
            Socket clientSocket = new Socket(jTextField_TCP_IP.getText().trim(), Integer.parseInt(jTextField_TCP_Port.getText().trim())); 
            DataOutputStream outToServer =new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            outToServer.writeBytes(sentence); 
            clientSocket.close(); 
        }
         catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Server it is not connected","Problem in connection",JOptionPane.ERROR_MESSAGE);
        }
        
    }


static class Server extends Thread{
    
    public Server()
    {
        super();
        start();
    } 
    
    @Override
    public void run(){
        String Message;
        DatagramSocket serverSocket; 
        
        try {
              serverSocket = new DatagramSocket(pooort);
            while(true){
              byte[] receiveData = new byte[1024]; 
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              System.out.println("Wait Connect");
              serverSocket.receive(receivePacket); 
              
              System.out.println("Connected Success");
              
              System.out.println("Read data");
              InetAddress IPAddress = receivePacket.getAddress(); 
              int port = receivePacket.getPort()+1; 
              Message=new String(receivePacket.getData());
              System.out.println(port);
              jTextField_Status.setText("Received From:IP= " + IPAddress.getCanonicalHostName()
                                        + ", Port= "+ port);
                      
              if ( poort != pooort ){
                  StyledDocument doc = jTextPane1.getStyledDocument();
                  Style style1 = jTextPane1.addStyle("", null);
                  StyleConstants.setForeground(style1, Color.BLUE);
                  
                  
                  boolean f=false;
                  
                  for(int i=0;i<listModel.getSize();i++){
                      String st=(String)listModel.getElementAt(i);
                      st=st.replaceAll(" ","");
                      String []data=st.split("-");
                      if(data[1].equals(IPAddress.getCanonicalHostName()) && Integer.parseInt(data[2])==port){
                            doc.insertString(doc.getLength(), data[0]+": "+Message+"\n", style1);        
                            f=true;
                            break;
                      }
                  }
                  if(!f)
                        doc.insertString(doc.getLength(), "Unknown"+": "+Message+"\n", style1);                     

              }

          }     
        }
        catch (Exception ex) {
            System.out.println(ex); 
    }          
 }
}

static class ServerTCP extends Thread{
    
    public ServerTCP()
    {
        super();
        start();
    } 
    
       @Override
    public void run(){
        String Message;
        DatagramSocket serverSocket; 
        
        try {
          String clientSentence;
          ServerSocket sSocket = new ServerSocket(poS2);
          while(true){
                
                System.out.println("Wait Connect");
                Socket ConnectionSocket=sSocket.accept();
                System.out.println("Connected Success");

                BufferedReader inFormClient=new BufferedReader(new InputStreamReader(ConnectionSocket.getInputStream()));
                System.out.println("Read data");
                clientSentence=inFormClient.readLine();
                ConnectionSocket.close();
                System.out.println("Connection closed");
                
                if(clientSentence.equals("exit")){
                    listModel.removeAllElements();
                    JOptionPane.showMessageDialog(null,"Server is closed");
                    flagLog=false;
                    continue;
                }
                
                String[] data=clientSentence.split(",");
                System.out.println(clientSentence);
                listModel.removeAllElements();
                for(String s: data){
                    listModel.addElement(s);
                }
                
            }
              
        }
        catch (Exception ex) {
            System.out.println(ex); 
    }          
 }

}
}
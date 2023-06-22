/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.network_part2;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataClient{
    String name;
    String IP;
    String port_udp;
    String port_tcp;
    
    public DataClient(String name,String IP,String port_udp,String port_tcp){
        this.name=name;
        this.IP=IP;
        this.port_udp=port_udp;
        this.port_tcp=port_tcp;
    }
    
     @Override
    public boolean equals(Object o) {
         if (o == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof DataClient)) {
            return false;
        }
        
        DataClient c = (DataClient) o;
        
        return !(!name.equals(c.name) || !IP.equals(c.IP) || !port_udp.equals(c.port_udp) || !port_tcp.equals(c.port_tcp));
    }
    
}

public class Server_Part2 extends javax.swing.JFrame {
    
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
            jComboBox1.addItem(netint.getName()+":"+req.toString().substring(1, req.toString().length()));
        }
     }

private static int pooort;
static Server server;
static ArrayList<DataClient> itemOfList = new ArrayList<DataClient>();
static  ServerSocket sSocket;


    public Server_Part2() {
        initComponents();
        
        
                Enumeration<NetworkInterface> nets;
        try {
            nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
        } catch (SocketException ex) {
            Logger.getLogger(Server_Part2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
               addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {

        for (int i = 0; i < itemOfList.size(); i++) {
       DataClient dc=itemOfList.get(i);
       Socket clientSocket;
       try {
           clientSocket = new Socket(dc.IP, Integer.parseInt(dc.port_tcp));
           DataOutputStream outToClient = 
       new DataOutputStream(clientSocket.getOutputStream());
       outToClient.writeBytes("exit\n");
       } catch (IOException ex) {
           Logger.getLogger(Server_Part2.class.getName()).log(Level.SEVERE, null, ex);
       }
  }
        
       
        
        
       System.exit(0);
    }
});
        
        
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Port = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Status = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TCPServer");
        setResizable(false);

        jButton1.setText("Start Listening");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Port:");

        jLabel2.setText("Status:");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
        if(sSocket!=null)
            try {
                sSocket.close();
                server.stop();
        } catch (IOException ex) {
            Logger.getLogger(Server_Part2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            for (int i = 0; i < itemOfList.size(); i++) {
                DataClient dc=itemOfList.get(i);
                Socket clientSocket;
                try {
                    clientSocket = new Socket(dc.IP, Integer.parseInt(dc.port_tcp));
                    DataOutputStream outToClient = 
                new DataOutputStream(clientSocket.getOutputStream());
                outToClient.writeBytes("exit\n");
                } catch (IOException ex) {
                    Logger.getLogger(Server_Part2.class.getName()).log(Level.SEVERE, null, ex);
                }
  }
        itemOfList.removeAll(itemOfList);
        jTextArea2.setText("");
        server= new Server();    
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Server_Part2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Part2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Part2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Part2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_Part2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel_Status;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    private static javax.swing.JTextField jTextField_Port;
    // End of variables declaration//GEN-END:variables

  
static class Server extends Thread{
    
    int port;
    
    
    
    public Server()
    {
        super();
        start();
    } 
    
    @Override
    public void run(){
       String Message;
        DatagramSocket serverSocket; 

          try{
          String clientSentence;
          Socket clientSocket = null;
          sSocket = new ServerSocket(Integer.parseInt(jTextField_Port.getText().trim()));
          while(true){
                
                System.out.println("Wait Connect");
                Socket ConnectionSocket=sSocket.accept();
                System.out.println("Connected Success");

                BufferedReader inFormClient=new BufferedReader(new InputStreamReader(ConnectionSocket.getInputStream()));
                System.out.println("Read data");
                clientSentence=inFormClient.readLine();
   
                ConnectionSocket.close();
                System.out.println("Connection closed");
                
                // flag - name - ip - port_udp - port_tcp
                // 0    - 1    - 2  - 3        - 4
                
                clientSentence = clientSentence.replaceAll(" ", "");
                String[] data = clientSentence.split("-");
                for(String st:data)
                    System.out.println(st);
                System.out.println("\\\\\\\\\\\\\\");
                boolean flag = false;
                DataClient obj=new DataClient(data[1],data[2],data[3],data[4]);
                
                if ( data[0].equals("1")){
                    flag=true;
                    for(int i=0;i<itemOfList.size();i++)
                        if( (itemOfList.get(i).equals(obj)) )
                            flag=false;
                    
                        if(flag)
                            itemOfList.add(obj);
                }
                else if(data[0].equals("2")){
                    flag=false;
                    for(int i=0;i<itemOfList.size();i++)
                        if( (itemOfList.get(i).equals(obj)) )
                            flag=true;
                    System.out.println(flag);
                    if(flag){
                        System.out.println("send");
                        itemOfList.remove(obj);
                        
                        //when delete client sent to him empty list
                        clientSocket = new Socket(obj.IP, Integer.parseInt(obj.port_tcp));
                        DataOutputStream outToClient = 
                            new DataOutputStream(clientSocket.getOutputStream());
                        outToClient.writeBytes("\n");
                    }
                }
                

                String concatination = "";
                    jTextArea2.setText("");
                        for (int i = 0; i < itemOfList.size(); i++) {
                          DataClient dc=itemOfList.get(i);
                          String st=dc.name+" - " + dc.IP + " - " + dc.port_udp;
                          System.out.println("List");
                          jTextArea2.append(st+"\n");
                          System.out.println(st);
                          concatination += st;
                          if( (i+1) != itemOfList.size() )
                              concatination += ",";
                        }
 
                        concatination += "\n";
                  

                    clientSocket = new Socket(obj.IP, Integer.parseInt(obj.port_tcp));
                    DataOutputStream outToClient = 
                            new DataOutputStream(clientSocket.getOutputStream());
                      if(data[0].equals("1") || data[0].equals("3"))
                        outToClient.writeBytes(concatination);
                      else if(data[0].equals("2"))
                           outToClient.writeBytes("\n");
                                  
        }
              
      }
        catch (Exception ex) {
            System.out.println(ex); 
    }            
 }
}
    
}


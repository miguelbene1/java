/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.inicio;
import view.admi;
import view.vende;
import view.clien;
import model.lista;
import view.login;
import javax.swing.JTable;
import java.util.ArrayList;

/**
 *
 * @author APRENDIZ SENA
 */
public class controlar implements ActionListener {

    inicio uno;  
    
    vende vendedor = new vende();
   
    admi admin = new admi();
    
    clien cliente = new clien();
    
    login productos = new login();

    ArrayList<lista> listaa = new ArrayList<lista>();
    
      private int id;
    private String nombre;
    private String apellido;
    private int precio;
    private String usuario;
    private String contraseña;

    

    private String name;
    private String co;

    public controlar(inicio uno) {
        this.uno = uno;
        this.iniciar();
        this.uno.ingresar.addActionListener(this);
        this.cliente.volverc.addActionListener(this);
        this.vendedor.ingresar.addActionListener(this);
        this.admin.abrid.addActionListener(this);
        this.admin.show.addActionListener(this);
        this.cliente.cvolver.addActionListener(this);
        this.admin.volvera.addActionListener(this);
        this.vendedor.volverv.addActionListener(this);
        this.admin.mostrap.addActionListener(this);
        this.productos.volverpr.addActionListener(this);
        this.admin.salirR.addActionListener(this);
        this.admin.SALIR.addActionListener(this);
        this.cliente.guardarclie.addActionListener(this);
        this.vendedor.savevender.addActionListener(this);
        this.productos.guarprodu.addActionListener(this);
        this.cliente.limpiar.addActionListener(this);
    
        


    }

    public void iniciar() {
        this.uno.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == this.uno.ingresar) {

            name = this.uno.nombre.getText();
            co = this.uno.contrase.getText();


            if (name.equals("admin") && co.equals("123")) {
                admin.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");
                
            
                
            }else if (name.equals("vendedor")&& co.equals("789")){
                vendedor.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");
                
                
            }else if (name.equals("cliente") && co.equals("456")){
                cliente.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");
                
              
            }else if (name.equals("") && co.equals("")) {
                    JOptionPane.showMessageDialog(null, "No valido");
                
            }else {
                JOptionPane.showMessageDialog(null,"DATO INCORRESTO");
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");
            }
            
        
        }
        if (e.getSource() == this.vendedor.ingresar){
            uno.setVisible(true);
            vendedor.dispose();
            this.uno.nombre.setText("");
            this.uno.contrase.setText("");
            
        
        }
        if(e.getSource() == this.cliente.volverc){
            uno.setVisible(true);
            cliente.dispose();
        }
        if (e.getSource() == this.admin.show){
            cliente.setVisible(true);
            admin.dispose();
        
        }
        if (e.getSource() == this.cliente.cvolver){
            admin.setVisible(true);
            cliente.dispose();
           
        }
        if (e.getSource() == this.admin.volvera){
            vendedor.setVisible(true);
            admin.dispose();
        }
        if (e.getSource() == this.vendedor.volverv){
            admin.setVisible(true);
            vendedor.dispose();
        }
        if (e.getSource() == this.admin.mostrap){
            productos.setVisible(true);  
            admin.dispose();
        }   
        if (e.getSource() == this.productos.volverpr){
            admin.setVisible(true);
            productos.dispose();
            
        }
        if (e.getSource() == this.admin.SALIR){
            uno.setVisible(true);
            admin.dispose();       
    }
    
        
        if (e.getSource() == this.cliente.guardarclie){
            id = Integer.parseInt(this.cliente.idcli.getText());
            nombre = this.cliente.nombreclie.getText();
            apellido = this.cliente.apecliente.getText();
            this.cliente.idcli.setText("");
            this.cliente.nombreclie.setText("");
            this.cliente.apecliente.setText("");
            
            listaa.add(new lista(id,nombre,apellido,precio,usuario,contraseña));
            llenarcliente(this.cliente.tablaclient,listaa);
        }
         if (e.getSource() == this.vendedor.savevender){
            id = Integer.parseInt(this.vendedor.idd.getText());
            nombre = this.vendedor.nombrevende.getText();
            apellido = this.vendedor.apellidovender.getText();
            this.vendedor.idd.setText("");
            this.vendedor.nombrevende.setText("");
            this.vendedor.apellidovender.setText("");
            
            listaa.add(new lista(id,nombre,apellido,precio,usuario,contraseña));
            llenar(this.vendedor.tablavender,listaa); 
         }
         if (e.getSource() == this.cliente.limpiar){
             
         }
        }
        public void llenarcliente(JTable tableclient,ArrayList<lista> listas ){
            for (int i = 0; i <listas.size(); i++) {
                tableclient.setValueAt(listas.get(i).getId(), i, 0);
                tableclient.setValueAt(listas.get(i).getNombre(), i, 1);
                tableclient.setValueAt(listas.get(i).getApellido(), i, 2);
            } 
            }
           public void llenar(JTable tablavende,ArrayList<lista> listas ){
            for (int i = 0; i <listas.size(); i++) {
                tablavende.setValueAt(listas.get(i).getId(), i, 0);
                tablavende.setValueAt(listas.get(i).getNombre(), i, 1);
                tablavende.setValueAt(listas.get(i).getApellido(), i, 2);
        }
           
      }
           
   }
           
   


 


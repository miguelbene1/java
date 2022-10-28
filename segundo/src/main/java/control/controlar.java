/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.inicio;
import view.admin;
import view.vende;
import view.cliente;
import model.lista;
import view.login;
import javax.swing.JTable;
import java.util.ArrayList;
import view.clien;
import view.vendedor;
import view.productos;
import model.listaproductos;

import model.listavendedor;
        

/**
 *
 * @author APRENDIZ SENA
 */
public class controlar implements ActionListener {

    inicio uno;

    vendedor vintro = new vendedor();

    clien clientein = new clien();

    vende vendedor = new vende();

    admin admin = new admin();

    cliente cliente = new cliente();

    login productos = new login();

    productos proin = new productos();

    ArrayList<lista> listaa = new ArrayList<>();
    ArrayList<listavendedor> listavendedor = new ArrayList<>();
    ArrayList<listaproductos> listaproductos = new ArrayList<>();   
    
    private int id;
    private String nombre;
    private String apellido;
    
 

    private String name;
    private String co;

    

    public controlar(inicio uno) {
        this.uno = uno;
        this.iniciar();
        this.uno.ingresar1.addActionListener(this);
        this.vendedor.ingresar.addActionListener(this);
        this.cliente.guardarclie.addActionListener(this);
        this.vendedor.savevender.addActionListener(this);
        this.productos.guarprodu.addActionListener(this);
        this.cliente.limpiar.addActionListener(this);
        this.admin.mostracl.addActionListener(this);
        this.admin.sale.addActionListener(this);
        this.admin.producin.addActionListener(this);
        this.clientein.volverc.addActionListener(this);
        this.clientein.guardarclie.addActionListener(this);
        this.admin.SALIRADMIN.addActionListener(this);
        this.uno.salir.addActionListener(this);
        this.vintro.savevenderx.addActionListener(this);

    }

    public void iniciar() {
        this.uno.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.uno.ingresar1) {

            name = this.uno.nombre.getText();
            co = this.uno.contrase.getText();

            if (name.equals("admin") && co.equals("123")) {
                admin.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");

            } else if (name.equals("vendedor") && co.equals("789")) {
                vendedor.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");

            } else if (name.equals("cliente") && co.equals("456")) {
                clientein.setVisible(true);
                uno.dispose();
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");

            } else if (name.equals("") && co.equals("")) {
                JOptionPane.showMessageDialog(null, "No valido");

            } else {
                JOptionPane.showMessageDialog(null, "DATO INCORRESTO");
                this.uno.nombre.setText("");
                this.uno.contrase.setText("");
            }

        }
        if (e.getSource() == this.vendedor.ingresar) {
            uno.setVisible(true);
            vendedor.dispose();
            this.uno.nombre.setText("");
            this.uno.contrase.setText("");

        }

        if (this.admin.mostracl == e.getSource()) {
            this.admin.todo.add(cliente);
            cliente.show();
        }

        if (this.admin.sale == e.getSource()) {
            this.admin.todo.add(vintro);
            vintro.show();
        }

        if (this.admin.producin == e.getSource()) {
            this.admin.todo.add(proin);  
            proin.show();
        }

        if (e.getSource() == this.clientein.volverc) {
            uno.setVisible(true);
            clientein.dispose();
        }
        if (e.getSource() == this.admin.SALIRADMIN){
            uno.setVisible(true);
            admin.dispose();
        }
        if(e.getSource() == this.uno.salir){
            System.exit(0);
        }
        
       
        
    /*
        TABLA CLIENTE
        */
        if (e.getSource() == this.cliente.guardarclie) {
            id = Integer.parseInt(this.cliente.idcli.getText());
            nombre = this.cliente.nombreclie.getText();
            apellido = this.cliente.apecliente.getText();
            this.cliente.idcli.setText("");
            this.cliente.nombreclie.setText("");
            this.cliente.apecliente.setText("");

            listaa.add(new lista(id, nombre, apellido));
            llenarcliente(this.cliente.tablaclient, listaa);
        }
        if (e.getSource() == this.clientein.guardarclie) {
            id = Integer.parseInt(this.clientein.idcli.getText());
            nombre = this.clientein.nombreclie.getText();
            apellido = this.clientein.apecliente.getText();
            this.clientein.idcli.setText("");
            this.clientein.nombreclie.setText("");
            this.clientein.apecliente.setText("");

            listaa.add(new lista(id, nombre, apellido));
            llenarcliente(this.clientein.tablaclient, listaa);
        }
        /**
         * TABLA  VENDEDOR
         * */
        
        if (e.getSource() == this.vendedor.savevender) {
            id = Integer.parseInt(this.vendedor.idd.getText());
            nombre = this.vendedor.nombrevende.getText();
            apellido = this.vendedor.apellidovender.getText();
            this.vendedor.idd.setText("");
            this.vendedor.nombrevende.setText("");
            this.vendedor.apellidovender.setText("");

            listavendedor.add(new listavendedor(id, nombre, apellido));
            llenarvendedor(this.vendedor.tablavender, listavendedor);
            
        }

        if (e.getSource() == this.vintro.savevenderx) {
            id = Integer.parseInt(this.vintro.idd.getText());
            nombre = this.vintro.nombrevende.getText();
            apellido = this.vintro.apellidovender.getText();
            this.vintro.idd.setText("");
            this.vintro.nombrevende.setText("");
            this.vintro.apellidovender.setText("");
           
            listavendedor.add(new listavendedor(id, nombre, apellido));
            llenarvendedor(this.vintro.vendertabla, listavendedor);
        }
    }
    public void llenarcliente(JTable tableclient, ArrayList<lista> listas) {
        for (int i = 0; i < listas.size(); i++) {
            tableclient.setValueAt(listas.get(i).getId(), i, 0);
            tableclient.setValueAt(listas.get(i).getNombre(), i, 1);
            tableclient.setValueAt(listas.get(i).getApellido(), i, 2);
        }
    }

    public void llenarvendedor(JTable tablavender, ArrayList<listavendedor> list) {
        for (int i = 0; i < listavendedor.size(); i++) {
            tablavender.setValueAt(listavendedor.get(i).getId(), i, 0);
            tablavender.setValueAt(listavendedor.get(i).getNombre(), i, 1);
            tablavender.setValueAt(listavendedor.get(i).getApellido(), i, 2);
        }
    }
    

         
            
        }
    

   
    
        
        
      


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Matuz
 */

import java.awt.Color;
import javax.swing.JFrame; //Para la ventana
import javax.swing.JLabel; //Datos de salida
import javax.swing.JButton; //Para botones
import javax.swing.JTextField; //Para caja de texto
import java.awt.event.ActionListener; //Para el escuchador
import java.awt.event.ActionEvent; //Eventos
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class CalculadoraIVA extends JFrame implements ActionListener{
    
    private JLabel mensaje;
    private JButton boton;
    private JTextField caja;
    private JTextField caja2;
    private JComboBox iva;
    private String selectIva;
    private int seleccionUsuario;
    public CalculadoraIVA(){
        super();
        seleccionUsuario=0;
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("Calculadora de IVA"); //Titulo de la ventana
        this.setSize(300,300); //Tamaño con ancho y altura
        this.setLocationRelativeTo(null); //Para que la colocacion de la pantalla sea relativa
        this.setLayout(null); //Para la acomodación de las cosas dentro de la ventana
        this.setResizable(true); //Modificación del tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar ventana
    }
    
    private void crearComponentes(){
        mensaje = new JLabel(); //Se crea el objeto JLabel
        mensaje.setText("Cantidad"); // Se crea el texto a mostrar
        mensaje.setBounds(50,50, 300, 30); // Posición X e Y del texto y su tamaño.
        mensaje.setForeground(Color.BLACK); //Color del texto
        this.add(mensaje); //Añadir el texto a la ventana
        
        mensaje = new JLabel();
        mensaje.setText("IVA");
        mensaje.setBounds(50,110,300,30);
        mensaje.setForeground(Color.BLACK);
        this.add(mensaje);
        
        mensaje = new JLabel();
        mensaje.setText("$");
        mensaje.setBounds(42,80,300,30);
        mensaje.setForeground(Color.BLACK);
        this.add(mensaje);
        
        
        mensaje = new JLabel();
        mensaje.setText("%");
        mensaje.setBounds(152,138,300,30);
        mensaje.setForeground(Color.BLACK);
        this.add(mensaje);
        
        
        caja = new JTextField();
        caja.setBounds(50,80,100,30);
        this.add(caja);
        
        /*
        caja2 = new JTextField();
        caja2.setBounds(50,140,100,30);
        this.add(caja2);
        */
        
        
        boton = new JButton();
        boton.setText("Calcular");
        boton.setBounds(50,180,150,30);
        boton.addActionListener(this);
        this.add(boton);
        
        String[] ivaList = new String[] {"IVA","16","15","10","8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(50,140,100,25);
        iva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              selectIva = iva.getItemAt(iva.getSelectedIndex()); 
              seleccionUsuario = iva.getSelectedIndex();
                //System.out.println("El valor de iva es: " + selectIva);
            }
        });
        this.add(iva);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(seleccionUsuario!=0){
            try {
                    String numeroIngresado = caja.getText(); //Obtiene el texto que se encuentra en la cajita de texto 
                    String cantidadIVA = selectIva;
                    float numero1 = java.lang.Float.parseFloat(numeroIngresado);
                    float numero2 = java.lang.Float.parseFloat(cantidadIVA);
                    float total = numero1*(numero2/100);
                    String resultado = "" + total;

                    JOptionPane.showMessageDialog(this, "El valor del IVA es de $" + resultado + "\nEl valor total es de $" + (numero1+total) ,"Resultado.", 1);
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.","ERROR", 1);
            }
        }
        else {
            JOptionPane.showMessageDialog(this,"Por favor, escoja un valor de IVA","ERROR", 1);
        }
    }
    
    public static void main(String[] args){
        CalculadoraIVA ventana = new CalculadoraIVA();
        ventana.setVisible(true);
    }
    
}

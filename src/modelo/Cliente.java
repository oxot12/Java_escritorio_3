/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Oseas Xt
 */
public class Cliente extends Persona {
    private int id;
    private String nit;
       Conexion cn;    

 public Cliente(){}
    
    public Cliente(int id, String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.id = id;
        this.nit = nit;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
 public DefaultTableModel leer(){
     DefaultTableModel tabla = new DefaultTableModel();
     
     try{
         cn = new Conexion();
         cn.abrir_conexion();
         String query;
         query = "select id_cliente as id,nit,nombres,apellidos,direccion,telefono,fecha_nacimiento from clientes;";
         ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
         
         String encabezado[] = {"id","nit","nombres","apellidos","direccion","telefono","Fecha Nacimiento"};
         tabla.setColumnIdentifiers(encabezado);
         String datos [] = new String[7];
         
         while(consulta.next()){
             datos[0] = consulta.getString("id");
             datos[1] = consulta.getString("nit");
             datos[2] = consulta.getString("nombres");
             datos[3] = consulta.getString("Apellidos");
             datos[4] = consulta.getString("Direccion");
             datos[5] = consulta.getString("Telefono");;
             datos[6] = consulta.getString("Fecha_nacimiento");
             tabla.addRow(datos);
         }
         
         cn.cerrar_conexion();
         
     }catch(SQLException ex){
         System.out.println("error" + ex.getMessage());
     }
     
     return tabla;
 }   
    @Override
    public void agregar(){
     try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         String query;
         query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento)VALUES(?,?,?,?,?,?)";
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getNit());
         parametro.setString(2, getNombres());
         parametro.setString(3, getApellidos());
         parametro.setString(4, getDireccion());
         parametro.setString(5, getTelefono());
         parametro.setString(6, getFecha_nacimiento());
         int executar = parametro.executeUpdate();
         cn.cerrar_conexion();
         JOptionPane.showMessageDialog(null, Integer.toString(executar) + " Registros Ingresados", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
     }catch(SQLException ex){
         System.out.println("error" + ex. getMessage());
     }}
   
    public void modificar (){
     try{
         PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         String query;
         query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento)VALUES(?,?,?,?,?,?)";
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getNit());
         parametro.setString(2, getNombres());
         parametro.setString(3, getApellidos());
         parametro.setString(4, getDireccion());
         parametro.setString(5, getTelefono());
         parametro.setString(6, getFecha_nacimiento());
         int executar = parametro.executeUpdate();
         cn.cerrar_conexion();
         JOptionPane.showMessageDialog(null, Integer.toString(executar) + " Registros Ingresados", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
     }catch(SQLException ex){
         System.out.println("error" + ex. getMessage());
     }
    }
}

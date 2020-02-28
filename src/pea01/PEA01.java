/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pea01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author l11m09
 */
public class PEA01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/appleInc?user=root&password=mysqladmin";
            Connection connect = DriverManager.getConnection(url);
            String query = "Select * from dispositivos";
            Statement statement = connect.createStatement();
            ResultSet resulSet = statement.executeQuery(query);
            while (resulSet.next()) {
                String nombre = resulSet.getString("nombre");
                int precio = resulSet.getInt("precio");
                String tipo = resulSet.getString("tipo");
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Tipo: " + tipo);
                System.out.println("======================================");
            }

            Scanner scan = new Scanner(System.in);
            System.out.println("Que deseas hacer : INSERTAR / BORRAR / MODIFICAR");
            String accion = scan.nextLine();
            if (accion.equalsIgnoreCase("INSERTAR")) {
                scan = new Scanner(System.in);
                System.out.println("INGRESAR EL Nombre");
                String nombre = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el Precio");
                String precio = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el Tipo");
                String tipo = scan.nextLine();
                //
                query = "call ingresar(?,?,?)";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setString(1, nombre);
                ps.setInt(2, Integer.parseInt(precio));
                ps.setString(3, tipo);
                ps.executeUpdate();
            }
            ///

            if (accion.equalsIgnoreCase("borrar")) {
                scan = new Scanner(System.in);
                System.out.println("INGRESAR EL Nombre");
                String nombre = scan.nextLine();

                query = "call eliminar(?)";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setString(1, nombre);
                ps.executeUpdate();
            }
            
            if (accion.equalsIgnoreCase("modificar")) {
                scan = new Scanner(System.in);
                System.out.println("INGRESAR EL Nombre");
                String nombre = scan.nextLine();


                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                String precio = scan.nextLine();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el Tipo");
                String tipo = scan.nextLine();
                //
                query = "call modificar(?,?,?)";
                PreparedStatement ps = connect.prepareStatement(query);
           
                ps.setString(1, nombre);
                ps.setInt(2,Integer.parseInt(precio));
                ps.setString(3, tipo);
                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}

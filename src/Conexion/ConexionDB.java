
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

public class ConexionDB {
    private String url="jdbc:mysql://localhost:3306";
    private String bd="softgym";
    private String user="root";
    private String password="";
    private String driver="com.mysql.cj.jdbc.Driver";
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url+bd+user+password);
            st=con.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void consultar(){
        try {
            String query="SELECT * FROM usuario";
            rs=st.executeQuery(query);
            while(rs.next()){
                int id_usuario=rs.getInt("id_Usuario");
                String nombre=rs.getString("Nombre");
                String apellido=rs.getString("Apellido");
                String tipoDocumento = rs.getString("TipoDocumento");
                String numeroDocumento = rs.getString("NumeroDocumento");
                Date fechaNacimiento = rs.getDate("FechaNacimiento");
                String direccion=rs.getString("Dirección");
                String celular=rs.getString("Celular");
                Date fechaIngreso = rs.getDate("FechaIngreso");
                System.out.println("Usuario: "+id_usuario+
                                   "\nNombre: "+nombre+
                                   "\nApellido: "+apellido+
                                   "\nTipo de Documento: " + tipoDocumento +
                                   "\nNúmero de Documento: " + numeroDocumento +
                                   "\nFecha de Nacimiento: " + fechaNacimiento +
                                   "\nDirección: "+direccion+
                                   "\nCelular: "+celular+
                                   "\nFecha de Ingreso: " + fechaIngreso + "\n");
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void insertar(){
        try{
            String query="INSERT INTO usuario VALUES(1,'Natalia','Suarez','CC','1110602','24/12/1999','Cra 4A #105','312526','29/10/2024')";
            st.executeUpdate(query);
            System.out.println("El usuario se ingresó exitosamente\n");                                         
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
        
    public void actualizar(){
        try{
            String query="UPDATE usuario SET nombre='Natalia', apellido='Suarez Cortes', tipoDocumento='CC', numeroDocumento='1110602', fechaNacimiento='24/12/1999', direccion='Cra 4A #105', celular='312526', fechaIngreso='29/10/2024' WHERE id=1";
            st.executeUpdate(query);
            System.out.println("El usuario se actualizó correctamente\n");                                         
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void eliminar(){
        try {
        String query = "DELETE FROM Usuario WHERE id=1";
        st.executeUpdate(query);
        System.out.println("El usuario se eliminó exitosamente\n"); 
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
}

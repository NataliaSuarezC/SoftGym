
package Conexion;


public class Main {


    public static void main(String[] args) {
        ConexionDB objusu=new ConexionDB();
        objusu.eliminar();
        objusu.actualizar();
        objusu.insertar();
        objusu.consultar();       
    }  
}

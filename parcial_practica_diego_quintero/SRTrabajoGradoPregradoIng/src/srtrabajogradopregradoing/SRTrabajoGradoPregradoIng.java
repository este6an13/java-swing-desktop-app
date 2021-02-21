
package srtrabajogradopregradoing;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SRTrabajoGradoPregradoIng {


    public static void main(String[] args) throws SQLException {
        
        try {
            
            Programa sistemas = new Programa("Ingeniería de Sistemas y Computación");
            Programa civil = new Programa("Ingeniería Civil");
            Programa mecatronica = new Programa("Ingeniería Mecatrónica");
            Programa electrica = new Programa("Ingeniería Eléctrica");
            Programa electronica = new Programa("Ingeniería Electrónica");
            Programa industrial = new Programa("Ingeniería Industrial");
            Programa mecanica = new Programa("Ingeniería Mecánica");
            
            Profesor p0 = new Profesor("aaaa", "Germán Moreno", sistemas);
            Profesor p1 = new Profesor("aaab", "Gilma Ramírez", civil);
            Profesor p2 = new Profesor("aaac", "Samuel Ibañez", mecatronica);
            
            ArrayList<Profesor> profesores = new ArrayList<Profesor>();
            profesores.add(p0);
            profesores.add(p1);
            profesores.add(p2);
            
            for (Profesor p: profesores) {
                p.imprimirInfo();
                System.out.println();
            }
            
            HashMap<String, Estudiante> coleccionEstudiantes = AccesoInfo.inicializarEstudiantes();
            
            coleccionEstudiantes.get("0000").setPrograma(sistemas);
            coleccionEstudiantes.get("0001").setPrograma(civil);
            coleccionEstudiantes.get("0002").setPrograma(mecatronica);
            coleccionEstudiantes.get("0003").setPrograma(electrica);
            coleccionEstudiantes.get("0004").setPrograma(civil);
            coleccionEstudiantes.get("0005").setPrograma(industrial);
            coleccionEstudiantes.get("0006").setPrograma(industrial);
            coleccionEstudiantes.get("0007").setPrograma(mecanica);
            coleccionEstudiantes.get("0008").setPrograma(sistemas);
            coleccionEstudiantes.get("0009").setPrograma(sistemas);
            coleccionEstudiantes.get("0010").setPrograma(industrial);
            coleccionEstudiantes.get("0011").setPrograma(civil);
            coleccionEstudiantes.get("0012").setPrograma(mecatronica);
            
            ConexionMySQL conmysql = new ConexionMySQL();
            
            for (Estudiante e: coleccionEstudiantes.values()) {
            
                if (!(conmysql.existe(e.getId()))) {
                    conmysql.insertar(e.getNombre(), e.getId(), e.getPass());
                } 
            }
            
            for (Estudiante e: coleccionEstudiantes.values()) {
                e.imprimirInfo();
                System.out.println();
            }
            
            HashMap<String, Asignatura> coleccionAsignaturas = AccesoInfo.inicializarAsignaturas();
            
            for (Asignatura a: coleccionAsignaturas.values()) {
                a.imprimirInfo();
                System.out.println();
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(SRTrabajoGradoPregradoIng.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

class Persona {
    
    private String nombre;
    private Programa programa;
    public void setPrograma(Programa p) {
        this.programa = p;
    }
    
    public Programa getPrograma() {
        return this.programa;
    }
    
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void imprimirInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Programa: " + this.programa.getNombre());
    }
    
}

class Estudiante extends Persona {
    
    private String id;
    private String password;
     
    public void setId(String i) {
        this.id = i;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setPass(String p) {
        this.password = p;
    }
    
    public String getPass() {
        return this.password;
    }
    
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("ID: " + this.id);
    }
    
}

class Profesor extends Persona { 
    
    public String codigo;
    
    public void setCodigo(String c) {
        this.codigo = c;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public Profesor(String c, String n, Programa p) {
        this.setCodigo(c);
        this.setNombre(n);
        this.setPrograma(p);
    }
    
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("Código: " + this.codigo);
    }
}

class Programa {

    private String nombre; 

    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public Programa(String n) {
        this.setNombre(n);
    }
    
}

class Asignatura {
    
    private String nombre;
    private String codigo;
    
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setCodigo(String c) {
        this.codigo = c;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void imprimirInfo() {
        System.out.println("Código Asignatura: " + this.codigo);
        System.out.println("Asignatura: " + this.nombre);
    }
}

class TrabajoGrado extends Asignatura {
    
    private DSI dsi;
    
    public void setDsi(DSI d) {
        this.dsi = d;
    }
    
    public DSI getDsi () {
        return this.dsi;
    }
    
}

class Investigativo extends TrabajoGrado {
    
    private Profesor director;
    
    public void setDirector (Profesor p) {
        this.director = p;
    }
    
    public Profesor getDirector() {
        return this.director;
    }
    
}

class Extension extends TrabajoGrado {
    
    private Profesor director;
    
    public void setDirector (Profesor p) {
        this.director = p;
    }
    
    public Profesor getDirector() {
        return this.director;
    }
}


class AsigPosgrado extends TrabajoGrado {
    
    private HashMap<String, Programa> asignaturas;

    public void setAsignaturas(HashMap<String, Programa> a) {
        this.asignaturas = a;
    }
    
    public HashMap<String, Programa> getAsignaturas() {
        return this.asignaturas;
    }
}

class DSI {
    
    private String titulo;
    private Estudiante estudiante;
    private File documento;

    public void setTitulo(String t) {
        this.titulo = t;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setEstudiante (Estudiante e) {
        this.estudiante = e;
    }
    
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setDocumento (File d) {
        this.documento = d;
    }
    
    public File getDocumento() {
        return this.documento;
    }
    
}

class AccesoInfo {
    
    static HashMap<String, Estudiante> coleccionEstudiantes = new HashMap<>(); 
    static HashMap<String, Asignatura> coleccionAsignaturas = new HashMap<>();
    
    
    public static HashMap<String, Estudiante> inicializarEstudiantes() throws IOException {
        
        File listaEstudiantes = new File("estudiantes.txt");
        
        try {
            
            FileReader fis = new FileReader(listaEstudiantes);
            BufferedReader lector = new BufferedReader(fis);
            
            String registro = lector.readLine();
            
            while (registro != null){
                
                StringTokenizer stok = new StringTokenizer(registro, "\t");
           
                Estudiante e = new Estudiante();
                e.setNombre(stok.nextToken());
                e.setId(stok.nextToken());
                e.setPass(stok.nextToken());
                
                coleccionEstudiantes.put(e.getId(), e);
          
                registro = lector.readLine();
            }
            
            lector.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return coleccionEstudiantes;
    }
    
    public static HashMap<String, Asignatura> inicializarAsignaturas() throws IOException {
        
        File listaAsignaturas = new File("asignaturas.txt");
        
        try {
            
            FileReader fis = new FileReader(listaAsignaturas);
            BufferedReader lector = new BufferedReader(fis);
            
            String registro = lector.readLine();
            
            while (registro != null){
                
                StringTokenizer stok = new StringTokenizer(registro, "\t");
           
                Asignatura a = new Asignatura(); 
                a.setCodigo(stok.nextToken());
                a.setNombre(stok.nextToken());
                
                coleccionAsignaturas.put(a.getCodigo(), a);
          
                registro = lector.readLine();
            }
            
            lector.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return coleccionAsignaturas;
    }
    
}

class ConexionMySQL {
    
    private Connection con;
    
    public ConexionMySQL() throws SQLException {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes", "user", "pass");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getCon() {
        return this.con;
    }
    
    public void insertar(String n, String i, String p) {
        
        try {
            
            PreparedStatement pps = (PreparedStatement) this.getCon().prepareStatement("INSERT INTO datosacceso(nombre, id, password) VALUES(?,?,?)");
            pps.setString(1, n);
            pps.setString(2, i);
            pps.setString(3, p);
            pps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    
    public boolean existe(String i) {
    
        try {
            
            String consulta = "SELECT * FROM datosacceso WHERE id = " + i;
            Statement st = this.getCon().createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            if (rs.absolute(1)) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        return false;
    }
    
}


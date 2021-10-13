package com.redsocial.dominio.usuario;

import com.redsocial.dominio.direccion.Direccion;
import com.redsocial.dominio.mascota.Mascota;
import com.redsocial.enumeraciones.Rol;
import com.sun.istack.internal.NotNull;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity// Esta anotacion, avisa que esta clase se convertira en TABLA de nombre Usuario y todos los atributos van a ser una columna de la tabla
//@Table (name="llamate así") //esto va a cambiar el nombre de la tabla
public class Usuario {
//CADA ATRIBUTO DEFINIDO EN UNA CLASE DEL TIPO ENTIDAD, SE CONVIERTE EN  UNA COLUMNA EN MI TABLA
    @Id //Declara un atributo como la clave primaria de la Tabla
    @GeneratedValue //Declara como el atributo que va a ser al clave primaria va a ser inicializada. Manualmente, Automático o a partir de una secuencia. si no recibe parametros es automático el incremento. (strategy= GenerationType.IDENTITY) incrementa en 1 el contador 
    private String id;
   
    @Column(unique = true) //@Column declara el nombre de la columna de la table y se usa para insertar parametros como (unique=true)
    private String correoElectronico;
     
    private String clave;

    @NotNull // Que no sea nulo
    @Column(unique = true)// (unique = true) Para que no permita duplicar este campo en otros registros. (lenght=longitud) para limitar la longitud de la columna
    private String dni;

   //Relacion de uno a uno
    @OneToOne(cascade = CascadeType.REMOVE)//Haciendo referencia a que Si se elimina un "usuario" se elimine en cascada, es decir se elimina la mascota
    private Mascota mascota;

    @OneToOne(cascade = CascadeType.REMOVE)//Esto indicado para que si elimino al PADRE,elimino el vinculado, en este caso la direccion
    private Direccion direccion;

    //Siempre que manejo fechas, debo utilizar esta anotacion
    @Temporal(TemporalType.DATE) //Declara que se está tratando de un atributo que va a trabajar con fechas, entre paréntesis, debemos especificarle que estilo de fecha va a manejar en la base de datos: @Temporal(TemporalType.DATE) Acotara el campo solo a la Fecha, descartando la hora, @Temportal(TemporalType.TIME) Acotara el campo solo a la Hora, descartando a la fecha, @Temporal(TemporalType.TIMESTAMP) Toma la fecha y hora
    private Date nacimiento;

    //Siempre que manejo enumeraciones, debo utilizar esta anotacion
    @Enumerated(EnumType.STRING)  //Declara que un atributo es de alguno de los valores definidos en un Enumerado (lista de valores constantes)
    private Rol rol;

    
    //Dejo mis constructores
    public Usuario() {
    }

    public Usuario(String correoElectronico, String clave, String dni, Direccion direccion, Date nacimiento, Rol rol) {
        this.correoElectronico = correoElectronico;
        this.clave = clave;
        this.dni = dni;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.rol = rol;
    }

    //Dejo mis GET y SET
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", correoElectronico=" + correoElectronico + ", clave=" + clave + ", dni=" + dni + ", mascota=" + mascota + ", direccion=" + direccion + ", nacimiento=" + nacimiento + ", rol=" + rol + '}';
    }

}

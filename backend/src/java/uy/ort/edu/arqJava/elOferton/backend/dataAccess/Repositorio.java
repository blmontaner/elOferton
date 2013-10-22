/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.backend.dataAccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uy.edu.ort.arqJava.elOferton.businessEntities.Compra;
import uy.edu.ort.arqJava.elOferton.businessEntities.Empresa;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;
import uy.edu.ort.arqJava.elOferton.businessEntities.Usuario;

/**
 *
 * @author Bruno
 */
public class Repositorio {

    private static Repositorio instance;
    private List<Usuario> usuarios;
    private List<Oferta> ofertas;
    private List<Empresa> empresas;
    private List<Compra> compras;
    private static long id = 1000;
    
    public static long getDBId(){
        return ++id;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    private Repositorio() {
        //usuarios = new ArrayList<>();
        //ofertas = new ArrayList<>();
        //empresas = new ArrayList<>();
        //compras = new ArrayList<>();

        usuarios = UsuariosPrueba();
        empresas = EmpresasPrueba();
        compras = ComprasPrueba();
    }

    public static Repositorio getInscatnce() {
        if (instance == null) {
            instance = new Repositorio();
        }
        return instance;
    }

    private List<Empresa> EmpresasPrueba() {
        List<Empresa> l = new ArrayList<Empresa>();

        Empresa e1 = new Empresa(1, "Hotel Suizo", "0900 1324", "Colonia 1234", "hs@gmail.com");
        Empresa e2 = new Empresa(2, "Clinica de Adelgazamiento", "221196874", "Benito Blanco 1234", "adelgaceya@gmail.com");
        Empresa e3 = new Empresa(3, "Pizzeria pizzaPizza", "0900 1324", "Av Rivera 1234", "pizza@gmail.com");
        Empresa e4 = new Empresa(4, "Clinica de Mayo", "0900 1324", "25 de Mayo 1234", "mayo@gmail.com");
        Empresa e5 = new Empresa(5, "ColoniaExpress", "0900 8888", "Colonia 8234", "coloniaEx@gmail.com");
        Empresa e6 = new Empresa(6, "Masajes Sa", "0900 1888", "San Jose 1234", "masajesSA@gmail.com");
        Empresa e7 = new Empresa(7, "ExtremeSports", "0900 0324", "Ruta 5 Km22", "exSports@gmail.com");
        Empresa e8 = new Empresa(8, "Pittamiglio Entertainments", "0900 2324", "Rambla Argentina 1234", "pitaEnter@gmail.com");
        Empresa e9 = new Empresa(9, "Sushi n go", "0900 1324", "Av Brasil 1234", "sushingo@gmail.com");
        Empresa e10 = new Empresa(10, "Taller laRique", "0900 1324", "Rondeau 1234", "laRique@gmail.com");

        l.add(e1);
        l.add(e2);
        l.add(e3);
        l.add(e4);
        l.add(e5);
        l.add(e6);
        l.add(e7);
        l.add(e8);
        l.add(e9);
        l.add(e10);

        return l;
    }

    private List<Compra> ComprasPrueba() {
        List<Compra> l = new ArrayList<Compra>();

        Compra c1 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c2 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c3 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c4 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c5 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c6 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c7 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c8 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c9 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c10 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c11 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c12 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c13 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c14 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));
        Compra c15 = new Compra(new Date(2013, 10, 17), new Usuario(1),new Oferta(1));

        l.add(c1);
        l.add(c2);
        l.add(c3);
        l.add(c4);
        l.add(c5);
        l.add(c6);
        l.add(c7);
        l.add(c8);
        l.add(c9);
        l.add(c10);
        l.add(c11);
        l.add(c12);
        l.add(c13);
        l.add(c14);
        l.add(c15);

        return l;
    }

    private List<Usuario> UsuariosPrueba() {
        List<Usuario> l = new ArrayList<Usuario>();

        Usuario u1 = new Usuario(1, "lsuarez", "hola1234", "Luis", "lsuarez@auf.com.uy", "Colonia 1234", "Suarez", "11110000");
        Usuario u2 = new Usuario(2, "ecavani", "abc123", "Edinson", "ecavani@edi.com.uy", "Mercedes 1198", "Cavani", "22225555");
        Usuario u3 = new Usuario(3, "fmuslera", "aaa1234", "Fernando", "fmuslera@auf.com.uy", "Yaguaron 1414", "Muslera", "6666 2222");
        Usuario u4 = new Usuario(4, "jfucile", "hola1111", "Jorge", "jfucile@auf.com.uy", "Paullier 1515", "Fucile", "2222 2222");
        Usuario u5 = new Usuario(5, "crodriguez", "cba000", "Walter", "wgargano@inter.com.uy", "Cerrito 2424", "Gargano", "3333 3333");

        l.add(u1);
        l.add(u2);
        l.add(u3);
        l.add(u4);
        l.add(u5);

        return l;
    }
}

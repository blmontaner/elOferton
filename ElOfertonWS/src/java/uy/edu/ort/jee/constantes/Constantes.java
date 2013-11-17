/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.jee.constantes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.joda.time.DateTime;
import uy.edu.ort.arqJava.elOferton.businessEntities.Empresa;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;

/**
 *
 * @author Bruno
 */
public class Constantes {

    public static HashMap<Integer, Oferta> ofertas = new HashMap<>();

    static {
        ofertas.put(0, new Oferta(1, "Escapada para 2", "Escapada para dos a Colonia en el mejor hotel del lugar", 2800.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(), new Empresa(1, "Hotel Suizo", "0900 1324", "Colonia 1234", "hs@gmail.com")));
        ofertas.put(1, new Oferta(2, "Adelgace ahora", "Grupo de adelgazamiento, 30 dias, agelgace 20 kg ahora", 3500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(), new Empresa(2, "Clinica de Adelgazamiento", "221196874", "Benito Blanco 1234", "adelgaceya@gmail.com")));
        ofertas.put(2, new Oferta(3, "Canilla libre de pizza y calzone", "Canilla libre de pizza y calzone a la parrilla para 20 personas $ 3510", 3510.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(), new Empresa(3, "Pizzeria pizzaPizza", "0900 1324", "Av Rivera 1234", "pizza@gmail.com")));
        ofertas.put(3, new Oferta(4, "Ocho sesiones de auriculoterapia", "No te pierdas la oportunidad de cuidar tu cuerpo con un método no invasivo y totalmente efectivo.", 9800.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate() ,new Empresa(4, "Clinica de Mayo", "0900 1324", "25 de Mayo 1234", "mayo@gmail.com")));
         ofertas.put(4, new Oferta(5, "¡Buenos Aires de lujo!", "Escapada para dos a Buenos Aires de lujo all inclusive", 92800.0,new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate() ,new Empresa(5, "ColoniaExpress", "0900 8888", "Colonia 8234", "coloniaEx@gmail.com")));
         ofertas.put(5, new Oferta(6, "Descontracturate ya", "¡Masajes descontracturantes con piedras calientes!", 800.0,new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate() ,new Empresa(6, "Masajes Sa", "0900 1888", "San Jose 1234", "masajesSA@gmail.com")));
         ofertas.put(6, new Oferta(7, "Salto en paracaidas", "Adrenalina desde el cielo: !Salto en paracaídas!", 3850.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(7, "ExtremeSports", "0900 0324", "Ruta 5 Km22", "exSports@gmail.com")));
         ofertas.put(7, new Oferta(8, "Dulce o Truco", "Halloween en el Castillo Pittamiglio: El Castillito Embrujado", 270.0,new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(), new Empresa(8, "Pittamiglio Entertainments", "0900 2324", "Rambla Argentina 1234", "pitaEnter@gmail.com")));
         ofertas.put(8, new Oferta(9, "Sushi para 2", "Deleitate con el exquisito sushi de Umi Sushi &Cuisine de Carrasco", 500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(9, "Sushi n go", "0900 1324", "Av Brasil 1234", "sushingo@gmail.com")));
         ofertas.put(9, new Oferta(10, "Tu auto a full", "$730 en vez de $2800 por recarga de aire de 400 g + chequeo + lavado para auto o camioneta", 2800.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(10, "Taller laRique", "0900 1324", "Rondeau 1234", "laRique@gmail.com")));
         ofertas.put(10, new Oferta(11, "Tu Cabello esplendido", "$790 en vez de $3000 por brushing progresivo u $890 en vez de $3490 con corte incluida en Cayetana", 790.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(11, "Peluqueria Celeste", "0900 1324", "Cno Maldonado 1234", "laPelu@gmail.com")));
         ofertas.put(11, new Oferta(12, "Arregla tu sonrisa", "$5500 en vez de $25000 por colocación de brackets estéticos de porcelana", 5500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(12, "Consultorio Odontológico", "0933 1324", "Mercedes 1234", "dentistas@gmail.com")));
         ofertas.put(12, new Oferta(13, "Arregla tu Pc", "Formataso rapido por los ingenieros mas experimentados del mercado, con un mouse pad de regalo", 1000.0,new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(), new Empresa(13, "Texsis", "0933 1111", "Mercedes 1234", "texis@gmail.com")));
         ofertas.put(13, new Oferta(14, "Pack de Cerveza", "20 latas de cerveza Stelºa Artois 250ml", 500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(14, "Stela Artois Sa", "0933 1324", "Mercedes 1234", "stelaArtois@gmail.com")));
         ofertas.put(14, new Oferta(15, "Luces led", "Carteleria led para tu negocio, auto, lo que quieras empezando por tan solo $1400", 1400.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(14, "Ledstar", "0933 1324", "Mercedes 1234", "ledstar@gmail.com")));
         ofertas.put(15, new Oferta(16, "Led Sony 47 pulgadas", "La mejor Tv al mejor precio Led Sony de 47 pulgadas a solamente $10000", 10000.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(15, "Sony", "0933 1324", "cno sonio 1234", "sony@gmail.com")));
         ofertas.put(16, new Oferta(17, "Tablet Chimichurry", "Directo de china el mejor tablet 2gb de RAM Quad Core Android 4.2 10'", 500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(16, "Chimi CHumi", "0933 1324", "Rondeau 1234", "chimestry@gmail.com")));
         ofertas.put(17, new Oferta(18, "Guitarra les Paul", "Como la que le regalaron al pepe, la mejor guitarra para regalar. Con correa para colgar.", 300.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(17, "Cotinho", "0933 1324", "Uruguay 1234", "coutinho@gmail.com")));
         ofertas.put(18, new Oferta(19, "Piscina Inflable", "Se viene el verano, estas preparado? Piscina de 200 litros para 6 personas. No pases calor!", 9500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(18, "Piscinazo", "0933 1324", "Propios 1234", "musgo@gmail.com")));
         ofertas.put(19, new Oferta(20, "Entrena tu mascota", "Entrenamiento de mascotas, 10 clases de obediencia en veterinaria Perro Rengo", 5500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(19, "veterinaria Perro Rengo", "0933 1324", "Tacuarembo 1234", "perroRengo@gmail.com")));
         ofertas.put(20, new Oferta(21, "Camara Pixar", "Registra tus mejores momentos. Camara Pixar 20 mega pixeles 26X Zoom Sumergible memoria de 64Gb", 2500.0, new DateTime(2013, 11, 1, 0, 0, 0).toDate(), new DateTime(2013, 11, 29, 0, 0, 0).toDate(),new Empresa(20, "Pixar", "0933 1324", "Siracusa 1234", "pixar@gmail.com")));
    }

    private static Oferta getOferta(Integer i) {
        return ofertas.get(i);
    }

    public static List<Oferta> getOfertas() {
        List<Oferta> ofertas = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            ofertas.add(getOferta(/*(int) (Math.random() * 20))*/i));
        }
        return ofertas;
    }
}

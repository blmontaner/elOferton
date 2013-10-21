/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.jee.constantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uy.edu.ort.arqJava.elOferton.businessEntities.Empresa;
import uy.edu.ort.arqJava.elOferton.businessEntities.Oferta;

/**
 *
 * @author Bruno
 */
public class Constantes {

    public static HashMap<Integer, Oferta> ofertas = new HashMap<>();

    static {
        ofertas.put(0, new Oferta(1000, "Escapada para 2", "Escapada para dos a Colonia en el mejor hotel del lugar", 2800.0, new Empresa(1, "Hotel Suizo", "0900 1324", "Colonia 1234", "hs@gmail.com")));
        ofertas.put(1, new Oferta(1001, "Adelgace ahora", "Grupo de adelgazamiento, 30 dias, agelgace 20 kg ahora", 3500.0, new Empresa(2, "Clinica de Adelgazamiento", "221196874", "Benito Blanco 1234", "adelgaceya@gmail.com")));
        ofertas.put(2, new Oferta(1002, "Canilla libre de pizza y calzone a la parrilla para 20", "Canilla libre de pizza y calzone a la parrilla para 20 personas $ 3510", 3510.0, new Empresa(3, "Pizzeria pizzaPizza", "0900 1324", "Av Rivera 1234", "pizza@gmail.com")));
        ofertas.put(3, new Oferta(1003, "Ocho sesiones de auriculoterapia", "No te pierdas la oportunidad de cuidar tu cuerpo con un método no invasivo y totalmente efectivo.", 9800.0, new Empresa(4, "Clinica de Mayo", "0900 1324", "25 de Mayo 1234", "mayo@gmail.com")));
        ofertas.put(4, new Oferta(1004, "¡Buenos Aires de lujo!", "Escapada para dos a Buenos Aires de lujo all inclusive", 92800.0, new Empresa(5, "ColoniaExpress", "0900 8888", "Colonia 8234", "coloniaEx@gmail.com")));
        ofertas.put(5, new Oferta(1005, "Descontracturate ya", "¡Masajes descontracturantes con piedras calientes!", 800.0, new Empresa(6, "Masajes Sa", "0900 1888", "San Jose 1234", "masajesSA@gmail.com")));
        ofertas.put(6, new Oferta(1006, "Salto en paracaidas", "Adrenalina desde el cielo: !Salto en paracaídas!", 3850.0, new Empresa(7, "ExtremeSports", "0900 0324", "Ruta 5 Km22", "exSports@gmail.com")));
        ofertas.put(7, new Oferta(1007, "Dulce o Truco", "Halloween en el Castillo Pittamiglio: El Castillito Embrujado", 270.0, new Empresa(8, "Pittamiglio Entertainments", "0900 2324", "Rambla Argentina 1234", "pitaEnter@gmail.com")));
        ofertas.put(8, new Oferta(1008, "Sushi para 2", "Deleitate con el exquisito sushi de Umi Sushi &Cuisine de Carrasco", 500.0, new Empresa(9, "Sushi n go", "0900 1324", "Av Brasil 1234", "sushingo@gmail.com")));
        ofertas.put(9, new Oferta(1009, "Tu auto a full", "$730 en vez de $2800 por recarga de aire de 400 g + chequeo + lavado para auto o camioneta en Polarizados Windows Films", 2800.0, new Empresa(10, "Taller laRique", "0900 1324", "Rondeau 1234", "laRique@gmail.com")));
        ofertas.put(10, new Oferta(1010, "Tu Cabello esplendido", "$790 en vez de $3000 por brushing progresivo u $890 en vez de $3490 con corte incluida en Cayetana", 790.0, new Empresa(11, "Peluqueria Celeste", "0900 1324", "Cno Maldonado 1234", "laPelu@gmail.com")));
        ofertas.put(11, new Oferta(1011, "Arregla tu sonrrisa", "$5500 en vez de $25000 por colocación de brackets estéticos de porcelana en ambos maxilares en Consultorio Odontológico", 5500.0, new Empresa(12, "Consultorio Odontológico", "0933 1324", "Mercedes 1234", "dentistas@gmail.com")));

    }

    private static Oferta getOferta(Integer i) {
        return ofertas.get(i);
    }

    public static List<Oferta> getOfertas() {
        List<Oferta> ofertas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ofertas.add(getOferta((int) (Math.random() * 11)));
        }
        return ofertas;
    }
}

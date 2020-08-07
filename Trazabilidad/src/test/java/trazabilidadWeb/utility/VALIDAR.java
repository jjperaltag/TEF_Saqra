package trazabilidadWeb.utility;

import java.util.Date;

public class VALIDAR {
    public static void main(String[] args) {
        Date fechaActual = new Date();
        System.out.println("Sub_tostring:" + fechaActual.toString().substring(8, 10));
    }
}
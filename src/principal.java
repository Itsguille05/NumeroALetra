import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int cont=0;
        while(cont<50) {
            // Pedir número y validar que sea entre 1 y 999999
            while (true) {
                System.out.println("Por favor, ingrese un número entre 1 y 999999:");

                // Comprobar si lo ingresado es un número entero
                if (sc.hasNextInt()) {
                    num = sc.nextInt();

                    // Verificar que el número esté en el rango de 1 a 999999
                    if (num >= 0 && num <= 999999) {
                        break; // Si el número es válido, salimos del bucle
                    } else {
                        System.out.println("El número debe estar entre 1 y 999999. Inténtelo de nuevo.");
                    }
                } else {
                    System.out.println("Eso no es un número válido. Inténtelo de nuevo.");
                    sc.next(); // Limpiar el buffer para que no se quede en un estado inválido
                }
            }
            String numeroConCeros = rellenarConCeros(num);
            String valorenLetra = "";

            String parte1 = numeroALetra(Integer.parseInt(numeroConCeros.substring(0, 3)));
            String parte2 = numeroALetra(Integer.parseInt(numeroConCeros.substring(3, 6)));


            if (numeroConCeros.equals("000000")) {
                valorenLetra = "cero";
            } else if (numeroConCeros.equals("001000")) {
                valorenLetra = "mil";
            } else {
                if (parte1.equals("cero"))
                    valorenLetra = parte2;
                else
                    valorenLetra = parte1 + " mil " + parte2;

            }
            System.out.println("Numero en letra es: " + valorenLetra);
            cont++;
        }
        sc.close();

    }

    public static String rellenarConCeros(int num) {
        return String.format("%06d", num);
    }

    public static String numeroALetra(int numero){
        String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        String[] especiales = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
        String[] centenas = {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos",
                "seiscientos", "setecientos", "ochocientos", "novecientos"};

        if (numero == 0) {
            return "cero";
        }

        int centena = numero / 100;
        int resto = numero % 100;
        int decena = resto / 10;
        int unidad = resto % 10;

        String resultado = "";

        if (centena > 0) {
            if (centena == 1 && resto == 0) {
                return "cien";
            }
            resultado += centenas[centena] + " ";
        }

        if (resto >= 10 && resto <= 19) {
            resultado += especiales[resto - 10];
        } else {
            if (decena > 0 && decena != 2) {
                resultado += decenas[decena];

                if (unidad > 0) {
                    resultado += " y ";
                }
            }else{
                if (unidad == 0) {
                    resultado += decenas[decena];
                }
                resultado += "veinti";
            }

            if (unidad > 0) {
                resultado += unidades[unidad]; // Unidades
            }
        }
        return resultado.trim();
    }
}
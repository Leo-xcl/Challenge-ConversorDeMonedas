import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Moneda moneda = null;
        Conversor conversor = new Conversor();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        float valor = 0;
        float resultado = 0;
        String currency = "";
        String signo = "";
        String menu = """
                ************************************************
                [ Bienvenido al conversor de monedas ]
                Sus opciones de conversión son:
                
                1) Dólar -> Peso Argentino
                2) Peso Argentino -> Dólar
                3) Dólar -> Real Brasileño
                4) Real Brasileño -> Dólar
                5) Dólar -> Peso Colombiano
                6) Peso Colombiano -> Dólar
                7) Dólar -> Peso Méxicano
                8) Peso Méxicano -> Dólar
                9) Salir
                ************************************************
       
                """;
        System.out.println(menu);

        while (opcion != 9) {
            System.out.println("Ingresa la operación de conversión a realizar: ");
            opcion = entrada.nextInt();
            try {
                if (opcion == 1) {
                    moneda = conversor.convierteMoneda("USD", "ARS");
                    signo = "$";
                    currency = "Pesos Argentinos";
                }
                else if (opcion == 2) {
                    moneda = conversor.convierteMoneda("ARS", "USD");
                    signo = "$";
                    currency = "Dólares";
                }
                else if (opcion == 3) {
                    moneda = conversor.convierteMoneda("USD", "BRL");
                    signo = "R$";
                    currency = "Reales Brasileños";
                }
                else if (opcion == 4) {
                    moneda = conversor.convierteMoneda("BRL", "USD");
                    signo = "$";
                    currency = "Dólares";
                }
                else if (opcion == 5) {
                    moneda = conversor.convierteMoneda("USD", "COP");
                    signo = "$";
                    currency = "Pesos Colombianos";
                }
                else if (opcion == 6) {
                    moneda = conversor.convierteMoneda("COP", "USD");
                    signo = "$";
                    currency = "Dólares";
                }
                else if (opcion == 7) {
                    moneda = conversor.convierteMoneda("USD", "MXN");
                    signo = "$";
                    currency = "Pesos Méxicanos";
                }
                else if (opcion == 8) {
                    moneda = conversor.convierteMoneda("MXN", "USD");
                    signo = "$";
                    currency = "Dólares";
                }
                else if (opcion == 9) {
                    System.out.println("Saliendo de la aplicacion");
                }
                else{
                    throw new NumberFormatException("Opcion no valida");
                }
                System.out.println(moneda);
                System.out.println("""
                        
                        Ingresa la cantidad a convertir:""");
                valor = entrada.nextFloat();
                resultado = valor * moneda.conversion_rate();
                System.out.println("El valor es de: " + signo + resultado + " " + currency);

            } catch (NumberFormatException e) {
                System.out.println("No se puede realizar la operacion: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Finalizando la aplicación");
    }
}
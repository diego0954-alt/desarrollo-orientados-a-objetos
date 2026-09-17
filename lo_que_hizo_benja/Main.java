package lo_que_hizo_benja;

import java.util.ArrayList;
import java.util.Scanner;

//Estudiante: Benjamin Valenzuela Nelson Albarran
//ASIGNATURA: Programación oriente a objetos
//Evaluación: parcial 1

public class Main {

    public static void main(String[] args) {
        Scanner mn = new Scanner(System.in);

        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();

        double impuesto = leerImpuesto(mn);
        int opcion;

        //Creamos un do junto con un while para poder desplegar en menú en bucle.

        do {
            System.out.println("============================================");
            System.out.println("       AGENCIA DE VIAJES VOYAGETOP");
            System.out.println("============================================");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Mostrar todos los paquetes");
            System.out.println("3. Buscar por destino");
            System.out.println("4. Buscar por destino y tipo");
            System.out.println("5. Contratar seguro (paquete internacional)");
            System.out.println("6. Consultar seguro (paquete internacional)");
            System.out.println("0. Salir");
            System.out.println("============================================");

            opcion = leerEntero(mn, "Seleccione una opción: ");

            //Creamos el switch para poder crear los respectivos case
            //estos ayudaran a que el programa sepa que numero se escoge en cada caso

            switch (opcion) {

                case 1:
                    registrarPaquete(mn, paquetes);
                    break;

                case 2:
                    if (paquetes.isEmpty()) {
                        System.out.println("No hay paquetes registrados.");
                    } else {
                        for (PaqueteTuristico paquete : paquetes) {
                            mostrarPaquete(paquete, impuesto);
                        }
                    }
                    break;

                case 3:
                    String destino = leerTexto(mn, "Ingrese el destino a buscar: ");
                    buscarPaquete(paquetes, destino, impuesto);
                    break;

                case 4:
                    String destinoBusqueda =
                            leerTexto(mn, "Ingrese el destino: ");

                    String tipoBusqueda =
                            leerTexto(mn, "Ingrese el tipo de paquete: ");

                    buscarPaquete(
                            paquetes,
                            destinoBusqueda,
                            tipoBusqueda,
                            impuesto
                    );
                    break;

                case 5:
                    contratarSeguro(mn, paquetes);
                    break;

                case 6:
                    consultarSeguro(mn, paquetes);
                    break;

                case 0:
                    System.out.println("Cerrando programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        mn.close();
    }
    //Hacemos break en casa caso para terminar el proceso correspondiente de cada case.
    //Junto con finalizar se cierra el Scanner.

    public static void registrarPaquete(
            Scanner sc,
            ArrayList<PaqueteTuristico> paquetes) {

        System.out.println("\nREGISTRAR PAQUETE: ");
        String destino = leerTexto(sc, "Destino: ");
        double duracion = leerDoubleNoNegativo(
                sc,
                "Duración en días: "
        );

        System.out.println("\nDATOS DEL PASAJERO:");
        String nombre = leerTexto(
                sc,
                "Nombre completo: "
        );

        String pasaporte = leerTexto(
                sc,
                "Número de pasaporte: "
        );

        String email = leerTexto(
                sc,
                "Correo electrónico: "
        );

        Pasajero pasajero =
                new Pasajero(nombre, pasaporte, email);
        System.out.println("\nTIPO DE PAQUETE:");
        System.out.println("1. Nacional");
        System.out.println("2. Internacional");
        System.out.println("3. Crucero");

        //Creamos una sub clase "registrarPaquete" para poder hacer la validaciones de manera correcta al momento de registrar los datos


        int tipo = leerEntero(sc, "Seleccione el tipo: ");

        switch (tipo) {
            case 1:
                PaqueteNacional nacional =
                        new PaqueteNacional(
                                destino,
                                duracion,
                                pasajero
                        );
                paquetes.add(nacional);
                System.out.println(
                        "Paquete nacional registrado correctamente."
                );
                break;


            case 2:
                boolean primeraClase =
                        leerSiNo(
                                sc,
                                "¿Desea viajar en primera clase? (s/n): "
                        );
                PaqueteInternacional internacional =
                        new PaqueteInternacional(
                                destino,
                                duracion,
                                pasajero,
                                primeraClase
                        );

                paquetes.add(internacional);
                System.out.println(
                        "Paquete internacional registrado correctamente."
                );
                break;

            case 3:

                boolean balcon =
                        leerSiNo(
                                sc,
                                "¿La cabina tiene balcón? (si/no): "
                        );
                PaqueteCrucero crucero =
                        new PaqueteCrucero(
                                destino,
                                duracion,
                                pasajero,
                                balcon
                        );
                paquetes.add(crucero);
                System.out.println(
                        "Paquete crucero registrado correctamente."
                );
                break;

            default:
                System.out.println("Tipo de paquete inválido.");
        }
    }

    //Creamos un switch para registrar los tipos de paquete y de esta manera poder guardarlos en un ArrayList

    public static void mostrarPaquete(
            PaqueteTuristico paquete,
            double impuesto) {
        System.out.println("--------------------------------------------");
        System.out.println("DESTINO: " + paquete.getDestino());
        System.out.println("DURACIÓN: " + paquete.getDuracion() + " días");
        System.out.println("TIPO: " + paquete.getTipo());
        System.out.println("PASAJERO:");
        System.out.println("Nombre: " + paquete.getPasajero().getNombreCompleto());
        System.out.println("Pasaporte: " + paquete.getPasajero().getPasaporte());

        if (paquete instanceof PaqueteInternacional) {
            PaqueteInternacional internacional =
                    (PaqueteInternacional) paquete;

            System.out.println(
                    "Primera clase: " +
                            (internacional.isPrimeraClase() ? "Sí" : "No")
            );

            System.out.println(
                    "Seguro: " +
                            internacional.consultarSeguro()
            );
        }

        if (paquete instanceof PaqueteCrucero) {

            PaqueteCrucero crucero =
                    (PaqueteCrucero) paquete;

            System.out.println(
                    "Cabina con balcón: " +
                            (crucero.isTieneBalcon() ? "Sí" : "No")
            );
        }


        double costo = paquete.calcularCosto();
        double precioFinal =
                paquete.calcularPrecioFinal(impuesto);

        System.out.println("\nCOSTOS:");
        System.out.println(
                "Costo base: $" + costo
        );
        System.out.println(
                "Impuesto: " + impuesto + "%"
        );
        System.out.println(
                "Precio final: $" + precioFinal
        );

        System.out.println("--------------------------------------------");
    }

    //Aca hacemos el calculo del precio para dar un resultado final, usamos "double" en cada caso para obtener un valor mas preciso

    public static void buscarPaquete(
            ArrayList<PaqueteTuristico> paquetes,
            String destino,
            double impuesto) {

        boolean encontrado = false;

        for (PaqueteTuristico paquete : paquetes) {

            if (paquete.getDestino().equalsIgnoreCase(destino)) {

                mostrarPaquete(paquete, impuesto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println(
                    "No se encontraron paquetes para ese destino."
            );
        }
    }

    //Creamos esta sub clase void para que no retorne un valor, dentro usamos un boolean que nos ayuda a saber si ya existe un paquete
    //En caso de que este ya se encontrara "econtrado" pasa a ser "true" y si se da el caso contrario "false"

    public static void buscarPaquete(
            ArrayList<PaqueteTuristico> paquetes,
            String destino,
            String tipo,
            double impuesto) {

        boolean encontrado = false;

        for (PaqueteTuristico paquete : paquetes) {

            if (paquete.getDestino().equalsIgnoreCase(destino)
                    && paquete.getTipo().equalsIgnoreCase(tipo)) {

                mostrarPaquete(paquete, impuesto);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(
                    "No se encontraron paquetes con esos datos."
            );
        }
    }

    public static void contratarSeguro(
            Scanner sc,
            ArrayList<PaqueteTuristico> paquetes) {

        String destino =
                leerTexto(
                        sc,
                        "Ingrese el destino del paquete internacional: "
                );

        for (PaqueteTuristico paquete : paquetes) {

            if (paquete instanceof PaqueteInternacional
                    && paquete.getDestino()
                    .equalsIgnoreCase(destino)) {

                PaqueteInternacional internacional =
                        (PaqueteInternacional) paquete;
                String compania =
                        leerTexto(
                                sc,
                                "Ingrese la compañía de seguros: "
                        );
                internacional.contratarSeguro(compania);

                return;
            }
        }

        System.out.println(
                "No se encontró un paquete internacional con ese destino."
        );
    }

    public static void consultarSeguro(
            Scanner sc,
            ArrayList<PaqueteTuristico> paquetes) {

        String destino =
                leerTexto(
                        sc,
                        "Ingrese el destino del paquete internacional: "
                );

        for (PaqueteTuristico paquete : paquetes) {
            if (paquete instanceof PaqueteInternacional
                    && paquete.getDestino()
                    .equalsIgnoreCase(destino)) {
                PaqueteInternacional internacional =
                        (PaqueteInternacional) paquete;
                System.out.println(
                        internacional.consultarSeguro()
                );
                return;
            }
        }
        System.out.println(
                "No se encontró un paquete internacional con ese destino."
        );
    }

    public static double leerImpuesto(Scanner sc) {
        while (true) {
            try {
                System.out.print(
                        "Ingrese porcentaje de impuesto (0 - 100): "
                );

                double impuesto =
                        Double.parseDouble(sc.nextLine());

                if (impuesto >= 0 && impuesto <= 100) {
                    return impuesto;
                }

                System.out.println(
                        "El impuesto debe estar entre 0 y 100."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                        "Debe ingresar un número válido."
                );
            }
        }
    }


    public static int leerEntero(
            Scanner sc,
            String mensaje) {

        while (true) {
            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        sc.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Debe ingresar un número entero válido."
                );
            }
        }
    }


    public static double leerDoubleNoNegativo(
            Scanner sc,
            String mensaje) {

        while (true) {

            try {
                System.out.print(mensaje);
                double valor =
                        Double.parseDouble(sc.nextLine());

                if (valor >= 0) {
                    return valor;
                }

                System.out.println(
                        "El valor no puede ser negativo."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                        "Debe ingresar un número válido."
                );
            }
        }
    }
    public static String leerTexto(
            Scanner sc,
            String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println(
                    "Este campo no puede quedar vacío."
            );
        }
    }

    public static boolean leerSiNo(
            Scanner sc,
            String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String respuesta =
                    sc.nextLine().trim();

            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            }

            if (respuesta.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println(
                    "Ingrese 's' para sí o 'n' para no."
            );
        }
    }
}
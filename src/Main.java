import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        OutputManager.displayMessage("¡Bienvenido a tu aventura!");

        // Inicializa la historia y cualquier configuración necesaria
        StoryManager.initializeStory();

        // Loop jugable
        boolean juegoEnProgreso = true;
        Scanner scanner = new Scanner(System.in);

        while (juegoEnProgreso) {
            // Muestra la situación actual al jugador y obtén la decisión
            OutputManager.displayMessage("--------------------------------------------------");
            OutputManager.displayMessage("Situación actual:");
            // Puedes mostrar información adicional aquí, como el entorno o inventario del jugador

            String decision = PlayerInput.getPlayerDecision(scanner);

            // Maneja la decisión del jugador
            if ("salir".equalsIgnoreCase(decision)) {
                juegoEnProgreso = false;
                OutputManager.displayMessage("Gracias por jugar. ¡Hasta luego!");
            } else {
                // Procesa la decisión del jugador
                StoryManager.handleDecision(decision);
            }
        }

        scanner.close();
    }
}




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
            // situación actual al jugador
            OutputManager.displayMessage("--------------------------------------------------");
            OutputManager.displayMessage("Situación actual:");
            // ToDo: mostrar entorno del jugador
            
            // ToDo: ofrecer inputs para deciciones
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




import java.util.HashMap;
import java.util.Map;
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

class OutputManager {
    public static void displayMessage(String message) {
        System.out.println(message);
    }
}

class PlayerInput {
    public static String getPlayerDecision(Scanner scanner) {
        // Obtener la decisión del jugador
        return scanner.nextLine().toLowerCase();
    }
    

	public static String ParseCommand(String decision) {
		// TODO Auto-generated method stub
		return null;
	}
}

class StoryManager {
    private static Map<String, String> storyProgression = new HashMap<>();

    public static void initializeStory() {
        // Lee el archivo de texto y carga la historia en el mapa
        loadStoryFromFile("historia.txt");
    }

    private static void loadStoryFromFile(String filePath) {
        try (Scanner scanner = new Scanner(StoryManager.class.getResourceAsStream(filePath))) {
            while (scanner.hasNextLine()) {
                String decision = scanner.nextLine();
                String storyLine = scanner.nextLine();
                storyProgression.put(decision, storyLine);
            }
        } catch (Exception e) {
            OutputManager.displayMessage("Error al cargar la historia desde el archivo: " + e.getMessage());
        }
    }

    public static void handleDecision(String decision) {
        // Analizar y procesar comandos especiales
        String commandTarget = PlayerInput.ParseCommand(decision);

        // Tomar decisiones basadas en comandos especiales o decisiones regulares
        if (commandTarget != null) {
            handleSpecialCommand(commandTarget);
        } else {
            // Lógica para manejar decisiones regulares
            if (storyProgression.containsKey(decision)) {
                OutputManager.displayMessage(storyProgression.get(decision));
            } else {
                OutputManager.displayMessage("¡Ups! Algo salió mal en la historia. Fin del juego.");
                // Puedes manejar esta situación de acuerdo a tus necesidades
            }
        }
    }

    private static void handleSpecialCommand(String commandTarget) {
        // Lógica para manejar comandos especiales, como "agarrar -item-" o "hablar con -persona-"
        // Puedes definir acciones específicas para cada comando especial
    }
}

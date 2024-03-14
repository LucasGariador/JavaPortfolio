import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
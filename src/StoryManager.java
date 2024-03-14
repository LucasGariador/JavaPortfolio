import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum Locations{
	cama,
	ropero,
	puerta,
	sillon,
	ventana
}
enum Actions{
	Inventario,
	Ir,
	Usar
}

class StoryManager {
	public static Locations locations;
	public static String currentLocation;
    private static Map<String, String> storyProgression = new HashMap<>();
    private static Map<String, String> storyDecisions = new HashMap<>();
    private static Map<String, String> storyObjects = new HashMap<>();
    
    public static void initializeStory() {
        // Lee los archivos de texto
        loadStoryFromFile("historia.txt", storyProgression);
        loadStoryFromFile("decisions.txt", storyDecisions);
        loadStoryFromFile("objetos.txt", storyObjects);
    }

    private static void loadStoryFromFile(String filePath, Map<String, String> map) {
        try (Scanner scanner = new Scanner(StoryManager.class.getResourceAsStream(filePath))) {
            while (scanner.hasNextLine()) {
                String decision = scanner.nextLine();
                String storyLine = scanner.nextLine();
                map.put(decision, storyLine);
            }
        } catch (Exception e) {
            OutputManager.displayMessage("Error al cargar la historia desde el archivo: " + e.getMessage());
        }
    }

    public static void handleDecision(String decision) {
        // Inputs
        String commandTarget = PlayerInput.parseCommand(decision);

        if (commandTarget != null) {
            handleSpecialCommand(commandTarget);
        } else {
        	OutputManager.displayMessage("Ingrese un comando");
        }
    }

    private static void handleSpecialCommand(String commandTarget) {
        // Lógica para manejar comandos especiales, como "agarrar -item-" o "hablar con -persona-"
        // Puedes definir acciones específicas para cada comando especial
    }
}
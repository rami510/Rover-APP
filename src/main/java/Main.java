import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Please provide the file path as an argument.");
        }

        String filePath = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read maximum coordinates
            String[] dimensions = br.readLine().trim().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);

            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // Read initial position and direction
                    String[] position = line.trim().split(" ");
                    int x = Integer.parseInt(position[0]);
                    int y = Integer.parseInt(position[1]);
                    char defaultDirection = position[2].charAt(0);

                    // Create a new rover
                    MarsRover rover = new MarsRover(x, y, defaultDirection);

                    // Read instructions
                    String instructions = br.readLine().trim();

                    // Execute instructions
                    rover.executeInstructions(instructions, maxX, maxY);

                    // Display final position
                    System.out.println(rover);

                } catch (InvalidDirectionException | InvalidInstructionException | OutOfBoundsException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        }
    }
}

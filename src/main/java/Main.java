import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            RoverExceptionHandler.handleMissingFilePath();
        }

        String filePath = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read maximum coordinates
            String[] dimensions = br.readLine().trim().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);

            String line;
            while ((line = br.readLine()) != null) {
                // Read initial position and default direction
                String[] position = line.trim().split(" ");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                char defaultDirection = position[2].charAt(0);

                // Read rover instructions
                String instructions = br.readLine().trim();

                // Create a new rover
                MarsRover rover = new MarsRover(x, y, defaultDirection);

                System.out.println(rover);
            }
        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        }
    }
}


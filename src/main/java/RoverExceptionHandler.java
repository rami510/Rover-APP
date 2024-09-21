public class RoverExceptionHandler {

    public static void handleInvalidInstruction(char instruction) {
        throw new IllegalArgumentException("Invalid instruction: " + instruction);
    }

    public static void handleMissingFilePath() {
        throw new IllegalArgumentException("Please provide the file path as an argument.");
    }
}

public class RoverExceptionHandler {
    public static void handleMissingFilePath() {
        throw new IllegalArgumentException("Please provide the file path as an argument.");
    }
}

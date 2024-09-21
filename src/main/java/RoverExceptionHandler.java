// exception for invalid direction
class InvalidDirectionException extends RuntimeException {
    public InvalidDirectionException(char direction) {
        super("Invalid direction: " + direction);
    }
}

// exception for invalid instruction
class InvalidInstructionException extends RuntimeException {
    public InvalidInstructionException(char instruction) {
        super("Invalid instruction: " + instruction);
    }
}

// exception for out-of-bounds movement
class OutOfBoundsException extends RuntimeException {
    public OutOfBoundsException(char direction) {
        super("The rover attempted to move out of bounds in the " + direction + " direction.");
    }
}

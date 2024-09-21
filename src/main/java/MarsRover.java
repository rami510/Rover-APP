public class MarsRover {

    private int x, y;
    private char direction;

    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Turn to the left
    public void turnLeft() {
        switch (this.direction) {
            case RoverConstants.NORTH:
                this.direction = RoverConstants.WEST;
                break;
            case RoverConstants.EAST:
                this.direction = RoverConstants.NORTH;
                break;
            case RoverConstants.SOUTH:
                this.direction = RoverConstants.EAST;
                break;
            case RoverConstants.WEST:
                this.direction = RoverConstants.SOUTH;
                break;
        }
    }

    // Turn to the right
    public void turnRight() {
        switch (this.direction) {
            case RoverConstants.NORTH:
                this.direction = RoverConstants.EAST;
                break;
            case RoverConstants.EAST:
                this.direction = RoverConstants.SOUTH;
                break;
            case RoverConstants.SOUTH:
                this.direction = RoverConstants.WEST;
                break;
            case RoverConstants.WEST:
                this.direction = RoverConstants.NORTH;
                break;
        }
    }

    // Move forward the rover
    public void move(int maxX, int maxY) {
        switch (this.direction) {
            case RoverConstants.NORTH:
                if (y < maxY) y++;
                break;
            case RoverConstants.EAST:
                if (x < maxX) x++;
                break;
            case RoverConstants.SOUTH:
                if (y > 0) y--;
                break;
            case RoverConstants.WEST:
                if (x > 0) x--;
                break;
        }
    }

    public void executeInstructions(String instructions, int maxX, int maxY) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case RoverConstants.LEFT:
                    turnLeft();
                    break;
                case RoverConstants.RIGHT:
                    turnRight();
                    break;
                case RoverConstants.MOVE:
                    move(maxX, maxY);
                    break;
                default:
                    RoverExceptionHandler.handleInvalidInstruction(instruction);
            }
        }
    }


    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}

public class MarsRover {
    private int x, y;
    private char direction;

    public MarsRover(int x, int y, char direction) {
        if (!isValidDirection(direction)) {
            throw new InvalidDirectionException(direction);
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    // Turn left
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
            default:
                throw new InvalidDirectionException(this.direction);
        }
    }

    // Turn right
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
            default:
                throw new InvalidDirectionException(this.direction);
        }
    }

    // Move forward
    public void move(int maxX, int maxY) {
        switch (this.direction) {
            case RoverConstants.NORTH:
                if (y < maxY) y++;
                else throw new OutOfBoundsException(this.direction);
                break;
            case RoverConstants.EAST:
                if (x < maxX) x++;
                else throw new OutOfBoundsException(this.direction);
                break;
            case RoverConstants.SOUTH:
                if (y > 0) y--;
                else throw new OutOfBoundsException(this.direction);
                break;
            case RoverConstants.WEST:
                if (x > 0) x--;
                else throw new OutOfBoundsException(this.direction);
                break;
            default:
                throw new InvalidDirectionException(this.direction);
        }
    }

    // Execute instructions
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
                    throw new InvalidInstructionException(instruction);
            }
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

    // Verify direction
    private boolean isValidDirection(char direction) {
        return direction == RoverConstants.NORTH || direction == RoverConstants.EAST ||
                direction == RoverConstants.SOUTH || direction == RoverConstants.WEST;
    }
}

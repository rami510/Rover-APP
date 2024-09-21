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
            case 'N':
                this.direction = 'W';
                break;
            case 'E':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'E';
                break;
            case 'W':
                this.direction = 'S';
                break;
        }
    }

    // Turn to the right
    public void turnRight() {
        switch (this.direction) {
            case 'N':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'N';
                break;
        }
    }

    // Move forward the rover
    public void move(int maxX, int maxY) {
        switch (this.direction) {
            case 'N':
                if (y < maxY) y++;
                break;
            case 'E':
                if (x < maxX) x++;
                break;
            case 'S':
                if (y > 0) y--;
                break;
            case 'W':
                if (x > 0) x--;
                break;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}

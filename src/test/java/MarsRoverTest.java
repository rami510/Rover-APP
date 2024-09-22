import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarsRoverTest {

    private MarsRover rover;

    @Before
    public void setUp() {
        rover = new MarsRover(1, 2, RoverConstants.NORTH);
    }

    // Test initial position and direction
    @Test
    public void testInitialPosition() {
        assertEquals("Initial X position should be 0", 1, rover.getX());
        assertEquals("Initial Y position should be 0", 2, rover.getY());
        assertEquals("Initial direction should be NORTH", RoverConstants.NORTH, rover.getDirection());
    }

    // Test turning left from NORTH to WEST
    @Test
    public void testTurnLeftFromNorth() {
        rover.turnLeft();
        assertEquals("Direction after turning left from NORTH should be WEST", RoverConstants.WEST, rover.getDirection());
    }

    // Test turning right from NORTH to EAST
    @Test
    public void testTurnRightFromNorth() {
        rover.turnRight();
        assertEquals("Direction after turning right from NORTH should be EAST", RoverConstants.EAST, rover.getDirection());
    }

    // Test moving north
    @Test
    public void testMoveNorth() {
        rover.move(5, 5);
        assertEquals("X position should remain unchanged when moving north", 1, rover.getX());
        assertEquals("Y position should increase by 1 when moving north", 3, rover.getY());
    }

    // Test moving out of bounds exception
    @Test(expected = OutOfBoundsException.class)
    public void testMoveOutOfBounds() {
        rover.move(0, 0); // Rover is at (0,0) and cannot move
    }

    // Test invalid direction exception
    @Test(expected = InvalidDirectionException.class)
    public void testInvalidDirectionException() {
        new MarsRover(0, 0, 'Z'); // 'Z' is not a valid direction
    }

    // Test invalid instruction exception
    @Test(expected = InvalidInstructionException.class)
    public void testInvalidInstructionException() {
        rover.executeInstructions("AX", 5, 5); // 'A' is not a valid instruction
    }

    // Test execution of valid instructions
    @Test
    public void testValidInstructions() {
        rover.executeInstructions("LMLMLMLMM", 5, 5);
        assertEquals("Final X position should be 1", 1, rover.getX());
        assertEquals("Final Y position should be 3", 3, rover.getY());
        assertEquals("Final direction should be NORTH", RoverConstants.NORTH, rover.getDirection());
    }
}

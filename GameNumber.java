// Author: Chris Fietkiewicz
// Starter code for HW #9, problem #2. See instructions.

public class GameNumber {
    private Integer row;    // Row of grid location for this number
    private Integer column; // Column of grid location for this number
    private Integer value;  // Randomly generated number value for display
    
    // Constructor receives preset row, column coordinates.
    // Generates a random display value from 1 to 9.
    // NOTE: Zero values are not used because a 2-D array will be used in the
    // game, and Java automatically creates arrays with zeros by default.
    public GameNumber(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        value = (int) (Math.random() * 9) + 1; // Generate a random display value from 1 to 9
    }
    
    // Getter method
    public Integer getValue() {
        return value;
    }
    
    // Getter method
    public Integer getRow() {
        return row;
    }
    
    // Getter method
    public Integer getColumn() {
        return column;
    }
}

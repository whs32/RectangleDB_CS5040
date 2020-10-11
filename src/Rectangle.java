/**
 * Stub for Rectangle class
 * 
 * @author Lihui Zhang/lihuiz
 * @author Haosu Wang/whaosu
 * @version Oct 2020
 */
public class Rectangle implements Comparable<Rectangle> {
    /* The name of the rectangle*/
    private String name;
    
    /* The x coordinate of the origin. */
    private int coordX;

    /* The y coordinate of the origin. */
    private int coordY;

    /* The horizontal length of the rectangle. */
    private int width;

    /* The vertical length of the rectangle. */
    private int height;

    /**
     * Default
     */
    public Rectangle() {
        this.name = "";
        this.coordX = 0;
        this.coordY = 0;
        this.height = 0;
        this.width = 0;
    }
    /**
     * Construct a rectangle object.
     *
     * @param name   The name of the rectangle
     * @param x      The x coordinate of the origin.
     * @param y      The y coordinate of the origin.
     * @param width  The horizontal length of the rectangle.
     * @param height The vertical length of the rectangle.
     */
    public Rectangle(String name, int x, int y, int width, int height) {
        this.name = name;
        this.coordX = x;
        this.coordY = y;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Construct a rectangle object
     * @param name The name of the rectangle
     */
    public Rectangle(String name) {
        this.name = name;
        this.coordX = 0;
        this.coordY = 0;
        this.height = 0;
        this.width = 0;
    }
    
    /**
     * Getter of the name.
     * 
     * @return name of the rectangle.
     */
    public String getname() {
        return name;
    }
    
    /**
     * Getter of the width data.
     * 
     * @return Width of the rectangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter of the height data.
     * 
     * @return Height of the rectangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter of the x coordinate of the origin.
     * 
     * @return X coordinate of the origin.
     */
    public int getX() {
        return coordX;
    }

    /**
     * Getter of the y coordinate of the origin.
     * 
     * @return Y coordinate of the origin.
     */
    public int getY() {
        return coordY;
    }
    
    /**
     * Basic compare function
     * 
     * @param rhs
     *            rectangle to compare to
     */
    @Override
    public int compareTo(Rectangle rhs) {
        return this.name.compareTo(rhs.getname());
    }
    
    /**
     * toString function
     */
    @Override
    public String toString() {
        return ("(" + this.name + ", " + (int)Math.round(this.coordX)
            + ", " + (int)Math.round(this.coordY) + ", " + (int)Math.round(
                this.width) + ", " + (int)Math.round(this.height) + ")");
    }
    
    /**
     * Check if an rectangle equal to another
     * @param rhs
     *           rectangle to compare to
     * @return true if equals
     */
    public boolean dimequals(Rectangle rhs) {       
        return (this.coordX == rhs.coordX && 
            this.coordY == rhs.coordY && 
            this.height == rhs.height && 
            this.width == rhs.width);
    }
}

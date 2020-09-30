
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
     * Check if a point falls into this rectangle.
     * 
     * @param  x X coordinate of the point.
     * @param  y Y coordinate of the point.
     * 
     * @return   True if the point lies on this canvas.
     */
    public boolean hasPoint(int x, int y) {
        return (x >= getX()) && (x < getX() + getWidth())
                && (y >= getY()) && (y < getY() + getHeight());
    }
    
    /**
     * Basic compare function
     * 
     * @param rhs
     *            rectangle to compare to
     */
    @Override
    public int compareTo(Rectangle rhs) {
        if (rhs == null) {
            throw new IllegalArgumentException("Cant compare to null");
        }

        return this.name.compareTo(rhs.getname());
    }
    
}

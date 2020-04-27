public class Point2d {
    protected double xCoord;
    protected double yCoord;

    public Point2d(double x, double y){
        xCoord = x;
        yCoord = y;
    }

    public Point2d(){
        this(0.0,0.0);
    }

    public double getX(){
        return xCoord;
    }
    public double getY(){
        return yCoord;
    }

    public void setX(double xCoord) {
        this.xCoord = xCoord;
    }
    public void setY(double yCoord) {
        this.yCoord = yCoord;
    }
}

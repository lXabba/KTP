public class Point3d extends Point2d{

    private double zCoord;

    public Point3d(double x, double y, double z){
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d(){
        this(0.0,0.0,0.0);
    }

    public double getZ(){
        return zCoord;
    }

    public void setZ(double zCoord) {
        this.zCoord = zCoord;
    }

    public boolean isEqual(Point3d point){
        if (xCoord==point.getX() && yCoord==point.getY() && zCoord==point.getZ()){
            return true;
        }
        return false;
    }

    public double DistanceTo(Point3d point){
        double res = Math.sqrt(Math.pow((point.getX()-xCoord),2)+Math.pow((point.getY()-yCoord),2)+Math.pow((point.getZ()-zCoord),2));
        res = (double)Math.round(res*100)/100;
        return res;
    }
}

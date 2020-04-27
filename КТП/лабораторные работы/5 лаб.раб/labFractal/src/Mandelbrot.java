import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    public static final int MAX_ITERATIONS = 2000;
    @Override
    public int numIterations(double x, double y) {
        double rez = 0, imz = 0;
        int n = 0;
        while (((rez*rez)+(imz*imz))<4 && n<2000){
            double ri = rez;
            rez = rez*rez - imz * imz + x;
            imz = 2*ri*imz + y;
            n++;
        }
        if (n>=2000) return -1;
        return n;
    }
    public String toString(){
        return "Mandelbrot";
    }
}

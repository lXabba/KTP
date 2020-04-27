import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    private BufferedImage image;
    public JImageDisplay(int width, int height){
        image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        Dimension dimension = new Dimension(width,height);
        super.setPreferredSize(dimension); //ваш компонент будет включен в пользовательский интерфейс, он отобразит на экране все изображение
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null); //нарисовать изображение в компоненте
    }
    public void clearImage (){
        for (int i=0; i<image.getWidth(); i++){
            for (int j=0; j<image.getHeight(); j++){
                image.setRGB(i,j,0);
            }
        }
    }
    public void drawPixel (int x, int y, int rgbColor){
        image.setRGB(x,y,rgbColor);
    }
}

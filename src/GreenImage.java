import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class  GreenImage{


    BufferedImage img = null;
    File f = null;

    public GreenImage() throws IOException {
         System.out.println("test");
        f = new File("E:\\phn pic\\sakib.jpg");
        System.out.println("test1");
        img = ImageIO.read(f);
        System.out.println("test2");
    }

    public void setFilter()
    {

        //get width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //convert to green image

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int g = (p >> 8) & 0xff;

                //set new RGB
                p = (a << 24) | (0 << 16) | (g << 8) | 0;

                img.setRGB(x, y, p);
            }
        }

    }

    public void greenFilter() throws IOException {
        //write image
        f = new File("output.jpg");
        ImageIO.write(img, "jpg", f);
    }


}

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProperties {

    public File [] files;
    public int width;
    public int height;

    public ImageProperties(String folderPath) throws IOException {
        File path = new File(folderPath);

        File [] files = path.listFiles();

        BufferedImage bimg = ImageIO.read(files[0]);
        int width = bimg.getWidth();
        int height = bimg.getHeight();

        this.width = width;
        this.height = height;
        this.files = files;
    }
}
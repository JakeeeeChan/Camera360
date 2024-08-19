import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class CompileImage {

    public CompileImage(String path) throws IOException {
        String folderPath = path + "photos/";

        new SliceImage(path);

        ImageProperties imgp = new ImageProperties(folderPath);
        SliceImage simg = new SliceImage(path);
        File [] files = imgp.files;
        int height = imgp.height;
        int width = simg.sliceWidth * files.length;

        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //testing
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                File f = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");
                BufferedImage bimg = ImageIO.read(f);

                Graphics g = combined.getGraphics();
                g.drawImage(bimg, simg.sliceWidth * i, 0, null);

                g.dispose();

                if (Files.exists(Path.of(path + "/export/"))) {
                    ImageIO.write(combined, "png", new File(path + "/export/EXPORT.png"));
                } else {
                    new File(path + "/export/").mkdirs();
                    ImageIO.write(combined, "png", new File(path + "/export/EXPORT.png"));
                }
            }
        }

    }

    public CompileImage(String path, int sliceWidth) throws IOException {
        String folderPath = path + "photos/";

        ImageProperties imgp = new ImageProperties(folderPath);
        SliceImage simg = new SliceImage(path, sliceWidth);
        File [] files = imgp.files;
        int height = imgp.height;
        int width = sliceWidth * files.length;

        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //testing
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                File f = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");
                BufferedImage bimg = ImageIO.read(f);

                Graphics g = combined.getGraphics();
                g.drawImage(bimg, sliceWidth * i, 0, null);

                g.dispose();

                if (Files.exists(Path.of(path + "/export/"))) {
                    ImageIO.write(combined, "png", new File(path + "/export/EXPORT.png"));
                } else {
                    new File(path + "/export/").mkdirs();
                    ImageIO.write(combined, "png", new File(path + "/export/EXPORT.png"));
                }
            }
        }

    }

    public CompileImage(String path, int sliceWidth, int sliceHeight) throws IOException {
        String folderPath = path + "photos/";

        ImageProperties imgp = new ImageProperties(folderPath);
        new SliceImage(path, sliceWidth, sliceHeight);
        File [] files = imgp.files;
        int width = sliceWidth * files.length;
        System.out.println(width);


        for (int i = 0; i < files.length; i++) {
            if (files[i].getPath().equals("skip")) {
                width -= sliceWidth;
                System.out.println("changed!");
                System.out.println(width);
            }
        }//TODO fix extra blank space in compiled image.

        System.out.println(width);
        BufferedImage combined = new BufferedImage(width, sliceHeight, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < files.length; i++) {
            switch (files[i].getPath().substring(((files[i].getPath().length())) - 4).toLowerCase(Locale.ROOT)) {
                case(".png"), (".jpg"):
                    System.out.println("DONT SKIP ME PLEASE");
                    File f = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");
                    BufferedImage bimg = ImageIO.read(f);

                    Graphics g = combined.getGraphics();
                    g.drawImage(bimg, sliceWidth * i, 0, null);

                    g.dispose();

                    if (Files.exists(Path.of(path + "/export/"))) {
                        ImageIO.write(combined, "png", new File(path + "/export/EXPORT.png"));
                    } else {
                        new File(path + "/export/").mkdirs();
                        ImageIO.write(combined, "png", new File(path + "/export/EXPORT.png"));
                    }
                    break;
                case("skip"):
                    System.out.println("SKIP ME PLEASE");
                    break;
                default:
                    break;
            }
        }

    }
}
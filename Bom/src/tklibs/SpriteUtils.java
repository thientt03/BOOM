package tklibs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by huynq on 5/11/17.
 */
public class SpriteUtils {

    public static BufferedImage loadImage(String fileUrl) {
        try {
            return ImageIO.read(new File(fileUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<BufferedImage> loadImages(String dirUrl){
        ArrayList<BufferedImage> images = new ArrayList<>();
        try {
            String[] fileNames = new File(dirUrl).list();
            Arrays.sort(fileNames);
            for (String fileName :fileNames) {
                if (fileName.toLowerCase().endsWith(".png")) {
                    BufferedImage image = loadImage(dirUrl + "/" + fileName);
                    images.add(image);
                }
            }
        }catch ( Exception ex){
            ex.printStackTrace();
        }
        return images;
    }
    public static BufferedImage scale(BufferedImage sourceImage, int width, int height) {
        Image scaledImage = sourceImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = result.createGraphics();
        g.drawImage(scaledImage, 0, 0, null);
        g.dispose();
        return result;
    }

    public static void main(String[] args) {
        loadImages("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight");
    }

    public static void renderAtCenter(Graphics graphics, BufferedImage image, double x, double y) {
        graphics.drawImage(image, (int)(x - (double)image.getWidth() / 2), (int)(y - (double) image.getHeight() / 2), null);
    }

    public static BufferedImage maskWhite(BufferedImage image) {
        BufferedImage returnImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);
                int alpha = color & 0xFF000000;
                if (alpha != 0) {
                    returnImage.setRGB(x, y, color | 0x00FFFFFF | alpha);
                } else {
                    returnImage.setRGB(x, y, color);
                }
            }
        }

        return returnImage;
    }
}

package game.renderer;
import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Renderer {
    BufferedImage image;
    ArrayList<BufferedImage> images;
    int currentIndex;
    int frameCount;
    boolean isOnce;
    boolean ended;

    public Renderer(BufferedImage image) {
        this.image = image;
        this.currentIndex =0;
        this.frameCount = 0;
    }

    public Renderer() {

    }
    //TODO: 1. upgrade order filName
    //TODO: 2. load image file .png only
    public Renderer(String folderPath){
        images = new ArrayList<>();
        File folder = new File(folderPath);
//        String[] fileNames = folder.list();
        List<String> fileNames = Arrays.asList(folder.list());
        fileNames.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < folder.list().length ; i++) {
            String fileName = fileNames.get(i);
            if (fileName.toLowerCase().endsWith(".png")){
                BufferedImage image = SpriteUtils.loadImage(
                        folderPath + "/" + fileName
                );
                images.add(image);
            }
        }
    }

    public Renderer(String folderPath, boolean isOnce){
        this(folderPath);
        this.isOnce = isOnce;
    }

    public void render(Graphics g, GameObject master){
        // master > position
        if (image != null) {
            // ảnh đơn
            g.drawImage(
                    image,
                    (int) (master.position.x - master.anchor.x * image.getWidth()),
                    (int) (master.position.y - master.anchor.y * image.getHeight()),
                    null
            );
            drawHitBox̣(g, master);
        } else if(images != null) {
            BufferedImage currentImage = images.get(currentIndex);
            g.drawImage(
                    currentImage,
                    (int) (master.position.x - master.anchor.x * currentImage.getWidth()),
                    (int) (master.position.y - master.anchor.y * currentImage.getHeight()),
                    null
            );
            drawHitBox̣(g, master);

            frameCount++;
            if (frameCount > 10){

                currentIndex++;
                if (currentIndex >= images.size()) {
                    if (isOnce){
                        master.deactive();
                    }
                    currentIndex = 0;
                }
                frameCount = 0;
            }
        }
    }

    public void drawHitBox̣(Graphics g, GameObject master) {
        if(master.hitBox != null) {
            g.setColor(Color.CYAN);
            g.drawRect((int)master.hitBox.left(), (int)master.hitBox.top(), master.hitBox.width, master.hitBox.height);
        }
    }
}

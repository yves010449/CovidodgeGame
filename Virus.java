package Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

public class Virus {

    Player player;
    int x;
    int y;
    int movementSpeed;
    int imgSrcNumber = 0;

    
    String path = " ";
    BufferedImage image;

    String[] imgSrc ;

    Virus(int x, int y, int movementSpeed, Player player) {
        this.player = player;
        this.x = x;
        this.y = y;
        this.movementSpeed = movementSpeed;
        setRandomMove();
    }

    public void paintVirus(Graphics g) {    //paints virus 
        getImageSrc(imgSrc[imgSrcNumber]);
        g.drawImage(image, x, y, null);

    }

    public void moveUp() { //moves up
        y -= movementSpeed;
        if (y < -50) {
            setRandomMove();
        }
    }

    public void moveDown() {
        y += movementSpeed;
        if (y > 660) {
            setRandomMove();
        }
    }

    public void moveLeft() {
        x -= movementSpeed;
        if (x < -30) {
            setRandomMove();
        }
    }

    public void moveRight() {
        x += movementSpeed;
        if (x > 950) {
            setRandomMove();
        }
    }

    public void moveTopLeft() { //moving to topleft
        x -= movementSpeed;
        y -= movementSpeed;
        if (y < -50) {
            setRandomMove();
        }
    }

    public void moveTopRight() {
        x += movementSpeed;
        y -= movementSpeed;
        if (y < -50) {
            setRandomMove();
        }
    }

    public void moveBottomLeft() {
        x -= movementSpeed;
        y += movementSpeed;
        if (y > 660) {
            setRandomMove();
        }
    }

    public void moveBottomRight() {
        x += movementSpeed;
        y += movementSpeed;
        if (y > 660) {
            setRandomMove();
        }
    }

    public void setRandomMove() {   //sets a random direction of the virus 
        Random rand = new Random();
        int random = rand.nextInt(8);
        setColor();
        switch (random) {
            case 0:
                path = "up";
                x = player.x + 20;
                y = player.y + 700;
                break;
            case 1:
                path = "down";
                x = player.x + 20;
                y = player.y - 700;
                break;
            case 2:
                path = "left";
                x = player.x + 1000;
                y = player.y + 20;
                break;
            case 3:
                path = "right";
                x = player.x - 1000;
                y = player.y + 20;
                break;
            case 4:
                path = "topLeft";
                x = player.x + 700;
                y = player.y + 700;
                break;
            case 5:
                path = "topRight";
                x = player.x - 700;
                y = player.y + 720;
                break;
            case 6:
                path = "bottomLeft";
                x = player.x + 720;
                y = player.y - 700;
                break;
            case 7:
                path = "bottomRight";
                x = player.x - 720;
                y = player.y - 700;
                break;
            default:
                System.out.println("err");
                break;
        }

    }

    public void setColor() {    //sets the color of virus 
        Random rand = new Random();
        int random = rand.nextInt(5);
        switch (random) {
            case 0:
                imgSrc = new String[]{"src\\Virus\\GreenVirus\\1.png", "src\\Virus\\GreenVirus\\2.png", "src\\Virus\\GreenVirus\\3.png", "src\\Virus\\GreenVirus\\4.png",
                    "src\\Virus\\GreenVirus\\5.png", "src\\Virus\\GreenVirus\\6.png", "src\\Virus\\GreenVirus\\7.png", "src\\Virus\\GreenVirus\\8.png",};
                break;
            case 1:
                imgSrc = new String[]{"src\\Virus\\BlueVirus\\1.png", "src\\Virus\\BlueVirus\\2.png", "src\\Virus\\BlueVirus\\3.png", "src\\Virus\\BlueVirus\\4.png",
                    "src\\Virus\\BlueVirus\\5.png", "src\\Virus\\BlueVirus\\6.png", "src\\Virus\\BlueVirus\\7.png", "src\\Virus\\BlueVirus\\8.png",};
                break;
            case 2:
                imgSrc = new String[]{"src\\Virus\\YellowVirus\\1.png", "src\\Virus\\YellowVirus\\2.png", "src\\Virus\\YellowVirus\\3.png", "src\\Virus\\YellowVirus\\4.png",
                    "src\\Virus\\YellowVirus\\5.png", "src\\Virus\\YellowVirus\\6.png", "src\\Virus\\YellowVirus\\7.png", "src\\Virus\\YellowVirus\\8.png",};
                break;
            case 3:
                imgSrc = new String[]{"src\\Virus\\RedVirus\\1.png", "src\\Virus\\RedVirus\\2.png", "src\\Virus\\RedVirus\\3.png", "src\\Virus\\RedVirus\\4.png",
                    "src\\Virus\\RedVirus\\5.png", "src\\Virus\\RedVirus\\6.png", "src\\Virus\\RedVirus\\7.png", "src\\Virus\\RedVirus\\8.png",};
                break;
            case 4:
                imgSrc = new String[]{"src\\Virus\\Virus\\1.png", "src\\Virus\\Virus\\2.png", "src\\Virus\\Virus\\3.png", "src\\Virus\\Virus\\4.png",
                    "src\\Virus\\Virus\\5.png", "src\\Virus\\Virus\\6.png", "src\\Virus\\Virus\\7.png", "src\\Virus\\Virus\\8.png",};
                break;
            default:
                break;
        }
    }

    public void moveVirus() {   //moves the virus based on setRandomMove()
        virusAnimation();
        switch (path) {
            case "up":
                moveUp();
                break;
            case "down":
                moveDown();
                break;
            case "left":
                moveLeft();
                break;
            case "right":
                moveRight();
                break;
            case "topLeft":
                moveTopLeft();
                break;
            case "topRight":
                moveTopRight();
                break;
            case "bottomLeft":
                moveBottomLeft();
                break;
            case "bottomRight":
                moveBottomRight();
                break;
            default:
                System.out.println("err");
                break;
        }
    }

    public void virusAnimation() {   //virus animation  switchcase for delay
        switch (imgSrcNumber) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                imgSrcNumber++;
                break;
            case 7:
                imgSrcNumber = 0;
                break;
            default:
                break;
        }
    }

    public Rectangle virusHitbox() {    //uses rectangel to create hitbox
        return (new Rectangle(x + 8, y + 8, 35, 35));
    }

    public void checkCollision() { //checks if the virus intersects with player the if it is it makes player collision to true
        if (virusHitbox().intersects(player.playerHitbox())) {
            player.collision = true;
        } else {
            player.collision = false;
        }
    }

    public void getImageSrc(String source) {   //gets the image

        try {
            image = ImageIO.read(new File(source));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

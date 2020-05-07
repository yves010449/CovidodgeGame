package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener {

    final int WIDTH = 1000;
    final int HEIGHT = 730;

    JButton startBtn;
    JButton exitBtn;

    BufferedImage image;
    Player player;
    Virus virus;
    public int delay = 100;
    boolean startGame = false;

    Frame() { //creates Frame

        super.setSize(WIDTH, HEIGHT);
        super.setLocationRelativeTo(null);
        super.setTitle("COVIDODGE");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        super.setResizable(false);
        super.setVisible(true);
        super.createBufferStrategy(3);

        initializeButtons();

    }

    public void initializeButtons() { // creates buttons

        startBtn = new JButton("Start");
        exitBtn = new JButton("Exit");

        startBtn.setIcon(new ImageIcon("src\\Images\\StartButton.png"));
        exitBtn.setIcon(new ImageIcon("src\\Images\\ExitButton.png"));

        startBtn.setBounds(390, 450, 185, 75);
        exitBtn.setBounds(390, 550, 185, 75);

        startBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        super.add(startBtn);
        super.add(exitBtn);

    }

    @Override   //paints the game
    public void paint(Graphics g) {
        if (startGame != true) {    //main menu
            drawMainMenu(g);
        } else {    //game
            drawGame(g);
            player.paintPlayer(g);
            virus.paintVirus(g);
            player.drawScore(g);
            if (player.collision) {
                drawGameOver(g);               
            }
        }
    }

    public void drawMainMenu(Graphics g) {
        getImageSrc("src\\Images\\MainMenuBackGround.png");
        g.drawImage(image, 0, 30, null);

    }

    public void drawGame(Graphics g) {
        getImageSrc("src\\Images\\InGameBG.png");
        g.drawImage(image, 0, 30, null);
    }

    public void drawGameOver(Graphics g) {
        getImageSrc("src\\Images\\GameOver.png");
        g.drawImage(image, 320, 100, null);
    }

    public void getImageSrc(String source) {   //gets image
        try {                                 
            image = ImageIO.read(new File(source));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { //action listener for buttons
        String command = e.getActionCommand();
        if (command.equals("Start")) {
            new Game(this);
            this.dispose();
        }
        if (command.equals("Exit")) {
            System.exit(0);
        }
    }
}

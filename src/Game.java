import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener, ActionListener {

    private int [] snakeXlength = new int [750];
    private int [] snakeYlength = new int [750];
    private int lengthofsnake = 3;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;


    private ImageIcon head;
    private ImageIcon body;
    private ImageIcon cherry;
    private ImageIcon apple;
    private ImageIcon banana;
    private ImageIcon mushroom;
    private ImageIcon titleImage;

    private Timer timer;
    private int delay = 100;
    private int moves = 0;


    public Game()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();


    }

    public void paint(Graphics g) {


        if(moves ==0)
        {
            snakeXlength[2]=50;
            snakeXlength[1]=75;
            snakeXlength[0]=100;

            snakeYlength[2]=100;
            snakeYlength[1]=100;
            snakeYlength[0]=100;

        }

        //title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        //title image
        titleImage = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/SNaketitle.jpg");
        titleImage.paintIcon(this, g, 24, 10);

         //border for the game
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);

        //background for the game
        g.setColor(Color.green);
        g.fillRect(25, 75, 850, 575);

        head = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeHead.jpg");
        head.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);
        for (int a = 0; a < lengthofsnake; a++)
        {
            if(a==0 && right)
            {
                head = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeHead.jpg");
                head.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }
            if(a==0 && left)
            {
                head = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeHead.jpg");
                head.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }
            if(a==0 && up)
            {
                head = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeHead.jpg");
                head.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }
            if(a==0 && down)
            {
                head = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeHead.jpg");
                head.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }
            if (a!=0)
            {
                body = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeBody.jpg");
                body.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);

            }


        }

        body = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/SnakeBody.jpg");
        apple = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/apple.jpg");
        cherry = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/cherry.jpg");
        banana = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/banana.jpg");
        mushroom = new ImageIcon("/Users/iza/Downloads/SnakeGame/Snake/Fotor Batch copy/mushroom.jpg");

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        timer.start();
        if (right)
        {
            for( int r = lengthofsnake-1; r>=0; r--)
            {
                snakeYlength[r+1]=snakeYlength[r];
            }
            for (int r = lengthofsnake; r>=0; r--)
            {
                if (r==0)
                {
                    snakeXlength[r] = snakeXlength[r]+25;
                }
                else
                    {
                        snakeXlength[r] = snakeXlength[r-1];
                    }
                if (snakeXlength[r] >850)
                {
                    snakeXlength[r] = 25;
                }
            }
            repaint();
        }

        if (left)
        {
            for( int r = lengthofsnake-1; r>=0; r--)
            {
                snakeYlength[r+1]=snakeYlength[r];
            }
            for (int r = lengthofsnake; r>=0; r--)
            {
                if (r==0)
                {
                    snakeXlength[r] = snakeXlength[r]-25;
                }
                else
                {
                    snakeXlength[r] = snakeXlength[r-1];
                }
                if (snakeXlength[r] <25)
                {
                    snakeXlength[r] = 850;
                }
            }
            repaint();
        }


        if (down)
        {
            for( int r = lengthofsnake-1; r>=0; r--)
            {
                snakeYlength[r+1]=snakeYlength[r];
            }
            for (int r = lengthofsnake; r>=0; r--)
            {
                if (r==0)
                {
                    snakeXlength[r] = snakeXlength[r]+25;
                }
                else
                {
                    snakeXlength[r] = snakeXlength[r-1];
                }
                if (snakeXlength[r] >625)
                {
                    snakeXlength[r] = 75;
                }
            }
            repaint();
        }
        if (up)
        {
            for( int r = lengthofsnake-1; r>=0; r--)
            {
                snakeXlength[r+1]=snakeXlength[r];
            }
            for (int r = lengthofsnake; r>=0; r--)
            {
                if (r==0)
                {
                    snakeYlength[r] = snakeYlength[r]-25;
                }
                else
                {
                    snakeYlength[r] = snakeYlength[r-1];
                }
                if (snakeYlength[r] <75)
                {
                    snakeYlength[r] = 625;
                }
            }
        }
        repaint();




    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves++;
            right = true;
            if (!left)
            {
                right=true;
            }
            else
            {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves++;
            left = true;
            if (!right)
            {
                left = true;
            }
            else
                {
                    left = false;
                    right = true;
                }
            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            moves++;
            up = true;
            if (!down)
            {
                up=true;
            }
            else
            {
                up = false;
                down = true;
            }
            left= false;
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves++;
            down = true;
            if (!up)
            {
                down=true;
            }
            else
            {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args)
    {
        JPanel frame= new JPanel();
        JFrame obj = new JFrame();
        Game game = new Game();
// creating the window
        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);
        obj.setVisible(true);

//TODO change s into snake

    }
}

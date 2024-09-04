import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private JFrame frame;
    private JButton flipbutton;
    private JLabel resultlabel;
    private ImageIcon heads;
    private ImageIcon tails;
    private ImageIcon buttonicon;
    private Random random;
    private JLabel buttontext;
    private JLabel credits;

    public Main() {
        heads = new ImageIcon(getClass().getResource("/resources/Heads.png"));
        tails = new ImageIcon(getClass().getResource("/resources/Tails.png"));
        buttonicon = new ImageIcon(getClass().getResource("/resources/Button.png"));
        credits = new JLabel();

        frame = new JFrame("Coin Flip");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setMaximumSize(new Dimension(300,300));

        flipbutton = new JButton("");
        flipbutton.setIcon(buttonicon);
        flipbutton.setBorderPainted(false);
        flipbutton.setPreferredSize(new Dimension(100, 90));
        flipbutton.setFocusPainted(false);

        resultlabel = new JLabel(heads);

        random = new Random();
        flipbutton.setLayout(new BorderLayout());
        buttontext = new JLabel("Flip");
        flipbutton.add(buttontext, BorderLayout.CENTER);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x8A8A8A));
        frame.setLayout(new BorderLayout());
        frame.add(flipbutton, BorderLayout.SOUTH);
        frame.add(resultlabel, BorderLayout.CENTER);

        buttontext = new JLabel("Flip Coin");
        buttontext.setHorizontalAlignment(SwingConstants.CENTER);
        buttontext.setFont(new Font("Minecraft", Font.PLAIN, 45));

        credits.setFont(new Font("Minecraft", Font.PLAIN, 30));
        credits.setText("@Xenro45");
        frame.add(credits, BorderLayout.NORTH);


        flipbutton.add(buttontext);

        flipbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipCoin();
            }
        });

        new ButtonEffects(flipbutton);
        frame.setVisible(true);
    }

    private void flipCoin() {
        boolean bool = random.nextBoolean();
        if (bool) {
            resultlabel.setIcon(heads);
        } else {
            resultlabel.setIcon(tails);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}

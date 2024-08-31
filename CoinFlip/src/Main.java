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

        public Main() {
            heads = new ImageIcon(getClass().getResource("/resources/Heads.png"));
            tails = new ImageIcon(getClass().getResource("/resources/Tails.png"));
            buttonicon = new ImageIcon(getClass().getResource("/resources/Button.png"));

            frame = new JFrame("Coin Flip");
            frame.getContentPane().setBackground(new Color(179, 179, 179));
            frame.setPreferredSize(new Dimension(500, 500));
            frame.setMinimumSize(new Dimension(300, 300));
            frame.setMaximumSize(new Dimension(300,300));
            frame.setForeground(new Color(0, 0 ,0));

            flipbutton = new JButton("");
            flipbutton.setIcon(buttonicon);
            flipbutton.setBorderPainted(false);
            flipbutton.setPreferredSize(new Dimension(100, 90));
            flipbutton.setFocusPainted(false);

            resultlabel = new JLabel(heads);


            random = new Random();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(flipbutton, BorderLayout.SOUTH);
            frame.add(resultlabel, BorderLayout.CENTER);


            flipbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flipCoin();
                }
            });

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

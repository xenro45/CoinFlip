    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.Random;
    public class Main {
        private JFrame frame;
        private JButton flipButton;
        private JLabel resultLabel;
        private ImageIcon headsIcon;
        private ImageIcon tailsIcon;
        private ImageIcon buttonIcon;
        private Random random;
        boolean heads = random.nextBoolean();
        private JLabel statusLabel;
        long start = System.currentTimeMillis();

        public Main() {
            headsIcon = new ImageIcon(getClass().getResource("/resources/Heads.png"));
            tailsIcon = new ImageIcon(getClass().getResource("/resources/Tails.png"));
            buttonIcon = new ImageIcon(getClass().getResource("/resources/Button.png"));

            frame = new JFrame("Coin Flip");
            frame.setBackground(new Color(120,120,120));
            frame.setMaximumSize(new Dimension(400, 400));
            frame.setMinimumSize(new Dimension(400, 400));
            frame.setForeground(new Color(120, 120,30));

            flipButton = new JButton(buttonIcon);
            flipButton.setText("");
            flipButton.setBorderPainted(false);
            flipButton.setContentAreaFilled(false);

            statusLabel = new JLabel("Heads");
            statusLabel.setFont(new Font("Courier", Font.CENTER_BASELINE, 50));
            statusLabel.setBackground(new Color(120, 120,120));
            statusLabel.setForeground(new Color(120,120,120));

            resultLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/Heads.png")));
            random = new Random();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(flipButton, BorderLayout.SOUTH);
            frame.add(resultLabel, BorderLayout.CENTER);

            flipButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    flipCoin();
                }
            });

            frame.setVisible(true);
        }


        private void flipCoin() {
            if (heads) {
                resultLabel.setIcon(headsIcon);
            } else {
                resultLabel.setIcon(tailsIcon);
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

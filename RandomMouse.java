import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RandomMouse {

    public void move(int ScreenHeight, int ScreenWidth) {
        new Thread(() -> {
            try {
                Robot robot = new Robot();
                int x = 0;
                int y = 0;
                while (true) {
                    x += 100;
                    y += 100;
                    robot.mouseMove(x % ScreenHeight, y % ScreenWidth);
                    Thread.sleep(7000);  
                }
            } catch (AWTException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Mouse Mover");	
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JButton button = new JButton("Start");
        button.setBounds(150, 200, 200, 50);
        RandomMouse randomMouse = new RandomMouse();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {	
				Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
				int scHeight = screensize.height;
				int scWidth = screensize.width;
				System.out.println("H" + scHeight + "W" + scWidth);
                randomMouse.move(scHeight, scWidth);
            }
        });
        frame.add(button);
        frame.setVisible(true);
    }
}

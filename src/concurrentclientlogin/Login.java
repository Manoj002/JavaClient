package concurrentclientlogin;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    public int login() {
        JFrame f = new JFrame("Login");
        JLabel l1 = new JLabel("");
        l1.setVisible(true);
        JLabel l2 = new JLabel("Enter username");
        JLabel l3 = new JLabel("Enter password");
        JTextField tf1 = new JTextField(10);
        JPasswordField pf2 = new JPasswordField(10);
        JButton b = new JButton("Send");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.add(l1);
        p2.add(l2);
        p2.add(tf1);
        p3.add(l3);
        p3.add(pf2);
        p3.add(b);
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);
        f.add(p3, BorderLayout.SOUTH);
        f.setVisible(true);
        f.setLocation(200, 400);
        f.setSize(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Listen1 ltn = new Listen1(tf1, pf2, l1);
        pf2.addActionListener(ltn);
        b.addActionListener(ltn);
        int ret = 0;
        try {
            String str = ConcurrentClientLogin.br.readLine();
            ret = Integer.parseInt(str);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        f.setVisible(false);
        return ret;
    }
}

package concurrentclientlogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Listen1 implements ActionListener {

    JTextField tf1;
    JPasswordField pf2;
    JLabel l1;

    Listen1(JTextField tf1, JPasswordField pf2, JLabel l1) {
        this.tf1 = tf1;
        this.pf2 = pf2;
        this.l1 = l1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = tf1.getText();
        tf1.setText("");
        char[] str2 = pf2.getPassword();
        pf2.setText("");
        ConcurrentClientLogin.pw.println(str1);
        ConcurrentClientLogin.pw.println(str2);
    }
}

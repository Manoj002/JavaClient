package concurrentclientlogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.io.PrintWriter;

public class L implements ActionListener{
    
    public JTextField tf;
    
    public L(JTextField tf) {
        this.tf = tf;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tf.getText();
        tf.setText("");
        ConcurrentClientLogin.pw.println(str);
    }
}

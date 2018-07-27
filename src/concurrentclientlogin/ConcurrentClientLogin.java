package concurrentclientlogin;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConcurrentClientLogin {
    
    public static BufferedReader br;
    public static PrintWriter pw;
    public static int c;

    public static void main(String[] args) {
        try {
            Socket soc = new Socket("127.0.0.1", 9081);
            JTextArea ta = new JTextArea();
            br = new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                    )
            );
            pw = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    soc.getOutputStream()
                            )
                    ), true
            );
            Login lgn = new Login();
            boolean flag = true;
            while (flag) {
                c = 0;
                for (int i = 0; i < 3; i++) {
                    if (c >= 3) {
                        System.exit(0);
                        break;
                    } else if (lgn.login() == 1) {
                        flag = false;
                        break;
                    } else {
                        c++;
                    }
                }
                if(c >= 3) {
                    System.exit(0);
                }
            }
            Gui(ta);
            String str = br.readLine();
            while(!str.equalsIgnoreCase("end")) {
                ta.append(str + "\n");
                str = br.readLine();
            }
            ta.append("end");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void Gui(JTextArea ta) {
        JFrame f = new JFrame("Client");
        ta.setEditable(false);
        JTextField tf = new JTextField(10);
        JButton b = new JButton("Send");
        JPanel p = new JPanel();
        p.add(tf);
        p.add(b);
        f.add(ta, BorderLayout.CENTER);
        f.add(p, BorderLayout.SOUTH);
        f.setSize(300, 300);
        f.setLocation(100, 100);
        f.setVisible(true);
        L l1 = new L(tf);
        b.addActionListener(l1);
        tf.addActionListener(l1);
    }
}
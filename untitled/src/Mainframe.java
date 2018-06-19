import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainframe extends JFrame {
    private JTextArea jta1 = new JTextArea();
    private  JTextArea jta2 = new JTextArea();
    private  JScrollPane jspL = new JScrollPane(jta1);
    private  JScrollPane jspR = new JScrollPane(jta2);
    private  JPanel jpnC = new JPanel(new GridLayout(4,1,1,1));
    private  Container cp;
    private  JLabel jlb = new JLabel("Password");
    private  JPasswordField jpf = new JPasswordField();
    private  JButton jbtnEncrypt = new JButton("Encrypt");
    private  JButton jbtnExit = new JButton("Exit");
    public  Mainframe(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(1,1));
        cp.add(jspL, BorderLayout.WEST);
        cp.add(jspR, BorderLayout.EAST);
        cp.add(jpnC,BorderLayout.CENTER);

        jspL.setPreferredSize(new Dimension(200,400));
        jspR.setPreferredSize(new Dimension(200,400));
        jpnC.add(jlb);
        jpnC.add(jpf);
        jta2.setLineWrap(true);
        jpnC.add(jbtnEncrypt);
        jpnC.add(jbtnExit);

        jbtnEncrypt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char plainDATA[]=jta1.getText().toCharArray();
                int len = plainDATA.length;
                char cipherData[] =  new char[len];
                char keyData []  = (new String(jpf.getPassword())).toCharArray();
                int keyLen = keyData.length;
                for(int i = 0;i<len;i++){
                    cipherData[i] = (char)((int)plainDATA[i]^(int)keyData[i%keyLen]);
                }
                jta2.setText(new String(cipherData));
            }
        });
        jbtnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}


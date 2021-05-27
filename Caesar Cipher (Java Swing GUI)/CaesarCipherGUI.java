import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class CaesarCipherGUI extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel appTitle, devTag, plainLabel, encLabel, decLabel, encKeyLabel, decKeyLabel, decTextLabel;
    private JButton encrypt, decrypt;
    private JTextField plainField, encField, decField, encKeyField, decKeyField, plainTextField;
    CaesarCipherGUI() {
        this.setTitle("CaesarCipher");
        this.setSize(500, 650);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 121, 234));
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 107, 168));

        appTitle = new JLabel("Caesar Cipher");
        appTitle.setBounds(140, 20, 400, 50);
        appTitle.setBackground(new Color(50, 107, 168));
        appTitle.setForeground(Color.white);
        appTitle.setFont(new Font("Arial", Font.BOLD, 30));
        appTitle.setOpaque(true);
        panel.add(appTitle);

        devTag = new JLabel("Developed By ABU SAYEM", SwingConstants.CENTER);
        devTag.setBounds(95, 65, 300, 30);
        devTag.setBackground(new Color(50, 107, 168));
        devTag.setForeground(Color.white);
        devTag.setFont(new Font("Arial", Font.PLAIN, 12));
        devTag.setOpaque(true);
        panel.add(devTag);

        plainLabel = new JLabel("Plain Text");
        plainLabel.setBounds(85,150,120,30);
        plainLabel.setForeground(Color.white);
        panel.add(plainLabel);

        plainField = new JTextField();
        plainField.setBounds(205,150,200,30);
        plainField.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(plainField);

        encKeyLabel = new JLabel("Encryption Key");
        encKeyLabel.setBounds(85,200,120,30);
        encKeyLabel.setForeground(Color.white);
        panel.add(encKeyLabel);

        encKeyField = new JTextField();
        encKeyField.setBounds(205,200,200,30);
        encKeyField.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(encKeyField);

        encLabel = new JLabel("Encrypted Text");
        encLabel.setBounds(85,250,120,30);
        encLabel.setForeground(Color.white);
        panel.add(encLabel);

        encField = new JTextField();
        encField.setBounds(205,250,200,30);
        encField.setFont(new Font("Arial", Font.BOLD, 20));
        encField.setEditable(false);
        panel.add(encField);

        encrypt = new JButton("Encrypt");
        encrypt.setBounds(85,300,320,30);
        encrypt.setBackground(new Color(168, 30, 60));
        encrypt.setForeground(Color.WHITE);
        encrypt.setFocusable(false);
        encrypt.setBorder(BorderFactory.createEtchedBorder());
        encrypt.addActionListener(this);
        panel.add(encrypt);

        decLabel = new JLabel("Encrypted Text");
        decLabel.setBounds(85,350,120,30);
        decLabel.setForeground(Color.white);
        panel.add(decLabel);

        decField = new JTextField();
        decField.setBounds(205,350,200,30);
        decField.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(decField);

        decKeyLabel = new JLabel("Decryption Key");
        decKeyLabel.setBounds(85,400,120,30);
        decKeyLabel.setForeground(Color.white);
        panel.add(decKeyLabel);

        decKeyField = new JTextField();
        decKeyField.setBounds(205,400,200,30);
        decKeyField.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(decKeyField);

        decTextLabel = new JLabel("Decrypted Text");
        decTextLabel.setBounds(85,450,120,30);
        decTextLabel.setForeground(Color.white);
        panel.add(decTextLabel);

        plainTextField = new JTextField();
        plainTextField.setBounds(205,450,200,30);
        plainTextField.setFont(new Font("Arial", Font.BOLD, 20));
        plainTextField.setEditable(false);
        panel.add(plainTextField);

        decrypt = new JButton("Decrypt");
        decrypt.setBounds(85,500,320,30);
        decrypt.setBackground(new Color(168, 30, 60));
        decrypt.setForeground(Color.WHITE);
        decrypt.setFocusable(false);
        decrypt.setBorder(BorderFactory.createEtchedBorder());
        decrypt.addActionListener(this);
        panel.add(decrypt);

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if(buttonText.equals(encrypt.getText())) {
            String text = plainField.getText();
            CaesarCipher cc = new CaesarCipher();
            String key = encKeyField.getText();
            boolean flag = true;
            for(int i=0; i<key.length(); i++) {
                if(!Character.isDigit(key.charAt(i))) {
                    encKeyField.setText("");
                    JOptionPane.showMessageDialog(null, "Encryption Key Should Only Contain Numaric Values!");
                    flag = false;
                    break;
                }
            }
            if(text.isEmpty() || key.isEmpty()) {
                flag = false;
                encField.setText("");
                JOptionPane.showMessageDialog(null, "Please Fill Up All The Fields!");
            }
            if(flag) {
                text = cc.encrypt(text, Integer.parseInt(key));
                encField.setText(text);
            }
        }else if(buttonText.equals(decrypt.getText())) {
            String text = decField.getText();
            CaesarCipher cc = new CaesarCipher();
            String key = decKeyField.getText();
            boolean flag = true;
            for(int i=0; i<key.length(); i++) {
                if(!Character.isDigit(key.charAt(i))) {
                    decKeyField.setText("");
                    JOptionPane.showMessageDialog(null, "Decryption Key Should Only Contain Numaric Values!");
                    flag = false;
                    break;
                }
            }
            if(text.isEmpty() || key.isEmpty()) {
                flag = false;
                decField.setText("");
                JOptionPane.showMessageDialog(null, "Please Fill Up All The Fields!");
            }
            if(flag) {
                text = cc.decrypt(text, Integer.parseInt(key));
                plainTextField.setText(text);
            }
        }
    }
}

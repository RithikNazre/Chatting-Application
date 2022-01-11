import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.*;
import java.io.*;



public class server extends JFrame implements ActionListener{
	
	JPanel p1;
	JTextField t1;
	JButton b1;
	 static JTextArea a1;
	
	 static ServerSocket skt;
	 static Socket s;
	 static DataInputStream din;
	 static DataOutputStream dout;
	
	server(){
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 70);
		add(p1);
		
		String classLoader;
		ImageIcon i1 =  new ImageIcon(classLoader)).getSystemResource("Chat/src/icons/3.png");
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i1);
		l1.setBounds(5 , 5 , 10 ,10);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon i4 = new ImageIcon(classLoader).getSystemResource("Chat/src/icons/background.jng");
		Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l1.setBounds(5 , 5 , 10 ,10);
		p1.add(l2);
		
		JLabel l3 = new JLabel("Rithik");
		l3.setFont(new Font("SANS_SERIF",Font.PLAIN,18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110, 15, 100, 20);
		p1.add(l3);
		
		a1 = new JTextArea();
		a1.setBounds(5, 65, 350, 530 );
		a1.setEditable(false);
		add(a1);
		
		t1 = new JTextField();
		t1.setBounds(5, 600, 350, 15);
		add(t1);
		
		b1 = new JButton("SEND");
		b1.setBounds(290, 550, 60, 35);
		b1.addActionListener(this);
		add(b1);
		
		
		
		getContentPane().setBackground(Color.GRAY);
		
		
		setLayout(null);
		setSize(500,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String out = t1.getText();
		a1.setText(a1.getText()+"\n\t\t\t"+out);
		t1.setText("");
		
	}
	public static void main(String[] args) {
		new server().setVisible(true);
		
		
		String msginput  = "";
		try {
			skt = new ServerSocket(6001);
			s = skt.accept();
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			msginput = din.readUTF();
			a1.setText(a1.getText()+"\n"+msginput);
		
		}catch(Exception e) {}
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SecondWindow extends JFrame{

	int RED = 17;
	int GREEN = 23;
	int BLUE = 24;

	private JPanel contentPane;
	private  String colores[] = {"Black","Blue","Green","Turquoise","Red","Purple","Yellow","White","Exit"};
	private  Color colores_[] = {
								 new Color(0x000000),new Color(0x408AD2),new Color(0x34E444),
								 new Color(0x35D4A4), new Color(0xFF4040), new Color(0xD636C9),
								 new Color(0xFFEB40), new Color(0xFFFFFF) , new Color(0x797A57)
								 };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondWindow() {
		setTitle("Color led manager.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnCambiarPuertos = new JMenu("Change ports.");
		mnCambiarPuertos.setBackground(Color.WHITE);
		menuBar.add(mnCambiarPuertos);
		
		JMenuItem mntmPuertoLedRojo = new JMenuItem("Change red port.");
		mntmPuertoLedRojo.setBackground(Color.WHITE);
		mntmPuertoLedRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = JOptionPane.showInputDialog("Red port:");
				System.out.println(s);
				try{
					RED = Integer.parseInt(s);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Is not a valid port.");
				}
			}
		});
		mnCambiarPuertos.add(mntmPuertoLedRojo);
		
		JMenuItem mntmPuertoLedVerde = new JMenuItem("Change green port.");
		mntmPuertoLedVerde.setBackground(Color.WHITE);
		mntmPuertoLedVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = JOptionPane.showInputDialog("Green Port:");
				System.out.println(s);
				try{
					GREEN = Integer.parseInt(s);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Is not a valid port.");
				}
			}
		});
		mnCambiarPuertos.add(mntmPuertoLedVerde);
		
		JMenuItem mntmPuertoLedAzul = new JMenuItem("Change blue port.");
		mntmPuertoLedAzul.setBackground(Color.WHITE);
		mntmPuertoLedAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = JOptionPane.showInputDialog("Blue Port:");
				System.out.println(s);
				try{
					BLUE = Integer.parseInt(s);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Is not a valid port.");
				}
			}
		});
		mnCambiarPuertos.add(mntmPuertoLedAzul);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmShowHelp = new JMenuItem("Show help");
		mntmShowHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"No help LOL");
			}
		});
		mnHelp.add(mntmShowHelp);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1);
		GridLayout gbl_panel_1 = new GridLayout(3,3,0,0);
		panel_1.setLayout(gbl_panel_1);
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton boton = (JButton)e.getSource();
				String s = boton.getText();
				try{
					if(s.equalsIgnoreCase(colores[0])){
						black();
					}else if(s.equalsIgnoreCase(colores[1])){
						blue();
					}else if(s.equalsIgnoreCase(colores[2])){
						green();
					}else if(s.equalsIgnoreCase(colores[3])){
						turquoise();
					}else if(s.equalsIgnoreCase(colores[4])){
						red();
					}else if(s.equalsIgnoreCase(colores[5])){
						purple();
					}else if(s.equalsIgnoreCase(colores[6])){
						yellow();
					}else if(s.equalsIgnoreCase(colores[7])){
						white();
					}else{
						off();
					}
				}catch(IOException ex){
					JOptionPane.showMessageDialog(null,"Runtime error: "+ex.getMessage());
				}
			}
		};
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton(colores[i]);
			b.addActionListener(al);
			b.setBorder(new LineBorder(Color.white,0));
			b.setBackground(colores_[i]);
			if(i==0) b.setForeground(Color.WHITE);
			panel_1.add(b);

		}

	}
	/*Apaga ambos leds*/
	//echo 1 > /sys/class/gpio/gpio17/value
	public void black() throws IOException{
		execCommand(0,RED);
		execCommand(0,BLUE);
		execCommand(0,GREEN);
	}

	/*Enciende el led Azul*/
	public void blue() throws IOException{
		black();
		execCommand(1,BLUE);

	}
	/*Enciende el led Verde*/
	public void green() throws IOException {
		black();
		execCommand(1,GREEN);
	}
	/*Enciende el led Rojo*/
	public void red() throws IOException{
		black();
		execCommand(1,RED);
	}
	public void turquoise() throws IOException{
		black();
		execCommand(1,BLUE);
		execCommand(1,GREEN);
	}

	public void purple() throws IOException{
		black();
		execCommand(1,BLUE);
		execCommand(1,RED);
	}
	public void yellow() throws IOException{
		black();
		execCommand(1,RED);
		execCommand(1,GREEN);
	}
	public void white()throws IOException{
		execCommand(1,RED);
		execCommand(1,GREEN);
		execCommand(1,BLUE);
	}
	public void off() throws IOException{
		System.exit(0);
	}
	private void  execCommand(int status, int puerto) throws IOException{
		String command = "echo "+Integer.toString(status)+" > /sys/class/gpio/gpio"+Integer.toString(puerto)+"/value";
		System.out.println(command);
		Runtime.getRuntime().exec(command);
	}

}

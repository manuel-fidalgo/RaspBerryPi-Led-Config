import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SecondWindow extends JFrame {

	final int RED = 17;
	final int GREEN = 23;
	final int BLUE = 24;

	private JPanel contentPane;
	private  String colores[] = {"Negro","Azul","Verde","Turquesa","Rojo","Morado","Amarillo","Blanco","Apagado"};
	private  Color colores_[] = {Color.BLACK,Color.BLUE,Color.GREEN, new Color(93, 193, 185),Color.RED, new Color(207,91,148),Color.YELLOW,Color.WHITE,Color.LIGHT_GRAY};

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1);
		GridLayout gbl_panel_1 = new GridLayout(3,3,0,0);
		panel_1.setLayout(gbl_panel_1);
		//		String colores[] = {"Negro","Azul","Verde","Turquesa","Rojo","Morado","Amarillo","Blanco","Apagado"};
		//		Color colores_[] = {Color.BLACK,Color.BLUE,Color.GREEN, new Color(93, 193, 185),Color.RED, new Color(207,91,148),Color.YELLOW,Color.WHITE,Color.LIGHT_GRAY};
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton boton = (JButton)e.getSource();
				String s = boton.getText();
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
			}
		};
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton(colores[i]);
			b.addActionListener(al);
			b.setBackground(colores_[i]);
			if(i==0) b.setForeground(Color.WHITE);
			panel_1.add(b);

		}

	}
	/*Apaga ambos leds*/
	public void black(){
		System.out.println("Test");
	}
	/*Enciende el led Azul*/
	public void blue(){
		black();

	}
	/*Enciende el led Verde*/
	public void green(){
		black();

	}
	/*Enciende el led Rojo*/
	public void red(){
		black();

	}
	public void turquoise(){
		black();
		blue();
		green();
	}

	public void purple(){
		black();
		red();
		blue();
	}
	public void yellow(){
		black();
		green();
		red();
	}
	public void white(){
		black();
		red();
		green();
		blue();
	}
	public void off(){
		System.exit(0);
	}

}

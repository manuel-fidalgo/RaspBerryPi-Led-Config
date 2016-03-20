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

public class SecondWindow extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel_1 = new JPanel();
		JButton button = new JButton("NULL");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(button);
		this.getContentPane().add(panel_1);
		GridLayout gbl_panel_1 = new GridLayout(3,3,0,0);
		panel_1.setLayout(gbl_panel_1);
		String colores[] = {"Negro","Azul","Verde","Turquesa","Rojo","Morado","Amarillo","Blanco","Apagado"};
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					JButton boton = (JButton)e.getSource();
				 
			}
		};
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton(colores[i]);
			b.setBackground(Color.WHITE);
			panel_1.add(b);
			
		}
		
	}

}

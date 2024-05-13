package contexte;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 26, 104, 19);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2023-2024", "2022-23"}));
		contentPane.add(comboBox);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Changement d'année");
		lblNewJgoodiesLabel.setBounds(10, 7, 134, 19);
		contentPane.add(lblNewJgoodiesLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 55, 144, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(144, 10, 12, 472);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Ajouter une promotion");
		buttonGroup.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 78, 144, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Gestion promotion");
		lblNewJgoodiesLabel_1.setBounds(20, 55, 114, 13);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JButton btnNewButton_1 = new JButton("Modifier une promotion");
		buttonGroup.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(0, 109, 144, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ajouter un élève");
		buttonGroup.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(0, 140, 144, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifier un élève");
		buttonGroup.add(btnNewButton_3);
		btnNewButton_3.setBounds(0, 171, 144, 21);
		contentPane.add(btnNewButton_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 202, 144, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Gestion de la formation");
		lblNewJgoodiesLabel_2.setBounds(10, 202, 156, 19);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JButton btnNewButton_4 = new JButton("Charger une formation");
		buttonGroup.add(btnNewButton_4);
		btnNewButton_4.setBounds(0, 221, 144, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Modifier la formation");
		buttonGroup.add(btnNewButton_5);
		btnNewButton_5.setBounds(0, 252, 144, 21);
		contentPane.add(btnNewButton_5);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 278, 144, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Gestion des notes");
		lblNewJgoodiesLabel_3.setBounds(20, 278, 114, 19);
		contentPane.add(lblNewJgoodiesLabel_3);
		
		JButton btnNewButton_6 = new JButton("Ajouter des notes en lot");
		buttonGroup.add(btnNewButton_6);
		btnNewButton_6.setBounds(0, 301, 144, 21);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Ajouter des notes");
		buttonGroup.add(btnNewButton_7);
		btnNewButton_7.setBounds(0, 332, 144, 21);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Voir les résultats");
		buttonGroup.add(btnNewButton_8);
		btnNewButton_8.setBounds(0, 363, 144, 21);
		contentPane.add(btnNewButton_8);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 394, 144, 2);
		contentPane.add(separator_4);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Gestion des jurys");
		lblNewJgoodiesLabel_4.setBounds(20, 394, 124, 20);
		contentPane.add(lblNewJgoodiesLabel_4);
		
		JButton btnNewButton_9 = new JButton("Generer un PV jury");
		buttonGroup.add(btnNewButton_9);
		btnNewButton_9.setBounds(0, 417, 144, 21);
		contentPane.add(btnNewButton_9);
		
		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("FORMATION ACTUELLE");
		lblNewJgoodiesLabel_5.setBounds(380, 10, 172, 13);
		contentPane.add(lblNewJgoodiesLabel_5);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(437, 33, 23, 337);
		contentPane.add(separator_5);
		
		JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("ETUDIANTS");
		lblNewJgoodiesLabel_6.setBounds(243, 26, 144, 19);
		contentPane.add(lblNewJgoodiesLabel_6);
		
		JLabel lblNewJgoodiesLabel_7 = DefaultComponentFactory.getInstance().createLabel("ANNEE");
		lblNewJgoodiesLabel_7.setBounds(574, 26, 114, 19);
		contentPane.add(lblNewJgoodiesLabel_7);
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            // Ajouter un écouteur de souris à chaque bouton
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Afficher l'info-bulle avec le texte du bouton
                    button.setToolTipText(button.getText());
                    // Changer la couleur du bouton en gris
                    button.setBackground(Color.GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Retirer l'info-bulle
                    button.setToolTipText(null);
                    // Restaurer la couleur d'origine du bouton
                    button.setBackground(null);
                }
            });
        }
	}
}

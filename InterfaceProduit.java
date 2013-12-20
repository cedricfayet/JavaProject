
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class InterfaceProduit extends JFrame {
		private static final long serialVersionUID = 1L;
		
	
		JLabel label_id;
		JLabel label_nom;
		JLabel label_taille;
		JLabel label_prix;
		JTextField field_id;
		JTextField field_nom;
		JList liste_taille;
		JTextField field_prix;
		JButton button_update;
		JButton button_close;
		

		
		public void init() {
			String[] tailles = {"petit", "moyen", "grand"};
			
			label_id = new JLabel("id :");
			label_nom = new JLabel("nom :");
			label_taille = new JLabel("taille :");
			label_prix = new JLabel("prix :");
			field_id = new JTextField("");
			field_nom = new JTextField("");
			liste_taille = new JList(tailles);
			field_prix = new JTextField("");
			button_update = new JButton("Mettre à jour");
			button_close = new JButton("Quitter");;
			
			this.setLayout(new GridLayout(4,2));

			this.getContentPane().add(label_id); this.getContentPane().add(field_id);
			this.getContentPane().add(label_nom); this.getContentPane().add(field_nom);
			this.getContentPane().add(label_taille); this.getContentPane().add(liste_taille);
			this.getContentPane().add(label_prix); this.getContentPane().add(field_prix);
	
			button_update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateFields();
				}
			});
			
			button_close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					close();
				}
			});
			
		}
		
		public void updateFields() {
			int id;
			String nom;
			String taille;
			int prix;
		
			id = Integer.parseInt(field_id.getText());
			nom = field_nom.getText();
			taille = (String)liste_taille.getSelectedValue();
			prix = Integer.parseInt(field_prix.getText());
			
			if(id != 0)
				label_id.setText("id : "+field_id.getText());
			if(nom != null)
				label_nom.setText("nom : "+field_nom.getText());
			if(taille != null)
				label_taille.setText("taille : "+field_id.getText());
			if(prix != 0)
				label_prix.setText("prix : "+field_prix.getText());
			
		}
		
		public void close() {
			System.exit(0);
		}
		
		public InterfaceProduit() {
			super("Produit");
			setSize(400,600);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		
		public static void main(String args[]){
			InterfaceProduit fenetre = new InterfaceProduit();
			fenetre.init();
		}
	}

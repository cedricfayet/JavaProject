

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api_perso.Observable;
import api_perso.Observer;

public class UsersIHM  extends JFrame implements Observer
{
	private static final long serialVersionUID = -6727673912185390639L;

	public UsersIHM()
	{
		this.setTitle("eResto");
	    this.setSize(300, 120);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    JPanel b1 = new JPanel();
	    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
	    b1.add(new JLabel("S'inscrire"));

	    JPanel b2 = new JPanel();
	    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
	    b2.add(new JLabel("adresse e-mail"));
	    b2.add(new JTextField());
	    
	    JPanel b3 = new JPanel();
	    b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
	    b3.add(new JLabel("mot de passe"));
	    b3.add(new JTextField());
	    
	    JPanel b4 = new JPanel();
	    b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
	    b4.add(new JLabel("numéro de téléphone"));
	    b4.add(new JTextField());
	    
	    JPanel b5 = new JPanel();
	    b5.setLayout(new BoxLayout(b5, BoxLayout.LINE_AXIS));
	    b5.add(new JLabel("adresse postale"));
	    b5.add(new JTextField());
	    
	    JPanel main = new JPanel();
	    //On positionne maintenant ces trois lignes en colonne
	    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
	    main.add(b1);
	    main.add(b2);
	    main.add(b3);
	    main.add(b4);
	    main.add(b5);

	    this.getContentPane().add(main);
	    this.setVisible(true);

	}
	
	public static void main(String[] args) 
	{
		new UsersIHM();
	}
	
	@Override
	public void update(Observable o) 
	{
		// TODO Auto-generated method stub
		
	}

}

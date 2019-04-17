package lab2_pradzia;



import java.io.IOException;
import java.io.Serializable;
import view.MainView; 
public class Main implements Serializable{
	/**
	 * 
	 */	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		MainView pagr = new MainView();
		pagr.setVisible(true);
	}
}

package appTest;

import ticTacToe.component.button.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonClickTest {

	public static void main (String [] args) {
		
		MainWindow window = new MainWindow();
		
		Button bLogin = new Button(100,100,50,50);
		window.add(bLogin);
		window.addMouseListener(bLogin.mouseListener());
		window.addMouseMotionListener(bLogin.mouseMotionListener());
		
		Button bCancel = new Button(160,100, 50,50);
		window.add(bCancel);
		window.addMouseListener(bCancel.mouseListener());
		window.addMouseMotionListener(bCancel.mouseMotionListener());
		
		bLogin.addButtonClickListener(event ->{
			System.out.println("você clicou LOGIN");
		});
		
		bCancel.addButtonClickListener(event ->{
			System.out.println("você ciclou CANCEL");
		});
		
		
	}
}

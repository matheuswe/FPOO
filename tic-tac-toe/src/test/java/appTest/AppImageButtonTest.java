package appTest;

import javax.swing.ImageIcon;
import ticTacToe.component.button.ImageButton;
import ticTacToe.gui.MainWindow;

public class AppImageButtonTest {

	 public static void main(String[] args) {

	        MainWindow window = new MainWindow();

	        ImageIcon icon = new ImageIcon("/ticTacToe/images/");

	        ImageButton bImage = new ImageButton(100, 100, 64, 64, icon);
	        window.add(bImage);
	        window.addMouseListener(bImage.mouseListener());
	        window.addMouseMotionListener(bImage.mouseMotionListener());

	        bImage.addButtonClickListener(event -> {
	            System.out.println("Você clicou no botão com imagem!");
	        });
	    }
}

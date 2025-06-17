package appTest;

import java.net.URL;

import javax.swing.ImageIcon;

import ticTacToe.gui.MainWindow;
import ticTacToe.gui.TableView;

public class AppBackgroundTest {
	
	
	static ImageIcon loadImage(String pathWithFileName) {
		
		URL url = AppBackgroundTest.class.getResource(pathWithFileName);
		return new ImageIcon(url);
	}

	public static void main (String [] args) {
		
		final String path = "/ticTacToe/images/";
		
		MainWindow window = new MainWindow();
		URL url = AppBackgroundTest.class.getResource(path + "background.jpg");
		
		ImageIcon icon = loadImage(path + "background.jpg");
		TableView table = new TableView (50,50,200,200,icon);
		window.add(table);
		
		
		
	}
	
}

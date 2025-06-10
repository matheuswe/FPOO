package ticTacToe.component.button;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ImageButton extends Button {

	 private ImageIcon image;

	    public ImageButton() {
	        super();
	    }

	    public ImageButton(int x, int y) {
	        super(x, y);
	    }	

	    public ImageButton(int x, int y, int width, int height, ImageIcon image) {
	        super(x, y, width, height);
	        this.image = image;
	    }

	    public ImageIcon getImage() {
	        return image;
	    }

	    public void setImage(ImageIcon image) {
	        this.image = image;
	    }

	    @Override
	    public void paint(Graphics g) {
	        super.paint(g); 

	        if (image != null) {
	            g.drawImage(image.getImage(),
	            		position.x,
	            		position.y,
	            		dimension.width,
	            		dimension.height,
	            		null
	            );
	        }
	    }
	
}

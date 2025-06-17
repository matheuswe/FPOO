package ticTacToe.gui.score;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.TextButton;
import ticTacToe.model.score.ReadOnlyScoreModel;

public class ScoreView extends AbstractComponent{

	  private ReadOnlyScoreModel scoreModel;
	  private TextButton scoreX;
	  private TextButton scoreO;
	  private ImageIcon background;
	  
	  public ScoreView(int x, int y, int width, int height, ReadOnlyScoreModel scoreModel) {
	        super(x, y, width, height);
	        this.scoreModel = scoreModel;
	        
	        int buttonWidth = width / 2 - 10;
	        int buttonHeight = height - 20;
	        
	        scoreX = new TextButton(x + 5, y + 10, buttonWidth, buttonHeight, "X: 0");
	        scoreO = new TextButton(x + buttonWidth + 15, y + 10, buttonWidth, buttonHeight, "O: 0");


	  }
	  
	  public void setBackground(ImageIcon background) {
	        this.background = background;
	    }

	    @Override
	    public void paint(Graphics g) {
	    	if (scoreModel == null)
	    	    throw new RuntimeException("Error: ScoreModel is null at ScoreView!");
	    	
	        if (background != null) {
	            g.drawImage(background.getImage(),
	            		position.x, position.y,
	            		width(), height(), null);
	        }

	        scoreX.setText("X: " + scoreModel.scoreX());
	        scoreO.setText("O: " + scoreModel.scoreO());

	        scoreX.paint(g);
	        scoreO.paint(g);
	    }
}

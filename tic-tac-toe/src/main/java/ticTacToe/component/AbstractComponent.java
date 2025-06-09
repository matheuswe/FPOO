package ticTacToe.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import ticTacToe.gui.Paintable;

public class AbstractComponent implements Paintable {

	
	protected void onMouseClick (MouseEvent me) {
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	protected Point 	position 	= null;
	protected Dimension dimension = null;
	
	
}

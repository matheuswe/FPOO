package ticTacToe.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import ticTacToe.gui.Paintable;

public class AbstractComponent implements Paintable {
	
	
	protected boolean mouseOver = false;

	public MouseMotionListener mouseMotionListener() {
		
		
		//	return (MouseMotionListener) new MouseMotionAdapter() {
			return new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent me) {
					
					boolean isInside = isOver(me.getPoint());
				    if (mouseOver != isInside) {
				        mouseOver = isInside;
				    }
					
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			};
		}
	
	protected boolean isOver (Point point) {
		
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int xRight = xLeft + this.width();
		int yBotton = yTop + this.height();
		
		return ((point.x > xLeft && point.x < xRight) &&
				point.y	> yTop && point.y < yBotton);
	}

	
	protected void onMouseClick (MouseEvent me) {
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	protected Point 	position 	= null;
	protected Dimension dimension = null;
	
	public AbstractComponent (){
		
		this.position  = new Point(0,0);
		this.dimension = new Dimension(20,20);
	}
	
	public AbstractComponent(int x, int y) {
		this();
		setPosition(x,y);		//or position = new Point (x, y);
	}
	
	public AbstractComponent (int x, int y, int width, int height) {
		this(x,y);
		setSize(width, height); //or dimension = new Dimension (width, height)
	}
	
	public void setPosition(int x, int y) {
		this.position = new Point (x, y);
	}
	
	public Point getPosition() {
		return (Point) this.position.clone();
	}
	
	public void setSize(int width, int height) {
		this.dimension = new Dimension(width, height);
	}

	public Dimension getSize() {
		return (Dimension) this.dimension.clone();
	}
	
	public int width() {
		return this.dimension.width;
	}
	
	public int height() {
		return this.dimension.height;
	}
	
}

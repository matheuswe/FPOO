package ticTacToe.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

import ticTacToe.component.button.Button.ButtonClickEvent.MouseButton;
import ticTacToe.gui.Paintable;
import ticTacToe.gui.util.MouseListenerAdapter;

public class Button  implements Paintable{
	
	
	public boolean isOver (Point point) {
		
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int xRight = xLeft + this.width();
		int yBotton = yTop + this.height();
		
		return ((point.x > xLeft && point.x < xRight) &&
				point.y	> yTop && point.y < yBotton);
	}
	
	public MouseListener mouseListener() {
		
		return new MouseListenerAdapter() {
			
			@Override
			public void mouseClicked (MouseEvent me) {
				
				if (!isOver (me.getPoint() ))
					return;
				System.out.println("Olá!");
//				onMouseClick(me);
	
			}
		};
	}
	
	private boolean mouseOver = false;
	
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
	
//	@Override	
//	protected void onMouseClick(MouseEvent me) {
//		dispatchButtonClickEvent(me);
		
//	}

	private Point 	position 	= null;
	private Dimension dimension = null;
	
	public Button (){
		
		this.position  = new Point(0,0);
		this.dimension = new Dimension(20,20);
	}
	
	public Button(int x, int y) {
		this();
		setPosition(x,y);		//or position = new Point (x, y);
	}
	
	public Button (int x, int y, int width, int height) {
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
	
	@Override
	public void paint (Graphics g) {
		
		g.drawRect(position.x, position.y,
					dimension.width, dimension.height);	
		
		if (mouseOver ){
			
	        Color original = g.getColor();

	        g.setColor(Color.RED);
	        g.drawRect(position.x + 2, position.y + 2,
	                   dimension.width - 4, dimension.height - 4); 

	        g.setColor(original);
	    }
	}
	
	public final class ButtonClickEvent{
		
		public static enum MouseButton{LEFT, MIDLE, RIGHT};
		
		public final Button source;
		
		public final MouseButton mouseButton;
		
		public ButtonClickEvent(Button source, MouseButton mouseButton) {

			this.source = source;
			this.mouseButton = mouseButton;
		}
	}
		@FunctionalInterface
	public interface ButtonClickListener {
		void onClick (ButtonClickEvent e);
	}
	
		//Observer Pattern
		
		Set <ButtonClickListener> buttonClickListeners = new HashSet<>();
		
		public void addButtonClickListener (ButtonClickListener listener) {
			buttonClickListeners.add(listener);
		}
		
		public void removeButtonClickListener (ButtonClickListener listener) {
			buttonClickListeners.remove(listener);
			
		}
		private void dispatchButtonClickEvent (MouseEvent me) {
			
			MouseButton button = ((me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT :
									(me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDLE : 
										MouseButton.RIGHT);
			
			ButtonClickEvent event = new ButtonClickEvent(this, button);
			buttonClickListeners.forEach(listener -> listener.onClick(event));
			
		}
}

package ticTacToe.component.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.Button.ButtonClickEvent.MouseButton;
import ticTacToe.gui.util.MouseListenerAdapter;

public class Button  extends AbstractComponent{
	
	
	public Button() {
        super(); 
    }

    public Button(int x, int y) {
        super(x, y); 
    }

    public Button(int x, int y, int width, int height) {
        super(x, y, width, height); 
    }
	
	public MouseListener mouseListener() {
		
		return new MouseListenerAdapter() {
			
			@Override
			public void mouseClicked (MouseEvent me) {
				
				if (!isOver (me.getPoint() ))
					return;
				System.out.println("Olá!");
				onMouseClick(me);
	
			}
		};
	}
	
	
	@Override	
	protected void onMouseClick(MouseEvent me) {
		dispatchButtonClickEvent(me);
		
	}

	@Override
	public void paint (Graphics g) {
		
		g.drawRect(super.position.x, super.position.y,
					super.dimension.width, super.dimension.height);	
		
		if (super.mouseOver ){
			
			doMouseOverDecoration(g);
	    }
	}
	private void doMouseOverDecoration(Graphics g) {
		
	    Color original = g.getColor();

	    g.setColor(Color.RED);
	    g.drawRect(super.position.x + 2, super.position.y + 2,
	    		super.dimension.width - 4, super.dimension.height - 4);

	    g.setColor(original);
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

package ticTacToe.gui.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public abstract class MouseMotionAdapter implements MouseMotionListener {

    @Override
    public void mouseMoved(MouseEvent e) {
        // Sobrescreva onde precisar
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Pode deixar vazio se não for necessário
    }
}

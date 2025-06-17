package ticTacToe.model.table;

import ticTacToe.model.Mark;

public interface ReadOnlyTableModel {

	Mark getMark (int link, int col);
}

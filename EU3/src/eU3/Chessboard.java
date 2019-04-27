package eU3;

import java.util.Random;

public class Chessboard 
{
	public static class Field
	{
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;

		public Field(char row, byte column)
		{
			this.row = row;
			this.column = column;
		}

		public void put (Chesspiece piece)
		{
			this.piece = piece;
		}

		public Chesspiece take()
		{
			this.piece = null;
			return null;
		}

		public void mark()
		{
			this.marked = true;
		}

		public void unmark()
		{
			this.marked = false;
		}

		public String toString()
		{
			String s = (marked) ? "xx" : "--";
			return (piece == null) ? s : piece.toString();
		}
	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;

	private Field[][] fields;

	public Chessboard()
	{
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;

		byte column = 0;
		
		for(int r = 0; r < NUMBER_OF_ROWS; r++)
		{
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for(int c = 0; c < NUMBER_OF_COLUMNS; c++)
			{
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("    1  2  3  4  5  6  7  8\n");
		for(int i = 0; i < 8; i++)
		{
			sb.append((char) (i + FIRST_ROW) + " ");
			for(int i2 = 0; i2 < 8; i2++)
			{
				sb.append(" " + fields[i][i2]);
				if(i2 == 7)
				{
					sb.append("\n");
				}
			}
		}
		return sb.toString();
	}

	public boolean isValidField(char row, byte column)
	{
		if(row >= 97 && row <= 104 && column <= 7 && column >= 0)
		{
			return true;
		}
		return false;
	}

	public abstract class Chesspiece
	{
		private char color; // w - white, b - black
		private char name; // K - King, Q - Queen, R - Rock, B - Bishop, N - Knight, P - Pawn
		protected char row;
		protected byte column;

		protected Chesspiece(char color, char name)
		{
			this.color = color;
			this.name = name;
			this.column = (byte) (new Random().nextInt(8) + 1);
			this.row = (char) (new Random().nextInt(8) + 97);
		}

		public String toString()
		{
			return "" + color + name;
		}

		public boolean isOnBoard()
		{
			return Chessboard.this.isValidField(row, column);
		}

		public void moveTo (char row, byte column) throws NotValidFieldException
		{
			if (!Chessboard.this.isValidField(row, column)) 
			{
				throw new NotValidFieldException("bad field: " + row + column);
			}

			this.row = row;
			this.column = column;

			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			Chessboard.this.fields[r][c].put(this);
		}

		public void moveOut()
		{
			if(isOnBoard())
			{
				Chessboard.this.fields[row - FIRST_ROW][column].take();
			}
		}

		public abstract void markReachableFields();

		public abstract void unmarkReachableFields();
	}

	public class Pawn extends Chesspiece
	{
		public Pawn(char color, char namn)
		{
			super(color, namn);
		}

		public void markReachableFields()
		{
			byte    col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row -FIRST_ROW;
				int c = col -FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark ();
			}
		}

		public void unmarkReachableFields()
		{
			byte    col = (byte) (column + 1);
			if (Chessboard.this.isValidField (row, col))
			{
				int r = row -FIRST_ROW;
				int c = col -FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark ();
			}
		}
	}

	public class Rook extends Chesspiece {

		public Rook(char color, char name) {
			super(color, name);
		}

		public void markReachableFields()
		{
			for(int i = 0; i <= ('h' - FIRST_ROW); i++)
			{
				if (Chessboard.this.isValidField(row, (byte) i))
				{
					Chessboard.this.fields[row - FIRST_ROW][(byte) i].mark();
				}
			}
			
			for(int i2 = 0; i2 < 8; i2++)
			{
				if (Chessboard.this.isValidField((char) (FIRST_ROW + i2), this.column))
				{
					Chessboard.this.fields[i2][this.column].mark();
				}
			}
		}

		public void unmarkReachableFields()
		{
			for(int i = 0; i <= 7; i++)
			{
				if (Chessboard.this.isValidField(row, (byte) i))
				{
					Chessboard.this.fields[row - FIRST_ROW][(byte) i].unmark();
				}
			}

			for(int i2 = 0; i2 < 8; i2++)
			{
				if (Chessboard.this.isValidField((char) (FIRST_ROW + i2), this.column))
				{
					Chessboard.this.fields[i2][this.column].unmark();
				}
			}		
		}
	}

	public class Knight extends Chesspiece {

		public Knight(char color, char name) {
			super(color, name);
		}
		
		int[] x = {1, 2, 2, 1, -1, -2, -2, -1, 1, 2};

		public void markReachableFields()
		{
			for (int i = 0; i < 8; i++) {
	             if (Chessboard.this.isValidField((char) (row + x[i]), (byte) (column + x[i+2]))) {
	                 int r = (char) (row + x[i]) - FIRST_ROW;
	                 int c = (byte) (column + x[i+2]);
	                 Chessboard.this.fields[r][c].mark();
	            }
			}
		}

		public void unmarkReachableFields()
		{
			for (int i = 0; i < 8; i++) {
	             if (Chessboard.this.isValidField((char) (row + x[i]), (byte) (column + x[i+2]))) {
	                 int r = (char) (row + x[i]) - FIRST_ROW;
	                 int c = (byte) (column + x[i+2]);
	                 Chessboard.this.fields[r][c].unmark();
	            }
			}
		}
	}

	public class Bishop extends Chesspiece {

		public Bishop(char color, char name) {
			super(color, name);
		}
		
		public void markReachableFields()
		{
			
			byte col1 = (byte) (column - row + FIRST_ROW);

			for (int i = 0; i < 8; i++) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col1 + i))) {
	            	 int markedCol = col1 + i;
	            	 Chessboard.this.fields[i][markedCol].mark();
	             }
			}
			
			byte col2 = (byte) (column - 'h' + row);
			
			for (int i = 8; i > -1; i--) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col2 + (7-i)))) {
	            	 int markedCol = col2 + (7-i);
	            	 Chessboard.this.fields[i][markedCol].mark();
	             }
			}	
		}

		public void unmarkReachableFields()
		{
			byte col1 = (byte) (column - row + FIRST_ROW);

			for (int i = 0; i < 8; i++) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col1 + i))) {
	            	 int markedCol = col1 + i;
	            	 Chessboard.this.fields[i][markedCol].unmark();
	             }
			}
			
			byte col2 = (byte) (column - 'h' + row);
			
			for (int i = 8; i > -1; i--) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col2 + (7-i)))) {
	            	 int markedCol = col2 + (7-i);
	            	 Chessboard.this.fields[i][markedCol].unmark();
	             }
			}
		}	
	}

	public class Queen extends Chesspiece {

		public Queen(char color, char name) {
			super(color, name);
		}

		public void markReachableFields()
		{
			for(int i = 0; i <= ('h' - FIRST_ROW); i++)
			{
				if (Chessboard.this.isValidField(row, (byte) i))
				{
					Chessboard.this.fields[row - FIRST_ROW][(byte) i].mark();
				}
			}

			for(int i2 = 0; i2 < 8; i2++)
			{
				if (Chessboard.this.isValidField((char) (FIRST_ROW + i2), this.column))
				{
					Chessboard.this.fields[i2][this.column].mark();
				}
			}

			byte col1 = (byte) (column - row + FIRST_ROW);

			for (int i = 0; i < 8; i++) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col1 + i))) {
	            	 int markedCol = col1 + i;
	            	 Chessboard.this.fields[i][markedCol].mark();
	             }
			}
			
			byte col2 = (byte) (column - 'h' + row);
			
			for (int i = 8; i > -1; i--) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col2 + (7-i)))) {
	            	 int markedCol = col2 + (7-i);
	            	 Chessboard.this.fields[i][markedCol].mark();
	             }
			}
			
		}

		public void unmarkReachableFields()
		{
			for(int i = 0; i <= ('h' - FIRST_ROW); i++)
			{
				if (Chessboard.this.isValidField(row, (byte) i))
				{
					Chessboard.this.fields[row - FIRST_ROW][(byte) i].unmark();
				}
			}

			for(int i2 = 0; i2 < 8; i2++)
			{
				if (Chessboard.this.isValidField((char) (FIRST_ROW + i2), this.column))
				{
					Chessboard.this.fields[i2][this.column].unmark();
				}
			}		
			
			byte col1 = (byte) (column - row + FIRST_ROW);

			for (int i = 0; i < 8; i++) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col1 + i))) {
	            	 int markedCol = col1 + i;
	            	 Chessboard.this.fields[i][markedCol].unmark();
	             }
			}
			
			byte col2 = (byte) (column - 'h' + row);
			
			for (int i = 8; i > -1; i--) {
	             if (Chessboard.this.isValidField((char) (FIRST_ROW + i), (byte) (col2 + (7-i)))) {
	            	 int markedCol = col2 + (7-i);
	            	 Chessboard.this.fields[i][markedCol].unmark();
	             }
			}	
		}
	}

	public class King extends Chesspiece {

		public King(char color, char name) {
			super(color, name);
		}

		 int[] w = {0, 1, 1, 1, 0, -1, -1, -1, 0, 1};
		
		public void markReachableFields()
		{
			for (int i = 0; i < 8; i++) {
                if (Chessboard.this.isValidField((char) (row + w[i]), (byte) (column + w[i + 2]))) {
                    int r = (char) (row + w[i]) - FIRST_ROW;
                    int c = (byte) (column + w[i + 2]);
                    Chessboard.this.fields[r][c].mark();
                }
            }
		}

		public void unmarkReachableFields()
		{
			for (int i = 0; i < 8; i++) {
                if (Chessboard.this.isValidField((char) (row + w[i]), (byte) (column + w[i + 2]))) {
                    int r = (char) (row + w[i]) - FIRST_ROW;
                    int c = (byte) (column + w[i + 2]);
                    Chessboard.this.fields[r][c].unmark();
                }
            }
		}
	}
}
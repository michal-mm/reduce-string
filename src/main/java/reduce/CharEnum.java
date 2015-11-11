package reduce;

public enum CharEnum {
	CHAR_A('A'), CHAR_B('B'), CHAR_C('C');
	
	private char character;
	
	CharEnum (char c) {
		character = c;
	}
	
	public char getCharacter() {
		return character;
	}
}

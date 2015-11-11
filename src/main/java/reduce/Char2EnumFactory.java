package reduce;

public class Char2EnumFactory {

	public static CharEnum getCharEnum (char c) {
		CharEnum ce = null;
		
		switch (c) {
		case 'A':
			ce = CharEnum.CHAR_A;
			break;
		case 'B':
			ce = CharEnum.CHAR_B;
			break;
		case 'C':
			ce = CharEnum.CHAR_C;
			break;
		}
		
		return ce;
	}
}

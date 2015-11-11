package reduce;

/**
 * Created by michal on 03.08.15.
 */
public class Reduction {

    public String solution (String S) {
        char[] chars = S.toCharArray();

        CharState cs;
        cs = getCharState(Char2EnumFactory.getCharEnum(chars[0]));

        for (int i=1; i<chars.length; i++) {
            cs = cs.next(Char2EnumFactory.getCharEnum(chars[i]));
        }

        return cs.getBufferAsString();
    }

    private CharState getCharState(CharEnum charEnum) {
        CharState cs = null;
        switch (charEnum) {
            case CHAR_A:
                cs = new CharStateA(new StringBuffer("A"));
                break;
            case CHAR_B:
                cs = new CharStateB(new StringBuffer());
                break;
            case CHAR_C:
                cs = new CharStateC(new StringBuffer("C"));
                break;
        }
        return cs;
    }
}

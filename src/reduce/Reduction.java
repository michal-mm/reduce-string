package reduce;

/**
 * Created by michal on 03.08.15.
 */
public class Reduction {

    public String solution (String S) {
        char[] chars = S.toCharArray();

        CharState cs;
        cs = getCharState(chars[0]);

        for (int i=1; i<chars.length; i++) {
            cs = cs.next(chars[i]);
        }

        return cs.getBufferAsString();
    }

    private CharState getCharState(char aChar) {
        CharState cs = null;
        switch (aChar) {
            case 'A':
                cs = new CharStateA(new StringBuffer("A"));
                break;
            case 'B':
                cs = new CharStateB(new StringBuffer());
                break;
            case 'C':
                cs = new CharStateC(new StringBuffer("C"));
                break;
        }
        return cs;
    }
}

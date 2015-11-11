package reduce;

/**
 * Created by michal on 03.08.15.
 */
abstract public class CharState {

    StringBuffer currentBuffer;

    public CharState (StringBuffer buffer) {
        currentBuffer = buffer;
    }

    public CharState next (CharEnum charEnum) {
        CharState nextCharState = null;

        switch (charEnum) {
            case CHAR_A:
                nextCharState = handleA();
                break;

            case CHAR_B:
                nextCharState = handleB();
                break;

            case CHAR_C:
                nextCharState = handleC();
                break;
        }

        return nextCharState;
    }

    abstract public CharState handleA();
    abstract public CharState handleB();
    abstract public CharState handleC();

    public String getBufferAsString(){
        return currentBuffer.toString();
    }
}

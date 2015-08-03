package reduce;

/**
 * Created by michal on 03.08.15.
 */
abstract public class CharState {

    StringBuffer currentBuffer;

    public CharState (StringBuffer buffer) {
        currentBuffer = buffer;
    }

    public CharState next (char c) {
        CharState nextCharState = null;

        switch (c) {
            case 'A':
                nextCharState = handleA();
                break;

            case 'B':
                nextCharState = handleB();
                break;

            case 'C':
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

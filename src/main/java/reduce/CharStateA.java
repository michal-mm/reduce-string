package reduce;

/**
 * Created by michal on 03.08.15.
 */
public class CharStateA extends CharState {

    public CharStateA(StringBuffer buffer) {
        super(buffer);
    }

    @Override
    public CharState handleA() {
        return new CharStateA(this.currentBuffer);
    }

    @Override
    public CharState handleB() {
        return new CharStateA(this.currentBuffer);
    }

    @Override
    public CharState handleC() {
        return new CharStateC(this.currentBuffer.append('C'));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CharStateA) {
            return true;
        } else {
            return false;
        }
    }
}

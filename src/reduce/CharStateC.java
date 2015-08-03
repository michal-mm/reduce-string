package reduce;

/**
 * Created by michal on 03.08.15.
 */
public class CharStateC extends CharState {

    public CharStateC(StringBuffer buffer) {
        super(buffer);
    }

    @Override
    public CharState handleA() {
        return new CharStateA(this.currentBuffer.append('A'));
    }

    @Override
    public CharState handleB() {
        return new CharStateC(this.currentBuffer);
    }

    @Override
    public CharState handleC() {
        return new CharStateC(this.currentBuffer);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CharStateC) {
            return true;
        } else {
            return false;
        }
    }
}

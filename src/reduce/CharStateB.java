package reduce;

/**
 * Created by michal on 03.08.15.
 */
public class CharStateB extends CharState {

    private int numberOfB = 1;

    public CharStateB(StringBuffer buffer) {
        super(buffer);
    }

    public CharStateB (StringBuffer buffer, int howManyB) {
        this(buffer);
        numberOfB = howManyB;
    }

    @Override
    public CharState handleA() {
        return new CharStateA(this.currentBuffer.append("A"));
    }

    @Override
    public CharState handleB() {
        return new CharStateB(this.currentBuffer, numberOfB+1);
    }

    @Override
    public CharState handleC() {
        return new CharStateC(this.currentBuffer.append("C"));
    }

    @Override
    public String getBufferAsString(){
        appendBsToBuffer();

        return super.getBufferAsString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CharStateB) {
            return true;
        } else {
            return false;
        }
    }
    
	private void appendBsToBuffer() {
		currentBuffer = new StringBuffer();

        for(int i=0; i<numberOfB; i++) {
            currentBuffer.append("B");
        }
	}
}

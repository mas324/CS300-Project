
public class RegularVisitor extends Visitor {

    private static int regularCounter = 0;
    private String regularID;

    public RegularVisitor(int time) {
        super(time);
        setRegularID();
    }

    public void setRegularID() {
        regularID = String.format("%s Regular", regularCounter++);
    }

    public String getRegularID() {
        return regularID;
    }
}


public class VIPVisitor extends Visitor {

    private static int vipCounter = 0;
    private String vipID;

    public VIPVisitor(int time) {
        super(time);
        setVipID();
    }

    public void setVipID() {
        vipID = String.format("%s VIP", vipCounter++);
    }

    public String getVipID() {
        return vipID;
    }
}

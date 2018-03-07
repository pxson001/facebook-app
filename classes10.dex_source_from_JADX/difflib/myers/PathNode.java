package difflib.myers;

/* compiled from: event_checkin_posted */
public abstract class PathNode {
    public final int f13602a;
    public final int f13603b;
    public final PathNode f13604c;

    public abstract boolean mo684a();

    public PathNode(int i, int i2, PathNode pathNode) {
        this.f13602a = i;
        this.f13603b = i2;
        this.f13604c = pathNode;
    }

    public final PathNode m13866b() {
        Object obj;
        if (this.f13602a < 0 || this.f13603b < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return null;
        }
        if (mo684a() || this.f13604c == null) {
            return this;
        }
        return this.f13604c.m13866b();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        while (this != null) {
            stringBuffer.append("(");
            stringBuffer.append(Integer.toString(this.f13602a));
            stringBuffer.append(",");
            stringBuffer.append(Integer.toString(this.f13603b));
            stringBuffer.append(")");
            this = this.f13604c;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

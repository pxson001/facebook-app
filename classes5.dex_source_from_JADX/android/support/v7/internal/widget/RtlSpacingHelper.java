package android.support.v7.internal.widget;

/* compiled from: undo_dismiss */
public class RtlSpacingHelper {
    public int f1113a = 0;
    public int f1114b = 0;
    public int f1115c = Integer.MIN_VALUE;
    public int f1116d = Integer.MIN_VALUE;
    public int f1117e = 0;
    public int f1118f = 0;
    public boolean f1119g = false;
    public boolean f1120h = false;

    public final void m1632a(int i, int i2) {
        this.f1115c = i;
        this.f1116d = i2;
        this.f1120h = true;
        if (this.f1119g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1113a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1114b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1113a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1114b = i2;
        }
    }
}

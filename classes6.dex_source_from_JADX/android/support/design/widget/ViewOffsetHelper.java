package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewParent;

/* compiled from: public */
public class ViewOffsetHelper {
    private final View f7140a;
    private int f7141b;
    private int f7142c;
    public int f7143d;
    public int f7144e;

    public ViewOffsetHelper(View view) {
        this.f7140a = view;
    }

    public final void m10272a() {
        this.f7141b = this.f7140a.getTop();
        this.f7142c = this.f7140a.getLeft();
        m10271d();
    }

    private void m10271d() {
        ViewCompat.g(this.f7140a, this.f7143d - (this.f7140a.getTop() - this.f7141b));
        View view = this.f7140a;
        int left = this.f7144e - (this.f7140a.getLeft() - this.f7142c);
        view.offsetLeftAndRight(left);
        if (left != 0 && VERSION.SDK_INT < 11) {
            view.invalidate();
        }
        if (VERSION.SDK_INT < 23) {
            m10270a(this.f7140a);
            ViewParent parent = this.f7140a.getParent();
            if (parent instanceof View) {
                m10270a((View) parent);
            }
        }
    }

    private static void m10270a(View view) {
        float p = ViewCompat.p(view);
        ViewCompat.b(view, 1.0f + p);
        ViewCompat.b(view, p);
    }

    public final boolean m10273a(int i) {
        if (this.f7143d == i) {
            return false;
        }
        this.f7143d = i;
        m10271d();
        return true;
    }

    public final boolean m10274b(int i) {
        if (this.f7144e == i) {
            return false;
        }
        this.f7144e = i;
        m10271d();
        return true;
    }
}

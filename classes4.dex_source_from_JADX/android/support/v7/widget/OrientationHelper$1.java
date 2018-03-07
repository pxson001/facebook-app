package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: privacy_checkup_mobile */
public final class OrientationHelper$1 extends OrientationHelper {
    public OrientationHelper$1(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int m4753d() {
        return this.a.w() - this.a.A();
    }

    public final int m4755e() {
        return this.a.w();
    }

    public final void m4749a(int i) {
        this.a.g(i);
    }

    public final int m4751c() {
        return this.a.y();
    }

    public final int m4752c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (LayoutManager.f(view) + layoutParams.leftMargin);
    }

    public final int m4754d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (LayoutManager.g(view) + layoutParams.topMargin);
    }

    public final int m4750b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + this.a.j(view);
    }

    public final int m4748a(View view) {
        return this.a.h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public final int m4756f() {
        return (this.a.w() - this.a.y()) - this.a.A();
    }

    public final int m4757g() {
        return this.a.A();
    }
}

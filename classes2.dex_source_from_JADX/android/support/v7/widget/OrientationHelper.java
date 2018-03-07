package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: not a valid Integer value */
public abstract class OrientationHelper {
    protected final LayoutManager f12211a;
    public int f12212b = Integer.MIN_VALUE;

    /* compiled from: not a valid Integer value */
    public final class C05082 extends OrientationHelper {
        public C05082(LayoutManager layoutManager) {
            super(layoutManager);
        }

        public final int mo2332d() {
            return this.f12211a.m17369x() - this.f12211a.m17286B();
        }

        public final int mo2334e() {
            return this.f12211a.m17369x();
        }

        public final void mo2328a(int i) {
            this.f12211a.m17356h(i);
        }

        public final int mo2330c() {
            return this.f12211a.m17371z();
        }

        public final int mo2331c(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (LayoutManager.m17276g(view) + layoutParams.topMargin);
        }

        public final int mo2333d(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (LayoutManager.m17275f(view) + layoutParams.leftMargin);
        }

        public final int mo2329b(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + this.f12211a.m17361k(view);
        }

        public final int mo2327a(View view) {
            return this.f12211a.m17358i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
        }

        public final int mo2335f() {
            return (this.f12211a.m17369x() - this.f12211a.m17371z()) - this.f12211a.m17286B();
        }

        public final int mo2336g() {
            return this.f12211a.m17286B();
        }
    }

    public abstract int mo2327a(View view);

    public abstract void mo2328a(int i);

    public abstract int mo2329b(View view);

    public abstract int mo2330c();

    public abstract int mo2331c(View view);

    public abstract int mo2332d();

    public abstract int mo2333d(View view);

    public abstract int mo2334e();

    public abstract int mo2335f();

    public abstract int mo2336g();

    public OrientationHelper(LayoutManager layoutManager) {
        this.f12211a = layoutManager;
    }

    public final int m18003b() {
        return Integer.MIN_VALUE == this.f12212b ? 0 : mo2335f() - this.f12212b;
    }

    public static OrientationHelper m18000a(LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return new 1(layoutManager);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new C05082(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }
}

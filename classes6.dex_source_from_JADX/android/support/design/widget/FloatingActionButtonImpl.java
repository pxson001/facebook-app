package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: publish_order */
public abstract class FloatingActionButtonImpl {
    static final int[] f7036a = new int[]{16842919, 16842910};
    static final int[] f7037b = new int[]{16842908, 16842910};
    static final int[] f7038c = new int[0];
    public final VisibilityAwareImageButton f7039d;
    public OnPreDrawListener f7040e;

    /* compiled from: publish_order */
    interface InternalVisibilityChangedListener {
    }

    /* compiled from: publish_order */
    public class C04001 implements OnPreDrawListener {
        final /* synthetic */ FloatingActionButtonImpl f7035a;

        public C04001(FloatingActionButtonImpl floatingActionButtonImpl) {
            this.f7035a = floatingActionButtonImpl;
        }

        public boolean onPreDraw() {
            return true;
        }
    }

    abstract void m10140a();

    abstract void m10141b();

    abstract void m10142c();

    abstract void m10143d();

    abstract void m10144e();

    abstract void m10145f();

    abstract void m10146g();
}

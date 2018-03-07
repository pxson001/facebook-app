package com.facebook.components.widget;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentTree;
import com.facebook.components.ComponentView;
import com.facebook.components.ComponentsPools;
import com.facebook.components.SizeSpec;
import com.facebook.components.ThreadUtils;
import com.facebook.components.widget.PagerBinder.InternalAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: transliterator_download_failed */
public abstract class BaseBinder<V extends ViewGroup> {
    private static final SynchronizedPool<List> f1230a = new SynchronizedPool(8);
    private final ComponentContext f1231b;
    private final BinderTreeCollection f1232c;
    private final Looper f1233d;
    private int f1234e;
    private int f1235f;
    public V f1236g;
    public InternalAdapter f1237h;
    private boolean f1238i;

    protected abstract int m1305a();

    public abstract Component<?> m1307a(ComponentContext componentContext, int i);

    protected abstract void mo52b();

    protected abstract boolean m1315c();

    public abstract void mo53e(V v);

    protected abstract void mo54f(V v);

    public abstract void mo55g(V v);

    public BaseBinder(Context context) {
        this(context, null);
    }

    private BaseBinder(Context context, Looper looper) {
        this.f1234e = SizeSpec.a(0, 0);
        this.f1235f = SizeSpec.a(0, 0);
        this.f1231b = new ComponentContext(context);
        this.f1232c = new BinderTreeCollection();
        this.f1233d = looper;
        if (this.f1233d != null && this.f1233d == Looper.getMainLooper()) {
            throw new IllegalStateException("If you want to compute the layout of the Binder's elements in the Main Thread you shouldn't set the MainLooper here butoverride isAsyncLayoutEnabled() and return false.");
        }
    }

    private void m1299d() {
        ThreadUtils.b();
        if (m1303h()) {
            m1310a(0, m1305a(), 3);
            if (this.f1237h != null) {
                this.f1238i = false;
                this.f1237h.kR_();
                return;
            }
            return;
        }
        this.f1238i = true;
    }

    public final void m1309a(int i, int i2) {
        synchronized (this) {
            this.f1234e = SizeSpec.a(i, 1073741824);
            this.f1235f = SizeSpec.a(i2, 1073741824);
        }
        if (this.f1238i) {
            m1299d();
        }
        mo52b();
    }

    public final void m1313b(V v) {
        ThreadUtils.b();
        m1304i(v);
        int childCount = this.f1236g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f1236g.getChildAt(i);
            if (childAt instanceof ComponentView) {
                ((ComponentView) childAt).e();
            }
        }
        mo54f(this.f1236g);
    }

    public final void m1314c(V v) {
        ThreadUtils.b();
        m1304i(v);
        int childCount = this.f1236g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f1236g.getChildAt(i);
            if (childAt instanceof ComponentView) {
                ((ComponentView) childAt).f();
            }
        }
    }

    private void m1304i(V v) {
        if (v != this.f1236g) {
            throw new IllegalArgumentException("Must pass same view to bind/unbind as was passed in mount");
        }
    }

    public final ComponentTree m1308a(int i) {
        ComponentTree b;
        synchronized (this) {
            b = this.f1232c.m1324b(i);
        }
        return b;
    }

    final int m1306a(ComponentTree componentTree) {
        int a;
        synchronized (this) {
            a = this.f1232c.m1320a(componentTree);
        }
        return a;
    }

    protected int mo51b(int i) {
        return this.f1234e;
    }

    private int m1300e() {
        return this.f1235f;
    }

    private static boolean m1301f() {
        return false;
    }

    private static boolean m1302g() {
        return false;
    }

    final void m1310a(int i, int i2, int i3) {
        int i4 = 0;
        if (Thread.holdsLock(this)) {
            throw new IllegalStateException("This method should be called outside the lock.");
        }
        int i5;
        int i6;
        int i7 = (i3 & 1) != 0 ? 1 : 0;
        if ((i3 & 2) != 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        List c = m1298c(m1305a());
        List c2 = m1298c(m1305a());
        int i8 = i + i2;
        for (i6 = i; i6 < i8; i6++) {
            c2.add(m1307a(this.f1231b, i6));
        }
        synchronized (this) {
            i8 = this.f1232c.m1319a();
            int b = this.f1232c.m1323b();
            i6 = Math.max(0, Math.min(i, i8));
            b = Math.max(i + i2, i8 + b);
            i8 = i6;
            while (i8 < b) {
                ComponentTree b2 = this.f1232c.m1324b(i8);
                if (b2 != null && r1 != 0 && (i8 < i || i8 >= i + i2)) {
                    c.add(b2);
                    this.f1232c.m1321a(i8);
                } else if (i8 >= i && i8 < i + i2) {
                    Component component = (Component) c2.get(i8 - i);
                    if (b2 == null) {
                        ComponentTree b3 = ComponentsPools.a(this.f1231b, component).a(m1301f()).c(m1302g()).a(this.f1233d).b();
                        if (m1315c()) {
                            b3.b(mo51b(i8), m1300e());
                        } else {
                            b3.a(mo51b(i8), m1300e());
                        }
                        this.f1232c.m1322a(i8, b3);
                    } else if (i7 != 0) {
                        if (m1315c()) {
                            b2.a(component, mo51b(i8), m1300e());
                        } else {
                            b2.b(component, mo51b(i8), m1300e());
                        }
                    }
                }
                i8++;
            }
        }
        m1297a(c2);
        i5 = c.size();
        while (i4 < i5) {
            ((ComponentTree) c.get(i4)).l();
            i4++;
        }
        m1297a(c);
    }

    private boolean m1303h() {
        boolean z;
        synchronized (this) {
            z = (SizeSpec.a(this.f1234e) == 0 || SizeSpec.a(this.f1235f) == 0) ? false : true;
        }
        return z;
    }

    private static <T> List<T> m1298c(int i) {
        List<T> list = (List) f1230a.a();
        if (list == null) {
            return new ArrayList(i);
        }
        return list;
    }

    private static void m1297a(List<?> list) {
        list.clear();
        f1230a.a(list);
    }
}

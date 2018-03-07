package com.facebook.components.widget;

import android.content.Context;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.components.ComponentTree;
import com.facebook.components.ComponentView;
import com.facebook.components.SizeSpec;

/* compiled from: transliterator_comment_posted */
public abstract class PagerBinder extends BaseBinder<ViewPager> {
    private final InternalAdapter f1247a;
    private final OnPageChangeListener f1248b;
    public final float f1249c;
    private final int f1250d;
    public final SparseArray<ComponentView> f1251e = new SparseArray(3);
    public final boolean f1252f;
    public ViewPager f1253g;
    public int f1254h;
    public OnPageChangeListener f1255i;

    /* compiled from: transliterator_comment_posted */
    public class InternalAdapter extends PagerAdapter {
        private final PagerBinder f1243a;
        private final Context f1244b;
        private final SimplePool<ComponentView> f1245c = new SimplePool(5);

        public final CharSequence J_(int i) {
            return null;
        }

        InternalAdapter(PagerBinder pagerBinder, Context context) {
            this.f1243a = pagerBinder;
            this.f1244b = context;
        }

        public final Object m1326a(ViewGroup viewGroup, int i) {
            ComponentView componentView = (ComponentView) this.f1245c.a();
            if (componentView == null) {
                componentView = new ComponentView(this.f1244b);
            }
            this.f1243a.f1251e.put(i, componentView);
            if (i == this.f1243a.f1254h || !this.f1243a.f1252f) {
                ComponentTree a = this.f1243a.m1308a(i);
                if (a == null && this.f1243a.f1253g != null && this.f1243a.f1254h == this.f1243a.f1253g.k) {
                    throw new IllegalStateException("Null component while initializing a new page.");
                }
                componentView.setComponent(a);
            }
            viewGroup.addView(componentView);
            return componentView;
        }

        public final void m1327a(ViewGroup viewGroup, int i, Object obj) {
            ComponentView componentView = (ComponentView) obj;
            componentView.setComponent(null);
            viewGroup.removeView((View) obj);
            this.f1243a.f1251e.remove(i);
            this.f1245c.a(componentView);
        }

        public final boolean m1328a(View view, Object obj) {
            return view == obj;
        }

        public final int m1325a(Object obj) {
            int a = this.f1243a.m1306a(((ComponentView) obj).a);
            if (a < 0) {
                return -2;
            }
            return a;
        }

        public final float m1330d(int i) {
            return this.f1243a.f1249c;
        }

        public final int m1329b() {
            return this.f1243a.m1305a();
        }
    }

    /* compiled from: transliterator_comment_posted */
    public class InternalOnPageChangeListener implements OnPageChangeListener {
        public final PagerBinder f1246a;

        InternalOnPageChangeListener(PagerBinder pagerBinder) {
            this.f1246a = pagerBinder;
        }

        public final void m1331a(int i, float f, int i2) {
            int i3;
            int i4;
            ComponentView componentView;
            if (this.f1246a.f1252f) {
                int i5 = f == 0.0f ? 1 : 2;
                for (i3 = 0; i3 < i5; i3++) {
                    i4 = i + i3;
                    componentView = (ComponentView) this.f1246a.f1251e.get(i4);
                    ComponentTree a = this.f1246a.m1308a(i4);
                    if (componentView.a != a) {
                        componentView.setComponent(a);
                    }
                }
            }
            ViewPager viewPager = this.f1246a.f1253g;
            i4 = viewPager.getChildCount();
            for (i3 = 0; i3 < i4; i3++) {
                Object obj;
                componentView = (ComponentView) viewPager.getChildAt(i3);
                if (componentView.a == null || !componentView.a.i()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    componentView.h();
                }
            }
            if (this.f1246a.f1255i != null) {
                this.f1246a.f1255i.a(i, f, i2);
            }
        }

        public final void e_(int i) {
            this.f1246a.f1254h = i;
            this.f1246a.m1336b(i, 2);
            if (this.f1246a.f1255i != null) {
                this.f1246a.f1255i.e_(i);
            }
        }

        public final void m1332b(int i) {
            if (this.f1246a.f1255i != null) {
                this.f1246a.f1255i.b(i);
            }
        }
    }

    protected final void mo53e(ViewGroup viewGroup) {
        ViewPager viewPager = (ViewPager) viewGroup;
        this.f1253g = viewPager;
        viewPager.setOnPageChangeListener(this.f1248b);
        viewPager.setAdapter(this.f1247a);
        viewPager.setCurrentItem(this.f1254h);
        viewPager.setOffscreenPageLimit(this.f1250d);
    }

    protected /* synthetic */ void mo54f(ViewGroup viewGroup) {
        m1333a((ViewPager) viewGroup);
    }

    protected /* synthetic */ void mo55g(ViewGroup viewGroup) {
        m1337b((ViewPager) viewGroup);
    }

    public PagerBinder(Context context, int i, float f) {
        super(context);
        this.f1254h = i;
        this.f1249c = f;
        this.f1250d = (int) Math.ceil((double) (1.0f / this.f1249c));
        this.f1247a = new InternalAdapter(this, context);
        this.f1248b = new InternalOnPageChangeListener(this);
        this.f1252f = this.f1249c >= 1.0f;
        this.f1237h = this.f1247a;
    }

    protected final int mo51b(int i) {
        int b = super.mo51b(i);
        return SizeSpec.a((int) (((float) SizeSpec.b(b)) * this.f1249c), SizeSpec.a(b));
    }

    protected final void mo52b() {
        m1336b(this.f1254h, 3);
    }

    public void m1333a(ViewPager viewPager) {
    }

    public void m1337b(ViewPager viewPager) {
        this.f1253g.setOnPageChangeListener(null);
        this.f1253g.setAdapter(null);
        this.f1253g = null;
    }

    final void m1336b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("The ViewPager center page can't be < 0");
        }
        int a = m1305a();
        if (a == 0) {
            m1310a(0, 0, 2);
            return;
        }
        int i3 = this.f1250d + 1;
        int max = Math.max(0, i - i3);
        m1310a(max, (Math.min(i3 + i, a - 1) - max) + 1, i2);
    }
}

package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: rto */
public class ViewPager extends ViewGroup {
    public static final int[] f6376a = new int[]{16842931};
    private static final ViewPositionComparator am = new ViewPositionComparator();
    private static final Comparator<ItemInfo> f6377e = new C02841();
    private static final Interpolator f6378f = new C02852();
    private boolean f6379A;
    public int f6380B = 1;
    private boolean f6381C;
    private boolean f6382D;
    private boolean f6383E;
    private int f6384F;
    private int f6385G;
    private int f6386H;
    private float f6387I;
    private float f6388J;
    private float f6389K;
    private float f6390L;
    private int f6391M = -1;
    private VelocityTracker f6392N;
    private int f6393O;
    private int f6394P;
    private int f6395Q;
    private int f6396R;
    public boolean f6397S;
    private long f6398T;
    private EdgeEffectCompat f6399U;
    private EdgeEffectCompat f6400V;
    private boolean f6401W = true;
    private boolean aa = false;
    private boolean ab;
    private int ac;
    private boolean ad = true;
    private OnPageChangeListener ae;
    private OnPageChangeListener af;
    public OnAdapterChangeListener ag;
    private PageTransformer ah;
    private Method ai;
    private int aj;
    private ArrayList<View> ak;
    private boolean al = false;
    private final Runnable an = new C02863(this);
    private int ao = 0;
    private int f6402b;
    public int f6403c;
    public float f6404d;
    private final ArrayList<ItemInfo> f6405g = new ArrayList();
    private final ItemInfo f6406h = new ItemInfo();
    private final Rect f6407i = new Rect();
    public PagerAdapter f6408j;
    public int f6409k;
    private int f6410l = -1;
    private Parcelable f6411m = null;
    private ClassLoader f6412n = null;
    private Scroller f6413o;
    private PagerObserver f6414p;
    public int f6415q;
    private Drawable f6416r;
    private int f6417s;
    private int f6418t;
    private float f6419u = -3.4028235E38f;
    private float f6420v = Float.MAX_VALUE;
    private int f6421w;
    private int f6422x;
    private boolean f6423y;
    private boolean f6424z;

    /* compiled from: rto */
    final class C02841 implements Comparator<ItemInfo> {
        C02841() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((ItemInfo) obj).f6426b - ((ItemInfo) obj2).f6426b;
        }
    }

    /* compiled from: rto */
    final class C02852 implements Interpolator {
        C02852() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* compiled from: rto */
    class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.f8956a != layoutParams2.f8956a) {
                return layoutParams.f8956a ? 1 : -1;
            } else {
                return layoutParams.f8960e - layoutParams2.f8960e;
            }
        }
    }

    /* compiled from: rto */
    class ItemInfo {
        Object f6425a;
        int f6426b;
        boolean f6427c;
        float f6428d;
        float f6429e;

        ItemInfo() {
        }
    }

    /* compiled from: rto */
    class C02863 implements Runnable {
        final /* synthetic */ ViewPager f6430a;

        C02863(ViewPager viewPager) {
            this.f6430a = viewPager;
        }

        public void run() {
            ViewPager.setScrollState(this.f6430a, 0);
            this.f6430a.m10822b();
        }
    }

    /* compiled from: rto */
    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager f6434b;

        MyAccessibilityDelegate(ViewPager viewPager) {
            this.f6434b = viewPager;
        }

        public final void mo1505d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo1505d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat accessibilityRecordCompat = new AccessibilityRecordCompat(AccessibilityRecordCompat.a.a());
            accessibilityRecordCompat.a(m10862b());
            if (accessibilityEvent.getEventType() == 4096 && this.f6434b.f6408j != null) {
                accessibilityRecordCompat.a(this.f6434b.f6408j.mo1711b());
                accessibilityRecordCompat.b(this.f6434b.f6409k);
                accessibilityRecordCompat.c(this.f6434b.f6409k);
            }
        }

        public final void mo1503a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo1503a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.b(ViewPager.class.getName());
            accessibilityNodeInfoCompat.i(m10862b());
            if (m10863c()) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (m10864d()) {
                accessibilityNodeInfoCompat.a(8192);
            }
        }

        public final boolean mo1504a(View view, int i, Bundle bundle) {
            if (super.mo1504a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!m10863c()) {
                        return false;
                    }
                    this.f6434b.setCurrentItem(this.f6434b.f6409k + 1);
                    return true;
                case 8192:
                    if (!m10864d()) {
                        return false;
                    }
                    this.f6434b.setCurrentItem(this.f6434b.f6409k - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m10862b() {
            return this.f6434b.f6408j != null && this.f6434b.f6408j.mo1711b() > 1;
        }

        private boolean m10863c() {
            return this.f6434b.f6408j != null && this.f6434b.f6409k >= 0 && this.f6434b.f6409k < this.f6434b.f6408j.mo1711b() - 1;
        }

        private boolean m10864d() {
            return this.f6434b.f6408j != null && this.f6434b.f6409k > 0 && this.f6434b.f6409k < this.f6434b.f6408j.mo1711b();
        }
    }

    /* compiled from: rto */
    class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager f8059a;

        public PagerObserver(ViewPager viewPager) {
            this.f8059a = viewPager;
        }

        public void onChanged() {
            this.f8059a.m10815a();
        }

        public void onInvalidated() {
            this.f8059a.m10815a();
        }
    }

    /* compiled from: rto */
    public interface OnPageChangeListener {
        void mo1723a(int i, float f, int i2);

        void mo1724b(int i);

        void e_(int i);
    }

    /* compiled from: rto */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean f8956a;
        public int f8957b;
        float f8958c = 0.0f;
        boolean f8959d;
        int f8960e;
        int f8961f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f6376a);
            this.f8957b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: rto */
    interface Decor {
    }

    public ViewPager(Context context) {
        super(context);
        m10807g();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10807g();
    }

    private void m10807g() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f6413o = new Scroller(context, f6378f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f6386H = ViewConfigurationCompat.m10827a(viewConfiguration);
        this.f6393O = (int) (400.0f * f);
        this.f6394P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6399U = new EdgeEffectCompat(context);
        this.f6400V = new EdgeEffectCompat(context);
        this.f6395Q = (int) (25.0f * f);
        this.f6396R = (int) (2.0f * f);
        this.f6384F = (int) (16.0f * f);
        ViewCompat.m10939a((View) this, new MyAccessibilityDelegate(this));
        if (ViewCompat.m10959e(this) == 0) {
            ViewCompat.m10958d((View) this, 1);
        }
    }

    protected void setIgnoreTouchSlop(boolean z) {
        this.ad = z;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 814782289);
        removeCallbacks(this.an);
        this.al = false;
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1155817088, a);
    }

    public static void setScrollState(ViewPager viewPager, int i) {
        if (viewPager.ao != i) {
            viewPager.ao = i;
            if (viewPager.ah != null) {
                viewPager.m10801b(i != 0);
            }
            if (viewPager.ae != null) {
                viewPager.ae.mo1724b(i);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f6408j != null) {
            this.f6408j.m12657b(this.f6414p);
            this.f6408j.mo1715a((ViewGroup) this);
            for (int i = 0; i < this.f6405g.size(); i++) {
                ItemInfo itemInfo = (ItemInfo) this.f6405g.get(i);
                this.f6408j.mo1710a((ViewGroup) this, itemInfo.f6426b, itemInfo.f6425a);
            }
            this.f6408j.mo1712b((ViewGroup) this);
            this.f6405g.clear();
            m10808h();
            this.f6409k = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f6408j;
        this.f6408j = pagerAdapter;
        this.f6402b = 0;
        if (this.f6408j != null) {
            if (this.f6414p == null) {
                this.f6414p = new PagerObserver(this);
            }
            this.f6408j.m12650a(this.f6414p);
            this.f6379A = false;
            boolean z = this.f6401W;
            this.f6401W = true;
            this.f6402b = this.f6408j.mo1711b();
            if (this.f6410l >= 0) {
                this.f6408j.mo1709a(this.f6411m, this.f6412n);
                m10790a(this.f6410l, false, true);
                this.f6410l = -1;
                this.f6411m = null;
                this.f6412n = null;
            } else if (z) {
                requestLayout();
            } else {
                m10822b();
            }
        }
        if (this.ag != null && pagerAdapter2 != pagerAdapter) {
            this.ag.a(pagerAdapter2, pagerAdapter);
        }
    }

    private void m10808h() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f8956a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.f6408j;
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.ag = onAdapterChangeListener;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f6379A = false;
        if (this.f6401W) {
            z = false;
        } else {
            z = true;
        }
        m10790a(i, z, false);
    }

    public void m10817a(int i, boolean z) {
        this.f6379A = false;
        m10790a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f6409k;
    }

    private void m10790a(int i, boolean z, boolean z2) {
        m10791a(i, z, z2, 0);
    }

    private void m10791a(int i, boolean z, boolean z2, int i2) {
        if (this.f6408j == null || this.f6408j.mo1711b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f6409k != i || this.f6405g.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f6408j.mo1711b()) {
                i = this.f6408j.mo1711b() - 1;
            }
            int i3 = this.f6380B;
            if (i > this.f6409k + i3 || i < this.f6409k - i3) {
                for (int i4 = 0; i4 < this.f6405g.size(); i4++) {
                    ((ItemInfo) this.f6405g.get(i4)).f6427c = true;
                }
            }
            boolean z3 = this.f6409k != i;
            if (this.f6401W) {
                this.f6409k = i;
                if (z3 && this.ae != null) {
                    this.ae.e_(i);
                }
                if (z3 && this.af != null) {
                    this.af.e_(i);
                }
                requestLayout();
                return;
            }
            mo1487b(i);
            m10789a(i, z, i2, z3);
            if (this.f6405g.size() > 0) {
                this.f6403c = m10810j().f6426b;
            } else {
                this.f6403c = 0;
            }
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public int getScrollPosition() {
        return this.f6403c;
    }

    public float getScrollOffset() {
        return this.f6404d;
    }

    private void m10789a(int i, boolean z, int i2, boolean z2) {
        int round;
        ItemInfo c = m10802c(i);
        if (c != null) {
            round = Math.round(Math.max(this.f6419u, Math.min(c.f6429e, this.f6420v)) * ((float) getClientWidth()));
        } else {
            round = 0;
        }
        if (z) {
            m10787a(round, 0, i2);
            if (z2 && this.ae != null) {
                this.ae.e_(i);
            }
            if (z2 && this.af != null) {
                this.af.e_(i);
                return;
            }
            return;
        }
        if (z2 && this.ae != null) {
            this.ae.e_(i);
        }
        if (z2 && this.af != null) {
            this.af.e_(i);
        }
        m10795a(false);
        scrollTo(round, 0);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.ae = onPageChangeListener;
    }

    public final void m10818a(boolean z, PageTransformer pageTransformer) {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z2;
            boolean z3 = pageTransformer != null;
            if (this.ah != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i2 = z3 != z2 ? 1 : 0;
            this.ah = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z) {
                    i = 2;
                }
                this.aj = i;
            } else {
                this.aj = 0;
            }
            if (i2 != 0) {
                m10822b();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ai == null) {
                try {
                    this.ai = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ai.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.aj == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.ak.get(i2)).getLayoutParams()).f8961f;
    }

    final OnPageChangeListener m10814a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.af;
        this.af = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.f6380B;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f6380B) {
            this.f6380B = i;
            m10822b();
        }
    }

    public boolean getOnlyCreatePagesImmediatelyOffscreen() {
        return this.f6381C;
    }

    public void setOnlyCreatePagesImmediatelyOffscreen(boolean z) {
        if (z != this.f6381C) {
            this.f6381C = z;
            m10822b();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f6415q;
        this.f6415q = i;
        int width = getWidth();
        m10788a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f6415q;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f6416r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6416r;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6416r;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private static float m10797b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private void m10787a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m10795a(false);
            m10822b();
            setScrollState(this, 0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(this, 2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float b = (((float) i6) * m10797b(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(b / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f6408j.m12660d(this.f6409k)) + ((float) this.f6415q))) + 1.0f) * 100.0f);
        }
        this.f6413o.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        ViewCompat.m10956d(this);
    }

    private ItemInfo m10784a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f6426b = i;
        itemInfo.f6425a = this.f6408j.mo1714a((ViewGroup) this, i);
        itemInfo.f6428d = this.f6408j.m12660d(i);
        if (i2 < 0 || i2 >= this.f6405g.size()) {
            this.f6405g.add(itemInfo);
        } else {
            this.f6405g.add(i2, itemInfo);
        }
        return itemInfo;
    }

    final void m10815a() {
        int max;
        int b = this.f6408j.mo1711b();
        this.f6402b = b;
        boolean z = this.f6405g.size() < (this.f6380B * 2) + 1 && this.f6405g.size() < b;
        boolean z2 = false;
        int i = this.f6409k;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f6405g.size()) {
            int i3;
            boolean z4;
            boolean z5;
            ItemInfo itemInfo = (ItemInfo) this.f6405g.get(i2);
            int a = this.f6408j.mo1707a(itemInfo.f6425a);
            if (a != -1) {
                if (a == -2) {
                    this.f6405g.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f6408j.mo1715a((ViewGroup) this);
                        z2 = true;
                    }
                    this.f6408j.mo1710a((ViewGroup) this, itemInfo.f6426b, itemInfo.f6425a);
                    if (this.f6409k == itemInfo.f6426b) {
                        i3 = i2;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.f6409k, b - 1));
                        z5 = true;
                    } else {
                        i3 = i2;
                        z4 = z2;
                        max = i;
                        z5 = true;
                    }
                } else if (itemInfo.f6426b != a) {
                    if (itemInfo.f6426b == this.f6409k) {
                        i = a;
                    }
                    itemInfo.f6426b = a;
                    i3 = i2;
                    z4 = z2;
                    max = i;
                    z5 = true;
                }
                z3 = z5;
                i = max;
                z2 = z4;
                i2 = i3 + 1;
            }
            i3 = i2;
            z4 = z2;
            max = i;
            z5 = z3;
            z3 = z5;
            i = max;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f6408j.mo1712b((ViewGroup) this);
        }
        Collections.sort(this.f6405g, f6377e);
        if (z3) {
            max = getChildCount();
            for (i2 = 0; i2 < max; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.f8956a) {
                    layoutParams.f8958c = 0.0f;
                }
            }
            m10790a(i, false, true);
            requestLayout();
        }
    }

    final void m10822b() {
        mo1487b(this.f6409k);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mo1487b(int r21) {
        /*
        r20 = this;
        r3 = 0;
        r2 = 2;
        r0 = r20;
        r4 = r0.f6409k;
        r0 = r21;
        if (r4 == r0) goto L_0x0378;
    L_0x000a:
        r0 = r20;
        r2 = r0.f6409k;
        r0 = r21;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r20;
        r3 = r0.f6409k;
        r0 = r20;
        r3 = r0.m10802c(r3);
        r0 = r21;
        r1 = r20;
        r1.f6409k = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r20;
        r2 = r0.f6408j;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r20.m10809i();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r20;
        r2 = r0.f6379A;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r20.m10809i();
        goto L_0x002f;
    L_0x003d:
        r0 = r20;
        r2 = r0.al;
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r20;
        r2 = r0.f6408j;
        r0 = r20;
        r2.mo1715a(r0);
        r0 = r20;
        r2 = r0.f6380B;
        r5 = 0;
        r0 = r20;
        r6 = r0.f6409k;
        r6 = r6 - r2;
        r8 = java.lang.Math.max(r5, r6);
        r0 = r20;
        r5 = r0.f6408j;
        r15 = r5.mo1711b();
        r5 = r15 + -1;
        r0 = r20;
        r6 = r0.f6409k;
        r2 = r2 + r6;
        r10 = java.lang.Math.min(r5, r2);
        r0 = r20;
        r2 = r0.f6402b;
        if (r15 == r2) goto L_0x00d6;
    L_0x0073:
        r2 = r20.getResources();	 Catch:{ NotFoundException -> 0x00cc }
        r3 = r20.getId();	 Catch:{ NotFoundException -> 0x00cc }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00cc }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r20;
        r5 = r0.f6402b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r15);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r20.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r20;
        r4 = r0.f6408j;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00cc:
        r2 = move-exception;
        r2 = r20.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00d6:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00d9:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0375;
    L_0x00e3:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        r7 = r2.f6426b;
        r0 = r20;
        r9 = r0.f6409k;
        if (r7 < r9) goto L_0x019c;
    L_0x00f5:
        r7 = r2.f6426b;
        r0 = r20;
        r9 = r0.f6409k;
        if (r7 != r9) goto L_0x0375;
    L_0x00fd:
        if (r2 != 0) goto L_0x0372;
    L_0x00ff:
        if (r15 <= 0) goto L_0x0372;
    L_0x0101:
        r0 = r20;
        r2 = r0.f6409k;
        r0 = r20;
        r2 = r0.m10784a(r2, r5);
        r14 = r2;
    L_0x010c:
        if (r14 == 0) goto L_0x02d3;
    L_0x010e:
        r13 = 0;
        r12 = r5 + -1;
        if (r12 < 0) goto L_0x01a1;
    L_0x0113:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r12);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x011d:
        r16 = r20.getClientWidth();
        if (r16 > 0) goto L_0x01a4;
    L_0x0123:
        r6 = 0;
    L_0x0124:
        r0 = r20;
        r7 = r0.f6381C;
        if (r7 == 0) goto L_0x01b5;
    L_0x012a:
        r7 = 0;
        r0 = r20;
        r9 = r0.f6409k;
        r9 = r9 + -1;
        r7 = java.lang.Math.max(r7, r9);
    L_0x0135:
        r0 = r20;
        r9 = r0.f6381C;
        if (r9 == 0) goto L_0x01b8;
    L_0x013b:
        r9 = r15 + -1;
        r0 = r20;
        r11 = r0.f6409k;
        r11 = r11 + 1;
        r9 = java.lang.Math.min(r9, r11);
    L_0x0147:
        r0 = r20;
        r11 = r0.f6409k;
        r11 = r11 + -1;
        r18 = r11;
        r11 = r13;
        r13 = r18;
        r19 = r12;
        r12 = r5;
        r5 = r19;
    L_0x0157:
        if (r13 < 0) goto L_0x01f8;
    L_0x0159:
        r17 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r17 < 0) goto L_0x01bc;
    L_0x015d:
        if (r13 >= r8) goto L_0x01bc;
    L_0x015f:
        if (r2 == 0) goto L_0x01f8;
    L_0x0161:
        r0 = r2.f6426b;
        r17 = r0;
        r0 = r17;
        if (r13 != r0) goto L_0x0199;
    L_0x0169:
        r0 = r2.f6427c;
        r17 = r0;
        if (r17 != 0) goto L_0x0199;
    L_0x016f:
        r0 = r20;
        r0 = r0.f6405g;
        r17 = r0;
        r0 = r17;
        r0.remove(r5);
        r0 = r20;
        r0 = r0.f6408j;
        r17 = r0;
        r2 = r2.f6425a;
        r0 = r17;
        r1 = r20;
        r0.mo1710a(r1, r13, r2);
        r5 = r5 + -1;
        r12 = r12 + -1;
        if (r5 < 0) goto L_0x01ba;
    L_0x018f:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x0199:
        r13 = r13 + -1;
        goto L_0x0157;
    L_0x019c:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00d9;
    L_0x01a1:
        r2 = 0;
        goto L_0x011d;
    L_0x01a4:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r14.f6428d;
        r6 = r6 - r7;
        r7 = r20.getPaddingLeft();
        r7 = (float) r7;
        r0 = r16;
        r9 = (float) r0;
        r7 = r7 / r9;
        r6 = r6 + r7;
        goto L_0x0124;
    L_0x01b5:
        r7 = r8;
        goto L_0x0135;
    L_0x01b8:
        r9 = r10;
        goto L_0x0147;
    L_0x01ba:
        r2 = 0;
        goto L_0x0199;
    L_0x01bc:
        if (r2 == 0) goto L_0x01da;
    L_0x01be:
        r0 = r2.f6426b;
        r17 = r0;
        r0 = r17;
        if (r13 != r0) goto L_0x01da;
    L_0x01c6:
        r2 = r2.f6428d;
        r11 = r11 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x01d8;
    L_0x01cd:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        goto L_0x0199;
    L_0x01d8:
        r2 = 0;
        goto L_0x0199;
    L_0x01da:
        if (r13 < r7) goto L_0x0199;
    L_0x01dc:
        r2 = r5 + 1;
        r0 = r20;
        r2 = r0.m10784a(r13, r2);
        r2 = r2.f6428d;
        r11 = r11 + r2;
        r12 = r12 + 1;
        if (r5 < 0) goto L_0x01f6;
    L_0x01eb:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        goto L_0x0199;
    L_0x01f6:
        r2 = 0;
        goto L_0x0199;
    L_0x01f8:
        r6 = r14.f6428d;
        r8 = r12 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x02ce;
    L_0x0202:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x026c;
    L_0x020c:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        r7 = r2;
    L_0x0217:
        if (r16 > 0) goto L_0x026e;
    L_0x0219:
        r2 = 0;
        r5 = r2;
    L_0x021b:
        r0 = r20;
        r2 = r0.f6409k;
        r2 = r2 + 1;
        r18 = r2;
        r2 = r7;
        r7 = r8;
        r8 = r18;
    L_0x0227:
        if (r8 >= r15) goto L_0x02ce;
    L_0x0229:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x027e;
    L_0x022d:
        if (r8 <= r10) goto L_0x027e;
    L_0x022f:
        if (r2 == 0) goto L_0x02ce;
    L_0x0231:
        r11 = r2.f6426b;
        if (r8 != r11) goto L_0x036b;
    L_0x0235:
        r11 = r2.f6427c;
        if (r11 != 0) goto L_0x036b;
    L_0x0239:
        r0 = r20;
        r11 = r0.f6405g;
        r11.remove(r7);
        r0 = r20;
        r11 = r0.f6408j;
        r2 = r2.f6425a;
        r0 = r20;
        r11.mo1710a(r0, r8, r2);
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x027c;
    L_0x0255:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x025f:
        r18 = r6;
        r6 = r2;
        r2 = r18;
    L_0x0264:
        r8 = r8 + 1;
        r18 = r2;
        r2 = r6;
        r6 = r18;
        goto L_0x0227;
    L_0x026c:
        r7 = 0;
        goto L_0x0217;
    L_0x026e:
        r2 = r20.getPaddingRight();
        r2 = (float) r2;
        r0 = r16;
        r5 = (float) r0;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x021b;
    L_0x027c:
        r2 = 0;
        goto L_0x025f;
    L_0x027e:
        if (r2 == 0) goto L_0x02a5;
    L_0x0280:
        r11 = r2.f6426b;
        if (r8 != r11) goto L_0x02a5;
    L_0x0284:
        r2 = r2.f6428d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02a3;
    L_0x0293:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x029d:
        r18 = r6;
        r6 = r2;
        r2 = r18;
        goto L_0x0264;
    L_0x02a3:
        r2 = 0;
        goto L_0x029d;
    L_0x02a5:
        if (r8 > r9) goto L_0x036b;
    L_0x02a7:
        r0 = r20;
        r2 = r0.m10784a(r8, r7);
        r7 = r7 + 1;
        r2 = r2.f6428d;
        r6 = r6 + r2;
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02cc;
    L_0x02bc:
        r0 = r20;
        r2 = r0.f6405g;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x02c6:
        r18 = r6;
        r6 = r2;
        r2 = r18;
        goto L_0x0264;
    L_0x02cc:
        r2 = 0;
        goto L_0x02c6;
    L_0x02ce:
        r0 = r20;
        r0.m10792a(r14, r12, r4);
    L_0x02d3:
        r0 = r20;
        r4 = r0.f6408j;
        r0 = r20;
        r5 = r0.f6409k;
        if (r14 == 0) goto L_0x0322;
    L_0x02dd:
        r2 = r14.f6425a;
    L_0x02df:
        r0 = r20;
        r4.mo1717b(r0, r5, r2);
        r0 = r20;
        r2 = r0.f6408j;
        r0 = r20;
        r2.mo1712b(r0);
        r5 = r20.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x02f3:
        if (r4 >= r5) goto L_0x0324;
    L_0x02f5:
        r0 = r20;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f8961f = r4;
        r7 = r2.f8956a;
        if (r7 != 0) goto L_0x031e;
    L_0x0307:
        r7 = r2.f8958c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x031e;
    L_0x030e:
        r0 = r20;
        r6 = r0.m10785a(r6);
        if (r6 == 0) goto L_0x031e;
    L_0x0316:
        r7 = r6.f6428d;
        r2.f8958c = r7;
        r6 = r6.f6426b;
        r2.f8960e = r6;
    L_0x031e:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x02f3;
    L_0x0322:
        r2 = 0;
        goto L_0x02df;
    L_0x0324:
        r20.m10809i();
        r2 = r20.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x032d:
        r2 = r20.findFocus();
        if (r2 == 0) goto L_0x0369;
    L_0x0333:
        r0 = r20;
        r2 = r0.m10799b(r2);
    L_0x0339:
        if (r2 == 0) goto L_0x0343;
    L_0x033b:
        r2 = r2.f6426b;
        r0 = r20;
        r4 = r0.f6409k;
        if (r2 == r4) goto L_0x002f;
    L_0x0343:
        r2 = 0;
    L_0x0344:
        r4 = r20.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x034a:
        r0 = r20;
        r4 = r0.getChildAt(r2);
        r0 = r20;
        r5 = r0.m10785a(r4);
        if (r5 == 0) goto L_0x0366;
    L_0x0358:
        r5 = r5.f6426b;
        r0 = r20;
        r6 = r0.f6409k;
        if (r5 != r6) goto L_0x0366;
    L_0x0360:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x0366:
        r2 = r2 + 1;
        goto L_0x0344;
    L_0x0369:
        r2 = 0;
        goto L_0x0339;
    L_0x036b:
        r18 = r6;
        r6 = r2;
        r2 = r18;
        goto L_0x0264;
    L_0x0372:
        r14 = r2;
        goto L_0x010c;
    L_0x0375:
        r2 = r6;
        goto L_0x00fd;
    L_0x0378:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(int):void");
    }

    private void m10809i() {
        if (this.aj != 0) {
            if (this.ak == null) {
                this.ak = new ArrayList();
            } else {
                this.ak.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ak.add(getChildAt(i));
            }
            Collections.sort(this.ak, am);
        }
    }

    private void m10792a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        float f;
        float f2;
        int i2;
        ItemInfo itemInfo3;
        int i3;
        int b = this.f6408j.mo1711b();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f6415q) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (itemInfo2 != null) {
            clientWidth = itemInfo2.f6426b;
            int i4;
            int i5;
            float f3;
            int i6;
            float d;
            if (clientWidth < itemInfo.f6426b) {
                f2 = (itemInfo2.f6429e + itemInfo2.f6428d) + f;
                i4 = 0;
                i2 = clientWidth + 1;
                while (i2 <= itemInfo.f6426b && i4 < this.f6405g.size()) {
                    itemInfo3 = (ItemInfo) this.f6405g.get(i4);
                    while (i2 > itemInfo3.f6426b && i4 < this.f6405g.size() - 1) {
                        i4++;
                        itemInfo3 = (ItemInfo) this.f6405g.get(i4);
                    }
                    i5 = i2;
                    f3 = f2;
                    i6 = i5;
                    while (i6 < itemInfo3.f6426b) {
                        d = (this.f6408j.m12660d(i6) + f) + f3;
                        i6++;
                        f3 = d;
                    }
                    itemInfo3.f6429e = f3;
                    f3 += itemInfo3.f6428d + f;
                    clientWidth = i6 + 1;
                    f2 = f3;
                    i2 = clientWidth;
                }
            } else if (clientWidth > itemInfo.f6426b) {
                i4 = this.f6405g.size() - 1;
                f2 = itemInfo2.f6429e;
                i2 = clientWidth - 1;
                while (i2 >= itemInfo.f6426b && i4 >= 0) {
                    itemInfo3 = (ItemInfo) this.f6405g.get(i4);
                    while (i2 < itemInfo3.f6426b && i4 > 0) {
                        i4--;
                        itemInfo3 = (ItemInfo) this.f6405g.get(i4);
                    }
                    i5 = i2;
                    f3 = f2;
                    i6 = i5;
                    while (i6 > itemInfo3.f6426b) {
                        d = f3 - (this.f6408j.m12660d(i6) + f);
                        i6--;
                        f3 = d;
                    }
                    f3 -= itemInfo3.f6428d + f;
                    itemInfo3.f6429e = f3;
                    clientWidth = i6 - 1;
                    f2 = f3;
                    i2 = clientWidth;
                }
            }
        }
        int size = this.f6405g.size();
        f2 = itemInfo.f6429e;
        i2 = itemInfo.f6426b - 1;
        this.f6419u = itemInfo.f6426b == 0 ? itemInfo.f6429e : -3.4028235E38f;
        this.f6420v = itemInfo.f6426b == b + -1 ? (itemInfo.f6429e + itemInfo.f6428d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            itemInfo3 = (ItemInfo) this.f6405g.get(i3);
            float f4 = f2;
            while (i2 > itemInfo3.f6426b) {
                f4 -= this.f6408j.m12660d(i2) + f;
                i2--;
            }
            f2 = f4 - (itemInfo3.f6428d + f);
            itemInfo3.f6429e = f2;
            if (itemInfo3.f6426b == 0) {
                this.f6419u = f2;
            }
            i2--;
        }
        f2 = (itemInfo.f6429e + itemInfo.f6428d) + f;
        i2 = itemInfo.f6426b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            itemInfo3 = (ItemInfo) this.f6405g.get(i3);
            f4 = f2;
            while (i2 < itemInfo3.f6426b) {
                f4 = (this.f6408j.m12660d(i2) + f) + f4;
                i2++;
            }
            if (itemInfo3.f6426b == b - 1) {
                this.f6420v = (itemInfo3.f6428d + f4) - 1.0f;
            }
            itemInfo3.f6429e = f4;
            f2 = f4 + (itemInfo3.f6428d + f);
            i2++;
        }
        this.aa = false;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f6409k;
        if (this.f6408j != null) {
            savedState.b = this.f6408j.gG_();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f6408j != null) {
                this.f6408j.mo1709a(savedState.b, savedState.c);
                m10790a(savedState.a, false, true);
                return;
            }
            this.f6410l = savedState.a;
            this.f6411m = savedState.b;
            this.f6412n = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.f8956a |= view instanceof Decor;
        if (!this.f6423y) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.f8956a) {
            layoutParams3.f8959d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f6423y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private ItemInfo m10785a(View view) {
        for (int i = 0; i < this.f6405g.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.f6405g.get(i);
            if (this.f6408j.mo1716a(view, itemInfo.f6425a)) {
                return itemInfo;
            }
        }
        return null;
    }

    private ItemInfo m10799b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m10785a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private ItemInfo m10802c(int i) {
        for (int i2 = 0; i2 < this.f6405g.size(); i2++) {
            ItemInfo itemInfo = (ItemInfo) this.f6405g.get(i2);
            if (itemInfo.f6426b == i) {
                return itemInfo;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1082060476);
        super.onAttachedToWindow();
        this.al = true;
        this.f6401W = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1017043608, a);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f6385G = Math.min(measuredWidth / 10, this.f6384F);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f8956a) {
                    int i6 = layoutParams.f8957b & 7;
                    int i7 = layoutParams.f8957b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f6421w = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f6422x = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f6423y = true;
        m10822b();
        this.f6423y = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.f8956a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.f8958c * ((float) paddingLeft)), 1073741824), this.f6422x);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 665317803);
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m10788a(i, i3, this.f6415q, this.f6415q);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2145710515, a);
    }

    private void m10788a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f6405g.isEmpty()) {
            ItemInfo c = m10802c(this.f6409k);
            int min = (int) ((c != null ? Math.min(c.f6429e, this.f6420v) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m10795a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f6413o.isFinished()) {
            this.f6413o.startScroll(paddingLeft, 0, (int) (m10802c(this.f6409k).f6429e * ((float) i)), 0, this.f6413o.getDuration() - this.f6413o.timePassed());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f8956a) {
                    int i9 = layoutParams.f8957b & 112;
                    switch (layoutParams.f8957b & 7) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.f8956a) {
                    ItemInfo a = m10785a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f6429e * ((float) max))) + paddingLeft;
                        if (layoutParams.f8959d) {
                            layoutParams.f8959d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.f8958c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f6417s = paddingTop;
        this.f6418t = i6 - paddingBottom;
        this.ac = i7;
        if (this.f6401W) {
            m10789a(this.f6409k, false, 0, false);
        }
        this.f6401W = false;
    }

    public void computeScroll() {
        if (this.f6413o.isFinished() || !this.f6413o.computeScrollOffset()) {
            m10795a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f6413o.getCurrX();
        int currY = this.f6413o.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m10805d(currX)) {
                this.f6413o.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.m10956d(this);
    }

    private boolean m10805d(int i) {
        if (this.f6405g.size() == 0) {
            this.ab = false;
            m10786a(0, 0.0f, 0);
            if (this.ab) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo j = m10810j();
        int clientWidth = getClientWidth();
        int i2 = this.f6415q + clientWidth;
        float f = ((float) this.f6415q) / ((float) clientWidth);
        int i3 = j.f6426b;
        float f2 = ((((float) i) / ((float) clientWidth)) - j.f6429e) / (j.f6428d + f);
        clientWidth = (int) (((float) i2) * f2);
        this.ab = false;
        m10786a(i3, f2, clientWidth);
        if (this.ab) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void m10786a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.ac > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f8956a) {
                    int max;
                    switch (layoutParams.f8957b & 7) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        this.f6403c = i;
        this.f6404d = f;
        if (this.ae != null) {
            this.ae.mo1723a(i, f, i2);
        }
        if (this.af != null) {
            this.af.mo1723a(i, f, i2);
        }
        if (this.ah != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).f8956a) {
                    this.ah.a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.ab = true;
    }

    private void m10795a(boolean z) {
        int scrollX;
        boolean z2 = this.ao == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f6413o.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f6413o.getCurrX();
            int currY = this.f6413o.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f6379A = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f6405g.size(); scrollX++) {
            ItemInfo itemInfo = (ItemInfo) this.f6405g.get(scrollX);
            if (itemInfo.f6427c) {
                itemInfo.f6427c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.m10943a((View) this, this.an);
        } else {
            this.an.run();
        }
    }

    protected boolean mo1481a(float f, float f2) {
        return (f < ((float) this.f6385G) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f6385G)) && f2 < 0.0f);
    }

    private void m10801b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ViewCompat.m10937a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f6382D = false;
            this.f6383E = false;
            this.f6391M = -1;
            if (this.f6392N == null) {
                return false;
            }
            this.f6392N.recycle();
            this.f6392N = null;
            return false;
        }
        if (action != 0) {
            if (this.f6382D) {
                return true;
            }
            if (this.f6383E) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f6389K = x;
                this.f6387I = x;
                x = motionEvent.getY();
                this.f6390L = x;
                this.f6388J = x;
                this.f6391M = MotionEventCompat.b(motionEvent, 0);
                this.f6383E = false;
                this.f6413o.computeScrollOffset();
                if (this.ao == 2 && Math.abs(this.f6413o.getFinalX() - this.f6413o.getCurrX()) > this.f6396R) {
                    this.f6413o.abortAnimation();
                    this.f6379A = false;
                    m10822b();
                    if (this.ad) {
                        this.f6382D = true;
                        setScrollState(this, 1);
                        break;
                    }
                }
                m10795a(false);
                this.f6382D = false;
                break;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                action = this.f6391M;
                if (action != -1) {
                    action = MotionEventCompat.a(motionEvent, action);
                    float c = MotionEventCompat.c(motionEvent, action);
                    float f = c - this.f6387I;
                    float abs = Math.abs(f);
                    float d = MotionEventCompat.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f6390L);
                    if (f == 0.0f || mo1481a(this.f6387I, f) || !mo1485a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f6386H) && 0.5f * abs > abs2) {
                            this.f6382D = true;
                            m10803c(true);
                            setScrollState(this, 1);
                            this.f6387I = f > 0.0f ? this.f6389K + ((float) this.f6386H) : this.f6389K - ((float) this.f6386H);
                            this.f6388J = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f6386H)) {
                            this.f6383E = true;
                        }
                        if (this.f6382D && m10804c(c)) {
                            ViewCompat.m10956d(this);
                            break;
                        }
                    }
                    this.f6387I = c;
                    this.f6388J = d;
                    this.f6383E = true;
                    return false;
                }
                break;
            case 6:
                m10794a(motionEvent);
                break;
        }
        if (this.f6392N == null) {
            this.f6392N = VelocityTracker.obtain();
        }
        this.f6392N.addMovement(motionEvent);
        return this.f6382D;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1225455073);
        if (this.f6397S) {
            Logger.a(2, EntryType.UI_INPUT_END, 658367851, a);
            return true;
        } else if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            LogUtils.a(1272481566, a);
            return false;
        } else if (this.f6408j == null || this.f6408j.mo1711b() == 0) {
            LogUtils.a(124400264, a);
            return false;
        } else {
            if (this.f6392N == null) {
                this.f6392N = VelocityTracker.obtain();
            }
            this.f6392N.addMovement(motionEvent);
            float x;
            int a2;
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f6413o.abortAnimation();
                    this.f6379A = false;
                    m10822b();
                    if (this.ad) {
                        this.f6382D = true;
                        m10803c(true);
                        setScrollState(this, 1);
                    }
                    x = motionEvent.getX();
                    this.f6389K = x;
                    this.f6387I = x;
                    x = motionEvent.getY();
                    this.f6390L = x;
                    this.f6388J = x;
                    this.f6391M = MotionEventCompat.b(motionEvent, 0);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (this.f6382D) {
                        VelocityTracker velocityTracker = this.f6392N;
                        velocityTracker.computeCurrentVelocity(1000, (float) this.f6394P);
                        a2 = (int) VelocityTrackerCompat.a(velocityTracker, this.f6391M);
                        this.f6379A = true;
                        int clientWidth = getClientWidth();
                        int scrollX = getScrollX();
                        ItemInfo j = m10810j();
                        m10791a(m10781a(j.f6426b, ((((float) scrollX) / ((float) clientWidth)) - j.f6429e) / j.f6428d, a2, (int) (MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f6391M)) - this.f6389K)), true, true, a2);
                        this.f6391M = -1;
                        m10811k();
                        z = this.f6400V.m10843c() | this.f6399U.m10843c();
                        break;
                    }
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (!this.f6382D) {
                        a2 = MotionEventCompat.a(motionEvent, this.f6391M);
                        float c = MotionEventCompat.c(motionEvent, a2);
                        float abs = Math.abs(c - this.f6387I);
                        float d = MotionEventCompat.d(motionEvent, a2);
                        x = Math.abs(d - this.f6388J);
                        if (abs > ((float) this.f6386H) && abs > x) {
                            this.f6382D = true;
                            m10803c(true);
                            if (c - this.f6389K > 0.0f) {
                                x = this.f6389K + ((float) this.f6386H);
                            } else {
                                x = this.f6389K - ((float) this.f6386H);
                            }
                            this.f6387I = x;
                            this.f6388J = d;
                            setScrollState(this, 1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.f6382D) {
                        z = m10804c(MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f6391M))) | 0;
                        break;
                    }
                    break;
                case 3:
                    if (this.f6382D) {
                        m10789a(this.f6409k, true, 0, false);
                        this.f6391M = -1;
                        m10811k();
                        z = this.f6400V.m10843c() | this.f6399U.m10843c();
                        break;
                    }
                    break;
                case 5:
                    a2 = MotionEventCompat.b(motionEvent);
                    this.f6387I = MotionEventCompat.c(motionEvent, a2);
                    this.f6391M = MotionEventCompat.b(motionEvent, a2);
                    break;
                case 6:
                    m10794a(motionEvent);
                    this.f6387I = MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f6391M));
                    break;
            }
            if (z) {
                ViewCompat.m10956d(this);
            }
            LogUtils.a(-668873660, a);
            return true;
        }
    }

    private void m10803c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m10804c(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f6387I - f;
        this.f6387I = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f6419u;
        float f5 = ((float) clientWidth) * this.f6420v;
        ItemInfo itemInfo = (ItemInfo) this.f6405g.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.f6405g.get(this.f6405g.size() - 1);
        if (itemInfo.f6426b != 0) {
            f4 = itemInfo.f6429e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f6426b != this.f6408j.mo1711b() - 1) {
            f2 = itemInfo2.f6429e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f6399U.m10838a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f6400V.m10838a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f6387I += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m10805d((int) f4);
        return z3;
    }

    private ItemInfo m10810j() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f6415q) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        ItemInfo itemInfo = null;
        while (i2 < this.f6405g.size()) {
            int i3;
            ItemInfo itemInfo2;
            ItemInfo itemInfo3 = (ItemInfo) this.f6405g.get(i2);
            ItemInfo itemInfo4;
            if (obj != null || itemInfo3.f6426b == i + 1) {
                itemInfo4 = itemInfo3;
                i3 = i2;
                itemInfo2 = itemInfo4;
            } else {
                itemInfo3 = this.f6406h;
                itemInfo3.f6429e = (f2 + f3) + f;
                itemInfo3.f6426b = i + 1;
                itemInfo3.f6428d = this.f6408j.m12660d(itemInfo3.f6426b);
                itemInfo4 = itemInfo3;
                i3 = i2 - 1;
                itemInfo2 = itemInfo4;
            }
            f2 = itemInfo2.f6429e;
            f3 = (itemInfo2.f6428d + f2) + f;
            if (obj == null && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f3 || i3 == this.f6405g.size() - 1) {
                return itemInfo2;
            }
            f3 = f2;
            i = itemInfo2.f6426b;
            obj = null;
            f2 = itemInfo2.f6428d;
            itemInfo = itemInfo2;
            i2 = i3 + 1;
        }
        return itemInfo;
    }

    private int m10781a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f6395Q || Math.abs(i2) <= this.f6393O) {
            i = (int) ((i >= this.f6409k ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f6405g.size() <= 0) {
            return i;
        }
        return Math.max(((ItemInfo) this.f6405g.get(0)).f6426b, Math.min(i, ((ItemInfo) this.f6405g.get(this.f6405g.size() - 1)).f6426b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ViewCompat.m10934a(this);
        if (a == 0 || (a == 1 && this.f6408j != null && this.f6408j.mo1711b() > 1)) {
            int width;
            if (!this.f6399U.m10837a()) {
                a = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.f6419u * ((float) width));
                this.f6399U.m10836a(i, width);
                i = this.f6399U.m10841a(canvas) | 0;
                canvas.restoreToCount(a);
            }
            if (!this.f6400V.m10837a()) {
                a = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f6420v + 1.0f)) * ((float) width));
                this.f6400V.m10836a(height, width);
                i |= this.f6400V.m10841a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f6399U.m10842b();
            this.f6400V.m10842b();
        }
        if (i != 0) {
            ViewCompat.m10956d(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6415q > 0 && this.f6416r != null && this.f6405g.size() > 0 && this.f6408j != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f6415q) / ((float) width);
            ItemInfo itemInfo = (ItemInfo) this.f6405g.get(0);
            float f2 = itemInfo.f6429e;
            int size = this.f6405g.size();
            int i = itemInfo.f6426b;
            int i2 = ((ItemInfo) this.f6405g.get(size - 1)).f6426b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > itemInfo.f6426b && i3 < size) {
                    i3++;
                    itemInfo = (ItemInfo) this.f6405g.get(i3);
                }
                if (i4 == itemInfo.f6426b) {
                    f3 = (itemInfo.f6429e + itemInfo.f6428d) * ((float) width);
                    f2 = (itemInfo.f6429e + itemInfo.f6428d) + f;
                } else {
                    float d = this.f6408j.m12660d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.f6415q) + f3 > ((float) scrollX)) {
                    this.f6416r.setBounds((int) f3, this.f6417s, (int) ((((float) this.f6415q) + f3) + 0.5f), this.f6418t);
                    this.f6416r.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean m10823c() {
        if (this.f6382D) {
            return false;
        }
        this.f6397S = true;
        setScrollState(this, 1);
        this.f6387I = 0.0f;
        this.f6389K = 0.0f;
        if (this.f6392N == null) {
            this.f6392N = VelocityTracker.obtain();
        } else {
            this.f6392N.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f6392N.addMovement(obtain);
        obtain.recycle();
        this.f6398T = uptimeMillis;
        return true;
    }

    public final void m10824d() {
        if (this.f6397S) {
            VelocityTracker velocityTracker = this.f6392N;
            velocityTracker.computeCurrentVelocity(1000, (float) this.f6394P);
            int a = (int) VelocityTrackerCompat.a(velocityTracker, this.f6391M);
            this.f6379A = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo j = m10810j();
            m10791a(m10781a(j.f6426b, ((((float) scrollX) / ((float) clientWidth)) - j.f6429e) / j.f6428d, a, (int) (this.f6387I - this.f6389K)), true, true, a);
            m10811k();
            this.f6397S = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public final void m10816a(float f) {
        if (this.f6397S) {
            float f2;
            float f3;
            this.f6387I += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f4 = ((float) clientWidth) * this.f6419u;
            float f5 = ((float) clientWidth) * this.f6420v;
            ItemInfo itemInfo = (ItemInfo) this.f6405g.get(0);
            ItemInfo itemInfo2 = (ItemInfo) this.f6405g.get(this.f6405g.size() - 1);
            if (itemInfo.f6426b != 0) {
                f2 = itemInfo.f6429e * ((float) clientWidth);
            } else {
                f2 = f4;
            }
            if (itemInfo2.f6426b != this.f6408j.mo1711b() - 1) {
                f3 = itemInfo2.f6429e * ((float) clientWidth);
            } else {
                f3 = f5;
            }
            if (scrollX >= f2) {
                if (scrollX > f3) {
                    f2 = f3;
                } else {
                    f2 = scrollX;
                }
            }
            this.f6387I += f2 - ((float) ((int) f2));
            scrollTo((int) f2, getScrollY());
            m10805d((int) f2);
            MotionEvent obtain = MotionEvent.obtain(this.f6398T, SystemClock.uptimeMillis(), 2, this.f6387I, 0.0f, 0);
            this.f6392N.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public final boolean m10825e() {
        return this.f6397S;
    }

    private void m10794a(MotionEvent motionEvent) {
        int b = MotionEventCompat.b(motionEvent);
        if (MotionEventCompat.b(motionEvent, b) == this.f6391M) {
            b = b == 0 ? 1 : 0;
            this.f6387I = MotionEventCompat.c(motionEvent, b);
            this.f6391M = MotionEventCompat.b(motionEvent, b);
            if (this.f6392N != null) {
                this.f6392N.clear();
            }
        }
    }

    private void m10811k() {
        this.f6382D = false;
        this.f6383E = false;
        if (this.f6392N != null) {
            this.f6392N.recycle();
            this.f6392N = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f6424z != z) {
            this.f6424z = z;
        }
    }

    protected boolean mo1485a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (mo1485a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ViewCompat.m10946a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m10796a(keyEvent);
    }

    private boolean m10796a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return mo1484a(17);
            case 22:
                return mo1484a(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (KeyEventCompat.a(keyEvent)) {
                    return mo1484a(2);
                }
                if (KeyEventCompat.a.a(keyEvent.getMetaState(), 1)) {
                    return mo1484a(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean mo1484a(int i) {
        View view;
        boolean l;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                l = m10812l();
            } else {
                if (i == 66 || i == 2) {
                    l = m10813m();
                }
                l = false;
            }
        } else if (i == 17) {
            l = (view == null || m10782a(this.f6407i, findNextFocus).left < m10782a(this.f6407i, view).left) ? findNextFocus.requestFocus() : m10812l();
        } else {
            if (i == 66) {
                l = (view == null || m10782a(this.f6407i, findNextFocus).left > m10782a(this.f6407i, view).left) ? findNextFocus.requestFocus() : m10813m();
            }
            l = false;
        }
        if (l) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return l;
    }

    private Rect m10782a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean m10812l() {
        if (this.f6409k <= 0) {
            return false;
        }
        m10817a(this.f6409k - 1, true);
        return true;
    }

    private boolean m10813m() {
        if (this.f6408j == null || this.f6409k >= this.f6408j.mo1711b() - 1) {
            return false;
        }
        m10817a(this.f6409k + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo a = m10785a(childAt);
                    if (a != null && a.f6426b == this.f6409k) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m10785a(childAt);
                if (a != null && a.f6426b == this.f6409k) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m10785a(childAt);
                if (a != null && a.f6426b == this.f6409k && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m10785a(childAt);
                if (a != null && a.f6426b == this.f6409k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}

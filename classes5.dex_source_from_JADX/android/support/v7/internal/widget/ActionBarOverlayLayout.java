package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.internal.VersionUtils;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: upsell_buy_maybe_impression */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent {
    static final int[] f1017a = new int[]{2130771988, 16842841};
    public final ViewPropertyAnimatorListener f1018A = new C00501(this);
    public final ViewPropertyAnimatorListener f1019B = new C00512(this);
    private final Runnable f1020C = new C00523(this);
    private final Runnable f1021D = new C00534(this);
    private int f1022b;
    private int f1023c = 0;
    private ContentFrameLayout f1024d;
    public ActionBarContainer f1025e;
    public ActionBarContainer f1026f;
    private DecorToolbar f1027g;
    private Drawable f1028h;
    private boolean f1029i;
    public boolean f1030j;
    public boolean f1031k;
    private boolean f1032l;
    public boolean f1033m;
    private int f1034n;
    private int f1035o;
    private final Rect f1036p = new Rect();
    private final Rect f1037q = new Rect();
    private final Rect f1038r = new Rect();
    private final Rect f1039s = new Rect();
    private final Rect f1040t = new Rect();
    private final Rect f1041u = new Rect();
    private ActionBarVisibilityCallback f1042v;
    private final int f1043w = 600;
    private ScrollerCompat f1044x;
    public ViewPropertyAnimatorCompat f1045y;
    public ViewPropertyAnimatorCompat f1046z;

    /* compiled from: upsell_buy_maybe_impression */
    public interface ActionBarVisibilityCallback {
        void mo281e(int i);

        void mo282e(boolean z);

        void mo284j();

        void mo285k();

        void mo286l();
    }

    /* compiled from: upsell_buy_maybe_impression */
    class C00501 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ ActionBarOverlayLayout f1013a;

        C00501(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1013a = actionBarOverlayLayout;
        }

        public final void mo88b(View view) {
            this.f1013a.f1045y = null;
            this.f1013a.f1033m = false;
        }

        public final void mo89c(View view) {
            this.f1013a.f1045y = null;
            this.f1013a.f1033m = false;
        }
    }

    /* compiled from: upsell_buy_maybe_impression */
    class C00512 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ ActionBarOverlayLayout f1014a;

        C00512(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1014a = actionBarOverlayLayout;
        }

        public final void mo88b(View view) {
            this.f1014a.f1046z = null;
            this.f1014a.f1033m = false;
        }

        public final void mo89c(View view) {
            this.f1014a.f1046z = null;
            this.f1014a.f1033m = false;
        }
    }

    /* compiled from: upsell_buy_maybe_impression */
    class C00523 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1015a;

        C00523(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1015a = actionBarOverlayLayout;
        }

        public void run() {
            ActionBarOverlayLayout.m1552k(this.f1015a);
            this.f1015a.f1045y = ViewCompat.t(this.f1015a.f1026f).m496c(0.0f).m489a(this.f1015a.f1018A);
            if (this.f1015a.f1025e != null && this.f1015a.f1025e.getVisibility() != 8) {
                this.f1015a.f1046z = ViewCompat.t(this.f1015a.f1025e).m496c(0.0f).m489a(this.f1015a.f1019B);
            }
        }
    }

    /* compiled from: upsell_buy_maybe_impression */
    class C00534 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1016a;

        C00534(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1016a = actionBarOverlayLayout;
        }

        public void run() {
            ActionBarOverlayLayout.m1552k(this.f1016a);
            this.f1016a.f1045y = ViewCompat.t(this.f1016a.f1026f).m496c((float) (-this.f1016a.f1026f.getHeight())).m489a(this.f1016a.f1018A);
            if (this.f1016a.f1025e != null && this.f1016a.f1025e.getVisibility() != 8) {
                this.f1016a.f1046z = ViewCompat.t(this.f1016a.f1025e).m496c((float) this.f1016a.f1025e.getHeight()).m489a(this.f1016a.f1019B);
            }
        }
    }

    /* compiled from: upsell_buy_maybe_impression */
    public class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ActionBarOverlayLayout(Context context) {
        super(context);
        m1541a(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1541a(context);
    }

    private void m1541a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1017a);
        this.f1022b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1028h = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1028h == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1029i = z;
        this.f1044x = ScrollerCompat.a(context);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1897705861);
        super.onDetachedFromWindow();
        m1552k(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1686874018, a);
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f1042v = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f1042v.mo281e(this.f1023c);
            if (this.f1035o != 0) {
                onWindowSystemUiVisibilityChanged(this.f1035o);
                ViewCompat.z(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1030j = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1029i = z2;
    }

    public final boolean m1559a() {
        return this.f1030j;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1031k = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m1541a(getContext());
        ViewCompat.z(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m1551j();
        int i2 = this.f1035o ^ i;
        this.f1035o = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1042v != null) {
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1042v;
            if (z) {
                z2 = false;
            }
            actionBarVisibilityCallback.mo282e(z2);
            if (z3 || !z) {
                this.f1042v.mo284j();
            } else {
                this.f1042v.mo285k();
            }
        }
        if ((i2 & 256) != 0 && this.f1042v != null) {
            ViewCompat.z(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 642799267);
        super.onWindowVisibilityChanged(i);
        this.f1023c = i;
        if (this.f1042v != null) {
            this.f1042v.mo281e(i);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 402711035, a);
    }

    private static boolean m1545a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        m1551j();
        ViewCompat.y(this);
        boolean z = false;
        this.f1039s.set(rect);
        ViewUtils.m1755a(this, this.f1039s, this.f1036p);
        if (!this.f1037q.equals(this.f1036p)) {
            this.f1037q.set(this.f1036p);
            z = true;
        }
        if (z) {
            requestLayout();
        }
        return true;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int max;
        int max2;
        int a;
        int i3;
        int i4;
        int i5;
        m1551j();
        measureChildWithMargins(this.f1026f, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1026f.getLayoutParams();
        int max3 = Math.max(0, (this.f1026f.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max4 = Math.max(0, layoutParams.bottomMargin + (this.f1026f.getMeasuredHeight() + layoutParams.topMargin));
        int a2 = ViewUtils.m1753a(0, ViewCompat.m(this.f1026f));
        if (this.f1025e != null) {
            measureChildWithMargins(this.f1025e, i, 0, i2, 0);
            layoutParams = (LayoutParams) this.f1025e.getLayoutParams();
            max = Math.max(max3, (this.f1025e.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
            max2 = Math.max(max4, layoutParams.bottomMargin + (this.f1025e.getMeasuredHeight() + layoutParams.topMargin));
            a = ViewUtils.m1753a(a2, ViewCompat.m(this.f1025e));
            i3 = max;
            i4 = max2;
        } else {
            a = a2;
            i3 = max3;
            i4 = max4;
        }
        boolean z = (ViewCompat.y(this) & 256) != 0;
        if (z) {
            i5 = this.f1022b;
            if (this.f1031k && this.f1026f.getTabContainer() != null) {
                i5 += this.f1022b;
            }
        } else {
            i5 = this.f1026f.getVisibility() != 8 ? this.f1026f.getMeasuredHeight() : 0;
        }
        if (!this.f1027g.mo396c() || this.f1025e == null) {
            max = 0;
        } else if (z) {
            max = this.f1022b;
        } else {
            max = this.f1025e.getMeasuredHeight();
        }
        this.f1038r.set(this.f1036p);
        this.f1040t.set(this.f1039s);
        Rect rect;
        Rect rect2;
        if (this.f1030j || z) {
            rect = this.f1040t;
            rect.top = i5 + rect.top;
            rect2 = this.f1040t;
            rect2.bottom = max + rect2.bottom;
        } else {
            rect = this.f1038r;
            rect.top = i5 + rect.top;
            rect2 = this.f1038r;
            rect2.bottom = max + rect2.bottom;
        }
        m1545a(this.f1024d, this.f1038r, true, true, true, true);
        if (!this.f1041u.equals(this.f1040t)) {
            this.f1041u.set(this.f1040t);
            this.f1024d.m1592a(this.f1040t);
        }
        measureChildWithMargins(this.f1024d, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.f1024d.getLayoutParams();
        max = Math.max(i3, (this.f1024d.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i5 = Math.max(i4, layoutParams.bottomMargin + (this.f1024d.getMeasuredHeight() + layoutParams.topMargin));
        max2 = ViewUtils.m1753a(a, ViewCompat.m(this.f1024d));
        setMeasuredDimension(ViewCompat.a(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, max2), ViewCompat.a(Math.max(i5 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, max2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int i6;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                if (childAt == this.f1025e) {
                    i6 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                } else {
                    i6 = layoutParams.topMargin + paddingTop;
                }
                childAt.layout(i7, i6, measuredWidth + i7, measuredHeight + i6);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1028h != null && !this.f1029i) {
            int bottom = this.f1026f.getVisibility() == 0 ? (int) ((((float) this.f1026f.getBottom()) + ViewCompat.q(this.f1026f)) + 0.5f) : 0;
            this.f1028h.setBounds(0, bottom, getWidth(), this.f1028h.getIntrinsicHeight() + bottom);
            this.f1028h.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1026f.getVisibility() != 0) {
            return false;
        }
        return this.f1032l;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
        this.f1034n = getActionBarHideOffset();
        m1552k(this);
        if (this.f1042v != null) {
            this.f1042v.mo286l();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1034n += i2;
        setActionBarHideOffset(this.f1034n);
    }

    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
        if (this.f1032l && !this.f1033m) {
            if (this.f1034n <= this.f1026f.getHeight()) {
                m1553l();
            } else {
                m1554m();
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1032l || !z) {
            return false;
        }
        if (m1543a(f2)) {
            m1556o();
        } else {
            m1555n();
        }
        this.f1033m = true;
        return true;
    }

    private void m1551j() {
        if (this.f1024d == null) {
            this.f1024d = (ContentFrameLayout) findViewById(2131558403);
            this.f1026f = (ActionBarContainer) findViewById(2131559129);
            this.f1027g = m1540a(findViewById(2131559130));
            this.f1025e = (ActionBarContainer) findViewById(2131558404);
        }
    }

    private static DecorToolbar m1540a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1032l) {
            this.f1032l = z;
            if (!z) {
                if (VersionUtils.m1192a()) {
                    stopNestedScroll();
                }
                m1552k(this);
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f1026f != null ? -((int) ViewCompat.q(this.f1026f)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m1552k(this);
        int height = this.f1026f.getHeight();
        int max = Math.max(0, Math.min(i, height));
        ViewCompat.b(this.f1026f, (float) (-max));
        if (this.f1025e != null && this.f1025e.getVisibility() != 8) {
            ViewCompat.b(this.f1025e, (float) ((int) ((((float) max) / ((float) height)) * ((float) this.f1025e.getHeight()))));
        }
    }

    public static void m1552k(ActionBarOverlayLayout actionBarOverlayLayout) {
        actionBarOverlayLayout.removeCallbacks(actionBarOverlayLayout.f1020C);
        actionBarOverlayLayout.removeCallbacks(actionBarOverlayLayout.f1021D);
        if (actionBarOverlayLayout.f1045y != null) {
            actionBarOverlayLayout.f1045y.m492a();
        }
        if (actionBarOverlayLayout.f1046z != null) {
            actionBarOverlayLayout.f1046z.m492a();
        }
    }

    private void m1553l() {
        m1552k(this);
        postDelayed(this.f1020C, 600);
    }

    private void m1554m() {
        m1552k(this);
        postDelayed(this.f1021D, 600);
    }

    private void m1555n() {
        m1552k(this);
        this.f1020C.run();
    }

    private void m1556o() {
        m1552k(this);
        this.f1021D.run();
    }

    private boolean m1543a(float f) {
        this.f1044x.a(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1044x.e() > this.f1026f.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        m1551j();
        this.f1027g.mo389a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m1551j();
        this.f1027g.mo390a(charSequence);
    }

    public CharSequence getTitle() {
        m1551j();
        return this.f1027g.mo401f();
    }

    public final void mo347a(int i) {
        m1551j();
        switch (i) {
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f1027g.mo403g();
                return;
            case 5:
                this.f1027g.mo405h();
                return;
            case 9:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m1551j();
        this.f1027g.mo384a(i);
    }

    public void setIcon(Drawable drawable) {
        m1551j();
        this.f1027g.mo385a(drawable);
    }

    public void setLogo(int i) {
        m1551j();
        this.f1027g.mo393b(i);
    }

    public final boolean mo349b() {
        m1551j();
        return this.f1027g.mo406i();
    }

    public final boolean mo350c() {
        m1551j();
        return this.f1027g.mo407j();
    }

    public final boolean mo351d() {
        m1551j();
        return this.f1027g.mo408k();
    }

    public final boolean mo352e() {
        m1551j();
        return this.f1027g.mo409l();
    }

    public final boolean mo353f() {
        m1551j();
        return this.f1027g.mo410m();
    }

    public final void mo354g() {
        m1551j();
        this.f1027g.mo411n();
    }

    public final void mo348a(Menu menu, MenuPresenter.Callback callback) {
        m1551j();
        this.f1027g.mo387a(menu, callback);
    }

    public final void mo355h() {
        m1551j();
        this.f1027g.mo412o();
    }
}

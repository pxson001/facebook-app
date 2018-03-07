package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: upperBound */
public class ActionMenuView extends LinearLayoutCompat implements ItemInvoker, MenuView {
    public MenuBuilder f1302a;
    private Context f1303b;
    private Context f1304c;
    private int f1305d;
    public boolean f1306e;
    private ActionMenuPresenter f1307f;
    private Callback f1308g;
    public MenuBuilder.Callback f1309h;
    private boolean f1310i;
    private int f1311j;
    private int f1312k;
    private int f1313l;
    public OnMenuItemClickListener f1314m;

    /* compiled from: upperBound */
    public interface ActionMenuChildView {
        boolean mo302c();

        boolean mo303d();
    }

    /* compiled from: upperBound */
    class ActionMenuPresenterCallback implements Callback {
        final /* synthetic */ ActionMenuView f1292a;

        public ActionMenuPresenterCallback(ActionMenuView actionMenuView) {
            this.f1292a = actionMenuView;
        }

        public final void mo228a(MenuBuilder menuBuilder, boolean z) {
        }

        public final boolean a_(MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* compiled from: upperBound */
    public class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean f1295a;
        @ExportedProperty
        public int f1296b;
        @ExportedProperty
        public int f1297c;
        @ExportedProperty
        public boolean f1298d;
        @ExportedProperty
        public boolean f1299e;
        boolean f1300f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1295a = layoutParams.f1295a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1295a = false;
        }
    }

    /* compiled from: upperBound */
    class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ActionMenuView f1301a;

        public MenuBuilderCallback(ActionMenuView actionMenuView) {
            this.f1301a = actionMenuView;
        }

        public final boolean mo214a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return this.f1301a.f1314m != null && this.f1301a.f1314m.mo453a(menuItem);
        }

        public final void b_(MenuBuilder menuBuilder) {
            if (this.f1301a.f1309h != null) {
                this.f1301a.f1309h.b_(menuBuilder);
            }
        }
    }

    /* compiled from: upperBound */
    public interface OnMenuItemClickListener {
        boolean mo453a(MenuItem menuItem);
    }

    protected /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return m1794i();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams m23575generateDefaultLayoutParams() {
        return m1794i();
    }

    public /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1789a(attributeSet);
    }

    protected /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m1795a(layoutParams);
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams m23576generateLayoutParams(AttributeSet attributeSet) {
        return m1789a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams m23577generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m1795a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1303b = context;
        this.mBaselineAligned = false;
        float f = context.getResources().getDisplayMetrics().density;
        this.f1312k = (int) (56.0f * f);
        this.f1313l = (int) (f * 4.0f);
        this.f1304c = context;
        this.f1305d = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f1305d != i) {
            this.f1305d = i;
            if (i == 0) {
                this.f1304c = this.f1303b;
            } else {
                this.f1304c = new ContextThemeWrapper(this.f1303b, i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1305d;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1307f = actionMenuPresenter;
        this.f1307f.m1771a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1307f != null) {
            this.f1307f.mo309b(false);
            if (this.f1307f.m1784h()) {
                this.f1307f.m1781e();
                this.f1307f.m1780d();
            }
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1314m = onMenuItemClickListener;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1310i;
        this.f1310i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1310i) {
            this.f1311j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1310i || this.f1302a == null || size == this.f1311j)) {
            this.f1311j = size;
            this.f1302a.m1410b(true);
        }
        int childCount = getChildCount();
        if (!this.f1310i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m1791a(i, i2);
    }

    private void m1791a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1312k;
        size = i3 % this.f1312k;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        LayoutParams layoutParams;
        Object obj;
        Object obj2;
        int i6 = this.f1312k + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            int i12;
            long j2;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1313l, 0, this.f1313l, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1300f = false;
                layoutParams.f1297c = 0;
                layoutParams.f1296b = 0;
                layoutParams.f1298d = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m1343b();
                layoutParams.f1299e = z2;
                if (layoutParams.f1295a) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int a = m1788a(childAt, i6, paddingLeft, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                if (layoutParams.f1298d) {
                    paddingLeft = i9 + 1;
                } else {
                    paddingLeft = i9;
                }
                if (layoutParams.f1295a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i11 = i9;
                    i12 = i14;
                    i9 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i8;
                    i13 = i5;
                } else {
                    i13 = i5;
                    i4 = i8;
                    long j4 = j;
                    i11 = i9;
                    i12 = i14;
                    obj3 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            } else {
                i13 = paddingLeft;
                j2 = j;
                i11 = i7;
                i12 = i4;
                i4 = i8;
            }
            i10++;
            i8 = i4;
            i7 = i11;
            i4 = i12;
            j = j2;
            paddingLeft = i13;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                layoutParams = (LayoutParams) getChildAt(i15).getLayoutParams();
                if (layoutParams.f1298d) {
                    if (layoutParams.f1296b < i5) {
                        i4 = layoutParams.f1296b;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (layoutParams.f1296b == i5) {
                        j |= (long) (1 << i15);
                        size = i4 + 1;
                        i4 = i5;
                    }
                    i15++;
                    i5 = i4;
                    i4 = size;
                }
                size = i4;
                i4 = i5;
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj2 != null && layoutParams.f1299e && i4 == 1) {
                        childAt2.setPadding(this.f1313l + i6, 0, this.f1313l, 0);
                    }
                    layoutParams.f1296b++;
                    layoutParams.f1300f = true;
                    size = i4 - 1;
                } else if (layoutParams.f1296b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).f1299e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((LayoutParams) getChildAt(childCount - 1).getLayoutParams()).f1299e)) {
                    f = bitCount - 0.5f;
                    if (f <= 0.0f) {
                        paddingLeft = (int) (((float) (paddingTop * i6)) / f);
                    } else {
                        paddingLeft = 0;
                    }
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            childAt3 = getChildAt(i4);
                            layoutParams = (LayoutParams) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                layoutParams.f1297c = paddingLeft;
                                layoutParams.f1300f = true;
                                if (i4 == 0 && !layoutParams.f1299e) {
                                    layoutParams.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (layoutParams.f1295a) {
                                if (i4 != 0) {
                                    layoutParams.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    layoutParams.rightMargin = paddingLeft / 2;
                                }
                            } else {
                                layoutParams.f1297c = paddingLeft;
                                layoutParams.f1300f = true;
                                layoutParams.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                            i4++;
                            obj2 = obj;
                        }
                        obj = obj2;
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
                paddingLeft = 0;
            } else {
                paddingLeft = (int) (((float) (paddingTop * i6)) / f);
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams.f1297c = paddingLeft;
                        layoutParams.f1300f = true;
                        layoutParams.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (layoutParams.f1295a) {
                        if (i4 != 0) {
                            layoutParams.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            layoutParams.rightMargin = paddingLeft / 2;
                        }
                    } else {
                        layoutParams.f1297c = paddingLeft;
                        layoutParams.f1300f = true;
                        layoutParams.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                    i4++;
                    obj2 = obj;
                }
                obj = obj2;
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1300f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.f1297c + (layoutParams.f1296b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    static int m1788a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.m1343b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.f1295a && z) {
            z2 = true;
        }
        layoutParams.f1298d = z2;
        layoutParams.f1296b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1310i) {
            LayoutParams layoutParams;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = ViewUtils.m1756a(this);
            int i8 = 0;
            while (i8 < childCount) {
                Object obj2;
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.f1295a) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (m1792a(i8)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i9 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i9, i5, measuredHeight + i9);
                        measuredWidth = paddingRight - measuredWidth;
                        obj2 = 1;
                        paddingLeft = i7;
                    } else {
                        i5 = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                        m1792a(i8);
                        paddingLeft = i7 + 1;
                        Object obj3 = obj;
                        measuredWidth = i5;
                        obj2 = obj3;
                    }
                } else {
                    obj2 = obj;
                    paddingLeft = i7;
                    measuredWidth = paddingRight;
                }
                i8++;
                i7 = paddingLeft;
                paddingRight = measuredWidth;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                paddingLeft = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i7 = i6 - (paddingLeft / 2);
                childAt2.layout(paddingRight, i7, measuredWidth + paddingRight, paddingLeft + i7);
                return;
            }
            i5 = i7 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, i5 > 0 ? paddingRight / i5 : 0);
            View childAt3;
            int i10;
            if (a) {
                measuredWidth = getWidth() - getPaddingRight();
                paddingLeft = 0;
                while (paddingLeft < childCount) {
                    childAt3 = getChildAt(paddingLeft);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || layoutParams.f1295a) {
                        i5 = measuredWidth;
                    } else {
                        measuredWidth -= layoutParams.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        dividerWidth = childAt3.getMeasuredHeight();
                        i10 = i6 - (dividerWidth / 2);
                        childAt3.layout(measuredWidth - i8, i10, measuredWidth, dividerWidth + i10);
                        i5 = measuredWidth - ((layoutParams.leftMargin + i8) + paddingRight);
                    }
                    paddingLeft++;
                    measuredWidth = i5;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            paddingLeft = 0;
            while (paddingLeft < childCount) {
                childAt3 = getChildAt(paddingLeft);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams.f1295a) {
                    i5 = measuredWidth;
                } else {
                    measuredWidth += layoutParams.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    dividerWidth = childAt3.getMeasuredHeight();
                    i10 = i6 - (dividerWidth / 2);
                    childAt3.layout(measuredWidth, i10, measuredWidth + i8, dividerWidth + i10);
                    i5 = ((layoutParams.rightMargin + i8) + paddingRight) + measuredWidth;
                }
                paddingLeft++;
                measuredWidth = i5;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -737404995);
        super.onDetachedFromWindow();
        m1806h();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1651945055, a);
    }

    public final boolean m1798a() {
        return this.f1306e;
    }

    public void setOverflowReserved(boolean z) {
        this.f1306e = z;
    }

    private static LayoutParams m1794i() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.h = 16;
        return layoutParams;
    }

    private LayoutParams m1789a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected final LayoutParams m1795a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m1794i();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.f1294h > 0) {
            return layoutParams2;
        }
        layoutParams2.h = 16;
        return layoutParams2;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public final LayoutParams m1800b() {
        LayoutParams i = m1794i();
        i.f1295a = true;
        return i;
    }

    public final boolean mo314a(MenuItemImpl menuItemImpl) {
        return this.f1302a.m1406a((MenuItem) menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void mo313a(MenuBuilder menuBuilder) {
        this.f1302a = menuBuilder;
    }

    public Menu getMenu() {
        if (this.f1302a == null) {
            Callback callback;
            Context context = getContext();
            this.f1302a = new MenuBuilder(context);
            this.f1302a.mo330a(new MenuBuilderCallback(this));
            this.f1307f = new ActionMenuPresenter(context);
            this.f1307f.m1779c(true);
            BaseMenuPresenter baseMenuPresenter = this.f1307f;
            if (this.f1308g != null) {
                callback = this.f1308g;
            } else {
                callback = new ActionMenuPresenterCallback(this);
            }
            baseMenuPresenter.f810g = callback;
            this.f1302a.m1402a(this.f1307f, this.f1304c);
            this.f1307f.m1771a(this);
        }
        return this.f1302a;
    }

    public final void m1797a(Callback callback, MenuBuilder.Callback callback2) {
        this.f1308g = callback;
        this.f1309h = callback2;
    }

    public final MenuBuilder m1801c() {
        return this.f1302a;
    }

    public final boolean m1802d() {
        return this.f1307f != null && this.f1307f.m1780d();
    }

    public final boolean m1803e() {
        return this.f1307f != null && this.f1307f.m1781e();
    }

    public final boolean m1804f() {
        return this.f1307f != null && this.f1307f.m1784h();
    }

    public final boolean m1805g() {
        if (this.f1307f != null) {
            ActionMenuPresenter actionMenuPresenter = this.f1307f;
            Object obj = (actionMenuPresenter.f1290x != null || actionMenuPresenter.m1784h()) ? 1 : null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final void m1806h() {
        if (this.f1307f != null) {
            this.f1307f.m1782f();
        }
    }

    private boolean m1792a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).mo303d() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : ((ActionMenuChildView) childAt2).mo302c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1307f.f1284r = z;
    }
}

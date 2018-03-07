package com.facebook.fbui.pagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: speed_test_failed */
public class TabbedViewPagerIndicator extends HorizontalScrollView implements OnPageChangeListener {
    private final DataSetObserver f3560a;
    public ViewPager f3561b;
    public TabsContainer f3562c;
    public PagerAdapter f3563d;
    public BadgePagerAdapter f3564e;
    private float f3565f;
    private int f3566g;
    private int f3567h;
    private boolean f3568i;
    public boolean f3569j;
    public boolean f3570k;
    public OnPageChangeListener f3571l;
    public OnTabClickListener f3572m;
    public OnTabLongClickListener f3573n;
    public TransformationMethod f3574o;
    @Inject
    public ViewAccessibilityHelper f3575p;

    /* compiled from: speed_test_failed */
    public interface TabProgressListenerView {
        void mo168a(float f);
    }

    /* compiled from: speed_test_failed */
    public class TabsContainer extends SegmentedLinearLayout {
        public int f3576a;
        private Paint f3577b;
        private int f3578c;
        private int f3579d;
        private int f3580e;
        private int f3581f;
        public boolean f3582g;
        public boolean f3583h;

        public TabsContainer(Context context) {
            this(context, null);
        }

        public TabsContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3576a = 0;
            this.f3579d = 0;
            this.f3580e = 0;
            this.f3582g = false;
            this.f3577b = new Paint(1);
            this.f3581f = 2130904278;
            setWillNotDraw(false);
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.f3582g = true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (getChildCount() != 0) {
                if (this.f3579d == 0 && this.f3580e == 0) {
                    View childAt = getChildAt(this.f3576a);
                    this.f3579d = childAt.getLeft();
                    this.f3580e = childAt.getRight();
                }
                int measuredHeight = getMeasuredHeight();
                canvas.drawRect((float) this.f3579d, (float) (measuredHeight - this.f3578c), (float) this.f3580e, (float) measuredHeight, this.f3577b);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                this.f3579d = 0;
                this.f3580e = 0;
            }
        }

        public final boolean m4301a() {
            return this.f3582g;
        }

        public final void m4302b() {
            if (this.f3576a < getChildCount()) {
                setPageSelection(this.f3576a);
            }
        }

        public void setPageSelection(int i) {
            View childAt = getChildAt(this.f3576a);
            if (childAt != null) {
                childAt.setSelected(false);
            }
            childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setSelected(true);
            }
            this.f3576a = i;
            invalidate();
        }

        public final void m4300a(int i, int i2, float f) {
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i2);
            if (childAt != null && childAt2 != null) {
                this.f3579d = m4298b(childAt.getLeft(), childAt2.getLeft(), f);
                this.f3580e = m4298b(childAt.getRight(), childAt2.getRight(), f);
                if (this.f3583h) {
                    ((TabProgressListenerView) childAt2).mo168a(f);
                    ((TabProgressListenerView) childAt).mo168a(1.0f - f);
                    int i3;
                    if (i < i2) {
                        for (i3 = i - 1; i3 >= 0; i3--) {
                            ((TabProgressListenerView) getChildAt(i3)).mo168a(0.0f);
                        }
                    } else {
                        int i4 = i + 1;
                        int childCount = getChildCount();
                        for (i3 = i4; i3 < childCount; i3++) {
                            ((TabProgressListenerView) getChildAt(i3)).mo168a(0.0f);
                        }
                    }
                }
                invalidate();
            }
        }

        public final void m4303c() {
            this.f3579d = 0;
            this.f3580e = 0;
            invalidate();
        }

        public void setUnderlineColor(int i) {
            this.f3577b.setColor(i);
            invalidate();
        }

        public int getCurrentPosition() {
            return this.f3576a;
        }

        public int getUnderlineColor() {
            return this.f3577b.getColor();
        }

        public void setUnderlineHeight(int i) {
            if (this.f3578c != i) {
                this.f3578c = i;
                invalidate();
            }
        }

        public void setTabLayout(int i) {
            if (i > 0) {
                this.f3581f = i;
            }
        }

        public void setUpdateTabProgress(boolean z) {
            this.f3583h = z;
        }

        public final View m4299a(CharSequence charSequence) {
            View d = m4304d();
            if (!(d instanceof FbTextView)) {
                throw new InflateException("Tab layout should be a subclass of FbTextView");
            } else if (!this.f3583h || (d instanceof TabProgressListenerView)) {
                FbTextView fbTextView = (FbTextView) d;
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = "";
                }
                fbTextView.setText(charSequence);
                addView(fbTextView);
                return fbTextView;
            } else {
                throw new InflateException("Tab layout should implement TabProgressListenerView if the updateTabProgress attr is true.");
            }
        }

        protected final View m4304d() {
            return LayoutInflater.from(getContext()).inflate(this.f3581f, this, false);
        }

        private static int m4298b(int i, int i2, float f) {
            return (int) (((float) i) + (((float) (i2 - i)) * f));
        }
    }

    /* compiled from: speed_test_failed */
    class C03101 extends DataSetObserver {
        final /* synthetic */ TabbedViewPagerIndicator f3584a;

        C03101(TabbedViewPagerIndicator tabbedViewPagerIndicator) {
            this.f3584a = tabbedViewPagerIndicator;
        }

        public void onChanged() {
            super.onChanged();
            this.f3584a.mo172a();
        }

        public void onInvalidated() {
            super.onInvalidated();
            this.f3584a.mo172a();
        }
    }

    /* compiled from: speed_test_failed */
    class C03123 implements Runnable {
        final /* synthetic */ TabbedViewPagerIndicator f3587a;

        C03123(TabbedViewPagerIndicator tabbedViewPagerIndicator) {
            this.f3587a = tabbedViewPagerIndicator;
        }

        public void run() {
            TabbedViewPagerIndicator.m4287e(this.f3587a, this.f3587a.f3562c.f3576a);
        }
    }

    /* compiled from: speed_test_failed */
    public interface OnTabClickListener {
        void mo181a(int i, int i2);
    }

    /* compiled from: speed_test_failed */
    public interface OnTabLongClickListener {
    }

    /* compiled from: speed_test_failed */
    class TabClickListener implements OnClickListener {
        final /* synthetic */ TabbedViewPagerIndicator f3588a;
        private int f3589b;

        public TabClickListener(TabbedViewPagerIndicator tabbedViewPagerIndicator, int i) {
            this.f3588a = tabbedViewPagerIndicator;
            this.f3589b = i;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 101288902);
            if (this.f3588a.f3572m != null) {
                this.f3588a.f3572m.mo181a(this.f3589b, this.f3588a.f3561b.k);
            }
            this.f3588a.f3561b.a(this.f3589b, true);
            Logger.a(2, EntryType.UI_INPUT_END, 874670208, a);
        }
    }

    /* compiled from: speed_test_failed */
    class TabLongClickListener implements OnLongClickListener {
        final /* synthetic */ TabbedViewPagerIndicator f3590a;
        private int f3591b;

        public TabLongClickListener(TabbedViewPagerIndicator tabbedViewPagerIndicator, int i) {
            this.f3590a = tabbedViewPagerIndicator;
            this.f3591b = i;
        }

        public boolean onLongClick(View view) {
            if (this.f3590a.f3573n != null) {
                int i = this.f3590a.f3561b.k;
            }
            return false;
        }
    }

    private static <T extends View> void m4279a(Class<T> cls, T t) {
        m4280a((Object) t, t.getContext());
    }

    private static void m4280a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) obj;
        tabbedViewPagerIndicator.f3574o = AllCapsTransformationMethod.b(fbInjector);
        tabbedViewPagerIndicator.f3575p = ViewAccessibilityHelper.a(fbInjector);
    }

    public TabbedViewPagerIndicator(Context context) {
        this(context, null);
    }

    public TabbedViewPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772337);
    }

    public TabbedViewPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3560a = new C03101(this);
        m4279a(TabbedViewPagerIndicator.class, (View) this);
        setHorizontalScrollBarEnabled(false);
        this.f3562c = (TabsContainer) LayoutInflater.from(context).inflate(getTabsContainerResource(), this, false);
        addView(this.f3562c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabbedViewPagerIndicator, i, 0);
        this.f3562c.setUnderlineColor(obtainStyledAttributes.getColor(1, 0));
        this.f3562c.setUnderlineHeight(obtainStyledAttributes.getDimensionPixelSize(2, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(7);
        if (drawable != null) {
            this.f3562c.setShowSegmentedDividers(2);
            this.f3562c.setSegmentedDivider(drawable);
            this.f3562c.setSegmentedDividerPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
            if (dimensionPixelSize > 0) {
                this.f3562c.setSegmentedDividerThickness(dimensionPixelSize);
            }
        } else {
            this.f3562c.setShowSegmentedDividers(0);
            this.f3562c.setSegmentedDivider(null);
        }
        this.f3562c.setTabLayout(obtainStyledAttributes.getResourceId(3, 0));
        this.f3569j = obtainStyledAttributes.getBoolean(4, true);
        this.f3570k = obtainStyledAttributes.getBoolean(6, false);
        this.f3562c.f3583h = obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.recycle();
    }

    @Inject
    private void m4278a(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f3574o = allCapsTransformationMethod;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1681618827);
        super.onDetachedFromWindow();
        if (this.f3564e != null) {
            this.f3564e.m4267b(this.f3560a);
            this.f3564e = null;
        }
        this.f3561b = null;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1538397831, a);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        setFillViewport(false);
        super.onMeasure(i, i2);
        if (this.f3562c.getMeasuredWidth() < getMeasuredWidth() && this.f3569j) {
            int i4;
            LayoutParams layoutParams;
            boolean z;
            setFillViewport(true);
            int childCount = this.f3562c.getChildCount();
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = this.f3562c.getChildAt(i4);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.width = 1;
                layoutParams.weight = 1.0f;
                childAt.setLayoutParams(layoutParams);
            }
            super.onMeasure(i, i2);
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt2 = this.f3562c.getChildAt(i4);
                if ((childAt2 instanceof FbTextView) && ((FbTextView) childAt2).getLayout().getEllipsisCount(0) > 0) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                while (i3 < childCount) {
                    View childAt3 = this.f3562c.getChildAt(i3);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.weight = 1.0f;
                    childAt3.setLayoutParams(layoutParams);
                    i3++;
                }
                super.onMeasure(i, i2);
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f3561b != viewPager) {
            if (this.f3561b != null) {
                this.f3561b.setOnPageChangeListener(null);
            }
            this.f3561b = viewPager;
            this.f3561b.setOnPageChangeListener(this);
            PagerAdapter adapter = this.f3561b.getAdapter();
            if (adapter != null) {
                this.f3563d = adapter;
                if (this.f3564e != null) {
                    this.f3564e.m4267b(this.f3560a);
                }
                if (adapter instanceof BadgePagerProvider) {
                    this.f3564e = ((BadgePagerProvider) adapter).m4269a();
                    if (this.f3564e != null) {
                        ContentDescriptionPagerAdapter contentDescriptionPagerAdapter = this.f3564e;
                        contentDescriptionPagerAdapter.f3556a.registerObserver(this.f3560a);
                    }
                }
                m4293b();
            }
        }
    }

    public void setFillParentWidth(boolean z) {
        this.f3569j = z;
    }

    protected PagerAdapter getPagerAdapter() {
        return this.f3563d;
    }

    protected BadgePagerAdapter getBadgePagerAdapter() {
        return this.f3564e;
    }

    protected int getTabsContainerResource() {
        return 2130904279;
    }

    protected TabsContainer getTabsContainer() {
        return this.f3562c;
    }

    public final void m4293b() {
        if (this.f3563d != null) {
            TabIdentifierProvider tabIdentifierProvider = null;
            if (this.f3563d instanceof TabIdentifierProvider) {
                tabIdentifierProvider = (TabIdentifierProvider) this.f3563d;
            }
            this.f3562c.removeAllViews();
            int b = this.f3563d.b();
            for (int i = 0; i < b; i++) {
                View c = mo169c(i);
                c.setContentDescription(m4289g(i));
                if (tabIdentifierProvider != null) {
                    c.setId(tabIdentifierProvider.m4310a());
                }
                c.setOnClickListener(new TabClickListener(this, i));
                c.setOnLongClickListener(new TabLongClickListener(this, i));
            }
            this.f3562c.m4302b();
            setLastSelectTabIndex(this.f3562c.f3576a);
        }
    }

    protected View mo169c(int i) {
        View a = this.f3562c.m4299a(this.f3563d.J_(i));
        if (this.f3564e != null && (a instanceof BadgeTextView)) {
            ((BadgeTextView) a).setBadgeText(this.f3564e.m4268a(i));
        }
        if (a instanceof TextView) {
            ((TextView) a).setTransformationMethod(this.f3574o);
        }
        return a;
    }

    public final View m4296d(int i) {
        if (i < 0 || i >= this.f3562c.getChildCount()) {
            return null;
        }
        return this.f3562c.getChildAt(i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3563d != null) {
            int i5 = (int) this.f3565f;
            if (z && i5 >= 0 && i5 < this.f3562c.getChildCount()) {
                m4287e(this, i5);
            }
        }
    }

    public final void m4292a(int i, float f, int i2) {
        float f2;
        int i3;
        int i4;
        float f3 = ((float) i) + f;
        if (this.f3565f > f3) {
            f2 = 1.0f - f;
            i3 = i + 1;
            i4 = i;
        } else {
            i4 = i + 1;
            i3 = i;
            f2 = f;
        }
        if (f > 0.0f) {
            if (!this.f3570k) {
                m4290h(this, i4);
            } else if (this.f3568i) {
                m4275a(i, f);
            }
        }
        this.f3565f = f3;
        this.f3562c.m4300a(i3, i4, f2);
        if (this.f3571l != null) {
            this.f3571l.a(i, f, i2);
        }
    }

    public final void e_(final int i) {
        this.f3562c.setPageSelection(i);
        if (this.f3562c.getWindowToken() == null || !this.f3562c.f3582g) {
            post(new Runnable(this) {
                final /* synthetic */ TabbedViewPagerIndicator f3586b;

                public void run() {
                    if (this.f3586b.f3570k) {
                        TabbedViewPagerIndicator.m4287e(this.f3586b, i);
                    } else {
                        TabbedViewPagerIndicator.m4290h(this.f3586b, i);
                    }
                    this.f3586b.f3562c.m4303c();
                }
            });
        } else if (!this.f3570k && this.f3567h == 0) {
            m4290h(this, i);
            this.f3562c.m4303c();
        } else if (this.f3570k && ((this.f3567h == 2 || this.f3567h == 0) && !this.f3568i)) {
            m4287e(this, i);
        }
        setLastSelectTabIndex(i);
        this.f3575p.a(this, m4289g(i));
        if (this.f3571l != null) {
            this.f3571l.e_(i);
        }
    }

    public final void m4294b(int i) {
        this.f3567h = i;
        if (i == 1) {
            this.f3568i = true;
        } else if (i == 0) {
            this.f3568i = false;
        }
        if (this.f3571l != null) {
            this.f3571l.b(i);
        }
    }

    private void m4275a(int i, float f) {
        if (this.f3567h != 0 && i >= 0 && i != this.f3562c.getChildCount() - 1) {
            View childAt = this.f3562c.getChildAt(i);
            View childAt2 = this.f3562c.getChildAt(i + 1);
            scrollTo(((int) (((float) (((childAt.getWidth() / 2) + (childAt2.getWidth() / 2)) + getDividerWidth())) * f)) + m4288f(i), 0);
        }
    }

    public static void m4287e(TabbedViewPagerIndicator tabbedViewPagerIndicator, int i) {
        tabbedViewPagerIndicator.smoothScrollTo(tabbedViewPagerIndicator.m4288f(i), 0);
    }

    private int m4288f(int i) {
        View childAt = this.f3562c.getChildAt(i);
        int dividerWidth = this.f3562c.c(i) ? getDividerWidth() : 0;
        return ((dividerWidth + childAt.getWidth()) / 2) + ((getPaddingLeft() + (childAt.getLeft() - (dividerWidth / 2))) - (getWidth() / 2));
    }

    private void setLastSelectTabIndex(int i) {
        View childAt = this.f3562c.getChildAt(this.f3566g);
        if (childAt != null) {
            childAt.setContentDescription(m4289g(this.f3566g));
            this.f3562c.getChildAt(i).setContentDescription(m4289g(i));
        }
        this.f3566g = i;
    }

    private CharSequence m4289g(int i) {
        View childAt = this.f3562c.getChildAt(i);
        if (childAt == null) {
            return null;
        }
        CharSequence b;
        int i2 = childAt.isSelected() ? 2131230833 : 2131230834;
        if (this.f3564e != null) {
            b = this.f3564e.m4266b(i);
        } else if (this.f3563d.J_(i) != null) {
            b = this.f3563d.J_(i);
        } else if (childAt instanceof FbTextView) {
            b = ((FbTextView) childAt).getText();
        } else {
            b = "";
        }
        return getResources().getString(i2, new Object[]{b, Integer.valueOf(i + 1), Integer.valueOf(this.f3563d.b())});
    }

    private int getDividerWidth() {
        return this.f3562c != null ? this.f3562c.getSegmentedDividerThickness() : 0;
    }

    public static void m4290h(TabbedViewPagerIndicator tabbedViewPagerIndicator, int i) {
        int childCount = tabbedViewPagerIndicator.f3562c.getChildCount();
        if (i >= 0 && i < childCount) {
            int width;
            int width2;
            View childAt = tabbedViewPagerIndicator.f3562c.getChildAt(i);
            int scrollX = tabbedViewPagerIndicator.getScrollX();
            int width3 = tabbedViewPagerIndicator.getWidth();
            int left = childAt.getLeft();
            int width4 = childAt.getWidth();
            if (i > 0) {
                width = tabbedViewPagerIndicator.f3562c.getChildAt(i - 1).getWidth() / 2;
            } else {
                width = 0;
            }
            if (i < childCount - 1) {
                width2 = tabbedViewPagerIndicator.f3562c.getChildAt(i + 1).getWidth() / 2;
            } else {
                width2 = 0;
            }
            width = left - width;
            width2 += left + width4;
            if (width < scrollX) {
                tabbedViewPagerIndicator.scrollTo(width, 0);
            } else if (width2 > scrollX + width3) {
                tabbedViewPagerIndicator.scrollTo(width2 - width3, 0);
            }
        }
    }

    protected void mo172a() {
        if (this.f3564e != null) {
            int childCount = this.f3562c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f3562c.getChildAt(i);
                if (childAt instanceof BadgeTextView) {
                    ((BadgeTextView) childAt).setBadgeText(this.f3564e.m4268a(i));
                }
            }
            post(new C03123(this));
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f3571l = onPageChangeListener;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.f3572m = onTabClickListener;
    }

    public void setOnTabLongClickListener(OnTabLongClickListener onTabLongClickListener) {
        this.f3573n = onTabLongClickListener;
    }

    public void setUnderlineHeight(int i) {
        this.f3562c.setUnderlineHeight(i);
    }

    public void setUnderlineColor(int i) {
        if (i != this.f3562c.getUnderlineColor()) {
            this.f3562c.setUnderlineColor(i);
        }
    }

    public void setTitleTransformationMethod(TransformationMethod transformationMethod) {
        this.f3574o = transformationMethod;
    }

    private void m4276a(ViewAccessibilityHelper viewAccessibilityHelper) {
        this.f3575p = viewAccessibilityHelper;
    }
}

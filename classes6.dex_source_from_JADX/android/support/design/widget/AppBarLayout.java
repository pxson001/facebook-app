package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.facebook.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@DefaultBehavior(Behavior.class)
/* compiled from: qcom */
public class AppBarLayout extends LinearLayout {
    public boolean f6884a;
    private int f6885b;
    private int f6886c;
    private int f6887d;
    public float f6888e;
    public int f6889f;
    private WindowInsetsCompat f6890g;
    public final List<OnOffsetChangedListener> f6891h;

    /* compiled from: qcom */
    class C03901 implements OnApplyWindowInsetsListener {
        final /* synthetic */ AppBarLayout f6859a;

        C03901(AppBarLayout appBarLayout) {
            this.f6859a = appBarLayout;
        }

        public final WindowInsetsCompat m9979a(View view, WindowInsetsCompat windowInsetsCompat) {
            AppBarLayout.setWindowInsets(this.f6859a, windowInsetsCompat);
            return windowInsetsCompat.f();
        }
    }

    /* compiled from: qcom */
    public class Behavior extends HeaderBehavior<AppBarLayout> {
        private int f6873a;
        private boolean f6874b;
        private boolean f6875c;
        private ValueAnimatorCompat f6876d;
        private int f6877e = -1;
        private boolean f6878f;
        private float f6879g;
        private WeakReference<View> f6880h;
        private DragCallback f6881i;

        /* compiled from: qcom */
        public abstract class DragCallback {
            public abstract boolean m9982a();
        }

        /* compiled from: qcom */
        public class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = ParcelableCompat.a(new C03921());
            int f6863a;
            float f6864b;
            boolean f6865c;

            /* compiled from: qcom */
            final class C03921 implements ParcelableCompatCreatorCallbacks<SavedState> {
                C03921() {
                }

                public final Object m9983a(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel);
                }

                public final Object[] m9984a(int i) {
                    return new SavedState[i];
                }
            }

            public SavedState(Parcel parcel) {
                super(parcel);
                this.f6863a = parcel.readInt();
                this.f6864b = parcel.readFloat();
                this.f6865c = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f6863a);
                parcel.writeFloat(this.f6864b);
                parcel.writeByte((byte) (this.f6865c ? 1 : 0));
            }
        }

        final int mo853a(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        final int mo854b(View view) {
            return -AppBarLayout.getDownNestedScrollRange((AppBarLayout) view);
        }

        final boolean mo855c(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f6881i != null) {
                return this.f6881i.m9982a();
            }
            if (this.f6880h == null) {
                return true;
            }
            View view2 = (View) this.f6880h.get();
            return (view2 == null || !view2.isShown() || ViewCompat.b(view2, -1)) ? false : true;
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int i2 = appBarLayout.f6889f;
            int i3;
            int i4;
            if (i2 != 0) {
                i3 = (i2 & 4) != 0 ? 1 : 0;
                if ((i2 & 2) != 0) {
                    i4 = -AppBarLayout.getUpNestedPreScrollRange(appBarLayout);
                    if (i3 != 0) {
                        m9998b(coordinatorLayout, appBarLayout, i4);
                    } else {
                        m9987a(coordinatorLayout, appBarLayout, i4);
                    }
                } else if ((i2 & 1) != 0) {
                    if (i3 != 0) {
                        m9998b(coordinatorLayout, appBarLayout, 0);
                    } else {
                        m9987a(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f6877e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f6877e);
                i4 = -childAt.getBottom();
                if (this.f6878f) {
                    i3 = ViewCompat.s(childAt) + i4;
                } else {
                    i3 = Math.round(((float) childAt.getHeight()) * this.f6879g) + i4;
                }
                setTopAndBottomOffset(i3);
            }
            appBarLayout.f6889f;
            this.f6877e = -1;
            m9999d(appBarLayout);
            return onLayoutChild;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2, boolean z) {
            view = (AppBarLayout) view;
            boolean z2 = false;
            if (!z) {
                z2 = m9990a(coordinatorLayout, view, -view.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-view.getTotalScrollRange()) + AppBarLayout.getDownNestedPreScrollRange(view);
                if (mo851a() < r1) {
                    m9998b(coordinatorLayout, view, r1);
                    z2 = true;
                }
            } else {
                r1 = -AppBarLayout.getUpNestedPreScrollRange(view);
                if (mo851a() > r1) {
                    m9998b(coordinatorLayout, view, r1);
                    z2 = true;
                }
            }
            this.f6875c = z2;
            return z2;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
            view = (AppBarLayout) view;
            if (i2 != 0 && !this.f6874b) {
                int i3;
                int downNestedPreScrollRange;
                if (i2 < 0) {
                    i3 = -view.getTotalScrollRange();
                    downNestedPreScrollRange = i3 + AppBarLayout.getDownNestedPreScrollRange(view);
                } else {
                    i3 = -AppBarLayout.getUpNestedPreScrollRange(view);
                    downNestedPreScrollRange = 0;
                }
                iArr[1] = m9991b(coordinatorLayout, view, i2, i3, downNestedPreScrollRange);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4) {
            view = (AppBarLayout) view;
            if (i4 < 0) {
                m9991b(coordinatorLayout, view, i4, -AppBarLayout.getDownNestedScrollRange(view), 0);
                this.f6874b = true;
                return;
            }
            this.f6874b = false;
        }

        public /* synthetic */ void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            m10004a(coordinatorLayout, (AppBarLayout) view, parcelable);
        }

        public /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            return m10003a(coordinatorLayout, (AppBarLayout) view);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && AppBarLayout.getDownNestedScrollRange(appBarLayout) && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight();
            if (z && this.f6876d != null) {
                this.f6876d.m10244e();
            }
            this.f6880h = null;
            return z;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!this.f6875c) {
                m9997b(coordinatorLayout, appBarLayout);
            }
            this.f6874b = false;
            this.f6875c = false;
            this.f6880h = new WeakReference(view2);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void m9998b(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int a = mo851a();
            if (a != i) {
                if (this.f6876d == null) {
                    this.f6876d = ViewUtils.m10279a();
                    this.f6876d.m10240a(AnimationUtils.f6858e);
                    this.f6876d.m10239a(new AnimatorUpdateListener(this) {
                        final /* synthetic */ Behavior f6862c;

                        public final void mo847a(ValueAnimatorCompat valueAnimatorCompat) {
                            this.f6862c.m9987a(coordinatorLayout, appBarLayout, valueAnimatorCompat.m10242c());
                        }
                    });
                } else {
                    this.f6876d.m10244e();
                }
                this.f6876d.m10237a(Math.round(((((float) Math.abs(a - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.f6876d.m10238a(a, i);
                this.f6876d.m10235a();
            } else if (this.f6876d != null && this.f6876d.m10241b()) {
                this.f6876d.m10244e();
            }
        }

        private static View m9995a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return childAt;
                }
            }
            return null;
        }

        private void m9997b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo851a();
            View a2 = m9995a(appBarLayout, a);
            if (a2 != null) {
                LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
                if ((layoutParams.f6882a & 17) == 17) {
                    int s;
                    int i = -a2.getTop();
                    int i2 = -a2.getBottom();
                    if ((layoutParams.f6882a & 2) == 2) {
                        s = ViewCompat.s(a2) + i2;
                    } else {
                        s = i2;
                    }
                    if (a >= (s + i) / 2) {
                        s = i;
                    }
                    m9998b(coordinatorLayout, appBarLayout, MathUtils.m10148a(s, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        private int m9994a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo851a();
            if (i2 == 0 || a < i2 || a > i3) {
                return 0;
            }
            int a2 = MathUtils.m10148a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b;
            if (appBarLayout.f6884a) {
                b = m9996b(appBarLayout, a2);
            } else {
                b = a2;
            }
            boolean topAndBottomOffset = setTopAndBottomOffset(b);
            a -= a2;
            this.f6873a = a2 - b;
            if (!topAndBottomOffset && appBarLayout.f6884a) {
                coordinatorLayout.m10127b((View) appBarLayout);
            }
            m9999d(appBarLayout);
            return a;
        }

        private void m9999d(AppBarLayout appBarLayout) {
            List list = appBarLayout.f6891h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                OnOffsetChangedListener onOffsetChangedListener = (OnOffsetChangedListener) list.get(i);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.mo872a(appBarLayout, getTopAndBottomOffset());
                }
            }
        }

        private static int m9996b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolator = layoutParams.f6883b;
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (interpolator == null) {
                    return i;
                } else {
                    int height;
                    i2 = layoutParams.f6882a;
                    if ((i2 & 1) != 0) {
                        height = (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= ViewCompat.s(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (ViewCompat.A(childAt)) {
                        height -= AppBarLayout.getTopInset(appBarLayout);
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(interpolator.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        final int mo851a() {
            return getTopAndBottomOffset() + this.f6873a;
        }

        public Parcelable m10003a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f6863a = i;
                    if (bottom == ViewCompat.s(childAt)) {
                        z = true;
                    }
                    savedState.f6865c = z;
                    savedState.f6864b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        public void m10004a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.f6877e = savedState.f6863a;
                this.f6879g = savedState.f6864b;
                this.f6878f = savedState.f6865c;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
            this.f6877e = -1;
        }
    }

    /* compiled from: qcom */
    public class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public int f6882a = 1;
        public Interpolator f6883b;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: qcom */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_LayoutParams);
            this.f6882a = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.f6883b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void m10008a(int i) {
            this.f6882a = i;
        }

        public final int m10007a() {
            return this.f6882a;
        }

        public final Interpolator m10009b() {
            return this.f6883b;
        }
    }

    /* compiled from: qcom */
    public interface OnOffsetChangedListener {
        void mo872a(AppBarLayout appBarLayout, int i);
    }

    /* compiled from: qcom */
    public class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        private int mOverlayTop;

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Params);
            this.mOverlayTop = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            super.onLayoutChild(coordinatorLayout, view, i);
            List c = coordinatorLayout.m10128c(view);
            int size = c.size();
            int i2 = 0;
            while (i2 < size && !updateOffset(coordinatorLayout, view, (View) c.get(i2))) {
                i2++;
            }
            return true;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            updateOffset(coordinatorLayout, view, view2);
            return false;
        }

        private boolean updateOffset(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.Behavior behavior = ((android.support.design.widget.CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f6979a;
            if (!(behavior instanceof Behavior)) {
                return false;
            }
            int a = ((Behavior) behavior).mo851a();
            setTopAndBottomOffset((view2.getHeight() + a) - getOverlapForOffset(view2, a));
            return true;
        }

        private int getOverlapForOffset(View view, int i) {
            if (this.mOverlayTop != 0 && (view instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = AppBarLayout.getDownNestedPreScrollRange(appBarLayout);
                if (downNestedPreScrollRange != 0 && totalScrollRange + i <= downNestedPreScrollRange) {
                    return 0;
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (totalScrollRange != 0) {
                    return MathUtils.m10148a(Math.round(((((float) i) / ((float) totalScrollRange)) + 1.0f) * ((float) this.mOverlayTop)), 0, this.mOverlayTop);
                }
            }
            return this.mOverlayTop;
        }

        public void setOverlayTop(int i) {
            this.mOverlayTop = i;
        }

        public int getOverlayTop() {
            return this.mOverlayTop;
        }

        View findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m10018b();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m28958generateDefaultLayoutParams() {
        return m10018b();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m10011a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m10012a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m28959generateLayoutParams(AttributeSet attributeSet) {
        return m10011a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m28960generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m10012a(layoutParams);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6885b = -1;
        this.f6886c = -1;
        this.f6887d = -1;
        this.f6889f = 0;
        setOrientation(1);
        ThemeUtils.m10221a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, 2131624593);
        this.f6888e = (float) obtainStyledAttributes.getDimensionPixelSize(1, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        if (obtainStyledAttributes.hasValue(2)) {
            setExpanded(obtainStyledAttributes.getBoolean(2, false));
        }
        obtainStyledAttributes.recycle();
        ViewUtils.f7146b.mo894a(this);
        this.f6891h = new ArrayList();
        ViewCompat.g(this, this.f6888e);
        ViewCompat.a(this, new C03901(this));
    }

    public final void m10029a(OnOffsetChangedListener onOffsetChangedListener) {
        if (onOffsetChangedListener != null && !this.f6891h.contains(onOffsetChangedListener)) {
            this.f6891h.add(onOffsetChangedListener);
        }
    }

    public final void m10030b(OnOffsetChangedListener onOffsetChangedListener) {
        if (onOffsetChangedListener != null) {
            this.f6891h.remove(onOffsetChangedListener);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m10013a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m10013a();
        this.f6884a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).f6883b != null) {
                this.f6884a = true;
                return;
            }
        }
    }

    private void m10013a() {
        this.f6885b = -1;
        this.f6886c = -1;
        this.f6887d = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        m10015a(z, ViewCompat.E(this));
    }

    private void m10015a(boolean z, boolean z2) {
        this.f6889f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams m10018b() {
        return new LayoutParams(-1, -2);
    }

    private LayoutParams m10011a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams m10012a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static boolean m10020c(AppBarLayout appBarLayout) {
        return appBarLayout.f6884a;
    }

    public final int getTotalScrollRange() {
        if (this.f6885b != -1) {
            return this.f6885b;
        }
        int s;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f6882a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                s = i - ViewCompat.s(childAt);
                break;
            }
        }
        s = i;
        s = Math.max(0, s - getTopInset(this));
        this.f6885b = s;
        return s;
    }

    public static boolean m10022d(AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange() != 0;
    }

    public static int getUpNestedPreScrollRange(AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange();
    }

    public static int getDownNestedPreScrollRange(AppBarLayout appBarLayout) {
        if (appBarLayout.f6886c != -1) {
            return appBarLayout.f6886c;
        }
        int i = 0;
        int childCount = appBarLayout.getChildCount() - 1;
        while (childCount >= 0) {
            int i2;
            View childAt = appBarLayout.getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f6882a;
            if ((i3 & 5) != 5) {
                if (i > 0) {
                    break;
                }
                i2 = i;
            } else {
                i2 = (layoutParams.bottomMargin + layoutParams.topMargin) + i;
                if ((i3 & 8) != 0) {
                    i2 += ViewCompat.s(childAt);
                } else {
                    i2 += measuredHeight;
                }
            }
            childCount--;
            i = i2;
        }
        appBarLayout.f6886c = i;
        return i;
    }

    public static int getDownNestedScrollRange(AppBarLayout appBarLayout) {
        if (appBarLayout.f6887d != -1) {
            return appBarLayout.f6887d;
        }
        int i;
        int childCount = appBarLayout.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = appBarLayout.getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.f6882a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (ViewCompat.s(childAt) + getTopInset(appBarLayout));
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        appBarLayout.f6887d = i;
        return i;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int b = this.f6890g != null ? this.f6890g.b() : 0;
        int s = ViewCompat.s(this);
        if (s != 0) {
            return (s * 2) + b;
        }
        s = getChildCount();
        if (s > 0) {
            return (ViewCompat.s(getChildAt(s - 1)) * 2) + b;
        }
        return 0;
    }

    public void setTargetElevation(float f) {
        this.f6888e = f;
    }

    public float getTargetElevation() {
        return this.f6888e;
    }

    public static int getPendingAction(AppBarLayout appBarLayout) {
        return appBarLayout.f6889f;
    }

    public static void m10024e(AppBarLayout appBarLayout) {
        appBarLayout.f6889f = 0;
    }

    public static int getTopInset(AppBarLayout appBarLayout) {
        return appBarLayout.f6890g != null ? appBarLayout.f6890g.b() : 0;
    }

    public static void setWindowInsets(AppBarLayout appBarLayout, WindowInsetsCompat windowInsetsCompat) {
        appBarLayout.f6885b = -1;
        appBarLayout.f6890g = windowInsetsCompat;
        int i = 0;
        int childCount = appBarLayout.getChildCount();
        while (i < childCount) {
            windowInsetsCompat = ViewCompat.b(appBarLayout.getChildAt(i), windowInsetsCompat);
            if (!windowInsetsCompat.e()) {
                i++;
            } else {
                return;
            }
        }
    }
}

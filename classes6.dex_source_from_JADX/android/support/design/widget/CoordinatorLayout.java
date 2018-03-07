package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: pymk_location */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {
    static final String f6994a;
    static final Class<?>[] f6995b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f6996c = new ThreadLocal();
    static final Comparator<View> f6997e;
    static final CoordinatorLayoutInsetsHelper f6998f;
    final Comparator<View> f6999d;
    private final List<View> f7000g;
    private final List<View> f7001h;
    private final List<View> f7002i;
    private final Rect f7003j;
    private final Rect f7004k;
    private final Rect f7005l;
    private final int[] f7006m;
    private Paint f7007n;
    private boolean f7008o;
    private int[] f7009p;
    private View f7010q;
    private View f7011r;
    private View f7012s;
    private OnPreDrawListener f7013t;
    private boolean f7014u;
    private WindowInsetsCompat f7015v;
    private boolean f7016w;
    private Drawable f7017x;
    public OnHierarchyChangeListener f7018y;
    private final NestedScrollingParentHelper f7019z;

    /* compiled from: pymk_location */
    public abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public final int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f > 0.0f;
        }

        public final float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean isDirty(CoordinatorLayout coordinatorLayout, V v) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public static void setTag(View view, Object obj) {
            ((LayoutParams) view.getLayoutParams()).f6988j = obj;
        }

        public static Object getTag(View view) {
            return ((LayoutParams) view.getLayoutParams()).f6988j;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return AbsSavedState.EMPTY_STATE;
        }
    }

    /* compiled from: pymk_location */
    class C03961 implements Comparator<View> {
        final /* synthetic */ CoordinatorLayout f6976a;

        C03961(CoordinatorLayout coordinatorLayout) {
            this.f6976a = coordinatorLayout;
        }

        public int compare(Object obj, Object obj2) {
            View view = (View) obj;
            View view2 = (View) obj2;
            if (view == view2) {
                return 0;
            }
            if (((LayoutParams) view.getLayoutParams()).m10080a(this.f6976a, view, view2)) {
                return 1;
            }
            return ((LayoutParams) view2.getLayoutParams()).m10080a(this.f6976a, view2, view) ? -1 : 0;
        }
    }

    /* compiled from: pymk_location */
    final class ApplyInsetsListener implements OnApplyWindowInsetsListener {
        final /* synthetic */ CoordinatorLayout f6977a;

        ApplyInsetsListener(CoordinatorLayout coordinatorLayout) {
            this.f6977a = coordinatorLayout;
        }

        public final WindowInsetsCompat m10072a(View view, WindowInsetsCompat windowInsetsCompat) {
            CoordinatorLayout.setWindowInsets(this.f6977a, windowInsetsCompat);
            return windowInsetsCompat.f();
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: pymk_location */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    /* compiled from: pymk_location */
    final class HierarchyChangeListener implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f6978a;

        HierarchyChangeListener(CoordinatorLayout coordinatorLayout) {
            this.f6978a = coordinatorLayout;
        }

        public final void onChildViewAdded(View view, View view2) {
            if (this.f6978a.f7018y != null) {
                this.f6978a.f7018y.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            this.f6978a.m10121a(view2);
            if (this.f6978a.f7018y != null) {
                this.f6978a.f7018y.onChildViewRemoved(view, view2);
            }
        }
    }

    /* compiled from: pymk_location */
    public class LayoutParams extends MarginLayoutParams {
        public Behavior f6979a;
        boolean f6980b = false;
        public int f6981c = 0;
        public int f6982d = 0;
        public int f6983e = -1;
        public int f6984f = -1;
        View f6985g;
        View f6986h;
        public final Rect f6987i = new Rect();
        Object f6988j;
        private boolean f6989k;
        public boolean f6990l;
        public boolean f6991m;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_LayoutParams);
            this.f6981c = obtainStyledAttributes.getInteger(0, 0);
            this.f6984f = obtainStyledAttributes.getResourceId(2, -1);
            this.f6982d = obtainStyledAttributes.getInteger(4, 0);
            this.f6983e = obtainStyledAttributes.getInteger(3, -1);
            this.f6980b = obtainStyledAttributes.hasValue(1);
            if (this.f6980b) {
                this.f6979a = CoordinatorLayout.m10095a(context, attributeSet, obtainStyledAttributes.getString(1));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final int m10075a() {
            return this.f6984f;
        }

        public final Behavior m10081b() {
            return this.f6979a;
        }

        public final void m10077a(Behavior behavior) {
            if (this.f6979a != behavior) {
                this.f6979a = behavior;
                this.f6988j = null;
                this.f6980b = true;
            }
        }

        final void m10076a(Rect rect) {
            this.f6987i.set(rect);
        }

        final Rect m10084c() {
            return this.f6987i;
        }

        final boolean m10085d() {
            return this.f6985g == null && this.f6984f != -1;
        }

        final boolean m10086e() {
            if (this.f6979a == null) {
                this.f6989k = false;
            }
            return this.f6989k;
        }

        final boolean m10079a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f6989k) {
                return true;
            }
            boolean blocksInteractionBelow = (this.f6979a != null ? this.f6979a.blocksInteractionBelow(coordinatorLayout, view) : 0) | this.f6989k;
            this.f6989k = blocksInteractionBelow;
            return blocksInteractionBelow;
        }

        final void m10087f() {
            this.f6989k = false;
        }

        final void m10088g() {
            this.f6990l = false;
        }

        final void m10078a(boolean z) {
            this.f6990l = z;
        }

        final boolean m10089h() {
            return this.f6990l;
        }

        final boolean m10090i() {
            return this.f6991m;
        }

        final void m10083b(boolean z) {
            this.f6991m = z;
        }

        final void m10091j() {
            this.f6991m = false;
        }

        final boolean m10080a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f6986h || (this.f6979a != null && this.f6979a.layoutDependsOn(coordinatorLayout, view, view2));
        }

        final View m10082b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f6984f == -1) {
                this.f6986h = null;
                this.f6985g = null;
                return null;
            }
            if (this.f6985g == null || !m10074b(view, coordinatorLayout)) {
                m10073a(view, coordinatorLayout);
            }
            return this.f6985g;
        }

        private void m10073a(View view, CoordinatorLayout coordinatorLayout) {
            this.f6985g = coordinatorLayout.findViewById(this.f6984f);
            if (this.f6985g != null) {
                if (this.f6985g != coordinatorLayout) {
                    View view2 = this.f6985g;
                    View parent = this.f6985g.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f6986h = null;
                            this.f6985g = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f6986h = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f6986h = null;
                    this.f6985g = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f6986h = null;
                this.f6985g = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f6984f) + " to anchor view " + view);
            }
        }

        private boolean m10074b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f6985g.getId() != this.f6984f) {
                return false;
            }
            View view2 = this.f6985g;
            View parent = this.f6985g.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.f6986h = null;
                    this.f6985g = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.f6986h = view2;
            return true;
        }
    }

    /* compiled from: pymk_location */
    class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f6992a;

        OnPreDrawListener(CoordinatorLayout coordinatorLayout) {
            this.f6992a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f6992a.m10124a(false);
            return true;
        }
    }

    /* compiled from: pymk_location */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = ParcelableCompat.a(new C03971());
        SparseArray<Parcelable> f6993a;

        /* compiled from: pymk_location */
        final class C03971 implements ParcelableCompatCreatorCallbacks<SavedState> {
            C03971() {
            }

            public final Object m10092a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final Object[] m10093a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f6993a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f6993a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f6993a != null ? this.f6993a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f6993a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f6993a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* compiled from: pymk_location */
    class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        public int compare(Object obj, Object obj2) {
            View view = (View) obj2;
            float F = ViewCompat.F((View) obj);
            float F2 = ViewCompat.F(view);
            if (F > F2) {
                return -1;
            }
            if (F < F2) {
                return 1;
            }
            return 0;
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f6994a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f6997e = new ViewElevationComparator();
            f6998f = new CoordinatorLayoutInsetsHelperLollipop();
        } else {
            f6997e = null;
            f6998f = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f6999d = new C03961(this);
        this.f7000g = new ArrayList();
        this.f7001h = new ArrayList();
        this.f7002i = new ArrayList();
        this.f7003j = new Rect();
        this.f7004k = new Rect();
        this.f7005l = new Rect();
        this.f7006m = new int[2];
        this.f7019z = new NestedScrollingParentHelper(this);
        ThemeUtils.m10221a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 2131624594);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f7009p = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f7009p.length;
            while (i2 < length) {
                int[] iArr = this.f7009p;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f7017x = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        if (f6998f != null) {
            f6998f.mo873a(this, new ApplyInsetsListener(this));
        }
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f7018y = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -241807136);
        super.onAttachedToWindow();
        m10097a();
        if (this.f7014u) {
            if (this.f7013t == null) {
                this.f7013t = new OnPreDrawListener(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7013t);
        }
        if (this.f7015v == null && ViewCompat.A(this)) {
            ViewCompat.z(this);
        }
        this.f7008o = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1174101382, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2110404386);
        super.onDetachedFromWindow();
        m10097a();
        if (this.f7014u && this.f7013t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7013t);
        }
        if (this.f7012s != null) {
            onStopNestedScroll(this.f7012s);
        }
        this.f7008o = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1330463693, a);
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f7017x = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackground() {
        return this.f7017x;
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public static void setWindowInsets(CoordinatorLayout coordinatorLayout, WindowInsetsCompat windowInsetsCompat) {
        boolean z = true;
        if (coordinatorLayout.f7015v != windowInsetsCompat) {
            coordinatorLayout.f7015v = windowInsetsCompat;
            boolean z2 = windowInsetsCompat != null && windowInsetsCompat.b() > 0;
            coordinatorLayout.f7016w = z2;
            if (coordinatorLayout.f7016w || coordinatorLayout.getBackground() != null) {
                z = false;
            }
            coordinatorLayout.setWillNotDraw(z);
            coordinatorLayout.m10099a(windowInsetsCompat);
            coordinatorLayout.requestLayout();
        }
    }

    private void m10097a() {
        int i = 0;
        if (this.f7010q != null) {
            Behavior behavior = ((LayoutParams) this.f7010q.getLayoutParams()).f6979a;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.onTouchEvent(this, this.f7010q, obtain);
                obtain.recycle();
            }
            this.f7010q = null;
        }
        int childCount = getChildCount();
        while (i < childCount) {
            ((LayoutParams) getChildAt(i).getLayoutParams()).m10087f();
            i++;
        }
    }

    private void m10104a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            int childDrawingOrder;
            if (isChildrenDrawingOrderEnabled) {
                childDrawingOrder = getChildDrawingOrder(childCount, i);
            } else {
                childDrawingOrder = i;
            }
            list.add(getChildAt(childDrawingOrder));
        }
        if (f6997e != null) {
            Collections.sort(list, f6997e);
        }
    }

    private boolean m10106a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = MotionEventCompat.a(motionEvent);
        List list = this.f7001h;
        m10104a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior b = layoutParams.m10081b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.onInterceptTouchEvent(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.onTouchEvent(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f7010q = view;
                    }
                }
                z = z2;
                boolean e = layoutParams.m10086e();
                boolean a2 = layoutParams.m10079a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.onInterceptTouchEvent(this, view, motionEvent3);
                        obj2 = obj;
                        z = z2;
                        continue;
                    case 1:
                        b.onTouchEvent(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = MotionEventCompat.a(motionEvent);
        if (a == 0) {
            m10097a();
        }
        boolean a2 = m10106a(motionEvent, 0);
        if (a == 1 || a == 3) {
            m10097a();
        }
        return a2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -772652104);
        int a2 = MotionEventCompat.a(motionEvent);
        boolean z2;
        if (this.f7010q == null) {
            boolean a3 = m10106a(motionEvent, 1);
            if (a3) {
                z2 = a3;
            } else {
                z2 = a3;
                z = false;
                if (this.f7010q == null) {
                    z |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z2) {
                    motionEvent2 = null;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (a2 == 1 || a2 == 3) {
                    m10097a();
                }
                LogUtils.a(1088656094, a);
                return z;
            }
        }
        z2 = false;
        Behavior behavior = ((LayoutParams) this.f7010q.getLayoutParams()).f6979a;
        z = behavior != null ? behavior.onTouchEvent(this, this.f7010q, motionEvent) : false;
        if (this.f7010q == null) {
            z |= super.onTouchEvent(motionEvent);
            motionEvent2 = null;
        } else if (z2) {
            motionEvent2 = null;
        } else {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m10097a();
        LogUtils.a(1088656094, a);
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m10097a();
        }
    }

    private int m10094a(int i) {
        if (this.f7009p == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f7009p.length) {
            return this.f7009p[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    static Behavior m10095a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f6994a)) {
            str = f6994a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f6996c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f6996c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f6995b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static LayoutParams m10117d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f6980b) {
            DefaultBehavior defaultBehavior = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            DefaultBehavior defaultBehavior2 = defaultBehavior;
            if (defaultBehavior2 != null) {
                try {
                    layoutParams.m10077a((Behavior) defaultBehavior2.value().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior2.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            layoutParams.f6980b = true;
        }
        return layoutParams;
    }

    private void m10108b() {
        this.f7000g.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            m10117d(childAt).m10082b(this, childAt);
            this.f7000g.add(childAt);
        }
        m10105a(this.f7000g, this.f6999d);
    }

    private void m10101a(View view, Rect rect) {
        ViewGroupUtils.m10268a(this, view, rect);
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void m10123a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        m10108b();
        m10113c();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int h = ViewCompat.h(this);
        Object obj2;
        if (h == 1) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        if (this.f7015v == null || !ViewCompat.A(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size3 = this.f7000g.size();
        int i5 = 0;
        int i6 = 0;
        int i7 = paddingBottom;
        int i8 = suggestedMinimumWidth;
        while (i5 < size3) {
            int i9;
            View view = (View) this.f7000g.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i10 = 0;
            if (layoutParams.f6983e >= 0 && mode != 0) {
                int a = m10094a(layoutParams.f6983e);
                paddingTop = GravityCompat.a(m10112c(layoutParams.f6981c), h) & 7;
                if ((paddingTop == 3 && r9 == null) || (paddingTop == 5 && r9 != null)) {
                    i10 = Math.max(0, (size - paddingRight) - a);
                } else if ((paddingTop == 5 && r9 == null) || (paddingTop == 3 && r9 != null)) {
                    i10 = Math.max(0, a - paddingLeft);
                }
            }
            if (obj == null || ViewCompat.A(view)) {
                i9 = i2;
                suggestedMinimumWidth = i;
            } else {
                paddingTop = this.f7015v.b() + this.f7015v.d();
                suggestedMinimumWidth = MeasureSpec.makeMeasureSpec(size - (this.f7015v.a() + this.f7015v.c()), mode);
                i9 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
            }
            Behavior b = layoutParams.m10081b();
            if (b == null || !b.onMeasureChild(this, view, suggestedMinimumWidth, i10, i9, 0)) {
                m10123a(view, suggestedMinimumWidth, i10, i9, 0);
            }
            i10 = Math.max(i8, ((view.getMeasuredWidth() + i3) + layoutParams.leftMargin) + layoutParams.rightMargin);
            suggestedMinimumWidth = Math.max(i7, ((view.getMeasuredHeight() + i4) + layoutParams.topMargin) + layoutParams.bottomMargin);
            i5++;
            i6 = ViewCompat.a(i6, ViewCompat.m(view));
            i7 = suggestedMinimumWidth;
            i8 = i10;
        }
        setMeasuredDimension(ViewCompat.a(i8, i, -16777216 & i6), ViewCompat.a(i7, i2, i6 << 16));
    }

    private void m10099a(WindowInsetsCompat windowInsetsCompat) {
        if (!windowInsetsCompat.e()) {
            int childCount = getChildCount();
            WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (ViewCompat.A(childAt)) {
                    WindowInsetsCompat windowInsetsCompat3;
                    if (((LayoutParams) childAt.getLayoutParams()).f6979a != null) {
                        windowInsetsCompat3 = windowInsetsCompat2;
                        if (windowInsetsCompat3.e()) {
                            return;
                        }
                    }
                    windowInsetsCompat3 = windowInsetsCompat2;
                    windowInsetsCompat2 = ViewCompat.b(childAt, windowInsetsCompat3);
                    if (windowInsetsCompat2.e()) {
                        return;
                    }
                }
            }
        }
    }

    public final void m10122a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.m10085d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (layoutParams.f6985g != null) {
            m10102a(view, layoutParams.f6985g, i);
        } else if (layoutParams.f6983e >= 0) {
            m10110b(view, layoutParams.f6983e, i);
        } else {
            m10109b(view, i);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int h = ViewCompat.h(this);
        int size = this.f7000g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f7000g.get(i5);
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).f6979a;
            if (behavior == null || !behavior.onLayoutChild(this, view, h)) {
                m10122a(view, h);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7016w && this.f7017x != null) {
            int b = this.f7015v != null ? this.f7015v.b() : 0;
            if (b > 0) {
                this.f7017x.setBounds(0, 0, getWidth(), b);
                this.f7017x.draw(canvas);
            }
        }
    }

    private static void m10111b(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).m10076a(rect);
    }

    private static void m10115c(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).f6987i);
    }

    private void m10103a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.set(0, 0, 0, 0);
        } else if (z) {
            ViewGroupUtils.m10268a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void m10100a(View view, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int a = GravityCompat.a(m10116d(layoutParams.f6981c), i);
        int a2 = GravityCompat.a(m10107b(layoutParams.f6982d), i);
        int i2 = a & 7;
        int i3 = a & 112;
        a = a2 & 7;
        int i4 = a2 & 112;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        switch (a) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i4) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i2) {
            case 1:
                a2 -= measuredWidth / 2;
                break;
            case 5:
                break;
            default:
                a2 -= measuredWidth;
                break;
        }
        switch (i3) {
            case 16:
                a -= measuredHeight / 2;
                break;
            case 80:
                break;
            default:
                a -= measuredHeight;
                break;
        }
        i2 = getWidth();
        i3 = getHeight();
        a2 = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(a2, ((i2 - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(a, ((i3 - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        rect2.set(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private void m10102a(View view, View view2, int i) {
        view.getLayoutParams();
        Rect rect = this.f7003j;
        Rect rect2 = this.f7004k;
        ViewGroupUtils.m10268a(this, view2, rect);
        m10100a(view, i, rect, rect2);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void m10110b(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int a = GravityCompat.a(m10112c(layoutParams.f6981c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int a2 = m10094a(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                a2 += measuredWidth / 2;
                break;
            case 5:
                a2 += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = (measuredHeight / 2) + 0;
                break;
            case 80:
                a = measuredHeight + 0;
                break;
        }
        a2 = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(a2, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(a2, max, a2 + measuredWidth, max + measuredHeight);
    }

    private void m10109b(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = this.f7003j;
        rect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (!(this.f7015v == null || !ViewCompat.A(this) || ViewCompat.A(view))) {
            rect.left += this.f7015v.a();
            rect.top += this.f7015v.b();
            rect.right -= this.f7015v.c();
            rect.bottom -= this.f7015v.d();
        }
        Rect rect2 = this.f7004k;
        GravityCompat.a(m10107b(layoutParams.f6981c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private static int m10107b(int i) {
        return i == 0 ? 8388659 : i;
    }

    private static int m10112c(int i) {
        return i == 0 ? 8388661 : i;
    }

    private static int m10116d(int i) {
        return i == 0 ? 17 : i;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f6979a != null) {
            Behavior behavior = layoutParams.f6979a;
            if (0.0f > 0.0f) {
                if (this.f7007n == null) {
                    this.f7007n = new Paint();
                }
                Paint paint = this.f7007n;
                Behavior behavior2 = layoutParams.f6979a;
                paint.setColor(-16777216);
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f7007n);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void m10124a(boolean z) {
        int h = ViewCompat.h(this);
        int size = this.f7000g.size();
        for (int i = 0; i < size; i++) {
            int i2;
            View view = (View) this.f7000g.get(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            for (i2 = 0; i2 < i; i2++) {
                if (layoutParams.f6986h == ((View) this.f7000g.get(i2))) {
                    m10114c(view, h);
                }
            }
            Rect rect = this.f7003j;
            Rect rect2 = this.f7004k;
            m10115c(view, rect);
            m10103a(view, true, rect2);
            if (!rect.equals(rect2)) {
                m10111b(view, rect2);
                for (i2 = i + 1; i2 < size; i2++) {
                    View view2 = (View) this.f7000g.get(i2);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.f6979a;
                    if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                        if (z || !layoutParams2.f6991m) {
                            boolean onDependentViewChanged = behavior.onDependentViewChanged(this, view2, view);
                            if (z) {
                                layoutParams2.f6991m = onDependentViewChanged;
                            }
                        } else {
                            layoutParams2.m10091j();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m10121a(android.view.View r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.f7000g;
        r4 = r1.size();
        r3 = r0;
        r2 = r0;
    L_0x0009:
        if (r3 >= r4) goto L_0x0030;
    L_0x000b:
        r0 = r7.f7000g;
        r0 = r0.get(r3);
        r0 = (android.view.View) r0;
        if (r0 != r8) goto L_0x001b;
    L_0x0015:
        r0 = 1;
    L_0x0016:
        r1 = r3 + 1;
        r3 = r1;
        r2 = r0;
        goto L_0x0009;
    L_0x001b:
        if (r2 == 0) goto L_0x002e;
    L_0x001d:
        r1 = r0.getLayoutParams();
        r1 = (android.support.design.widget.CoordinatorLayout.LayoutParams) r1;
        r6 = r1.f6979a;
        r5 = r6;
        if (r5 == 0) goto L_0x002e;
    L_0x0028:
        r1 = r1.m10080a(r7, r0, r8);
        if (r1 == 0) goto L_0x002e;
    L_0x002e:
        r0 = r2;
        goto L_0x0016;
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.a(android.view.View):void");
    }

    public final void m10127b(View view) {
        int size = this.f7000g.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            View view2 = (View) this.f7000g.get(i);
            if (view2 == view) {
                obj2 = 1;
            } else {
                if (obj != null) {
                    LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams.f6979a;
                    if (behavior != null && layoutParams.m10080a(this, view2, view)) {
                        behavior.onDependentViewChanged(this, view2, view);
                    }
                }
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
    }

    public final List<View> m10128c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        List<View> list = this.f7002i;
        list.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && layoutParams.m10080a(this, view, childAt)) {
                list.add(childAt);
            }
        }
        return list;
    }

    private void m10113c() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m10120e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f7014u) {
            return;
        }
        if (z) {
            m10118d();
        } else {
            m10119e();
        }
    }

    private boolean m10120e(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f6985g != null) {
            return true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != view && layoutParams.m10080a(this, view, childAt)) {
                return true;
            }
        }
        return false;
    }

    private void m10118d() {
        if (this.f7008o) {
            if (this.f7013t == null) {
                this.f7013t = new OnPreDrawListener(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7013t);
        }
        this.f7014u = true;
    }

    private void m10119e() {
        if (this.f7008o && this.f7013t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7013t);
        }
        this.f7014u = false;
    }

    private void m10114c(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f6985g != null) {
            Rect rect = this.f7003j;
            Rect rect2 = this.f7004k;
            Rect rect3 = this.f7005l;
            ViewGroupUtils.m10268a(this, layoutParams.f6985g, rect);
            m10103a(view, false, rect2);
            m10100a(view, i, rect, rect3);
            int i2 = rect3.left - rect2.left;
            int i3 = rect3.top - rect2.top;
            if (i2 != 0) {
                view.offsetLeftAndRight(i2);
            }
            if (i3 != 0) {
                view.offsetTopAndBottom(i3);
            }
            if (i2 != 0 || i3 != 0) {
                Behavior behavior = layoutParams.f6979a;
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view, layoutParams.f6985g);
                }
            }
        }
    }

    public final boolean m10125a(View view, int i, int i2) {
        Rect rect = this.f7003j;
        ViewGroupUtils.m10268a(this, view, rect);
        return rect.contains(i, i2);
    }

    public final boolean m10126a(View view, View view2) {
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        boolean z;
        Rect rect = this.f7003j;
        m10103a(view, view.getParent() != this, rect);
        Rect rect2 = this.f7004k;
        if (view2.getParent() != this) {
            z = true;
        } else {
            z = false;
        }
        m10103a(view2, z, rect2);
        if (rect.left > rect2.right || rect.top > rect2.bottom || rect.right < rect2.left || rect.bottom < rect2.top) {
            return false;
        }
        return true;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            Behavior behavior = layoutParams.f6979a;
            if (behavior != null) {
                boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i);
                z2 = z | onStartNestedScroll;
                layoutParams.f6990l = onStartNestedScroll;
            } else {
                layoutParams.f6990l = false;
                z2 = z;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f7019z.b = i;
        this.f7011r = view;
        this.f7012s = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f6990l) {
                Behavior behavior = layoutParams.f6979a;
                if (behavior != null) {
                    behavior.onNestedScrollAccepted(this, childAt, view, view2, i);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        this.f7019z.b();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f6990l) {
                Behavior behavior = layoutParams.f6979a;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view);
                }
                layoutParams.m10088g();
                layoutParams.m10091j();
            }
        }
        this.f7011r = null;
        this.f7012s = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.m10089h()) {
                Behavior b = layoutParams.m10081b();
                if (b != null) {
                    b.onNestedScroll(this, childAt, view, i, i2, i3, i4);
                    obj2 = 1;
                    i5++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m10124a(true);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int max;
            int max2;
            Object obj2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.m10089h()) {
                Behavior b = layoutParams.m10081b();
                if (b != null) {
                    int[] iArr2 = this.f7006m;
                    this.f7006m[1] = 0;
                    iArr2[0] = 0;
                    b.onNestedPreScroll(this, childAt, view, i, i2, this.f7006m);
                    max = i > 0 ? Math.max(i3, this.f7006m[0]) : Math.min(i3, this.f7006m[0]);
                    max2 = i2 > 0 ? Math.max(i4, this.f7006m[1]) : Math.min(i4, this.f7006m[1]);
                    obj2 = 1;
                    i5++;
                    i4 = max2;
                    i3 = max;
                    obj = obj2;
                }
            }
            obj2 = obj;
            max = i3;
            max2 = i4;
            i5++;
            i4 = max2;
            i3 = max;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m10124a(true);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean onNestedFling;
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f6990l) {
                Behavior b = layoutParams.m10081b();
                if (b != null) {
                    onNestedFling = b.onNestedFling(this, childAt, view, f, f2, z) | z2;
                    i++;
                    z2 = onNestedFling;
                }
            }
            onNestedFling = z2;
            i++;
            z2 = onNestedFling;
        }
        if (z2) {
            m10124a(true);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean onNestedPreFling;
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.f6990l) {
                Behavior behavior = layoutParams.f6979a;
                if (behavior != null) {
                    onNestedPreFling = behavior.onNestedPreFling(this, childAt, view, f, f2) | z;
                    i++;
                    z = onNestedPreFling;
                }
            }
            onNestedPreFling = z;
            i++;
            z = onNestedPreFling;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.f7019z.b;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray sparseArray = savedState.f6993a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = m10117d(childAt).f6979a;
            if (!(id == -1 || behavior == null)) {
                Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                if (parcelable2 != null) {
                    behavior.onRestoreInstanceState(this, childAt, parcelable2);
                }
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).f6979a;
            if (!(id == -1 || behavior == null)) {
                Parcelable onSaveInstanceState = behavior.onSaveInstanceState(this, childAt);
                if (onSaveInstanceState != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
        }
        savedState.f6993a = sparseArray;
        return savedState;
    }

    private static void m10105a(List<View> list, Comparator<View> comparator) {
        if (list != null && list.size() >= 2) {
            int i;
            View[] viewArr = new View[list.size()];
            list.toArray(viewArr);
            for (int i2 = 0; i2 < r5; i2++) {
                i = i2;
                for (int i3 = i2 + 1; i3 < r5; i3++) {
                    if (comparator.compare(viewArr[i3], viewArr[i]) < 0) {
                        i = i3;
                    }
                }
                if (i2 != i) {
                    View view = viewArr[i];
                    viewArr[i] = viewArr[i2];
                    viewArr[i2] = view;
                }
            }
            list.clear();
            for (Object add : viewArr) {
                list.add(add);
            }
        }
    }
}

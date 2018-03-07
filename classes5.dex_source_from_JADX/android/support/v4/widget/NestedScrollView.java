package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.List;

/* compiled from: user_login_approval */
public class NestedScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {
    private static final AccessibilityDelegate f480v = new AccessibilityDelegate();
    private static final int[] f481w = new int[]{16843130};
    private long f482a;
    private final Rect f483b;
    private ScrollerCompat f484c;
    private EdgeEffectCompat f485d;
    private EdgeEffectCompat f486e;
    private int f487f;
    private boolean f488g;
    private boolean f489h;
    private View f490i;
    private boolean f491j;
    private VelocityTracker f492k;
    private boolean f493l;
    private boolean f494m;
    private int f495n;
    private int f496o;
    private int f497p;
    private int f498q;
    private final int[] f499r;
    private final int[] f500s;
    private int f501t;
    private SavedState f502u;
    private final NestedScrollingParentHelper f503x;
    private final NestedScrollingChildHelper f504y;
    private float f505z;

    /* compiled from: user_login_approval */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public final boolean m959a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), NestedScrollView.getScrollRange(nestedScrollView));
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m989a(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m989a(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public final void m958a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.a(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.m705b(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = NestedScrollView.getScrollRange(nestedScrollView);
                if (scrollRange > 0) {
                    accessibilityNodeInfoCompat.m725i(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        accessibilityNodeInfoCompat.m699a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        accessibilityNodeInfoCompat.m699a(4096);
                    }
                }
            }
        }

        public final void m960d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            AccessibilityRecordCompat a = AccessibilityEventCompat.m524a(accessibilityEvent);
            a.m821a(NestedScrollView.getScrollRange(nestedScrollView) > 0);
            a.m824d(nestedScrollView.getScrollX());
            a.m825e(nestedScrollView.getScrollY());
            a.m826f(nestedScrollView.getScrollX());
            a.m827g(NestedScrollView.getScrollRange(nestedScrollView));
        }
    }

    /* compiled from: user_login_approval */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C00341();
        public int f479a;

        /* compiled from: user_login_approval */
        final class C00341 implements Creator<SavedState> {
            C00341() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f479a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f479a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f479a + "}";
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f483b = new Rect();
        this.f488g = true;
        this.f489h = false;
        this.f490i = null;
        this.f491j = false;
        this.f494m = true;
        this.f498q = -1;
        this.f499r = new int[2];
        this.f500s = new int[2];
        m964a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f481w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f503x = new NestedScrollingParentHelper(this);
        this.f504y = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.a(this, f480v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f504y.a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f504y.c;
    }

    public boolean startNestedScroll(int i) {
        return this.f504y.a(i);
    }

    public void stopNestedScroll() {
        this.f504y.c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f504y.b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f504y.a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f504y.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f504y.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f504y.a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f503x.f311b = i;
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m987f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f503x.f311b;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m964a() {
        this.f484c = new ScrollerCompat(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f495n = viewConfiguration.getScaledTouchSlop();
        this.f496o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f497p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    private boolean m976b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f493l) {
            this.f493l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f494m = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f493l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m970a(keyEvent);
    }

    private boolean m970a(KeyEvent keyEvent) {
        int i = 33;
        this.f483b.setEmpty();
        if (m976b()) {
            boolean c;
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 19:
                        if (!keyEvent.isAltPressed()) {
                            c = m981c(33);
                            break;
                        }
                        c = m977b(33);
                        break;
                    case 20:
                        if (!keyEvent.isAltPressed()) {
                            c = m981c(130);
                            break;
                        }
                        c = m977b(130);
                        break;
                    case 62:
                        if (!keyEvent.isShiftPressed()) {
                            i = 130;
                        }
                        m966a(i);
                        break;
                }
            }
            c = false;
            return c;
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                return false;
            }
            return true;
        }
    }

    private boolean m978b(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m979c() {
        if (this.f492k == null) {
            this.f492k = VelocityTracker.obtain();
        } else {
            this.f492k.clear();
        }
    }

    private void m982d() {
        if (this.f492k == null) {
            this.f492k = VelocityTracker.obtain();
        }
    }

    private void m984e() {
        if (this.f492k != null) {
            this.f492k.recycle();
            this.f492k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m984e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.f491j) {
            return true;
        }
        if (getScrollY() == 0 && !ViewCompat.b(this, 1)) {
            return false;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m978b((int) motionEvent.getX(), action)) {
                    this.f491j = false;
                    m984e();
                    break;
                }
                this.f487f = action;
                this.f498q = MotionEventCompat.b(motionEvent, 0);
                m979c();
                this.f492k.addMovement(motionEvent);
                if (this.f484c.a()) {
                    z = false;
                }
                this.f491j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f491j = false;
                this.f498q = -1;
                m984e();
                stopNestedScroll();
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                action = this.f498q;
                if (action != -1) {
                    int a = MotionEventCompat.a(motionEvent, action);
                    if (a != -1) {
                        action = (int) MotionEventCompat.d(motionEvent, a);
                        if (Math.abs(action - this.f487f) > this.f495n && (getNestedScrollAxes() & 2) == 0) {
                            this.f491j = true;
                            this.f487f = action;
                            m982d();
                            this.f492k.addMovement(motionEvent);
                            this.f501t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m965a(motionEvent);
                break;
        }
        return this.f491j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1634380556);
        m982d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a2 = MotionEventCompat.a(motionEvent);
        if (a2 == 0) {
            this.f501t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f501t);
        switch (a2) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f484c.a();
                    this.f491j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f484c.a()) {
                        this.f484c.h();
                    }
                    this.f487f = (int) motionEvent.getY();
                    this.f498q = MotionEventCompat.b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                LogUtils.a(-1445443093, a);
                return false;
            case 1:
                if (this.f491j) {
                    VelocityTracker velocityTracker = this.f492k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f497p);
                    a2 = (int) VelocityTrackerCompat.b(velocityTracker, this.f498q);
                    if (Math.abs(a2) > this.f496o) {
                        m987f(-a2);
                    }
                    this.f498q = -1;
                    m986f();
                    break;
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                int a3 = MotionEventCompat.a(motionEvent, this.f498q);
                if (a3 != -1) {
                    int i;
                    int d = (int) MotionEventCompat.d(motionEvent, a3);
                    a2 = this.f487f - d;
                    if (dispatchNestedPreScroll(0, a2, this.f500s, this.f499r)) {
                        a2 -= this.f500s[1];
                        obtain.offsetLocation(0.0f, (float) this.f499r[1]);
                        this.f501t += this.f499r[1];
                    }
                    if (this.f491j || Math.abs(a2) <= this.f495n) {
                        i = a2;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f491j = true;
                        if (a2 > 0) {
                            i = a2 - this.f495n;
                        } else {
                            i = a2 + this.f495n;
                        }
                    }
                    if (this.f491j) {
                        Object obj;
                        this.f487f = d - this.f499r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange(this);
                        a2 = ViewCompat.a(this);
                        if (a2 == 0 || (a2 == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m968a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0) && !hasNestedScrollingParent()) {
                            this.f492k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f499r)) {
                            if (obj != null) {
                                m988g();
                                a2 = scrollY + i;
                                if (a2 < 0) {
                                    this.f485d.a(((float) i) / ((float) getHeight()), MotionEventCompat.c(motionEvent, a3) / ((float) getWidth()));
                                    if (!this.f486e.a()) {
                                        this.f486e.c();
                                    }
                                } else if (a2 > scrollRange) {
                                    this.f486e.a(((float) i) / ((float) getHeight()), 1.0f - (MotionEventCompat.c(motionEvent, a3) / ((float) getWidth())));
                                    if (!this.f485d.a()) {
                                        this.f485d.c();
                                    }
                                }
                                if (!(this.f485d == null || (this.f485d.a() && this.f486e.a()))) {
                                    ViewCompat.d(this);
                                    break;
                                }
                            }
                        }
                        this.f487f -= this.f499r[1];
                        obtain.offsetLocation(0.0f, (float) this.f499r[1]);
                        this.f501t += this.f499r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f498q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f491j && getChildCount() > 0) {
                    this.f498q = -1;
                    m986f();
                    break;
                }
            case 5:
                a2 = MotionEventCompat.b(motionEvent);
                this.f487f = (int) MotionEventCompat.d(motionEvent, a2);
                this.f498q = MotionEventCompat.b(motionEvent, a2);
                break;
            case 6:
                m965a(motionEvent);
                this.f487f = (int) MotionEventCompat.d(motionEvent, MotionEventCompat.a(motionEvent, this.f498q));
                break;
        }
        if (this.f492k != null) {
            this.f492k.addMovement(obtain);
        }
        obtain.recycle();
        LogUtils.a(406601907, a);
        return true;
    }

    private void m965a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (MotionEventCompat.b(motionEvent, action) == this.f498q) {
            action = action == 0 ? 1 : 0;
            this.f487f = (int) MotionEventCompat.d(motionEvent, action);
            this.f498q = MotionEventCompat.b(motionEvent, action);
            if (this.f492k != null) {
                this.f492k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((MotionEventCompat.d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f491j) {
                    return false;
                }
                float e = MotionEventCompat.e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange(this);
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f505z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f505z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f505z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    private boolean m968a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean z;
        int a = ViewCompat.a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        a = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i10 = -i7;
        int i11 = i7 + i5;
        int i12 = -i8;
        int i13 = i8 + i6;
        if (i9 > i11) {
            i10 = i11;
            z = true;
        } else if (i9 < i10) {
            z = true;
        } else {
            z = false;
            i10 = i9;
        }
        boolean z2 = false;
        if (a > i13) {
            z2 = true;
        } else if (a < i12) {
            z2 = true;
            i13 = i12;
        } else {
            i13 = a;
        }
        onOverScrolled(i10, i13, z, z2);
        if (z || z2) {
            return true;
        }
        return false;
    }

    public static int getScrollRange(NestedScrollView nestedScrollView) {
        if (nestedScrollView.getChildCount() > 0) {
            return Math.max(0, nestedScrollView.getChildAt(0).getHeight() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()));
        }
        return 0;
    }

    private View m963a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private boolean m966a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f483b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f483b.top + height > childAt.getBottom()) {
                    this.f483b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f483b.top = getScrollY() - height;
            if (this.f483b.top < 0) {
                this.f483b.top = 0;
            }
        }
        this.f483b.bottom = this.f483b.top + height;
        return m967a(i, this.f483b.top, this.f483b.bottom);
    }

    private boolean m977b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f483b.top = 0;
        this.f483b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f483b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f483b.top = this.f483b.bottom - height;
            }
        }
        return m967a(i, this.f483b.top, this.f483b.bottom);
    }

    private boolean m967a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m963a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m983d(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m981c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m972a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m983d(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f483b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f483b);
            m983d(m961a(this.f483b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m971a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m971a(View view) {
        return !m972a(view, 0, getHeight());
    }

    private boolean m972a(View view, int i, int i2) {
        view.getDrawingRect(this.f483b);
        offsetDescendantRectToMyCoords(view, this.f483b);
        return this.f483b.bottom + i >= getScrollY() && this.f483b.top - i <= getScrollY() + i2;
    }

    private void m983d(int i) {
        if (i == 0) {
            return;
        }
        if (this.f494m) {
            m980c(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m980c(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f482a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f484c.a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ViewCompat.d(this);
            } else {
                if (!this.f484c.a()) {
                    this.f484c.h();
                }
                scrollBy(i, i2);
            }
            this.f482a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m989a(int i, int i2) {
        m980c(i - getScrollX(), i2 - getScrollY());
    }

    protected int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    protected int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1419710340);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1191262358, a);
    }

    public void computeScroll() {
        if (this.f484c.g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f484c.b();
            int c = this.f484c.c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange(this);
                int a = ViewCompat.a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m968a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0);
                if (i != 0) {
                    m988g();
                    if (c <= 0 && scrollY > 0) {
                        this.f485d.a((int) this.f484c.f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f486e.a((int) this.f484c.f());
                    }
                }
            }
        }
    }

    private void m975b(View view) {
        view.getDrawingRect(this.f483b);
        offsetDescendantRectToMyCoords(view, this.f483b);
        int a = m961a(this.f483b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m969a(Rect rect, boolean z) {
        int a = m961a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m980c(0, a);
            }
        }
        return z2;
    }

    private int m961a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f488g) {
            this.f490i = view2;
        } else {
            m975b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || m971a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m969a(rect, z);
    }

    public void requestLayout() {
        this.f488g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f488g = false;
        if (this.f490i != null && m973a(this.f490i, (View) this)) {
            m975b(this.f490i);
        }
        this.f490i = null;
        if (!this.f489h) {
            if (this.f502u != null) {
                scrollTo(getScrollX(), this.f502u.f479a);
                this.f502u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f489h = true;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1593390076);
        this.f489h = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2006650926, a);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1947481427);
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus) {
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1655019498, a);
            return;
        }
        if (m972a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f483b);
            offsetDescendantRectToMyCoords(findFocus, this.f483b);
            m983d(m961a(this.f483b));
        }
        LogUtils.g(-1222624470, a);
    }

    private static boolean m973a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m973a((View) parent, view2);
    }

    private void m985e(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f484c.a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ViewCompat.d(this);
        }
    }

    private void m987f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange(this) || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m985e(i);
            }
        }
    }

    private void m986f() {
        this.f491j = false;
        m984e();
        if (this.f485d != null) {
            this.f485d.c();
            this.f486e.c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m974b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m974b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m988g() {
        if (ViewCompat.a(this) == 2) {
            this.f485d = null;
            this.f486e = null;
        } else if (this.f485d == null) {
            Context context = getContext();
            this.f485d = new EdgeEffectCompat(context);
            this.f486e = new EdgeEffectCompat(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f485d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f485d.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f485d.a(width, getHeight());
                if (this.f485d.a(canvas)) {
                    ViewCompat.d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f486e.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(this), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f486e.a(width, height);
                if (this.f486e.a(canvas)) {
                    ViewCompat.d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m974b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f502u = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f479a = getScrollY();
        return savedState;
    }
}

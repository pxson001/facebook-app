package com.facebook.fbreact.views.fbscroll;

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
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
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

/* compiled from: eventCount */
public class BugFixScrollView extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {
    private static final AccessibilityDelegate f7410v = new AccessibilityDelegate();
    private static final int[] f7411w = new int[]{16843130};
    public int f7412A;
    public int f7413B;
    private long f7414a;
    private final Rect f7415b;
    public ScrollerCompat f7416c;
    private EdgeEffectCompat f7417d;
    private EdgeEffectCompat f7418e;
    private int f7419f;
    private boolean f7420g;
    private boolean f7421h;
    private View f7422i;
    private boolean f7423j;
    public VelocityTracker f7424k;
    public boolean f7425l;
    private boolean f7426m;
    public int f7427n;
    public int f7428o;
    public int f7429p;
    private int f7430q;
    private final int[] f7431r;
    private final int[] f7432s;
    private int f7433t;
    private SavedState f7434u;
    private final NestedScrollingParentHelper f7435x;
    private final NestedScrollingChildHelper f7436y;
    private float f7437z;

    /* compiled from: eventCount */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public final boolean m8650a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            BugFixScrollView bugFixScrollView = (BugFixScrollView) view;
            if (!bugFixScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((bugFixScrollView.getHeight() - bugFixScrollView.getPaddingBottom()) - bugFixScrollView.getPaddingTop()) + bugFixScrollView.getScrollY(), BugFixScrollView.getScrollRange(bugFixScrollView));
                    if (min == bugFixScrollView.getScrollY()) {
                        return false;
                    }
                    bugFixScrollView.m8628a(0, min);
                    return true;
                case 8192:
                    min = Math.max(bugFixScrollView.getScrollY() - ((bugFixScrollView.getHeight() - bugFixScrollView.getPaddingBottom()) - bugFixScrollView.getPaddingTop()), bugFixScrollView.f7413B);
                    if (min == bugFixScrollView.getScrollY()) {
                        return false;
                    }
                    bugFixScrollView.m8628a(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public final void m8649a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.a(view, accessibilityNodeInfoCompat);
            BugFixScrollView bugFixScrollView = (BugFixScrollView) view;
            accessibilityNodeInfoCompat.b(ScrollView.class.getName());
            if (bugFixScrollView.isEnabled()) {
                int scrollRange = BugFixScrollView.getScrollRange(bugFixScrollView);
                if (scrollRange > 0) {
                    accessibilityNodeInfoCompat.i(true);
                    if (bugFixScrollView.getScrollY() > bugFixScrollView.f7412A) {
                        accessibilityNodeInfoCompat.a(8192);
                    }
                    if (bugFixScrollView.getScrollY() < scrollRange) {
                        accessibilityNodeInfoCompat.a(4096);
                    }
                }
            }
        }

        public final void m8651d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            BugFixScrollView bugFixScrollView = (BugFixScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            AccessibilityRecordCompat a = AccessibilityEventCompat.a(accessibilityEvent);
            a.a(BugFixScrollView.getScrollRange(bugFixScrollView) > 0);
            a.d(bugFixScrollView.getScrollX());
            a.e(bugFixScrollView.getScrollY());
            a.f(bugFixScrollView.getScrollX());
            a.g(BugFixScrollView.getScrollRange(bugFixScrollView));
        }
    }

    /* compiled from: eventCount */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C09461();
        public int f7479a;

        /* compiled from: eventCount */
        final class C09461 implements Creator<SavedState> {
            C09461() {
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
            this.f7479a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7479a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f7479a + "}";
        }
    }

    public BugFixScrollView(Context context) {
        this(context, null);
    }

    private BugFixScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private BugFixScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7415b = new Rect();
        this.f7420g = true;
        this.f7421h = false;
        this.f7422i = null;
        this.f7423j = false;
        this.f7426m = true;
        this.f7430q = -1;
        this.f7431r = new int[2];
        this.f7432s = new int[2];
        this.f7412A = 0;
        this.f7413B = 0;
        this.f7416c = ScrollerCompat.a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f7427n = viewConfiguration.getScaledTouchSlop();
        this.f7428o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7429p = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7411w, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        if (z != this.f7425l) {
            this.f7425l = z;
            requestLayout();
        }
        obtainStyledAttributes.recycle();
        this.f7435x = new NestedScrollingParentHelper(this);
        this.f7436y = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.a(this, f7410v);
    }

    public void setMinScrollDeltaY(int i) {
        this.f7412A = i;
        if (getScrollY() < this.f7412A) {
            scrollTo(getScrollX(), this.f7412A);
        }
    }

    public void setMaxScrollDeltaY(int i) {
        this.f7413B = i;
        int scrollRange = getScrollRange(this);
        if (getScrollY() > scrollRange) {
            scrollTo(getScrollX(), scrollRange);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f7436y.a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f7436y.c;
    }

    public boolean startNestedScroll(int i) {
        return this.f7436y.a(i);
    }

    public void stopNestedScroll() {
        this.f7436y.c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f7436y.b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f7436y.a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f7436y.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f7436y.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f7436y.a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f7435x.b = i;
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
        m8625f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f7435x.b;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY() - this.f7412A;
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
        int bottom = ((getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom())) - this.f7413B;
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
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

    public void setSmoothScrollingEnabled(boolean z) {
        this.f7426m = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7425l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m8611a(keyEvent);
    }

    private boolean m8611a(KeyEvent keyEvent) {
        int i = 33;
        this.f7415b.setEmpty();
        int i2 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && getHeight() < (((childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) - this.f7412A) - this.f7413B) {
            i2 = 1;
        }
        if (i2 != 0) {
            boolean d;
            if (keyEvent.getAction() == 0) {
                switch (keyEvent.getKeyCode()) {
                    case 19:
                        if (!keyEvent.isAltPressed()) {
                            d = m8621d(33);
                            break;
                        }
                        d = m8619c(33);
                        break;
                    case 20:
                        if (!keyEvent.isAltPressed()) {
                            d = m8621d(130);
                            break;
                        }
                        d = m8619c(130);
                        break;
                    case 62:
                        if (!keyEvent.isShiftPressed()) {
                            i = 130;
                        }
                        m8617b(i);
                        break;
                }
            }
            d = false;
            return d;
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

    private void m8620d() {
        if (this.f7424k == null) {
            this.f7424k = VelocityTracker.obtain();
        }
    }

    private void m8622e() {
        if (this.f7424k != null) {
            this.f7424k.recycle();
            this.f7424k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m8622e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.f7423j) {
            return true;
        }
        if (getScrollY() == 0 && !ViewCompat.b(this, 1)) {
            return false;
        }
        int x;
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                x = (int) motionEvent.getX();
                int i = 0;
                if (getChildCount() > 0) {
                    int scrollY = getScrollY();
                    View childAt = getChildAt(0);
                    if (action >= childAt.getTop() - scrollY && action < childAt.getBottom() - scrollY && x >= childAt.getLeft() && x < childAt.getRight()) {
                        i = 1;
                    }
                }
                if (i != 0) {
                    this.f7419f = action;
                    this.f7430q = MotionEventCompat.b(motionEvent, 0);
                    if (this.f7424k == null) {
                        this.f7424k = VelocityTracker.obtain();
                    } else {
                        this.f7424k.clear();
                    }
                    this.f7424k.addMovement(motionEvent);
                    if (this.f7416c.a()) {
                        z = false;
                    }
                    this.f7423j = z;
                    startNestedScroll(2);
                    break;
                }
                this.f7423j = false;
                m8622e();
                break;
            case 1:
            case 3:
                this.f7423j = false;
                this.f7430q = -1;
                m8622e();
                stopNestedScroll();
                break;
            case 2:
                action = this.f7430q;
                if (action != -1) {
                    x = MotionEventCompat.a(motionEvent, action);
                    if (x != -1) {
                        action = (int) MotionEventCompat.d(motionEvent, x);
                        if (Math.abs(action - this.f7419f) > this.f7427n && (getNestedScrollAxes() & 2) == 0) {
                            this.f7423j = true;
                            this.f7419f = action;
                            m8620d();
                            this.f7424k.addMovement(motionEvent);
                            this.f7433t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("BugFixScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m8607a(motionEvent);
                break;
        }
        return this.f7423j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -553242101);
        m8620d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a2 = MotionEventCompat.a(motionEvent);
        if (a2 == 0) {
            this.f7433t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f7433t);
        switch (a2) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f7416c.a();
                    this.f7423j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f7416c.a()) {
                        this.f7416c.h();
                    }
                    this.f7419f = (int) motionEvent.getY();
                    this.f7430q = MotionEventCompat.b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                LogUtils.a(1212253051, a);
                return false;
            case 1:
                if (this.f7423j) {
                    VelocityTracker velocityTracker = this.f7424k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f7429p);
                    a2 = (int) VelocityTrackerCompat.b(velocityTracker, this.f7430q);
                    if (Math.abs(a2) > this.f7428o) {
                        m8625f(-a2);
                    }
                    this.f7430q = -1;
                    m8624f();
                    break;
                }
                break;
            case 2:
                int a3 = MotionEventCompat.a(motionEvent, this.f7430q);
                if (a3 != -1) {
                    int i;
                    int d = (int) MotionEventCompat.d(motionEvent, a3);
                    a2 = this.f7419f - d;
                    if (dispatchNestedPreScroll(0, a2, this.f7432s, this.f7431r)) {
                        a2 -= this.f7432s[1];
                        obtain.offsetLocation(0.0f, (float) this.f7431r[1]);
                        this.f7433t += this.f7431r[1];
                    }
                    if (this.f7423j || Math.abs(a2) <= this.f7427n) {
                        i = a2;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f7423j = true;
                        if (a2 > 0) {
                            i = a2 - this.f7427n;
                        } else {
                            i = a2 + this.f7427n;
                        }
                    }
                    if (this.f7423j) {
                        Object obj;
                        this.f7419f = d - this.f7431r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange(this);
                        a2 = ViewCompat.a(this);
                        if (a2 == 0 || (a2 == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m8609a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0) && !hasNestedScrollingParent()) {
                            this.f7424k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f7431r)) {
                            if (obj != null) {
                                m8626g();
                                a2 = scrollY + i;
                                if (a2 < this.f7412A) {
                                    this.f7417d.a(((float) i) / ((float) getHeight()), MotionEventCompat.c(motionEvent, a3) / ((float) getWidth()));
                                    if (!this.f7418e.a()) {
                                        this.f7418e.c();
                                    }
                                } else if (a2 > scrollRange) {
                                    this.f7418e.a(((float) i) / ((float) getHeight()), 1.0f - (MotionEventCompat.c(motionEvent, a3) / ((float) getWidth())));
                                    if (!this.f7417d.a()) {
                                        this.f7417d.c();
                                    }
                                }
                                if (!(this.f7417d == null || (this.f7417d.a() && this.f7418e.a()))) {
                                    ViewCompat.d(this);
                                    break;
                                }
                            }
                        }
                        this.f7419f -= this.f7431r[1];
                        obtain.offsetLocation(0.0f, (float) this.f7431r[1]);
                        this.f7433t += this.f7431r[1];
                        break;
                    }
                }
                Log.e("BugFixScrollView", "Invalid pointerId=" + this.f7430q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f7423j && getChildCount() > 0) {
                    this.f7430q = -1;
                    m8624f();
                    break;
                }
            case 5:
                a2 = MotionEventCompat.b(motionEvent);
                this.f7419f = (int) MotionEventCompat.d(motionEvent, a2);
                this.f7430q = MotionEventCompat.b(motionEvent, a2);
                break;
            case 6:
                m8607a(motionEvent);
                this.f7419f = (int) MotionEventCompat.d(motionEvent, MotionEventCompat.a(motionEvent, this.f7430q));
                break;
        }
        if (this.f7424k != null) {
            this.f7424k.addMovement(obtain);
        }
        obtain.recycle();
        LogUtils.a(1947952224, a);
        return true;
    }

    private void m8607a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (MotionEventCompat.b(motionEvent, action) == this.f7430q) {
            action = action == 0 ? 1 : 0;
            this.f7419f = (int) MotionEventCompat.d(motionEvent, action);
            this.f7430q = MotionEventCompat.b(motionEvent, action);
            if (this.f7424k != null) {
                this.f7424k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((MotionEventCompat.d(motionEvent) & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (!this.f7423j) {
                        float e = MotionEventCompat.e(motionEvent, 9);
                        if (e != 0.0f) {
                            int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                            int scrollRange = getScrollRange(this);
                            int scrollY = getScrollY();
                            verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                            if (verticalScrollFactorCompat < this.f7412A) {
                                scrollRange = this.f7412A;
                            } else if (verticalScrollFactorCompat <= scrollRange) {
                                scrollRange = verticalScrollFactorCompat;
                            }
                            if (scrollRange != scrollY) {
                                super.scrollTo(getScrollX(), scrollRange);
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f7437z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f7437z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f7437z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!this.f7416c.a() && ((i2 >= getScrollRange(this) || i2 <= this.f7412A) && this.f7416c.c() != this.f7416c.e())) {
            this.f7416c.h();
        }
        super.scrollTo(i, i2);
    }

    private boolean m8609a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
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
        int i12 = (-i8) + this.f7412A;
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

    public static int getScrollRange(BugFixScrollView bugFixScrollView) {
        if (bugFixScrollView.getChildCount() > 0) {
            return Math.max(0, (bugFixScrollView.getChildAt(0).getHeight() - ((bugFixScrollView.getHeight() - bugFixScrollView.getPaddingBottom()) - bugFixScrollView.getPaddingTop())) - bugFixScrollView.f7413B);
        }
        return 0;
    }

    private View m8606a(boolean z, int i, int i2) {
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

    private boolean m8617b(int i) {
        Object obj = i == 130 ? 1 : null;
        int height = getHeight();
        if (obj != null) {
            this.f7415b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f7415b.top + height > childAt.getBottom()) {
                    this.f7415b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f7415b.top = getScrollY() - height;
            if (this.f7415b.top < this.f7412A) {
                this.f7415b.top = this.f7412A;
            }
        }
        this.f7415b.bottom = height + this.f7415b.top;
        return m8608a(i, this.f7415b.top, this.f7415b.bottom);
    }

    private boolean m8619c(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f7415b.top = 0;
        this.f7415b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f7415b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f7415b.top = this.f7415b.bottom - height;
            }
        }
        return m8608a(i, this.f7415b.top, this.f7415b.bottom);
    }

    private boolean m8608a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m8606a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m8623e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m8621d(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int height = (int) (0.5f * ((float) getHeight()));
        if (findNextFocus == null || !m8613a(findNextFocus, height, getHeight())) {
            if (i == 33 && getScrollY() < height) {
                height = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < height) {
                    height = bottom - scrollY;
                }
            }
            if (height == 0) {
                return false;
            }
            if (i != 130) {
                height = -height;
            }
            m8623e(height);
        } else {
            findNextFocus.getDrawingRect(this.f7415b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f7415b);
            m8623e(mo223a(this.f7415b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m8612a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m8612a(View view) {
        return !m8613a(view, 0, getHeight());
    }

    private boolean m8613a(View view, int i, int i2) {
        view.getDrawingRect(this.f7415b);
        offsetDescendantRectToMyCoords(view, this.f7415b);
        return this.f7415b.bottom + i >= getScrollY() && this.f7415b.top - i <= getScrollY() + i2;
    }

    private void m8623e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f7426m) {
            m8618c(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m8618c(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f7414a > 250) {
                int max = Math.max(0, (getChildAt(0).getHeight() - this.f7413B) - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f7416c.a(getScrollX(), scrollY, 0, Math.max(this.f7412A, Math.min(scrollY + i2, max)) - scrollY);
                ViewCompat.d(this);
            } else {
                if (!this.f7416c.a()) {
                    this.f7416c.h();
                }
                scrollBy(i, i2);
            }
            this.f7414a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m8628a(int i, int i2) {
        m8618c(i - getScrollX(), i2 - getScrollY());
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
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1649341139);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -559390506, a);
    }

    public void computeScroll() {
        if (this.f7416c.g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f7416c.b();
            int c = this.f7416c.c();
            if (scrollX == b && scrollY == c) {
                this.f7416c.h();
                return;
            }
            int scrollRange = getScrollRange(this);
            int a = ViewCompat.a(this);
            int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
            m8609a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0);
            if (i != 0) {
                m8626g();
                if (c <= this.f7412A && scrollY > this.f7412A) {
                    this.f7417d.a((int) this.f7416c.f());
                } else if (c >= scrollRange && scrollY < scrollRange) {
                    this.f7418e.a((int) this.f7416c.f());
                }
            }
        }
    }

    private void m8616b(View view) {
        view.getDrawingRect(this.f7415b);
        offsetDescendantRectToMyCoords(view, this.f7415b);
        int a = mo223a(this.f7415b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m8610a(Rect rect, boolean z) {
        int a = mo223a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m8618c(0, a);
            }
        }
        return z2;
    }

    private int mo223a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > this.f7412A) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight() - this.f7413B) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, (getChildAt(0).getBottom() - this.f7413B) - i);
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
        if (this.f7420g) {
            this.f7422i = view2;
        } else {
            m8616b(view2);
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
        if (findNextFocus == null || m8612a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m8610a(rect, z);
    }

    public void requestLayout() {
        this.f7420g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7420g = false;
        if (this.f7422i != null && m8614a(this.f7422i, (View) this)) {
            m8616b(this.f7422i);
        }
        this.f7422i = null;
        if (!this.f7421h) {
            if (this.f7434u != null) {
                scrollTo(getScrollX(), this.f7434u.f7479a);
                this.f7434u = null;
            }
            int max = Math.max(0, ((getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop())) - this.f7413B);
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < this.f7412A) {
                scrollTo(getScrollX(), this.f7412A);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f7421h = true;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -136094529);
        this.f7421h = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2088188119, a);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -64534956);
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus) {
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2126258505, a);
            return;
        }
        if (m8613a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f7415b);
            offsetDescendantRectToMyCoords(findFocus, this.f7415b);
            m8623e(mo223a(this.f7415b));
        }
        LogUtils.g(1738483691, a);
    }

    private static boolean m8614a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && m8614a((View) parent, view2);
    }

    public void mo222a(int i) {
        if (getChildCount() > 0) {
            this.f7416c.a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Integer.MAX_VALUE, 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            ViewCompat.d(this);
        }
    }

    private void m8625f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange(this) || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                mo222a(i);
            }
        }
    }

    private void m8624f() {
        this.f7423j = false;
        m8622e();
        if (this.f7417d != null) {
            this.f7417d.c();
            this.f7418e.c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m8615b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int max = Math.max(this.f7412A, m8615b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight() - this.f7413B));
            if (b != getScrollX() || max != getScrollY()) {
                super.scrollTo(b, max);
            }
        }
    }

    private void m8626g() {
        if (ViewCompat.a(this) == 2) {
            this.f7417d = null;
            this.f7418e = null;
        } else if (this.f7417d == null) {
            Context context = getContext();
            this.f7417d = new EdgeEffectCompat(context);
            this.f7418e = new EdgeEffectCompat(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f7417d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f7417d.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(this.f7412A, scrollY));
                this.f7417d.a(width, getHeight());
                if (this.f7417d.a(canvas)) {
                    ViewCompat.d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f7418e.a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(this), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f7418e.a(width, height);
                if (this.f7418e.a(canvas)) {
                    ViewCompat.d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m8615b(int i, int i2, int i3) {
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
        this.f7434u = savedState;
        requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7479a = getScrollY();
        return savedState;
    }
}

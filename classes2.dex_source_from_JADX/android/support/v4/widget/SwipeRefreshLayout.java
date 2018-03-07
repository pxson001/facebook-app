package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: nux_shown_count */
public class SwipeRefreshLayout extends ViewGroup {
    private static final String f11678c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] f11679s = new int[]{16842766};
    private Animation f11680A;
    private Animation f11681B;
    public float f11682C;
    public boolean f11683D;
    private int f11684E;
    private int f11685F;
    public boolean f11686G;
    private AnimationListener f11687H;
    private final Animation f11688I;
    private final Animation f11689J;
    protected int f11690a;
    protected int f11691b;
    private View f11692d;
    public OnRefreshListener f11693e;
    public boolean f11694f;
    private int f11695g;
    private float f11696h;
    private int f11697i;
    public int f11698j;
    private boolean f11699k;
    private float f11700l;
    private float f11701m;
    private boolean f11702n;
    private int f11703o;
    public boolean f11704p;
    private boolean f11705q;
    private final DecelerateInterpolator f11706r;
    public CircleImageView f11707t;
    private int f11708u;
    public float f11709v;
    public MaterialProgressDrawable f11710w;
    private Animation f11711x;
    private Animation f11712y;
    private Animation f11713z;

    /* compiled from: nux_shown_count */
    class C04861 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f11714a;

        C04861(SwipeRefreshLayout swipeRefreshLayout) {
            this.f11714a = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f11714a.f11694f) {
                this.f11714a.f11710w.setAlpha(255);
                this.f11714a.f11710w.start();
                if (this.f11714a.f11683D && this.f11714a.f11693e != null) {
                    this.f11714a.f11693e.mo2418a();
                }
            } else {
                this.f11714a.f11710w.stop();
                this.f11714a.f11707t.setVisibility(8);
                SwipeRefreshLayout.setColorViewAlpha(this.f11714a, 255);
                if (this.f11714a.f11704p) {
                    SwipeRefreshLayout.setAnimationProgress(this.f11714a, 0.0f);
                } else {
                    this.f11714a.m16964a(this.f11714a.f11691b - this.f11714a.f11698j, true);
                }
            }
            this.f11714a.f11698j = this.f11714a.f11707t.getTop();
        }
    }

    /* compiled from: nux_shown_count */
    class C04876 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f11715a;

        C04876(SwipeRefreshLayout swipeRefreshLayout) {
            this.f11715a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            if (this.f11715a.f11686G) {
                i = (int) this.f11715a.f11682C;
            } else {
                i = (int) (this.f11715a.f11682C - ((float) Math.abs(this.f11715a.f11691b)));
            }
            this.f11715a.m16964a((((int) (((float) (i - this.f11715a.f11690a)) * f)) + this.f11715a.f11690a) - this.f11715a.f11707t.getTop(), false);
            this.f11715a.f11710w.m16998a(1.0f - f);
        }
    }

    /* compiled from: nux_shown_count */
    class C04887 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f11716a;

        C04887(SwipeRefreshLayout swipeRefreshLayout) {
            this.f11716a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f11716a.m16962a(f);
        }
    }

    /* compiled from: nux_shown_count */
    public interface OnRefreshListener {
        void mo2418a();
    }

    public static void setColorViewAlpha(SwipeRefreshLayout swipeRefreshLayout, int i) {
        swipeRefreshLayout.f11707t.getBackground().setAlpha(i);
        swipeRefreshLayout.f11710w.setAlpha(i);
    }

    public final void m16994a(boolean z, int i, int i2) {
        this.f11704p = z;
        this.f11707t.setVisibility(8);
        this.f11698j = i;
        this.f11691b = i;
        this.f11682C = (float) i2;
        this.f11686G = true;
        this.f11707t.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f11684E = i2;
                this.f11685F = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f11684E = i2;
                this.f11685F = i2;
            }
            this.f11707t.setImageDrawable(null);
            this.f11710w.m17000a(i);
            this.f11707t.setImageDrawable(this.f11710w);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11694f = false;
        this.f11696h = -1.0f;
        this.f11699k = false;
        this.f11703o = -1;
        this.f11708u = -1;
        this.f11687H = new C04861(this);
        this.f11688I = new C04876(this);
        this.f11689J = new C04887(this);
        this.f11695g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11697i = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f11706r = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11679s);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f11684E = (int) (displayMetrics.density * 40.0f);
        this.f11685F = (int) (displayMetrics.density * 40.0f);
        m16976b();
        ViewCompat.f6441a.mo1579a((ViewGroup) this, true);
        this.f11682C = displayMetrics.density * 64.0f;
        this.f11696h = this.f11682C;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f11708u < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f11708u;
        }
        if (i2 >= this.f11708u) {
            return i2 + 1;
        }
        return i2;
    }

    private void m16976b() {
        this.f11707t = new CircleImageView(getContext(), -328966, 20.0f);
        this.f11710w = new MaterialProgressDrawable(getContext(), this);
        this.f11710w.m17002b(-328966);
        this.f11707t.setImageDrawable(this.f11710w);
        this.f11707t.setVisibility(8);
        addView(this.f11707t);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f11693e = onRefreshListener;
    }

    private static boolean m16981c() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f11694f == z) {
            m16971a(z, false);
            return;
        }
        int i;
        this.f11694f = z;
        if (this.f11686G) {
            i = (int) this.f11682C;
        } else {
            i = (int) (this.f11682C + ((float) this.f11691b));
        }
        m16964a(i - this.f11698j, true);
        this.f11683D = false;
        m16970a(this.f11687H);
    }

    private void m16970a(AnimationListener animationListener) {
        this.f11707t.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f11710w.setAlpha(255);
        }
        this.f11711x = new 2(this);
        this.f11711x.setDuration((long) this.f11697i);
        if (animationListener != null) {
            this.f11707t.f11717a = animationListener;
        }
        this.f11707t.clearAnimation();
        this.f11707t.startAnimation(this.f11711x);
    }

    public static void setAnimationProgress(SwipeRefreshLayout swipeRefreshLayout, float f) {
        if (m16981c()) {
            setColorViewAlpha(swipeRefreshLayout, (int) (255.0f * f));
            return;
        }
        ViewCompat.m10960e(swipeRefreshLayout.f11707t, f);
        ViewCompat.m10962f(swipeRefreshLayout.f11707t, f);
    }

    private void m16971a(boolean z, boolean z2) {
        if (this.f11694f != z) {
            this.f11683D = z2;
            m16987f();
            this.f11694f = z;
            if (this.f11694f) {
                m16963a(this.f11698j, this.f11687H);
            } else {
                m16979b(this, this.f11687H);
            }
        }
    }

    public static void m16979b(SwipeRefreshLayout swipeRefreshLayout, AnimationListener animationListener) {
        swipeRefreshLayout.f11712y = new 3(swipeRefreshLayout);
        swipeRefreshLayout.f11712y.setDuration(150);
        swipeRefreshLayout.f11707t.f11717a = animationListener;
        swipeRefreshLayout.f11707t.clearAnimation();
        swipeRefreshLayout.f11707t.startAnimation(swipeRefreshLayout.f11712y);
    }

    private void m16984d() {
        this.f11713z = m16961a(this.f11710w.getAlpha(), 76);
    }

    private void m16986e() {
        this.f11680A = m16961a(this.f11710w.getAlpha(), 255);
    }

    private Animation m16961a(int i, int i2) {
        if (this.f11704p && m16981c()) {
            return null;
        }
        4 4 = new 4(this, i, i2);
        4.setDuration(300);
        this.f11707t.f11717a = null;
        this.f11707t.clearAnimation();
        this.f11707t.startAnimation(4);
        return 4;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f11707t.setBackgroundColor(i);
        this.f11710w.m17002b(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m16987f();
        MaterialProgressDrawable materialProgressDrawable = this.f11710w;
        materialProgressDrawable.f11730h.m17013a(iArr);
        materialProgressDrawable.f11730h.f11750k = 0;
    }

    public final boolean m16995a() {
        return this.f11694f;
    }

    private void m16987f() {
        if (this.f11692d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f11707t)) {
                    i++;
                } else {
                    this.f11692d = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f11696h = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f11692d == null) {
                m16987f();
            }
            if (this.f11692d != null) {
                View view = this.f11692d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f11707t.getMeasuredWidth();
                this.f11707t.layout((measuredWidth / 2) - (measuredHeight / 2), this.f11698j, (measuredWidth / 2) + (measuredHeight / 2), this.f11698j + this.f11707t.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11692d == null) {
            m16987f();
        }
        if (this.f11692d != null) {
            int i3;
            this.f11692d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f11707t.measure(MeasureSpec.makeMeasureSpec(this.f11684E, 1073741824), MeasureSpec.makeMeasureSpec(this.f11685F, 1073741824));
            if (!(this.f11686G || this.f11699k)) {
                this.f11699k = true;
                i3 = -this.f11707t.getMeasuredHeight();
                this.f11691b = i3;
                this.f11698j = i3;
            }
            this.f11708u = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f11707t) {
                    this.f11708u = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f11707t != null ? this.f11707t.getMeasuredHeight() : 0;
    }

    private boolean m16990g() {
        if (VERSION.SDK_INT >= 14) {
            return ViewCompat.m10953b(this.f11692d, -1);
        }
        if (!(this.f11692d instanceof AbsListView)) {
            return this.f11692d.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.f11692d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m16987f();
        int a = MotionEventCompat.a(motionEvent);
        if (this.f11705q && a == 0) {
            this.f11705q = false;
        }
        if (!isEnabled() || this.f11705q || m16990g() || this.f11694f) {
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                m16964a(this.f11691b - this.f11707t.getTop(), true);
                this.f11703o = MotionEventCompat.b(motionEvent, 0);
                this.f11702n = false;
                a2 = m16960a(motionEvent, this.f11703o);
                if (a2 != -1.0f) {
                    this.f11701m = a2;
                    break;
                }
                return false;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 3:
                this.f11702n = false;
                this.f11703o = -1;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f11703o == -1) {
                    Log.e(f11678c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = m16960a(motionEvent, this.f11703o);
                if (a2 != -1.0f) {
                    if (a2 - this.f11701m > ((float) this.f11695g) && !this.f11702n) {
                        this.f11700l = this.f11701m + ((float) this.f11695g);
                        this.f11702n = true;
                        this.f11710w.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                m16969a(motionEvent);
                break;
        }
        return this.f11702n;
    }

    private static float m16960a(MotionEvent motionEvent, int i) {
        int a = MotionEventCompat.a(motionEvent, i);
        if (a < 0) {
            return -1.0f;
        }
        return MotionEventCompat.d(motionEvent, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    private static boolean m16973a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -845530469);
        int a2 = MotionEventCompat.a(motionEvent);
        if (this.f11705q && a2 == 0) {
            this.f11705q = false;
        }
        if (!isEnabled() || this.f11705q || m16990g()) {
            Logger.a(2, EntryType.UI_INPUT_END, 201685945, a);
            return false;
        }
        float d;
        switch (a2) {
            case 0:
                this.f11703o = MotionEventCompat.b(motionEvent, 0);
                this.f11702n = false;
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 3:
                if (this.f11703o == -1) {
                    if (a2 == 1) {
                        Log.e(f11678c, "Got ACTION_UP event but don't have an active pointer id.");
                    }
                    LogUtils.a(581768684, a);
                    return false;
                }
                d = (MotionEventCompat.d(motionEvent, MotionEventCompat.a(motionEvent, this.f11703o)) - this.f11700l) * 0.5f;
                this.f11702n = false;
                if (d > this.f11696h) {
                    m16971a(true, true);
                } else {
                    this.f11694f = false;
                    this.f11710w.m16999a(0.0f, 0.0f);
                    AnimationListener animationListener = null;
                    if (!this.f11704p) {
                        animationListener = new 5(this);
                    }
                    m16977b(this.f11698j, animationListener);
                    this.f11710w.m17001a(false);
                }
                this.f11703o = -1;
                LogUtils.a(-2111058376, a);
                return false;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a2 = MotionEventCompat.a(motionEvent, this.f11703o);
                if (a2 >= 0) {
                    float d2 = 0.5f * (MotionEventCompat.d(motionEvent, a2) - this.f11700l);
                    if (this.f11702n) {
                        this.f11710w.m17001a(true);
                        d = d2 / this.f11696h;
                        if (d >= 0.0f) {
                            float min = Math.min(1.0f, Math.abs(d));
                            float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                            float abs = Math.abs(d2) - this.f11696h;
                            d = this.f11686G ? this.f11682C - ((float) this.f11691b) : this.f11682C;
                            abs = Math.max(0.0f, Math.min(abs, 2.0f * d) / d);
                            abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
                            a2 = ((int) ((d * min) + ((d * abs) * 2.0f))) + this.f11691b;
                            if (this.f11707t.getVisibility() != 0) {
                                this.f11707t.setVisibility(0);
                            }
                            if (!this.f11704p) {
                                ViewCompat.m10960e(this.f11707t, 1.0f);
                                ViewCompat.m10962f(this.f11707t, 1.0f);
                            }
                            if (d2 < this.f11696h) {
                                if (this.f11704p) {
                                    setAnimationProgress(this, d2 / this.f11696h);
                                }
                                if (this.f11710w.getAlpha() > 76 && !m16973a(this.f11713z)) {
                                    m16984d();
                                }
                                this.f11710w.m16999a(0.0f, Math.min(0.8f, 0.8f * max));
                                this.f11710w.m16998a(Math.min(1.0f, max));
                            } else if (this.f11710w.getAlpha() < 255 && !m16973a(this.f11680A)) {
                                m16986e();
                            }
                            this.f11710w.f11730h.m17016d(((-0.25f + (0.4f * max)) + (2.0f * abs)) * 0.5f);
                            m16964a(a2 - this.f11698j, true);
                            break;
                        }
                        LogUtils.a(1890104402, a);
                        return false;
                    }
                }
                Log.e(f11678c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                LogUtils.a(1939371257, a);
                return false;
                break;
            case 5:
                this.f11703o = MotionEventCompat.b(motionEvent, MotionEventCompat.b(motionEvent));
                break;
            case 6:
                m16969a(motionEvent);
                break;
        }
        LogUtils.a(1470573436, a);
        return true;
    }

    private void m16963a(int i, AnimationListener animationListener) {
        this.f11690a = i;
        this.f11688I.reset();
        this.f11688I.setDuration(200);
        this.f11688I.setInterpolator(this.f11706r);
        if (animationListener != null) {
            this.f11707t.f11717a = animationListener;
        }
        this.f11707t.clearAnimation();
        this.f11707t.startAnimation(this.f11688I);
    }

    private void m16977b(int i, AnimationListener animationListener) {
        if (this.f11704p) {
            m16980c(i, animationListener);
            return;
        }
        this.f11690a = i;
        this.f11689J.reset();
        this.f11689J.setDuration(200);
        this.f11689J.setInterpolator(this.f11706r);
        if (animationListener != null) {
            this.f11707t.f11717a = animationListener;
        }
        this.f11707t.clearAnimation();
        this.f11707t.startAnimation(this.f11689J);
    }

    private void m16962a(float f) {
        m16964a((this.f11690a + ((int) (((float) (this.f11691b - this.f11690a)) * f))) - this.f11707t.getTop(), false);
    }

    private void m16980c(int i, AnimationListener animationListener) {
        this.f11690a = i;
        if (m16981c()) {
            this.f11709v = (float) this.f11710w.getAlpha();
        } else {
            this.f11709v = ViewCompat.m10977v(this.f11707t);
        }
        this.f11681B = new 8(this);
        this.f11681B.setDuration(150);
        if (animationListener != null) {
            this.f11707t.f11717a = animationListener;
        }
        this.f11707t.clearAnimation();
        this.f11707t.startAnimation(this.f11681B);
    }

    private void m16964a(int i, boolean z) {
        this.f11707t.bringToFront();
        this.f11707t.offsetTopAndBottom(i);
        this.f11698j = this.f11707t.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m16969a(MotionEvent motionEvent) {
        int b = MotionEventCompat.b(motionEvent);
        if (MotionEventCompat.b(motionEvent, b) == this.f11703o) {
            this.f11703o = MotionEventCompat.b(motionEvent, b == 0 ? 1 : 0);
        }
    }
}

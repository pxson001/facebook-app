package com.facebook.fbui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.fbui.popover.PopoverViewFlipper.NubShown;
import com.facebook.fbui.popover.PopoverViewFlipper.TransitionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;

/* compiled from: out_of_sync */
public class PopoverWindow {
    private static final Rect f5781a = new Rect();
    public int f5782A;
    public int f5783B;
    public int f5784C;
    public int f5785D;
    private boolean f5786E;
    public float f5787F;
    private Position f5788G;
    public OnDismissListener f5789H;
    public OnCancelListener f5790I;
    private final Runnable f5791J;
    private OnGlobalLayoutListener f5792K;
    public boolean f5793b;
    public int f5794c;
    protected boolean f5795d;
    public boolean f5796e;
    public PopoverViewFlipper f5797f;
    public Container f5798g;
    protected int f5799h;
    protected int f5800i;
    protected int f5801j;
    protected int f5802k;
    private Context f5803l;
    private WindowManager f5804m;
    private WeakReference<View> f5805n;
    public boolean f5806o;
    private int f5807p;
    private int f5808q;
    public boolean f5809r;
    public int f5810s;
    private boolean f5811t;
    private boolean f5812u;
    private boolean f5813v;
    public boolean f5814w;
    public boolean f5815x;
    public int f5816y;
    public int f5817z;

    /* compiled from: out_of_sync */
    public enum Position {
        ABOVE,
        BELOW,
        CENTER
    }

    /* compiled from: out_of_sync */
    class C02511 implements Runnable {
        final /* synthetic */ PopoverWindow f5818a;

        C02511(PopoverWindow popoverWindow) {
            this.f5818a = popoverWindow;
        }

        public void run() {
            View h = this.f5818a.m6299h();
            if (h != null) {
                PopoverWindow.m6267b(this.f5818a, h, this.f5818a.f5806o);
            }
        }
    }

    /* compiled from: out_of_sync */
    public class Container extends FrameLayout {
        final /* synthetic */ PopoverWindow f5819a;
        private boolean f5820b = false;

        public Container(PopoverWindow popoverWindow, Context context, AttributeSet attributeSet) {
            this.f5819a = popoverWindow;
            super(context, attributeSet);
        }

        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.f5820b = true;
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f5820b) {
                PopoverWindow.m6274x(this.f5819a);
                this.f5820b = false;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            if (dispatchKeyEvent || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || !this.f5819a.f5814w) {
                return dispatchKeyEvent;
            }
            PopoverWindow.m6273w(this.f5819a);
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z = true;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1484008975);
            if (this.f5819a.f5797f == null) {
                z = super.onTouchEvent(motionEvent);
                Logger.a(2, EntryType.UI_INPUT_END, 793468234, a);
                return z;
            }
            if (motionEvent.getActionMasked() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int left = this.f5819a.f5797f.getLeft();
                int top = this.f5819a.f5797f.getTop();
                boolean z2 = y < this.f5819a.f5797f.getPaddingTop() + top || y >= (top + this.f5819a.f5797f.getHeight()) - this.f5819a.f5797f.getPaddingBottom() || x < this.f5819a.f5797f.getPaddingLeft() + left || x >= (this.f5819a.f5797f.getWidth() + left) - this.f5819a.f5797f.getPaddingRight();
                if (z2 && this.f5819a.f5815x) {
                    PopoverWindow.m6273w(this.f5819a);
                    LogUtils.a(-578600842, a);
                    return true;
                }
            } else if (motionEvent.getAction() == 4 && this.f5819a.f5815x) {
                PopoverWindow.m6273w(this.f5819a);
                if (!this.f5819a.f5793b) {
                    z = super.onTouchEvent(motionEvent);
                }
                LogUtils.a(-865591420, a);
                return z;
            }
            z = super.onTouchEvent(motionEvent);
            LogUtils.a(-384228635, a);
            return z;
        }
    }

    /* compiled from: out_of_sync */
    class C02552 implements OnGlobalLayoutListener {
        final /* synthetic */ PopoverWindow f5846a;

        C02552(PopoverWindow popoverWindow) {
            this.f5846a = popoverWindow;
        }

        public void onGlobalLayout() {
            PopoverWindow.m6274x(this.f5846a);
        }
    }

    /* compiled from: out_of_sync */
    class C02563 extends SimpleSpringListener {
        final /* synthetic */ PopoverWindow f5847a;

        C02563(PopoverWindow popoverWindow) {
            this.f5847a = popoverWindow;
        }

        public final void m6337b(Spring spring) {
            PopoverWindow.m6272v(this.f5847a);
        }
    }

    public PopoverWindow(Context context) {
        this(context, 0);
    }

    public PopoverWindow(Context context, int i) {
        this.f5810s = 1000;
        this.f5814w = true;
        this.f5815x = true;
        this.f5788G = Position.BELOW;
        this.f5791J = new C02511(this);
        this.f5803l = new ContextThemeWrapper(context, m6262a(context, i));
        m6263a();
    }

    private void m6263a() {
        boolean z;
        this.f5804m = (WindowManager) this.f5803l.getSystemService("window");
        this.f5787F = 0.4f;
        this.f5806o = false;
        this.f5811t = false;
        this.f5793b = true;
        this.f5795d = false;
        this.f5812u = false;
        this.f5786E = false;
        this.f5813v = false;
        Resources resources = this.f5803l.getResources();
        this.f5807p = resources.getDimensionPixelSize(2131428372);
        this.f5808q = resources.getDimensionPixelSize(2131428373);
        m6266b();
        this.f5794c = m6275y();
        if (this.f5794c == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f5796e = z;
    }

    public final void m6290d(int i) {
        this.f5803l = new ContextThemeWrapper(this.f5803l, m6262a(this.f5803l, i));
        m6266b();
    }

    protected int m6298g() {
        return 2130904270;
    }

    private void m6266b() {
        this.f5798g = new Container(this, this.f5803l, null);
        LayoutInflater.from(this.f5803l).inflate(m6298g(), this.f5798g);
        this.f5797f = (PopoverViewFlipper) this.f5798g.findViewById(2131561852);
        this.f5816y = this.f5797f.getPaddingTop();
        this.f5817z = this.f5797f.getPaddingBottom();
        this.f5794c = m6275y();
        this.f5796e = this.f5794c == 0;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.PopoverWindow);
        this.f5796e = obtainStyledAttributes.getBoolean(0, this.f5796e);
        this.f5795d = obtainStyledAttributes.getBoolean(1, this.f5795d);
        this.f5812u = obtainStyledAttributes.getBoolean(2, this.f5812u);
        this.f5813v = obtainStyledAttributes.getBoolean(3, this.f5813v);
        this.f5816y = obtainStyledAttributes.getDimensionPixelSize(8, this.f5816y);
        this.f5817z = obtainStyledAttributes.getDimensionPixelSize(9, this.f5817z);
        this.f5782A = obtainStyledAttributes.getDimensionPixelSize(5, this.f5782A);
        this.f5783B = obtainStyledAttributes.getDimensionPixelSize(4, this.f5783B);
        this.f5784C = obtainStyledAttributes.getDimensionPixelSize(7, this.f5784C);
        this.f5785D = obtainStyledAttributes.getDimensionPixelSize(6, this.f5785D);
        obtainStyledAttributes.recycle();
    }

    private static int m6262a(Context context, int i) {
        if (i == 1) {
            return 2131624489;
        }
        if (i == 2) {
            return 2131624490;
        }
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130772479, typedValue, true);
        i = typedValue.resourceId;
        return i == 0 ? 2131624489 : i;
    }

    public Context getContext() {
        return this.f5803l;
    }

    public final View m6299h() {
        return this.f5805n == null ? null : (View) this.f5805n.get();
    }

    public final void m6287c(View view) {
        m6279a(view, 0, 0, view == null ? 0 : view.getWidth(), view == null ? 0 : view.getHeight());
    }

    public final void m6279a(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            this.f5805n = new WeakReference(view);
        } else {
            this.f5805n = null;
        }
        this.f5806o = true;
        this.f5799h = i;
        this.f5800i = i2;
        this.f5801j = i3;
        this.f5802k = i4;
    }

    public final void m6286b(float f) {
        if (this.f5787F != f) {
            this.f5787F = f;
        }
    }

    public final Position m6300i() {
        return this.f5788G;
    }

    public void mo540a(Position position) {
        if (this.f5788G != position) {
            this.f5788G = position;
        }
    }

    public final void m6283a(OnDismissListener onDismissListener) {
        this.f5789H = onDismissListener;
    }

    public final void m6282a(OnCancelListener onCancelListener) {
        this.f5790I = onCancelListener;
    }

    public final void m6288c(boolean z) {
        this.f5811t = z;
        if (this.f5809r) {
            m6274x(this);
        }
    }

    public final void m6292d(boolean z) {
        this.f5793b = z;
        if (this.f5809r) {
            m6274x(this);
        }
    }

    public final void m6295e(boolean z) {
        this.f5795d = z;
        if (this.f5809r) {
            m6274x(this);
        }
    }

    public final void m6277a(Drawable drawable) {
        this.f5797f.setBackgroundDrawable(drawable);
    }

    public void m6291d(View view) {
        this.f5797f.setContentView(view);
    }

    public void m6294e(View view) {
        this.f5797f.m6321a(view);
    }

    public final void m6281a(TransitionType transitionType) {
        this.f5797f.setTransitionType(transitionType);
    }

    public void m6293e() {
        this.f5797f.m6325d();
    }

    public void m6296f() {
        this.f5797f.m6326e();
    }

    public void mo541d() {
        if (this.f5805n != null) {
            View view = (View) this.f5805n.get();
            if (view != null) {
                m6264a(view, true);
            }
        }
    }

    public void m6297f(View view) {
        m6287c(view);
        mo541d();
    }

    public void mo538a(View view) {
        if (this.f5812u) {
            m6297f(view);
            return;
        }
        if (view != null) {
            this.f5805n = new WeakReference(view);
        } else {
            this.f5805n = null;
        }
        this.f5806o = false;
        m6264a(view, false);
    }

    private void m6264a(View view, boolean z) {
        if (m6269r()) {
            m6267b(this, view, z);
        } else {
            view.post(this.f5791J);
        }
    }

    public static void m6267b(PopoverWindow popoverWindow, View view, boolean z) {
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = popoverWindow.f5810s;
        layoutParams.flags = 262658;
        if (!popoverWindow.f5793b) {
            layoutParams.flags |= 32;
        }
        layoutParams.softInputMode = 16;
        layoutParams.format = -2;
        layoutParams.dimAmount = popoverWindow.f5787F;
        layoutParams.x = 0;
        layoutParams.y = 0;
        LayoutParams layoutParams2 = layoutParams;
        layoutParams2.token = view.getWindowToken();
        popoverWindow.mo539a(view, z, layoutParams2);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!(viewTreeObserver == null || !viewTreeObserver.isAlive() || popoverWindow.f5786E)) {
            viewTreeObserver.addOnGlobalLayoutListener(popoverWindow.m6268c());
            popoverWindow.f5786E = true;
        }
        if (!popoverWindow.f5809r) {
            if (m6269r()) {
                ((ViewGroup) view.getRootView()).addView(popoverWindow.f5798g, layoutParams2);
            } else if (layoutParams2.token == null) {
                popoverWindow.m6265a(viewTreeObserver);
                return;
            } else {
                popoverWindow.f5804m.addView(popoverWindow.f5798g, layoutParams2);
            }
            popoverWindow.f5809r = true;
        } else if (!m6269r()) {
            if (layoutParams2.token == null) {
                popoverWindow.m6265a(viewTreeObserver);
            } else {
                popoverWindow.f5804m.updateViewLayout(popoverWindow.f5798g, layoutParams2);
            }
        }
    }

    protected OnGlobalLayoutListener m6301k() {
        return new C02552(this);
    }

    private OnGlobalLayoutListener m6268c() {
        if (this.f5792K == null) {
            this.f5792K = m6301k();
        }
        return this.f5792K;
    }

    private void m6265a(ViewTreeObserver viewTreeObserver) {
        if (viewTreeObserver != null && viewTreeObserver.isAlive() && this.f5786E) {
            if (VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(m6268c());
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(m6268c());
            }
            this.f5786E = false;
        }
    }

    private static boolean m6269r() {
        return Boolean.getBoolean("popover_attach_to_activity");
    }

    private void m6270s() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5797f.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
    }

    protected void mo539a(View view, boolean z, WindowManager.LayoutParams layoutParams) {
        int i;
        int i2;
        m6270s();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = this.f5801j;
        int i4 = this.f5802k;
        int i5 = iArr[0] + this.f5799h;
        int i6 = iArr[1] + this.f5800i;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i7 = displayMetrics.widthPixels;
        int i8 = displayMetrics.heightPixels;
        this.f5798g.measure(MeasureSpec.makeMeasureSpec(i3, 0), MeasureSpec.makeMeasureSpec(Math.max(i6 + i4, i8 - i6), Integer.MIN_VALUE));
        int measuredWidth = this.f5797f.getMeasuredWidth();
        int measuredHeight = this.f5797f.getMeasuredHeight();
        int paddingLeft = this.f5797f.getPaddingLeft();
        int paddingRight = this.f5797f.getPaddingRight();
        int height = view.getRootView().getHeight();
        Object obj = (measuredWidth + paddingLeft) + paddingRight >= i7 ? 1 : null;
        layoutParams.width = obj != null ? measuredWidth : -1;
        if (this.f5793b) {
            i = -1;
        } else {
            i = measuredHeight;
        }
        layoutParams.height = i;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f5797f.getLayoutParams();
        if (z) {
            Object obj2;
            Object obj3;
            Object obj4;
            int i9;
            int i10 = i5 + (i3 / 2);
            Object obj5 = measuredHeight <= i6 ? 1 : null;
            if (this.f5795d) {
                obj5 = measuredHeight <= i6 + i4 ? 1 : null;
            }
            Object obj6 = (i6 + i4) + measuredHeight <= i8 - this.f5785D ? 1 : null;
            if (this.f5795d) {
                obj2 = i6 + measuredHeight <= i8 - this.f5785D ? 1 : null;
            } else {
                obj2 = obj6;
            }
            obj6 = (obj5 == null || this.f5788G == Position.CENTER) ? null : 1;
            obj5 = (obj2 == null || this.f5788G == Position.CENTER || !(this.f5788G == Position.BELOW || (this.f5788G == Position.ABOVE && obj5 == null))) ? null : 1;
            if (i6 < this.f5783B || i6 >= i8 - this.f5785D) {
                obj3 = null;
                obj4 = null;
            } else {
                obj3 = obj5;
                obj4 = obj6;
            }
            obj5 = (obj4 == null && obj3 == null) ? 1 : null;
            obj2 = (!this.f5811t || this.f5795d) ? null : 1;
            if (obj3 != null) {
                layoutParams.y = (i6 + i4) - (this.f5816y - (obj2 != null ? this.f5808q : 0));
                layoutParams.y -= this.f5795d ? i4 : 0;
                measuredHeight = 0;
                view.getWindowVisibleDisplayFrame(f5781a);
                if (f5781a.top > 0) {
                    measuredHeight = f5781a.top;
                }
                if (layoutParams.y < this.f5783B + measuredHeight) {
                    layoutParams.y = measuredHeight + this.f5783B;
                }
                layoutParams.windowAnimations = 2131624757;
                layoutParams2.gravity = 49;
                layoutParams.gravity = 49;
                if (obj2 != null) {
                    this.f5797f.setNubShown(NubShown.BELOW);
                }
                i4 = 0;
                i9 = i10;
            } else if (obj4 != null) {
                layoutParams.y = (height - i6) - (this.f5817z - (obj2 != null ? this.f5807p : 0));
                i9 = layoutParams.y;
                if (!this.f5795d) {
                    i4 = 0;
                }
                layoutParams.y = i9 - i4;
                if (layoutParams.y < this.f5785D) {
                    layoutParams.y = this.f5785D;
                }
                layoutParams.windowAnimations = 2131624758;
                layoutParams2.gravity = 81;
                layoutParams.gravity = 81;
                if (obj2 != null) {
                    this.f5797f.setNubShown(NubShown.ABOVE);
                    i4 = measuredHeight;
                    i9 = i10;
                } else {
                    i4 = measuredHeight;
                    i9 = i10;
                }
            } else {
                measuredHeight /= 2;
                i9 = i7 / 2;
                layoutParams.windowAnimations = 2131624756;
                layoutParams2.gravity = 17;
                layoutParams.gravity = 17;
                this.f5797f.setNubShown(NubShown.NONE);
                i4 = measuredHeight;
            }
            if (obj5 == null) {
                if (obj != null || m6271t()) {
                    layoutParams.gravity |= 1;
                    layoutParams2.gravity |= 1;
                } else {
                    layoutParams.gravity |= 3;
                    layoutParams2.gravity |= 3;
                }
            }
            if (obj5 != null || obj != null) {
                measuredHeight = i10 + paddingLeft;
                measuredWidth = (i7 - measuredWidth) / 2;
                layoutParams2.leftMargin = measuredWidth;
                layoutParams2.rightMargin = measuredWidth;
                measuredWidth = measuredHeight;
                i2 = i9;
            } else if (this.f5813v) {
                i2 = i5 + i3;
                if (i5 < this.f5782A) {
                    measuredHeight = this.f5782A;
                } else {
                    measuredHeight = i5;
                }
                if ((measuredHeight + measuredWidth) + this.f5784C > i7) {
                    measuredHeight = i7 - i2;
                    if (measuredHeight < this.f5784C) {
                        measuredHeight = this.f5784C;
                    }
                    if ((measuredHeight + measuredWidth) + this.f5782A > i7) {
                        measuredHeight = (i7 - measuredWidth) / 2;
                        measuredWidth = (measuredWidth / 2) + measuredHeight;
                    } else {
                        int i11 = (i7 - measuredWidth) - measuredHeight;
                        measuredWidth = i7 - measuredHeight;
                        measuredHeight = i11;
                    }
                } else {
                    measuredWidth = measuredHeight;
                }
                layoutParams2.leftMargin = measuredHeight;
                layoutParams2.rightMargin = 0;
                i2 = measuredWidth;
                measuredWidth = i10;
            } else {
                measuredHeight = i10 - (measuredWidth / 2);
                if (m6271t() || this.f5794c <= 0) {
                    i2 = (measuredWidth / 2) + measuredHeight;
                    if (measuredHeight < (-paddingLeft)) {
                        measuredHeight = 0;
                        i2 = 0;
                    }
                    if (measuredHeight + measuredWidth > i7 + paddingRight) {
                        measuredHeight = (i7 - measuredWidth) + paddingRight;
                        i2 = measuredHeight + measuredWidth;
                    }
                } else {
                    if (measuredHeight < paddingLeft) {
                        measuredHeight = paddingLeft;
                    } else if (measuredHeight + measuredWidth > i7 + paddingRight) {
                        measuredHeight = (i7 - measuredWidth) + paddingRight;
                    }
                    i2 = (measuredWidth / 2) + measuredHeight;
                }
                i9 = (i7 - measuredWidth) - measuredHeight;
                measuredWidth = i10 - measuredHeight;
                layoutParams2.leftMargin = measuredHeight;
                layoutParams2.rightMargin = i9;
            }
            this.f5797f.setLayoutParams(layoutParams2);
            this.f5797f.setNubOffset(measuredWidth);
            i = i4;
        } else {
            layoutParams.windowAnimations = 2131624756;
            layoutParams2.gravity = 17;
            layoutParams.gravity = 17;
            i2 = i7 / 2;
            i = measuredHeight / 2;
            this.f5797f.setNubShown(NubShown.NONE);
        }
        if (this.f5797f.m6323b()) {
            layoutParams.windowAnimations = 0;
        }
        this.f5797f.m6320a(i2, i);
    }

    private boolean m6271t() {
        int y = m6275y();
        if (!this.f5796e || y <= 0 || y >= this.f5803l.getResources().getDisplayMetrics().widthPixels) {
            return this.f5796e;
        }
        return false;
    }

    public static void m6272v(PopoverWindow popoverWindow) {
        if (popoverWindow.m6303m()) {
            if (m6269r()) {
                ((ViewGroup) popoverWindow.f5798g.getParent()).removeView(popoverWindow.f5798g);
            } else {
                try {
                    popoverWindow.f5804m.removeViewImmediate(popoverWindow.f5798g);
                } catch (Exception e) {
                }
            }
            popoverWindow.f5809r = false;
            View h = popoverWindow.m6299h();
            ViewTreeObserver viewTreeObserver = null;
            if (h != null) {
                h.removeCallbacks(popoverWindow.f5791J);
                viewTreeObserver = h.getViewTreeObserver();
            }
            popoverWindow.m6265a(viewTreeObserver);
            if (popoverWindow.f5789H != null) {
                popoverWindow.f5789H.a(popoverWindow);
            }
        }
    }

    public static void m6273w(PopoverWindow popoverWindow) {
        if (popoverWindow.f5809r) {
            if (popoverWindow.f5790I != null) {
                popoverWindow.f5790I.a();
            }
            popoverWindow.mo542l();
        }
    }

    public static void m6274x(PopoverWindow popoverWindow) {
        if (popoverWindow.f5809r) {
            View view = popoverWindow.f5805n == null ? null : (View) popoverWindow.f5805n.get();
            if (view != null) {
                popoverWindow.m6264a(view, popoverWindow.f5806o);
            }
        }
    }

    public void mo542l() {
        if (this.f5809r) {
            this.f5797f.m6322a(new C02563(this));
        }
    }

    public final boolean m6303m() {
        return this.f5809r;
    }

    private int m6275y() {
        return (int) this.f5803l.getResources().getDimension(2131428389);
    }

    public final int m6304n() {
        return this.f5782A;
    }

    public final int m6305o() {
        return this.f5784C;
    }

    public final int m6306p() {
        return this.f5783B;
    }

    public final int m6307q() {
        return this.f5785D;
    }

    public final void m6276a(int i, int i2, int i3, int i4) {
        this.f5782A = i;
        this.f5783B = i2;
        this.f5784C = i3;
        this.f5785D = i4;
    }

    public final void m6285a(Spring spring) {
        this.f5797f.f5827g = spring;
    }
}

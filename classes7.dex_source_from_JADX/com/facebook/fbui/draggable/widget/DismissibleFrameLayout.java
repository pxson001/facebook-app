package com.facebook.fbui.draggable.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.R;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragDecider;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Axis;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.inject.Inject;

/* compiled from: sprout_button_name */
public class DismissibleFrameLayout extends SmoothScrollFrameLayout implements DragDecider, DragListener {
    private static final Class<?> f3544a = DismissibleFrameLayout.class;
    private AdvancedDragDetector f3545b = null;
    private Handler f3546c = null;
    private Direction f3547d = null;
    public OnDismissListener f3548e = null;
    public OnResetListener f3549f = null;
    public AnimationListener f3550g = null;
    public FlingListener f3551h = null;
    private final Runnable f3552i = new C03081(this);
    private ViewState f3553j = ViewState.AT_REST;
    private StateChangeFuture f3554k = null;
    public boolean f3555l = true;

    /* compiled from: sprout_button_name */
    class C03081 implements Runnable {
        final /* synthetic */ DismissibleFrameLayout f3537a;

        C03081(DismissibleFrameLayout dismissibleFrameLayout) {
            this.f3537a = dismissibleFrameLayout;
        }

        public void run() {
            DismissibleFrameLayout.m4250j(this.f3537a);
        }
    }

    /* compiled from: sprout_button_name */
    /* synthetic */ class C03092 {
        static final /* synthetic */ int[] f3538a = new int[Direction.values().length];

        static {
            try {
                f3538a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3538a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3538a[Direction.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3538a[Direction.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: sprout_button_name */
    public interface AnimationListener {
        void mo550a(float f, float f2);
    }

    /* compiled from: sprout_button_name */
    public interface FlingListener {
        void mo549a();
    }

    /* compiled from: sprout_button_name */
    public interface OnDismissListener {
        void mo551b();

        void mo552c();
    }

    /* compiled from: sprout_button_name */
    public interface OnResetListener {
        void mo553d();
    }

    /* compiled from: sprout_button_name */
    public class StateChangeFuture {
        public ViewState f3539a;
        public SettableFuture<Void> f3540b = SettableFuture.f();

        public StateChangeFuture(ViewState viewState) {
            this.f3539a = viewState;
        }

        public final ViewState m4228a() {
            return this.f3539a;
        }

        public final SettableFuture<Void> m4229b() {
            return this.f3540b;
        }

        public final void m4230c() {
            FutureDetour.a(this.f3540b, null, 1044601444);
        }

        public final void m4231d() {
            this.f3540b.cancel(false);
        }
    }

    /* compiled from: sprout_button_name */
    public enum ViewState {
        AT_REST,
        ANIMATING,
        DISMISSED
    }

    private static <T extends View> void m4243a(Class<T> cls, T t) {
        m4244a((Object) t, t.getContext());
    }

    private static void m4244a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DismissibleFrameLayout) obj).m4240a(Handler_ForUiThreadMethodAutoProvider.b(fbInjector), AdvancedDragDetector.b(fbInjector));
    }

    public DismissibleFrameLayout(Context context) {
        super(context);
        m4239a(context, null, 0);
    }

    public DismissibleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4239a(context, attributeSet, 0);
    }

    public DismissibleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4239a(context, attributeSet, i);
    }

    private void m4239a(Context context, AttributeSet attributeSet, int i) {
        m4243a(DismissibleFrameLayout.class, (View) this);
        this.f3545b.q = this;
        this.f3545b.r = this;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DismissibleFrameLayout, i, 0);
            int i2 = obtainStyledAttributes.getInt(0, Direction.RIGHT.flag());
            int i3 = obtainStyledAttributes.getInt(1, Axis.HORIZONTAL.ordinal());
            this.f3545b.h = Axis.values()[i3];
            obtainStyledAttributes.recycle();
            setDirectionFlags(i2);
        }
    }

    @Inject
    private void m4240a(Handler handler, AdvancedDragDetector advancedDragDetector) {
        this.f3546c = handler;
        this.f3545b = advancedDragDetector;
    }

    public void setDirectionFlags(int i) {
        this.f3545b.p = i;
    }

    public void setDirections(Direction... directionArr) {
        this.f3545b.a(directionArr);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f3548e = onDismissListener;
    }

    public void setOnResetListener(OnResetListener onResetListener) {
        this.f3549f = onResetListener;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.f3550g = animationListener;
    }

    public void setFlingListener(FlingListener flingListener) {
        this.f3551h = flingListener;
    }

    public final ListenableFuture<Void> m4254a(Direction direction, boolean z) {
        ListenableFuture<Void> a = m4238a(ViewState.DISMISSED);
        if (a != null) {
            return a;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (scrollX != 0) {
            if (scrollX >= 0) {
                scrollY = getWidth();
                scrollX = 0;
            }
            scrollY = -getWidth();
            scrollX = 0;
        } else if (scrollY == 0) {
            m4252l();
            switch (C03092.f3538a[direction.ordinal()]) {
                case 1:
                    scrollX = getHeight();
                    scrollY = 0;
                    break;
                case 2:
                    scrollX = -getHeight();
                    scrollY = 0;
                    break;
                case 3:
                    scrollY = getWidth();
                    scrollX = 0;
                    break;
                case 4:
                    break;
                default:
                    scrollX = 0;
                    scrollY = 0;
                    break;
            }
            scrollY = -getWidth();
            scrollX = 0;
        } else if (scrollY < 0) {
            scrollX = -getHeight();
            scrollY = 0;
        } else {
            scrollX = getHeight();
            scrollY = 0;
        }
        StateChangeFuture stateChangeFuture = new StateChangeFuture(ViewState.DISMISSED);
        this.f3554k = stateChangeFuture;
        if (z) {
            m4234a(scrollY, scrollX);
        } else {
            mo167a(scrollY, scrollX, false);
        }
        return stateChangeFuture.f3540b;
    }

    public final ListenableFuture<Void> m4255a(boolean z) {
        ListenableFuture<Void> a = m4238a(ViewState.AT_REST);
        if (a != null) {
            return a;
        }
        StateChangeFuture stateChangeFuture = new StateChangeFuture(ViewState.AT_REST);
        this.f3554k = stateChangeFuture;
        if (z) {
            m4234a(0, 0);
        } else {
            mo167a(0, 0, false);
        }
        return stateChangeFuture.f3540b;
    }

    public ViewState getCurrentState() {
        return this.f3553j;
    }

    public void setDraggingEnabled(boolean z) {
        this.f3555l = z;
    }

    public final void m4264e() {
        m4237g();
        HandlerDetour.a(this.f3546c, this.f3552i);
    }

    private boolean m4245a(View view, boolean z, int i, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom()) {
                    if (m4245a(childAt, true, i, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z) {
            return false;
        }
        if (i != 0) {
            return ViewCompat.a(view, i);
        }
        if (i2 != 0) {
            return ViewCompat.b(view, i2);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f3555l && motionEvent.getPointerCount() <= 1) {
            return this.f3545b.a(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1406823630);
        if (!this.f3555l) {
            Logger.a(2, EntryType.UI_INPUT_END, -1113664877, a);
            return false;
        } else if (motionEvent.getPointerCount() > 1) {
            LogUtils.a(600903144, a);
            return false;
        } else {
            boolean b = this.f3545b.b(motionEvent);
            LogUtils.a(1265140505, a);
            return b;
        }
    }

    public final boolean m4259a(float f, float f2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (scrollX < 0) {
            if (((float) Math.abs(scrollX)) <= f) {
                return true;
            }
            return false;
        } else if (scrollX > 0) {
            if (f > ((float) (getWidth() - scrollX))) {
                return false;
            }
            return true;
        } else if (scrollY < 0) {
            if (((float) Math.abs(scrollY)) > f2) {
                return false;
            }
            return true;
        } else if (scrollY <= 0 || f2 <= ((float) (getHeight() - scrollY))) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean m4263b(float f, float f2) {
        return m4236f();
    }

    public final boolean m4260a(float f, float f2, Direction direction) {
        int i = direction.isXAxis() ? direction == Direction.LEFT ? -1 : 1 : 0;
        int i2 = direction.isYAxis() ? direction == Direction.UP ? -1 : 1 : 0;
        if (m4245a(this, false, i, i2, (int) f, (int) f2)) {
            return false;
        }
        this.f3547d = direction;
        m4237g();
        m4252l();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4262b(float r5, float r6, com.facebook.fbui.draggable.Direction r7) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r7.isXAxis();
        if (r0 == 0) goto L_0x002a;
    L_0x0007:
        r0 = r4.getScrollX();
        r2 = (int) r5;
        r0 = r0 - r2;
        r2 = com.facebook.fbui.draggable.widget.DismissibleFrameLayout.C03092.f3538a;
        r3 = r4.f3547d;
        r3 = r3.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 3: goto L_0x0020;
            case 4: goto L_0x0025;
            default: goto L_0x001a;
        };
    L_0x001a:
        r2 = r0;
        r0 = r1;
    L_0x001c:
        r4.mo167a(r2, r0, r1);
        return;
    L_0x0020:
        if (r0 >= 0) goto L_0x0049;
    L_0x0022:
        r0 = r1;
        r2 = r1;
        goto L_0x001c;
    L_0x0025:
        if (r0 <= 0) goto L_0x0049;
    L_0x0027:
        r0 = r1;
        r2 = r1;
        goto L_0x001c;
    L_0x002a:
        r0 = r4.getScrollY();
        r2 = (int) r6;
        r0 = r0 - r2;
        r2 = com.facebook.fbui.draggable.widget.DismissibleFrameLayout.C03092.f3538a;
        r3 = r4.f3547d;
        r3 = r3.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x003f;
            case 2: goto L_0x0044;
            default: goto L_0x003d;
        };
    L_0x003d:
        r2 = r1;
        goto L_0x001c;
    L_0x003f:
        if (r0 >= 0) goto L_0x003d;
    L_0x0041:
        r0 = r1;
        r2 = r1;
        goto L_0x001c;
    L_0x0044:
        if (r0 <= 0) goto L_0x003d;
    L_0x0046:
        r0 = r1;
        r2 = r1;
        goto L_0x001c;
    L_0x0049:
        r2 = r0;
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.draggable.widget.DismissibleFrameLayout.b(float, float, com.facebook.fbui.draggable.Direction):void");
    }

    public final void mo166a() {
        m4248h();
    }

    public final void m4258a(Direction direction, int i) {
        if (direction.isSetInFlags(this.f3545b.p)) {
            m4241a(direction);
        } else {
            m4234a(0, 0);
        }
    }

    public final void m4261b() {
        this.f3553j = ViewState.AT_REST;
        m4251k();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 337005603);
        HandlerDetour.a(this.f3546c, this.f3552i);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1909322779, a);
    }

    private ListenableFuture<Void> m4238a(ViewState viewState) {
        if (this.f3553j == viewState) {
            return Futures.a(null);
        }
        if (this.f3554k != null) {
            if (this.f3554k.f3539a == viewState) {
                return this.f3554k.f3540b;
            }
            this.f3554k.m4231d();
            this.f3554k = null;
        }
        m4237g();
        if (!this.f3545b.b()) {
            return null;
        }
        this.f3545b.c();
        return null;
    }

    private void m4241a(Direction direction) {
        int height;
        int i = 0;
        int i2;
        switch (C03092.f3538a[direction.ordinal()]) {
            case 1:
                if (getScrollY() > 0) {
                    height = getHeight();
                } else {
                    height = 0;
                }
                i2 = height;
                height = 0;
                i = i2;
                break;
            case 2:
                if (getScrollY() < 0) {
                    height = -getHeight();
                } else {
                    height = 0;
                }
                i2 = height;
                height = 0;
                i = i2;
                break;
            case 3:
                if (getScrollX() <= 0) {
                    height = 0;
                    break;
                } else {
                    height = getWidth();
                    break;
                }
            case 4:
                if (getScrollX() >= 0) {
                    height = 0;
                    break;
                } else {
                    height = -getWidth();
                    break;
                }
            default:
                height = 0;
                break;
        }
        m4234a(height, i);
        if (this.f3551h == null) {
            return;
        }
        if (height != 0 || i != 0) {
            this.f3551h.mo549a();
        }
    }

    private void m4248h() {
        int width;
        int i = 0;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (scrollX != 0) {
            width = getWidth();
            if (Math.abs(scrollX) > width / 2) {
                if (scrollX < 0) {
                    width = -width;
                }
            }
            width = 0;
        } else {
            if (scrollY != 0) {
                width = getHeight();
                if (Math.abs(scrollY) > width / 2) {
                    if (scrollY < 0) {
                        width = -width;
                    }
                    int i2 = width;
                    width = 0;
                    i = i2;
                }
            }
            width = 0;
        }
        m4234a(width, i);
    }

    protected final void mo167a(int i, int i2, boolean z) {
        super.mo167a(i, i2, z);
        m4247b(z);
    }

    private void m4247b(boolean z) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            ViewState viewState = this.f3553j;
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (!(this.f3545b.b() || m4236f())) {
                if (Math.abs(scrollX) >= width || Math.abs(scrollY) >= height) {
                    if (viewState != ViewState.DISMISSED) {
                        m4246b(ViewState.DISMISSED);
                        m4253m();
                        return;
                    }
                    return;
                } else if (scrollX == 0 && scrollY == 0) {
                    if (viewState != ViewState.AT_REST) {
                        m4246b(ViewState.AT_REST);
                        m4251k();
                        return;
                    }
                    return;
                }
            }
            this.f3553j = ViewState.ANIMATING;
            if (z) {
                m4249i();
            } else {
                m4250j(this);
            }
        }
    }

    private void m4246b(ViewState viewState) {
        StateChangeFuture stateChangeFuture = this.f3554k;
        this.f3554k = null;
        if (stateChangeFuture != null) {
            if (stateChangeFuture.f3539a == viewState) {
                stateChangeFuture.m4230c();
            } else {
                stateChangeFuture.m4231d();
            }
        }
        this.f3553j = viewState;
    }

    private void m4249i() {
        HandlerDetour.a(this.f3546c, this.f3552i, -1392982878);
    }

    public static void m4250j(DismissibleFrameLayout dismissibleFrameLayout) {
        if (dismissibleFrameLayout.f3550g != null) {
            int width = dismissibleFrameLayout.getWidth();
            int height = dismissibleFrameLayout.getHeight();
            if (height != 0 && width != 0) {
                dismissibleFrameLayout.f3550g.mo550a(((float) dismissibleFrameLayout.getScrollX()) / ((float) width), ((float) dismissibleFrameLayout.getScrollY()) / ((float) height));
            }
        }
    }

    private void m4251k() {
        if (this.f3549f != null) {
            this.f3549f.mo553d();
        }
    }

    private void m4252l() {
        if (this.f3548e != null) {
            this.f3548e.mo551b();
        }
    }

    private void m4253m() {
        if (this.f3548e != null) {
            this.f3548e.mo552c();
            return;
        }
        Context context = getContext();
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).finish();
        }
    }
}

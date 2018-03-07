package com.facebook.widget.popover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.NavigationLogger;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragDecider;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.maps.internal.IOnCameraChangeListener */
public class PopoverView extends CustomRelativeLayout implements DragDecider, DragListener {
    private static final SpringConfig f19795a = SpringConfig.b(5.0d, 6.0d);
    public Direction f19796A = Direction.UP;
    public Direction f19797B = Direction.DOWN;
    public double f19798C = 0.5d;
    public double f19799D = 0.25d;
    public AdvancedDragDetector f19800b;
    public AnimationUtil f19801c;
    public PopoverAnimationState f19802d;
    public ScreenUtil f19803e;
    public Spring f19804f;
    public Spring f19805g;
    private AnimationSpringListener f19806h;
    private DragSpringListener f19807i;
    public BasePopoverDelegate f19808j;
    @Nullable
    public SpringListener f19809k;
    public Drawable f19810l;
    private Lazy<NavigationLogger> f19811m;
    public ViewGroup f19812n;
    public Optional<ViewGroup> f19813o;
    public ViewGroup f19814p;
    private float f19815q;
    private float f19816r;
    public Direction f19817s;
    public Direction f19818t;
    public State f19819u;
    public boolean f19820v = true;
    public boolean f19821w = true;
    public boolean f19822x = true;
    public int f19823y = (Direction.DOWN.flag() | Direction.UP.flag());
    public int f19824z = this.f19823y;

    /* compiled from: com.google.android.gms.maps.internal.IOnCameraChangeListener */
    class AnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ PopoverView f19793a;

        public AnimationSpringListener(PopoverView popoverView) {
            this.f19793a = popoverView;
        }

        public final void m28519a(Spring spring) {
            double d = spring.d();
            Direction direction = this.f19793a.f19796A;
            if (!(this.f19793a.f19819u == State.NEEDS_REVEAL || this.f19793a.f19819u == State.DISMISSING || this.f19793a.f19818t == null)) {
                direction = this.f19793a.f19818t;
            }
            PopoverView popoverView = this.f19793a;
            PopoverView.m28522a(this.f19793a.f19814p, direction, (int) d);
            if (this.f19793a.f19822x) {
                this.f19793a.f19810l.setAlpha(Math.max((int) (178.0d - ((Math.abs(d) / ((double) (this.f19793a.f19796A.isYAxis() ? this.f19793a.getHeight() : this.f19793a.getWidth()))) * 178.0d)), 0));
            }
            if (this.f19793a.f19809k != null) {
                this.f19793a.f19809k.a(spring);
            }
        }

        public final void m28520b(Spring spring) {
            this.f19793a.f19801c.b(this.f19793a.f19814p);
            switch (this.f19793a.f19819u) {
                case DISMISSING:
                    if (this.f19793a.f19808j != null) {
                        this.f19793a.f19808j.mo1356d();
                        break;
                    }
                    break;
                case REVEALING:
                    if (this.f19793a.f19808j != null) {
                        this.f19793a.f19808j.mo1359b();
                        PopoverView popoverView = this.f19793a;
                        Spring spring2 = popoverView.f19804f;
                        spring2.l = 0.001d;
                        spring2.k = 0.001d;
                        spring2 = popoverView.f19805g;
                        spring2.l = 0.001d;
                        spring2.k = 0.001d;
                        break;
                    }
                    break;
            }
            this.f19793a.f19802d.c();
            this.f19793a.f19819u = State.AT_REST;
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnCameraChangeListener */
    class DragSpringListener extends SimpleSpringListener {
        final /* synthetic */ PopoverView f19794a;

        public DragSpringListener(PopoverView popoverView) {
            this.f19794a = popoverView;
        }

        public final void m28521a(Spring spring) {
            double d = spring.d();
            if (d < 0.0d) {
                if (this.f19794a.f19819u != State.BEING_DRAGGED) {
                    this.f19794a.f19818t = this.f19794a.f19817s;
                    this.f19794a.f19804f.c(spring.e.b).b(spring.i);
                }
                spring.a(0.0d).b(0.0d).l();
                return;
            }
            PopoverView popoverView = this.f19794a;
            PopoverView.m28522a(this.f19794a.f19812n, this.f19794a.f19817s, (int) d);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnCameraChangeListener */
    public enum State {
        AT_REST,
        ANIMATING,
        BEING_DRAGGED,
        DISMISSING,
        NEEDS_REVEAL,
        REVEALING
    }

    public static void m28525a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PopoverView) obj).m28523a(AdvancedDragDetector.b(fbInjector), AnimationUtil.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137), PopoverAnimationState.a(fbInjector), SpringSystem.b(fbInjector), ScreenUtil.a(fbInjector));
    }

    public PopoverView(Context context, int i) {
        super(context);
        Class cls = PopoverView.class;
        m28525a((Object) this, getContext());
        setContentView(i);
        this.f19812n = (ViewGroup) a(2131560065);
        this.f19813o = b(2131562860);
        this.f19814p = (ViewGroup) a(2131562859);
        this.f19819u = State.AT_REST;
        this.f19800b.q = this;
        this.f19800b.r = this;
        this.f19800b.p = this.f19823y;
        this.f19810l = new ColorDrawable(getResources().getColor(2131363188));
        this.f19810l.setAlpha(0);
        setBackgroundDrawable(this.f19810l);
    }

    @Inject
    private void m28523a(AdvancedDragDetector advancedDragDetector, AnimationUtil animationUtil, Lazy<NavigationLogger> lazy, PopoverAnimationState popoverAnimationState, SpringSystem springSystem, ScreenUtil screenUtil) {
        this.f19801c = animationUtil;
        this.f19800b = advancedDragDetector;
        this.f19811m = lazy;
        this.f19802d = popoverAnimationState;
        Spring a = springSystem.a().a(f19795a);
        a.l = 10.0d;
        a = a;
        a.k = 10.0d;
        this.f19804f = a;
        this.f19806h = new AnimationSpringListener(this);
        a = springSystem.a().a(f19795a);
        a.l = 10.0d;
        a = a;
        a.k = 10.0d;
        this.f19805g = a;
        this.f19807i = new DragSpringListener(this);
        this.f19803e = screenUtil;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1321486439);
        super.onDetachedFromWindow();
        this.f19804f.b(this.f19806h);
        this.f19805g.b(this.f19807i);
        this.f19802d.c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1050605984, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1616339618);
        super.onAttachedToWindow();
        this.f19804f.a(this.f19806h);
        this.f19805g.a(this.f19807i);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -529265671, a);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f19800b.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 284468584);
        if (this.f19819u == State.DISMISSING || this.f19819u == State.ANIMATING || this.f19819u == State.NEEDS_REVEAL) {
            Logger.a(2, EntryType.UI_INPUT_END, -73659545, a);
            return true;
        }
        boolean b = this.f19800b.b(motionEvent);
        LogUtils.a(1642424203, a);
        return b;
    }

    public final boolean m28534a(float f, float f2) {
        return true;
    }

    public final boolean m28538b(float f, float f2) {
        return false;
    }

    public final boolean m28535a(float f, float f2, Direction direction) {
        if (this.f19819u == State.REVEALING) {
            return false;
        }
        this.f19815q = 0.0f;
        this.f19816r = 0.0f;
        this.f19817s = direction;
        this.f19818t = direction;
        this.f19819u = State.BEING_DRAGGED;
        if (PopoverUtil.m28516a(this.f19812n, f, f2) || this.f19808j.mo1358a(f, f2, direction)) {
            return true;
        }
        return false;
    }

    public final void m28537b(float f, float f2, Direction direction) {
        boolean z;
        float c = m28527c(f, f2, direction);
        if (!direction.isSetInFlags(this.f19824z)) {
            z = false;
        } else if (direction.isYAxis()) {
            z = PopoverUtil.m28517b((int) (((double) this.f19814p.getHeight()) * this.f19798C), c, direction);
        } else {
            z = PopoverUtil.m28518c((int) (((double) this.f19814p.getWidth()) * this.f19798C), c, direction);
        }
        if (z) {
            ((NavigationLogger) this.f19811m.get()).a("swipe");
            this.f19800b.c();
            m28524a(direction, 0.0d);
        } else if (c > 0.0f) {
            this.f19805g.b((double) c).a((double) c).l();
            this.f19804f.b(0.0d).a(0.0d).l();
        } else {
            this.f19804f.b((double) c).a((double) c).l();
            this.f19805g.b(0.0d).a(0.0d).l();
        }
    }

    public final void m28532a() {
        m28526b(this.f19817s, 0);
    }

    public final void m28533a(Direction direction, int i) {
        m28526b(direction, i);
    }

    public final void m28536b() {
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f19819u == State.NEEDS_REVEAL) {
            m28530f();
            if (!this.f19820v) {
                this.f19819u = State.AT_REST;
                this.f19802d.c();
            }
        }
    }

    private void m28529e() {
        m28528c(0.0d);
    }

    private void m28528c(double d) {
        if (this.f19819u != State.ANIMATING && this.f19819u != State.DISMISSING) {
            if (this.f19804f.d() != 0.0d) {
                this.f19804f.b(0.0d).c(d);
                this.f19819u = State.ANIMATING;
            }
            if (this.f19805g.d() != 0.0d) {
                this.f19805g.b(0.0d).c(d);
                this.f19819u = State.ANIMATING;
            }
        }
    }

    public final void m28539c() {
        if (!this.f19820v || this.f19797B == null) {
            this.f19808j.mo1356d();
        } else {
            m28524a(this.f19797B, 0.0d);
        }
    }

    private void m28524a(Direction direction, double d) {
        if (this.f19819u != State.DISMISSING) {
            this.f19818t = null;
            this.f19801c.a(this.f19814p);
            this.f19808j.mo1369c();
            double d2 = direction.isYAxis() ? (double) this.f19803e.d() : (double) this.f19803e.c();
            if (direction == Direction.UP || direction == Direction.LEFT) {
                d2 = -d2;
            }
            this.f19804f.b(d2).c(d).c = true;
            this.f19819u = State.DISMISSING;
        }
    }

    public final PopoverView m28531a(SpringConfig springConfig) {
        this.f19804f.a(springConfig);
        return this;
    }

    public final void m28540d() {
        this.f19819u = State.NEEDS_REVEAL;
        if (this.f19820v) {
            int d = this.f19796A.isYAxis() ? this.f19803e.d() : this.f19803e.c();
            this.f19804f.b((double) d).a((double) d).l();
            this.f19805g.b(0.0d).a(0.0d).l();
            m28522a(this.f19814p, this.f19796A, d);
            requestLayout();
        }
    }

    private PopoverView m28530f() {
        this.f19801c.a(this.f19814p);
        m28529e();
        this.f19808j.mo1357a();
        this.f19819u = State.REVEALING;
        return this;
    }

    private void m28526b(Direction direction, int i) {
        boolean z;
        float f = this.f19816r;
        if (!direction.isSetInFlags(this.f19824z)) {
            z = false;
        } else if (direction.isYAxis()) {
            z = PopoverUtil.m28517b((int) (((double) this.f19814p.getHeight()) * this.f19799D), f, direction);
        } else {
            z = PopoverUtil.m28518c((int) (((double) this.f19814p.getWidth()) * this.f19799D), f, direction);
        }
        if (z) {
            ((NavigationLogger) this.f19811m.get()).a("swipe");
            m28524a(direction, (double) i);
            return;
        }
        m28528c((double) i);
    }

    private float m28527c(float f, float f2, Direction direction) {
        float f3;
        float f4;
        if (direction.isYAxis()) {
            f3 = this.f19816r;
        } else {
            f3 = this.f19815q;
            f2 = f;
        }
        if (!direction.isSetInFlags(this.f19824z)) {
            int height = direction.isYAxis() ? this.f19814p.getHeight() : this.f19814p.getWidth();
            float f5 = f3 + f2;
            if (PopoverUtil.m28515a(height / 16, f5, direction)) {
                f4 = 0.1f;
            } else if (PopoverUtil.m28515a(height / 32, f5, direction)) {
                f4 = 0.25f;
            }
            f3 += f4 * f2;
            if (direction.isYAxis()) {
                this.f19815q = f3;
            } else {
                this.f19816r = f3;
            }
            return f3;
        }
        f4 = 1.0f;
        f3 += f4 * f2;
        if (direction.isYAxis()) {
            this.f19815q = f3;
        } else {
            this.f19816r = f3;
        }
        return f3;
    }

    public static void m28522a(View view, Direction direction, int i) {
        if (direction.isYAxis()) {
            view.setTranslationY((float) i);
        } else {
            view.setTranslationX((float) i);
        }
    }
}

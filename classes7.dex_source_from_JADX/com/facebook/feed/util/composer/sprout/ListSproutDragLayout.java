package com.facebook.feed.util.composer.sprout;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uicontrib.circularreveal.CircularRevealFrameLayout;
import javax.inject.Inject;

/* compiled from: TV;>;>; */
public class ListSproutDragLayout extends CircularRevealFrameLayout implements DragListener {
    @Inject
    AdvancedDragDetector f22408a;
    @Inject
    SpringSystem f22409b;
    private Spring f22410c;
    private Spring f22411d;
    public State f22412e = State.BEFORE_REVEAL;
    private int f22413f;
    private float f22414g;
    private float f22415h;
    public float f22416i = 0.0f;
    public int f22417j = -1;
    private Delegate f22418k;
    public final ArgbEvaluator f22419l = new ArgbEvaluator();
    public final PaintDrawable f22420m = new PaintDrawable(-1);

    /* compiled from: TV;>;>; */
    public interface Delegate {
        boolean m24988a();
    }

    /* compiled from: TV;>;>; */
    class DragSpringListener extends SimpleSpringListener {
        final /* synthetic */ ListSproutDragLayout f22405a;

        public DragSpringListener(ListSproutDragLayout listSproutDragLayout) {
            this.f22405a = listSproutDragLayout;
        }

        public final void m24989a(Spring spring) {
            this.f22405a.setTranslationY((float) (((double) this.f22405a.getHeight()) - spring.d()));
            ListSproutDragLayout.m25014h(this.f22405a);
        }

        public final void m24990b(Spring spring) {
            this.f22405a.f22412e = ListSproutDragLayout.getAtRestState(this.f22405a);
        }
    }

    /* compiled from: TV;>;>; */
    class RevealSpringListener extends SimpleSpringListener {
        final /* synthetic */ ListSproutDragLayout f22406a;

        public RevealSpringListener(ListSproutDragLayout listSproutDragLayout) {
            this.f22406a = listSproutDragLayout;
        }

        public final void m24992a(Spring spring) {
            float d = (float) spring.d();
            if (d < 0.8f) {
                m24991a((float) SpringUtil.a((double) d, 0.0d, 0.800000011920929d, 0.0d, 1.0d));
            } else {
                this.f22406a.f22420m.getPaint().setColor(-1);
                this.f22406a.setRevealRadius(Float.NaN);
            }
            this.f22406a.setVisibility(0);
        }

        private void m24991a(float f) {
            this.f22406a.f22420m.getPaint().setColor(((Integer) this.f22406a.f22419l.evaluate(f, Integer.valueOf(this.f22406a.f22417j), Integer.valueOf(-1))).intValue());
            this.f22406a.setRevealRadius((float) SpringUtil.a((double) f, 0.0d, 1.0d, (double) this.f22406a.f22416i, (double) Math.max(this.f22406a.getHeight(), this.f22406a.getWidth())));
        }

        public final void m24993b(Spring spring) {
            if (!spring.g(0.0d)) {
                this.f22406a.f22412e = ListSproutDragLayout.getAtRestState(this.f22406a);
            }
        }
    }

    /* compiled from: TV;>;>; */
    enum State {
        BEFORE_REVEAL,
        COLLAPSED,
        EXPANDED,
        ANIMATING
    }

    private static <T extends View> void m25003a(Class<T> cls, T t) {
        m25004a((Object) t, t.getContext());
    }

    private static void m25004a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ListSproutDragLayout) obj).m25002a(AdvancedDragDetector.b(fbInjector), SpringSystem.b(fbInjector));
    }

    private void m25002a(AdvancedDragDetector advancedDragDetector, SpringSystem springSystem) {
        this.f22408a = advancedDragDetector;
        this.f22409b = springSystem;
    }

    public ListSproutDragLayout(Context context) {
        super(context);
        m25010e();
    }

    public ListSproutDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25010e();
    }

    public ListSproutDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25010e();
    }

    private void m25010e() {
        m25003a(ListSproutDragLayout.class, (View) this);
        setVisibility(4);
        m25011f();
        m25013g();
        if (VERSION.SDK_INT >= 16) {
            setBackground(this.f22420m);
        } else {
            setBackgroundDrawable(this.f22420m);
        }
    }

    private void m25011f() {
        this.f22408a.p = Direction.DOWN.flag() | Direction.UP.flag();
        this.f22408a.t = true;
        this.f22408a.r = this;
    }

    private void m25013g() {
        this.f22410c = this.f22409b.a().a(SpringConfig.a(30.0d, 8.0d)).a(0.0d).b(0.0d).l();
        Spring a = this.f22409b.a().a(SpringConfig.a(30.0d, 8.0d));
        a.l = 0.5d;
        a = a;
        a.k = 20.0d;
        this.f22411d = a.a(0.0d).b(0.0d).l();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1950979724);
        super.onAttachedToWindow();
        this.f22410c.a(new RevealSpringListener(this));
        this.f22411d.a(new DragSpringListener(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1302267833, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1656721585);
        this.f22410c.m();
        this.f22411d.m();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1977714201, a);
    }

    public void setDelegate(Delegate delegate) {
        this.f22418k = delegate;
    }

    public final void mo1555a(float f, float f2) {
        this.f22414g = f;
        this.f22415h = f2;
        m25014h(this);
    }

    public void setInitialRevealRadius(float f) {
        this.f22416i = f;
    }

    public void setInitialBackgroundColor(int i) {
        this.f22420m.getPaint().setColor(i);
        this.f22417j = i;
    }

    public static void m25014h(ListSproutDragLayout listSproutDragLayout) {
        super.mo1555a(listSproutDragLayout.f22414g, listSproutDragLayout.f22415h - listSproutDragLayout.getTranslationY());
    }

    public void setCollapsedVisibleHeight(int i) {
        this.f22413f = i;
    }

    private void m25015i() {
        this.f22412e = State.ANIMATING;
        Spring spring = this.f22410c;
        spring.c = true;
        spring.b(0.0d);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22412e == State.BEFORE_REVEAL || this.f22412e == State.ANIMATING) {
            return true;
        }
        return this.f22408a.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -792802887);
        if (this.f22412e == State.BEFORE_REVEAL || this.f22412e == State.ANIMATING) {
            Logger.a(2, EntryType.UI_INPUT_END, -1406383279, a);
            return true;
        }
        boolean b = this.f22408a.b(motionEvent);
        LogUtils.a(-918273559, a);
        return b;
    }

    public final boolean m25019a(float f, float f2, Direction direction) {
        if (this.f22412e == State.ANIMATING) {
            return false;
        }
        if (this.f22412e == State.EXPANDED && direction == Direction.UP) {
            return false;
        }
        if (this.f22412e == State.COLLAPSED) {
            return true;
        }
        return this.f22418k.m24988a();
    }

    public final void m25021b(float f, float f2, Direction direction) {
        float min = Math.min((float) getHeight(), ((float) this.f22411d.d()) - f2);
        int i = (int) (((double) this.f22413f) * 0.5d);
        Object obj = null;
        if (min < ((float) i)) {
            min = (float) i;
            obj = 1;
        }
        this.f22411d.a((double) min).l();
        if (obj != null) {
            this.f22408a.c();
            m25015i();
        }
    }

    public final void mo1554a() {
        m25005a(false);
    }

    public final void m25018a(Direction direction, int i) {
        boolean z = this.f22412e == State.EXPANDED && Math.abs(i) > 500;
        m25005a(z);
    }

    private void m25005a(boolean z) {
        float d = (float) this.f22411d.d();
        int i = (int) (((double) this.f22413f) * 0.75d);
        if (z || d < ((float) i)) {
            m25015i();
            return;
        }
        if (d > ((float) ((int) (((double) this.f22413f) * 1.25d))) || this.f22411d.g((double) getHeight())) {
            this.f22411d.b((double) getHeight());
        } else {
            this.f22411d.b((double) this.f22413f);
        }
        if (this.f22411d.k()) {
            this.f22412e = getAtRestState(this);
        } else {
            this.f22412e = State.ANIMATING;
        }
    }

    public static State getAtRestState(ListSproutDragLayout listSproutDragLayout) {
        return listSproutDragLayout.f22411d.g((double) listSproutDragLayout.getHeight()) ? State.EXPANDED : State.COLLAPSED;
    }

    public final void m25020b() {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getHeight() != 0) {
            if (this.f22412e == State.EXPANDED) {
                this.f22411d.a((double) getHeight()).l();
            } else {
                this.f22411d.a((double) this.f22413f).l();
            }
            if (this.f22412e == State.BEFORE_REVEAL) {
                this.f22412e = State.ANIMATING;
                this.f22410c.b(1.0d);
                return;
            }
            this.f22412e = getAtRestState(this);
        }
    }
}

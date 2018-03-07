package com.facebook.greetingcards.verve.render;

import android.view.View;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragDecider;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.greetingcards.verve.render.VerveContentView.C00461;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.google.common.base.Preconditions;

/* compiled from: viewed_offer */
public class DragAndSpringScroller {
    public static final Class<?> f369a = DragAndSpringScroller.class;
    private static final SpringConfig f370b = new SpringConfig(180.0d, 27.0d);
    public final AdvancedDragDetector f371c;
    public final Spring f372d;
    private final View f373e;
    public C00461 f374f;
    public Direction f375g;
    public State f376h = State.IDLE;
    public int f377i;
    public int f378j;
    public boolean f379k;

    /* compiled from: viewed_offer */
    class C00371 extends SimpleSpringListener {
        final /* synthetic */ DragAndSpringScroller f365a;

        C00371(DragAndSpringScroller dragAndSpringScroller) {
            this.f365a = dragAndSpringScroller;
        }

        public final void m338a(Spring spring) {
            if (this.f365a.f376h != State.IDLE) {
                Class cls = DragAndSpringScroller.f369a;
                Double.valueOf(DragAndSpringScroller.m352d(this.f365a));
                this.f365a.f374f.m382a(DragAndSpringScroller.m352d(this.f365a));
            }
        }

        public final void m337a() {
            if (this.f365a.f376h == State.SPRINGING) {
                DragAndSpringScroller.m346a(this.f365a, DragAndSpringScroller.m352d(this.f365a) > 0.5d);
            }
        }
    }

    /* compiled from: viewed_offer */
    class C00382 implements DragDecider {
        final /* synthetic */ DragAndSpringScroller f366a;

        C00382(DragAndSpringScroller dragAndSpringScroller) {
            this.f366a = dragAndSpringScroller;
        }

        public final boolean m339a(float f, float f2) {
            return true;
        }

        public final boolean m340b(float f, float f2) {
            return this.f366a.f376h == State.SPRINGING;
        }
    }

    /* compiled from: viewed_offer */
    class C00393 implements DragListener {
        final /* synthetic */ DragAndSpringScroller f367a;

        C00393(DragAndSpringScroller dragAndSpringScroller) {
            this.f367a = dragAndSpringScroller;
        }

        public final boolean m343a(float f, float f2, Direction direction) {
            if (this.f367a.f376h == State.IDLE) {
                DragAndSpringScroller.m351c(this.f367a, direction);
            } else {
                DragAndSpringScroller dragAndSpringScroller = this.f367a;
                Preconditions.checkState(dragAndSpringScroller.f376h == State.SPRINGING);
                dragAndSpringScroller.f372d.f();
                dragAndSpringScroller.f379k = true;
                dragAndSpringScroller.f376h = State.DRAGGING;
            }
            return true;
        }

        public final void m345b(float f, float f2, Direction direction) {
            if (!this.f367a.f375g.isYAxis()) {
                f2 = f;
            }
            double b = this.f367a.f372d.b() + ((double) f2);
            double c = DragAndSpringScroller.m349c(this.f367a, b);
            Class cls;
            if (c > 1.0d && this.f367a.f375g.isSetInFlags(this.f367a.f378j)) {
                cls = DragAndSpringScroller.f369a;
                this.f367a.f372d.a(DragAndSpringScroller.m348b(this.f367a, 1.0d));
                DragAndSpringScroller.m346a(this.f367a, true);
                DragAndSpringScroller.m351c(this.f367a, this.f367a.f375g);
            } else if (c < 0.0d && DragAndSpringScroller.m353d(this.f367a.f375g).isSetInFlags(this.f367a.f377i)) {
                cls = DragAndSpringScroller.f369a;
                this.f367a.f372d.a(DragAndSpringScroller.m348b(this.f367a, 0.0d));
                DragAndSpringScroller.m346a(this.f367a, false);
                DragAndSpringScroller.m351c(this.f367a, DragAndSpringScroller.m353d(this.f367a.f375g));
            } else if (DragAndSpringScroller.m347a(this.f367a, b)) {
                this.f367a.f372d.a(b);
            }
        }

        public final void m341a() {
            DragAndSpringScroller.m350c(this.f367a);
            if (DragAndSpringScroller.m352d(this.f367a) > 0.4d) {
                this.f367a.f372d.b(DragAndSpringScroller.m348b(this.f367a, 1.0d));
            } else {
                this.f367a.f372d.b(0.0d);
            }
        }

        public final void m342a(Direction direction, int i) {
            Object obj;
            boolean z;
            double d;
            if (this.f367a.f379k && ((direction == this.f367a.f375g && DragAndSpringScroller.m352d(this.f367a) > 0.8d) || (direction != this.f367a.f375g && DragAndSpringScroller.m352d(this.f367a) < 0.2d))) {
                int i2;
                if (direction == this.f367a.f375g) {
                    i2 = this.f367a.f378j;
                } else {
                    i2 = this.f367a.f377i;
                }
                if (direction.isSetInFlags(i2)) {
                    obj = 1;
                    if (obj != null) {
                        z = DragAndSpringScroller.m352d(this.f367a) <= 0.5d;
                        Class cls = DragAndSpringScroller.f369a;
                        Boolean.valueOf(z);
                        direction.name();
                        Spring spring = this.f367a.f372d;
                        DragAndSpringScroller dragAndSpringScroller = this.f367a;
                        if (z) {
                            d = 0.0d;
                        } else {
                            d = 1.0d;
                        }
                        spring.a(DragAndSpringScroller.m348b(dragAndSpringScroller, d));
                        DragAndSpringScroller.m346a(this.f367a, z);
                        DragAndSpringScroller.m351c(this.f367a, direction);
                    }
                    DragAndSpringScroller.m350c(this.f367a);
                    if (direction != this.f367a.f375g) {
                        this.f367a.f372d.b(DragAndSpringScroller.m348b(this.f367a, 1.0d));
                        this.f367a.f372d.c((double) i);
                    }
                    this.f367a.f372d.b(0.0d);
                    this.f367a.f372d.c((double) i);
                    return;
                }
            }
            obj = null;
            if (obj != null) {
                if (DragAndSpringScroller.m352d(this.f367a) <= 0.5d) {
                }
                Class cls2 = DragAndSpringScroller.f369a;
                Boolean.valueOf(z);
                direction.name();
                Spring spring2 = this.f367a.f372d;
                DragAndSpringScroller dragAndSpringScroller2 = this.f367a;
                if (z) {
                    d = 0.0d;
                } else {
                    d = 1.0d;
                }
                spring2.a(DragAndSpringScroller.m348b(dragAndSpringScroller2, d));
                DragAndSpringScroller.m346a(this.f367a, z);
                DragAndSpringScroller.m351c(this.f367a, direction);
            }
            DragAndSpringScroller.m350c(this.f367a);
            if (direction != this.f367a.f375g) {
                this.f367a.f372d.b(0.0d);
                this.f367a.f372d.c((double) i);
                return;
            }
            this.f367a.f372d.b(DragAndSpringScroller.m348b(this.f367a, 1.0d));
            this.f367a.f372d.c((double) i);
        }

        public final void m344b() {
        }
    }

    /* compiled from: viewed_offer */
    /* synthetic */ class C00404 {
        static final /* synthetic */ int[] f368a = new int[Direction.values().length];

        static {
            try {
                f368a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f368a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f368a[Direction.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f368a[Direction.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: viewed_offer */
    public enum State {
        IDLE,
        DRAGGING,
        SPRINGING
    }

    public DragAndSpringScroller(AdvancedDragDetector advancedDragDetector, View view) {
        this.f371c = advancedDragDetector;
        Spring a = SpringSystem.b().a().a(f370b);
        a.l = 1.0d;
        a = a;
        a.k = 15.0d;
        this.f372d = a.a(new C00371(this));
        this.f373e = view;
        this.f371c.q = new C00382(this);
        this.f371c.r = new C00393(this);
    }

    public static void m346a(DragAndSpringScroller dragAndSpringScroller, boolean z) {
        Boolean.valueOf(z);
        dragAndSpringScroller.f374f.m383a(z);
        if (z) {
            dragAndSpringScroller.f377i = dragAndSpringScroller.f378j;
        }
        dragAndSpringScroller.f371c.p = dragAndSpringScroller.f377i;
        dragAndSpringScroller.f376h = State.IDLE;
        dragAndSpringScroller.f372d.a(0.0d).f();
    }

    public static void m351c(DragAndSpringScroller dragAndSpringScroller, Direction direction) {
        Preconditions.checkState(dragAndSpringScroller.f376h == State.IDLE);
        direction.name();
        dragAndSpringScroller.f378j = dragAndSpringScroller.f374f.m381a(direction);
        dragAndSpringScroller.f375g = direction;
        dragAndSpringScroller.f376h = State.DRAGGING;
    }

    public static void m350c(DragAndSpringScroller dragAndSpringScroller) {
        boolean z;
        if (dragAndSpringScroller.f376h == State.DRAGGING) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        dragAndSpringScroller.f376h = State.SPRINGING;
        dragAndSpringScroller.f379k = false;
        dragAndSpringScroller.f371c.a(new Direction[]{dragAndSpringScroller.f375g});
    }

    public static boolean m347a(DragAndSpringScroller dragAndSpringScroller, double d) {
        double c = m349c(dragAndSpringScroller, d);
        return c > -0.05d && c < 1.05d;
    }

    public static double m348b(DragAndSpringScroller dragAndSpringScroller, double d) {
        if (dragAndSpringScroller.f375g == Direction.LEFT || dragAndSpringScroller.f375g == Direction.UP) {
            d = -d;
        }
        return ((double) dragAndSpringScroller.m354e()) * d;
    }

    public static double m352d(DragAndSpringScroller dragAndSpringScroller) {
        return m349c(dragAndSpringScroller, dragAndSpringScroller.f372d.b());
    }

    public static double m349c(DragAndSpringScroller dragAndSpringScroller, double d) {
        if (dragAndSpringScroller.f375g == Direction.LEFT || dragAndSpringScroller.f375g == Direction.UP) {
            d = -d;
        }
        return d / ((double) dragAndSpringScroller.m354e());
    }

    private long m354e() {
        return this.f375g.isYAxis() ? (long) this.f373e.getHeight() : (long) this.f373e.getWidth();
    }

    public static Direction m353d(Direction direction) {
        switch (C00404.f368a[direction.ordinal()]) {
            case 1:
                return Direction.DOWN;
            case 2:
                return Direction.UP;
            case 3:
                return Direction.RIGHT;
            case 4:
                return Direction.LEFT;
            default:
                return null;
        }
    }
}

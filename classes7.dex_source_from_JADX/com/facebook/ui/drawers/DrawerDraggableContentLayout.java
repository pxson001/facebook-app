package com.facebook.ui.drawers;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragDecider;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.AdvancedDragDetector.TapListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.ScrollabilityCompatUtils;
import com.facebook.fbui.draggable.widget.SmoothScrollFrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: end_screen_set_privacy */
public class DrawerDraggableContentLayout extends SmoothScrollFrameLayout implements DragDecider, DragListener, TapListener {
    private static final Class<?> f15271a = DrawerDraggableContentLayout.class;
    public AdvancedDragDetector f15272b;
    private int f15273c = 0;
    private int f15274d = 0;
    private boolean f15275e = true;
    private boolean f15276f = true;
    private int f15277g = 0;
    private int f15278h = 0;
    public Set<DrawerStateListener> f15279i = Sets.a();
    private Set<View> f15280j = Sets.a();
    public Set<DrawerInterceptor> f15281k = Sets.a();
    private boolean f15282l = false;
    private boolean f15283m = false;
    private boolean f15284n = true;
    public final Runnable f15285o = new C11451(this);

    /* compiled from: end_screen_set_privacy */
    class C11451 implements Runnable {
        final /* synthetic */ DrawerDraggableContentLayout f15268a;

        C11451(DrawerDraggableContentLayout drawerDraggableContentLayout) {
            this.f15268a = drawerDraggableContentLayout;
        }

        public void run() {
            DrawerDraggableContentLayout.m19272k(this.f15268a);
        }
    }

    /* compiled from: end_screen_set_privacy */
    /* synthetic */ class C11462 {
        static final /* synthetic */ int[] f15269a = new int[DrawerState.values().length];
        static final /* synthetic */ int[] f15270b = new int[Direction.values().length];

        static {
            try {
                f15270b[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15270b[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15269a[DrawerState.SHOWING_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15269a[DrawerState.SHOWING_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15269a[DrawerState.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static void m19264a(Object obj, Context context) {
        ((DrawerDraggableContentLayout) obj).f15272b = AdvancedDragDetector.b(FbInjector.get(context));
    }

    public DrawerDraggableContentLayout(Context context) {
        super(context);
        Class cls = DrawerDraggableContentLayout.class;
        m19264a((Object) this, getContext());
        this.f15272b.a(new Direction[]{Direction.LEFT, Direction.RIGHT});
        this.f15272b.q = this;
        this.f15272b.r = this;
        this.f15272b.s = this;
    }

    public void setLeftDrawerEnabled(boolean z) {
        if (this.f15275e != z) {
            this.f15275e = z;
            if (!z) {
                m19267b(false);
            }
        }
    }

    public void setRightDrawerEnabled(boolean z) {
        if (this.f15276f != z) {
            this.f15276f = z;
            if (!z) {
                m19267b(false);
            }
        }
    }

    public void setSwipeToOpenEnabled(boolean z) {
        this.f15284n = z;
    }

    private void m19265a(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        for (DrawerInterceptor drawerInterceptor : this.f15281k) {
            if (z5 && drawerInterceptor.mo607a()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z4 && drawerInterceptor.mo608a(z)) {
                z2 = true;
            } else {
                z2 = false;
            }
            z4 = z2;
        }
        if (z5) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f15282l = z2;
        if (z4) {
            z3 = false;
        }
        this.f15283m = z3;
    }

    private boolean m19270h() {
        return this.f15275e && this.f15274d > 0 && !this.f15282l;
    }

    private boolean m19271i() {
        return this.f15276f && this.f15273c > 0 && !this.f15283m;
    }

    public void setRightDrawerWidth(int i) {
        this.f15273c = i;
        m19267b(false);
    }

    public void setLeftDrawerWidth(int i) {
        this.f15274d = i;
        m19267b(false);
    }

    public int getRightDrawerWidth() {
        return this.f15273c;
    }

    public int getLeftDrawerWidth() {
        return this.f15274d;
    }

    public final void m19276a(DrawerState drawerState, boolean z) {
        int i = 0;
        m4237g();
        this.f15272b.c();
        if (drawerState != DrawerState.CLOSED) {
            m19265a(false);
            m19263a(drawerState, null);
        }
        switch (C11462.f15269a[drawerState.ordinal()]) {
            case 1:
                if (m19271i()) {
                    i = this.f15273c;
                    break;
                }
                break;
            case 2:
                if (m19270h()) {
                    i = -this.f15274d;
                    break;
                }
                break;
        }
        if (i == getScrollX()) {
            return;
        }
        if (z) {
            m19269e(i);
            DrawerState drawerState2 = getDrawerState();
            if (drawerState2 == DrawerState.CLOSED) {
                m19262a(drawerState);
                return;
            } else {
                m19262a(drawerState2);
                return;
            }
        }
        m19266b(i);
    }

    public DrawerState getDrawerState() {
        int scrollX = getScrollX();
        if (scrollX > 0) {
            return DrawerState.SHOWING_RIGHT;
        }
        if (scrollX < 0) {
            return DrawerState.SHOWING_LEFT;
        }
        return DrawerState.CLOSED;
    }

    public static void m19272k(DrawerDraggableContentLayout drawerDraggableContentLayout) {
        if (drawerDraggableContentLayout.f15279i != null && !drawerDraggableContentLayout.f15279i.isEmpty()) {
            Object obj;
            if (drawerDraggableContentLayout.f15272b.b() || drawerDraggableContentLayout.m4236f()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                drawerDraggableContentLayout.m19262a(drawerDraggableContentLayout.getDrawerState());
                return;
            }
            for (DrawerController a : drawerDraggableContentLayout.f15279i) {
                a.a(drawerDraggableContentLayout.getDrawerState());
            }
        }
    }

    private void m19262a(DrawerState drawerState) {
        getScrollX();
        int[] iArr = C11462.f15269a;
        drawerState.ordinal();
        for (DrawerController b : this.f15279i) {
            b.b(drawerState);
        }
    }

    private void m19263a(DrawerState drawerState, @Nullable Direction direction) {
        int i = 0;
        boolean z = (drawerState == DrawerState.CLOSED && direction == null) ? false : true;
        Preconditions.checkArgument(z);
        switch (C11462.f15269a[drawerState.ordinal()]) {
            case 1:
                this.f15278h = this.f15273c;
                break;
            case 2:
                this.f15278h = 0;
                i = -this.f15274d;
                break;
            case 3:
                switch (C11462.f15270b[direction.ordinal()]) {
                    case 1:
                        this.f15278h = m19271i() ? this.f15273c : 0;
                        break;
                    case 2:
                        this.f15278h = 0;
                        if (m19270h()) {
                            i = -this.f15274d;
                            break;
                        }
                        break;
                    default:
                        return;
                }
            default:
                return;
        }
        this.f15277g = i;
    }

    private int m19261a(int i) {
        if (i > this.f15278h) {
            return this.f15278h;
        }
        if (i < this.f15277g) {
            return this.f15277g;
        }
        return i;
    }

    private boolean m19268b(int i, int i2) {
        if (this.f15280j.isEmpty()) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        for (View view : this.f15280j) {
            view.getLocationInWindow(iArr2);
            int i3 = iArr2[0] - iArr[0];
            int i4 = iArr2[1] - iArr[1];
            if (new Rect(i3, i4, view.getWidth() + i3, view.getHeight() + i4).contains(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f15272b.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 941325321);
        boolean b = this.f15272b.b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 2017257687, a);
        return b;
    }

    public boolean canScrollHorizontally(int i) {
        if (i <= 0 || !m19271i()) {
            if (i >= 0 || !m19270h()) {
                return false;
            }
            if (getScrollX() <= (-this.f15274d)) {
                return false;
            }
            return true;
        } else if (getScrollX() < this.f15273c) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canScrollVertically(int i) {
        return false;
    }

    private void m19267b(boolean z) {
        m4237g();
        int scrollX = getScrollX();
        int i = 0;
        if (scrollX != 0) {
            i = Math.abs(scrollX - this.f15278h) < Math.abs(scrollX - this.f15277g) ? this.f15278h : this.f15277g;
        }
        if (i != scrollX) {
            if (z) {
                m19269e(i);
            } else {
                m19266b(i);
            }
        } else if (z) {
            m19272k(this);
        }
    }

    protected final void mo167a(int i, int i2, boolean z) {
        super.mo167a(i, i2, z);
        if (z) {
            Handler handler = getHandler();
            if (handler != null) {
                HandlerDetour.a(handler, this.f15285o, -1286417527);
                return;
            }
            return;
        }
        m19272k(this);
    }

    private void m19266b(int i) {
        scrollTo(i, 0);
    }

    private void m19269e(int i) {
        m4234a(i, 0);
    }

    public final boolean m19277a(float f, float f2) {
        int scrollX = getScrollX();
        switch (C11462.f15269a[getDrawerState().ordinal()]) {
            case 1:
                if (f >= ((float) (getWidth() - scrollX))) {
                    return false;
                }
                return true;
            case 2:
                if (f <= ((float) (-scrollX))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    public final boolean m19281b(float f, float f2) {
        if (m4236f()) {
            return true;
        }
        if (getScrollX() == 0 || m19268b((int) f, (int) f2)) {
            return false;
        }
        return true;
    }

    public final boolean m19278a(float f, float f2, Direction direction) {
        m19265a(true);
        m19263a(getDrawerState(), direction);
        if (m4237g()) {
            return true;
        }
        if (getDrawerState() == DrawerState.CLOSED) {
            if (!this.f15284n || ((direction == Direction.LEFT && !m19271i()) || ((direction == Direction.RIGHT && !m19270h()) || ScrollabilityCompatUtils.a(this, direction, (int) f, (int) f2)))) {
                return false;
            }
            return true;
        } else if (m19268b((int) f, (int) f2)) {
            return false;
        } else {
            return true;
        }
    }

    public final void m19280b(float f, float f2, Direction direction) {
        m19266b(m19261a(getScrollX() - ((int) f)));
    }

    public final void mo166a() {
        m19267b(true);
    }

    public final void m19275a(Direction direction, int i) {
        m19269e(direction == Direction.LEFT ? this.f15278h : this.f15277g);
    }

    public final void m19279b() {
    }

    public final boolean m19282c(float f, float f2) {
        return false;
    }

    public final void m19283d(float f, float f2) {
        if (getDrawerState() != DrawerState.CLOSED) {
            m19276a(DrawerState.CLOSED, true);
        }
    }
}

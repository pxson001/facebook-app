package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.IncomingAnimationCompleteEvent;
import com.facebook.richdocument.event.RichDocumentEvents.OutgoingAnimationCompleteEvent;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: offers_shown */
public class RichDocumentActivityTransitioner extends CustomFrameLayout {
    private static final SpringConfig f7257e = SpringConfig.a(280.0d, 30.0d);
    @Inject
    SpringSystem f7258a;
    @Inject
    RichDocumentEventBus f7259b;
    @Inject
    ExpandedMediaHolder f7260c;
    @Inject
    RichDocumentLayoutDirection f7261d;
    private final int f7262f = getResources().getDimensionPixelSize(2131431836);
    public View f7263g;
    private RecyclerView f7264h;
    private float f7265i;
    private float f7266j;
    private float f7267k;
    private TransitionState f7268l = TransitionState.WAITING_FOR_DOWN;
    private int f7269m;
    private Spring f7270n;
    private VelocityTracker f7271o;
    private boolean f7272p;
    public boolean f7273q;

    /* compiled from: offers_shown */
    class C08281 implements OnLayoutChangeListener {
        final /* synthetic */ RichDocumentActivityTransitioner f7253a;

        C08281(RichDocumentActivityTransitioner richDocumentActivityTransitioner) {
            this.f7253a = richDocumentActivityTransitioner;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f7253a.f7273q) {
                this.f7253a.f7263g.setX((float) (-this.f7253a.getWidth()));
            } else {
                this.f7253a.f7263g.setX((float) this.f7253a.getWidth());
            }
            this.f7253a.m7531a(false, 1250.0f);
            this.f7253a.removeOnLayoutChangeListener(this);
        }
    }

    /* compiled from: offers_shown */
    enum TransitionState {
        WAITING_FOR_DOWN,
        WAITING_FOR_MOVES,
        ACCEPTING_MOVE_EVENTS
    }

    private static <T extends View> void m7529a(Class<T> cls, T t) {
        m7530a((Object) t, t.getContext());
    }

    private static void m7530a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RichDocumentActivityTransitioner) obj).m7528a(SpringSystem.b(injectorLike), RichDocumentEventBus.m5130a(injectorLike), ExpandedMediaHolder.m7438a(injectorLike), RichDocumentLayoutDirection.m7366a(injectorLike));
    }

    public RichDocumentActivityTransitioner(Context context) {
        super(context);
        m7536e();
    }

    public RichDocumentActivityTransitioner(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m7536e();
    }

    public RichDocumentActivityTransitioner(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7536e();
    }

    private void m7536e() {
        m7529a(RichDocumentActivityTransitioner.class, (View) this);
        this.f7273q = this.f7261d.m7370b();
        this.f7271o = VelocityTracker.obtain();
        Spring c = this.f7258a.a().a(f7257e).c(1250.0d);
        c.c = true;
        this.f7270n = c.l();
        this.f7269m = getResources().getColor(2131363469);
        addOnLayoutChangeListener(new C08281(this));
    }

    public final void m7538a(View view, RecyclerView recyclerView) {
        this.f7263g = view;
        this.f7264h = recyclerView;
    }

    private boolean m7532a(int i, int i2) {
        if (this.f7264h == null) {
            return false;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f7264h.getLayoutManager();
        int l = linearLayoutManager.l();
        int v = (linearLayoutManager.v() + l) - 1;
        int[] iArr = new int[2];
        this.f7264h.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        while (l <= v) {
            BlockViewHolder blockViewHolder = (BlockViewHolder) this.f7264h.c(l);
            if (blockViewHolder != null) {
                View view = blockViewHolder.a;
                rect.set(view.getLeft() + iArr[0], view.getTop() + iArr[1], view.getRight() + iArr[0], view.getBottom() + iArr[1]);
                if (rect.contains(i, i2) && blockViewHolder.m7383w().f6382d.mo377a(i, i2)) {
                    return true;
                }
            }
            l++;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.f7260c.m7440a() != null || !m7539a()) {
                this.f7267k = motionEvent.getX();
                return false;
            } else if (this.f7263g == null || this.f7264h == null) {
                r0 = super.onInterceptTouchEvent(motionEvent);
                this.f7267k = motionEvent.getX();
                return r0;
            } else if (motionEvent.getAction() == 0 && this.f7268l == TransitionState.WAITING_FOR_DOWN) {
                this.f7271o.clear();
                this.f7271o.addMovement(motionEvent);
                if (m7532a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.f7267k = motionEvent.getX();
                    return false;
                }
                this.f7268l = TransitionState.WAITING_FOR_MOVES;
                this.f7265i = motionEvent.getX();
                this.f7266j = motionEvent.getY();
                this.f7267k = motionEvent.getX();
                return false;
            } else if (motionEvent.getAction() == 2 && this.f7268l == TransitionState.WAITING_FOR_MOVES) {
                this.f7271o.addMovement(motionEvent);
                float abs = Math.abs(motionEvent.getX() - this.f7265i);
                float abs2 = Math.abs(motionEvent.getY() - this.f7266j);
                if (abs < ((float) this.f7262f) && abs2 < ((float) this.f7262f)) {
                    this.f7267k = motionEvent.getX();
                    return false;
                } else if ((abs >= ((float) this.f7262f) || abs2 <= ((float) this.f7262f)) && abs2 * 2.0f < abs) {
                    this.f7268l = TransitionState.ACCEPTING_MOVE_EVENTS;
                    m7523a((m7522a(this.f7263g) + motionEvent.getX()) - this.f7267k);
                    m7537f(this);
                    this.f7267k = motionEvent.getX();
                    return true;
                } else {
                    this.f7268l = TransitionState.WAITING_FOR_DOWN;
                    this.f7267k = motionEvent.getX();
                    return false;
                }
            } else {
                if (motionEvent.getAction() == 1) {
                    this.f7268l = TransitionState.WAITING_FOR_DOWN;
                }
                r0 = super.onInterceptTouchEvent(motionEvent);
                this.f7267k = motionEvent.getX();
                return r0;
            }
        } catch (Throwable th) {
            this.f7267k = motionEvent.getX();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 105760182);
        if (this.f7260c.m7440a() != null || !m7539a()) {
            Logger.a(2, EntryType.UI_INPUT_END, -1060115989, a);
            return false;
        } else if (this.f7263g == null || this.f7264h == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(157394144, a);
            return onTouchEvent;
        } else {
            this.f7271o.addMovement(motionEvent);
            if (motionEvent.getAction() == 1 && this.f7268l == TransitionState.ACCEPTING_MOVE_EVENTS) {
                int i;
                boolean z;
                this.f7268l = TransitionState.WAITING_FOR_DOWN;
                this.f7271o.computeCurrentVelocity(1000);
                float xVelocity = this.f7271o.getXVelocity();
                float f = xVelocity * 0.25f;
                if (this.f7273q) {
                    i = (-getWidth()) / 2;
                } else {
                    i = getWidth() / 2;
                }
                boolean z2;
                if (this.f7273q) {
                    if (f <= ((float) i)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (m7522a(this.f7263g) < ((float) i)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    if (f >= ((float) i)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (m7522a(this.f7263g) > ((float) i)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (z || r0) {
                    m7531a(true, xVelocity);
                } else {
                    m7531a(false, xVelocity);
                }
            } else if (motionEvent.getAction() == 2 && this.f7268l == TransitionState.ACCEPTING_MOVE_EVENTS) {
                m7523a((m7522a(this.f7263g) + motionEvent.getX()) - this.f7267k);
                m7537f(this);
                this.f7267k = motionEvent.getX();
            } else {
                LogUtils.a(-2091773067, a);
                return false;
            }
            LogUtils.a(1457737876, a);
            return true;
        }
    }

    private void m7528a(SpringSystem springSystem, RichDocumentEventBus richDocumentEventBus, ExpandedMediaHolder expandedMediaHolder, RichDocumentLayoutDirection richDocumentLayoutDirection) {
        this.f7258a = springSystem;
        this.f7259b = richDocumentEventBus;
        this.f7260c = expandedMediaHolder;
        this.f7261d = richDocumentLayoutDirection;
    }

    public boolean m7539a() {
        return true;
    }

    private float m7522a(View view) {
        float x = view.getX();
        if (this.f7273q) {
            if (x > 0.0f) {
                return x * 10.0f;
            }
            return x;
        } else if (x < 0.0f) {
            return x * 10.0f;
        } else {
            return x;
        }
    }

    public static void m7537f(RichDocumentActivityTransitioner richDocumentActivityTransitioner) {
        richDocumentActivityTransitioner.setBackgroundColor(Color.argb((int) ((1.0f - (Math.abs(richDocumentActivityTransitioner.m7522a(richDocumentActivityTransitioner.f7263g)) / ((float) richDocumentActivityTransitioner.getWidth()))) * 255.0f), Color.red(richDocumentActivityTransitioner.f7269m), Color.green(richDocumentActivityTransitioner.f7269m), Color.blue(richDocumentActivityTransitioner.f7269m)));
    }

    public final void m7540b() {
        m7531a(true, 1250.0f);
    }

    private void m7524a(float f, boolean z) {
        m7523a(f);
        if (z) {
            this.f7259b.a(new OutgoingAnimationCompleteEvent());
        }
        this.f7270n.m();
        if (!z && !this.f7272p) {
            this.f7272p = true;
            this.f7259b.a(new IncomingAnimationCompleteEvent());
        }
    }

    private void m7531a(final boolean z, float f) {
        float f2 = 0.0f;
        float a = m7522a(this.f7263g);
        if (this.f7273q) {
            if (z) {
                f2 = (float) (-getWidth());
            }
        } else if (z) {
            f2 = (float) getWidth();
        }
        this.f7270n.c((double) f);
        this.f7270n.a(new SpringListener(this) {
            final /* synthetic */ RichDocumentActivityTransitioner f7256c;

            public final void m7518a(Spring spring) {
                if (Math.abs(((float) Math.round((float) spring.d())) - f2) <= 1.0f) {
                    this.f7256c.m7524a(f2, z);
                    return;
                }
                this.f7256c.m7523a((float) spring.d());
                RichDocumentActivityTransitioner.m7537f(this.f7256c);
            }

            public final void m7519b(Spring spring) {
                this.f7256c.m7524a(f2, z);
            }

            public final void m7520c(Spring spring) {
            }

            public final void m7521d(Spring spring) {
            }
        });
        this.f7270n.a((double) a);
        this.f7270n.b((double) f2);
    }

    private void m7523a(float f) {
        if (this.f7273q) {
            if (f > 0.0f) {
                f /= 10.0f;
            }
        } else if (f < 0.0f) {
            f /= 10.0f;
        }
        this.f7263g.setX(f);
    }
}

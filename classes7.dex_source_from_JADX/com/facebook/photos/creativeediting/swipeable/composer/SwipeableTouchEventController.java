package com.facebook.photos.creativeediting.swipeable.composer;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.10;
import com.facebook.photos.creativecam.ui.CameraPreviewController;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState.SwipingState;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController.C08137;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout.SwipeableLayoutEventListener;
import com.facebook.photos.creativeediting.utilities.SpringAnimatorHelper;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.ScrollingAwareScrollView.GestureDetectorListener;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: lockscreen_notification_on */
public class SwipeableTouchEventController {
    public static final String f9903a = SwipeableTouchEventController.class.getSimpleName();
    public final ViewConfiguration f9904b;
    public boolean f9905c;
    public float f9906d;
    public float f9907e;
    public Pair<Float, Float> f9908f;
    @Nullable
    public 10 f9909g;
    @Nullable
    public OnTouchListener f9910h;
    public boolean f9911i;
    public final GestureDetectorListener f9912j = new C08201(this);
    public final OnTouchListener f9913k = new C08212(this);
    private final SimpleOnGestureListener f9914l = new C08223(this);
    private final C08234 f9915m = new C08234(this);
    public final SpringAnimatorHelper f9916n;
    public final SwipingTouchEventState f9917o = new SwipingTouchEventState(SwipingState.NOT_SWIPING);
    public final C08137 f9918p;
    public final GestureDetector f9919q;
    @Nullable
    public CreativeEditingSwipeableLayout f9920r;
    @Nullable
    public ScrollingAwareScrollView f9921s;
    @Nullable
    public OnClickListener f9922t;
    private boolean f9923u;
    public boolean f9924v = true;

    /* compiled from: lockscreen_notification_on */
    class C08201 implements GestureDetectorListener {
        final /* synthetic */ SwipeableTouchEventController f9898a;

        C08201(SwipeableTouchEventController swipeableTouchEventController) {
            this.f9898a = swipeableTouchEventController;
        }

        public final void m11835a(ScrollingAwareScrollView scrollingAwareScrollView, MotionEvent motionEvent, float f) {
            if (this.f9898a.f9917o.c()) {
                SwipeableTouchEventController.m11839a(this.f9898a, SwipingState.NOT_SWIPING);
            } else if (this.f9898a.f9917o.h()) {
                SwipeableTouchEventController.m11838a(this.f9898a, motionEvent.getX(), f, false, false);
            } else if (this.f9898a.f9917o.f() && !scrollingAwareScrollView.a) {
                scrollingAwareScrollView.a = true;
            }
        }

        public final void m11834a(MotionEvent motionEvent) {
            if (!(motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
                BLog.b(SwipeableTouchEventController.f9903a, "ScrollAwareScrollView::onTouchUp is triggered when action isn't cancel or up. action : %d", new Object[]{Integer.valueOf(motionEvent.getAction())});
            }
            if (this.f9898a.f9917o.h()) {
                this.f9898a.m11844b(false);
            }
        }
    }

    /* compiled from: lockscreen_notification_on */
    class C08212 implements OnTouchListener {
        int f9899a = -1;
        final /* synthetic */ SwipeableTouchEventController f9900b;

        C08212(SwipeableTouchEventController swipeableTouchEventController) {
            this.f9900b = swipeableTouchEventController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f9900b.f9910h != null) {
                this.f9900b.f9910h.onTouch(view, motionEvent);
            }
            if (this.f9900b.f9909g != null) {
                CameraPreviewController cameraPreviewController = this.f9900b.f9909g.a.az;
                if (cameraPreviewController.r) {
                    cameraPreviewController.c.onTouchEvent(motionEvent);
                }
            }
            if (!(motionEvent.getAction() == 0 && this.f9899a == 0)) {
                this.f9899a = motionEvent.getAction();
                if ((!this.f9900b.f9919q.onTouchEvent(motionEvent) || this.f9900b.f9917o.g()) && this.f9900b.f9918p.m11763b()) {
                    BLog.a(SwipeableTouchEventController.f9903a, "There's mixed touch events being thrown.");
                    if (motionEvent.getAction() == 1) {
                        this.f9900b.m11844b(false);
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: lockscreen_notification_on */
    class C08223 extends SimpleOnGestureListener {
        final /* synthetic */ SwipeableTouchEventController f9901a;

        C08223(SwipeableTouchEventController swipeableTouchEventController) {
            this.f9901a = swipeableTouchEventController;
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (this.f9901a.f9917o.g()) {
                SwipeableTouchEventController.m11842c(this.f9901a, true);
                this.f9901a.f9916n.j = true;
                this.f9901a.f9905c = true;
                this.f9901a.f9906d = motionEvent.getX();
                this.f9901a.f9907e = motionEvent.getX();
            } else {
                SwipeableTouchEventController.m11841c(this.f9901a, motionEvent.getX());
            }
            if (this.f9901a.f9921s != null) {
                this.f9901a.f9921s.e = this.f9901a.f9912j;
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!this.f9901a.f9918p.m11763b() || !this.f9901a.f9924v) {
                return false;
            }
            if (Math.abs(this.f9901a.f9917o.a()) > ((float) this.f9901a.f9904b.getScaledTouchSlop())) {
                SwipeableTouchEventController.m11842c(this.f9901a, true);
            }
            if (this.f9901a.f9905c) {
                this.f9901a.f9907e = motionEvent2.getX();
                if (!SwipeableTouchEventController.m11843d(this.f9901a, Math.abs(f))) {
                    return true;
                }
                this.f9901a.f9908f = new Pair(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()));
                return true;
            }
            if (this.f9901a.f9917o.c()) {
                SwipeableTouchEventController.m11839a(this.f9901a, SwipingState.SWIPING);
            }
            if (!this.f9901a.f9917o.h()) {
                return true;
            }
            SwipeableTouchEventController.m11838a(this.f9901a, motionEvent2.getX(), f, false, false);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.f9901a.m11846f();
            if (this.f9901a.f9922t == null) {
                return false;
            }
            this.f9901a.f9922t.onClick(this.f9901a.f9920r);
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(motionEvent.getX() - motionEvent2.getX()) < Math.abs(motionEvent.getY() - motionEvent2.getY()) || !this.f9901a.f9918p.m11763b()) {
                return false;
            }
            SwipeableTouchEventController.m11842c(this.f9901a, true);
            if (this.f9901a.f9918p.m11762a()) {
                if (this.f9901a.f9917o.h() || this.f9901a.f9917o.g()) {
                    SwipeableTouchEventController.m11838a(this.f9901a, motionEvent2.getX(), 0.0f, true, true);
                }
                return true;
            }
            this.f9901a.f9908f = new Pair(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()));
            return true;
        }
    }

    /* compiled from: lockscreen_notification_on */
    public class C08234 {
        final /* synthetic */ SwipeableTouchEventController f9902a;

        C08234(SwipeableTouchEventController swipeableTouchEventController) {
            this.f9902a = swipeableTouchEventController;
        }

        public final void m11836a(float f, boolean z) {
            SwipingTouchEventState swipingTouchEventState = this.f9902a.f9917o;
            swipingTouchEventState.c = swipingTouchEventState.b + f;
            if (z) {
                this.f9902a.m11846f();
            }
            if (this.f9902a.f9920r != null) {
                this.f9902a.f9920r.invalidate();
            }
        }
    }

    @Inject
    public SwipeableTouchEventController(@Assisted C08137 c08137, Context context, SpringAnimatorHelper springAnimatorHelper) {
        this.f9918p = c08137;
        this.f9919q = new GestureDetector(context, this.f9914l);
        this.f9916n = springAnimatorHelper;
        this.f9904b = ViewConfiguration.get(context);
        SpringAnimatorHelper springAnimatorHelper2 = this.f9916n;
        springAnimatorHelper2.h = 15.0f;
        springAnimatorHelper2.g = 100.0f;
    }

    public static void m11841c(SwipeableTouchEventController swipeableTouchEventController, float f) {
        swipeableTouchEventController.f9916n.a();
        swipeableTouchEventController.f9917o.b = f;
        m11839a(swipeableTouchEventController, SwipingState.ON_DOWN);
    }

    public static void m11839a(SwipeableTouchEventController swipeableTouchEventController, SwipingState swipingState) {
        if (swipeableTouchEventController.f9920r != null) {
            SwipeableLayoutEventListener swipeableLayoutEventListener;
            if (swipeableTouchEventController.f9905c) {
                swipeableLayoutEventListener = swipeableTouchEventController.f9920r.f9843h;
                if (swipeableLayoutEventListener != null) {
                    swipeableLayoutEventListener.mo518a(swipeableTouchEventController.f9917o, swipingState);
                    return;
                }
                return;
            }
            swipeableLayoutEventListener = swipeableTouchEventController.f9920r.f9843h;
            if (swipeableLayoutEventListener != null) {
                swipeableLayoutEventListener.mo518a(swipeableTouchEventController.f9917o, swipingState);
            }
            swipeableTouchEventController.f9917o.a = swipingState;
        }
    }

    public final float m11845e() {
        int measuredWidth = ((CreativeEditingSwipeableLayout) Preconditions.checkNotNull(this.f9920r)).getMeasuredWidth();
        float a = this.f9917o.a();
        if (a <= 0.0f) {
            a += (float) measuredWidth;
        }
        if (a < 0.0f) {
            return 0.0f;
        }
        if (a > ((float) measuredWidth)) {
            return (float) measuredWidth;
        }
        return a;
    }

    public final void m11846f() {
        m11839a(this, SwipingState.NOT_SWIPING);
        if (this.f9917o.f()) {
            this.f9917o.c = 0.0f;
            this.f9917o.b = 0.0f;
        }
    }

    public final void m11844b(boolean z) {
        int i = 1;
        if (!this.f9905c) {
            m11842c(this, false);
        }
        if (this.f9917o.h() && this.f9920r != null) {
            if (this.f9923u) {
                z = true;
            }
            float e = m11845e();
            float measuredWidth = (float) this.f9920r.getMeasuredWidth();
            float a = this.f9917o.a();
            float f = measuredWidth / 2.0f;
            m11839a(this, SwipingState.FINISHING);
            if (z) {
                if (this.f9917o.d()) {
                    m11840b(a, measuredWidth);
                } else if (this.f9917o.e()) {
                    m11837a(a, measuredWidth);
                } else {
                    BLog.b(f9903a, "Finishing calculation error. Delta : %f, width : %f", new Object[]{Float.valueOf(a), Float.valueOf(measuredWidth)});
                }
            } else if (this.f9917o.e()) {
                if (e <= f) {
                    i = 0;
                }
                if (i != 0) {
                    m11837a(a, measuredWidth);
                } else {
                    m11840b(a, measuredWidth);
                }
            } else if (this.f9917o.d()) {
                if (e >= f) {
                    i = 0;
                }
                if (i != 0) {
                    m11840b(a, measuredWidth);
                } else {
                    m11837a(a, measuredWidth);
                }
            } else {
                BLog.b(f9903a, "Finishing calculation error. Delta : %f, width : %f", new Object[]{Float.valueOf(a), Float.valueOf(measuredWidth)});
                m11846f();
            }
        }
    }

    public final boolean m11847g() {
        float e = m11845e();
        float measuredWidth = ((float) this.f9920r.getMeasuredWidth()) / 2.0f;
        return this.f9923u || ((this.f9917o.e() && e > measuredWidth) || (this.f9917o.d() && e < measuredWidth));
    }

    public static void m11838a(SwipeableTouchEventController swipeableTouchEventController, float f, float f2, boolean z, boolean z2) {
        boolean z3 = m11843d(swipeableTouchEventController, Math.abs(f2)) || z2;
        swipeableTouchEventController.f9923u = z3;
        if (swipeableTouchEventController.f9917o.h()) {
            swipeableTouchEventController.f9917o.c = f;
            if (z) {
                swipeableTouchEventController.m11844b(true);
            }
            if (swipeableTouchEventController.f9920r != null) {
                swipeableTouchEventController.f9920r.invalidate();
                return;
            }
            return;
        }
        BLog.b(f9903a, "Cannot update x position while not swiping.");
    }

    private void m11837a(float f, float f2) {
        if (f <= 0.0f) {
            this.f9916n.a(this.f9915m, f, 0.0f);
        } else {
            this.f9916n.a(this.f9915m, f, f2);
        }
    }

    private void m11840b(float f, float f2) {
        if (f <= 0.0f) {
            this.f9916n.a(this.f9915m, f, -f2);
        } else {
            this.f9916n.a(this.f9915m, f, 0.0f);
        }
    }

    public static boolean m11843d(SwipeableTouchEventController swipeableTouchEventController, float f) {
        if (swipeableTouchEventController.f9920r != null && f / ((float) swipeableTouchEventController.f9920r.getWidth()) > 0.1f) {
            return true;
        }
        return false;
    }

    public static void m11842c(SwipeableTouchEventController swipeableTouchEventController, boolean z) {
        if (swipeableTouchEventController.f9911i && swipeableTouchEventController.f9920r != null) {
            ViewParent parent = swipeableTouchEventController.f9920r.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(z);
            }
        }
    }
}

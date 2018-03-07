package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: video_max_duration */
public class GestureDetectorCompat$GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
    private static final int f281e = ViewConfiguration.getLongPressTimeout();
    private static final int f282f = ViewConfiguration.getTapTimeout();
    private static final int f283g = ViewConfiguration.getDoubleTapTimeout();
    private int f284a;
    private int f285b;
    private int f286c;
    private int f287d;
    public final Handler f288h;
    public final OnGestureListener f289i;
    public OnDoubleTapListener f290j;
    public boolean f291k;
    public boolean f292l;
    public boolean f293m;
    private boolean f294n;
    private boolean f295o;
    public MotionEvent f296p;
    private MotionEvent f297q;
    private boolean f298r;
    private float f299s;
    private float f300t;
    private float f301u;
    private float f302v;
    private boolean f303w;
    private VelocityTracker f304x;

    /* compiled from: video_max_duration */
    class GestureHandler extends Handler {
        final /* synthetic */ GestureDetectorCompat$GestureDetectorCompatImplBase f280a;

        GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase) {
            this.f280a = gestureDetectorCompat$GestureDetectorCompatImplBase;
        }

        GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase, Handler handler) {
            this.f280a = gestureDetectorCompat$GestureDetectorCompatImplBase;
            super(handler.getLooper());
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f280a.f289i.onShowPress(this.f280a.f296p);
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase = this.f280a;
                    gestureDetectorCompat$GestureDetectorCompatImplBase.f288h.removeMessages(3);
                    gestureDetectorCompat$GestureDetectorCompatImplBase.f292l = false;
                    gestureDetectorCompat$GestureDetectorCompatImplBase.f293m = true;
                    gestureDetectorCompat$GestureDetectorCompatImplBase.f289i.onLongPress(gestureDetectorCompat$GestureDetectorCompatImplBase.f296p);
                    return;
                case 3:
                    if (this.f280a.f290j == null) {
                        return;
                    }
                    if (this.f280a.f291k) {
                        this.f280a.f292l = true;
                        return;
                    } else {
                        this.f280a.f290j.onSingleTapConfirmed(this.f280a.f296p);
                        return;
                    }
                default:
                    throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    public GestureDetectorCompat$GestureDetectorCompatImplBase(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.f288h = new GestureHandler(this, handler);
        } else {
            this.f288h = new GestureHandler(this);
        }
        this.f289i = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            this.f290j = (OnDoubleTapListener) onGestureListener;
        }
        m321a(context);
    }

    private void m321a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.f289i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.f303w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f286c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f287d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f284a = scaledTouchSlop * scaledTouchSlop;
            this.f285b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    public final void m324a(boolean z) {
        this.f303w = z;
    }

    public final boolean m325a(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.f304x == null) {
            this.f304x = VelocityTracker.obtain();
        }
        this.f304x.addMovement(motionEvent);
        boolean z = (action & 255) == 6;
        int b = z ? MotionEventCompat.b(motionEvent) : -1;
        int c = MotionEventCompat.c(motionEvent);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < c; i++) {
            if (b != i) {
                f2 += MotionEventCompat.c(motionEvent, i);
                f += MotionEventCompat.d(motionEvent, i);
            }
        }
        b = z ? c - 1 : c;
        f2 /= (float) b;
        f /= (float) b;
        boolean hasMessages;
        float b2;
        float a;
        switch (action & 255) {
            case 0:
                if (this.f290j != null) {
                    hasMessages = this.f288h.hasMessages(3);
                    if (hasMessages) {
                        this.f288h.removeMessages(3);
                    }
                    if (this.f296p == null || this.f297q == null || !hasMessages || !m322a(this.f296p, this.f297q, motionEvent)) {
                        this.f288h.sendEmptyMessageDelayed(3, (long) f283g);
                    } else {
                        this.f298r = true;
                        b = (this.f290j.onDoubleTap(this.f296p) | 0) | this.f290j.onDoubleTapEvent(motionEvent);
                        this.f299s = f2;
                        this.f301u = f2;
                        this.f300t = f;
                        this.f302v = f;
                        if (this.f296p != null) {
                            this.f296p.recycle();
                        }
                        this.f296p = MotionEvent.obtain(motionEvent);
                        this.f294n = true;
                        this.f295o = true;
                        this.f291k = true;
                        this.f293m = false;
                        this.f292l = false;
                        if (this.f303w) {
                            this.f288h.removeMessages(2);
                            this.f288h.sendEmptyMessageAtTime(2, (this.f296p.getDownTime() + ((long) f282f)) + ((long) f281e));
                        }
                        this.f288h.sendEmptyMessageAtTime(1, this.f296p.getDownTime() + ((long) f282f));
                        return b | this.f289i.onDown(motionEvent);
                    }
                }
                b = 0;
                this.f299s = f2;
                this.f301u = f2;
                this.f300t = f;
                this.f302v = f;
                if (this.f296p != null) {
                    this.f296p.recycle();
                }
                this.f296p = MotionEvent.obtain(motionEvent);
                this.f294n = true;
                this.f295o = true;
                this.f291k = true;
                this.f293m = false;
                this.f292l = false;
                if (this.f303w) {
                    this.f288h.removeMessages(2);
                    this.f288h.sendEmptyMessageAtTime(2, (this.f296p.getDownTime() + ((long) f282f)) + ((long) f281e));
                }
                this.f288h.sendEmptyMessageAtTime(1, this.f296p.getDownTime() + ((long) f282f));
                return b | this.f289i.onDown(motionEvent);
            case 1:
                this.f291k = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.f298r) {
                    hasMessages = this.f290j.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.f293m) {
                    this.f288h.removeMessages(3);
                    this.f293m = false;
                    hasMessages = false;
                } else if (this.f294n) {
                    hasMessages = this.f289i.onSingleTapUp(motionEvent);
                    if (this.f292l && this.f290j != null) {
                        this.f290j.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.f304x;
                    int b3 = MotionEventCompat.b(motionEvent, 0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f287d);
                    b2 = VelocityTrackerCompat.b(velocityTracker, b3);
                    a = VelocityTrackerCompat.a(velocityTracker, b3);
                    hasMessages = (Math.abs(b2) > ((float) this.f286c) || Math.abs(a) > ((float) this.f286c)) ? this.f289i.onFling(this.f296p, motionEvent, a, b2) : false;
                }
                if (this.f297q != null) {
                    this.f297q.recycle();
                }
                this.f297q = obtain;
                if (this.f304x != null) {
                    this.f304x.recycle();
                    this.f304x = null;
                }
                this.f298r = false;
                this.f292l = false;
                this.f288h.removeMessages(1);
                this.f288h.removeMessages(2);
                return hasMessages;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (this.f293m) {
                    return false;
                }
                a = this.f299s - f2;
                b2 = this.f300t - f;
                if (this.f298r) {
                    return this.f290j.onDoubleTapEvent(motionEvent) | 0;
                }
                if (this.f294n) {
                    i = (int) (f2 - this.f301u);
                    int i2 = (int) (f - this.f302v);
                    i = (i * i) + (i2 * i2);
                    if (i > this.f284a) {
                        hasMessages = this.f289i.onScroll(this.f296p, motionEvent, a, b2);
                        this.f299s = f2;
                        this.f300t = f;
                        this.f294n = false;
                        this.f288h.removeMessages(3);
                        this.f288h.removeMessages(1);
                        this.f288h.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.f284a) {
                        this.f295o = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.f289i.onScroll(this.f296p, motionEvent, a, b2);
                    this.f299s = f2;
                    this.f300t = f;
                    return onScroll;
                }
            case 3:
                m320a();
                return false;
            case 5:
                this.f299s = f2;
                this.f301u = f2;
                this.f300t = f;
                this.f302v = f;
                m323b();
                return false;
            case 6:
                this.f299s = f2;
                this.f301u = f2;
                this.f300t = f;
                this.f302v = f;
                this.f304x.computeCurrentVelocity(1000, (float) this.f287d);
                int b4 = MotionEventCompat.b(motionEvent);
                b = MotionEventCompat.b(motionEvent, b4);
                f2 = VelocityTrackerCompat.a(this.f304x, b);
                float b5 = VelocityTrackerCompat.b(this.f304x, b);
                for (b = 0; b < c; b++) {
                    if (b != b4) {
                        int b6 = MotionEventCompat.b(motionEvent, b);
                        if ((VelocityTrackerCompat.b(this.f304x, b6) * b5) + (VelocityTrackerCompat.a(this.f304x, b6) * f2) < 0.0f) {
                            this.f304x.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    private void m320a() {
        this.f288h.removeMessages(1);
        this.f288h.removeMessages(2);
        this.f288h.removeMessages(3);
        this.f304x.recycle();
        this.f304x = null;
        this.f298r = false;
        this.f291k = false;
        this.f294n = false;
        this.f295o = false;
        this.f292l = false;
        if (this.f293m) {
            this.f293m = false;
        }
    }

    private void m323b() {
        this.f288h.removeMessages(1);
        this.f288h.removeMessages(2);
        this.f288h.removeMessages(3);
        this.f298r = false;
        this.f294n = false;
        this.f295o = false;
        this.f292l = false;
        if (this.f293m) {
            this.f293m = false;
        }
    }

    private boolean m322a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.f295o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f283g)) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x * x) + (y * y) < this.f285b) {
            return true;
        }
        return false;
    }
}

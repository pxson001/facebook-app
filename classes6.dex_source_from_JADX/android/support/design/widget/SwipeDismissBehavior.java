package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: publishPost */
public class SwipeDismissBehavior<V extends View> extends Behavior<V> {
    public ViewDragHelper f7057a;
    public OnDismissListener f7058b;
    private boolean f7059c;
    public float f7060d = 0.0f;
    public boolean f7061e;
    public int f7062f = 2;
    public float f7063g = 0.5f;
    public float f7064h = 0.0f;
    public float f7065i = 0.5f;
    public final Callback f7066j = new C04121(this);

    /* compiled from: publishPost */
    public interface OnDismissListener {
        void mo876a();

        void mo877a(int i);
    }

    /* compiled from: publishPost */
    public class C04121 extends Callback {
        public final /* synthetic */ SwipeDismissBehavior f7089a;
        public int f7090b;

        C04121(SwipeDismissBehavior swipeDismissBehavior) {
            this.f7089a = swipeDismissBehavior;
        }

        public final boolean m10200a(View view) {
            return this.f7089a.mo880a(view);
        }

        public final void m10202b(View view) {
            this.f7090b = view.getLeft();
        }

        public final void m10197a(int i) {
            if (this.f7089a.f7058b != null) {
                this.f7089a.f7058b.mo877a(i);
            }
        }

        public final void m10198a(View view, float f, float f2) {
            int width = view.getWidth();
            boolean z = false;
            Object obj = 1;
            if (f != 0.0f) {
                Object obj2;
                if (ViewCompat.h(view) == 1) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (this.f7089a.f7062f != 2) {
                    if (this.f7089a.f7062f == 0) {
                        if (obj2 != null) {
                            if (f >= 0.0f) {
                                obj = null;
                            }
                        } else if (f <= 0.0f) {
                            obj = null;
                        }
                    } else if (this.f7089a.f7062f != 1) {
                        obj = null;
                    } else if (obj2 != null) {
                        if (f <= 0.0f) {
                            obj = null;
                        }
                    } else if (f >= 0.0f) {
                        obj = null;
                    }
                }
            } else {
                if (Math.abs(view.getLeft() - this.f7090b) < Math.round(((float) view.getWidth()) * this.f7089a.f7063g)) {
                    obj = null;
                }
            }
            if (obj != null) {
                width = view.getLeft() < this.f7090b ? this.f7090b - width : width + this.f7090b;
                z = true;
            } else {
                width = this.f7090b;
            }
            if (this.f7089a.f7057a.a(width, view.getTop())) {
                ViewCompat.a(view, new SettleRunnable(this.f7089a, view, z));
            } else if (z && this.f7089a.f7058b != null) {
                this.f7089a.f7058b.mo876a();
            }
        }

        public final int m10203c(View view) {
            return view.getWidth();
        }

        public final int m10201b(View view, int i) {
            int width;
            int i2;
            Object obj = ViewCompat.h(view) == 1 ? 1 : null;
            if (this.f7089a.f7062f == 0) {
                if (obj != null) {
                    width = this.f7090b - view.getWidth();
                    i2 = this.f7090b;
                } else {
                    width = this.f7090b;
                    i2 = this.f7090b + view.getWidth();
                }
            } else if (this.f7089a.f7062f != 1) {
                width = this.f7090b - view.getWidth();
                i2 = this.f7090b + view.getWidth();
            } else if (obj != null) {
                width = this.f7090b;
                i2 = this.f7090b + view.getWidth();
            } else {
                width = this.f7090b - view.getWidth();
                i2 = this.f7090b;
            }
            return Math.min(Math.max(width, i), i2);
        }

        public final int m10204c(View view, int i) {
            return view.getTop();
        }

        public final void m10199a(View view, int i) {
            float width = ((float) this.f7090b) + (((float) view.getWidth()) * this.f7089a.f7064h);
            float width2 = ((float) this.f7090b) + (((float) view.getWidth()) * this.f7089a.f7065i);
            if (((float) i) <= width) {
                ViewCompat.c(view, 1.0f);
            } else if (((float) i) >= width2) {
                ViewCompat.c(view, 0.0f);
            } else {
                ViewCompat.c(view, SwipeDismissBehavior.m10165c(0.0f, 1.0f - ((((float) i) - width) / (width2 - width)), 1.0f));
            }
        }
    }

    /* compiled from: publishPost */
    class SettleRunnable implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f7091a;
        private final View f7092b;
        private final boolean f7093c;

        SettleRunnable(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f7091a = swipeDismissBehavior;
            this.f7092b = view;
            this.f7093c = z;
        }

        public void run() {
            if (this.f7091a.f7057a != null && this.f7091a.f7057a.a(true)) {
                ViewCompat.a(this.f7092b, this);
            } else if (this.f7093c && this.f7091a.f7058b != null) {
                this.f7091a.f7058b.mo876a();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: publishPost */
    @interface SwipeDirection {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (MotionEventCompat.a(motionEvent)) {
            case 1:
            case 3:
                if (this.f7059c) {
                    this.f7059c = false;
                    return false;
                }
                break;
            default:
                boolean z;
                if (coordinatorLayout.m10125a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    z = false;
                } else {
                    z = true;
                }
                this.f7059c = z;
                break;
        }
        if (this.f7059c) {
            return false;
        }
        if (this.f7057a == null) {
            this.f7057a = this.f7061e ? ViewDragHelper.a(coordinatorLayout, this.f7060d, this.f7066j) : ViewDragHelper.a(coordinatorLayout, this.f7066j);
        }
        return this.f7057a.a(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f7057a == null) {
            return false;
        }
        this.f7057a.b(motionEvent);
        return true;
    }

    public boolean mo880a(@NonNull View view) {
        return true;
    }

    public static float m10165c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }
}

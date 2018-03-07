package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import com.facebook.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* compiled from: push_notifications_tray */
public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    public int f6897a;
    public int f6898b;
    public int f6899c;
    private int f6900d = 4;
    public ViewDragHelper f6901e;
    private boolean f6902f;
    private int f6903g;
    public int f6904h;
    private WeakReference<V> f6905i;
    private final Callback f6906j = new C03931(this);

    /* compiled from: push_notifications_tray */
    class C03931 extends Callback {
        final /* synthetic */ BottomSheetBehavior f6892a;

        C03931(BottomSheetBehavior bottomSheetBehavior) {
            this.f6892a = bottomSheetBehavior;
        }

        public final boolean m10033a(View view) {
            return true;
        }

        public final void m10031a(int i) {
            if (i == 1) {
                BottomSheetBehavior.m10036b(this.f6892a, 1);
            }
        }

        public final void m10032a(View view, float f, float f2) {
            int i;
            int i2;
            if (f2 < 0.0f) {
                i = this.f6892a.f6898b;
                i2 = 3;
            } else {
                i = this.f6892a.f6899c;
                i2 = 4;
            }
            BottomSheetBehavior.m10036b(this.f6892a, 2);
            if (this.f6892a.f6901e.a(view.getLeft(), i)) {
                ViewCompat.a(view, new SettleRunnable(this.f6892a, view, i2));
            }
        }

        public final int m10035c(View view, int i) {
            return MathUtils.m10148a(i, this.f6892a.f6898b, this.f6892a.f6899c);
        }

        public final int m10034b(View view, int i) {
            return view.getLeft();
        }
    }

    /* compiled from: push_notifications_tray */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C03941();
        final int f6893a;

        /* compiled from: push_notifications_tray */
        final class C03941 implements Creator<SavedState> {
            C03941() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f6893a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f6893a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6893a);
        }
    }

    /* compiled from: push_notifications_tray */
    class SettleRunnable implements Runnable {
        final /* synthetic */ BottomSheetBehavior f6894a;
        private final View f6895b;
        private final int f6896c;

        SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f6894a = bottomSheetBehavior;
            this.f6895b = view;
            this.f6896c = i;
        }

        public void run() {
            if (this.f6894a.f6901e == null || !this.f6894a.f6901e.a(true)) {
                BottomSheetBehavior.m10036b(this.f6894a, this.f6896c);
            } else {
                ViewCompat.a(this.f6895b, this);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: push_notifications_tray */
    public @interface State {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Params);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6897a = Math.max(0, dimensionPixelSize);
        this.f6899c = this.f6904h - dimensionPixelSize;
        obtainStyledAttributes.recycle();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.f6900d);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        this.f6900d = savedState.f6893a;
        if (this.f6900d == 1 || this.f6900d == 2) {
            this.f6900d = 4;
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m10122a((View) v, i);
        this.f6904h = coordinatorLayout.getHeight();
        this.f6898b = Math.max(0, this.f6904h - v.getHeight());
        this.f6899c = this.f6904h - this.f6897a;
        if (this.f6900d == 3) {
            ViewCompat.g(v, this.f6898b);
        } else {
            ViewCompat.g(v, this.f6899c);
            this.f6900d = 4;
        }
        if (this.f6901e == null) {
            this.f6901e = ViewDragHelper.a(coordinatorLayout, this.f6906j);
        }
        this.f6905i = new WeakReference(v);
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (MotionEventCompat.a(motionEvent)) {
            case 0:
                this.f6902f = !coordinatorLayout.m10125a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
            case 1:
            case 3:
                if (this.f6902f) {
                    this.f6902f = false;
                    return false;
                }
                break;
        }
        if (this.f6902f || !this.f6901e.a(motionEvent)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        this.f6901e.b(motionEvent);
        return true;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f6903g = 0;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        int top = v.getTop();
        int i3 = top - i2;
        if (i2 > 0) {
            if (i3 < this.f6898b) {
                iArr[1] = top - this.f6898b;
                v.offsetTopAndBottom(-iArr[1]);
                m10036b(this, 3);
            } else {
                iArr[1] = i2;
                v.offsetTopAndBottom(-i2);
                m10036b(this, 1);
            }
        } else if (i2 < 0 && !ViewCompat.b(view, -1)) {
            if (i3 > this.f6899c) {
                iArr[1] = top - this.f6899c;
                v.offsetTopAndBottom(-iArr[1]);
                m10036b(this, 4);
            } else {
                iArr[1] = i2;
                v.offsetTopAndBottom(-i2);
                m10036b(this, 1);
            }
        }
        this.f6903g = i2;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        if (this.f6903g != 0 && v.getTop() != this.f6898b) {
            int i;
            int i2;
            if (this.f6903g > 0) {
                i = this.f6898b;
                i2 = 3;
            } else {
                i = this.f6899c;
                i2 = 4;
            }
            m10036b(this, 2);
            if (this.f6901e.a(v, v.getLeft(), i)) {
                ViewCompat.a(v, new SettleRunnable(this, v, i2));
            }
        }
    }

    public static void m10036b(BottomSheetBehavior bottomSheetBehavior, int i) {
        if (bottomSheetBehavior.f6900d != i) {
            bottomSheetBehavior.f6900d = i;
        }
    }
}

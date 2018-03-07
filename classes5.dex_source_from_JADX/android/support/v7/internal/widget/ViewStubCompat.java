package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R;
import java.lang.ref.WeakReference;

/* compiled from: uiZoomGestures */
public final class ViewStubCompat extends View {
    public int f1255a;
    private int f1256b;
    private WeakReference<View> f1257c;
    public LayoutInflater f1258d;
    private OnInflateListener f1259e;

    /* compiled from: uiZoomGestures */
    public interface OnInflateListener {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1255a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, i, 0);
        this.f1256b = obtainStyledAttributes.getResourceId(2, -1);
        this.f1255a = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final int getInflatedId() {
        return this.f1256b;
    }

    public final void setInflatedId(int i) {
        this.f1256b = i;
    }

    public final int getLayoutResource() {
        return this.f1255a;
    }

    public final void setLayoutResource(int i) {
        this.f1255a = i;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1258d = layoutInflater;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.f1258d;
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final void draw(Canvas canvas) {
    }

    protected final void dispatchDraw(Canvas canvas) {
    }

    public final void setVisibility(int i) {
        if (this.f1257c != null) {
            View view = (View) this.f1257c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m1752a();
        }
    }

    public final View m1752a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1255a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f1258d != null) {
                layoutInflater = this.f1258d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1255a, viewGroup, false);
            if (this.f1256b != -1) {
                inflate.setId(this.f1256b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1257c = new WeakReference(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public final void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f1259e = onInflateListener;
    }
}

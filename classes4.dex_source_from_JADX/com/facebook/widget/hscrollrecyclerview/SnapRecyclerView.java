package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.R;
import com.google.common.base.Preconditions;

/* compiled from: direction */
public class SnapRecyclerView extends RecyclerView implements OnTouchListener {
    private int f13805h = 0;
    private boolean f13806i = true;
    protected boolean f13807j = true;
    public int f13808k = 0;
    protected int f13809l;
    private boolean f13810m = false;
    public LinearLayoutManager f13811n;
    public SnapDelegate f13812o;

    /* compiled from: direction */
    public interface SnapDelegate {
        int mo989f(int i);
    }

    public SnapRecyclerView(Context context) {
        super(context);
        m14571a(context, null);
    }

    public SnapRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14571a(context, attributeSet);
    }

    public SnapRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14571a(context, attributeSet);
    }

    private void m14571a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HScrollRecyclerView);
            this.f13807j = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
        setOnTouchListener(this.f13807j ? this : null);
        this.f13809l = (int) context.getResources().getDimension(2131430345);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        Preconditions.checkArgument(layoutManager instanceof LinearLayoutManager, "SnapRecyclerView only supports LinearLayoutManager");
        super.setLayoutManager(layoutManager);
        this.f13811n = (LinearLayoutManager) layoutManager;
    }

    public int getCurrentPosition() {
        return this.f13808k;
    }

    public final void m14575a(Direction direction) {
        mo988b(m14570a(this.f13808k, direction), true);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.f13810m) {
                mo988b(mo989f(rawX), true);
            }
            this.f13806i = true;
            this.f13810m = false;
            return true;
        } else if (actionMasked != 0 && actionMasked != 5 && (!this.f13806i || actionMasked != 2)) {
            return false;
        } else {
            this.f13805h = rawX;
            if (this.f13806i) {
                this.f13806i = false;
            }
            this.f13810m = true;
            return false;
        }
    }

    public final boolean m14577l() {
        return this.f13807j;
    }

    private int mo989f(int i) {
        int i2 = this.f13805h - i;
        int f = this.f13812o.mo989f(i2);
        if (i2 > this.f13809l) {
            return getLayoutDirection() == 1 ? mo991h(this.f13808k, f) : mo990g(this.f13808k, f);
        } else {
            if (i2 < (-this.f13809l)) {
                return getLayoutDirection() == 1 ? mo990g(this.f13808k, f) : mo991h(this.f13808k, f);
            } else {
                return this.f13808k;
            }
        }
    }

    private int m14570a(int i, Direction direction) {
        switch (1.a[direction.ordinal()]) {
            case 1:
                return mo990g(i, 1);
            case 2:
                return mo991h(i, 1);
            default:
                return 0;
        }
    }

    private int mo990g(int i, int i2) {
        int i3;
        int i4 = i + i2;
        Adapter adapter = this.o;
        if (adapter == null) {
            i3 = 0;
        } else {
            i3 = adapter.aZ_();
        }
        return Math.min(i4, i3 - 1);
    }

    private static int mo991h(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    protected void mo988b(int i, boolean z) {
        if (this.o != null) {
            this.f13808k = i;
            if (z) {
                b(i);
            } else {
                a(i);
            }
        }
    }
}

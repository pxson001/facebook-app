package com.facebook.events.tickets.modal.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: application_version */
public class EventTicketingLinearLayout extends CustomLinearLayout {
    protected EventDrawDividerUtil f19349b;

    /* compiled from: application_version */
    class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public boolean f19368a = false;
        public boolean f19369b = false;
        public int f19370c = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EventBuyTicketViewBlock_Layout);
            this.f19368a = obtainStyledAttributes.getBoolean(0, this.f19368a);
            this.f19369b = obtainStyledAttributes.getBoolean(1, this.f19369b);
            this.f19370c = obtainStyledAttributes.getDimensionPixelSize(2, this.f19370c);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        private boolean m19518a() {
            return this.f19369b || this.f19368a;
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m19503b();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m25610generateDefaultLayoutParams() {
        return m19503b();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m19500a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m19501a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m25611generateLayoutParams(AttributeSet attributeSet) {
        return m19500a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m25612generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m19501a(layoutParams);
    }

    public EventTicketingLinearLayout(Context context) {
        super(context);
        m19502a();
    }

    public EventTicketingLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19502a();
    }

    public EventTicketingLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19502a();
    }

    private void m19502a() {
        setOrientation(1);
        setWillNotDraw(false);
        this.f19349b = new EventDrawDividerUtil(getContext().getResources());
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.m19518a()) {
            return drawChild;
        }
        canvas.save(2);
        Rect clipBounds = canvas.getClipBounds();
        canvas.clipRect(clipBounds.left + layoutParams.f19370c, clipBounds.top, clipBounds.right - layoutParams.f19370c, clipBounds.bottom);
        if (layoutParams.f19368a) {
            this.f19349b.a(canvas, view.getY());
        }
        if (layoutParams.f19369b) {
            this.f19349b.a(canvas, view.getY() + ((float) view.getHeight()));
        }
        canvas.restore();
        return drawChild;
    }

    private static LayoutParams m19503b() {
        return new LayoutParams(-1, -2);
    }

    private LayoutParams m19500a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams m19501a(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}

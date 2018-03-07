package com.facebook.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;

/* compiled from: thread_queue_enabled */
public final class PaddingNode extends NodeGroup {
    private int f3138a;
    private int f3139b;
    private int f3140f;
    private int f3141g;

    public PaddingNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PaddingNode, i, i2);
        if (obtainStyledAttributes.hasValue(0)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f3138a = dimensionPixelSize;
            this.f3139b = dimensionPixelSize;
            this.f3140f = dimensionPixelSize;
            this.f3141g = dimensionPixelSize;
        } else {
            this.f3138a = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f3139b = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.f3140f = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f3141g = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        }
        obtainStyledAttributes.recycle();
    }

    public final void mo190a(Node node) {
        if (m4126y() > 0) {
            throw new IllegalStateException("PaddingNode can host only one direct child");
        }
        super.mo190a(node);
    }

    public final void mo191a(Node node, LayoutParams layoutParams) {
        if (m4126y() > 0) {
            throw new IllegalStateException("PaddingNode can host only one direct child");
        }
        super.mo191a(node, layoutParams);
    }

    protected final void mo184a(int i, int i2) {
        if (m4126y() == 0) {
            m4091c(this.f3138a + this.f3140f, this.f3139b + this.f3141g);
            return;
        }
        Node node = (Node) this.f3093e.get(0);
        LayoutParams layoutParams = node.f3075f;
        node.m4089b(ViewGroup.getChildMeasureSpec(i, this.f3138a + this.f3140f, layoutParams.width), ViewGroup.getChildMeasureSpec(i2, this.f3139b + this.f3141g, layoutParams.height));
        m4091c((this.f3138a + node.f3089t) + this.f3140f, (node.f3090u + this.f3139b) + this.f3141g);
    }

    protected final void mo185a(int i, int i2, int i3, int i4) {
        if (m4126y() > 0) {
            ((Node) this.f3093e.get(0)).m4086b(this.f3138a + i, this.f3139b + i2, i3 - this.f3140f, i4 - this.f3141g);
        }
    }
}

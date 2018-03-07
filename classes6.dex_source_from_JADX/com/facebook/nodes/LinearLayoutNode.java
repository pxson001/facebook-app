package com.facebook.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.R;

/* compiled from: ticket_price_details */
public abstract class LinearLayoutNode extends NodeGroup {
    protected int f3095a;
    public int f3096b = 8388659;

    protected final LayoutParams mo182a() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    protected LinearLayoutNode() {
    }

    protected LinearLayoutNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutNode, i, i2);
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            int i4;
            if ((8388615 & i3) == 0) {
                i4 = 8388611 | i3;
            } else {
                i4 = i3;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            if (this.f3096b != i4) {
                this.f3096b = i4;
                m4107s();
            }
        }
        mo186a(obtainStyledAttributes.getBoolean(1, false));
        obtainStyledAttributes.recycle();
    }

    public void mo186a(boolean z) {
    }

    public final /* synthetic */ LayoutParams mo183a(Context context, AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(context, attributeSet);
    }
}

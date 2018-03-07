package com.facebook.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import com.facebook.R;

/* compiled from: thread_admins */
public class ViewStubNode extends Node {
    private Context f3180a;
    private int f3181b;
    @LayoutRes
    private int f3182e;

    public ViewStubNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubNode, i, i2);
        this.f3182e = obtainStyledAttributes.getResourceId(0, 0);
        this.f3181b = obtainStyledAttributes.getResourceId(1, -1);
        this.f3180a = context;
        obtainStyledAttributes.recycle();
    }
}

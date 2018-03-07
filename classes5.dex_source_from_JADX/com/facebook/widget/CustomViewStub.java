package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.R;
import com.facebook.inject.FbInjector;

/* compiled from: com.google.android.gms.signin.internal.offlineAccessRequested */
public abstract class CustomViewStub extends View {
    protected Context f5603a;
    private int f5604b = -1;
    private FbInjector f5605c;

    protected abstract View getInflatedLayout();

    public CustomViewStub(Context context) {
        super(context);
        m10405a(context, null);
    }

    public CustomViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10405a(context, attributeSet);
    }

    public CustomViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10405a(context, attributeSet);
    }

    private final void m10405a(Context context, AttributeSet attributeSet) {
        this.f5603a = context;
        this.f5605c = FbInjector.get(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomViewStub);
            this.f5604b = obtainStyledAttributes.getResourceId(0, this.f5604b);
            obtainStyledAttributes.recycle();
        }
    }

    @Deprecated
    protected FbInjector getInjector() {
        return this.f5605c;
    }

    public View m10406a() {
        ViewParent parent = getParent();
        if (parent == null) {
            throw new IllegalStateException("CustomViewStub has no parent. The view could have been already inflated.");
        } else if (parent instanceof ViewGroup) {
            View inflatedLayout = getInflatedLayout();
            if (inflatedLayout == null) {
                throw new IllegalStateException("CustomViewStub.getInflatedLayout returned null");
            }
            LayoutParams layoutParams;
            inflatedLayout.setId(this.f5604b);
            int indexOfChild = ((ViewGroup) parent).indexOfChild(this);
            if (getLayoutParams() != null) {
                layoutParams = getLayoutParams();
            } else {
                layoutParams = new LayoutParams(-2, -2);
            }
            ((ViewGroup) parent).removeViewAt(indexOfChild);
            if ((parent instanceof FbCustomViewGroup) && (inflatedLayout instanceof RecyclableView)) {
                ((FbCustomViewGroup) parent).attachRecyclableViewToParent(inflatedLayout, indexOfChild, layoutParams);
            } else {
                ((ViewGroup) parent).addView(inflatedLayout, indexOfChild, layoutParams);
            }
            return inflatedLayout;
        } else {
            throw new IllegalStateException("CustomViewStub is in an invalid parent");
        }
    }
}

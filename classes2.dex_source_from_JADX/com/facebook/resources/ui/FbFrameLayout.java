package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: nux_ver_completed */
public class FbFrameLayout extends FrameLayout {
    public FbFrameLayout(Context context) {
        super(context);
    }

    public FbFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16958a(context, attributeSet);
    }

    public FbFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16958a(context, attributeSet);
    }

    private void m16958a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbFrameLayout);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setContentDescription(context.getText(resourceId));
        }
        obtainStyledAttributes.recycle();
    }
}

package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: free_count */
public class FbButton extends Button {
    public FbButton(Context context) {
        super(context);
    }

    public FbButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m31391a(context, attributeSet);
    }

    public FbButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31391a(context, attributeSet);
    }

    private void m31391a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbButton);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            setContentDescription(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setHint(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            setImeActionLabel(context.getText(resourceId), getImeActionId());
        }
        resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setText(context.getText(resourceId));
        }
        obtainStyledAttributes.recycle();
    }
}

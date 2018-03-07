package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: silent_login */
public class FbResourcesTextView extends TextView {
    public FbResourcesTextView(Context context) {
        super(context);
    }

    public FbResourcesTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m8580a(context, attributeSet);
    }

    public FbResourcesTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8580a(context, attributeSet);
    }

    private void m8580a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbResourcesTextView);
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

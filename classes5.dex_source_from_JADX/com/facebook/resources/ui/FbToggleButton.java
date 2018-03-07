package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: contact_importer */
public class FbToggleButton extends ToggleButton {
    public FbToggleButton(Context context) {
        super(context);
    }

    public FbToggleButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10170a(context, attributeSet);
    }

    public FbToggleButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10170a(context, attributeSet);
    }

    private void m10170a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbToggleButton);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            setContentDescription(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            setHint(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            setImeActionLabel(context.getText(resourceId), getImeActionId());
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            setText(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setTextOff(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setTextOn(context.getText(resourceId));
        }
        obtainStyledAttributes.recycle();
    }
}

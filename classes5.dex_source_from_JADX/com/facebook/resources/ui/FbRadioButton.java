package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: contact_suggest_friend */
public class FbRadioButton extends RadioButton {
    public FbRadioButton(Context context) {
        super(context);
    }

    public FbRadioButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10168a(context, attributeSet);
    }

    public FbRadioButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10168a(context, attributeSet);
    }

    private void m10168a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbRadioButton);
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

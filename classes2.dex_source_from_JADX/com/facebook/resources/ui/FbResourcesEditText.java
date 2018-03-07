package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: report_sticky_guardrail_action */
public class FbResourcesEditText extends EditText {
    public FbResourcesEditText(Context context) {
        super(context);
    }

    public FbResourcesEditText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m12081a(context, attributeSet);
    }

    public FbResourcesEditText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12081a(context, attributeSet);
    }

    private void m12081a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbResourcesEditText);
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

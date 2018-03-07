package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: top_level_comments */
public class FbResourcesAutoCompleteTextView extends AutoCompleteTextView {
    public FbResourcesAutoCompleteTextView(Context context) {
        super(context);
    }

    public FbResourcesAutoCompleteTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1238a(context, attributeSet);
    }

    public FbResourcesAutoCompleteTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1238a(context, attributeSet);
    }

    private void m1238a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbResourcesAutoCompleteTextView);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            setCompletionHint(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            setContentDescription(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setHint(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(3, 0);
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

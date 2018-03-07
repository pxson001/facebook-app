package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: contact_upload_session_type */
public class FbCheckedTextView extends CheckedTextView {
    public FbCheckedTextView(Context context) {
        super(context);
    }

    public FbCheckedTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10166a(context, attributeSet);
    }

    public FbCheckedTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10166a(context, attributeSet);
    }

    private void m10166a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbCheckedTextView);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            setHint(context.getText(resourceId));
        }
        resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setText(context.getText(resourceId));
        }
        obtainStyledAttributes.recycle();
    }
}

package com.facebook.iorg.common.upsell;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.R;

/* compiled from: mCheckinLocationName */
public class IorgTextView extends TextView {
    public IorgTextView(Context context) {
        super(context);
    }

    public IorgTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18121a(context, attributeSet);
    }

    public IorgTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18121a(context, attributeSet);
    }

    private void m18121a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IorgTextView);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            setText(context.getText(resourceId));
        }
    }
}

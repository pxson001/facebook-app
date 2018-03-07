package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: contact_suggest_friend_notif */
public class FbImageButton extends ImageButton {
    public FbImageButton(Context context) {
        super(context);
    }

    public FbImageButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10167a(context, attributeSet);
    }

    public FbImageButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10167a(context, attributeSet);
    }

    private void m10167a(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FbImageButton);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            setContentDescription(context.getText(resourceId));
        }
        obtainStyledAttributes.recycle();
    }
}

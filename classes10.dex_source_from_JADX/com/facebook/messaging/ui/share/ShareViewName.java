package com.facebook.messaging.ui.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import com.facebook.messaging.ui.text.MultilineEllipsizeTextView;

/* compiled from: pinned_status */
public class ShareViewName extends MultilineEllipsizeTextView {
    public ShareViewName(Context context) {
        super(context);
        setMaxLines(2);
    }

    public ShareViewName(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxLines(2);
    }

    public ShareViewName(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMaxLines(2);
    }

    protected void drawableStateChanged() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ShareView) {
                ((ShareView) parent).m4411a();
            }
        }
    }
}

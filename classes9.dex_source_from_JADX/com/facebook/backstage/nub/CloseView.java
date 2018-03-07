package com.facebook.backstage.nub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: requestRouteToHost */
public class CloseView extends FrameLayout {
    public CloseView(Context context) {
        this(context, null);
    }

    private CloseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, 2130903581, this);
        setBackgroundResource(2130838338);
    }
}

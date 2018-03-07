package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import javax.annotation.Nullable;

/* compiled from: borderTopColor */
public class FacecastEndingBlankScreenPlugin extends FacecastBasePlugin {
    public FacecastEndingBlankScreenPlugin(Context context) {
        this(context, null);
    }

    private FacecastEndingBlankScreenPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastEndingBlankScreenPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View view = new View(context);
        view.setBackgroundResource(2131363603);
        addView(view);
    }
}

package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;

/* compiled from: THREADED */
public class PollOptionTextViewWithProgressBar extends FbTextView {
    public PollOptionTextViewWithProgressBar(Context context) {
        super(context);
    }

    public PollOptionTextViewWithProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PollOptionTextViewWithProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public synchronized void setProgress(float f) {
        if (getBackground() instanceof LayerDrawable) {
            Drawable findDrawableByLayerId = ((LayerDrawable) getBackground()).findDrawableByLayerId(2131568594);
            if (findDrawableByLayerId != null && (findDrawableByLayerId instanceof ClipDrawable)) {
                findDrawableByLayerId.setLevel((int) (10000.0f * f));
                drawableStateChanged();
            }
        }
    }
}

package com.facebook.backstage.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/* compiled from: remove_audience_targeting_sentences */
public class VideoRecordingProgressBar extends LinearLayout {
    private final ProgressBar f5520a;
    private final ProgressBar f5521b;

    public VideoRecordingProgressBar(Context context) {
        this(context, null);
    }

    public VideoRecordingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoRecordingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, 2130907700, this);
        this.f5520a = (ProgressBar) findViewById(2131568386);
        this.f5521b = (ProgressBar) findViewById(2131568387);
    }

    public void setProgress(int i) {
        this.f5520a.setProgress(i);
        this.f5521b.setProgress(i);
    }

    public void setMax(int i) {
        this.f5520a.setMax(i);
        this.f5521b.setMax(i);
    }
}

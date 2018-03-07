package com.facebook.reportaproblem.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* compiled from: setPrivacyEducationState */
public class BugReportImageThumbnail extends FrameLayout {
    public ImageView f4599a;
    public ImageView f4600b;

    public BugReportImageThumbnail(Context context) {
        this(context, null, 0);
    }

    private BugReportImageThumbnail(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(getContext(), 2130903453, this);
        this.f4599a = (ImageView) findViewById(2131560057);
        this.f4600b = (ImageView) findViewById(2131560058);
    }
}

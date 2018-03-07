package com.facebook.backstage.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: replace_synced_tab_with_moments_tab */
public class MediaView extends FrameLayout {
    private final PhotoView f5484a;
    private final BackstageRichVideoView f5485b;

    public MediaView(Context context) {
        this(context, null);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, 2130905195, this);
        this.f5484a = (PhotoView) findViewById(2131563761);
        this.f5485b = (BackstageRichVideoView) findViewById(2131563762);
    }

    public final void m5719a(Bitmap bitmap, int i, boolean z) {
        this.f5484a.m5727a(bitmap, i, z);
        this.f5484a.setVisibility(0);
        this.f5485b.setVisibility(8);
    }

    public final void setVideo$44bdce70(String str) {
        this.f5485b.m5711b(str, null);
        this.f5484a.setVisibility(8);
        this.f5485b.setVisibility(0);
        this.f5485b.m5712t();
    }

    public final void m5718a() {
        this.f5484a.setVisibility(8);
        this.f5485b.setVisibility(8);
        this.f5484a.m5726a();
        this.f5485b.m5709a();
    }
}

package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.richdocument.model.block.VideoSeekBarAnnotation;
import com.facebook.richdocument.view.widget.AnnotationView;

/* compiled from: null url from entity with id  */
public class VideoSeekBarView extends LinearLayout implements AnnotationView<VideoSeekBarAnnotation> {
    public final VideoSeekBarAnnotation f7767a;

    public VideoSeekBarView(Context context) {
        this(context, null);
    }

    public VideoSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSeekBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7767a = new VideoSeekBarAnnotation();
    }

    public VideoSeekBarAnnotation getAnnotation() {
        return this.f7767a;
    }

    public final View mo438b() {
        return this;
    }

    public void setIsOverlay(boolean z) {
    }

    public final boolean mo439c() {
        return false;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getChildAt(0).getMeasuredHeight());
    }
}

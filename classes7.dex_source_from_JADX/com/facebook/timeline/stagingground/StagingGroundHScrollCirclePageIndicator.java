package com.facebook.timeline.stagingground;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;

/* compiled from: fast_hash */
public class StagingGroundHScrollCirclePageIndicator extends SwipeableFramesHScrollCirclePageIndicator {
    private Paint f14745a;

    public StagingGroundHScrollCirclePageIndicator(Context context) {
        super(context);
        m18665b();
    }

    public StagingGroundHScrollCirclePageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18665b();
    }

    private void m18665b() {
        this.f14745a = new Paint(1);
        this.f14745a.setColor(ContextCompat.b(getContext(), 2131361937));
        this.f14745a.setStrokeWidth(1.0f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, (float) getHeight(), (float) getWidth(), (float) getHeight(), this.f14745a);
    }
}

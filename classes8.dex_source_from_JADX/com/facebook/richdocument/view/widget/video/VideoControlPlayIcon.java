package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.richdocument.view.widget.InchwormAnimatedView;

/* compiled from: nullstate_image_mdpi */
public class VideoControlPlayIcon extends VideoControlIcon {
    public VideoControlPlayIcon(Context context) {
        this(context, null);
    }

    public VideoControlPlayIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public VideoControlPlayIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final Path mo446a(RectF rectF) {
        RectF a = InchwormAnimatedView.m7423a(rectF, 0.85294116f);
        float f = (this.f7113d + ((float) this.f7110a)) + (this.f7112c / 2.0f);
        float f2 = a.left + f;
        float f3 = a.top + f;
        float f4 = a.right - f;
        float f5 = a.bottom - f;
        f = f4 - f2;
        f5 -= f3;
        PointF pointF = new PointF(f2, f3);
        PointF pointF2 = new PointF(f + pointF.x, pointF.y + (f5 / 2.0f));
        PointF pointF3 = new PointF(pointF.x, f5 + pointF.y);
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.lineTo(pointF3.x, pointF3.y);
        path.lineTo(pointF.x, pointF.y);
        path.close();
        return path;
    }
}

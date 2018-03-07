package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.richdocument.view.widget.InchwormAnimatedView;

/* compiled from: nullstate_image_xhdpi */
public class VideoControlPauseIcon extends VideoControlIcon {
    public VideoControlPauseIcon(Context context) {
        this(context, null);
    }

    public VideoControlPauseIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public VideoControlPauseIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final Path mo446a(RectF rectF) {
        RectF a = InchwormAnimatedView.m7423a(rectF, 0.8f);
        float width = 0.4f * ((a.width() - (this.f7113d * 2.0f)) - ((float) (this.f7110a * 2)));
        float f = (this.f7113d + ((float) this.f7110a)) + (this.f7112c / 2.0f);
        float f2 = a.left + f;
        float f3 = a.top + f;
        float f4 = (f2 + width) - this.f7112c;
        float f5 = a.bottom - f;
        f = f4 - f2;
        f5 -= f3;
        PointF pointF = new PointF(f2, f3);
        PointF pointF2 = new PointF(pointF.x + f, pointF.y);
        PointF pointF3 = new PointF(f + pointF.x, pointF.y + f5);
        PointF pointF4 = new PointF(pointF.x, pointF.y + f5);
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.lineTo(pointF3.x, pointF3.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.lineTo(pointF.x, pointF.y);
        f = ((width / 2.0f) + f4) + this.f7112c;
        width = ((width + f) - this.f7112c) - f;
        pointF2 = new PointF(f, f3);
        pointF4 = new PointF(pointF2.x + width, pointF2.y);
        PointF pointF5 = new PointF(width + pointF2.x, pointF2.y + f5);
        PointF pointF6 = new PointF(pointF2.x, f5 + pointF2.y);
        path.moveTo(pointF2.x, pointF2.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.lineTo(pointF5.x, pointF5.y);
        path.lineTo(pointF6.x, pointF6.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.close();
        return path;
    }

    public void setLoading(boolean z) {
    }
}

package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.richdocument.model.block.ImageLoadingIndicatorAnnotation;

/* compiled from: open_page_child_locations */
public class CircularIndeterminateLoadingIndicator extends InchwormAnimatedView implements AnnotationView<ImageLoadingIndicatorAnnotation> {
    public ImageLoadingIndicatorAnnotation f7136e;

    public CircularIndeterminateLoadingIndicator(Context context) {
        this(context, null);
    }

    public CircularIndeterminateLoadingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularIndeterminateLoadingIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7136e = new ImageLoadingIndicatorAnnotation();
    }

    protected final Path mo446a(RectF rectF) {
        RectF a = InchwormAnimatedView.m7423a(rectF, 1.0f);
        float f = (this.f7113d + ((float) this.f7110a)) + (this.f7112c / 2.0f);
        float f2 = a.left + f;
        float f3 = a.top + f;
        float f4 = a.right - f;
        float f5 = a.bottom - f;
        f = f4 - f2;
        f2 += f / 2.0f;
        f5 = ((f5 - f3) / 2.0f) + f3;
        Path path = new Path();
        path.addCircle(f2, f5, f / 2.1f, Direction.CW);
        return path;
    }

    public ImageLoadingIndicatorAnnotation getAnnotation() {
        return this.f7136e;
    }

    public final View mo438b() {
        return this;
    }

    public void setIsOverlay(boolean z) {
    }

    public final boolean mo439c() {
        return false;
    }
}

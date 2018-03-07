package com.facebook.groups.widget.header;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: production_prompt_share */
public class ParallaxDraweeView extends FbDraweeView {
    float f5990c;

    public ParallaxDraweeView(Context context) {
        super(context);
    }

    public ParallaxDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParallaxDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCurrentTranslation(float f) {
        this.f5990c = f;
        invalidate();
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (-this.f5990c) / 2.0f);
        super.draw(canvas);
        canvas.restore();
    }
}

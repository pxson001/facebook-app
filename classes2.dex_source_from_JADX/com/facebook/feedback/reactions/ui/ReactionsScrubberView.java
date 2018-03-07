package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: gift_link */
public class ReactionsScrubberView extends View {
    private final Drawable f22349a;
    private float f22350b;

    public ReactionsScrubberView(Context context) {
        this(context, null);
    }

    public ReactionsScrubberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReactionsScrubberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22349a = getResources().getDrawable(2130842948);
        this.f22349a.setBounds(0, 0, this.f22349a.getIntrinsicWidth(), this.f22349a.getIntrinsicHeight());
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f22350b = ((float) (getMeasuredWidth() - (this.f22349a.getIntrinsicWidth() * 10))) / 11.0f;
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f22350b, (((float) getHeight()) / 2.0f) - (((float) this.f22349a.getIntrinsicHeight()) / 2.0f));
        int intrinsicWidth = this.f22349a.getIntrinsicWidth();
        for (int i = 0; i < 10; i++) {
            this.f22349a.draw(canvas);
            canvas.translate(((float) intrinsicWidth) + this.f22350b, 0.0f);
        }
        canvas.restore();
    }
}

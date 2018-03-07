package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.facebook.widget.text.BetterTextView;

/* compiled from: VIDEOS_COUNT */
public class ScoreCardTextView extends BetterTextView {
    private Paint f21092a;

    public ScoreCardTextView(Context context) {
        super(context);
        m23968b();
    }

    public ScoreCardTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23968b();
    }

    public ScoreCardTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23968b();
    }

    private void m23968b() {
        this.f21092a = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int height2 = (getHeight() / 2) + 1;
        this.f21092a.setColor(-1);
        this.f21092a.setStyle(Style.FILL);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f21092a);
        this.f21092a.setColor(getResources().getColor(2131361939));
        this.f21092a.setStrokeWidth(2.0f);
        this.f21092a.setStyle(Style.STROKE);
        canvas.drawLine(0.0f, (float) height2, (float) width, (float) height2, this.f21092a);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f21092a);
        super.onDraw(canvas);
    }
}

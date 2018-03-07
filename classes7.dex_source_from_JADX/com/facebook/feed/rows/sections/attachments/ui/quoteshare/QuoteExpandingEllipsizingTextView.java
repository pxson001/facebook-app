package com.facebook.feed.rows.sections.attachments.ui.quoteshare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import com.facebook.resources.ui.ExpandingEllipsizingTextView;

/* compiled from: Upsell API Error */
public class QuoteExpandingEllipsizingTextView extends ExpandingEllipsizingTextView {
    private Paint f21111a;
    private int f21112b;
    private int f21113c;

    public QuoteExpandingEllipsizingTextView(Context context) {
        super(context);
        m23981a();
    }

    public QuoteExpandingEllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23981a();
    }

    public QuoteExpandingEllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23981a();
    }

    private void m23981a() {
        this.f21111a = new Paint();
        this.f21112b = getResources().getColor(2131362099);
        this.f21113c = getResources().getDimensionPixelSize(2131430413);
        setMaxLines(3);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        this.f21111a.setColor(this.f21112b);
        this.f21111a.setStyle(Style.FILL);
        canvas.drawRect(0.0f, 0.0f, (float) (this.f21113c + 0), (float) height, this.f21111a);
    }
}

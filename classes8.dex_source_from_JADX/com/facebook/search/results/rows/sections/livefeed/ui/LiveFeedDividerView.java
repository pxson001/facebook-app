package com.facebook.search.results.rows.sections.livefeed.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: Params cannot be null! */
public class LiveFeedDividerView extends View {
    private Paint f24557a;
    private int f24558b;

    public LiveFeedDividerView(Context context) {
        super(context);
        m28009a();
    }

    public LiveFeedDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28009a();
    }

    public LiveFeedDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28009a();
    }

    private void m28009a() {
        this.f24557a = new Paint();
        this.f24557a.setColor(getResources().getColor(2131362148));
        this.f24557a.setStrokeWidth((float) getResources().getDimensionPixelSize(2131431721));
        this.f24558b = getResources().getDimensionPixelSize(2131432586);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawLine((float) this.f24558b, 2.0f, (float) (getWidth() - this.f24558b), 2.0f, this.f24557a);
    }
}

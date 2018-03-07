package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: REACTION_PAGE_ERROR */
public class SearchResultsDividerView extends View {
    private Paint f24006a;

    public SearchResultsDividerView(Context context) {
        super(context);
        m27583a();
    }

    public SearchResultsDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27583a();
    }

    public SearchResultsDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27583a();
    }

    private void m27583a() {
        this.f24006a = new Paint();
        this.f24006a.setColor(getResources().getColor(2131361938));
        this.f24006a.setStrokeWidth((float) getResources().getDimensionPixelSize(2131432557));
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight() / 2;
        canvas.drawLine((float) getPaddingLeft(), (float) height, (float) (getWidth() - getPaddingRight()), (float) height, this.f24006a);
    }
}

package com.facebook.search.suggestions.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: viewed_fundraiser_share_attachment */
public class TypeaheadDividerView extends View {
    private Paint f344a;
    private int f345b;
    private int f346c;

    public TypeaheadDividerView(Context context) {
        super(context);
        m487a();
    }

    public TypeaheadDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m487a();
    }

    public TypeaheadDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m487a();
    }

    private void m487a() {
        this.f344a = new Paint();
        this.f344a.setColor(getResources().getColor(2131361940));
        this.f344a.setStrokeWidth((float) getResources().getDimensionPixelSize(2131431721));
        this.f345b = getResources().getDimensionPixelSize(2131431642);
        this.f346c = getResources().getDimensionPixelSize(2131431643);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawLine((float) this.f345b, (float) this.f346c, (float) (getWidth() - this.f345b), (float) this.f346c, this.f344a);
    }
}

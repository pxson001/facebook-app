package com.facebook.search.suggestions.viewbinder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: video_length_retreval_category */
public class RecentSearchSeeMoreView extends ImageView {
    private Paint f379a;
    private int f380b;

    public RecentSearchSeeMoreView(Context context) {
        super(context);
        m504a();
    }

    public RecentSearchSeeMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m504a();
    }

    public RecentSearchSeeMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m504a();
    }

    private void m504a() {
        this.f379a = new Paint();
        this.f379a.setColor(getResources().getColor(2131361940));
        this.f379a.setStrokeWidth((float) getResources().getDimensionPixelSize(2131431721));
        this.f380b = getResources().getDimensionPixelSize(2131431642);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine((float) this.f380b, 0.0f, (float) (getWidth() - this.f380b), 0.0f, this.f379a);
        canvas.drawLine((float) this.f380b, (float) (getHeight() - 1), (float) (getWidth() - this.f380b), (float) (getHeight() - 1), this.f379a);
    }
}

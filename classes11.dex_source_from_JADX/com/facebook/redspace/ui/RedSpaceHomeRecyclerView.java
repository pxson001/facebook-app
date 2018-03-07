package com.facebook.redspace.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: PRIVACY_REVIEW_WRITE_RETRY */
public class RedSpaceHomeRecyclerView extends BetterRecyclerView {
    private int f12343l = -1;
    private Paint f12344m;

    public RedSpaceHomeRecyclerView(Context context) {
        super(context);
        m12764o();
    }

    public RedSpaceHomeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12764o();
    }

    public RedSpaceHomeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12764o();
    }

    private void m12764o() {
        this.f12344m = new Paint();
        this.f12344m.setColor(getResources().getColor(2131363124));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = 0;
        while (i5 < getChildCount()) {
            i6 = Math.max(getChildAt(i5).getBottom(), i6);
            i5++;
        }
        if (i6 >= getHeight()) {
            this.f12343l = -1;
        } else {
            this.f12343l = i6;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12343l != -1) {
            canvas.drawRect(0.0f, (float) this.f12343l, (float) getWidth(), (float) getHeight(), this.f12344m);
        }
    }
}

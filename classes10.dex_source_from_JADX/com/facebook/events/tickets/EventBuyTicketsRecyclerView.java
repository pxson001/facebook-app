package com.facebook.events.tickets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.widget.recyclerview.BetterRecyclerView;

/* compiled from: attachment_data */
public class EventBuyTicketsRecyclerView extends BetterRecyclerView {
    private boolean f19173l;
    private Paint f19174m;

    public EventBuyTicketsRecyclerView(Context context) {
        super(context);
        m19354o();
    }

    public EventBuyTicketsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19354o();
    }

    public EventBuyTicketsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19354o();
    }

    private void m19354o() {
        this.f19173l = true;
        this.f19174m = new Paint(1);
        this.f19174m.setColor(getResources().getColor(2131361971));
    }

    public void setEnabled(boolean z) {
        this.f19173l = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f19173l || super.onInterceptTouchEvent(motionEvent);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.f19173l) {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f19174m);
        }
    }
}

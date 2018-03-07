package com.facebook.events.tickets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: attempt unexpected adapter type */
public class EventBuyTicketsQuantityButton extends CompoundButton {
    public int f19163a;

    public EventBuyTicketsQuantityButton(Context context) {
        super(context);
    }

    public EventBuyTicketsQuantityButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getQuantity() {
        return this.f19163a;
    }

    public void setQuantity(int i) {
        this.f19163a = i;
    }
}

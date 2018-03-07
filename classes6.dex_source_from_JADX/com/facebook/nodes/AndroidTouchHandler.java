package com.facebook.nodes;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

/* compiled from: ticket_uri */
public final class AndroidTouchHandler extends NodeTouchHandler {
    public OnTouchListener f3063a;
    public OnClickListener f3064b;

    public AndroidTouchHandler(OnTouchListener onTouchListener, OnClickListener onClickListener) {
        this.f3063a = onTouchListener;
        this.f3064b = onClickListener;
    }

    public final boolean mo175a(MotionEvent motionEvent, View view) {
        Object obj;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x < this.f3059a || x >= this.f3061c || y < this.f3060b || y >= this.f3062d) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return false;
        }
        if ((this.f3063a != null && this.f3063a.onTouch(view, motionEvent)) || this.f3064b == null || motionEvent.getAction() != 1) {
            return true;
        }
        this.f3064b.onClick(view);
        return true;
    }
}

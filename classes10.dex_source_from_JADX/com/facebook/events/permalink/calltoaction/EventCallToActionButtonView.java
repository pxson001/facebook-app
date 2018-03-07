package com.facebook.events.permalink.calltoaction;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: button1Url */
public class EventCallToActionButtonView extends CustomFrameLayout {
    private TextView f18276a;

    public EventCallToActionButtonView(Context context) {
        super(context);
        m18630a();
    }

    public EventCallToActionButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18630a();
    }

    public EventCallToActionButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18630a();
    }

    private void m18630a() {
        setContentView(2130904057);
        this.f18276a = (TextView) c(2131561345);
    }

    public TextView getCallToActionButtonView() {
        return this.f18276a;
    }
}

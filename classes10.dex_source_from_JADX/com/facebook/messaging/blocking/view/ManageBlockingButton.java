package com.facebook.messaging.blocking.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.titlebar.TintableTitleBarButton;

/* compiled from: thread_up_to_date */
public class ManageBlockingButton extends CustomFrameLayout implements TintableTitleBarButton {
    BetterTextView f1469a;

    public ManageBlockingButton(Context context) {
        super(context);
        m1465a();
    }

    public ManageBlockingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1465a();
    }

    public ManageBlockingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1465a();
    }

    private void m1465a() {
        setContentView(2130905158);
        this.f1469a = (BetterTextView) c(2131563659);
    }

    public void setButtonTintColor(int i) {
        this.f1469a.setTextColor(i);
    }
}

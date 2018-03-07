package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: fb4a_timeline_disk_cache_drop_table */
public class PaymentBubbleHeaderView extends CustomLinearLayout {
    private BetterTextView f14984a;

    private static <T extends View> void m15367a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m15368a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PaymentBubbleHeaderView(Context context) {
        super(context);
        m15366a();
    }

    public PaymentBubbleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15366a();
    }

    public PaymentBubbleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15366a();
    }

    private void m15366a() {
        m15367a(PaymentBubbleHeaderView.class, (View) this);
        setContentView(2130905808);
        this.f14984a = (BetterTextView) findViewById(2131565036);
    }

    public void setText(String str) {
        this.f14984a.setText(str);
    }
}

package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: favorited_topic_ids */
public class PaymentBubbleRecipientNameView extends CustomLinearLayout {
    private BetterTextView f14985a;

    private static <T extends View> void m15370a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m15371a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PaymentBubbleRecipientNameView(Context context) {
        super(context);
        m15369a();
    }

    public PaymentBubbleRecipientNameView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15369a();
    }

    protected PaymentBubbleRecipientNameView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15369a();
    }

    private void m15369a() {
        m15370a(PaymentBubbleRecipientNameView.class, (View) this);
        setContentView(2130905811);
        this.f14985a = (BetterTextView) a(2131565037);
    }

    public void setRecipientNameText(String str) {
        this.f14985a.setText(str);
    }
}

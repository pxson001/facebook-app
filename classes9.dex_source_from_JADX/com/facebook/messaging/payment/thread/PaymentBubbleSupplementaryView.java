package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: fallback_msite */
public class PaymentBubbleSupplementaryView extends CustomLinearLayout {
    private BetterTextView f14986a;
    private BetterTextView f14987b;

    private static <T extends View> void m15373a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m15374a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PaymentBubbleSupplementaryView(Context context) {
        super(context);
        m15372a();
    }

    public PaymentBubbleSupplementaryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15372a();
    }

    public PaymentBubbleSupplementaryView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15372a();
    }

    private void m15372a() {
        m15373a(PaymentBubbleSupplementaryView.class, (View) this);
        setContentView(2130905813);
        this.f14986a = (BetterTextView) a(2131564912);
        this.f14987b = (BetterTextView) a(2131565038);
    }

    public void setMessageText(int i) {
        this.f14986a.setText(i);
    }

    public void setMessageText(String str) {
        this.f14986a.setText(str);
    }

    public void setDrawableText(int i) {
        this.f14987b.setText(i);
    }

    public void setDrawableText(String str) {
        this.f14987b.setText(str);
    }

    public void setMessageTextVisibility(int i) {
        this.f14986a.setVisibility(i);
    }

    public void setDrawableTextVisibility(int i) {
        this.f14987b.setVisibility(i);
    }
}

package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: feeds_switcher_missing_fragment_builder */
public class PaymentBubbleActionButtonsView extends CustomLinearLayout {
    private BetterTextView f14971a;
    private BetterTextView f14972b;

    /* compiled from: feeds_switcher_missing_fragment_builder */
    public interface Listener {
        void mo602a();

        void mo603b();
    }

    private static <T extends View> void m15358a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m15359a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PaymentBubbleActionButtonsView(Context context) {
        super(context);
        m15357a();
    }

    public PaymentBubbleActionButtonsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15357a();
    }

    protected PaymentBubbleActionButtonsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15357a();
    }

    private void m15357a() {
        m15358a(PaymentBubbleActionButtonsView.class, (View) this);
        setContentView(2130905803);
        this.f14971a = (BetterTextView) a(2131565030);
        this.f14972b = (BetterTextView) a(2131565029);
    }

    public void setPrimaryActionText(int i) {
        this.f14971a.setText(i);
    }

    public void setSecondaryActionText(int i) {
        this.f14972b.setText(i);
    }

    public void setPrimaryActionVisibility(int i) {
        this.f14971a.setVisibility(i);
    }

    public void setSecondaryActionVisibility(int i) {
        this.f14972b.setVisibility(i);
    }

    public void setListener(final Listener listener) {
        this.f14971a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PaymentBubbleActionButtonsView f14968b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -420828592);
                listener.mo602a();
                Logger.a(2, EntryType.UI_INPUT_END, 1464195713, a);
            }
        });
        this.f14972b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PaymentBubbleActionButtonsView f14970b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1731056111);
                listener.mo603b();
                Logger.a(2, EntryType.UI_INPUT_END, -1080913842, a);
            }
        });
    }
}

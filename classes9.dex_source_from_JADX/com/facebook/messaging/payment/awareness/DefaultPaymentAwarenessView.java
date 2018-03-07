package com.facebook.messaging.payment.awareness;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.awareness.PaymentAwarenessFragment.C14411;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invite_button */
public class DefaultPaymentAwarenessView extends CustomLinearLayout implements PaymentAwarenessView {
    @Inject
    public GlyphColorizer f12781a;
    private final BetterTextView f12782b;
    private final BetterTextView f12783c;
    private final BetterTextView f12784d;
    private final BetterTextView f12785e;
    private final BetterTextView f12786f;
    private final BetterButton f12787g;
    private final ViewStubCompat f12788h;

    public static void m13139a(Object obj, Context context) {
        ((DefaultPaymentAwarenessView) obj).f12781a = GlyphColorizer.a(FbInjector.get(context));
    }

    public DefaultPaymentAwarenessView(Context context) {
        this(context, null);
    }

    private DefaultPaymentAwarenessView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DefaultPaymentAwarenessView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = DefaultPaymentAwarenessView.class;
        m13139a((Object) this, getContext());
        setContentView(2130903877);
        this.f12782b = (BetterTextView) a(2131558927);
        this.f12783c = (BetterTextView) a(2131558926);
        this.f12784d = (BetterTextView) a(2131560946);
        this.f12785e = (BetterTextView) a(2131560947);
        this.f12786f = (BetterTextView) a(2131560948);
        this.f12787g = (BetterButton) a(2131559198);
        this.f12788h = (ViewStubCompat) a(2131560949);
    }

    public void setListener(final C14411 c14411) {
        this.f12787g.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DefaultPaymentAwarenessView f12780b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1898463347);
                C14411 c14411 = c14411;
                if (c14411.f12810a.f12812a != null) {
                    c14411.f12810a.f12812a.mo508a();
                }
                Logger.a(2, EntryType.UI_INPUT_END, -866918090, a);
            }
        });
    }

    public void setViewParams(DefaultPaymentAwarenessViewParams defaultPaymentAwarenessViewParams) {
        this.f12782b.setText(defaultPaymentAwarenessViewParams.f12789a);
        this.f12783c.setText(defaultPaymentAwarenessViewParams.f12790b);
        m13138a(this.f12784d, defaultPaymentAwarenessViewParams.f12791c);
        m13138a(this.f12785e, defaultPaymentAwarenessViewParams.f12792d);
        m13138a(this.f12786f, defaultPaymentAwarenessViewParams.f12793e);
        this.f12787g.setText(defaultPaymentAwarenessViewParams.f12794f);
        ViewStubHolder.a(this.f12788h, defaultPaymentAwarenessViewParams.f12795g).f();
    }

    private void m13138a(BetterTextView betterTextView, PaymentAwarenessRow paymentAwarenessRow) {
        betterTextView.setText(paymentAwarenessRow.f12817a);
        betterTextView.setCompoundDrawablesWithIntrinsicBounds(paymentAwarenessRow.f12818b, 0, 0, 0);
        this.f12781a.a(betterTextView.getCompoundDrawables()[0], getResources().getColor(2131363814));
    }
}

package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.PayPalBillingAgreement;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodRowItem;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.payments.util.PaymentMethodUtil;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: boosted_local_awareness_mobile */
public class PaymentMethodView extends PaymentsComponentLinearLayout implements RowItemView<PaymentMethodRowItem> {
    @Inject
    public AnalyticsLogger f18723a;
    private PaymentMethodRowItem f18724b;
    private ImageView f18725c;
    private TextView f18726d;
    private TextView f18727e;
    private GlyphView f18728f;

    /* compiled from: boosted_local_awareness_mobile */
    /* synthetic */ class C21851 {
        static final /* synthetic */ int[] f18722a = new int[PaymentMethodType.values().length];

        static {
            try {
                f18722a[PaymentMethodType.CREDIT_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18722a[PaymentMethodType.PAYPAL_BILLING_AGREEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static <T extends View> void m18724a(Class<T> cls, T t) {
        m18725a((Object) t, t.getContext());
    }

    private static void m18725a(Object obj, Context context) {
        ((PaymentMethodView) obj).f18723a = AnalyticsLoggerMethodAutoProvider.a(FbInjector.get(context));
    }

    private void m18723a(AnalyticsLogger analyticsLogger) {
        this.f18723a = analyticsLogger;
    }

    public PaymentMethodView(Context context) {
        super(context);
        m18726b();
    }

    public PaymentMethodView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m18726b();
    }

    public PaymentMethodView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18726b();
    }

    private void m18726b() {
        m18724a(PaymentMethodView.class, (View) this);
        setContentView(2130906145);
        setOrientation(0);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361920)));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429273);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.f18725c = (ImageView) a(2131565804);
        this.f18726d = (TextView) a(2131560465);
        this.f18727e = (TextView) a(2131565805);
        this.f18728f = (GlyphView) a(2131560317);
    }

    public final void m18728a(PaymentMethodRowItem paymentMethodRowItem) {
        this.f18724b = paymentMethodRowItem;
        setPaymentMethod(this.f18724b.f18841a);
        this.f18728f.setVisibility(this.f18724b.f18842b ? 0 : 8);
    }

    public final void mo658a() {
        this.f18723a.a(PickerScreenAnalyticsEvent.m18788c("payments_payment_method_selected", this.f18724b.f18843c.f18785b.f18776a).m18786a(this.f18724b.f18843c).m18787a(this.f18724b.f18841a.a()).f18775a);
        Bundle bundle = new Bundle();
        bundle.putString("extra_user_action", this.f18724b.f18841a.a());
        a(new PaymentsComponentAction(Action.USER_ACTION, bundle));
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        Drawable drawable = null;
        switch (C21851.f18722a[paymentMethod.b().ordinal()]) {
            case 1:
                drawable = ((CreditCard) paymentMethod).a(getResources());
                break;
            case 2:
                drawable = PayPalBillingAgreement.a(getResources());
                break;
        }
        if (drawable != null) {
            this.f18725c.setImageDrawable(drawable);
        }
        this.f18726d.setText(PaymentMethodUtil.b(paymentMethod, getResources()));
        CharSequence a = PaymentMethodUtil.a(paymentMethod, getResources());
        if (Strings.isNullOrEmpty(a)) {
            this.f18727e.setVisibility(8);
            return;
        }
        this.f18727e.setVisibility(0);
        this.f18727e.setText(a);
    }

    public final void m18729a(boolean z) {
        a(2131558965).setVisibility(z ? 0 : 8);
    }
}

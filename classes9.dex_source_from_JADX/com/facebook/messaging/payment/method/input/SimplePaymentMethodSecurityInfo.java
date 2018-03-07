package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: incoming_request_ids */
public class SimplePaymentMethodSecurityInfo extends PaymentsComponentLinearLayout {
    @Inject
    public PaymentsTextViewLinkHelper f13075a;

    private static <T extends View> void m13382a(Class<T> cls, T t) {
        m13383a((Object) t, t.getContext());
    }

    private static void m13383a(Object obj, Context context) {
        ((SimplePaymentMethodSecurityInfo) obj).f13075a = PaymentsTextViewLinkHelper.b(FbInjector.get(context));
    }

    public SimplePaymentMethodSecurityInfo(Context context) {
        super(context);
        m13380a();
    }

    public SimplePaymentMethodSecurityInfo(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m13380a();
    }

    public SimplePaymentMethodSecurityInfo(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13380a();
    }

    private void m13380a() {
        m13382a(SimplePaymentMethodSecurityInfo.class, (View) this);
        setContentView(2130907110);
        this.f13075a.a(2131240281, "[[learn_more_link]]", getContext().getString(2131240282), (FbTextView) a(2131565280), "https://m.facebook.com/help/messenger-app/728431013914433");
    }

    private void m13381a(PaymentsTextViewLinkHelper paymentsTextViewLinkHelper) {
        this.f13075a = paymentsTextViewLinkHelper;
    }
}

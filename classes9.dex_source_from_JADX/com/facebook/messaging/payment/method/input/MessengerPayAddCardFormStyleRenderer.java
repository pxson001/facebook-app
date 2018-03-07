package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.method.input.TransactionPaymentMethodSecurityInfo.C14592;
import com.facebook.messaging.payment.ui.PaymentHeaderSubheaderLayout;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormStyleRenderer;
import com.facebook.payments.ui.PaymentsComponentView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: initDecode failed */
public class MessengerPayAddCardFormStyleRenderer extends SimpleCardFormStyleRenderer {
    private final Context f13017a;
    private final AbstractFbErrorReporter f13018b;

    @Inject
    public MessengerPayAddCardFormStyleRenderer(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13017a = context;
        this.f13018b = abstractFbErrorReporter;
    }

    public final PaymentsComponentView m13324a(ViewGroup viewGroup, CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        PaymentHeaderSubheaderLayout paymentHeaderSubheaderLayout = new PaymentHeaderSubheaderLayout(this.f13017a);
        if (messengerPayCardFormParams.f13032e) {
            paymentHeaderSubheaderLayout.setSubheader(2131240261);
            paymentHeaderSubheaderLayout.setSubheaderVisibility(0);
            paymentHeaderSubheaderLayout.setHeaderVisibility(8);
        } else {
            paymentHeaderSubheaderLayout.setHeader(messengerPayCardFormParams.f13030c != null ? messengerPayCardFormParams.f13030c : this.f13017a.getString(2131240259));
            paymentHeaderSubheaderLayout.setSubheader(messengerPayCardFormParams.f13031d != null ? messengerPayCardFormParams.f13031d : this.f13017a.getString(2131240260));
            paymentHeaderSubheaderLayout.setHeaderVisibility(0);
            paymentHeaderSubheaderLayout.setSubheaderVisibility(0);
        }
        return paymentHeaderSubheaderLayout;
    }

    @Nullable
    public final PaymentsComponentView m13325b(ViewGroup viewGroup, CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        if (!PaymentFlowType.NUX.analyticsModule.equals(messengerPayCardFormParams.m13335a().b.b)) {
            return new SimplePaymentMethodSecurityInfo(this.f13017a);
        }
        if (StringUtil.a(new CharSequence[]{messengerPayCardFormParams.f13028a, messengerPayCardFormParams.f13029b})) {
            this.f13018b.a(getClass().getName(), "Null senderName or transactionId received when in a receive nux flow.");
            return null;
        }
        PaymentsComponentView transactionPaymentMethodSecurityInfo = new TransactionPaymentMethodSecurityInfo(this.f13017a);
        transactionPaymentMethodSecurityInfo.f13081a.setOnClickListener(new C14592(transactionPaymentMethodSecurityInfo, messengerPayCardFormParams.f13028a, messengerPayCardFormParams.f13029b));
        return transactionPaymentMethodSecurityInfo;
    }
}

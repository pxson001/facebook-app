package com.facebook.messaging.payment.method.input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.dialog.ConfirmActionDialogFragment;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.payments.paymentmethods.cardform.CardFormComponent;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: initialStatus */
public class DeletePaymentCardDialogFragment extends ConfirmActionDialogFragment implements CardFormComponent {
    @Inject
    public AnalyticsLogger am;
    private SimplePaymentsComponentCallback an;

    public static void m13305a(Object obj, Context context) {
        ((DeletePaymentCardDialogFragment) obj).am = AnalyticsLoggerMethodAutoProvider.a(FbInjector.get(context));
    }

    public final void m13306a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2138675772);
        super.a(bundle);
        Class cls = DeletePaymentCardDialogFragment.class;
        m13305a(this, getContext());
        this.am.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_initiate_remove_card"));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1156601800, a);
    }

    public final Dialog m13308c(Bundle bundle) {
        Builder builder = new Builder(b(2131240430), b(2131240431));
        builder.d = b(2131240433);
        builder = builder;
        builder.f = false;
        this.am = builder.a();
        return super.c(bundle);
    }

    public final void m13307a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.an = simplePaymentsComponentCallback;
    }

    protected final void as() {
        super.as();
        this.am.a(P2pPaymentsLogEvent.c("p2p_settings", "p2p_cancel_remove_card"));
    }

    protected final void aq() {
        super.aq();
        if (this.an != null) {
            PaymentCard paymentCard = (PaymentCard) this.s.getParcelable("payment_card");
            Bundle bundle = new Bundle();
            bundle.putString("extra_mutation", "action_delete_payment_card");
            bundle.putParcelable("payment_card", paymentCard);
            this.an.a(new PaymentsComponentAction(Action.MUTATION, bundle));
        }
    }
}

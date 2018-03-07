package com.facebook.messaging.payment.method.input.cvv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.payments.paymentmethods.cardform.CardFormInput;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormMutator;
import com.facebook.payments.paymentmethods.cardform.protocol.CardFormProtocolUtil;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: include_thread_info */
public class MessengerPayRequireCvvFormMutator extends SimpleCardFormMutator {
    @Inject
    public MessengerPayRequireCvvFormMutator(Context context, Executor executor, CardFormProtocolUtil cardFormProtocolUtil) {
        super(context, executor, cardFormProtocolUtil);
    }

    public final ListenableFuture m13389a(CardFormParams cardFormParams, CardFormInput cardFormInput) {
        Parcelable intent = new Intent();
        intent.putExtra("cvv_code", cardFormInput.e);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_activity_result_data", intent);
        this.a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
        return Futures.a(Boolean.valueOf(true));
    }
}

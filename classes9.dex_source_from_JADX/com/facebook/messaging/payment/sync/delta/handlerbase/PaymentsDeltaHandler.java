package com.facebook.messaging.payment.sync.delta.handlerbase;

import android.os.Bundle;
import com.facebook.messaging.payment.sync.delta.PaymentsPrefetchedSyncData;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.sync.delta.BaseDeltaHandler;
import com.facebook.sync.delta.DeltaWithSequenceId;

/* compiled from: fetchMoreMessages (DSH).  */
public abstract class PaymentsDeltaHandler implements BaseDeltaHandler<PaymentsPrefetchedSyncData, DeltaPaymentWrapper> {
    public abstract Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId);
}

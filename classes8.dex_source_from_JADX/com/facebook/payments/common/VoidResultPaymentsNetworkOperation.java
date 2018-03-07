package com.facebook.payments.common;

import android.os.Parcelable;
import com.facebook.http.protocol.ApiResponse;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: target_uri */
public abstract class VoidResultPaymentsNetworkOperation<PARAM extends Parcelable> extends UnrestrictedResultPaymentsNetworkOperation<PARAM, Void> {
    public VoidResultPaymentsNetworkOperation(PaymentNetworkOperationHelper paymentNetworkOperationHelper) {
        super(paymentNetworkOperationHelper, Void.class);
    }

    public final ListenableFuture<Void> m1936c(PARAM param) {
        return Futures.a(m1929a(param), PaymentNetworkOperationHelper.f1746a, this.f1751a.f1750d);
    }

    public final ListenableFuture<Void> mo71b(PARAM param) {
        return m1936c(param);
    }

    @Nullable
    public final Object m1934a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}

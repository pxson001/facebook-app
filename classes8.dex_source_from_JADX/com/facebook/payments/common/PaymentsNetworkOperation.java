package com.facebook.payments.common;

import android.os.Parcelable;
import com.facebook.http.protocol.ApiResponse;

/* compiled from: target_user_id */
public abstract class PaymentsNetworkOperation<PARAM extends Parcelable, RESULT extends Parcelable> extends UnrestrictedResultPaymentsNetworkOperation<PARAM, RESULT> {
    public PaymentsNetworkOperation(PaymentNetworkOperationHelper paymentNetworkOperationHelper, Class<RESULT> cls) {
        super(paymentNetworkOperationHelper, cls);
    }

    public RESULT m1932a(PARAM param, ApiResponse apiResponse) {
        apiResponse.i();
        return (Parcelable) apiResponse.d().a(this.f1752b);
    }
}

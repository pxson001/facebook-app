package com.facebook.payments.common;

import android.os.Parcelable;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.payments.common.PaymentNetworkOperationHelper.C01802;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: target_user_is_birthday */
public abstract class UnrestrictedResultPaymentsNetworkOperation<PARAM extends Parcelable, RESULT> implements PaymentsApiMethod<PARAM, RESULT> {
    protected final PaymentNetworkOperationHelper f1751a;
    protected final Class<RESULT> f1752b;

    public abstract String mo87a();

    public UnrestrictedResultPaymentsNetworkOperation(PaymentNetworkOperationHelper paymentNetworkOperationHelper, Class<RESULT> cls) {
        this.f1751a = paymentNetworkOperationHelper;
        this.f1752b = cls;
    }

    public final ListenableFuture<OperationResult> m1929a(PARAM param) {
        return this.f1751a.m1923a(m1927b(), param, mo87a());
    }

    public ListenableFuture<RESULT> mo71b(PARAM param) {
        PaymentNetworkOperationHelper paymentNetworkOperationHelper = this.f1751a;
        ListenableFuture a = this.f1751a.m1923a(m1927b(), param, mo87a());
        Class cls = this.f1752b;
        return Futures.a(a, Parcelable.class.isAssignableFrom(cls) ? PaymentNetworkOperationHelper.f1747b : new C01802(paymentNetworkOperationHelper, cls), paymentNetworkOperationHelper.f1750d);
    }

    final OperationResult m1928a(OperationParams operationParams, ApiMethodRunnerImpl apiMethodRunnerImpl) {
        return OperationResult.a(apiMethodRunnerImpl.a(this, operationParams.c.getParcelable(m1927b())));
    }

    protected static String m1924a(ApiResponse apiResponse, String str) {
        return m1925a(apiResponse.c(), str);
    }

    protected static String m1925a(JsonNode jsonNode, String str) {
        JsonNode jsonNode2 = (JsonNode) Preconditions.checkNotNull(jsonNode.f(str), "No field %s in %s", new Object[]{str, jsonNode});
        Preconditions.checkArgument(jsonNode2 instanceof ValueNode, "%s is not a value node", new Object[]{jsonNode2});
        return jsonNode2.B();
    }

    protected static void m1926a(List<? super BasicNameValuePair> list, String str, Object obj) {
        list.add(new BasicNameValuePair(str, String.valueOf(obj)));
    }

    private String m1927b() {
        return getClass().getSimpleName();
    }
}

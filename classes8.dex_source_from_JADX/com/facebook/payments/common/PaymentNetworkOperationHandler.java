package com.facebook.payments.common;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.google.common.collect.ImmutableList;

/* compiled from: task-fetchMediaset */
public class PaymentNetworkOperationHandler implements Filter {
    private final ApiMethodRunnerImpl f1742a;
    private final ImmutableList<UnrestrictedResultPaymentsNetworkOperation<?, ?>> f1743b;

    public PaymentNetworkOperationHandler(ApiMethodRunner apiMethodRunner, UnrestrictedResultPaymentsNetworkOperation<?, ?>... unrestrictedResultPaymentsNetworkOperationArr) {
        this((ApiMethodRunnerImpl) apiMethodRunner, ImmutableList.copyOf(unrestrictedResultPaymentsNetworkOperationArr));
    }

    private PaymentNetworkOperationHandler(ApiMethodRunner apiMethodRunner, Iterable<UnrestrictedResultPaymentsNetworkOperation<?, ?>> iterable) {
        this.f1742a = apiMethodRunner;
        this.f1743b = ImmutableList.copyOf(iterable);
    }

    public OperationResult m1920a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        int size = this.f1743b.size();
        for (int i = 0; i < size; i++) {
            UnrestrictedResultPaymentsNetworkOperation unrestrictedResultPaymentsNetworkOperation = (UnrestrictedResultPaymentsNetworkOperation) this.f1743b.get(i);
            if (unrestrictedResultPaymentsNetworkOperation.mo87a().equals(operationParams.b)) {
                return unrestrictedResultPaymentsNetworkOperation.m1928a(operationParams, this.f1742a);
            }
        }
        return blueServiceHandler.a(operationParams);
    }
}

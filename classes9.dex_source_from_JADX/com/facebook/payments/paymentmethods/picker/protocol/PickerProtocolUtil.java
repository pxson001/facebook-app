package com.facebook.payments.paymentmethods.picker.protocol;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: billing_country */
public class PickerProtocolUtil {
    public final ListeningExecutorService f18866a;
    public final GetPaymentMethodsInfoMethod f18867b;

    /* compiled from: billing_country */
    public class C22121 implements Function<OperationResult, PaymentMethodsInfo> {
        final /* synthetic */ PickerProtocolUtil f18865a;

        public C22121(PickerProtocolUtil pickerProtocolUtil) {
            this.f18865a = pickerProtocolUtil;
        }

        public Object apply(Object obj) {
            return ((GetPaymentMethodsInfoResult) ((OperationResult) obj).h()).f18864a;
        }
    }

    @Inject
    public PickerProtocolUtil(ListeningExecutorService listeningExecutorService, GetPaymentMethodsInfoMethod getPaymentMethodsInfoMethod) {
        this.f18866a = listeningExecutorService;
        this.f18867b = getPaymentMethodsInfoMethod;
    }
}

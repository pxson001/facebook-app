package com.facebook.messaging.payment.thread.details;

import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: failed getting currency for logging */
public class ProtectConversationStatusLoader {
    private final PaymentPinProtocolUtil f15111a;
    @ForUiThread
    private final Executor f15112b;

    private static ProtectConversationStatusLoader m15479b(InjectorLike injectorLike) {
        return new ProtectConversationStatusLoader(PaymentPinProtocolUtil.m14279a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProtectConversationStatusLoader(PaymentPinProtocolUtil paymentPinProtocolUtil, Executor executor) {
        this.f15111a = paymentPinProtocolUtil;
        this.f15112b = executor;
    }
}

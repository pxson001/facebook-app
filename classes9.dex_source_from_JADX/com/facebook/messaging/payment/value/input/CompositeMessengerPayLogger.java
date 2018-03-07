package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import javax.inject.Inject;

/* compiled from: extra_payment_request_id */
public class CompositeMessengerPayLogger {
    private final Lazy<GroupCommerceMessengerPayLogger> f15210a;
    private final Lazy<MCMessengerPayLogger> f15211b;
    private final Lazy<MPMessengerPayLogger> f15212c;
    private final Lazy<OrionMessengerPayLogger> f15213d;
    private final Lazy<OrionRequestAckMessengerPayLogger> f15214e;
    private final Lazy<OrionRequestMessengerPayLogger> f15215f;

    public static CompositeMessengerPayLogger m15564b(InjectorLike injectorLike) {
        return new CompositeMessengerPayLogger(IdBasedLazy.a(injectorLike, 8217), IdBasedLazy.a(injectorLike, 8220), IdBasedLazy.a(injectorLike, 8224), IdBasedLazy.a(injectorLike, 8233), IdBasedLazy.a(injectorLike, 8236), IdBasedLazy.a(injectorLike, 8240));
    }

    @Inject
    public CompositeMessengerPayLogger(Lazy<GroupCommerceMessengerPayLogger> lazy, Lazy<MCMessengerPayLogger> lazy2, Lazy<MPMessengerPayLogger> lazy3, Lazy<OrionMessengerPayLogger> lazy4, Lazy<OrionRequestAckMessengerPayLogger> lazy5, Lazy<OrionRequestMessengerPayLogger> lazy6) {
        this.f15210a = lazy;
        this.f15211b = lazy2;
        this.f15212c = lazy3;
        this.f15213d = lazy4;
        this.f15214e = lazy5;
        this.f15215f = lazy6;
    }

    public final void m15566a(String str, MessengerPayData messengerPayData, Bundle bundle) {
        MessengerPayLogger messengerPayLogger;
        MessengerPayType messengerPayType = (MessengerPayType) bundle.getSerializable("messenger_pay_type");
        switch (messengerPayType) {
            case MP:
                messengerPayLogger = (MessengerPayLogger) this.f15212c.get();
                break;
            case MC:
            case PAGES_COMMERCE:
                messengerPayLogger = (MessengerPayLogger) this.f15211b.get();
                break;
            case GROUP_COMMERCE_PAY:
                messengerPayLogger = (MessengerPayLogger) this.f15210a.get();
                break;
            case ORION:
                messengerPayLogger = (MessengerPayLogger) this.f15213d.get();
                break;
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                messengerPayLogger = (MessengerPayLogger) this.f15215f.get();
                break;
            case ORION_REQUEST_ACK:
                messengerPayLogger = (MessengerPayLogger) this.f15214e.get();
                break;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
        messengerPayLogger.mo619a(str, messengerPayData, bundle);
    }

    public static CompositeMessengerPayLogger m15563a(InjectorLike injectorLike) {
        return m15564b(injectorLike);
    }

    public final PaymentFlowType m15565a(MessengerPayType messengerPayType) {
        MessengerPayLogger messengerPayLogger;
        switch (messengerPayType) {
            case MP:
                messengerPayLogger = (MessengerPayLogger) this.f15212c.get();
                break;
            case MC:
            case PAGES_COMMERCE:
                messengerPayLogger = (MessengerPayLogger) this.f15211b.get();
                break;
            case GROUP_COMMERCE_PAY:
                messengerPayLogger = (MessengerPayLogger) this.f15210a.get();
                break;
            case ORION:
                messengerPayLogger = (MessengerPayLogger) this.f15213d.get();
                break;
            case ORION_REQUEST:
                messengerPayLogger = (MessengerPayLogger) this.f15215f.get();
                break;
            case ORION_REQUEST_ACK:
                messengerPayLogger = (MessengerPayLogger) this.f15214e.get();
                break;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
        return messengerPayLogger.mo618a();
    }
}

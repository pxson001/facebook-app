package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: extra_replace_send_with_confirm */
public class CompositeMessengerPayIneligibleRecipientHandler implements MessengerPayIneligibleRecipientHandler {
    private final Lazy<OrionRequestMessengerPayIneligibleRecipientHandler> f15194a;
    private final Lazy<OrionMessengerPayIneligibleRecipientHandler> f15195b;

    public static CompositeMessengerPayIneligibleRecipientHandler m15551a(InjectorLike injectorLike) {
        return new CompositeMessengerPayIneligibleRecipientHandler(IdBasedLazy.a(injectorLike, 8238), IdBasedLazy.a(injectorLike, 8230));
    }

    @Inject
    public CompositeMessengerPayIneligibleRecipientHandler(Lazy<OrionRequestMessengerPayIneligibleRecipientHandler> lazy, Lazy<OrionMessengerPayIneligibleRecipientHandler> lazy2) {
        this.f15194a = lazy;
        this.f15195b = lazy2;
    }

    public final String mo609a(Bundle bundle, MessengerPayData messengerPayData) {
        MessengerPayIneligibleRecipientHandler messengerPayIneligibleRecipientHandler;
        MessengerPayType messengerPayType = (MessengerPayType) bundle.getSerializable("messenger_pay_type");
        switch (messengerPayType) {
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                messengerPayIneligibleRecipientHandler = (MessengerPayIneligibleRecipientHandler) this.f15194a.get();
                break;
            case GROUP_COMMERCE_PAY:
            case ORION:
            case ORION_REQUEST_ACK:
                messengerPayIneligibleRecipientHandler = (MessengerPayIneligibleRecipientHandler) this.f15195b.get();
                break;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
        return messengerPayIneligibleRecipientHandler.mo609a(bundle, messengerPayData);
    }
}

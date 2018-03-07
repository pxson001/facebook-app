package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: extra_picker_screen_param */
public class CompositeMessengerPayInitializer implements MessengerPayInitializer {
    private final Lazy<MCMessengerPayInitializer> f15197a;
    private final Lazy<MPMessengerPayInitializer> f15198b;
    private final Lazy<OrionRequestAckMessengerPayInitializer> f15199c;
    private final Lazy<OrionMessengerPayInitializer> f15200d;

    public static CompositeMessengerPayInitializer m15554a(InjectorLike injectorLike) {
        return new CompositeMessengerPayInitializer(IdBasedLazy.a(injectorLike, 8218), IdBasedLazy.a(injectorLike, 8222), IdBasedLazy.a(injectorLike, 8235), IdBasedLazy.a(injectorLike, 8231));
    }

    @Inject
    public CompositeMessengerPayInitializer(Lazy<MCMessengerPayInitializer> lazy, Lazy<MPMessengerPayInitializer> lazy2, Lazy<OrionRequestAckMessengerPayInitializer> lazy3, Lazy<OrionMessengerPayInitializer> lazy4) {
        this.f15197a = lazy;
        this.f15198b = lazy2;
        this.f15199c = lazy3;
        this.f15200d = lazy4;
    }

    public final void mo610a(Bundle bundle, MessengerPayData messengerPayData) {
        MessengerPayInitializer messengerPayInitializer;
        MessengerPayType messengerPayType = (MessengerPayType) bundle.getSerializable("messenger_pay_type");
        switch (messengerPayType) {
            case MP:
                messengerPayInitializer = (MessengerPayInitializer) this.f15198b.get();
                break;
            case MC:
            case PAGES_COMMERCE:
                messengerPayInitializer = (MessengerPayInitializer) this.f15197a.get();
                break;
            case ORION_REQUEST_ACK:
                messengerPayInitializer = (MessengerPayInitializer) this.f15199c.get();
                break;
            case GROUP_COMMERCE_PAY:
            case ORION:
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                messengerPayInitializer = (MessengerPayInitializer) this.f15200d.get();
                break;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
        messengerPayInitializer.mo610a(bundle, messengerPayData);
    }
}

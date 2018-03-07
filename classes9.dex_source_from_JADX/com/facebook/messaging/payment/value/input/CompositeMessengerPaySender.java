package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17758;
import com.facebook.messaging.payment.value.input.pagescommerce.PagesCommerceMessengerPaySender;
import javax.inject.Inject;

/* compiled from: extra_payment_account_enabled_status */
public class CompositeMessengerPaySender implements MessengerPaySender {
    private final Lazy<MCMessengerPaySender> f15217a;
    private final Lazy<MPMessengerPaySender> f15218b;
    private final Lazy<PagesCommerceMessengerPaySender> f15219c;
    private final Lazy<OrionMessengerPaySender> f15220d;
    private final Lazy<OrionRequestAckMessengerPaySender> f15221e;
    private final Lazy<OrionRequestMessengerPaySender> f15222f;
    private MessengerPaySender f15223g;
    private C17758 f15224h;

    public static CompositeMessengerPaySender m15570a(InjectorLike injectorLike) {
        return new CompositeMessengerPaySender(IdBasedLazy.a(injectorLike, 8221), IdBasedLazy.a(injectorLike, 8225), IdBasedLazy.a(injectorLike, 8260), IdBasedLazy.a(injectorLike, 8234), IdBasedLazy.a(injectorLike, 8237), IdBasedLazy.a(injectorLike, 8241));
    }

    @Inject
    public CompositeMessengerPaySender(Lazy<MCMessengerPaySender> lazy, Lazy<MPMessengerPaySender> lazy2, Lazy<PagesCommerceMessengerPaySender> lazy3, Lazy<OrionMessengerPaySender> lazy4, Lazy<OrionRequestAckMessengerPaySender> lazy5, Lazy<OrionRequestMessengerPaySender> lazy6) {
        this.f15217a = lazy;
        this.f15218b = lazy2;
        this.f15219c = lazy3;
        this.f15220d = lazy4;
        this.f15221e = lazy5;
        this.f15222f = lazy6;
    }

    public final void mo616a(C17758 c17758) {
        this.f15224h = c17758;
    }

    public final void mo615a(Bundle bundle, MessengerPayData messengerPayData) {
        MessengerPayType messengerPayType = (MessengerPayType) bundle.getSerializable("messenger_pay_type");
        switch (messengerPayType) {
            case MP:
                this.f15223g = (MessengerPaySender) this.f15218b.get();
                break;
            case MC:
                this.f15223g = (MessengerPaySender) this.f15217a.get();
                break;
            case PAGES_COMMERCE:
                this.f15223g = (MessengerPaySender) this.f15219c.get();
                break;
            case GROUP_COMMERCE_PAY:
            case ORION:
                this.f15223g = (MessengerPaySender) this.f15220d.get();
                break;
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                this.f15223g = (MessengerPaySender) this.f15222f.get();
                break;
            case ORION_REQUEST_ACK:
                this.f15223g = (MessengerPaySender) this.f15221e.get();
                break;
            default:
                throw new RuntimeException("Unsupported messengerPayType: " + messengerPayType);
        }
        this.f15223g.mo616a(this.f15224h);
        this.f15223g.mo615a(bundle, messengerPayData);
    }

    public final void mo614a() {
        if (this.f15223g != null) {
            this.f15223g.mo614a();
        }
    }
}

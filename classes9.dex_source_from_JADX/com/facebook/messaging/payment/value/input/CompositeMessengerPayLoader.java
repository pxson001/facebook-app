package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17769;
import com.facebook.messaging.payment.value.input.pagescommerce.PagesCommerceMessengerPayLoader;
import javax.inject.Inject;

/* compiled from: extra_permissions */
public class CompositeMessengerPayLoader implements MessengerPayLoader {
    private final Lazy<MCMessengerPayLoader> f15202a;
    private final Lazy<PagesCommerceMessengerPayLoader> f15203b;
    private final Lazy<MPMessengerPayLoader> f15204c;
    private final Lazy<OrionMessengerPayLoader> f15205d;
    private final Lazy<OrionRequestMessengerPayLoader> f15206e;
    private MessengerPayLoader f15207f;
    private C17769 f15208g;

    public static CompositeMessengerPayLoader m15559a(InjectorLike injectorLike) {
        return new CompositeMessengerPayLoader(IdBasedLazy.a(injectorLike, 8219), IdBasedLazy.a(injectorLike, 8259), IdBasedLazy.a(injectorLike, 8223), IdBasedLazy.a(injectorLike, 8232), IdBasedLazy.a(injectorLike, 8239));
    }

    @Inject
    public CompositeMessengerPayLoader(Lazy<MCMessengerPayLoader> lazy, Lazy<PagesCommerceMessengerPayLoader> lazy2, Lazy<MPMessengerPayLoader> lazy3, Lazy<OrionMessengerPayLoader> lazy4, Lazy<OrionRequestMessengerPayLoader> lazy5) {
        this.f15202a = lazy;
        this.f15203b = lazy2;
        this.f15204c = lazy3;
        this.f15205d = lazy4;
        this.f15206e = lazy5;
    }

    public final void mo613a(C17769 c17769) {
        this.f15208g = c17769;
    }

    public final void mo612a(Bundle bundle, MessengerPayData messengerPayData) {
        MessengerPayType messengerPayType = (MessengerPayType) bundle.getSerializable("messenger_pay_type");
        switch (messengerPayType) {
            case MP:
                this.f15207f = (MessengerPayLoader) this.f15204c.get();
                break;
            case MC:
                this.f15207f = (MessengerPayLoader) this.f15202a.get();
                break;
            case PAGES_COMMERCE:
                this.f15207f = (MessengerPayLoader) this.f15203b.get();
                break;
            case GROUP_COMMERCE_PAY:
            case ORION:
            case ORION_REQUEST_ACK:
                this.f15207f = (MessengerPayLoader) this.f15205d.get();
                break;
            case ORION_REQUEST:
            case GROUP_COMMERCE_REQUEST:
                this.f15207f = (MessengerPayLoader) this.f15206e.get();
                break;
            default:
                throw new RuntimeException("Unsupported enterPaymentValueType: " + messengerPayType);
        }
        this.f15207f.mo613a(this.f15208g);
        this.f15207f.mo612a(bundle, messengerPayData);
    }

    public final void mo611a() {
        if (this.f15207f != null) {
            this.f15207f.mo611a();
        }
    }
}

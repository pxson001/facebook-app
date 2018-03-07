package com.facebook.messaging.payment.method.input.shipping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.dialog.ConfirmActionParams.Builder;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.shipping.form.ShippingAddressMutator;
import com.facebook.payments.shipping.model.ShippingAddressFormInput;
import com.facebook.payments.shipping.model.SimpleMailingAddress;
import com.facebook.payments.shipping.model.SimpleMailingAddressBuilder;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: include_is_messenger_user */
public class MessengerCommerceShippingAddressMutator implements ShippingAddressMutator {
    private SimplePaymentsComponentCallback f13089a;
    private ListenableFuture<String> f13090b;
    private ListenableFuture<OperationResult> f13091c;
    public final Context f13092d;
    private final Executor f13093e;
    private final PaymentProtocolUtil f13094f;
    private final Provider<User> f13095g;

    @Inject
    public MessengerCommerceShippingAddressMutator(Context context, Executor executor, PaymentProtocolUtil paymentProtocolUtil, Provider<User> provider) {
        this.f13092d = context;
        this.f13093e = executor;
        this.f13094f = paymentProtocolUtil;
        this.f13095g = provider;
    }

    public final void mo512a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f13089a = simplePaymentsComponentCallback;
    }

    public final void mo509a(final ShippingAddressFormInput shippingAddressFormInput) {
        if (!m13401a(this.f13090b)) {
            Preconditions.checkNotNull(this.f13089a);
            this.f13090b = this.f13094f.m14953a(shippingAddressFormInput, ((User) this.f13095g.get()).a);
            this.f13089a.a(this.f13090b);
            Futures.a(this.f13090b, new ResultFutureCallback<String>(this) {
                final /* synthetic */ MessengerCommerceShippingAddressMutator f13083b;

                public final void m13392a(Object obj) {
                    MessengerCommerceShippingAddressMutator.m13400a(this.f13083b, (String) obj, shippingAddressFormInput, false, false);
                }

                public final void m13391a(ServiceException serviceException) {
                    MessengerCommerceShippingAddressMutator.m13399a(this.f13083b, this.f13083b.f13092d.getString(2131240114));
                }
            }, this.f13093e);
        }
    }

    public final void mo510a(ShippingAddressFormInput shippingAddressFormInput, String str, boolean z, boolean z2) {
        if (!m13401a(this.f13091c)) {
            Preconditions.checkNotNull(this.f13089a);
            this.f13091c = this.f13094f.m14954a(shippingAddressFormInput, str, z, z2);
            this.f13089a.a(this.f13091c);
            final String str2 = str;
            final ShippingAddressFormInput shippingAddressFormInput2 = shippingAddressFormInput;
            final boolean z3 = z;
            final boolean z4 = z2;
            Futures.a(this.f13091c, new ResultFutureCallback<OperationResult>(this) {
                final /* synthetic */ MessengerCommerceShippingAddressMutator f13088e;

                public final void m13393a(ServiceException serviceException) {
                    MessengerCommerceShippingAddressMutator.m13399a(this.f13088e, this.f13088e.f13092d.getString(2131240115));
                }

                public final void m13394a(Object obj) {
                    MessengerCommerceShippingAddressMutator.m13400a(this.f13088e, str2, shippingAddressFormInput2, z3, z4);
                }
            }, this.f13093e);
        }
    }

    public final void mo511a(PaymentsComponentAction paymentsComponentAction, ShippingAddressFormInput shippingAddressFormInput) {
        String a = paymentsComponentAction.a("extra_mutation", null);
        String a2 = paymentsComponentAction.a("shipping_address_id", null);
        if ("make_default_mutation".equals(a)) {
            mo510a(shippingAddressFormInput, a2, true, false);
        } else if ("delete_mutation".equals(a)) {
            mo510a(null, a2, false, true);
        }
    }

    public static void m13399a(MessengerCommerceShippingAddressMutator messengerCommerceShippingAddressMutator, String str) {
        Builder builder = new Builder(str, messengerCommerceShippingAddressMutator.f13092d.getString(2131230726));
        builder.d = messengerCommerceShippingAddressMutator.f13092d.getString(2131238319);
        builder = builder;
        builder.f = true;
        messengerCommerceShippingAddressMutator.f13089a.a(PaymentsConfirmDialogFragment.b(builder.a()));
    }

    public static void m13400a(MessengerCommerceShippingAddressMutator messengerCommerceShippingAddressMutator, String str, ShippingAddressFormInput shippingAddressFormInput, boolean z, boolean z2) {
        if (z2) {
            messengerCommerceShippingAddressMutator.f13089a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY));
            return;
        }
        SimpleMailingAddressBuilder newBuilder = SimpleMailingAddress.newBuilder();
        newBuilder.f19012a = str;
        newBuilder = newBuilder;
        newBuilder.f19013b = shippingAddressFormInput.f18963a;
        newBuilder = newBuilder;
        newBuilder.f19014c = shippingAddressFormInput.f18965c;
        newBuilder = newBuilder;
        newBuilder.f19015d = shippingAddressFormInput.f18966d;
        newBuilder = newBuilder;
        newBuilder.f19016e = StringFormatUtil.formatStrLocaleSafe("%s, %s", shippingAddressFormInput.f18967e, shippingAddressFormInput.f18968f);
        newBuilder = newBuilder;
        newBuilder.f19017f = shippingAddressFormInput.f18969g;
        newBuilder = newBuilder;
        newBuilder.f19018g = shippingAddressFormInput.f18970h.b();
        newBuilder = newBuilder;
        newBuilder.f19019h = shippingAddressFormInput.f18964b;
        newBuilder = newBuilder;
        if (z) {
            newBuilder.f19022k = true;
        }
        Parcelable intent = new Intent();
        intent.putExtra("shipping_address", newBuilder.m18983l());
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_activity_result_data", intent);
        messengerCommerceShippingAddressMutator.f13089a.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
    }

    private static boolean m13401a(ListenableFuture listenableFuture) {
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }
}

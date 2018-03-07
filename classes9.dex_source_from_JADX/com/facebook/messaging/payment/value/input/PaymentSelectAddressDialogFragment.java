package com.facebook.messaging.payment.value.input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder.MultiOptionsDialogListener;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17725;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: error_stacktrace */
public class PaymentSelectAddressDialogFragment extends FbDialogFragment {
    @Inject
    public PaymentDialogsBuilder am;
    public C17725 an;

    public static void m15848a(Object obj, Context context) {
        ((PaymentSelectAddressDialogFragment) obj).am = PaymentDialogsBuilder.m13301a(FbInjector.get(context));
    }

    public final void m15849a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1574191606);
        super.a(bundle);
        Class cls = PaymentSelectAddressDialogFragment.class;
        m15848a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1931074358, a);
    }

    public final Dialog m15850c(Bundle bundle) {
        final ImmutableList copyOf = ImmutableList.copyOf(this.s.getParcelableArrayList("shipping_addresses"));
        Context context = getContext();
        Builder builder = new Builder();
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            builder.c(((MailingAddress) copyOf.get(i)).mo761a("%s\n%s\n%s, %s\n%s"));
        }
        return PaymentDialogsBuilder.m13297a(context, builder.b(), b(2131240554), b(2131240553), null, new MultiOptionsDialogListener(this) {
            final /* synthetic */ PaymentSelectAddressDialogFragment f15684b;

            public final void mo520a() {
                EnterPaymentValueFragment.aR(this.f15684b.an.f15274a);
            }

            public final void mo521a(int i) {
                MailingAddress mailingAddress = (MailingAddress) copyOf.get(i);
                EnterPaymentValueFragment.m15642a(this.f15684b.an.f15274a, mailingAddress);
            }
        });
    }
}

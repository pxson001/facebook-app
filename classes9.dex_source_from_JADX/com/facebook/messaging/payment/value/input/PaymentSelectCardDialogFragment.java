package com.facebook.messaging.payment.value.input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder.MultiOptionsDialogListener;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17714;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: error_resend_sms_code */
public class PaymentSelectCardDialogFragment extends FbDialogFragment {
    @Inject
    public PaymentDialogsBuilder am;
    @Inject
    public PaymentCardsFetcher an;
    public C17714 ao;

    public static void m15855a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PaymentSelectCardDialogFragment paymentSelectCardDialogFragment = (PaymentSelectCardDialogFragment) obj;
        PaymentDialogsBuilder a = PaymentDialogsBuilder.m13301a(injectorLike);
        PaymentCardsFetcher a2 = PaymentCardsFetcher.m13429a(injectorLike);
        paymentSelectCardDialogFragment.am = a;
        paymentSelectCardDialogFragment.an = a2;
    }

    public final void m15856a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1592376813);
        super.a(bundle);
        Class cls = PaymentSelectCardDialogFragment.class;
        m15855a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1992880354, a);
    }

    public final Dialog m15857c(Bundle bundle) {
        Bundle bundle2 = this.s;
        Collection parcelableArrayList = bundle2.getParcelableArrayList("payment_cards");
        Boolean valueOf = Boolean.valueOf(bundle2.getBoolean("credit_card_enabled"));
        final ImmutableList a = PaymentCardsFetcher.m13430a(ImmutableList.copyOf(parcelableArrayList));
        return valueOf.booleanValue() ? PaymentDialogsBuilder.m13297a(getContext(), PaymentDialogsBuilder.m13302a(getContext(), PaymentCardsFetcher.m13432c(a)), b(2131240393), b(2131240397), null, new MultiOptionsDialogListener(this) {
            final /* synthetic */ PaymentSelectCardDialogFragment f15686b;

            public final void mo520a() {
                this.f15686b.ao.m15626a();
            }

            public final void mo521a(int i) {
                C17714 c17714 = this.f15686b.ao;
                PaymentCardsFetcher paymentCardsFetcher = this.f15686b.an;
                c17714.m15627a((PaymentCard) PaymentCardsFetcher.m13432c(a).get(i));
            }
        }) : PaymentDialogsBuilder.m13297a(getContext(), PaymentDialogsBuilder.m13302a(getContext(), PaymentCardsFetcher.m13433d(a)), b(2131240392), b(2131240413), b(2131240396), new MultiOptionsDialogListener(this) {
            final /* synthetic */ PaymentSelectCardDialogFragment f15688b;

            public final void mo520a() {
                this.f15688b.ao.m15626a();
            }

            public final void mo521a(int i) {
                C17714 c17714 = this.f15688b.ao;
                PaymentCardsFetcher paymentCardsFetcher = this.f15688b.an;
                c17714.m15627a((PaymentCard) PaymentCardsFetcher.m13433d(a).get(i));
            }
        });
    }
}

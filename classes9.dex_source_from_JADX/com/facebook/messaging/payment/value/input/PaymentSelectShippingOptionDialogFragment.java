package com.facebook.messaging.payment.value.input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder.MultiOptionsDialogListener;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17736;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: error_request_sms_code */
public class PaymentSelectShippingOptionDialogFragment extends FbDialogFragment {
    @Inject
    public PaymentDialogsBuilder am;
    public C17736 an;

    public static void m15860a(Object obj, Context context) {
        ((PaymentSelectShippingOptionDialogFragment) obj).am = PaymentDialogsBuilder.m13301a(FbInjector.get(context));
    }

    public final void m15861a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1582909308);
        super.a(bundle);
        Class cls = PaymentSelectShippingOptionDialogFragment.class;
        m15860a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -271780546, a);
    }

    public final Dialog m15862c(Bundle bundle) {
        final ImmutableList copyOf = ImmutableList.copyOf((ArrayList) FlatBufferModelHelper.b(this.s, "shipping_options"));
        Context context = getContext();
        Builder builder = new Builder();
        int size = copyOf.size();
        for (int i = 0; i < size; i++) {
            builder.c(((PaymentShippingOptionModel) copyOf.get(i)).lz_());
        }
        return PaymentDialogsBuilder.m13297a(context, builder.b(), null, b(2131240552), null, new MultiOptionsDialogListener(this) {
            final /* synthetic */ PaymentSelectShippingOptionDialogFragment f15690b;

            public final void mo520a() {
            }

            public final void mo521a(int i) {
                this.f15690b.an.f15275a.ay.m15760c(Optional.of((PaymentShippingOptionModel) copyOf.get(i)));
            }
        });
    }
}

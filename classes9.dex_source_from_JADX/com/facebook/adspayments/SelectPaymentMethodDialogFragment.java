package com.facebook.adspayments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.adspayments.analytics.PaymentsFlowState;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.common.locale.Country;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLMobilePaymentOption;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.paypalweb.PayPalWebIntentHelper;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Unable to get a valid fbid from UDP finished message */
public class SelectPaymentMethodDialogFragment extends FbDialogFragment {
    @Inject
    public SecureContextHelper am;
    @Inject
    public PaymentsLogger an;

    /* compiled from: Unable to get a valid fbid from UDP finished message */
    /* synthetic */ class C28432 {
        static final /* synthetic */ int[] f23616a = new int[GraphQLMobilePaymentOption.values().length];

        static {
            try {
                f23616a[GraphQLMobilePaymentOption.CREDIT_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23616a[GraphQLMobilePaymentOption.PAYPAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m25605a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SelectPaymentMethodDialogFragment selectPaymentMethodDialogFragment = (SelectPaymentMethodDialogFragment) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        PaymentsLogger a = PaymentsLogger.m3873a(injectorLike);
        selectPaymentMethodDialogFragment.am = secureContextHelper;
        selectPaymentMethodDialogFragment.an = a;
    }

    public final void m25607a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1014468233);
        super.a(bundle);
        Class cls = SelectPaymentMethodDialogFragment.class;
        m25605a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1419979899, a);
    }

    public final void m25606G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1681890308);
        super.G();
        this.an.m3878a(PaymentsFlowState.SELECT_PAYMENT_METHOD_STATE, aq());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1092409396, a);
    }

    private PaymentsFlowContext aq() {
        return (PaymentsFlowContext) this.s.getParcelable("payments_flow_context_key");
    }

    public final Dialog m25608c(Bundle bundle) {
        Bundle bundle2 = this.s;
        final PaymentsFlowContext aq = aq();
        List arrayList = new ArrayList();
        for (GraphQLMobilePaymentOption ordinal : (Iterable) this.s.getSerializable("payment_options")) {
            switch (C28432.f23616a[ordinal.ordinal()]) {
                case 1:
                    arrayList.add(b(2131240142));
                    break;
                case 2:
                    arrayList.add(b(2131240143));
                    break;
                default:
                    break;
            }
        }
        final Country country = (Country) bundle2.getParcelable("billing_iso_country");
        final int i = bundle2.getInt("request_code");
        final CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(2131240141);
        fbAlertDialogBuilder.a(charSequenceArr, new OnClickListener(this) {
            final /* synthetic */ SelectPaymentMethodDialogFragment f23615e;

            public void onClick(DialogInterface dialogInterface, int i) {
                Intent a;
                if (((String) charSequenceArr[i]).equals(this.f23615e.b(2131240142))) {
                    this.f23615e.an.m3880a("payments_new_credit_card_selected", aq);
                    a = AddPaymentCardActivity.m25389a(this.f23615e.getContext(), aq, country);
                    if (i == -1) {
                        this.f23615e.am.a(a, this.f23615e.an());
                        return;
                    } else {
                        this.f23615e.am.a(a, i, this.f23615e.an());
                        return;
                    }
                }
                this.f23615e.an.m3878a(PaymentsFlowState.ADD_PAYPAL_STATE, aq);
                this.f23615e.an.m3880a("payments_new_paypal_selected", aq);
                a = PayPalWebIntentHelper.m18718a(aq.f3967b, aq.f3969d);
                if (i == -1) {
                    this.f23615e.am.b(a, this.f23615e.getContext());
                } else {
                    this.f23615e.am.b(a, i, this.f23615e.an());
                }
            }
        });
        return fbAlertDialogBuilder.b();
    }
}

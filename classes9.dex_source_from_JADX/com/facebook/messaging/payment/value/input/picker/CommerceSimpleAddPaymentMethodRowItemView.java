package com.facebook.messaging.payment.value.input.picker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.payment.service.model.cards.ManualTransferMethod;
import com.facebook.messaging.payment.service.model.cards.NewManualTransferOption;
import com.facebook.messaging.payment.service.model.cards.NewNetBankingOption;
import com.facebook.messaging.payment.service.model.cards.PayOverCounterMethod;
import com.facebook.messaging.payment.value.input.BankPickerScreenActivity;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentViewGroup;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: edit_dialog_close */
public class CommerceSimpleAddPaymentMethodRowItemView extends PaymentsComponentViewGroup implements RowItemView {
    public TextView f15853a = ((TextView) getView(2131567450));

    /* compiled from: edit_dialog_close */
    /* synthetic */ class C18662 {
        static final /* synthetic */ int[] f15852a = new int[NewPaymentOptionType.values().length];

        static {
            try {
                f15852a[NewPaymentOptionType.NEW_NET_BANKING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15852a[NewPaymentOptionType.NEW_MANUAL_TRANSFER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15852a[NewPaymentOptionType.NEW_PAY_OVER_COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public CommerceSimpleAddPaymentMethodRowItemView(Context context) {
        super(context);
        setContentView(2130907101);
    }

    public final void m16047a(RowItem rowItem) {
        final CommerceSimpleAddPaymentMethodRowItem commerceSimpleAddPaymentMethodRowItem = (CommerceSimpleAddPaymentMethodRowItem) rowItem;
        this.f15853a.setText(commerceSimpleAddPaymentMethodRowItem.f15847a);
        this.f15853a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommerceSimpleAddPaymentMethodRowItemView f15851b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 768016610);
                NewPaymentOption newPaymentOption = commerceSimpleAddPaymentMethodRowItem.f15848b;
                switch (C18662.f15852a[newPaymentOption.a().ordinal()]) {
                    case 1:
                        NewNetBankingOption newNetBankingOption = (NewNetBankingOption) newPaymentOption;
                        Context context = this.f15851b.getContext();
                        Collection collection = newNetBankingOption.f14651b;
                        Intent intent = new Intent(context, BankPickerScreenActivity.class);
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(collection);
                        intent.putParcelableArrayListExtra("payment_bar_code_details", arrayList);
                        this.f15851b.a(intent, commerceSimpleAddPaymentMethodRowItem.f15849c);
                        break;
                    case 2:
                        NewManualTransferOption newManualTransferOption = (NewManualTransferOption) newPaymentOption;
                        Context context2 = this.f15851b.getContext();
                        String str = newManualTransferOption.f14649d;
                        Object manualTransferMethod = new ManualTransferMethod(newManualTransferOption.f14648c, null, null, newManualTransferOption.f14646a, newManualTransferOption.f14647b);
                        Parcelable bundle = new Bundle();
                        bundle.putString("InvoicesProofOfPaymentFragment_KEY_TRANSACTION_ID", str);
                        bundle.putParcelable("InvoicesProofOfPaymentFragment_KEY_MANUAL_TRANSFER_METHOD", manualTransferMethod);
                        this.f15851b.a(BusinessActivity.m8889a(context2, "InvoicesProofOfPaymentFragment", bundle), commerceSimpleAddPaymentMethodRowItem.f15849c);
                        break;
                    case 3:
                        CommerceSimpleAddPaymentMethodRowItemView.m16045a(this.f15851b, new PayOverCounterMethod());
                        break;
                }
                LogUtils.a(1539964601, a);
            }
        });
    }

    public final void mo658a() {
    }

    public static void m16045a(CommerceSimpleAddPaymentMethodRowItemView commerceSimpleAddPaymentMethodRowItemView, PaymentMethod paymentMethod) {
        Parcelable intent = new Intent();
        intent.putExtra("selected_payment_method", paymentMethod);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_activity_result_data", intent);
        commerceSimpleAddPaymentMethodRowItemView.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
    }
}

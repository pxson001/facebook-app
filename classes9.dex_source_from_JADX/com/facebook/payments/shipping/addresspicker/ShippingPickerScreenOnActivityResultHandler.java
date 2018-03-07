package com.facebook.payments.shipping.addresspicker;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.payments.paymentmethods.picker.PaymentsLoadingIndicatorHelper;
import com.facebook.payments.paymentmethods.picker.PickerScreenOnActivityResultHandler;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: bank_code */
public class ShippingPickerScreenOnActivityResultHandler implements PickerScreenOnActivityResultHandler<ShippingPickerScreenData> {
    private SimplePaymentsComponentCallback f18897a;

    public final boolean mo650a(PickerScreenData pickerScreenData, int i, int i2, Intent intent) {
        ShippingPickerScreenData shippingPickerScreenData = (ShippingPickerScreenData) pickerScreenData;
        MailingAddress mailingAddress;
        switch (i) {
            case 101:
                if (i2 == -1) {
                    mailingAddress = (MailingAddress) intent.getParcelableExtra("shipping_address");
                    m18905a(shippingPickerScreenData, ImmutableList.builder().b(shippingPickerScreenData.f18893a).c(mailingAddress).b(), mailingAddress);
                }
                return true;
            case 102:
                if (i2 == -1) {
                    if (intent == null) {
                        return true;
                    }
                    ImmutableList immutableList = shippingPickerScreenData.f18893a;
                    mailingAddress = (MailingAddress) intent.getParcelableExtra("shipping_address");
                    Builder builder = ImmutableList.builder();
                    if (mailingAddress != null) {
                        int size = immutableList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            MailingAddress mailingAddress2 = (MailingAddress) immutableList.get(i3);
                            if (mailingAddress2.mo760a().equals(mailingAddress.mo760a())) {
                                builder.c(mailingAddress);
                            } else {
                                builder.c(mailingAddress2);
                            }
                        }
                    }
                    m18905a(shippingPickerScreenData, builder.b(), mailingAddress);
                }
                return true;
            default:
                return false;
        }
    }

    public final void mo649a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, PaymentsLoadingIndicatorHelper paymentsLoadingIndicatorHelper) {
        this.f18897a = simplePaymentsComponentCallback;
    }

    private void m18905a(ShippingPickerScreenData shippingPickerScreenData, ImmutableList<MailingAddress> immutableList, MailingAddress mailingAddress) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_reset_data", new ShippingPickerScreenData(shippingPickerScreenData.f18895c, immutableList, mailingAddress.mo760a()));
        this.f18897a.a(new PaymentsComponentAction(Action.RESET, bundle));
    }
}

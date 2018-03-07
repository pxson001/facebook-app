package com.facebook.messaging.payment.value.input;

import android.os.Bundle;

/* compiled from: expire_month */
public class MPMessengerPayInitializer implements MessengerPayInitializer {
    public final void mo610a(Bundle bundle, MessengerPayData messengerPayData) {
        messengerPayData.m15748a((MoneyPennyItemParams) bundle.getParcelable("money_penny_item_params"));
    }
}

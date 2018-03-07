package com.facebook.messaging.payment.value.input;

import android.content.res.Resources;
import android.os.Bundle;
import javax.inject.Inject;

/* compiled from: euc-jp */
public class OrionRequestMessengerPayIneligibleRecipientHandler implements MessengerPayIneligibleRecipientHandler {
    private final Resources f15633a;

    @Inject
    public OrionRequestMessengerPayIneligibleRecipientHandler(Resources resources) {
        this.f15633a = resources;
    }

    public final String mo609a(Bundle bundle, MessengerPayData messengerPayData) {
        if (messengerPayData.f15459p == null || messengerPayData.f15459p.a() == null) {
            return this.f15633a.getString(2131240486);
        }
        return this.f15633a.getString(2131240487, new Object[]{messengerPayData.f15459p.a()});
    }
}

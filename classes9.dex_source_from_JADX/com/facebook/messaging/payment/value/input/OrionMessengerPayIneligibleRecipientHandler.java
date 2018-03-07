package com.facebook.messaging.payment.value.input;

import android.content.res.Resources;
import android.os.Bundle;
import javax.inject.Inject;

/* compiled from: events/ */
public class OrionMessengerPayIneligibleRecipientHandler implements MessengerPayIneligibleRecipientHandler {
    private final Resources f15491a;

    @Inject
    public OrionMessengerPayIneligibleRecipientHandler(Resources resources) {
        this.f15491a = resources;
    }

    public final String mo609a(Bundle bundle, MessengerPayData messengerPayData) {
        if (messengerPayData.f15459p == null || messengerPayData.f15459p.a() == null) {
            return this.f15491a.getString(2131240484);
        }
        return this.f15491a.getString(2131240485, new Object[]{messengerPayData.f15459p.a()});
    }
}

package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.user.model.Name;

/* compiled from: event_spec */
public class OrionMessengerPayInitializer implements MessengerPayInitializer {
    public final void mo610a(Bundle bundle, MessengerPayData messengerPayData) {
        OrionMessengerPayParams orionMessengerPayParams = (OrionMessengerPayParams) bundle.getParcelable("orion_messenger_pay_params");
        messengerPayData.m15750a(orionMessengerPayParams.f15512a);
        messengerPayData.m15749a(new Name(orionMessengerPayParams.f15513b));
        messengerPayData.m15746a(new MessengerPayAmount(orionMessengerPayParams.f15515d));
        messengerPayData.m15753a(orionMessengerPayParams.f15516e);
    }
}

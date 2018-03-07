package com.facebook.messaging.payment.value.input;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.user.model.UserKey;

/* compiled from: event_reminder_key */
public class OrionMessengerPayParamsBuilder {
    public UserKey f15519a;
    public String f15520b;
    public ThreadKey f15521c;
    public String f15522d;
    public String f15523e;
    public PaymentPlatformContextModel f15524f;
    public String f15525g;

    public final OrionMessengerPayParams m15790h() {
        return new OrionMessengerPayParams(this);
    }
}

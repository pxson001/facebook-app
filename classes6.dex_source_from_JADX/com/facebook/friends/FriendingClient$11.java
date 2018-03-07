package com.facebook.friends;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: me/privacy_checkup_mobile_events */
class FriendingClient$11 implements Function<OperationResult, Boolean> {
    final /* synthetic */ FriendingClient f10538a;

    FriendingClient$11(FriendingClient friendingClient) {
        this.f10538a = friendingClient;
    }

    public Object apply(@Nullable Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        boolean z = operationResult != null && operationResult.b;
        return Boolean.valueOf(z);
    }
}

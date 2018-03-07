package com.facebook.katana.dbl;

import android.content.Intent;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.katana.login.protocol.LoginBroadcastEligibilityResult;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: sms_hide_inbox_filter */
public class AuthLoginHelper$1 implements FutureCallback<OperationResult> {
    final /* synthetic */ User f2109a;
    final /* synthetic */ AuthLoginHelper f2110b;

    public AuthLoginHelper$1(AuthLoginHelper authLoginHelper, User user) {
        this.f2110b = authLoginHelper;
        this.f2109a = user;
    }

    public void onSuccess(@Nullable Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        if (operationResult != null) {
            LoginBroadcastEligibilityResult loginBroadcastEligibilityResult = (LoginBroadcastEligibilityResult) operationResult.k();
            if (loginBroadcastEligibilityResult != null && loginBroadcastEligibilityResult.f2141a) {
                Intent intent = new Intent(MessagesNotificationIntents.A);
                intent.putExtra("user_id", this.f2109a.a);
                intent.putExtra("user_display_name", this.f2109a.j());
                this.f2110b.h.a(intent);
            }
        }
    }

    public void onFailure(Throwable th) {
    }
}

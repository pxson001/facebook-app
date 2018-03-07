package com.facebook.confirmation.task;

import android.accounts.Account;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: install_from_google_play */
class OpenIDConnectEmailConfirmationBackgroundTask$2 implements Function<Account, String> {
    final /* synthetic */ OpenIDConnectEmailConfirmationBackgroundTask f10798a;

    OpenIDConnectEmailConfirmationBackgroundTask$2(OpenIDConnectEmailConfirmationBackgroundTask openIDConnectEmailConfirmationBackgroundTask) {
        this.f10798a = openIDConnectEmailConfirmationBackgroundTask;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        Account account = (Account) obj;
        return account != null ? account.name : null;
    }
}

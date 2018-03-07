package com.facebook.registration.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: legacy_override */
class AccountRegistrationActivity$1 implements OnClickListener {
    final /* synthetic */ AccountRegistrationActivity f8681a;

    AccountRegistrationActivity$1(AccountRegistrationActivity accountRegistrationActivity) {
        this.f8681a = accountRegistrationActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -581697153);
        AccountRegistrationActivity.b(this.f8681a, "up_button");
        Logger.a(2, EntryType.UI_INPUT_END, 1247320132, a);
    }
}

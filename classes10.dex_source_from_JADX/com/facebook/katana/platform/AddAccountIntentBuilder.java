package com.facebook.katana.platform;

import android.accounts.AccountAuthenticatorResponse;
import android.content.ComponentName;
import android.content.Intent;
import com.google.common.base.Preconditions;

/* compiled from: unexpected response */
public class AddAccountIntentBuilder {
    public AccountAuthenticatorResponse f1028a;
    public ComponentName f1029b;

    public final Intent m1075a() {
        Preconditions.checkNotNull(this.f1029b);
        Intent intent = new Intent();
        intent.setComponent(this.f1029b);
        intent.putExtra("add_account", true);
        intent.putExtra("accountAuthenticatorResponse", this.f1028a);
        return intent;
    }
}

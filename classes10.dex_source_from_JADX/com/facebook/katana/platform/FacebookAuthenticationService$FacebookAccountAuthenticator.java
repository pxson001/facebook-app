package com.facebook.katana.platform;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: ulg */
final class FacebookAuthenticationService$FacebookAccountAuthenticator extends AbstractAccountAuthenticator {
    public final Context f1061a;

    /* compiled from: ulg */
    class C01741 implements Runnable {
        final /* synthetic */ FacebookAuthenticationService$FacebookAccountAuthenticator f1060a;

        C01741(FacebookAuthenticationService$FacebookAccountAuthenticator facebookAuthenticationService$FacebookAccountAuthenticator) {
            this.f1060a = facebookAuthenticationService$FacebookAccountAuthenticator;
        }

        public void run() {
            Toast.makeText(this.f1060a.f1061a.getApplicationContext(), 2131232456, 0).show();
        }
    }

    public FacebookAuthenticationService$FacebookAccountAuthenticator(Context context) {
        super(context);
        this.f1061a = context;
    }

    public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (FacebookAuthenticationService.a(this.f1061a) > 0) {
            HandlerDetour.a(new Handler(Looper.getMainLooper()), new C01741(this), -1747456947);
            bundle2.putString("errorCode", "1");
            bundle2.putString("errorMessage", this.f1061a.getResources().getString(2131232456));
        } else {
            ComponentName componentName = new ComponentName(this.f1061a, FacebookAuthenticationActivity.class);
            AddAccountIntentBuilder addAccountIntentBuilder = new AddAccountIntentBuilder();
            addAccountIntentBuilder.f1028a = accountAuthenticatorResponse;
            addAccountIntentBuilder = addAccountIntentBuilder;
            addAccountIntentBuilder.f1029b = componentName;
            bundle2.putParcelable("intent", addAccountIntentBuilder.m1075a());
        }
        return bundle2;
    }

    public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        throw new UnsupportedOperationException();
    }

    public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        return null;
    }

    public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return null;
    }

    public final String getAuthTokenLabel(String str) {
        return this.f1061a.getString(2131236352);
    }

    public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return null;
    }

    public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }
}

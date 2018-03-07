package com.facebook.katana.platform;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.base.service.FbService;
import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;

/* compiled from: trace_type */
public class FacebookAuthenticationService extends FbService {
    private static final Class<?> f785a;
    private static final String f786b;
    private FacebookAccountAuthenticator f787c;

    static {
        Class cls = FacebookAuthenticationService.class;
        f785a = cls;
        f786b = cls.getSimpleName();
    }

    public static Account m1124a(Context context, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        for (Account account : m1127b(context)) {
            if (str.equals(account.name)) {
                return account;
            }
        }
        return null;
    }

    public static int m1123a(Context context) {
        return m1127b(context).length;
    }

    private static Account[] m1127b(Context context) {
        Account[] accountsByType;
        try {
            accountsByType = AccountManager.get(context).getAccountsByType("com.facebook.auth.login");
        } catch (Throwable e) {
            BLog.c(f785a, "Unexpected error", e);
            accountsByType = null;
        }
        return accountsByType == null ? new Account[0] : accountsByType;
    }

    public static void m1126a(Intent intent, String str) {
        AccountAuthenticatorResponse accountAuthenticatorResponse = (AccountAuthenticatorResponse) intent.getParcelableExtra("accountAuthenticatorResponse");
        if (accountAuthenticatorResponse == null) {
            BLog.b(f785a, "No callback IBinder");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", str);
        bundle.putString("accountType", "com.facebook.auth.login");
        accountAuthenticatorResponse.onResult(bundle);
    }

    public static void m1125a(Intent intent, int i, String str) {
        AccountAuthenticatorResponse accountAuthenticatorResponse = (AccountAuthenticatorResponse) intent.getParcelableExtra("accountAuthenticatorResponse");
        if (accountAuthenticatorResponse == null) {
            BLog.b(f785a, "No callback IBinder");
        } else {
            accountAuthenticatorResponse.onError(i, str);
        }
    }

    public final void m1128a() {
        this.f787c = new FacebookAccountAuthenticator(this);
    }

    public IBinder onBind(Intent intent) {
        if ("android.accounts.AccountAuthenticator".equals(intent.getAction())) {
            return this.f787c.getIBinder();
        }
        BLog.b(f785a, "Bound with unknown intent: " + intent);
        return null;
    }
}

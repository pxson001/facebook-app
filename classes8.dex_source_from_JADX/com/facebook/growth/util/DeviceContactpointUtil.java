package com.facebook.growth.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Patterns;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: effective_region */
public class DeviceContactpointUtil {
    private final Context f14900a;

    public static DeviceContactpointUtil m17363b(InjectorLike injectorLike) {
        return new DeviceContactpointUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public DeviceContactpointUtil(Context context) {
        this.f14900a = context.getApplicationContext();
    }

    @Nullable
    public final String m17364a() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f14900a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getLine1Number();
    }

    @Nonnull
    public final List<String> m17365b() {
        return m17362a(AccountManager.get(this.f14900a).getAccounts());
    }

    @Nonnull
    public final List<String> m17366c() {
        return m17362a(AccountManager.get(this.f14900a).getAccountsByType("com.google"));
    }

    private static List<String> m17362a(Account[] accountArr) {
        Builder builder = new Builder();
        if (accountArr != null) {
            for (Account account : accountArr) {
                if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches()) {
                    builder.c(account.name);
                }
            }
        }
        return builder.b();
    }
}

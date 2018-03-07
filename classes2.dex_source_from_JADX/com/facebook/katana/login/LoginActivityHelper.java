package com.facebook.katana.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Patterns;
import com.facebook.base.activity.FragmentBaseActivityUtil;
import com.facebook.common.android.AccountManagerMethodAutoProvider;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: social_context_truncated */
public class LoginActivityHelper {
    @Inject
    public volatile Provider<FragmentBaseActivityUtil> f4383a = UltralightRuntime.f367a;
    private final InterstitialManager f4384b;
    private final Activity f4385c;
    private final AccountManager f4386d;
    public TelephonyManager f4387e;
    private FbSharedPreferences f4388f;
    public String f4389g;

    public static LoginActivityHelper m8072b(InjectorLike injectorLike) {
        LoginActivityHelper loginActivityHelper = new LoginActivityHelper(InterstitialManager.m8082a(injectorLike), ActivityMethodAutoProvider.m6475b(injectorLike), AccountManagerMethodAutoProvider.m8174b(injectorLike), TelephonyManagerMethodAutoProvider.m3851b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
        loginActivityHelper.f4383a = IdBasedProvider.m1811a(injectorLike, 391);
        return loginActivityHelper;
    }

    @Inject
    private LoginActivityHelper(InterstitialManager interstitialManager, Activity activity, AccountManager accountManager, TelephonyManager telephonyManager, FbSharedPreferences fbSharedPreferences) {
        this.f4384b = interstitialManager;
        this.f4385c = activity;
        this.f4386d = accountManager;
        this.f4387e = telephonyManager;
        this.f4388f = fbSharedPreferences;
    }

    public static LoginActivityHelper m8071a(InjectorLike injectorLike) {
        return m8072b(injectorLike);
    }

    public final Intent m8073a() {
        Intent intent = null;
        if (this.f4385c.getIntent().hasExtra("calling_intent")) {
            Intent intent2 = new Intent((Intent) this.f4385c.getIntent().getParcelableExtra("calling_intent"));
            intent2.setFlags(intent2.getFlags() & -268435457);
            intent = intent2;
        }
        return m8070a(intent);
    }

    public final Intent m8074b() {
        Intent intent;
        InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f4384b.m8118a(new InterstitialTrigger(Action.SESSION_COLD_START), InterstitialIntentController.class);
        if (interstitialIntentController != null) {
            this.f4389g = interstitialIntentController.mo1173b();
            Intent a = interstitialIntentController.mo1687a(this.f4385c);
            this.f4384b.m8121a().a(interstitialIntentController.mo1173b());
            intent = a;
        } else {
            intent = null;
        }
        return m8070a(intent);
    }

    public final Intent m8075d() {
        return m8070a(((FragmentBaseActivityUtil) this.f4383a.get()).a());
    }

    private Intent m8070a(Intent intent) {
        String stringExtra = this.f4385c.getIntent().getStringExtra("activity_launcher");
        if (!(stringExtra == null || intent == null)) {
            intent.putExtra("activity_launcher", stringExtra);
        }
        return intent;
    }

    public final boolean m8076e() {
        if (this.f4385c.getIntent().getBooleanExtra("add_account", false) && (this.f4385c.getIntent().getFlags() & 1048576) == 0) {
            return true;
        }
        return false;
    }

    public final String m8077f() {
        String str = null;
        try {
            str = this.f4388f.mo278a(FbandroidPrefKeys.f19422n, null);
        } catch (Throwable th) {
        }
        return str;
    }

    public final String m8078g() {
        String str = null;
        try {
            str = this.f4388f.mo278a(FbandroidPrefKeys.f19423o, null);
        } catch (Throwable th) {
        }
        return str;
    }

    public final long m8079h() {
        long j = 0;
        try {
            j = this.f4388f.mo277a(FbandroidPrefKeys.f19421m, 0);
        } catch (Throwable th) {
        }
        return j;
    }

    public final long m8080i() {
        long j = 0;
        try {
            j = this.f4388f.mo277a(FbandroidPrefKeys.f19424p, 0);
        } catch (Throwable th) {
        }
        return j;
    }

    public final Set<String> m8081j() {
        Set<String> d = Sets.m1329d();
        if (this.f4386d != null) {
            for (Account account : this.f4386d.getAccounts()) {
                if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches()) {
                    d.add(account.name);
                }
            }
        }
        return d;
    }
}

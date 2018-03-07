package com.facebook.katana.dbl;

import android.os.Bundle;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.prefs.DBLPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.user.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sms_takeover_use_better_default_check */
public class DBLStorageAndRetrievalHelper {
    public final FbSharedPreferences f4517a;
    private final DeviceBasedLoginActivityHelper f4518b;
    private final ObjectMapper f4519c;
    private final AbstractFbErrorReporter f4520d;
    private final Provider<User> f4521e;
    private final LoggedInUserSessionManager f4522f;
    private final MonotonicClock f4523g;
    private final DBLLoggerHelper f4524h;

    public static DBLStorageAndRetrievalHelper m8206b(InjectorLike injectorLike) {
        return new DBLStorageAndRetrievalHelper(FbSharedPreferencesImpl.m1826a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), LoggedInUserSessionManager.m2511a(injectorLike), DeviceBasedLoginActivityHelper.m8223b(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), DBLLoggerHelper.m8231b(injectorLike));
    }

    public static DBLStorageAndRetrievalHelper m8205a(InjectorLike injectorLike) {
        return m8206b(injectorLike);
    }

    @Inject
    public DBLStorageAndRetrievalHelper(FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper, FbErrorReporter fbErrorReporter, Provider<User> provider, LoggedInUserSessionManager loggedInUserSessionManager, DeviceBasedLoginActivityHelper deviceBasedLoginActivityHelper, MonotonicClock monotonicClock, DBLLoggerHelper dBLLoggerHelper) {
        this.f4517a = fbSharedPreferences;
        this.f4519c = objectMapper;
        this.f4520d = fbErrorReporter;
        this.f4521e = provider;
        this.f4522f = loggedInUserSessionManager;
        this.f4518b = deviceBasedLoginActivityHelper;
        this.f4523g = monotonicClock;
        this.f4524h = dBLLoggerHelper;
    }

    public final void m8209a(DBLFacebookCredentials dBLFacebookCredentials) {
        if (dBLFacebookCredentials.mUserId != null) {
            PrefKey prefKey = (PrefKey) AuthPrefKeys.f2956k.m2011a(dBLFacebookCredentials.mUserId);
            m8216e(dBLFacebookCredentials.mUserId);
            try {
                Editor edit = this.f4517a.edit();
                edit.mo1276a(prefKey, this.f4519c.m6659a((Object) dBLFacebookCredentials));
                edit.commit();
            } catch (Throwable e) {
                this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in saving the DBLcredentials in FbSharedPreferences", e);
            }
        }
    }

    public final List<DBLFacebookCredentials> m8208a() {
        List<DBLFacebookCredentials> a = Lists.m1296a();
        for (Entry value : this.f4517a.mo297e(AuthPrefKeys.f2956k).entrySet()) {
            try {
                a.add((DBLFacebookCredentials) this.f4519c.m6657a((String) value.getValue(), DBLFacebookCredentials.class));
            } catch (Throwable e) {
                this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in reading the DBLcredentials from FbSharedPreferences", e);
            }
        }
        if (this.f4518b.m8225b()) {
            for (Entry value2 : this.f4517a.mo297e(AuthPrefKeys.f2967v).entrySet()) {
                try {
                    a.add((DBLFacebookCredentials) this.f4519c.m6657a((String) value2.getValue(), DBLFacebookCredentials.class));
                } catch (Throwable e2) {
                    this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in reading the DBLPasswordAccountcredentials from FbSharedPreferences", e2);
                }
            }
        }
        return a;
    }

    public final Boolean m8213c() {
        return Boolean.valueOf(m8214d() != 0);
    }

    public final void m8211b(String str) {
        if (str != null) {
            PrefKey prefKey = (PrefKey) AuthPrefKeys.f2956k.m2011a(str);
            Editor edit = this.f4517a.edit();
            edit.mo1271a(prefKey);
            edit.mo1274a((PrefKey) AuthPrefKeys.f2966u.m2011a(str), -1);
            edit.commit();
        }
    }

    public final DBLFacebookCredentials m8212c(String str) {
        if (str == null) {
            return null;
        }
        PrefKey prefKey;
        DBLFacebookCredentials dBLFacebookCredentials;
        if (m8218f(str)) {
            prefKey = (PrefKey) AuthPrefKeys.f2967v.m2011a(str);
        } else {
            prefKey = (PrefKey) AuthPrefKeys.f2956k.m2011a(str);
        }
        String a = this.f4517a.mo278a(prefKey, null);
        if (a != null) {
            try {
                dBLFacebookCredentials = (DBLFacebookCredentials) this.f4519c.m6657a(a, DBLFacebookCredentials.class);
            } catch (Throwable e) {
                this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in reading the DBLcredentials from FbSharedPreferences", e);
            }
            return dBLFacebookCredentials;
        }
        dBLFacebookCredentials = null;
        return dBLFacebookCredentials;
    }

    public final int m8214d() {
        int size = this.f4517a.mo297e(AuthPrefKeys.f2956k).size();
        int i = 0;
        if (this.f4518b.m8225b()) {
            i = this.f4517a.mo297e(AuthPrefKeys.f2967v).size();
        }
        return i + size;
    }

    public final Boolean m8217f() {
        return Boolean.valueOf(this.f4517a.mo286a(AuthPrefKeys.f2961p, false));
    }

    public final int m8219h() {
        int i = 0;
        for (Entry value : this.f4517a.mo297e(AuthPrefKeys.f2956k).entrySet()) {
            try {
                int i2;
                if (((DBLFacebookCredentials) this.f4519c.m6657a((String) value.getValue(), DBLFacebookCredentials.class)).mIsPinSet.booleanValue()) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            } catch (Throwable e) {
                this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in reading the DBLcredentials from FbSharedPreferences", e);
            }
        }
        return i;
    }

    public final int m8220i() {
        int i = 0;
        for (Entry value : this.f4517a.mo297e(AuthPrefKeys.f2956k).entrySet()) {
            try {
                int i2;
                if ("".equals(((DBLFacebookCredentials) this.f4519c.m6657a((String) value.getValue(), DBLFacebookCredentials.class)).mNonce)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            } catch (Throwable e) {
                this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in reading the DBLcredentials from FbSharedPreferences", e);
            }
        }
        return i;
    }

    public final void m8221k() {
        User user = (User) this.f4521e.get();
        if (user != null) {
            String d = user.m5840d();
            if (d != null && m8207g(d)) {
                PrefKey prefKey = (PrefKey) AuthPrefKeys.f2966u.m2011a(d);
                int a = this.f4517a.mo276a(prefKey, 0) + 1;
                this.f4517a.edit().mo1274a(prefKey, a).commit();
                Bundle bundle = new Bundle();
                bundle.putInt("counter_value", a);
                this.f4524h.m8232a("password_account_counter_incremented", bundle);
                if (a >= (m8213c().booleanValue() ? 3 : 1) && user != null) {
                    ViewerContext a2 = this.f4522f.m2517a();
                    if (a2 != null) {
                        try {
                            this.f4517a.edit().mo1276a((PrefKey) AuthPrefKeys.f2967v.m2011a(d), this.f4519c.m6659a(new DBLFacebookCredentials(d, (int) this.f4523g.now(), user.m5843h(), a2.m1531g(), user.m5856x(), "password_account", false))).commit();
                            bundle.putString("account_type", "password_account");
                            this.f4524h.m8232a("dbl_nux_save_account", bundle);
                        } catch (Throwable e) {
                            this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in saving the Password account credentials in FbSharedPreferences", e);
                        }
                    }
                }
            }
        }
    }

    public final boolean m8215d(String str) {
        if (!this.f4518b.m8225b() || str == null) {
            return false;
        }
        return this.f4517a.mo285a((PrefKey) AuthPrefKeys.f2966u.m2011a(str));
    }

    public final void m8210b(DBLFacebookCredentials dBLFacebookCredentials) {
        if (dBLFacebookCredentials.mUserId != null) {
            try {
                this.f4517a.edit().mo1276a((PrefKey) AuthPrefKeys.f2967v.m2011a(dBLFacebookCredentials.mUserId), this.f4519c.m6659a((Object) dBLFacebookCredentials)).mo1274a((PrefKey) AuthPrefKeys.f2966u.m2011a(dBLFacebookCredentials.mUserId), 3).commit();
            } catch (Throwable e) {
                this.f4520d.m2343a("DBLStorageAndRetrievalHelper", "Error encountered in saving the Password account credentials in FbSharedPreferences", e);
            }
        }
    }

    public final void m8216e(String str) {
        if (m8218f(str)) {
            this.f4517a.edit().mo1271a((PrefKey) AuthPrefKeys.f2967v.m2011a(str)).mo1274a((PrefKey) AuthPrefKeys.f2966u.m2011a(str), -1).mo1271a(DBLPrefKeys.a(str)).commit();
        }
    }

    public final boolean m8218f(String str) {
        if (str == null) {
            return false;
        }
        return this.f4517a.mo285a((PrefKey) AuthPrefKeys.f2967v.m2011a(str));
    }

    private boolean m8207g(String str) {
        if (str == null) {
            return false;
        }
        if (!this.f4518b.m8226c()) {
            return false;
        }
        if (this.f4517a.mo276a((PrefKey) AuthPrefKeys.f2966u.m2011a(str), 0) == -1) {
            return false;
        }
        PrefKey prefKey = (PrefKey) AuthPrefKeys.f2956k.m2011a(str);
        if (this.f4517a.mo285a((PrefKey) AuthPrefKeys.f2967v.m2011a(str))) {
            return false;
        }
        if (!this.f4517a.mo285a(prefKey)) {
            return true;
        }
        this.f4517a.edit().mo1274a((PrefKey) AuthPrefKeys.f2966u.m2011a(str), -1);
        return false;
    }
}

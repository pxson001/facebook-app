package com.facebook.push.fbpushtoken;

import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.push.externalcloud.PushPrefKeysSelector;
import com.facebook.push.registration.ServiceType;
import com.google.common.base.Objects;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: included_members */
public class PushTokenHolder {
    private static final Class<?> f10362a = PushTokenHolder.class;
    public final FbSharedPreferences f10363b;
    public final Provider<String> f10364c;
    private final ServiceType f10365d;
    public final AppVersionInfo f10366e;
    public final PushPrefKeys f10367f;
    public Clock f10368g;

    @Inject
    public PushTokenHolder(@Assisted ServiceType serviceType, FbSharedPreferences fbSharedPreferences, Provider<String> provider, AppVersionInfo appVersionInfo, PushPrefKeysSelector pushPrefKeysSelector, Clock clock) {
        this.f10363b = fbSharedPreferences;
        this.f10364c = provider;
        this.f10365d = serviceType;
        this.f10366e = appVersionInfo;
        this.f10367f = pushPrefKeysSelector.m10875a(this.f10365d);
        this.f10368g = clock;
    }

    public final String m10910a() {
        return this.f10363b.a(this.f10367f.f10372a, "");
    }

    public final ServiceType m10913b() {
        return m10909a(this.f10363b.a(this.f10367f.f10378g, null));
    }

    public final boolean m10914c() {
        return this.f10366e.b() != this.f10363b.a(this.f10367f.f10383l, Integer.MIN_VALUE);
    }

    public final ServiceType m10915e() {
        return m10909a(this.f10363b.a(this.f10367f.f10379h, null));
    }

    public final void m10912a(String str, boolean z) {
        this.f10363b.edit().putBoolean(this.f10367f.f10384m, z).a(this.f10367f.f10378g, str).commit();
    }

    public final boolean m10916f() {
        return this.f10363b.a(this.f10367f.f10384m, false);
    }

    public final String m10917g() {
        switch (this.f10365d) {
            case GCM:
                return m10916f() ? "" : "https://android.googleapis.com/gcm/send";
            case ADM:
                return "https://api.amazon.com/messaging/registrations/";
            case NNA:
                return "https://nnapi.ovi.com/nnapi/2.0/send";
            case FBNS:
            case FBNS_LITE:
                return "https://www.facebook.com/";
            default:
                throw new IllegalStateException("Unsupported push notification service type.");
        }
    }

    private static ServiceType m10909a(String str) {
        if (str == null) {
            return ServiceType.GCM;
        }
        try {
            return (ServiceType) Enum.valueOf(ServiceType.class, str);
        } catch (IllegalArgumentException e) {
            return ServiceType.GCM;
        }
    }

    public final void m10918h() {
        this.f10363b.edit().a(this.f10367f.f10372a, "").a(this.f10367f.f10373b, "").a(this.f10367f.f10383l, 0).a(this.f10367f.f10375d, this.f10368g.a()).putBoolean(this.f10367f.f10380i, false).commit();
    }

    public final void m10911a(String str, ServiceType serviceType) {
        long a = this.f10368g.a();
        Editor a2 = this.f10363b.edit().a(this.f10367f.f10372a, str).a(this.f10367f.f10375d, a).a(this.f10367f.f10374c, a).a(this.f10367f.f10379h, serviceType.toString()).a(this.f10367f.f10383l, this.f10366e.b());
        if (!Objects.equal(m10910a(), str)) {
            a2.putBoolean(this.f10367f.f10380i, false);
        }
        a2.commit();
    }

    public final String m10919i() {
        return this.f10363b.a(this.f10367f.f10373b, "");
    }

    public final boolean m10920k() {
        return this.f10363b.a(this.f10367f.f10380i, false);
    }

    public final long m10921l() {
        return this.f10363b.a(this.f10367f.f10374c, 0);
    }

    public final void m10922n() {
        this.f10363b.edit().putBoolean(this.f10367f.f10380i, false).commit();
    }

    public final long m10923o() {
        return this.f10363b.a(this.f10367f.f10382k, 0);
    }

    public final boolean m10924p() {
        TriState b = this.f10363b.b(this.f10367f.f10380i);
        String str = (String) this.f10364c.get();
        String a = m10910a();
        Object[] objArr = new Object[]{b, str, a, Integer.valueOf(Objects.hashCode(new Object[]{b, str, a})), Integer.valueOf(this.f10363b.a(this.f10367f.f10381j, 0))};
        return Objects.hashCode(new Object[]{b, str, a}) != this.f10363b.a(this.f10367f.f10381j, 0);
    }
}

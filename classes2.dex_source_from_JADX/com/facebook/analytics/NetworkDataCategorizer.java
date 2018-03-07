package com.facebook.analytics;

import android.os.SystemClock;
import com.facebook.analytics.webrequest.NetworkDataLoggerConfigProvider;
import com.facebook.analytics.webrequest.STATICDI_MULTIBIND_PROVIDER$NetworkDataLoggerConfigProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.util.logging.FB4ADataLoggerConfigProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.net.URI;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: null actor */
public class NetworkDataCategorizer implements INeedInit {
    private static final Class<?> f12040a = NetworkDataCategorizer.class;
    private final FbSharedPreferences f12041b;
    private final Set<NetworkDataLoggerConfigProvider> f12042c;
    @GuardedBy("this")
    private ImmutableMap<String, String> f12043d;
    @GuardedBy("this")
    private ImmutableMap<Pattern, String> f12044e;
    @GuardedBy("this")
    private long f12045f = 0;

    public static NetworkDataCategorizer m17747b(InjectorLike injectorLike) {
        return new NetworkDataCategorizer(FbSharedPreferencesImpl.m1826a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$NetworkDataLoggerConfigProvider(injectorLike)));
    }

    @Inject
    public NetworkDataCategorizer(FbSharedPreferences fbSharedPreferences, Set<NetworkDataLoggerConfigProvider> set) {
        this.f12041b = fbSharedPreferences;
        this.f12042c = set;
    }

    public void init() {
        this.f12041b.mo293c(InternalHttpPrefKeys.f2521p, new 1(this));
    }

    public final synchronized String m17750a(URI uri) {
        String str;
        m17748b();
        Object uri2 = uri.toString();
        Iterator it = this.f12044e.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Matcher matcher = ((Pattern) entry.getKey()).matcher(uri2);
            if (matcher != null && matcher.matches()) {
                str = (String) entry.getValue();
                break;
            }
        }
        it = this.f12043d.entrySet().iterator();
        while (it.hasNext()) {
            entry = (Entry) it.next();
            if (uri2.startsWith((String) entry.getKey())) {
                str = (String) entry.getValue();
                break;
            }
        }
        str = uri.getAuthority();
        if (str != null && (str.contains("fbcdn") || str.contains("fbstatic"))) {
            str = "cdn";
        } else if (str != null && str.contains("fbexternal")) {
            str = "cdn_external";
        } else if (m17749b(uri)) {
            str = "other_fb";
        } else {
            uri.toString();
            str = "uncategorized";
        }
        return str;
    }

    private static boolean m17749b(URI uri) {
        String host = uri.getHost();
        return host != null && host.endsWith(".facebook.com");
    }

    private synchronized void m17748b() {
        if (this.f12043d == null || this.f12044e == null || SystemClock.uptimeMillis() - this.f12045f > 43200000) {
            this.f12045f = SystemClock.uptimeMillis();
            Builder builder = ImmutableMap.builder();
            Builder builder2 = ImmutableMap.builder();
            for (FB4ADataLoggerConfigProvider fB4ADataLoggerConfigProvider : this.f12042c) {
                fB4ADataLoggerConfigProvider.m24640a(builder);
                fB4ADataLoggerConfigProvider.m24641b(builder2);
            }
            this.f12043d = builder.m610b();
            this.f12044e = builder2.m610b();
        }
    }

    public final synchronized void m17751a() {
        this.f12043d = null;
        this.f12044e = null;
    }
}

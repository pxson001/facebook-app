package com.facebook.composer.minutiae.ridge.config;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.resources.FbResources;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Provider;

/* compiled from: thu */
public class RidgeTooltipNuxXConfigUtil {
    private static final String f1762b = RidgeTooltipNuxXConfigUtil.class.getSimpleName();
    @Inject
    public volatile Provider<JsonFactory> f1763a = UltralightRuntime.a;
    private final XConfigReader f1764c;
    private final FbResources f1765d;
    private final AbstractFbErrorReporter f1766e;
    private ImmutableMap<String, String> f1767f;

    /* compiled from: thu */
    class C01761 extends TypeReference<ImmutableMap<String, String>> {
        final /* synthetic */ RidgeTooltipNuxXConfigUtil f1761b;

        C01761(RidgeTooltipNuxXConfigUtil ridgeTooltipNuxXConfigUtil) {
            this.f1761b = ridgeTooltipNuxXConfigUtil;
        }
    }

    @Inject
    public RidgeTooltipNuxXConfigUtil(XConfigReader xConfigReader, FbResources fbResources, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1764c = xConfigReader;
        this.f1765d = fbResources;
        this.f1766e = abstractFbErrorReporter;
    }

    public final int m1732a() {
        return this.f1764c.a(RidgeXConfig.d, 3);
    }

    public final boolean m1733a(String str) {
        return m1731c().get(str) != null;
    }

    public final String m1735b(String str) {
        return (String) m1731c().get(str);
    }

    public final String m1734b() {
        return "MaxImp: " + m1732a() + "; ContentsMap: " + m1731c().toString() + ";";
    }

    private ImmutableMap<String, String> m1730a(ImmutableMap<String, String> immutableMap) {
        Builder builder = ImmutableMap.builder();
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("content_watching".equals(str2)) {
                builder.b(str, this.f1765d.getString(2131234702));
            } else if ("content_listening".equals(str2)) {
                builder.b(str, this.f1765d.getString(2131234703));
            }
        }
        return builder.b();
    }

    private ImmutableMap<String, String> m1731c() {
        if (this.f1767f == null) {
            ImmutableMap a;
            String a2 = this.f1764c.a(RidgeXConfig.e, null);
            ImmutableBiMap a3 = ImmutableBiMap.a();
            if (a2 != null) {
                try {
                    a = m1730a((ImmutableMap) ((JsonFactory) this.f1763a.get()).a(a2).a(new C01761(this)));
                } catch (Throwable e) {
                    this.f1766e.b(f1762b, "Json parse failure: " + a2, e);
                }
                this.f1767f = a;
            }
            a = a3;
            this.f1767f = a;
        }
        return this.f1767f;
    }
}

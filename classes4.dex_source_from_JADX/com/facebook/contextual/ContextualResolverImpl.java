package com.facebook.contextual;

import com.facebook.debug.log.BLog;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.facebook.xconfig.core.XConfigSyncListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: speex_per_packet_ispx */
public class ContextualResolverImpl implements XConfigSyncListener {
    Map<Long, ContextualConfig> f1940a = new HashMap();
    Map<Character, ContextualConfig> f1941b = new HashMap();
    Map<XConfigSetting, ContextualConfig> f1942c = new HashMap();
    DefaultRawContextualConfigSourceImpl f1943d;
    ContextualConfigFactoryImpl f1944e;
    ContextualConfigLogger f1945f;
    ContextualConfigEvaluationResult f1946g;

    public ContextualResolverImpl(DefaultRawContextualConfigSourceImpl defaultRawContextualConfigSourceImpl, ContextualConfigFactoryImpl contextualConfigFactoryImpl, ContextualConfigLogger contextualConfigLogger) {
        this.f1943d = defaultRawContextualConfigSourceImpl;
        this.f1944e = contextualConfigFactoryImpl;
        this.f1945f = contextualConfigLogger;
        this.f1946g = new ContextualConfigEvaluationResult();
    }

    public final ContextualConfigEvaluationResult m2013a(XConfigSetting xConfigSetting) {
        return m2009a(m2011b(xConfigSetting), null);
    }

    public final long m2012a(XConfigSetting xConfigSetting, long j) {
        return m2009a(m2011b(xConfigSetting), null).m2019a(0, j);
    }

    public final String m2015a(XConfigSetting xConfigSetting, String str) {
        return m2009a(m2011b(xConfigSetting), null).m2020a(0, str);
    }

    private ContextualConfig m2011b(XConfigSetting xConfigSetting) {
        ContextualConfig contextualConfig = (ContextualConfig) this.f1942c.get(xConfigSetting);
        if (contextualConfig != null) {
            return contextualConfig;
        }
        String str = null;
        String a = this.f1943d.f1932c.a(xConfigSetting, null);
        if (a != null) {
            str = new RawConfig(a).a("param_name", xConfigSetting.a).a("xconfig", xConfigSetting.b.toString());
        }
        contextualConfig = m2008a((RawConfig) str);
        this.f1942c.put(xConfigSetting, contextualConfig);
        return contextualConfig;
    }

    private ContextualConfig m2008a(RawConfig rawConfig) {
        if (rawConfig != null) {
            return (ContextualConfig) m2010a(this.f1944e.m2006a(rawConfig));
        }
        try {
            throw new ContextualConfigError("Config not found");
        } catch (ContextualConfigError e) {
            ContextualConfigError contextualConfigError = e;
            String str = "ContextualResolverImpl";
            String str2 = "Error analyzing configuration: %s";
            Object[] objArr = new Object[1];
            objArr[0] = rawConfig != null ? rawConfig.a() : "CONFIG_NOT_FOUND!";
            BLog.b(str, str2, objArr);
            return new ErrorContextualConfig(rawConfig, contextualConfigError.getMessage());
        }
    }

    private ContextualConfigEvaluationResult m2009a(ContextualConfig contextualConfig, LocalContextsProvider localContextsProvider) {
        try {
            ContextualConfigEvaluationResult contextualConfigEvaluationResult = (ContextualConfigEvaluationResult) m2010a(contextualConfig.a(localContextsProvider));
            this.f1945f.mo135a(contextualConfig.a(), contextualConfigEvaluationResult);
            return contextualConfigEvaluationResult;
        } catch (ContextualConfigError e) {
            this.f1945f.mo136a(contextualConfig.a(), e.getMessage());
            return this.f1946g;
        }
    }

    private static <T> T m2010a(T t) {
        if (t != null) {
            return t;
        }
        throw new ContextualConfigError("Illegal null value");
    }

    public final void mo138a(XConfigName xConfigName) {
        BLog.b("ContextualResolverImpl", "updated: %s", new Object[]{xConfigName.toString()});
        List<XConfigSetting> arrayList = new ArrayList();
        for (Entry entry : this.f1942c.entrySet()) {
            if (((XConfigSetting) entry.getKey()).b.equals(xConfigName)) {
                arrayList.add(entry.getKey());
            }
        }
        for (XConfigSetting remove : arrayList) {
            this.f1942c.remove(remove);
        }
    }

    public final XConfigName mo137a() {
        return XConfigName.d;
    }
}

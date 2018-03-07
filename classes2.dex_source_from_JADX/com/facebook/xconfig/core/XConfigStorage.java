package com.facebook.xconfig.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"SharedPreferencesUse"})
/* compiled from: username */
public class XConfigStorage {
    private static final String f1410a = m2694d("LATEST", "EVERY_USER");
    private static final String f1411b = m2694d("OVERRIDE", "EVERY_USER");
    private static volatile XConfigStorage f1412g;
    private final Context f1413c;
    private final DefaultProcessUtil f1414d;
    @Nullable
    private String f1415e = null;
    @Nullable
    private String f1416f = null;

    public static com.facebook.xconfig.core.XConfigStorage m2688a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1412g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.xconfig.core.XConfigStorage.class;
        monitor-enter(r1);
        r0 = f1412g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2692b(r0);	 Catch:{ all -> 0x0035 }
        f1412g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1412g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.xconfig.core.XConfigStorage.a(com.facebook.inject.InjectorLike):com.facebook.xconfig.core.XConfigStorage");
    }

    private static XConfigStorage m2692b(InjectorLike injectorLike) {
        return new XConfigStorage((Context) injectorLike.getInstance(Context.class), DefaultProcessUtil.m2387a(injectorLike));
    }

    @Inject
    public XConfigStorage(Context context, DefaultProcessUtil defaultProcessUtil) {
        this.f1413c = context;
        this.f1414d = defaultProcessUtil;
    }

    public final void m2701a(String str) {
        TracerDetour.a("XConfigStorage.init", 2093171123);
        try {
            m2695d(str);
            m2697e(str);
        } finally {
            TracerDetour.a(-232343092);
        }
    }

    private void m2695d(String str) {
        TracerDetour.a("XConfigStorage.initOverrideStorage", 951890118);
        try {
            m2687a("OVERRIDE", str);
        } finally {
            TracerDetour.a(1956486195);
        }
    }

    private void m2697e(String str) {
        TracerDetour.a("XConfigStorage.initServerStorage", 732832842);
        try {
            m2687a("LATEST", str);
        } finally {
            TracerDetour.a(-486423373);
        }
    }

    @Nullable
    public final String m2700a(@Nullable String str, XConfigSetting xConfigSetting) {
        TracerDetour.a("XConfigStorage.readValue", 334147967);
        try {
            String a = m2689a(xConfigSetting);
            String string = m2687a("OVERRIDE", str).getString(a, null);
            if (string != null) {
                return string;
            }
            string = m2687a("LATEST", str).getString(a, null);
            if (string != null) {
                TracerDetour.a(-1234299581);
                return string;
            }
            xConfigSetting.f4701b.m2012a();
            TracerDetour.a(-1460996926);
            return null;
        } finally {
            TracerDetour.a(2079796516);
        }
    }

    public final synchronized ImmutableMap<String, String> m2699a(@Nullable String str, Iterable<String> iterable) {
        Builder builder;
        SharedPreferences a = m2687a("LATEST", str);
        builder = ImmutableMap.builder();
        for (String str2 : iterable) {
            String string = a.getString(m2696e(str2, "@ConfigHash"), null);
            if (string != null) {
                builder.m609b(string, a.getString(m2696e(str2, "@ValueHash"), ""));
            }
        }
        return builder.m610b();
    }

    public final boolean m2702a(@Nullable String str, ImmutableMap<String, XConfigAndValueInformation> immutableMap) {
        if (!m2691a()) {
            return false;
        }
        Editor edit = m2687a("LATEST", str).edit();
        edit.clear();
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str2 = (String) entry.getKey();
            XConfigAndValueInformation xConfigAndValueInformation = (XConfigAndValueInformation) entry.getValue();
            edit.putString(m2696e(str2, "@ConfigHash"), xConfigAndValueInformation.c);
            edit.putString(m2696e(str2, "@ValueHash"), xConfigAndValueInformation.d);
            Iterator it2 = xConfigAndValueInformation.b.entrySet().iterator();
            while (it2.hasNext()) {
                entry = (Entry) it2.next();
                edit.putString(m2696e(str2, (String) entry.getKey()), (String) entry.getValue());
            }
        }
        edit.putLong("last_sync_time", System.currentTimeMillis());
        synchronized (this) {
            if (edit.commit()) {
                return true;
            }
            return false;
        }
    }

    public final synchronized boolean m2703b(String str) {
        boolean z = false;
        synchronized (this) {
            if (m2691a() && m2698f(str) && m2687a("OVERRIDE", str).edit().clear().commit() && m2687a("LATEST", str).edit().clear().commit()) {
                z = true;
            }
        }
        return z;
    }

    public final boolean m2704c(String str) {
        return m2687a("LATEST", str).getLong("last_sync_time", -1) != -1;
    }

    @VisibleForTesting
    private SharedPreferences m2687a(String str, @Nullable String str2) {
        return this.f1413c.getSharedPreferences(m2693b(str, str2), 0);
    }

    @Nullable
    @VisibleForTesting
    private String m2693b(String str, @Nullable String str2) {
        if (m2698f(str2)) {
            Preconditions.checkNotNull(str2);
            String a;
            if ("OVERRIDE".equals(str)) {
                a = m2690a("OVERRIDE", this.f1416f, str2);
                this.f1416f = a;
                return a;
            }
            a = m2690a("LATEST", this.f1415e, str2);
            this.f1415e = a;
            return a;
        } else if ("LATEST".equals(str)) {
            return f1410a;
        } else {
            return f1411b;
        }
    }

    @Nullable
    private static String m2690a(String str, @Nullable String str2, String str3) {
        Object obj = null;
        if (str2 != null) {
            int length = (str2.length() - str3.length()) - 1;
            if (length >= 0 && str2.charAt(length) == '-' && str2.endsWith(str3)) {
                obj = 1;
            }
        }
        if (obj != null) {
            return str2;
        }
        return m2694d(str, str3);
    }

    @VisibleForTesting
    private static String m2694d(String str, @Nullable String str2) {
        return "XStorage-" + str + "-" + str2;
    }

    private static boolean m2698f(@Nullable String str) {
        return (Strings.isNullOrEmpty(str) || "EVERY_USER".equals(str)) ? false : true;
    }

    private static String m2689a(XConfigSetting xConfigSetting) {
        String str = xConfigSetting.f4702c;
        if (str != null) {
            return str;
        }
        str = m2696e(xConfigSetting.f4701b.m2012a(), xConfigSetting.f4700a);
        xConfigSetting.f4702c = str;
        return str;
    }

    @VisibleForTesting
    private static String m2696e(String str, String str2) {
        return str + ":" + str2;
    }

    private boolean m2691a() {
        return this.f1414d.m2389a().e();
    }
}

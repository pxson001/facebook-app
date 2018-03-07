package com.facebook.browser.prefetch.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: stickers AS s  */
public class BrowserPrefetchConfig extends XConfig {
    public static final XConfigSetting f1677c = new XConfigSetting(f1679e, "request_header");
    public static final XConfigSetting f1678d = new XConfigSetting(f1679e, "click_request_header");
    private static final XConfigName f1679e = new XConfigName("android_browser_prefetch");
    private static volatile BrowserPrefetchConfig f1680f;

    public static com.facebook.browser.prefetch.config.BrowserPrefetchConfig m1927a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1680f;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.browser.prefetch.config.BrowserPrefetchConfig.class;
        monitor-enter(r1);
        r0 = f1680f;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1926a();	 Catch:{ all -> 0x0034 }
        f1680f = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1680f;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.browser.prefetch.config.BrowserPrefetchConfig.a(com.facebook.inject.InjectorLike):com.facebook.browser.prefetch.config.BrowserPrefetchConfig");
    }

    private static BrowserPrefetchConfig m1926a() {
        return new BrowserPrefetchConfig();
    }

    @Inject
    public BrowserPrefetchConfig() {
        super(f1679e, ImmutableSet.of(f1677c, f1678d));
    }

    public static HashMap<String, String> m1928a(XConfigReader xConfigReader, XConfigSetting xConfigSetting) {
        String a = xConfigReader.a(xConfigSetting, "{}");
        HashMap<String, String> hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(a);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            a = (String) keys.next();
            hashMap.put(a, jSONObject.getString(a));
        }
        return hashMap;
    }
}

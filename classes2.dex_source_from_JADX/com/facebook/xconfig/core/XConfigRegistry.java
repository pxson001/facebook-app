package com.facebook.xconfig.core;

import android.annotation.SuppressLint;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.xconfig.core.STATICDI_MULTIBIND_PROVIDER.XConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sgp_proxygen_android */
public class XConfigRegistry {
    private static volatile XConfigRegistry f5022c;
    @Nullable
    private ImmutableMap<String, XConfigInformation> f5023a = null;
    private final Set<XConfig> f5024b;

    public static com.facebook.xconfig.core.XConfigRegistry m8935a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5022c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.xconfig.core.XConfigRegistry.class;
        monitor-enter(r1);
        r0 = f5022c;	 Catch:{ all -> 0x003a }
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
        r0 = m8939b(r0);	 Catch:{ all -> 0x0035 }
        f5022c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5022c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.xconfig.core.XConfigRegistry.a(com.facebook.inject.InjectorLike):com.facebook.xconfig.core.XConfigRegistry");
    }

    private static XConfigRegistry m8939b(InjectorLike injectorLike) {
        return new XConfigRegistry(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new XConfig(injectorLike)));
    }

    @Inject
    public XConfigRegistry(Set<XConfig> set) {
        this.f5024b = set;
    }

    public final synchronized ImmutableMap<String, XConfigInformation> m8942a() {
        if (this.f5023a == null) {
            this.f5023a = m8940b();
        }
        return this.f5023a;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.charAt", "BadMethodUse-java.lang.String.length"})
    public static boolean m8938a(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        if (!m8937a(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            Object obj;
            char charAt = str.charAt(i);
            if (m8937a(charAt) || ('0' <= charAt && charAt <= '9')) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean m8937a(char c) {
        return ('a' <= c && c <= 'z') || (('A' <= c && c <= 'Z') || c == '_');
    }

    @VisibleForTesting
    private static String m8941b(String str) {
        TracerDetour.a("XConfigRegistry.computeHashFromDescriptor", -1636605442);
        try {
            String hashCode = Hashing.b().a(str, Charset.defaultCharset()).toString();
            return hashCode;
        } finally {
            TracerDetour.a(1846840876);
        }
    }

    @VisibleForTesting
    private static String m8936a(XConfigName xConfigName, Iterable<XConfigSetting> iterable) {
        TracerDetour.a("XConfigRegistry.computeConfigDescriptor", 1460359734);
        try {
            Iterable a = Lists.m1298a((Iterable) iterable);
            Collections.sort(a);
            String str = xConfigName + "!!" + Joiner.on(",").join(a);
            return str;
        } finally {
            TracerDetour.a(633027069);
        }
    }

    @VisibleForTesting
    private ImmutableMap<String, XConfigInformation> m8940b() {
        TracerDetour.a("XConfigRegistry.buildRegistry", 1945329541);
        try {
            Builder builder = ImmutableMap.builder();
            for (XConfig xConfig : this.f5024b) {
                String a = m8936a(xConfig.f4698a, xConfig.f4699b);
                builder.m609b(xConfig.f4698a.m2012a(), new XConfigInformation(xConfig.f4698a, xConfig.f4699b, a, m8941b(a)));
            }
            ImmutableMap<String, XConfigInformation> b = builder.m610b();
            return b;
        } finally {
            TracerDetour.a(-868840152);
        }
    }
}

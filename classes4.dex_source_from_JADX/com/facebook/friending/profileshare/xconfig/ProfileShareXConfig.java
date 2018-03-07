package com.facebook.friending.profileshare.xconfig;

import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sticker_asserts as preview_assets  */
public class ProfileShareXConfig extends XConfig {
    private static final XConfigName f1767c = new XConfigName("fb4a_profile_share");
    private static final XConfigSetting f1768d = new XConfigSetting(f1767c, "blacklist");
    private static final XConfigSetting f1769e = new XConfigSetting(f1767c, "whitelist");
    private static final ImmutableSet<XConfigSetting> f1770f = ImmutableSet.of(f1768d, f1769e);
    private static volatile ProfileShareXConfig f1771h;
    private final XConfigReader f1772g;

    public static com.facebook.friending.profileshare.xconfig.ProfileShareXConfig m1937a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1771h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friending.profileshare.xconfig.ProfileShareXConfig.class;
        monitor-enter(r1);
        r0 = f1771h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1938b(r0);	 Catch:{ all -> 0x0035 }
        f1771h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1771h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friending.profileshare.xconfig.ProfileShareXConfig.a(com.facebook.inject.InjectorLike):com.facebook.friending.profileshare.xconfig.ProfileShareXConfig");
    }

    private static ProfileShareXConfig m1938b(InjectorLike injectorLike) {
        return new ProfileShareXConfig(XConfigReader.a(injectorLike));
    }

    @Inject
    public ProfileShareXConfig(XConfigReader xConfigReader) {
        super(f1767c, f1770f);
        this.f1772g = xConfigReader;
    }

    public final List<String> m1939a() {
        CharSequence a = this.f1772g.a(f1768d, null);
        return a != null ? Splitter.on(", ").splitToList(a) : new ArrayList();
    }

    public final List<String> m1940b() {
        CharSequence a = this.f1772g.a(f1769e, null);
        return a != null ? Splitter.on(", ").splitToList(a) : new ArrayList();
    }
}

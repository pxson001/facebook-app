package com.facebook.vault.prefs;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.vault.model.BlacklistedSyncPath;
import com.facebook.vault.model.BlacklistedSyncPathsGroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: legacy_key_value */
public class BlacklistedSyncPathsPref {
    private static volatile BlacklistedSyncPathsPref f9428d;
    public final FbSharedPreferences f9429a;
    private final ObjectMapper f9430b;
    public final Clock f9431c;

    public static com.facebook.vault.prefs.BlacklistedSyncPathsPref m9806a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9428d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.vault.prefs.BlacklistedSyncPathsPref.class;
        monitor-enter(r1);
        r0 = f9428d;	 Catch:{ all -> 0x003a }
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
        r0 = m9807b(r0);	 Catch:{ all -> 0x0035 }
        f9428d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9428d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.vault.prefs.BlacklistedSyncPathsPref.a(com.facebook.inject.InjectorLike):com.facebook.vault.prefs.BlacklistedSyncPathsPref");
    }

    private static BlacklistedSyncPathsPref m9807b(InjectorLike injectorLike) {
        return new BlacklistedSyncPathsPref((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BlacklistedSyncPathsPref(FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper, Clock clock) {
        this.f9429a = fbSharedPreferences;
        this.f9430b = objectMapper;
        this.f9431c = clock;
    }

    public final List<String> m9808b() {
        List<String> a = Lists.a();
        Object a2 = this.f9429a.a(VaultPrefKeys.f11555j, "");
        if (!StringUtil.a(a2)) {
            BlacklistedSyncPathsGroup blacklistedSyncPathsGroup = (BlacklistedSyncPathsGroup) this.f9430b.a(a2, BlacklistedSyncPathsGroup.class);
            for (int i = 0; i < blacklistedSyncPathsGroup.paths.size(); i++) {
                a.add(((BlacklistedSyncPath) blacklistedSyncPathsGroup.paths.get(i)).path);
            }
        }
        return a;
    }
}

package com.facebook.deeplinking;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.TriState;
import com.facebook.deeplinking.activity.DeepLinkingAliasActivity;
import com.facebook.deeplinking.activity.DeepLinkingLegacyAliasActivity;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_takeover_carrier_config */
public class DeepLinkingPrefsWatcher implements INeedInit {
    private static volatile DeepLinkingPrefsWatcher f2035c;
    public final Context f2036a;
    private final Provider<TriState> f2037b;

    public static com.facebook.deeplinking.DeepLinkingPrefsWatcher m2118a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2035c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.deeplinking.DeepLinkingPrefsWatcher.class;
        monitor-enter(r1);
        r0 = f2035c;	 Catch:{ all -> 0x003a }
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
        r0 = m2120b(r0);	 Catch:{ all -> 0x0035 }
        f2035c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2035c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.deeplinking.DeepLinkingPrefsWatcher.a(com.facebook.inject.InjectorLike):com.facebook.deeplinking.DeepLinkingPrefsWatcher");
    }

    private static DeepLinkingPrefsWatcher m2120b(InjectorLike injectorLike) {
        return new DeepLinkingPrefsWatcher((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 663));
    }

    @Inject
    public DeepLinkingPrefsWatcher(Context context, Provider<TriState> provider) {
        this.f2036a = context;
        this.f2037b = provider;
    }

    public void init() {
        m2119a(this);
    }

    public static void m2119a(DeepLinkingPrefsWatcher deepLinkingPrefsWatcher) {
        int i;
        boolean asBoolean = ((TriState) deepLinkingPrefsWatcher.f2037b.get()).asBoolean(false);
        int i2 = 2;
        if (asBoolean) {
            i = 1;
        } else {
            i = 2;
        }
        deepLinkingPrefsWatcher.f2036a.getPackageManager().setComponentEnabledSetting(new ComponentName(deepLinkingPrefsWatcher.f2036a, DeepLinkingAliasActivity.class), i, 1);
        ComponentName componentName = new ComponentName(deepLinkingPrefsWatcher.f2036a, DeepLinkingLegacyAliasActivity.class);
        if (!asBoolean) {
            i2 = 1;
        }
        deepLinkingPrefsWatcher.f2036a.getPackageManager().setComponentEnabledSetting(componentName, i2, 1);
    }
}

package com.facebook.composer.shareintent;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_promo_seen */
public class AlphabeticalShareIntentAliasPrefsWatcher implements INeedInit {
    private static volatile AlphabeticalShareIntentAliasPrefsWatcher f2038c;
    private final Context f2039a;
    private final Provider<Boolean> f2040b;

    public static com.facebook.composer.shareintent.AlphabeticalShareIntentAliasPrefsWatcher m2121a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2038c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.shareintent.AlphabeticalShareIntentAliasPrefsWatcher.class;
        monitor-enter(r1);
        r0 = f2038c;	 Catch:{ all -> 0x003a }
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
        r0 = m2123b(r0);	 Catch:{ all -> 0x0035 }
        f2038c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2038c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.shareintent.AlphabeticalShareIntentAliasPrefsWatcher.a(com.facebook.inject.InjectorLike):com.facebook.composer.shareintent.AlphabeticalShareIntentAliasPrefsWatcher");
    }

    private static AlphabeticalShareIntentAliasPrefsWatcher m2123b(InjectorLike injectorLike) {
        return new AlphabeticalShareIntentAliasPrefsWatcher((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3933));
    }

    @Inject
    public AlphabeticalShareIntentAliasPrefsWatcher(Context context, Provider<Boolean> provider) {
        this.f2039a = context;
        this.f2040b = provider;
    }

    public void init() {
        m2122a(this);
    }

    public static void m2122a(AlphabeticalShareIntentAliasPrefsWatcher alphabeticalShareIntentAliasPrefsWatcher) {
        int i = 2;
        boolean booleanValue = ((Boolean) alphabeticalShareIntentAliasPrefsWatcher.f2040b.get()).booleanValue();
        ComponentName componentName = new ComponentName(alphabeticalShareIntentAliasPrefsWatcher.f2039a, "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias");
        ComponentName componentName2 = new ComponentName(alphabeticalShareIntentAliasPrefsWatcher.f2039a, "com.facebook.composer.shareintent.ImplicitShareIntentHandlerAlphabeticalAlias");
        alphabeticalShareIntentAliasPrefsWatcher.f2039a.getPackageManager().setComponentEnabledSetting(componentName, booleanValue ? 2 : 1, 1);
        PackageManager packageManager = alphabeticalShareIntentAliasPrefsWatcher.f2039a.getPackageManager();
        if (booleanValue) {
            i = 1;
        }
        packageManager.setComponentEnabledSetting(componentName2, i, 1);
    }
}

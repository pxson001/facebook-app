package com.facebook.katana.intent;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.internal.InternalIntentSigner;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: souvenirPrompt */
public class Fb4aInternalIntentSigner implements InternalIntentSigner {
    private static volatile Fb4aInternalIntentSigner f4272c;
    private Context f4273a;
    private Provider<ComponentName> f4274b;

    public static com.facebook.katana.intent.Fb4aInternalIntentSigner m7903a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4272c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.intent.Fb4aInternalIntentSigner.class;
        monitor-enter(r1);
        r0 = f4272c;	 Catch:{ all -> 0x003a }
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
        r0 = m7904b(r0);	 Catch:{ all -> 0x0035 }
        f4272c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4272c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.intent.Fb4aInternalIntentSigner.a(com.facebook.inject.InjectorLike):com.facebook.katana.intent.Fb4aInternalIntentSigner");
    }

    private static Fb4aInternalIntentSigner m7904b(InjectorLike injectorLike) {
        return new Fb4aInternalIntentSigner((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1809a(injectorLike, 11));
    }

    @Inject
    public Fb4aInternalIntentSigner(Context context, Provider<ComponentName> provider) {
        this.f4273a = context.getApplicationContext();
        this.f4274b = provider;
    }

    public final void mo1178a(Intent intent) {
        intent.putExtra("verified_caller_intent", SecurePendingIntent.a(this.f4273a, 0, new Intent().setComponent((ComponentName) this.f4274b.get()), 1073741824));
    }

    public final boolean mo1179b(Intent intent) {
        if (intent.hasExtra("verified_caller_intent")) {
            String creatorPackage;
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("verified_caller_intent");
            String packageName = ((ComponentName) this.f4274b.get()).getPackageName();
            if (VERSION.SDK_INT >= 17) {
                creatorPackage = pendingIntent.getCreatorPackage();
            } else {
                creatorPackage = pendingIntent.getTargetPackage();
            }
            return packageName.equals(creatorPackage);
        }
        Bundle extras = intent.getExtras();
        Object obj = (extras == null || extras.isEmpty()) ? null : 1;
        return obj == null;
    }

    public final ComponentName mo1177a() {
        return (ComponentName) this.f4274b.get();
    }
}

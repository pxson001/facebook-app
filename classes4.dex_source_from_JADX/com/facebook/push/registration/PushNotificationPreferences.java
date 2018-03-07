package com.facebook.push.registration;

import com.facebook.common.manifest.ManifestReader;
import com.facebook.common.manifest.ManifestReaderMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: incoming_hot_like_medium_message */
public class PushNotificationPreferences {
    private static volatile PushNotificationPreferences f10355c;
    private final ManifestReader f10356a;
    private final FbAndroidMessagingNotificationPreferences f10357b;

    public static com.facebook.push.registration.PushNotificationPreferences m10897a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10355c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.registration.PushNotificationPreferences.class;
        monitor-enter(r1);
        r0 = f10355c;	 Catch:{ all -> 0x003a }
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
        r0 = m10898b(r0);	 Catch:{ all -> 0x0035 }
        f10355c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10355c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.registration.PushNotificationPreferences.a(com.facebook.inject.InjectorLike):com.facebook.push.registration.PushNotificationPreferences");
    }

    private static PushNotificationPreferences m10898b(InjectorLike injectorLike) {
        return new PushNotificationPreferences(ManifestReaderMethodAutoProvider.b(injectorLike), FbAndroidMessagingNotificationPreferences.m10901a(injectorLike));
    }

    @Inject
    public PushNotificationPreferences(ManifestReader manifestReader, FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences) {
        this.f10356a = manifestReader;
        this.f10357b = fbAndroidMessagingNotificationPreferences;
    }

    protected final int m10899a() {
        int i = 0;
        if ("true".equals(this.f10356a.a("com.facebook.vi"))) {
            i = 2;
        }
        if (this.f10357b == null) {
            return i;
        }
        if (this.f10357b.m10906e()) {
            i |= 16;
        }
        if (this.f10357b.m10905d()) {
            i |= 32;
        }
        if (this.f10357b.m10907f()) {
            i |= 64;
        }
        if (this.f10357b.f10360b.a(NotificationsPreferenceConstants.f7732i, true)) {
            return i | 128;
        }
        return i;
    }

    public final long m10900b() {
        if (this.f10357b == null) {
            return 0;
        }
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f10357b;
        return 0;
    }
}

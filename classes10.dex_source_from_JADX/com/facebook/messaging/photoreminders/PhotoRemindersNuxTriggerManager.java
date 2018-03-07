package com.facebook.messaging.photoreminders;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: release_number */
public class PhotoRemindersNuxTriggerManager {
    private static volatile PhotoRemindersNuxTriggerManager f3534f;
    public final Clock f3535a;
    public final FbSharedPreferences f3536b;
    private final PhotoRemindersGatingUtil f3537c;
    public final Provider<Boolean> f3538d;
    private final QeAccessor f3539e;

    public static com.facebook.messaging.photoreminders.PhotoRemindersNuxTriggerManager m3395a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3534f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.photoreminders.PhotoRemindersNuxTriggerManager.class;
        monitor-enter(r1);
        r0 = f3534f;	 Catch:{ all -> 0x003a }
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
        r0 = m3396b(r0);	 Catch:{ all -> 0x0035 }
        f3534f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3534f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photoreminders.PhotoRemindersNuxTriggerManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.photoreminders.PhotoRemindersNuxTriggerManager");
    }

    private static PhotoRemindersNuxTriggerManager m3396b(InjectorLike injectorLike) {
        return new PhotoRemindersNuxTriggerManager((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PhotoRemindersGatingUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 4172), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoRemindersNuxTriggerManager(Clock clock, FbSharedPreferences fbSharedPreferences, PhotoRemindersGatingUtil photoRemindersGatingUtil, Provider<Boolean> provider, QeAccessor qeAccessor) {
        this.f3535a = clock;
        this.f3536b = fbSharedPreferences;
        this.f3537c = photoRemindersGatingUtil;
        this.f3538d = provider;
        this.f3539e = qeAccessor;
    }

    public final boolean m3398a() {
        int a = this.f3539e.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingPhotoRemindersModule.f3510e, 3);
        if (this.f3537c.b() && !this.f3537c.e() && !this.f3537c.d() && this.f3537c.f() && this.f3537c.g() && this.f3536b.a(MessagingPrefKeys.aJ, 0) < a && m3397c()) {
            boolean z;
            if (this.f3538d.get() == null) {
                z = false;
            } else {
                z = ((Boolean) this.f3538d.get()).booleanValue();
            }
            if (!z) {
                if ((this.f3535a.a() < this.f3536b.a(MessagingPrefKeys.aL, 0) ? 1 : null) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m3397c() {
        long a = this.f3539e.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingPhotoRemindersModule.f3514i, 604800000);
        long a2 = this.f3536b.a(MessagingPrefKeys.aK, 0);
        return a2 == 0 || this.f3535a.a() > a + a2;
    }
}

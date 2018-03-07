package com.facebook.messaging.sms.abtest;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_edit_privacy_enabled */
public class AnonymousSmsThreadStateHelper {
    private static long f12099a = -1;
    private static volatile AnonymousSmsThreadStateHelper f12100f;
    public Clock f12101b;
    public FbSharedPreferences f12102c;
    private final SmsTakeoverMultiverseExperimentHelper f12103d;
    private final SmsIntegrationState f12104e;

    public static com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper m19037a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12100f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper.class;
        monitor-enter(r1);
        r0 = f12100f;	 Catch:{ all -> 0x003a }
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
        r0 = m19038b(r0);	 Catch:{ all -> 0x0035 }
        f12100f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12100f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper");
    }

    private static AnonymousSmsThreadStateHelper m19038b(InjectorLike injectorLike) {
        return new AnonymousSmsThreadStateHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsTakeoverMultiverseExperimentHelper.b(injectorLike), SmsIntegrationState.a(injectorLike));
    }

    @Inject
    public AnonymousSmsThreadStateHelper(Clock clock, FbSharedPreferences fbSharedPreferences, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, SmsIntegrationState smsIntegrationState) {
        this.f12101b = clock;
        this.f12102c = fbSharedPreferences;
        this.f12103d = smsTakeoverMultiverseExperimentHelper;
        this.f12104e = smsIntegrationState;
    }

    public final boolean m19044a() {
        if (m19040d()) {
            this.f12102c.edit().putBoolean(SmsPrefKeys.d, false).commit();
            return false;
        } else if (this.f12103d.a(true) && m19039c() && this.f12104e.c()) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean m19045b() {
        if (this.f12103d.m()) {
            boolean z = true;
            if (!this.f12102c.a(SmsPrefKeys.i, true) || this.f12101b.a() >= this.f12102c.a(SmsPrefKeys.f, -1) + 14400000) {
                z = false;
            }
            if (!(z || !m19039c() || m19041e() || m19042f() || !this.f12104e.c())) {
                return true;
            }
        }
        return false;
    }

    private boolean m19039c() {
        if (this.f12102c.a(SmsPrefKeys.k, false) || this.f12101b.a() > m19043h() + (3600000 * ((long) this.f12103d.a.a(ExperimentsForSmsTakeoverAbTestModule.u, 0)))) {
            return true;
        }
        return false;
    }

    private boolean m19040d() {
        return this.f12101b.a() > m19043h() + (86400000 * ((long) this.f12103d.a.a(ExperimentsForSmsTakeoverAbTestModule.n, 28)));
    }

    private boolean m19041e() {
        return this.f12101b.a() > m19043h() + (86400000 * ((long) this.f12103d.a.a(ExperimentsForSmsTakeoverAbTestModule.f, 14)));
    }

    private boolean m19042f() {
        if (this.f12102c.a(SmsPrefKeys.g, 0) > this.f12103d.a.a(ExperimentsForSmsTakeoverAbTestModule.e, 10)) {
            return true;
        }
        return false;
    }

    private long m19043h() {
        if (f12099a == -1) {
            long a = this.f12102c.a(SmsPrefKeys.e, -1);
            f12099a = a;
            if (a == -1) {
                f12099a = this.f12101b.a();
                this.f12102c.edit().a(SmsPrefKeys.e, f12099a).commit();
            }
        }
        return f12099a;
    }
}

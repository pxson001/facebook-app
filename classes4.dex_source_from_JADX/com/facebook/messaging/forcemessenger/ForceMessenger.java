package com.facebook.messaging.forcemessenger;

import android.os.Build;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.file.AvailableAppInstallSpaceHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.UserStatus;
import com.facebook.messages.ipc.MessengerUserUtils;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: min_sample_value */
public class ForceMessenger {
    private static volatile ForceMessenger f7644j;
    public final AnalyticsLogger f7645a;
    public final MessengerUserUtils f7646b;
    public final MessengerAppUtils f7647c;
    public final Provider<String> f7648d;
    public final AvailableAppInstallSpaceHelper f7649e;
    private final boolean f7650f;
    private final Provider<Boolean> f7651g;
    private final Provider<Boolean> f7652h;
    public final QeAccessor f7653i;

    /* compiled from: min_sample_value */
    public enum Stage {
        NOT_IN_EXPERIMENT,
        REDIRECT,
        INSTALL_NOW
    }

    public static com.facebook.messaging.forcemessenger.ForceMessenger m8010a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7644j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.forcemessenger.ForceMessenger.class;
        monitor-enter(r1);
        r0 = f7644j;	 Catch:{ all -> 0x003a }
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
        r0 = m8013b(r0);	 Catch:{ all -> 0x0035 }
        f7644j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7644j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.forcemessenger.ForceMessenger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.forcemessenger.ForceMessenger");
    }

    private static ForceMessenger m8013b(InjectorLike injectorLike) {
        return new ForceMessenger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), MessengerUserUtils.a(injectorLike), MessengerAppUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), new AvailableAppInstallSpaceHelper(ContentResolverMethodAutoProvider.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4160), IdBasedProvider.a(injectorLike, 4158), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ForceMessenger(AnalyticsLogger analyticsLogger, MessengerUserUtils messengerUserUtils, MessengerAppUtils messengerAppUtils, Provider<String> provider, AvailableAppInstallSpaceHelper availableAppInstallSpaceHelper, Boolean bool, Provider<Boolean> provider2, Provider<Boolean> provider3, QeAccessor qeAccessor) {
        this.f7645a = analyticsLogger;
        this.f7646b = messengerUserUtils;
        this.f7647c = messengerAppUtils;
        this.f7648d = provider;
        this.f7649e = availableAppInstallSpaceHelper;
        this.f7650f = bool.booleanValue();
        this.f7651g = provider2;
        this.f7652h = provider3;
        this.f7653i = qeAccessor;
    }

    public final boolean m8014a() {
        if (!(m8011a(TriState.UNSET) || m8016b())) {
            Object obj;
            if (this.f7647c.b() || !m8019f()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null && !m8017c()) {
                return false;
            }
        }
        return true;
    }

    private boolean m8011a(TriState triState) {
        if (!triState.isSet()) {
            triState = TriState.valueOf(m8019f());
        }
        boolean z = false;
        if (!triState.asBoolean()) {
            if (this.f7649e.m8040a(20971520) || this.f7653i.a(ExperimentsForForceMessengerModule.b, false)) {
                String str = Build.MANUFACTURER;
                Object obj = (str == null || !str.toLowerCase(Locale.US).contains("amazon")) ? null : 1;
                if (obj == null) {
                    z = m8018d();
                }
            } else {
                HoneyClientEventFast a = this.f7645a.a("diode_promotion", true);
                if (a.a()) {
                    a.c("insufficient disk space");
                    a.b();
                }
            }
        }
        if (z && m8012b(triState) == Stage.INSTALL_NOW) {
            return true;
        }
        return false;
    }

    public final boolean m8016b() {
        if (this.f7650f) {
            return false;
        }
        if (!m8019f()) {
            return false;
        }
        UserStatus a = this.f7646b.a((String) this.f7648d.get());
        if (a.a || a.c != TriState.NO) {
            return false;
        }
        return true;
    }

    public final boolean m8017c() {
        if (!m8019f()) {
            return false;
        }
        UserStatus a = this.f7646b.a((String) this.f7648d.get());
        if (a.a) {
            return false;
        }
        if (a.c == TriState.NO) {
            return false;
        }
        if (a.d) {
            return ((Boolean) this.f7652h.get()).booleanValue();
        }
        return false;
    }

    public final boolean m8015a(TriState triState, boolean z) {
        if (m8012b(triState) != Stage.REDIRECT) {
            return false;
        }
        UserStatus a = this.f7646b.a((String) this.f7648d.get());
        if (a.a) {
            return true;
        }
        return z && a.c == TriState.NO;
    }

    public final boolean m8018d() {
        return ((Boolean) this.f7651g.get()).booleanValue();
    }

    private Stage m8012b(TriState triState) {
        if (!triState.isSet()) {
            triState = TriState.valueOf(m8019f());
        }
        if (triState.asBoolean()) {
            return m8018d() ? Stage.REDIRECT : Stage.NOT_IN_EXPERIMENT;
        } else {
            return Stage.INSTALL_NOW;
        }
    }

    public final boolean m8019f() {
        return this.f7647c.a();
    }
}

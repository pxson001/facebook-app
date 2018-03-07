package com.facebook.backgroundlocation.reporting;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundlocation.reporting.abtest.ExperimentsForBackgroundLocationReportingModule;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecurePendingIntent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationContinuousListener;
import com.facebook.location.FbLocationContinuousListenerException;
import com.facebook.location.FbLocationContinuousListenerMethodAutoProvider;
import com.facebook.location.FbLocationContinuousListenerParams;
import com.facebook.location.FbLocationContinuousListenerParams.Priority;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: keyUsing */
public class BackgroundLocationReportingNewImplManager implements INeedInit {
    private static final String f9686a = BackgroundLocationReportingNewImplManager.class.getSimpleName();
    private static final FbLocationContinuousListenerParams f9687b = new FbLocationContinuousListenerParams(Priority.BALANCED_POWER_AND_ACCURACY, 900000, 180000, 0.0f);
    private static volatile BackgroundLocationReportingNewImplManager f9688n;
    private final GatekeeperStoreImpl f9689c;
    public final QeAccessor f9690d;
    private final BackgroundLocationReportingSettingsManager f9691e;
    public final Context f9692f;
    public final FacebookOnlyIntentActionFactory f9693g;
    private final FbLocationContinuousListener f9694h;
    public final BackgroundLocationReportingNewImplAnalyticsLogger f9695i;
    private final BaseFbBroadcastManager f9696j;
    private final FbSharedPreferences f9697k;
    private final Clock f9698l;
    private final AbstractFbErrorReporter f9699m;

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplManager m10114a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9688n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplManager.class;
        monitor-enter(r1);
        r0 = f9688n;	 Catch:{ all -> 0x003a }
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
        r0 = m10117b(r0);	 Catch:{ all -> 0x0035 }
        f9688n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9688n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplManager.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplManager");
    }

    private static BackgroundLocationReportingNewImplManager m10117b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingNewImplManager(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BackgroundLocationReportingSettingsManager.m10123a(injectorLike), (Context) injectorLike.getInstance(Context.class), FacebookOnlyIntentActionFactory.a(injectorLike), FbLocationContinuousListenerMethodAutoProvider.m10147b(injectorLike), BackgroundLocationReportingNewImplAnalyticsLogger.m10133a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingNewImplManager(GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor, BackgroundLocationReportingSettingsManager backgroundLocationReportingSettingsManager, Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, FbLocationContinuousListener fbLocationContinuousListener, BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger, BaseFbBroadcastManager baseFbBroadcastManager, FbSharedPreferences fbSharedPreferences, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9689c = gatekeeperStoreImpl;
        this.f9690d = qeAccessor;
        this.f9691e = backgroundLocationReportingSettingsManager;
        this.f9692f = context;
        this.f9693g = facebookOnlyIntentActionFactory;
        this.f9694h = fbLocationContinuousListener;
        this.f9695i = backgroundLocationReportingNewImplAnalyticsLogger;
        this.f9696j = baseFbBroadcastManager;
        this.f9697k = fbSharedPreferences;
        this.f9698l = clock;
        this.f9699m = abstractFbErrorReporter;
    }

    public void init() {
        if (this.f9689c.a(514) == TriState.YES) {
            boolean a = this.f9691e.m10130a();
            boolean a2 = this.f9690d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForBackgroundLocationReportingModule.f9748r, false);
            long a3 = this.f9697k.a(BackgroundLocationReportingPrefKeys.f9729c, 0);
            a2 = a2 && a3 != 0 && this.f9698l.a() < a3;
            m10116a(a, a2 ? m10119d() : m10118c());
            a2 = this.f9690d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForBackgroundLocationReportingModule.f9749s, false);
            if (a && a2) {
                this.f9696j.a().a("com.facebook.STREAM_PUBLISH_START", new 1(this)).a().b();
            }
        }
    }

    final void m10121a(boolean z) {
        m10116a(z, m10118c());
    }

    final void m10120a() {
        long a = this.f9690d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForBackgroundLocationReportingModule.f9745o, -1);
        if (a < 0) {
            this.f9699m.a(f9686a, "Invalid high frequency mode duration");
            return;
        }
        this.f9697k.edit().a(BackgroundLocationReportingPrefKeys.f9729c, (a * 1000) + this.f9698l.a()).commit();
        m10116a(this.f9691e.m10130a(), m10119d());
    }

    final void m10122b() {
        long a = this.f9697k.a(BackgroundLocationReportingPrefKeys.f9729c, 0);
        if (a != 0 && this.f9698l.a() > a) {
            m10116a(this.f9691e.m10130a(), m10118c());
            this.f9697k.edit().a(BackgroundLocationReportingPrefKeys.f9729c).commit();
        }
    }

    private void m10116a(boolean z, FbLocationContinuousListenerParams fbLocationContinuousListenerParams) {
        GoogleApiAvailability.a();
        int a = GoogleApiAvailability.a(this.f9692f);
        PendingIntent b = SecurePendingIntent.m10163b(this.f9692f, 0, new Intent().setPackage(this.f9692f.getPackageName()).setAction(this.f9693g.a("BACKGROUND_LOCATION_REPORTING_ACTION_LOCATION_UPDATE")), 134217728);
        if (z) {
            try {
                this.f9694h.mo786a(b, fbLocationContinuousListenerParams);
                this.f9695i.m10135a(a);
                return;
            } catch (FbLocationContinuousListenerException e) {
                this.f9695i.m10139a(e);
                return;
            }
        }
        this.f9694h.mo785a(b);
        this.f9695i.m10145b();
    }

    private FbLocationContinuousListenerParams m10118c() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.b;
        if (GoogleApiAvailability.a(this.f9692f) != 0) {
            return f9687b;
        }
        Priority a = m10115a(this.f9690d.a(ExperimentsForBackgroundLocationReportingModule.f9731a, f9687b.f9700a.name()));
        if (a == null) {
            a = f9687b.f9700a;
        }
        return new FbLocationContinuousListenerParams(a, this.f9690d.a(ExperimentsForBackgroundLocationReportingModule.f9732b, f9687b.f9701b), this.f9690d.a(ExperimentsForBackgroundLocationReportingModule.f9739i, f9687b.f9702c), f9687b.f9703d);
    }

    private FbLocationContinuousListenerParams m10119d() {
        Priority a = m10115a(this.f9690d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForBackgroundLocationReportingModule.f9747q, f9687b.f9700a.name()));
        long a2 = this.f9690d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForBackgroundLocationReportingModule.f9744n, -1);
        long a3 = this.f9690d.a(Liveness.Live, ExposureLogging.Off, ExperimentsForBackgroundLocationReportingModule.f9746p, -1);
        if (a == null || a2 < 0 || a3 < 0) {
            this.f9699m.a(f9686a, "Error fetching high frequency QE params");
            return m10118c();
        }
        return new FbLocationContinuousListenerParams(a, 1000 * a2, a3 * 1000, f9687b.f9703d);
    }

    @Nullable
    private Priority m10115a(String str) {
        try {
            return Priority.valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            this.f9699m.a(f9686a, "Invalid high frequency priority value");
            return null;
        }
    }
}

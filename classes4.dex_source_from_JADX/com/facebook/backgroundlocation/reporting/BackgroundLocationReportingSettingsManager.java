package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundlocation.reporting.BackgroundLocationReportingNewImplAnalyticsLogger.RefreshReason;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecurePendingIntent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: keep-alive */
public class BackgroundLocationReportingSettingsManager implements INeedInit {
    private static volatile BackgroundLocationReportingSettingsManager f9706g;
    private final GatekeeperStoreImpl f9707a;
    public final Clock f9708b;
    public final Context f9709c;
    public final FacebookOnlyIntentActionFactory f9710d;
    public final FbSharedPreferences f9711e;
    private final BackgroundLocationReportingNewImplAnalyticsLogger f9712f;

    public static com.facebook.backgroundlocation.reporting.BackgroundLocationReportingSettingsManager m10123a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9706g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingSettingsManager.class;
        monitor-enter(r1);
        r0 = f9706g;	 Catch:{ all -> 0x003a }
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
        r0 = m10125b(r0);	 Catch:{ all -> 0x0035 }
        f9706g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9706g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundlocation.reporting.BackgroundLocationReportingSettingsManager.a(com.facebook.inject.InjectorLike):com.facebook.backgroundlocation.reporting.BackgroundLocationReportingSettingsManager");
    }

    private static BackgroundLocationReportingSettingsManager m10125b(InjectorLike injectorLike) {
        return new BackgroundLocationReportingSettingsManager(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), FacebookOnlyIntentActionFactory.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), BackgroundLocationReportingNewImplAnalyticsLogger.m10133a(injectorLike));
    }

    @Inject
    public BackgroundLocationReportingSettingsManager(GatekeeperStoreImpl gatekeeperStoreImpl, Clock clock, Context context, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, FbSharedPreferences fbSharedPreferences, BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger) {
        this.f9707a = gatekeeperStoreImpl;
        this.f9708b = clock;
        this.f9709c = context;
        this.f9711e = fbSharedPreferences;
        this.f9710d = facebookOnlyIntentActionFactory;
        this.f9712f = backgroundLocationReportingNewImplAnalyticsLogger;
    }

    public void init() {
        if (m10127d()) {
            RefreshReason refreshReason = null;
            if (m10126b() == TriState.UNSET) {
                refreshReason = RefreshReason.FIRST;
            } else if (this.f9711e.a(BackgroundLocationReportingPrefKeys.f9728b, -1) + 43200000 <= this.f9708b.a()) {
                refreshReason = RefreshReason.TIME;
            }
            if (refreshReason != null) {
                m10124a(refreshReason);
            }
        }
    }

    final boolean m10130a() {
        return m10126b().asBoolean(false);
    }

    final void m10129a(boolean z) {
        if (m10127d()) {
            TriState b = m10126b();
            RefreshReason refreshReason = null;
            if (b == TriState.UNSET) {
                refreshReason = RefreshReason.FIRST;
            } else if (b.asBoolean() != z) {
                refreshReason = RefreshReason.HINT;
            }
            if (refreshReason != null) {
                m10124a(refreshReason);
            }
        }
    }

    final void m10128a(Optional<Boolean> optional) {
        if (optional.isPresent()) {
            boolean booleanValue = ((Boolean) optional.get()).booleanValue();
            this.f9712f.f9715b.a(BackgroundLocationReportingNewImplAnalyticsLogger.m10132a("background_location_setting_refresh_success").a("is_location_history_enabled", booleanValue));
            TriState b = m10126b();
            if (b == TriState.UNSET || b.asBoolean() != booleanValue) {
                this.f9712f.f9715b.a(BackgroundLocationReportingNewImplAnalyticsLogger.m10132a("background_location_setting_change").a("is_location_history_enabled", booleanValue));
                Intent intent = new Intent(this.f9710d.a("BACKGROUND_LOCATION_REPORTING_SETTINGS_CHANGED_ACTION"));
                intent.putExtra("is_location_history_enabled", booleanValue);
                this.f9709c.sendBroadcast(intent);
            }
            this.f9711e.edit().putBoolean(BackgroundLocationReportingPrefKeys.f9727a, booleanValue).a(BackgroundLocationReportingPrefKeys.f9728b, this.f9708b.a()).commit();
            return;
        }
        this.f9712f.f9715b.a(BackgroundLocationReportingNewImplAnalyticsLogger.m10132a("background_location_setting_refresh_failure"));
    }

    private void m10124a(RefreshReason refreshReason) {
        if (m10127d()) {
            BackgroundLocationReportingNewImplAnalyticsLogger backgroundLocationReportingNewImplAnalyticsLogger = this.f9712f;
            Preconditions.checkNotNull(refreshReason);
            backgroundLocationReportingNewImplAnalyticsLogger.f9715b.a(BackgroundLocationReportingNewImplAnalyticsLogger.m10132a("background_location_setting_refresh_start").a("reason", refreshReason));
            Intent intent = new Intent();
            intent.setAction(this.f9710d.a("BACKGROUND_LOCATION_REPORTING_ACTION_FETCH_IS_ENABLED_FINISHED"));
            BackgroundLocationReportingNewImplService.m10167a(this.f9709c, SecurePendingIntent.m10163b(this.f9709c, 0, intent, 0));
        }
    }

    private TriState m10126b() {
        if (this.f9711e.a(BackgroundLocationReportingPrefKeys.f9727a)) {
            return TriState.valueOf(this.f9711e.a(BackgroundLocationReportingPrefKeys.f9727a, false));
        }
        return TriState.UNSET;
    }

    private boolean m10127d() {
        return this.f9707a.a(514) == TriState.YES;
    }
}

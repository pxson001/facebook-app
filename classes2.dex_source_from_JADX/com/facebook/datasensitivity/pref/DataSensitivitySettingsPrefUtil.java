package com.facebook.datasensitivity.pref;

import android.net.NetworkInfo;
import com.facebook.analytics.timespent.TimeSpentBitArray.AppEvent;
import com.facebook.analytics.timespent.TimeSpentEventReporter;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: signal_evdo_level */
public class DataSensitivitySettingsPrefUtil {
    private static volatile DataSensitivitySettingsPrefUtil f4770g;
    public final FbSharedPreferences f4771a;
    public final GatekeeperStoreImpl f4772b;
    private DsmAnalyticsEventLogger f4773c;
    public FbNetworkManager f4774d;
    private Lazy<Set<DataSavingsStateChangeListener>> f4775e;
    private Set<DataSavingsStateChangeListener> f4776f;

    public static com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil m8604a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4770g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil.class;
        monitor-enter(r1);
        r0 = f4770g;	 Catch:{ all -> 0x003a }
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
        r0 = m8605b(r0);	 Catch:{ all -> 0x0035 }
        f4770g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4770g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil.a(com.facebook.inject.InjectorLike):com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil");
    }

    private static DataSensitivitySettingsPrefUtil m8605b(InjectorLike injectorLike) {
        return new DataSensitivitySettingsPrefUtil(FbSharedPreferencesImpl.m1826a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), DsmAnalyticsEventLogger.m8614a(injectorLike), FbNetworkManager.m3811a(injectorLike), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$DataSavingsStateChangeListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public DataSensitivitySettingsPrefUtil(FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, DsmAnalyticsEventLogger dsmAnalyticsEventLogger, FbNetworkManager fbNetworkManager, Lazy<Set<DataSavingsStateChangeListener>> lazy) {
        this.f4771a = fbSharedPreferences;
        this.f4772b = gatekeeperStore;
        this.f4773c = dsmAnalyticsEventLogger;
        this.f4774d = fbNetworkManager;
        this.f4775e = lazy;
    }

    public final boolean m8608a(boolean z) {
        return m8607a() && this.f4771a.mo286a(DataSensitivityPreferenceConstants.b, z);
    }

    public final boolean m8609b(boolean z) {
        Object obj;
        boolean a = m8608a(z);
        if (m8611c() && this.f4771a.mo286a(DataSensitivityPreferenceConstants.c, z)) {
            obj = 1;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        if (a && obj2 == null) {
            return true;
        }
        if (a && obj2 != null) {
            obj = 1;
            NetworkInfo b = this.f4774d.m3827b();
            if (!(b != null && b.isConnected() && b.getType() == 1)) {
                obj = null;
            }
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public final void m8610c(boolean z) {
        m8612d(z);
        Editor edit = this.f4771a.edit();
        edit.putBoolean(DataSensitivityPreferenceConstants.b, z);
        edit.commit();
        if (z) {
            this.f4773c.m8622f();
        } else {
            this.f4773c.m8623g();
        }
    }

    public final void m8612d(boolean z) {
        if (z != m8608a(false)) {
            for (TimeSpentEventReporter timeSpentEventReporter : m8606f()) {
                TimeSpentEventReporter.m20165a(timeSpentEventReporter, AppEvent.DATASAVINGS, timeSpentEventReporter.f13735b.mo211a());
            }
        }
    }

    public final boolean m8607a() {
        return this.f4772b.m2189a(790, false);
    }

    public final boolean m8613e(boolean z) {
        return this.f4772b.m2189a(793, false) && m8609b(z);
    }

    public final boolean m8611c() {
        return this.f4772b.m2189a(791, false);
    }

    private synchronized Set<DataSavingsStateChangeListener> m8606f() {
        if (this.f4776f == null) {
            this.f4776f = Sets.m1324b((Iterable) this.f4775e.get());
        }
        return this.f4776f;
    }
}

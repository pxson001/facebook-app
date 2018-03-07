package com.facebook.saved.common.nux;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.apptab.interfaces.AppTabHost;
import com.facebook.apptab.state.TabTag;
import com.facebook.bookmark.iface.BookmarkSyncListener;
import com.facebook.bookmark.iface.STATICDI_MULTIBIND_PROVIDER$BookmarkSyncListener;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.gating.feature.ExperimentsForSavedGatingModule;
import com.facebook.saved.gating.feature.SaverInfoXConfig;
import com.facebook.saved.gating.feature.SaverInfoXConfig.SaveBookmarkNuxState;
import com.facebook.saved.prefs.SavedPrefKeys;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pyml_imp */
public class SavedBookmarksNuxInterstitialController implements InterstitialActionController, InterstitialController {
    private static volatile SavedBookmarksNuxInterstitialController f8557i;
    public final FbSharedPreferences f8558a;
    public final Clock f8559b;
    private final SaveAnalyticsLogger f8560c;
    private final XConfigReader f8561d;
    private final Lazy<Set<BookmarkSyncListener>> f8562e;
    private final QeAccessor f8563f;
    private final NetworkMonitor f8564g;
    private final GatekeeperStoreImpl f8565h;

    public static com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController m13108a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8557i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController.class;
        monitor-enter(r1);
        r0 = f8557i;	 Catch:{ all -> 0x003a }
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
        r0 = m13109b(r0);	 Catch:{ all -> 0x0035 }
        f8557i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8557i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController.a(com.facebook.inject.InjectorLike):com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController");
    }

    private static SavedBookmarksNuxInterstitialController m13109b(InjectorLike injectorLike) {
        return new SavedBookmarksNuxInterstitialController(FbSharedPreferencesImpl.m1826a(injectorLike), SaveAnalyticsLogger.m13117a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), XConfigReader.m2681a(injectorLike), STATICDI_MULTIBIND_PROVIDER$BookmarkSyncListener.m13132a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), NetworkMonitor.m13133a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public SavedBookmarksNuxInterstitialController(FbSharedPreferences fbSharedPreferences, SaveAnalyticsLogger saveAnalyticsLogger, Clock clock, XConfigReader xConfigReader, Lazy<Set<BookmarkSyncListener>> lazy, QeAccessor qeAccessor, NetworkMonitor networkMonitor, GatekeeperStore gatekeeperStore) {
        this.f8558a = fbSharedPreferences;
        this.f8559b = clock;
        this.f8560c = saveAnalyticsLogger;
        this.f8561d = xConfigReader;
        this.f8562e = lazy;
        this.f8563f = qeAccessor;
        this.f8564g = networkMonitor;
        this.f8565h = gatekeeperStore;
    }

    public final void mo1752a(Context context, Object obj) {
        ProvidesInterface providesInterface = (ProvidesInterface) ContextUtils.m2500a(context, ProvidesInterface.class);
        if (providesInterface != null) {
            AppTabHost appTabHost = (AppTabHost) providesInterface.mo817a(AppTabHost.class);
            if (appTabHost != null) {
                Tooltip tooltip = new Tooltip(context, 2);
                tooltip.t = -1;
                CharSequence a = this.f8563f.mo581a(ExperimentsForSavedGatingModule.a, null);
                if (a == null) {
                    tooltip.b(2131232745);
                } else {
                    tooltip.b(a);
                }
                appTabHost.mo785a(TabTag.Bookmark, tooltip);
                SaveAnalyticsLogger saveAnalyticsLogger = this.f8560c;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_bookmark_nux_imp");
                honeyClientEvent.f3099c = "native_newsfeed";
                saveAnalyticsLogger.f8567a.mo526a(honeyClientEvent.m5090b("event_id", SafeUUIDGenerator.m2795a().toString()));
                for (BookmarkSyncListener a2 : (Set) this.f8562e.get()) {
                    a2.a();
                }
                return;
            }
            this.f8558a.edit().putBoolean(SavedPrefKeys.f19748f, true).commit();
        }
    }

    public final String mo1173b() {
        return "3907";
    }

    public final void mo1172a(@Nullable Parcelable parcelable) {
    }

    public final void mo1171a(long j) {
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        SaveBookmarkNuxState convertString = SaveBookmarkNuxState.convertString(this.f8561d.m2685a(SaverInfoXConfig.f14995c, null));
        if (SaveBookmarkNuxState.INELIGIBLE.equals(convertString) || !this.f8564g.m13137a()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        boolean a = this.f8565h.m2189a(1106, false);
        if (interstitialTrigger.action != Action.SAVED_MAIN_TAB_VISIBLE) {
            return InterstitialControllerState.ELIGIBLE;
        }
        if (!this.f8558a.mo286a(SavedPrefKeys.f19748f, false) && (!a || !SaveBookmarkNuxState.FORCE.equals(convertString))) {
            return InterstitialControllerState.INELIGIBLE;
        }
        this.f8558a.edit().putBoolean(SavedPrefKeys.f19748f, false).commit();
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return ImmutableList.of(new InterstitialTrigger(Action.ITEM_SAVED), new InterstitialTrigger(Action.SAVED_MAIN_TAB_VISIBLE));
    }

    public final long hI_() {
        return 604800000;
    }
}

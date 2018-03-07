package com.facebook.appinvites.installtracking;

import android.content.Context;
import android.content.IntentFilter;
import com.facebook.appinvites.data.AppInvitePrefKeys;
import com.facebook.appinvites.data.InstalledAppsCache;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteAppInstalledEvent;
import com.facebook.appinvites.events.AppInvitesEventBus;
import com.facebook.appinvites.installtracking.AppInvitesInstallTrackingDataStore.AppInvitesTrackedApp;
import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestAcceptCoreMutationString;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.graphql.calls.ApplicationRequestAcceptInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Arrays;
import javax.inject.Inject;

/* compiled from: messaging_push_notif_ */
public class AppInvitesInstallTracker implements INeedInit {
    private static final Class<?> f8076a = AppInvitesInstallTracker.class;
    public final InstalledAppsCache f8077b;
    private final GraphQLQueryExecutor f8078c;
    private final Context f8079d;
    public final AppInvitesInstallTrackingDataStore f8080e;
    public final Clock f8081f;
    private final AppInvitesEventBus f8082g;
    private DynamicSecureBroadcastReceiver f8083h;

    public static AppInvitesInstallTracker m8364b(InjectorLike injectorLike) {
        return new AppInvitesInstallTracker(InstalledAppsCache.m8367a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (Context) injectorLike.getInstance(Context.class), new AppInvitesInstallTrackingDataStore((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike)), (Clock) SystemClockMethodAutoProvider.a(injectorLike), AppInvitesEventBus.m8374a(injectorLike));
    }

    @Inject
    public AppInvitesInstallTracker(InstalledAppsCache installedAppsCache, GraphQLQueryExecutor graphQLQueryExecutor, Context context, AppInvitesInstallTrackingDataStore appInvitesInstallTrackingDataStore, Clock clock, AppInvitesEventBus appInvitesEventBus) {
        this.f8077b = installedAppsCache;
        this.f8078c = graphQLQueryExecutor;
        this.f8079d = context;
        this.f8080e = appInvitesInstallTrackingDataStore;
        this.f8081f = clock;
        this.f8082g = appInvitesEventBus;
    }

    public void init() {
        for (AppInvitesTrackedApp appInvitesTrackedApp : this.f8080e.m8371a()) {
            if (this.f8081f.a() - appInvitesTrackedApp.c > 86400000) {
                m8362a(this, appInvitesTrackedApp.b);
            } else if (this.f8077b.m8370b(appInvitesTrackedApp.b)) {
                m8361a(this, appInvitesTrackedApp);
            }
        }
        if (!this.f8080e.m8371a().isEmpty() && !m8363a()) {
            m8365b();
        }
    }

    public static void m8361a(AppInvitesInstallTracker appInvitesInstallTracker, AppInvitesTrackedApp appInvitesTrackedApp) {
        ApplicationRequestAcceptInputData applicationRequestAcceptInputData = new ApplicationRequestAcceptInputData();
        String str = "request_ids";
        applicationRequestAcceptInputData.a(str, Arrays.asList(new String[]{appInvitesTrackedApp.a}));
        appInvitesInstallTracker.f8078c.a(GraphQLRequest.a((AppRequestAcceptCoreMutationString) new AppRequestAcceptCoreMutationString().a("input", applicationRequestAcceptInputData)));
        m8362a(appInvitesInstallTracker, appInvitesTrackedApp.b);
        appInvitesInstallTracker.f8082g.a(new AppInviteAppInstalledEvent(appInvitesTrackedApp.b));
    }

    private boolean m8363a() {
        return this.f8083h != null;
    }

    private void m8365b() {
        this.f8083h = new DynamicSecureBroadcastReceiver("android.intent.action.PACKAGE_ADDED", new 1(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.f8079d.registerReceiver(this.f8083h, intentFilter);
    }

    public final void m8366a(String str, String str2) {
        AppInvitesInstallTrackingDataStore appInvitesInstallTrackingDataStore = this.f8080e;
        AppInvitesTrackedApp appInvitesTrackedApp = new AppInvitesTrackedApp(str, str2, this.f8081f.a());
        Editor edit = appInvitesInstallTrackingDataStore.f8087a.edit();
        PrefKey prefKey = (PrefKey) ((PrefKey) AppInvitePrefKeys.f9815b.a(appInvitesTrackedApp.b)).a("/");
        edit.a((PrefKey) prefKey.a("invite_id"), appInvitesTrackedApp.a);
        edit.a((PrefKey) prefKey.a("timestamp"), appInvitesTrackedApp.c);
        edit.commit();
        if (!m8363a()) {
            m8365b();
        }
    }

    public static void m8362a(AppInvitesInstallTracker appInvitesInstallTracker, String str) {
        Editor edit = appInvitesInstallTracker.f8080e.f8087a.edit();
        edit.b((PrefKey) AppInvitePrefKeys.f9815b.a(str));
        edit.commit();
    }
}

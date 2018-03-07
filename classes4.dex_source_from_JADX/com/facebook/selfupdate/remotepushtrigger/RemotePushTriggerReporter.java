package com.facebook.selfupdate.remotepushtrigger;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.TimeConversions;
import com.facebook.graphql.calls.Fb4aUpgradeWifiActiveInputData;
import com.facebook.graphql.calls.Fb4aUpgradeWifiActiveInputData.IsOnWifi;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.selfupdate.remotepushtrigger.protocol.SideloadingFb4aUpgradeWifiActiveGraphQlMutation.SideloadingFb4aUpgradeWifiActiveGraphQlMutationString;
import javax.inject.Inject;

/* compiled from: good_enough_scan */
public class RemotePushTriggerReporter {
    private final AppStateManager f11015a;
    private final Clock f11016b;
    private final FbSharedPreferences f11017c;
    private final RemotePushTriggerExperimentController f11018d;
    public final Lazy<GraphQLQueryExecutor> f11019e;

    @Inject
    public RemotePushTriggerReporter(AppStateManager appStateManager, Clock clock, FbSharedPreferences fbSharedPreferences, RemotePushTriggerExperimentController remotePushTriggerExperimentController, Lazy<GraphQLQueryExecutor> lazy) {
        this.f11015a = appStateManager;
        this.f11016b = clock;
        this.f11017c = fbSharedPreferences;
        this.f11018d = remotePushTriggerExperimentController;
        this.f11019e = lazy;
    }

    public final void m11478a() {
        if (this.f11017c.a()) {
            long p;
            long a = this.f11016b.a();
            long a2 = this.f11017c.a(RemotePushTriggerPrefs.a, 0);
            if (this.f11015a.j()) {
                p = TimeConversions.p((long) this.f11018d.f11014a.a(ExperimentsForRemotePushTriggerModule.f11026c, 15));
            } else {
                p = TimeConversions.o((long) this.f11018d.f11014a.a(ExperimentsForRemotePushTriggerModule.f11027d, 60));
            }
            if (a - a2 >= p) {
                this.f11017c.edit().a(RemotePushTriggerPrefs.a, a).commit();
                Fb4aUpgradeWifiActiveInputData fb4aUpgradeWifiActiveInputData = new Fb4aUpgradeWifiActiveInputData();
                fb4aUpgradeWifiActiveInputData.a("is_on_wifi", IsOnWifi.TRUE);
                GraphQlCallInput graphQlCallInput = fb4aUpgradeWifiActiveInputData;
                GraphQlQueryString sideloadingFb4aUpgradeWifiActiveGraphQlMutationString = new SideloadingFb4aUpgradeWifiActiveGraphQlMutationString();
                sideloadingFb4aUpgradeWifiActiveGraphQlMutationString.a("input", graphQlCallInput);
                ((GraphQLQueryExecutor) this.f11019e.get()).a(GraphQLRequest.a(sideloadingFb4aUpgradeWifiActiveGraphQlMutationString));
                return;
            }
            return;
        }
        this.f11017c.a(new 1(this));
    }
}

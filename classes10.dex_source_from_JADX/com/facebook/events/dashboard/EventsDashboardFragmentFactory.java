package com.facebook.events.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.events.common.ActionSource;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.fbreact.interfaces.FbReactInstanceManager;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: commerce/admin/shop/{#%s}/add */
public class EventsDashboardFragmentFactory implements IFragmentFactory {
    private static final Class<?> f16669a = EventsDashboardFragmentFactory.class;
    private final CurrentModuleHolder f16670b;
    private final Provider<Fragment> f16671c;
    private final Lazy<FbReactInstanceManager> f16672d;
    private final QeAccessor f16673e;

    @Inject
    public EventsDashboardFragmentFactory(CurrentModuleHolder currentModuleHolder, Provider<Fragment> provider, Lazy<FbReactInstanceManager> lazy, QeAccessor qeAccessor) {
        this.f16670b = currentModuleHolder;
        this.f16671c = provider;
        this.f16672d = lazy;
        this.f16673e = qeAccessor;
    }

    public final Fragment m17073a(Intent intent) {
        String stringExtra = intent.getStringExtra("section_name");
        Bundle bundle = new Bundle();
        boolean booleanExtra = intent.getBooleanExtra("force_tabbed_dashboard", false);
        bundle.putBoolean("force_tabbed_dashboard", booleanExtra);
        if (stringExtra == null && !booleanExtra && this.f16673e.a(Liveness.Live, ExperimentsForEventsGatingModule.N, false)) {
            ((Fb4aReactInstanceManager) this.f16672d.get()).b();
            return (Fragment) this.f16671c.get();
        } else if (this.f16673e.a(ExperimentsForEventsGatingModule.z, false)) {
            return EventsDiscoveryDashboardFragment.m17190a(bundle, stringExtra, this.f16670b.a("unknown"));
        } else {
            String stringExtra2 = intent.getStringExtra("extra_launch_uri");
            if (stringExtra2 != null) {
                stringExtra2 = Uri.parse(stringExtra2).getQueryParameter("action_ref");
                if (stringExtra2 != null) {
                    try {
                        bundle.putParcelable("action_ref", ActionSource.valueOf(stringExtra2));
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
            return (booleanExtra || this.f16673e.a(ExperimentsForEventsGatingModule.x, false)) ? stringExtra != null ? EventsDashboardFragment.m17040b(bundle, this.f16670b.a("unknown"), stringExtra) : EventsDashboardFragment.m17039b(bundle, this.f16670b.a("unknown")) : stringExtra != null ? EventsDashboardFragment.m17029a(bundle, this.f16670b.a("unknown"), stringExtra) : EventsDashboardFragment.m17028a(bundle, this.f16670b.a("unknown"));
        }
    }
}

package com.facebook.fbreact.events;

import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.inject.AbstractProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: facebook_apps_total_rss_kb */
public class Fragment_EventsDashboardReactFragmentMethodAutoProvider extends AbstractProvider<Fragment> {
    public Object get() {
        return EventsDashboardReactNativeModule.m8476a((QeAccessor) QeInternalImplMethodAutoProvider.a(this), CurrentModuleHolder.a(this));
    }
}

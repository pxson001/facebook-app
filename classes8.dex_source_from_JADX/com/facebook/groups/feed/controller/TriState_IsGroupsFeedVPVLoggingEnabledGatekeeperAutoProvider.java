package com.facebook.groups.feed.controller;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: faceweb/f?href=/scheduled_posts/?pageid=%s */
public class TriState_IsGroupsFeedVPVLoggingEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(868);
    }
}

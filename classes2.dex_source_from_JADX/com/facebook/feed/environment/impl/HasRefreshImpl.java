package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasRefresh;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: network_info_link_speed_mbps */
public class HasRefreshImpl implements HasRefresh {
    private final Runnable f12558a;

    @Inject
    public HasRefreshImpl(@Assisted Runnable runnable) {
        this.f12558a = runnable;
    }

    public final void mo2458l() {
        this.f12558a.run();
    }
}

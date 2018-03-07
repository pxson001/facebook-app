package com.facebook.timeline.search;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: extra_selected_category */
public class TimelineGraphSearchQueryFactory {
    public final String f12646a;
    public final String f12647b;
    public final GatekeeperStoreImpl f12648c;

    @Inject
    public TimelineGraphSearchQueryFactory(@Assisted String str, @Assisted Long l, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12646a = str;
        this.f12647b = String.valueOf(l);
        this.f12648c = gatekeeperStoreImpl;
    }
}

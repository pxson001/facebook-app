package com.facebook.feed.rows.core.events;

import com.facebook.graphql.model.FeedUnit;
import javax.annotation.Nonnull;

/* compiled from: phone_need_reconfirmation */
public class NavigatedToTargetPageEvent implements KeyedEvent<String> {
    @Nonnull
    public final FeedUnit f10135a;

    public final Object mo1976c() {
        return this.f10135a.mo2507g() != null ? this.f10135a.mo2507g() : Long.toString(this.f10135a.T_());
    }

    public NavigatedToTargetPageEvent(@Nonnull FeedUnit feedUnit) {
        this.f10135a = feedUnit;
    }
}

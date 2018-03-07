package com.facebook.feed.environment.tooltip;

import android.view.View;
import com.facebook.feed.environment.CanShowAnchoredTooltip;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: group_admin_cog_icon */
public class TooltipAnchor<V extends View & CanShowAnchoredTooltip> {
    public final FeedUnit f21765a;
    public V f21766b = null;

    public TooltipAnchor(FeedUnit feedUnit) {
        this.f21765a = feedUnit;
    }
}

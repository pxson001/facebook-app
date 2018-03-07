package com.facebook.feed.environment.impl;

import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.feedplugins.saved.nux.CaretNuxTooltipDelegateBase;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: multi_success */
public final class HasAnchoredTooltipProviderImpl$1 implements OnTooltipClickListener {
    final /* synthetic */ CaretNuxTooltipDelegateBase f10149a;
    final /* synthetic */ FeedUnit f10150b;

    public HasAnchoredTooltipProviderImpl$1(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase, FeedUnit feedUnit) {
        this.f10149a = caretNuxTooltipDelegateBase;
        this.f10150b = feedUnit;
    }

    public final void m15833a() {
        this.f10149a.c(this.f10150b);
    }
}

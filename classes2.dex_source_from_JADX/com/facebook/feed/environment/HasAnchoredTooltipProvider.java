package com.facebook.feed.environment;

import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.feedplugins.saved.nux.CaretNuxTooltipDelegateBase;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: next_polling_config */
public interface HasAnchoredTooltipProvider extends AnyEnvironment {
    void mo2427a(TooltipAnchor tooltipAnchor);

    void mo2431a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase);

    void mo2442b(TooltipAnchor tooltipAnchor);
}

package com.facebook.feed.environment.impl;

import android.view.View;
import android.view.ViewParent;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.environment.CanShowAnchoredTooltip;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.feedplugins.saved.nux.CaretNuxTooltipDelegateBase;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxies;
import com.facebook.widget.listview.ScrollingViewProxy;
import java.util.HashSet;
import java.util.Set;

/* compiled from: news_v2 */
public class HasAnchoredTooltipProviderImpl implements HasAnchoredTooltipProvider {
    private static final int[] f12291a = new int[2];
    public final Set<TooltipAnchor> f12292b = new HashSet();

    public static HasAnchoredTooltipProviderImpl m18316a(InjectorLike injectorLike) {
        return new HasAnchoredTooltipProviderImpl();
    }

    public final void mo2442b(TooltipAnchor tooltipAnchor) {
        this.f12292b.remove(tooltipAnchor);
    }

    public final void mo2427a(TooltipAnchor tooltipAnchor) {
        this.f12292b.add(tooltipAnchor);
    }

    public final void mo2431a(CaretNuxTooltipDelegateBase caretNuxTooltipDelegateBase) {
        for (TooltipAnchor tooltipAnchor : this.f12292b) {
            if (tooltipAnchor.f21766b instanceof CanShowAnchoredTooltip) {
                CanShowAnchoredTooltip canShowAnchoredTooltip = (CanShowAnchoredTooltip) tooltipAnchor.f21766b;
                if (canShowAnchoredTooltip.hk_() && caretNuxTooltipDelegateBase.a(tooltipAnchor.f21765a)) {
                    if (!m18317b((View) canShowAnchoredTooltip) || m18318c((View) canShowAnchoredTooltip) != null) {
                        break;
                    }
                }
            }
        }
        TooltipAnchor tooltipAnchor2 = null;
        TooltipAnchor tooltipAnchor3 = tooltipAnchor2;
        if (tooltipAnchor3 != null) {
            if (m18317b(tooltipAnchor3.f21766b)) {
                View view = tooltipAnchor3.f21766b;
                ScrollingViewProxy c = m18318c(view);
                if (c != null) {
                    c.mo2378d(c.mo2371c(view), SizeUtil.m19191a(view.getContext(), 5.0f));
                }
            }
            CanShowAnchoredTooltip canShowAnchoredTooltip2 = (CanShowAnchoredTooltip) tooltipAnchor3.f21766b;
            FeedUnit feedUnit = tooltipAnchor3.f21765a;
            Tooltip tooltip = new Tooltip(tooltipAnchor3.f21766b.getContext(), 2);
            tooltip.a(null);
            tooltip.b(caretNuxTooltipDelegateBase.a);
            tooltip.a(Position.BELOW);
            tooltip.t = -1;
            tooltip.a(new 1(caretNuxTooltipDelegateBase, feedUnit));
            canShowAnchoredTooltip2.mo3090a(tooltip);
            caretNuxTooltipDelegateBase.b(tooltipAnchor3.f21765a);
        }
    }

    public static boolean m18317b(View view) {
        view.getLocationInWindow(f12291a);
        if (f12291a[1] < SizeUtil.m19191a(view.getContext(), 90.0f)) {
            return true;
        }
        return false;
    }

    public static ScrollingViewProxy m18318c(View view) {
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            ScrollingViewProxy a = ScrollingViewProxies.a(view2);
            if (a != null) {
                return a;
            }
            parent = view2.getParent();
        }
        return null;
    }
}

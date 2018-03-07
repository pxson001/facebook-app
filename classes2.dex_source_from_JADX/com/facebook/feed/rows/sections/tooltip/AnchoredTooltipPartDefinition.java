package com.facebook.feed.rows.sections.tooltip;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowAnchoredTooltip;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.tooltip.TooltipAnchor;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;

@ContextScoped
/* compiled from: huge_picture_url */
public class AnchoredTooltipPartDefinition<V extends View & CanShowAnchoredTooltip> extends BaseSinglePartDefinition<FeedUnit, TooltipAnchor<V>, HasAnchoredTooltipProvider, V> {
    private static AnchoredTooltipPartDefinition f20664a;
    private static final Object f20665b = new Object();

    private static AnchoredTooltipPartDefinition m28413a() {
        return new AnchoredTooltipPartDefinition();
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new TooltipAnchor((FeedUnit) obj);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1931622156);
        TooltipAnchor tooltipAnchor = (TooltipAnchor) obj2;
        HasAnchoredTooltipProvider hasAnchoredTooltipProvider = (HasAnchoredTooltipProvider) anyEnvironment;
        tooltipAnchor.f21766b = view;
        hasAnchoredTooltipProvider.mo2427a(tooltipAnchor);
        Logger.a(8, EntryType.MARK_POP, 744038160, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TooltipAnchor tooltipAnchor = (TooltipAnchor) obj2;
        ((HasAnchoredTooltipProvider) anyEnvironment).mo2442b(tooltipAnchor);
        tooltipAnchor.f21766b = null;
    }

    public static AnchoredTooltipPartDefinition m28414a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnchoredTooltipPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f20665b) {
                AnchoredTooltipPartDefinition anchoredTooltipPartDefinition;
                if (a3 != null) {
                    anchoredTooltipPartDefinition = (AnchoredTooltipPartDefinition) a3.mo818a(f20665b);
                } else {
                    anchoredTooltipPartDefinition = f20664a;
                }
                if (anchoredTooltipPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m28413a();
                        if (a3 != null) {
                            a3.mo822a(f20665b, a2);
                        } else {
                            f20664a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = anchoredTooltipPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}

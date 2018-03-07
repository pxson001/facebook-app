package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.tooltip.AnchoredTooltipPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: hy */
public class StoryMenuButtonPartDefinition<E extends HasAnchoredTooltipProvider & HasMenuButtonProvider, V extends View & CanShowHeaderOptionsMenu> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Boolean, E, V> {
    private static StoryMenuButtonPartDefinition f20658e;
    private static final Object f20659f = new Object();
    private final AnchoredTooltipPartDefinition<V> f20660a;
    private final MenuButtonPartDefinition f20661b;
    private final TopicFeedsTooltipPartDefinition f20662c;
    private final StoryHeaderUtil f20663d;

    private static StoryMenuButtonPartDefinition m28409b(InjectorLike injectorLike) {
        return new StoryMenuButtonPartDefinition(AnchoredTooltipPartDefinition.m28414a(injectorLike), MenuButtonPartDefinition.m26324a(injectorLike), TopicFeedsTooltipPartDefinition.m28418a(injectorLike), StoryHeaderUtil.m28330a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        MenuConfig a = this.f20663d.m28333a(feedProps, ((HasMenuButtonProvider) ((HasAnchoredTooltipProvider) anyEnvironment)).mo2448e());
        boolean z = a != MenuConfig.HIDDEN;
        subParts.mo2755a(2131560877, this.f20661b, new Props(feedProps, a));
        if (z) {
            subParts.mo2756a(this.f20660a, graphQLStory);
            subParts.mo2756a(this.f20662c, graphQLStory);
        }
        return Boolean.valueOf(z);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1439482128);
        m28408a((Boolean) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1185370690, a);
    }

    @Inject
    public StoryMenuButtonPartDefinition(AnchoredTooltipPartDefinition anchoredTooltipPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, TopicFeedsTooltipPartDefinition topicFeedsTooltipPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f20660a = anchoredTooltipPartDefinition;
        this.f20661b = menuButtonPartDefinition;
        this.f20662c = topicFeedsTooltipPartDefinition;
        this.f20663d = storyHeaderUtil;
    }

    public static StoryMenuButtonPartDefinition m28407a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryMenuButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20659f) {
                StoryMenuButtonPartDefinition storyMenuButtonPartDefinition;
                if (a2 != null) {
                    storyMenuButtonPartDefinition = (StoryMenuButtonPartDefinition) a2.mo818a(f20659f);
                } else {
                    storyMenuButtonPartDefinition = f20658e;
                }
                if (storyMenuButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28409b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20659f, b3);
                        } else {
                            f20658e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storyMenuButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private static void m28408a(Boolean bool, V v) {
        ((CanShowHeaderOptionsMenu) v).setMenuButtonActive(bool.booleanValue());
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CanShowHeaderOptionsMenu) view).setMenuButtonActive(false);
    }
}

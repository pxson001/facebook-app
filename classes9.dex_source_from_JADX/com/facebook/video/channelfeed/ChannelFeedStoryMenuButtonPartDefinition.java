package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
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
/* compiled from: surge_multiplier */
public class ChannelFeedStoryMenuButtonPartDefinition<V extends View & CanShowHeaderOptionsMenu> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Boolean, HasMenuButtonProvider, V> {
    private static ChannelFeedStoryMenuButtonPartDefinition f2496b;
    private static final Object f2497c = new Object();
    private final MenuButtonPartDefinition f2498a;

    private static ChannelFeedStoryMenuButtonPartDefinition m2428b(InjectorLike injectorLike) {
        return new ChannelFeedStoryMenuButtonPartDefinition(MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m2429a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasMenuButtonProvider hasMenuButtonProvider = (HasMenuButtonProvider) anyEnvironment;
        FeedProps e = StoryProps.e((FeedProps) obj);
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        boolean a = hasMenuButtonProvider.e().a(graphQLStory).a(e);
        subParts.a(2131560877, this.f2498a, new Props(FeedProps.c(graphQLStory), a ? MenuConfig.CLICKABLE : MenuConfig.HIDDEN));
        return Boolean.valueOf(a);
    }

    public final /* bridge */ /* synthetic */ void m2430a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1076957946);
        m2427a((Boolean) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1156823756, a);
    }

    @Inject
    public ChannelFeedStoryMenuButtonPartDefinition(MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f2498a = menuButtonPartDefinition;
    }

    public static ChannelFeedStoryMenuButtonPartDefinition m2426a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedStoryMenuButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2497c) {
                ChannelFeedStoryMenuButtonPartDefinition channelFeedStoryMenuButtonPartDefinition;
                if (a2 != null) {
                    channelFeedStoryMenuButtonPartDefinition = (ChannelFeedStoryMenuButtonPartDefinition) a2.a(f2497c);
                } else {
                    channelFeedStoryMenuButtonPartDefinition = f2496b;
                }
                if (channelFeedStoryMenuButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2428b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2497c, b3);
                        } else {
                            f2496b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedStoryMenuButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m2427a(Boolean bool, V v) {
        ((CanShowHeaderOptionsMenu) v).setMenuButtonActive(bool.booleanValue());
    }

    public final void m2431b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CanShowHeaderOptionsMenu) view).setMenuButtonActive(false);
    }
}

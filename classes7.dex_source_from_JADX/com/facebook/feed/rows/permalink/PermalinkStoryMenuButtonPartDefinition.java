package com.facebook.feed.rows.permalink;

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
import com.facebook.feed.util.story.FeedStoryUtil;
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
/* compiled from: actor is null */
public class PermalinkStoryMenuButtonPartDefinition<V extends View & CanShowHeaderOptionsMenu> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Boolean, HasMenuButtonProvider, V> {
    private static PermalinkStoryMenuButtonPartDefinition f19949c;
    private static final Object f19950d = new Object();
    private final MenuButtonPartDefinition f19951a;
    private final FeedStoryUtil f19952b;

    private static PermalinkStoryMenuButtonPartDefinition m23151b(InjectorLike injectorLike) {
        return new PermalinkStoryMenuButtonPartDefinition(MenuButtonPartDefinition.a(injectorLike), FeedStoryUtil.a(injectorLike));
    }

    public final Object m23152a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        MenuConfig menuConfig = this.f19952b.a(feedProps, StoryProps.m(feedProps) ? feedProps.a(((GraphQLStory) feedProps.a).L()) : feedProps, ((HasMenuButtonProvider) anyEnvironment).e(), true) ? MenuConfig.CLICKABLE : MenuConfig.HIDDEN;
        subParts.a(2131560877, this.f19951a, new Props(feedProps, menuConfig));
        if (menuConfig != MenuConfig.HIDDEN) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final /* bridge */ /* synthetic */ void m23153a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 150105687);
        m23150a((Boolean) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1210352901, a);
    }

    @Inject
    public PermalinkStoryMenuButtonPartDefinition(MenuButtonPartDefinition menuButtonPartDefinition, FeedStoryUtil feedStoryUtil) {
        this.f19951a = menuButtonPartDefinition;
        this.f19952b = feedStoryUtil;
    }

    public static PermalinkStoryMenuButtonPartDefinition m23149a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkStoryMenuButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19950d) {
                PermalinkStoryMenuButtonPartDefinition permalinkStoryMenuButtonPartDefinition;
                if (a2 != null) {
                    permalinkStoryMenuButtonPartDefinition = (PermalinkStoryMenuButtonPartDefinition) a2.a(f19950d);
                } else {
                    permalinkStoryMenuButtonPartDefinition = f19949c;
                }
                if (permalinkStoryMenuButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23151b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19950d, b3);
                        } else {
                            f19949c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkStoryMenuButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m23150a(Boolean bool, V v) {
        ((CanShowHeaderOptionsMenu) v).setMenuButtonActive(bool.booleanValue());
    }
}

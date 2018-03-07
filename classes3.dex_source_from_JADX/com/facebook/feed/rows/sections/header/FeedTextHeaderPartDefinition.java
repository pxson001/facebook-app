package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_channel_subscribe_data */
public class FeedTextHeaderPartDefinition<E extends HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithMenuButtonView> {
    private static FeedTextHeaderPartDefinition f8d;
    private static final Object f9e = new Object();
    private final TextHeaderPartDefinition<E, TextWithMenuButtonView> f10a;
    private final TextLinkPartDefinition f11b;
    private final StoryMenuButtonPartDefinition<E, TextWithMenuButtonView> f12c;

    private static FeedTextHeaderPartDefinition m8b(InjectorLike injectorLike) {
        return new FeedTextHeaderPartDefinition(StoryMenuButtonPartDefinition.a(injectorLike), TextHeaderPartDefinition.a(injectorLike), TextLinkPartDefinition.a(injectorLike));
    }

    public final Object m10a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f10a, feedProps);
        subParts.a(this.f11b, feedProps);
        subParts.a(this.f12c, feedProps);
        return null;
    }

    @Inject
    public FeedTextHeaderPartDefinition(StoryMenuButtonPartDefinition storyMenuButtonPartDefinition, TextHeaderPartDefinition textHeaderPartDefinition, TextLinkPartDefinition textLinkPartDefinition) {
        this.f10a = textHeaderPartDefinition;
        this.f11b = textLinkPartDefinition;
        this.f12c = storyMenuButtonPartDefinition;
    }

    public final ViewType m9a() {
        return TextWithMenuButtonView.b;
    }

    public static FeedTextHeaderPartDefinition m7a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedTextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9e) {
                FeedTextHeaderPartDefinition feedTextHeaderPartDefinition;
                if (a2 != null) {
                    feedTextHeaderPartDefinition = (FeedTextHeaderPartDefinition) a2.a(f9e);
                } else {
                    feedTextHeaderPartDefinition = f8d;
                }
                if (feedTextHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9e, b3);
                        } else {
                            f8d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedTextHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

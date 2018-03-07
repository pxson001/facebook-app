package com.facebook.video.channelfeed;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundStyleResolver;
import com.facebook.feedplugins.base.footer.EdgeToEdgeFooterBackgroundStyleConfig;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleDefinition;
import com.facebook.feedplugins.base.footer.FooterBackgroundStylePartDefinition;
import com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition;
import com.facebook.feedplugins.base.footer.FooterButtonStylePartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.feedbackreactions.ReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
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
/* compiled from: sync_latest_user_info_fetch_timestamp_ms */
public class ChannelFeedReactionsFooterPartDefinition<E extends CanFeedback & CanShowVideoInFullScreen> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ReactionsFooterView> {
    private static ChannelFeedReactionsFooterPartDefinition f2375h;
    private static final Object f2376i = new Object();
    public final Resources f2377a;
    private final ReactionsFooterPartDefinition f2378b;
    private final FooterButtonStylePartDefinition<DefaultFooterView> f2379c;
    private final FooterBackgroundStylePartDefinition<DefaultFooterView> f2380d;
    private final DefaultFooterBackgroundStyleResolver f2381e;
    private final GraphQLStoryUtil f2382f;
    private final ReactionsExperimentUtil f2383g;

    private static ChannelFeedReactionsFooterPartDefinition m2329b(InjectorLike injectorLike) {
        return new ChannelFeedReactionsFooterPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), FooterButtonStylePartDefinition.a(injectorLike), FooterBackgroundStyleConfig_ForChannelFeedMethodAutoProvider.m2520b(injectorLike), ReactionsFooterPartDefinition.a(injectorLike), FooterBackgroundStylePartDefinition.a(injectorLike), GraphQLStoryUtil.a(injectorLike), ReactionsExperimentUtil.a(injectorLike));
    }

    public final Object m2331a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        FooterBackgroundStyleDefinition a = this.f2381e.a(FooterLevel.TOP);
        subParts.a(this.f2378b, feedProps);
        subParts.a(this.f2379c, new Props(graphQLStory.z(), graphQLStory.A(), StorySharingHelper.b(graphQLStory), a));
        subParts.a(this.f2380d, new FooterBackgroundStylePartDefinition.Props(a, a.a(this.f2377a, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE), null));
        return null;
    }

    public final boolean m2332a(Object obj) {
        return this.f2382f.n((FeedProps) obj) && this.f2383g.i();
    }

    @Inject
    public ChannelFeedReactionsFooterPartDefinition(Resources resources, FooterButtonStylePartDefinition footerButtonStylePartDefinition, EdgeToEdgeFooterBackgroundStyleConfig edgeToEdgeFooterBackgroundStyleConfig, ReactionsFooterPartDefinition reactionsFooterPartDefinition, FooterBackgroundStylePartDefinition footerBackgroundStylePartDefinition, GraphQLStoryUtil graphQLStoryUtil, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f2377a = resources;
        this.f2379c = footerButtonStylePartDefinition;
        this.f2378b = reactionsFooterPartDefinition;
        this.f2380d = footerBackgroundStylePartDefinition;
        this.f2381e = new DefaultFooterBackgroundStyleResolver(edgeToEdgeFooterBackgroundStyleConfig);
        this.f2382f = graphQLStoryUtil;
        this.f2383g = reactionsExperimentUtil;
    }

    public static ChannelFeedReactionsFooterPartDefinition m2328a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2376i) {
                ChannelFeedReactionsFooterPartDefinition channelFeedReactionsFooterPartDefinition;
                if (a2 != null) {
                    channelFeedReactionsFooterPartDefinition = (ChannelFeedReactionsFooterPartDefinition) a2.a(f2376i);
                } else {
                    channelFeedReactionsFooterPartDefinition = f2375h;
                }
                if (channelFeedReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2329b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2376i, b3);
                        } else {
                            f2375h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m2330a() {
        return ReactionsFooterView.h;
    }
}

package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: targeting_sentences */
public class ChannelFeedFooterPartSelector<E extends CanFeedback & CanShowVideoInFullScreen> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static ChannelFeedFooterPartSelector f2188d;
    private static final Object f2189e = new Object();
    private final GraphQLStoryUtil f2190a;
    private final ChannelFeedReactionsFooterPartDefinition<E> f2191b;
    private final ChannelFeedDefaultFooterPartDefinition<E> f2192c;

    private static ChannelFeedFooterPartSelector m2192b(InjectorLike injectorLike) {
        return new ChannelFeedFooterPartSelector(GraphQLStoryUtil.a(injectorLike), ChannelFeedReactionsFooterPartDefinition.m2328a(injectorLike), ChannelFeedDefaultFooterPartDefinition.m2121a(injectorLike));
    }

    public final Object m2193a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f2191b, feedProps).a(this.f2192c, feedProps);
        return null;
    }

    public final boolean m2194a(Object obj) {
        return GraphQLStoryUtil.f((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public ChannelFeedFooterPartSelector(GraphQLStoryUtil graphQLStoryUtil, ChannelFeedReactionsFooterPartDefinition channelFeedReactionsFooterPartDefinition, ChannelFeedDefaultFooterPartDefinition channelFeedDefaultFooterPartDefinition) {
        this.f2190a = graphQLStoryUtil;
        this.f2191b = channelFeedReactionsFooterPartDefinition;
        this.f2192c = channelFeedDefaultFooterPartDefinition;
    }

    public static ChannelFeedFooterPartSelector m2191a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedFooterPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2189e) {
                ChannelFeedFooterPartSelector channelFeedFooterPartSelector;
                if (a2 != null) {
                    channelFeedFooterPartSelector = (ChannelFeedFooterPartSelector) a2.a(f2189e);
                } else {
                    channelFeedFooterPartSelector = f2188d;
                }
                if (channelFeedFooterPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2192b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2189e, b3);
                        } else {
                            f2188d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedFooterPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

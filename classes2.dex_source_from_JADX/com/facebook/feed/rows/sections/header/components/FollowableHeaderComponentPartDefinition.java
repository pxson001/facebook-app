package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.components.FollowableHeaderComponent.Builder;
import com.facebook.feed.rows.sections.header.components.FollowableHeaderComponent.State;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image_size */
public class FollowableHeaderComponentPartDefinition<E extends CanFollowUser & HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static FollowableHeaderComponentPartDefinition f20378i;
    private static final Object f20379j = new Object();
    private final FollowableHeaderComponent<E> f20380c;
    private final GraphQLStoryUtil f20381d;
    private final StoryHeaderUtil f20382e;
    private final FeedBackgroundStylerComponentWrapper f20383f;
    private final FeedStoryMessageFlyoutComponent f20384g;
    private final AndroidComponentsExperimentHelper f20385h;

    private static FollowableHeaderComponentPartDefinition m28085b(InjectorLike injectorLike) {
        return new FollowableHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), FollowableHeaderComponent.m28107a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), StoryHeaderUtil.m28330a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final boolean m28089a(Object obj) {
        return GraphQLStoryUtil.m9576d((GraphQLStory) ((FeedProps) obj).f13444a) && this.f20385h.m10056b();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static FollowableHeaderComponentPartDefinition m28084a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowableHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20379j) {
                FollowableHeaderComponentPartDefinition followableHeaderComponentPartDefinition;
                if (a2 != null) {
                    followableHeaderComponentPartDefinition = (FollowableHeaderComponentPartDefinition) a2.mo818a(f20379j);
                } else {
                    followableHeaderComponentPartDefinition = f20378i;
                }
                if (followableHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28085b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20379j, b3);
                        } else {
                            f20378i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followableHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FollowableHeaderComponentPartDefinition(Context context, FollowableHeaderComponent followableHeaderComponent, GraphQLStoryUtil graphQLStoryUtil, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f20380c = followableHeaderComponent;
        this.f20381d = graphQLStoryUtil;
        this.f20382e = storyHeaderUtil;
        this.f20383f = feedBackgroundStylerComponentWrapper;
        this.f20384g = feedStoryMessageFlyoutComponent;
        this.f20385h = androidComponentsExperimentHelper;
    }

    private Component<?> m28083a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        FollowableHeaderComponent followableHeaderComponent = this.f20380c;
        State state = new State(followableHeaderComponent);
        Builder builder = (Builder) followableHeaderComponent.f20392c.mo740a();
        if (builder == null) {
            builder = new Builder(followableHeaderComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        builder2 = builder2;
        builder2.a.b = e;
        builder2.e.set(1);
        return this.f20384g.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f20383f.m28340b(componentContext, (HasPositionInformation) e, this.f20382e.m28334a((FeedProps) feedProps), builder2.mo3296d())).mo3296d();
    }

    public final ViewType mo2547a() {
        return DefaultHeaderComponentPartDefinition.f20811c;
    }
}

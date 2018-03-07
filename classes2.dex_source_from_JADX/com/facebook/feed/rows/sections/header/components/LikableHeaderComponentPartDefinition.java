package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
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
import com.facebook.feed.rows.sections.header.components.LikableHeaderComponent.Builder;
import com.facebook.feed.rows.sections.header.components.LikableHeaderComponent.State;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_accepted */
public class LikableHeaderComponentPartDefinition<E extends CanLikePage & HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static LikableHeaderComponentPartDefinition f23181h;
    private static final Object f23182i = new Object();
    private final LikableHeaderComponent<E> f23183c;
    private final StoryHeaderUtil f23184d;
    private final FeedBackgroundStylerComponentWrapper f23185e;
    private final FeedStoryMessageFlyoutComponent f23186f;
    private final AndroidComponentsExperimentHelper f23187g;

    private static LikableHeaderComponentPartDefinition m31295b(InjectorLike injectorLike) {
        return new LikableHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), LikableHeaderComponent.m31301a(injectorLike), StoryHeaderUtil.m28330a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static LikableHeaderComponentPartDefinition m31294a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikableHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23182i) {
                LikableHeaderComponentPartDefinition likableHeaderComponentPartDefinition;
                if (a2 != null) {
                    likableHeaderComponentPartDefinition = (LikableHeaderComponentPartDefinition) a2.mo818a(f23182i);
                } else {
                    likableHeaderComponentPartDefinition = f23181h;
                }
                if (likableHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31295b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23182i, b3);
                        } else {
                            f23181h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = likableHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public LikableHeaderComponentPartDefinition(Context context, LikableHeaderComponent likableHeaderComponent, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f23183c = likableHeaderComponent;
        this.f23184d = storyHeaderUtil;
        this.f23185e = feedBackgroundStylerComponentWrapper;
        this.f23186f = feedStoryMessageFlyoutComponent;
        this.f23187g = androidComponentsExperimentHelper;
    }

    private Component<?> m31293a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        LikableHeaderComponent likableHeaderComponent = this.f23183c;
        State state = new State(likableHeaderComponent);
        Builder builder = (Builder) likableHeaderComponent.f23191c.mo740a();
        if (builder == null) {
            builder = new Builder(likableHeaderComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        builder2 = builder2;
        builder2.a.b = e;
        builder2.e.set(1);
        Component d = builder2.mo3296d();
        return this.f23186f.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f23185e.m28340b(componentContext, (HasPositionInformation) e, this.f23184d.m28334a((FeedProps) feedProps), d)).mo3296d();
    }

    public final ViewType mo2547a() {
        return DefaultHeaderComponentPartDefinition.f20811c;
    }

    public final boolean m31299a(Object obj) {
        return this.f23187g.m10056b();
    }
}

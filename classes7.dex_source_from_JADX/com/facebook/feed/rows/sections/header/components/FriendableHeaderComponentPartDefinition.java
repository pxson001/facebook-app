package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.CanFriendPerson;
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
import com.facebook.feed.rows.sections.header.components.FriendableHeaderComponent.Builder;
import com.facebook.feed.rows.sections.header.components.FriendableHeaderComponent.State;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unknown FeedbackActionButton */
public class FriendableHeaderComponentPartDefinition<E extends CanFriendPerson & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasIsAsync> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static FriendableHeaderComponentPartDefinition f21281h;
    private static final Object f21282i = new Object();
    private final AndroidComponentsExperimentHelper f21283c;
    private final Lazy<FriendableHeaderComponent<E>> f21284d;
    private final StoryHeaderUtil f21285e;
    private final FeedBackgroundStylerComponentWrapper f21286f;
    private final FeedStoryMessageFlyoutComponent f21287g;

    private static FriendableHeaderComponentPartDefinition m24059b(InjectorLike injectorLike) {
        return new FriendableHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AndroidComponentsExperimentHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 6029), StoryHeaderUtil.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), FeedStoryMessageFlyoutComponent.a(injectorLike));
    }

    public final CacheableEntity m24064b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    public static FriendableHeaderComponentPartDefinition m24058a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendableHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21282i) {
                FriendableHeaderComponentPartDefinition friendableHeaderComponentPartDefinition;
                if (a2 != null) {
                    friendableHeaderComponentPartDefinition = (FriendableHeaderComponentPartDefinition) a2.a(f21282i);
                } else {
                    friendableHeaderComponentPartDefinition = f21281h;
                }
                if (friendableHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24059b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21282i, b3);
                        } else {
                            f21281h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendableHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendableHeaderComponentPartDefinition(Context context, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, Lazy<FriendableHeaderComponent> lazy, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent) {
        super(context);
        this.f21283c = androidComponentsExperimentHelper;
        this.f21284d = lazy;
        this.f21285e = storyHeaderUtil;
        this.f21286f = feedBackgroundStylerComponentWrapper;
        this.f21287g = feedStoryMessageFlyoutComponent;
    }

    private Component<?> m24057a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        FriendableHeaderComponent friendableHeaderComponent = (FriendableHeaderComponent) this.f21284d.get();
        State state = new State(friendableHeaderComponent);
        Builder builder = (Builder) friendableHeaderComponent.f21280c.a();
        if (builder == null) {
            builder = new Builder(friendableHeaderComponent);
        }
        Builder.m24050a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f21269a.f21274a = feedProps;
        builder2.f21273e.set(0);
        builder2 = builder2;
        builder2.f21269a.f21275b = e;
        builder2.f21273e.set(1);
        Component d = builder2.d();
        return this.f21287g.a(componentContext).a(feedProps).a(StoryRenderContext.NEWSFEED).a(this.f21286f.b(componentContext, (HasPositionInformation) e, this.f21285e.a(feedProps), d)).d();
    }

    public final boolean m24063a(Object obj) {
        return this.f21283c.b();
    }

    public final ViewType m24062a() {
        return DefaultHeaderComponentPartDefinition.c;
    }
}

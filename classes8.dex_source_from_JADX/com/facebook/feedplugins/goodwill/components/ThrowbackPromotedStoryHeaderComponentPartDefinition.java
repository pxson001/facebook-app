package com.facebook.feedplugins.goodwill.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
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
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponentPartDefinition;
import com.facebook.feedplugins.goodwill.components.ThrowbackPromotedStoryHeaderComponent.Builder;
import com.facebook.feedplugins.goodwill.components.ThrowbackPromotedStoryHeaderComponent.State;
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
/* compiled from: getModel() for invalid index */
public class ThrowbackPromotedStoryHeaderComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static ThrowbackPromotedStoryHeaderComponentPartDefinition f12666g;
    private static final Object f12667h = new Object();
    private final AndroidComponentsExperimentHelper f12668c;
    private final ThrowbackPromotedStoryHeaderComponent<E> f12669d;
    private final StoryHeaderUtil f12670e;
    private final FeedBackgroundStylerComponentWrapper f12671f;

    private static ThrowbackPromotedStoryHeaderComponentPartDefinition m14486b(InjectorLike injectorLike) {
        return new ThrowbackPromotedStoryHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AndroidComponentsExperimentHelper.a(injectorLike), ThrowbackPromotedStoryHeaderComponent.m14480a(injectorLike), StoryHeaderUtil.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike));
    }

    public final CacheableEntity m14491b(Object obj) {
        return (CacheableEntity) ((FeedProps) obj).a;
    }

    @Inject
    public ThrowbackPromotedStoryHeaderComponentPartDefinition(Context context, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, ThrowbackPromotedStoryHeaderComponent throwbackPromotedStoryHeaderComponent, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper) {
        super(context);
        this.f12668c = androidComponentsExperimentHelper;
        this.f12669d = throwbackPromotedStoryHeaderComponent;
        this.f12670e = storyHeaderUtil;
        this.f12671f = feedBackgroundStylerComponentWrapper;
    }

    public static ThrowbackPromotedStoryHeaderComponentPartDefinition m14485a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotedStoryHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12667h) {
                ThrowbackPromotedStoryHeaderComponentPartDefinition throwbackPromotedStoryHeaderComponentPartDefinition;
                if (a2 != null) {
                    throwbackPromotedStoryHeaderComponentPartDefinition = (ThrowbackPromotedStoryHeaderComponentPartDefinition) a2.a(f12667h);
                } else {
                    throwbackPromotedStoryHeaderComponentPartDefinition = f12666g;
                }
                if (throwbackPromotedStoryHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14486b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12667h, b3);
                        } else {
                            f12666g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotedStoryHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m14484a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        ThrowbackPromotedStoryHeaderComponent throwbackPromotedStoryHeaderComponent = this.f12669d;
        State state = new State(throwbackPromotedStoryHeaderComponent);
        Builder builder = (Builder) throwbackPromotedStoryHeaderComponent.f12665c.a();
        if (builder == null) {
            builder = new Builder(throwbackPromotedStoryHeaderComponent);
        }
        Builder.m14477a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f12654a.f12659a = feedProps;
        builder2.f12658e.set(0);
        builder2 = builder2;
        builder2.f12654a.f12660b = e;
        builder2.f12658e.set(1);
        Component d = builder2.d();
        return this.f12671f.b(componentContext, (HasPositionInformation) e, this.f12670e.a(feedProps), d);
    }

    public final boolean m14490a(Object obj) {
        return this.f12668c.b();
    }

    public final ViewType m14489a() {
        return DefaultHeaderComponentPartDefinition.c;
    }
}

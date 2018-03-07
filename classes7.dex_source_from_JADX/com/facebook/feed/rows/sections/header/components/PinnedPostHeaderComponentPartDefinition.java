package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
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
import com.facebook.feed.rows.sections.header.BaseHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.components.PinnedPostHeaderComponent.Builder;
import com.facebook.feed.rows.sections.header.components.PinnedPostHeaderComponent.State;
import com.facebook.feed.rows.sections.tooltip.AnchoredTooltipPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unexpected error while disconnecting */
public class PinnedPostHeaderComponentPartDefinition<E extends HasAnchoredTooltipProvider & HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static PinnedPostHeaderComponentPartDefinition f21382i;
    private static final Object f21383j = new Object();
    private final AnchoredTooltipPartDefinition<FeedComponentView> f21384c;
    private final PinnedPostHeaderComponent<E> f21385d;
    private final StoryHeaderUtil f21386e;
    private final FeedBackgroundStylerComponentWrapper f21387f;
    private final FeedStoryMessageFlyoutComponent f21388g;
    private final AndroidComponentsExperimentHelper f21389h;

    private static PinnedPostHeaderComponentPartDefinition m24104b(InjectorLike injectorLike) {
        return new PinnedPostHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), PinnedPostHeaderComponent.m24098a(injectorLike), StoryHeaderUtil.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), FeedStoryMessageFlyoutComponent.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike), AnchoredTooltipPartDefinition.a(injectorLike));
    }

    public final void m24108a(SubParts subParts, Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        super.a(subParts, feedProps);
        subParts.a(this.f21384c, feedProps.a);
    }

    public final boolean m24109a(Object obj) {
        return BaseHeaderPartDefinition.b((FeedProps) obj) && this.f21389h.b();
    }

    public final CacheableEntity m24110b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    public static PinnedPostHeaderComponentPartDefinition m24103a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PinnedPostHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21383j) {
                PinnedPostHeaderComponentPartDefinition pinnedPostHeaderComponentPartDefinition;
                if (a2 != null) {
                    pinnedPostHeaderComponentPartDefinition = (PinnedPostHeaderComponentPartDefinition) a2.a(f21383j);
                } else {
                    pinnedPostHeaderComponentPartDefinition = f21382i;
                }
                if (pinnedPostHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24104b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21383j, b3);
                        } else {
                            f21382i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pinnedPostHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PinnedPostHeaderComponentPartDefinition(Context context, PinnedPostHeaderComponent pinnedPostHeaderComponent, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, AnchoredTooltipPartDefinition anchoredTooltipPartDefinition) {
        super(context);
        this.f21385d = pinnedPostHeaderComponent;
        this.f21386e = storyHeaderUtil;
        this.f21387f = feedBackgroundStylerComponentWrapper;
        this.f21388g = feedStoryMessageFlyoutComponent;
        this.f21389h = androidComponentsExperimentHelper;
        this.f21384c = anchoredTooltipPartDefinition;
    }

    private Component<?> m24102a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        PinnedPostHeaderComponent pinnedPostHeaderComponent = this.f21385d;
        State state = new State(pinnedPostHeaderComponent);
        Builder builder = (Builder) pinnedPostHeaderComponent.f21381c.a();
        if (builder == null) {
            builder = new Builder(pinnedPostHeaderComponent);
        }
        Builder.m24095a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f21370a.f21375a = feedProps;
        builder2.f21374e.set(0);
        Builder builder3 = builder2;
        builder3.f21370a.f21376b = (HasContext) e;
        builder3.f21374e.set(1);
        Component d = builder3.d();
        return this.f21388g.a(componentContext).a(feedProps).a(StoryRenderContext.NEWSFEED).a(this.f21387f.b(componentContext, (HasPositionInformation) e, this.f21386e.a(feedProps), d)).d();
    }

    public final ViewType m24107a() {
        return DefaultHeaderComponentPartDefinition.c;
    }
}

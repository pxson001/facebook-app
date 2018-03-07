package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
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
import com.facebook.feed.rows.sections.header.HeaderWithSeeFirstLayoutPartDefinition;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.components.HeaderWithSeeFirstComponent.Builder;
import com.facebook.feed.rows.sections.header.components.HeaderWithSeeFirstComponent.State;
import com.facebook.feed.rows.sections.tooltip.AnchoredTooltipPartDefinition;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feedplugins.graphqlstory.header.SeeFirstTooltipPartDefinition;
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
/* compiled from: http/1.1 */
public class HeaderWithSeeFirstComponentPartDefinition<E extends HasAnchoredTooltipProvider & HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static HeaderWithSeeFirstComponentPartDefinition f20757k;
    private static final Object f20758l = new Object();
    private final HeaderWithSeeFirstComponent<E> f20759c;
    private final StoryHeaderUtil f20760d;
    private final FeedBackgroundStylerComponentWrapper f20761e;
    private final FeedStoryMessageFlyoutComponent f20762f;
    private final AndroidComponentsExperimentHelper f20763g;
    private final SeeFirstStateManager f20764h;
    private final SeeFirstTooltipPartDefinition<FeedHeaderComponentView> f20765i;
    private final AnchoredTooltipPartDefinition<FeedHeaderComponentView> f20766j;

    private static HeaderWithSeeFirstComponentPartDefinition m28476b(InjectorLike injectorLike) {
        return new HeaderWithSeeFirstComponentPartDefinition((Context) injectorLike.getInstance(Context.class), HeaderWithSeeFirstComponent.m28483a(injectorLike), StoryHeaderUtil.m28330a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike), SeeFirstStateManager.m16868a(injectorLike), SeeFirstTooltipPartDefinition.m28502a(injectorLike), AnchoredTooltipPartDefinition.m28414a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        obj = (FeedProps) obj;
        super.mo3132a(subParts, obj);
        subParts.mo2756a(this.f20765i, obj.f13444a);
        subParts.mo2756a(this.f20766j, obj.f13444a);
    }

    public final boolean m28481a(Object obj) {
        return HeaderWithSeeFirstLayoutPartDefinition.m28508a((FeedProps) obj, this.f20764h) && this.f20763g.m10056b();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static HeaderWithSeeFirstComponentPartDefinition m28475a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderWithSeeFirstComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20758l) {
                HeaderWithSeeFirstComponentPartDefinition headerWithSeeFirstComponentPartDefinition;
                if (a2 != null) {
                    headerWithSeeFirstComponentPartDefinition = (HeaderWithSeeFirstComponentPartDefinition) a2.mo818a(f20758l);
                } else {
                    headerWithSeeFirstComponentPartDefinition = f20757k;
                }
                if (headerWithSeeFirstComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28476b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20758l, b3);
                        } else {
                            f20757k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerWithSeeFirstComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public HeaderWithSeeFirstComponentPartDefinition(Context context, HeaderWithSeeFirstComponent headerWithSeeFirstComponent, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, SeeFirstStateManager seeFirstStateManager, SeeFirstTooltipPartDefinition seeFirstTooltipPartDefinition, AnchoredTooltipPartDefinition anchoredTooltipPartDefinition) {
        super(context);
        this.f20759c = headerWithSeeFirstComponent;
        this.f20760d = storyHeaderUtil;
        this.f20761e = feedBackgroundStylerComponentWrapper;
        this.f20762f = feedStoryMessageFlyoutComponent;
        this.f20763g = androidComponentsExperimentHelper;
        this.f20764h = seeFirstStateManager;
        this.f20765i = seeFirstTooltipPartDefinition;
        this.f20766j = anchoredTooltipPartDefinition;
    }

    private Component<?> m28474a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        HeaderWithSeeFirstComponent headerWithSeeFirstComponent = this.f20759c;
        State state = new State(headerWithSeeFirstComponent);
        Builder builder = (Builder) headerWithSeeFirstComponent.f20770c.mo740a();
        if (builder == null) {
            builder = new Builder(headerWithSeeFirstComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        Builder builder3 = builder2;
        builder3.a.b = (HasFeedListType) e;
        builder3.e.set(1);
        Component d = builder3.mo3296d();
        return this.f20762f.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f20761e.m28340b(componentContext, (HasPositionInformation) e, this.f20760d.m28334a((FeedProps) feedProps), d)).mo3296d();
    }

    public final ViewType mo2547a() {
        return DefaultHeaderComponentPartDefinition.f20811c;
    }
}

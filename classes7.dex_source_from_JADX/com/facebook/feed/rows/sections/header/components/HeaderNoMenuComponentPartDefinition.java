package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.analytics.StoryRenderContext;
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
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponent.Builder;
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
/* compiled from: Unhandled indirect reference */
public class HeaderNoMenuComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static HeaderNoMenuComponentPartDefinition f21329h;
    private static final Object f21330i = new Object();
    private final DefaultHeaderComponent<E> f21331c;
    private final StoryHeaderUtil f21332d;
    private final FeedBackgroundStylerComponentWrapper f21333e;
    private final FeedStoryMessageFlyoutComponent f21334f;
    private final AndroidComponentsExperimentHelper f21335g;

    private static HeaderNoMenuComponentPartDefinition m24083b(InjectorLike injectorLike) {
        return new HeaderNoMenuComponentPartDefinition((Context) injectorLike.getInstance(Context.class), DefaultHeaderComponent.a(injectorLike), StoryHeaderUtil.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), FeedStoryMessageFlyoutComponent.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final boolean m24087a(Object obj) {
        return BaseHeaderPartDefinition.b((FeedProps) obj) && this.f21335g.b();
    }

    public final CacheableEntity m24088b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    public static HeaderNoMenuComponentPartDefinition m24082a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderNoMenuComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21330i) {
                HeaderNoMenuComponentPartDefinition headerNoMenuComponentPartDefinition;
                if (a2 != null) {
                    headerNoMenuComponentPartDefinition = (HeaderNoMenuComponentPartDefinition) a2.a(f21330i);
                } else {
                    headerNoMenuComponentPartDefinition = f21329h;
                }
                if (headerNoMenuComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24083b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21330i, b3);
                        } else {
                            f21329h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = headerNoMenuComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public HeaderNoMenuComponentPartDefinition(Context context, DefaultHeaderComponent defaultHeaderComponent, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f21331c = defaultHeaderComponent;
        this.f21332d = storyHeaderUtil;
        this.f21333e = feedBackgroundStylerComponentWrapper;
        this.f21334f = feedStoryMessageFlyoutComponent;
        this.f21335g = androidComponentsExperimentHelper;
    }

    private Component<?> m24081a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Builder a = this.f21331c.a(componentContext).a(feedProps).a((HasFeedListType) e);
        a.a.c = true;
        Component d = a.d();
        return this.f21334f.a(componentContext).a(feedProps).a(StoryRenderContext.NEWSFEED).a(this.f21333e.b(componentContext, (HasPositionInformation) e, this.f21332d.a(feedProps), d)).d();
    }

    public final ViewType m24086a() {
        return DefaultHeaderComponentPartDefinition.c;
    }
}

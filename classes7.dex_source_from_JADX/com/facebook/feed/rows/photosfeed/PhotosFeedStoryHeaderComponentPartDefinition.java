package com.facebook.feed.rows.photosfeed;

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
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponent;
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponentPartDefinition;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: _startFetching */
public class PhotosFeedStoryHeaderComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static PhotosFeedStoryHeaderComponentPartDefinition f20304h;
    private static final Object f20305i = new Object();
    private final PhotosFeedStoryHeaderPartDefinition f20306c;
    private final DefaultHeaderComponent<E> f20307d;
    private final PhotosFeedBackgroundComponent f20308e;
    private final FeedStoryMessageFlyoutComponent f20309f;
    private final AndroidComponentsExperimentHelper f20310g;

    private static PhotosFeedStoryHeaderComponentPartDefinition m23428b(InjectorLike injectorLike) {
        return new PhotosFeedStoryHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), PhotosFeedStoryHeaderPartDefinition.m23434a(injectorLike), DefaultHeaderComponent.a(injectorLike), PhotosFeedBackgroundComponent.m23319a(injectorLike), FeedStoryMessageFlyoutComponent.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final boolean m23432a(Object obj) {
        return this.f20306c.m23438a((FeedProps) obj) && this.f20310g.b();
    }

    public final CacheableEntity m23433b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    @Inject
    public PhotosFeedStoryHeaderComponentPartDefinition(Context context, PhotosFeedStoryHeaderPartDefinition photosFeedStoryHeaderPartDefinition, DefaultHeaderComponent defaultHeaderComponent, PhotosFeedBackgroundComponent photosFeedBackgroundComponent, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f20306c = photosFeedStoryHeaderPartDefinition;
        this.f20307d = defaultHeaderComponent;
        this.f20308e = photosFeedBackgroundComponent;
        this.f20309f = feedStoryMessageFlyoutComponent;
        this.f20310g = androidComponentsExperimentHelper;
    }

    public static PhotosFeedStoryHeaderComponentPartDefinition m23427a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20305i) {
                PhotosFeedStoryHeaderComponentPartDefinition photosFeedStoryHeaderComponentPartDefinition;
                if (a2 != null) {
                    photosFeedStoryHeaderComponentPartDefinition = (PhotosFeedStoryHeaderComponentPartDefinition) a2.a(f20305i);
                } else {
                    photosFeedStoryHeaderComponentPartDefinition = f20304h;
                }
                if (photosFeedStoryHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23428b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20305i, b3);
                        } else {
                            f20304h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23431a() {
        return DefaultHeaderComponentPartDefinition.c;
    }

    private Component<?> m23426a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Component d = this.f20307d.a(componentContext).a(feedProps).a((HasFeedListType) e).d();
        return this.f20309f.a(componentContext).a(feedProps).a(StoryRenderContext.PHOTOS_FEED).a(this.f20308e.m23321a(componentContext).m23314a(d).m23315a((HasPositionInformation) e).m23316a(new StylingData(feedProps, PaddingStyle.i)).d()).d();
    }
}

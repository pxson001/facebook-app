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
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.sections.text.ContentTextComponent;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition;
import com.facebook.feed.rows.sections.text.CopyTextPartDefinition;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: _last_download_time */
public class PhotosFeedStoryTextComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static PhotosFeedStoryTextComponentPartDefinition f20324i;
    private static final Object f20325j = new Object();
    private final PhotosFeedStoryTextPartDefinition f20326c;
    private final ContentTextComponent<E> f20327d;
    private final PhotosFeedBackgroundComponent f20328e;
    private final FeedStoryMessageFlyoutComponent f20329f;
    private final CopyTextPartDefinition f20330g;
    private final AndroidComponentsExperimentHelper f20331h;

    private static PhotosFeedStoryTextComponentPartDefinition m23452b(InjectorLike injectorLike) {
        return new PhotosFeedStoryTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), PhotosFeedStoryTextPartDefinition.m23459a(injectorLike), ContentTextComponent.a(injectorLike), PhotosFeedBackgroundComponent.m23319a(injectorLike), FeedStoryMessageFlyoutComponent.a(injectorLike), CopyTextPartDefinition.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final void m23456a(SubParts subParts, Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        super.a(subParts, feedProps);
        subParts.a(this.f20330g, feedProps.a);
    }

    public final boolean m23457a(Object obj) {
        return this.f20326c.m23463a((FeedProps) obj) && this.f20331h.f();
    }

    public final CacheableEntity m23458b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    @Inject
    public PhotosFeedStoryTextComponentPartDefinition(Context context, PhotosFeedStoryTextPartDefinition photosFeedStoryTextPartDefinition, ContentTextComponent contentTextComponent, PhotosFeedBackgroundComponent photosFeedBackgroundComponent, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, CopyTextPartDefinition copyTextPartDefinition, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f20326c = photosFeedStoryTextPartDefinition;
        this.f20327d = contentTextComponent;
        this.f20328e = photosFeedBackgroundComponent;
        this.f20329f = feedStoryMessageFlyoutComponent;
        this.f20330g = copyTextPartDefinition;
        this.f20331h = androidComponentsExperimentHelper;
    }

    public static PhotosFeedStoryTextComponentPartDefinition m23451a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20325j) {
                PhotosFeedStoryTextComponentPartDefinition photosFeedStoryTextComponentPartDefinition;
                if (a2 != null) {
                    photosFeedStoryTextComponentPartDefinition = (PhotosFeedStoryTextComponentPartDefinition) a2.a(f20325j);
                } else {
                    photosFeedStoryTextComponentPartDefinition = f20324i;
                }
                if (photosFeedStoryTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23452b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20325j, b3);
                        } else {
                            f20324i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23455a() {
        return ContentTextComponentPartDefinition.c;
    }

    private Component<?> m23450a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Component d = this.f20327d.a(componentContext).a(feedProps).a(e).d();
        return this.f20329f.a(componentContext).a(feedProps).a(StoryRenderContext.PHOTOS_FEED).a(this.f20328e.m23321a(componentContext).m23314a(d).m23315a((HasPositionInformation) e).m23316a(new StylingData(feedProps, PaddingStyle.e)).d()).d();
    }
}

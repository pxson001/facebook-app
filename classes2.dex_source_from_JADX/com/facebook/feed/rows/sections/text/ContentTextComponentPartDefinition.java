package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.view.View;
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
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.story.FeedStoryUtil;
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
/* compiled from: free.facebook.com */
public class ContentTextComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    public static final ViewType<ContentTextComponentView> f23279c = new C09451();
    private static ContentTextComponentPartDefinition f23280i;
    private static final Object f23281j = new Object();
    private final ContentTextComponent<E> f23282d;
    private final FeedStoryUtil f23283e;
    private final CopyTextPartDefinition<ContentTextComponentView> f23284f;
    private final FeedBackgroundStylerComponentWrapper f23285g;
    private final FeedStoryMessageFlyoutComponent f23286h;

    /* compiled from: free.facebook.com */
    final class C09451 extends ViewType<ContentTextComponentView> {
        C09451() {
        }

        public final View mo1995a(Context context) {
            return new ContentTextComponentView(context);
        }
    }

    private static ContentTextComponentPartDefinition m31400b(InjectorLike injectorLike) {
        return new ContentTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ContentTextComponent.m28640a(injectorLike), FeedStoryUtil.m18578a(injectorLike), CopyTextPartDefinition.m28618a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        obj = (FeedProps) obj;
        super.mo3132a(subParts, obj);
        subParts.mo2756a(this.f23284f, obj.f13444a);
    }

    public final boolean m31405a(Object obj) {
        return FeedStoryUtil.m18583b((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static ContentTextComponentPartDefinition m31399a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23281j) {
                ContentTextComponentPartDefinition contentTextComponentPartDefinition;
                if (a2 != null) {
                    contentTextComponentPartDefinition = (ContentTextComponentPartDefinition) a2.mo818a(f23281j);
                } else {
                    contentTextComponentPartDefinition = f23280i;
                }
                if (contentTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31400b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23281j, b3);
                        } else {
                            f23280i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = contentTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ContentTextComponentPartDefinition(Context context, ContentTextComponent contentTextComponent, FeedStoryUtil feedStoryUtil, CopyTextPartDefinition copyTextPartDefinition, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent) {
        super(context);
        this.f23282d = contentTextComponent;
        this.f23283e = feedStoryUtil;
        this.f23284f = copyTextPartDefinition;
        this.f23285g = feedBackgroundStylerComponentWrapper;
        this.f23286h = feedStoryMessageFlyoutComponent;
    }

    private Component<?> m31398a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Component d = this.f23282d.m28642a(componentContext).a(feedProps).a(e).mo3296d();
        return this.f23286h.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f23285g.m28340b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, PaddingStyle.f13075e), d)).mo3296d();
    }

    public final ViewType mo2547a() {
        return f23279c;
    }
}

package com.facebook.feed.rows.permalink;

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
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.sections.text.ContentTextComponent;
import com.facebook.feed.rows.sections.text.ContentTextComponent.Builder;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition.ContentTextComponentView;
import com.facebook.feed.rows.sections.text.CopyTextPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
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
/* compiled from: activity_picker_verbs_loaded */
public class PermalinkTextComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static PermalinkTextComponentPartDefinition f19962h;
    private static final Object f19963i = new Object();
    private final ContentTextComponent<E> f19964c;
    private final CopyTextPartDefinition<ContentTextComponentView> f19965d;
    private final FeedBackgroundStylerComponentWrapper f19966e;
    private final FeedStoryMessageFlyoutComponent f19967f;
    private final AndroidComponentsExperimentHelper f19968g;

    private static PermalinkTextComponentPartDefinition m23162b(InjectorLike injectorLike) {
        return new PermalinkTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ContentTextComponent.a(injectorLike), CopyTextPartDefinition.a(injectorLike), FeedStoryMessageFlyoutComponent.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final void m23166a(SubParts subParts, Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        super.a(subParts, feedProps);
        subParts.a(this.f19965d, feedProps.a);
    }

    public final CacheableEntity m23168b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    @Inject
    public PermalinkTextComponentPartDefinition(Context context, ContentTextComponent contentTextComponent, CopyTextPartDefinition copyTextPartDefinition, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f19964c = contentTextComponent;
        this.f19965d = copyTextPartDefinition;
        this.f19967f = feedStoryMessageFlyoutComponent;
        this.f19966e = feedBackgroundStylerComponentWrapper;
        this.f19968g = androidComponentsExperimentHelper;
    }

    public static PermalinkTextComponentPartDefinition m23161a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19963i) {
                PermalinkTextComponentPartDefinition permalinkTextComponentPartDefinition;
                if (a2 != null) {
                    permalinkTextComponentPartDefinition = (PermalinkTextComponentPartDefinition) a2.a(f19963i);
                } else {
                    permalinkTextComponentPartDefinition = f19962h;
                }
                if (permalinkTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23162b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19963i, b3);
                        } else {
                            f19962h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m23160a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Builder a = this.f19964c.a(componentContext).a(feedProps).a(e);
        a.a.g = false;
        Component d = a.d();
        return this.f19967f.a(componentContext).a(feedProps).a(StoryRenderContext.PERMALINK).a(this.f19966e.b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, PaddingStyle.e), d)).d();
    }

    public final boolean m23167a(Object obj) {
        return this.f19968g.g();
    }

    public final ViewType m23165a() {
        return ContentTextComponentPartDefinition.c;
    }
}

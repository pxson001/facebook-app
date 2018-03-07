package com.facebook.feed.rows.sections.text;

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
import com.facebook.feed.rows.sections.text.ContentTextComponent.Builder;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition.ContentTextComponentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper.Configuration;
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
/* compiled from: home_stories_cursor_index */
public class VariableTextSizeClickableComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static VariableTextSizeClickableComponentPartDefinition f20939k;
    private static final Object f20940l = new Object();
    private final ContentTextComponent<E> f20941c;
    private final FeedStoryUtil f20942d;
    private final AndroidComponentsExperimentHelper f20943e;
    private final CopyTextPartDefinition<ContentTextComponentView> f20944f;
    private final FeedBackgroundStylerComponentWrapper f20945g;
    private final FeedStoryMessageFlyoutComponent f20946h;
    private final FeedTextSizeExperimentUtil f20947i;
    private final FeedTextSizeExperimentHelper f20948j;

    private static VariableTextSizeClickableComponentPartDefinition m28666b(InjectorLike injectorLike) {
        return new VariableTextSizeClickableComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ContentTextComponent.m28640a(injectorLike), FeedStoryUtil.m18578a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike), CopyTextPartDefinition.m28618a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike), FeedTextSizeExperimentUtil.m28675a(injectorLike), FeedTextSizeExperimentHelper.m28684a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        obj = (FeedProps) obj;
        super.mo3132a(subParts, obj);
        subParts.mo2756a(this.f20944f, obj.f13444a);
    }

    public final boolean m28671a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return this.f20947i.m28680a(graphQLStory) && FeedStoryUtil.m18583b(graphQLStory) && this.f20943e.m10057f();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static VariableTextSizeClickableComponentPartDefinition m28665a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VariableTextSizeClickableComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20940l) {
                VariableTextSizeClickableComponentPartDefinition variableTextSizeClickableComponentPartDefinition;
                if (a2 != null) {
                    variableTextSizeClickableComponentPartDefinition = (VariableTextSizeClickableComponentPartDefinition) a2.mo818a(f20940l);
                } else {
                    variableTextSizeClickableComponentPartDefinition = f20939k;
                }
                if (variableTextSizeClickableComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28666b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20940l, b3);
                        } else {
                            f20939k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = variableTextSizeClickableComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public VariableTextSizeClickableComponentPartDefinition(Context context, ContentTextComponent contentTextComponent, FeedStoryUtil feedStoryUtil, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, CopyTextPartDefinition copyTextPartDefinition, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, FeedTextSizeExperimentUtil feedTextSizeExperimentUtil, FeedTextSizeExperimentHelper feedTextSizeExperimentHelper) {
        super(context);
        this.f20941c = contentTextComponent;
        this.f20942d = feedStoryUtil;
        this.f20943e = androidComponentsExperimentHelper;
        this.f20944f = copyTextPartDefinition;
        this.f20945g = feedBackgroundStylerComponentWrapper;
        this.f20946h = feedStoryMessageFlyoutComponent;
        this.f20947i = feedTextSizeExperimentUtil;
        this.f20948j = feedTextSizeExperimentHelper;
    }

    private Component<?> m28664a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Configuration b = this.f20948j.m28693b((GraphQLStory) feedProps.f13444a);
        Builder h = this.f20941c.m28642a(componentContext).a(feedProps).a(e).h(FeedTextSizeExperimentUtil.m28677b(b.b));
        h.a.d = this.f20947i.m28679a();
        Component d = h.a(FeedTextSizeExperimentUtil.m28674a(b.g)).a(FeedTextSizeExperimentUtil.m28673a(b.e)).mo3296d();
        return this.f20946h.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f20945g.m28340b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, FeedTextSizeExperimentUtil.m28676a(b.d, b.c)), d)).mo3296d();
    }

    public final ViewType mo2547a() {
        return ContentTextComponentPartDefinition.f23279c;
    }
}

package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.sections.header.components.FeedTextHeaderComponent;
import com.facebook.feed.rows.sections.header.components.FeedTextHeaderComponent.Builder;
import com.facebook.feed.rows.sections.header.components.FeedTextHeaderComponent.State;
import com.facebook.feed.rows.sections.tooltip.AnchoredTooltipPartDefinition;
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
/* compiled from: feed_unit_full_view_debug */
public class FeedTextHeaderComponentPartDefinition<E extends HasAnchoredTooltipProvider & HasContext & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    public static final ViewType f24487c = new C09901();
    private static FeedTextHeaderComponentPartDefinition f24488j;
    private static final Object f24489k = new Object();
    private final FeedTextHeaderComponent<E> f24490d;
    private final FeedTextHeaderPartDefinition<E> f24491e;
    private final FeedBackgroundStylerComponentWrapper f24492f;
    private final FeedStoryMessageFlyoutComponent f24493g;
    private final AnchoredTooltipPartDefinition<FeedComponentView> f24494h;
    private final AndroidComponentsExperimentHelper f24495i;

    /* compiled from: feed_unit_full_view_debug */
    final class C09901 extends ViewType {
        C09901() {
        }

        public final View mo1995a(Context context) {
            return new FeedComponentView(context);
        }
    }

    private static FeedTextHeaderComponentPartDefinition m32795b(InjectorLike injectorLike) {
        return new FeedTextHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), FeedTextHeaderComponent.a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike), FeedTextHeaderPartDefinition.a(injectorLike), AnchoredTooltipPartDefinition.m28414a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        obj = (FeedProps) obj;
        super.mo3132a(subParts, obj);
        subParts.mo2756a(this.f24494h, obj.f13444a);
    }

    public final boolean m32800a(Object obj) {
        return TextHeaderPartDefinition.m32784a((FeedProps) obj) && this.f24495i.m10062n();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static FeedTextHeaderComponentPartDefinition m32794a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedTextHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24489k) {
                FeedTextHeaderComponentPartDefinition feedTextHeaderComponentPartDefinition;
                if (a2 != null) {
                    feedTextHeaderComponentPartDefinition = (FeedTextHeaderComponentPartDefinition) a2.mo818a(f24489k);
                } else {
                    feedTextHeaderComponentPartDefinition = f24488j;
                }
                if (feedTextHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32795b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24489k, b3);
                        } else {
                            f24488j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedTextHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedTextHeaderComponentPartDefinition(Context context, FeedTextHeaderComponent feedTextHeaderComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, FeedTextHeaderPartDefinition feedTextHeaderPartDefinition, AnchoredTooltipPartDefinition anchoredTooltipPartDefinition, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f24490d = feedTextHeaderComponent;
        this.f24492f = feedBackgroundStylerComponentWrapper;
        this.f24493g = feedStoryMessageFlyoutComponent;
        this.f24491e = feedTextHeaderPartDefinition;
        this.f24494h = anchoredTooltipPartDefinition;
        this.f24495i = androidComponentsExperimentHelper;
    }

    public final ViewType mo2547a() {
        return f24487c;
    }

    private Component<?> m32793a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        FeedTextHeaderComponent feedTextHeaderComponent = this.f24490d;
        State state = new State(feedTextHeaderComponent);
        Builder builder = (Builder) feedTextHeaderComponent.c.mo740a();
        if (builder == null) {
            builder = new Builder(feedTextHeaderComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        Builder builder3 = builder2;
        builder3.a.b = (HasInvalidate) e;
        builder3.e.set(1);
        Component d = builder3.mo3296d();
        return this.f24493g.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f24492f.m28340b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, PaddingStyle.f13080j), d)).mo3296d();
    }
}

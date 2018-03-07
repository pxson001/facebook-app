package com.facebook.feed.rows.sections.header.components;

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
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.components.FeedStoryMessageFlyoutComponent;
import com.facebook.feed.rows.sections.header.BaseHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.tooltip.AnchoredTooltipPartDefinition;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
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
/* compiled from: hr_HR */
public class DefaultHeaderComponentPartDefinition<E extends HasAnchoredTooltipProvider & HasContext & HasFeedListType & HasInvalidate & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> implements HasSpecialStyling {
    public static final ViewType<FeedHeaderComponentView> f20811c = new C08321();
    private static DefaultHeaderComponentPartDefinition f20812j;
    private static final Object f20813k = new Object();
    private final AnchoredTooltipPartDefinition<FeedComponentView> f20814d;
    private final DefaultHeaderComponent<E> f20815e;
    private final StoryHeaderUtil f20816f;
    private final FeedBackgroundStylerComponentWrapper f20817g;
    private final FeedStoryMessageFlyoutComponent f20818h;
    private final AndroidComponentsExperimentHelper f20819i;

    /* compiled from: hr_HR */
    final class C08321 extends ViewType<FeedHeaderComponentView> {
        C08321() {
        }

        public final View mo1995a(Context context) {
            return new FeedHeaderComponentView(context);
        }
    }

    private static DefaultHeaderComponentPartDefinition m28538b(InjectorLike injectorLike) {
        return new DefaultHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AnchoredTooltipPartDefinition.m28414a(injectorLike), DefaultHeaderComponent.m28547a(injectorLike), StoryHeaderUtil.m28330a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), FeedStoryMessageFlyoutComponent.m28349a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        obj = (FeedProps) obj;
        super.mo3132a(subParts, obj);
        subParts.mo2756a(this.f20814d, obj.f13444a);
    }

    public final boolean m28543a(Object obj) {
        if (BaseHeaderPartDefinition.m28398b((FeedProps) obj)) {
            AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f20819i;
            boolean z = false;
            if (androidComponentsExperimentHelper.f5898b == null) {
                androidComponentsExperimentHelper.f5898b = Boolean.valueOf(androidComponentsExperimentHelper.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5927k, false));
            }
            if (androidComponentsExperimentHelper.f5898b.booleanValue() || androidComponentsExperimentHelper.m10064s()) {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    public static DefaultHeaderComponentPartDefinition m28537a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20813k) {
                DefaultHeaderComponentPartDefinition defaultHeaderComponentPartDefinition;
                if (a2 != null) {
                    defaultHeaderComponentPartDefinition = (DefaultHeaderComponentPartDefinition) a2.mo818a(f20813k);
                } else {
                    defaultHeaderComponentPartDefinition = f20812j;
                }
                if (defaultHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28538b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20813k, b3);
                        } else {
                            f20812j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DefaultHeaderComponentPartDefinition(Context context, AnchoredTooltipPartDefinition anchoredTooltipPartDefinition, DefaultHeaderComponent defaultHeaderComponent, StoryHeaderUtil storyHeaderUtil, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, FeedStoryMessageFlyoutComponent feedStoryMessageFlyoutComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f20814d = anchoredTooltipPartDefinition;
        this.f20815e = defaultHeaderComponent;
        this.f20816f = storyHeaderUtil;
        this.f20817g = feedBackgroundStylerComponentWrapper;
        this.f20818h = feedStoryMessageFlyoutComponent;
        this.f20819i = androidComponentsExperimentHelper;
    }

    private Component<?> m28536a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        Component d = this.f20815e.m28549a(componentContext).m30657a((FeedProps) feedProps).m30656a((HasFeedListType) e).mo3296d();
        return this.f20818h.m28352a(componentContext).m30690a((FeedProps) feedProps).m30689a(StoryRenderContext.NEWSFEED).m30688a(this.f20817g.m28340b(componentContext, (HasPositionInformation) e, this.f20816f.m28334a((FeedProps) feedProps), d)).mo3296d();
    }

    public final ViewType mo2547a() {
        return f20811c;
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.HEADER;
    }
}

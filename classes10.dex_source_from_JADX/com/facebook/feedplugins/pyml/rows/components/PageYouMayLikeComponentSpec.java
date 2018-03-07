package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.components.widget.VerticalGravity;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feedplugins.images.FbFeedFrescoComponent;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.PageYouMayLikePartDefinition;
import com.facebook.feedplugins.pyml.rows.PymlHeaderPartDefinition;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition.Props;
import com.facebook.feedplugins.pyml.rows.components.PageYouMayLikeCardComponent.State;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: android.webkit.WebView */
public class PageYouMayLikeComponentSpec<E extends HasFeedListType & HasPositionInformation & HasPersistentState & HasMenuButtonProvider & HasPrefetcher & HasRowKey & HasContext & HasIsAsync> {
    private static final CallerContext f19768a = CallerContext.a(PageYouMayLikeBodyHeaderComponentSpec.class, "native_newsfeed", "cover_photo");
    private static PageYouMayLikeComponentSpec f19769j;
    private static final Object f19770k = new Object();
    private final PageYouMayLikeHeaderComponent f19771b;
    private final PageYouMayLikeBodyHeaderComponent f19772c;
    private final PageYouMayLikeCardComponent f19773d;
    public final QeAccessor f19774e;
    private final FbFeedFrescoComponent f19775f;
    public final DefaultFeedUnitRenderer f19776g;
    public final EventsStream f19777h;
    public final NewsFeedAnalyticsEventBuilder f19778i;

    private static PageYouMayLikeComponentSpec m20032b(InjectorLike injectorLike) {
        return new PageYouMayLikeComponentSpec(PageYouMayLikeHeaderComponent.m20037a(injectorLike), PageYouMayLikeBodyHeaderComponent.m19992a(injectorLike), FbFeedFrescoComponent.a(injectorLike), PageYouMayLikeCardComponent.m20005a(injectorLike), EventsStream.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static PageYouMayLikeComponentSpec m20030a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19770k) {
                PageYouMayLikeComponentSpec pageYouMayLikeComponentSpec;
                if (a2 != null) {
                    pageYouMayLikeComponentSpec = (PageYouMayLikeComponentSpec) a2.a(f19770k);
                } else {
                    pageYouMayLikeComponentSpec = f19769j;
                }
                if (pageYouMayLikeComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20032b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19770k, b3);
                        } else {
                            f19769j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageYouMayLikeComponentSpec(PageYouMayLikeHeaderComponent pageYouMayLikeHeaderComponent, PageYouMayLikeBodyHeaderComponent pageYouMayLikeBodyHeaderComponent, FbFeedFrescoComponent fbFeedFrescoComponent, PageYouMayLikeCardComponent pageYouMayLikeCardComponent, EventsStream eventsStream, DefaultFeedUnitRenderer defaultFeedUnitRenderer, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, QeAccessor qeAccessor) {
        this.f19771b = pageYouMayLikeHeaderComponent;
        this.f19772c = pageYouMayLikeBodyHeaderComponent;
        this.f19775f = fbFeedFrescoComponent;
        this.f19773d = pageYouMayLikeCardComponent;
        this.f19774e = qeAccessor;
        this.f19776g = defaultFeedUnitRenderer;
        this.f19777h = eventsStream;
        this.f19778i = newsFeedAnalyticsEventBuilder;
    }

    public final ComponentLayout m20033a(ComponentContext componentContext, E e, Props props) {
        PageYouMayLikePartDefinition.Props props2 = new PageYouMayLikePartDefinition.Props((ScrollableItemListFeedUnit) props.b.a, props.a, props.c, Integer.valueOf(props.d), props.f, Boolean.valueOf(false), PymlPagePartDefinition.a(this.f19774e, (ScrollableItemListFeedUnit) props.b.a), Boolean.valueOf(props.g));
        return Container.a(componentContext).C(0).a(m20031b(componentContext, e, props)).a(this.f19772c.m19994a(componentContext).m19989a(props2).m19988a((HasContext) e)).a(m20029a(componentContext, props2.b)).a(Container.a(componentContext).C(0).j(5, 2131428854).j(3, 2131427640).G(2130840170).o(8, 2).a(m20028a(componentContext, props, (HasFeedListType) e)).a(m20027a(componentContext, props))).b(PageYouMayLikeComponent.m20023b(componentContext)).j();
    }

    private Builder m20027a(ComponentContext componentContext, Props props) {
        State state = new State(this.f19773d);
        PageYouMayLikeCardComponent.Builder builder = (PageYouMayLikeCardComponent.Builder) PageYouMayLikeCardComponent.f19741b.a();
        if (builder == null) {
            builder = new PageYouMayLikeCardComponent.Builder();
        }
        PageYouMayLikeCardComponent.Builder.m20002a(builder, componentContext, 0, state);
        PageYouMayLikeCardComponent.Builder builder2 = builder;
        builder2.f19735a.f19739a = props;
        builder2.f19738d.set(0);
        return builder2.c();
    }

    private Builder m20028a(ComponentContext componentContext, Props props, E e) {
        FbDraweePartDefinition.Props a = PymlPagePartDefinition.a(props, false);
        int dimensionPixelOffset = componentContext.getResources().getDimensionPixelOffset(2131428854);
        FbFeedFrescoComponent.Builder b = this.f19775f.a(componentContext).a(e).a(a.a.c).a(f19768a).a(props.b).a(a.f).b(a.b);
        b.a.j = a.g;
        return b.c().j(props.d - (dimensionPixelOffset * 2)).h(5, 2).a(2);
    }

    private static Builder m20029a(ComponentContext componentContext, SuggestedPageUnitItem suggestedPageUnitItem) {
        CharSequence a = EgoUnitUtil.a(suggestedPageUnitItem);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        Text.Builder j = Text.a(componentContext).a(a).j(3);
        j.a.d = 3;
        return j.a(VerticalGravity.CENTER).l(2131362753).o(2131427402).a(TruncateAt.END).c().g(5, 2131428854).c(3, 2131427640);
    }

    private ComponentLayout m20031b(ComponentContext componentContext, E e, Props props) {
        if (!props.g) {
            return null;
        }
        PymlHeaderPartDefinition.Props props2 = new PymlHeaderPartDefinition.Props(props.a, props.b);
        PageYouMayLikeHeaderComponent pageYouMayLikeHeaderComponent = this.f19771b;
        PageYouMayLikeHeaderComponent.State state = new PageYouMayLikeHeaderComponent.State(pageYouMayLikeHeaderComponent);
        PageYouMayLikeHeaderComponent.Builder builder = (PageYouMayLikeHeaderComponent.Builder) pageYouMayLikeHeaderComponent.f19793c.a();
        if (builder == null) {
            builder = new PageYouMayLikeHeaderComponent.Builder(pageYouMayLikeHeaderComponent);
        }
        PageYouMayLikeHeaderComponent.Builder.m20034a(builder, componentContext, 0, state);
        PageYouMayLikeHeaderComponent.Builder builder2 = builder;
        builder2.f19782a.f19787a = (HasContext) e;
        builder2.f19786e.set(0);
        builder2 = builder2;
        builder2.f19782a.f19788b = props2;
        builder2.f19786e.set(1);
        return builder2.b();
    }
}

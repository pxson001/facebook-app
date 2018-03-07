package com.facebook.feedplugins.pyma.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.pyma.PYMAAnalyticsHelper;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnitItem;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collectionsViewFramer_inner_view */
public class PagesYouMayAdvertiseFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, Void, HasPositionInformation, LinearLayout> {
    public static final ViewType f8637a = ViewType.a(2130906133);
    private static PagesYouMayAdvertiseFooterPartDefinition f8638g;
    private static final Object f8639h = new Object();
    private final BackgroundPartDefinition f8640b;
    private final TextPartDefinition f8641c;
    private final ClickListenerPartDefinition f8642d;
    public final FbUriIntentHandler f8643e;
    public final PYMAAnalyticsHelper f8644f;

    private static PagesYouMayAdvertiseFooterPartDefinition m9477b(InjectorLike injectorLike) {
        return new PagesYouMayAdvertiseFooterPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), PYMAAnalyticsHelper.m9456a(injectorLike));
    }

    public final Object m9479a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        subParts.a(this.f8640b, new StylingData(feedProps, PaddingStyle.a, Position.DIVIDER_TOP));
        subParts.a(2131565756, this.f8641c, graphQLPagesYouMayAdvertiseFeedUnit.z().a());
        subParts.a(2131565757, this.f8641c, m9476a(graphQLPagesYouMayAdvertiseFeedUnit).aB());
        subParts.a(2131565757, this.f8642d, new OnClickListener(this) {
            final /* synthetic */ PagesYouMayAdvertiseFooterPartDefinition f8636b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 995754606);
                PagesYouMayAdvertiseFooterPartDefinition pagesYouMayAdvertiseFooterPartDefinition = this.f8636b;
                String aE = PagesYouMayAdvertiseFooterPartDefinition.m9476a(graphQLPagesYouMayAdvertiseFeedUnit).aE();
                if (this.f8636b.f8643e.a(view.getContext(), aE)) {
                    HoneyAnalyticsEvent honeyAnalyticsEvent;
                    PYMAAnalyticsHelper pYMAAnalyticsHelper = this.f8636b.f8644f;
                    GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = graphQLPagesYouMayAdvertiseFeedUnit;
                    ArrayNode a2 = FeedTrackableUtil.a(graphQLPagesYouMayAdvertiseFeedUnit);
                    String valueOf = String.valueOf(graphQLPagesYouMayAdvertiseFeedUnit.r());
                    if (NewsFeedAnalyticsEventBuilder.B(a2)) {
                        honeyAnalyticsEvent = null;
                    } else {
                        HoneyClientEvent b = new HoneyClientEvent("pyma_promote").a("tracking", a2).b("pyma_category", valueOf);
                        b.c = "native_newsfeed";
                        honeyAnalyticsEvent = b;
                    }
                    pYMAAnalyticsHelper.f8617b.a(honeyAnalyticsEvent);
                } else {
                    this.f8636b.f8644f.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "PYMA footer CTA click: can't handle URI: " + aE);
                }
                LogUtils.a(224412996, a);
            }
        });
        return null;
    }

    @Inject
    public PagesYouMayAdvertiseFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, PYMAAnalyticsHelper pYMAAnalyticsHelper) {
        this.f8640b = backgroundPartDefinition;
        this.f8641c = textPartDefinition;
        this.f8642d = clickListenerPartDefinition;
        this.f8643e = fbUriIntentHandler;
        this.f8644f = pYMAAnalyticsHelper;
    }

    public static PagesYouMayAdvertiseFooterPartDefinition m9475a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayAdvertiseFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8639h) {
                PagesYouMayAdvertiseFooterPartDefinition pagesYouMayAdvertiseFooterPartDefinition;
                if (a2 != null) {
                    pagesYouMayAdvertiseFooterPartDefinition = (PagesYouMayAdvertiseFooterPartDefinition) a2.a(f8639h);
                } else {
                    pagesYouMayAdvertiseFooterPartDefinition = f8638g;
                }
                if (pagesYouMayAdvertiseFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9477b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8639h, b3);
                        } else {
                            f8638g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayAdvertiseFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m9480a(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps) {
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        if (m9476a(graphQLPagesYouMayAdvertiseFeedUnit) == null) {
            this.f8644f.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "PYMA footer has NULL ActionLink");
            return false;
        } else if (graphQLPagesYouMayAdvertiseFeedUnit.z() != null) {
            return true;
        } else {
            this.f8644f.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "PYMA footer has NULL title");
            return false;
        }
    }

    @Nullable
    public static GraphQLStoryActionLink m9476a(GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit) {
        if (graphQLPagesYouMayAdvertiseFeedUnit.s().isEmpty()) {
            return null;
        }
        return ((GraphQLPagesYouMayAdvertiseFeedUnitItem) graphQLPagesYouMayAdvertiseFeedUnit.s().get(0)).a();
    }

    public final ViewType m9478a() {
        return f8637a;
    }
}
